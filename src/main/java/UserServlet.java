
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import parcheggio.Parcheggio;
import parcheggio.ParcheggioDaoImp;
import prenotazione.Prenotazione;
import prenotazione.PrenotazioneDaoImp;
import utente.Utente;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
	}

	/*---- DO GET ----*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("prenota".equals(action)) {
			showFormReservation(request, response);
		} 
		else if ("pagaQuota".equals(action)){
			showPaymentMethods(request, response);
		}
		else {
			showProfile(request, response);
		}

	}

	private void showPaymentMethods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/payment.jsp").forward(request, response);
		
	}

	/*---- DO POST ----*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String selectForm = request.getParameter("hidden");

		if ("prenotazione".equals(selectForm)) {

			HttpSession session = request.getSession(false);
			Utente user = (Utente) session.getAttribute("user");

			String dataInizio = request.getParameter("data_inizio");
			String dataConsegna = request.getParameter("data_consegna");
			float percorrenza = Float.parseFloat(request.getParameter("percorrenza"));
			int id_parcheggio = Integer.parseInt(request.getParameter("park"));

			Date data_inizio = toSqlDate(dataInizio);
			Date data_consegna = toSqlDate(dataConsegna);

			Prenotazione reservation = new Prenotazione(0, data_inizio, data_consegna, percorrenza, user.getId(),
					id_parcheggio, "Prenotato", 0, "NO", "NO", "", "");

			PrenotazioneDaoImp newReservation = new PrenotazioneDaoImp();
			String result = newReservation.insert(reservation);
			request.setAttribute("result", result);

			showProfile(request, response);
		} else if ("paid".equals(selectForm)) {

			int idPrenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));

			PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
			resDao.changePaid(idPrenotazione);
			showProfile(request, response);
		} else if ("consegna".equals(selectForm)) {

			int idPrenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));

			PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
			resDao.changeConsegna(idPrenotazione);
			showProfile(request, response);
		}

	}

	private void showProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Utente user = (Utente) session.getAttribute("user");

		PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
		resDao.updateStatoPrenotazioni(user.getId());

		List<Prenotazione> resList = resDao.selectAllReservation(user.getId());
		request.setAttribute("resList", resList);
		
		String DaPagare;
		DaPagare = checkPagamentoQuotaAnnuale(user.getData_pagamento());
		request.setAttribute("DaPagare", DaPagare);
		
		request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);

	}

	private void showFormReservation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession session = request.getSession(false);
		Utente user = (Utente) session.getAttribute("user");
		
		if( checkPagamentoQuotaAnnuale(user.getData_pagamento()).equals("Da_pagare"))
		{
			String result = "È necessario pagare la quota annuale per effetturare una prenotazione";
			request.setAttribute("result", result);
			showProfile(request, response);
		}
		
		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		List<Parcheggio> ParkList = ParkDao.selectAllParks();
		request.setAttribute("ParkList", ParkList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/prenotazione.jsp");
		dispatcher.forward(request, response);
	}

	public String checkPagamentoQuotaAnnuale(Date lastPayment) {
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		
		float diffTime = currentDate.getTime() - lastPayment.getTime();
		int diffDays = (int) (diffTime / (1000 * 60 * 60 * 24));
		
		if(diffDays > 365 )
			return "Da_pagare";
		else
			return "Pagato";
	}

	private Date toSqlDate(String dataString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dataUtil = null;

		try {
			dataUtil = sdf.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dataSql = new Date(dataUtil.getTime());

		return dataSql;
	}
}
