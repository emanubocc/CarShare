


import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("prenota".equals(action)) { 
			showFormReservation(request, response); 
		}
		else {
			showProfile(request,response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String selectForm = request.getParameter("hidden");
		
		if("prenotazione".equals(selectForm)) { 
		
			HttpSession session = request.getSession(false);
			Utente user = (Utente)session.getAttribute("user");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
			String dataInizio = request.getParameter("data_inizio"); 
			String dataConsegna = request.getParameter("data_consegna"); 
			float percorrenza = Float.parseFloat(request.getParameter("percorrenza"));
			int id_parcheggio = Integer.parseInt(request.getParameter("park"));
			
		    java.util.Date dataInizioUtil = null;
		    java.util.Date dataConsegnaUtil = null;
		    
			try {
				dataInizioUtil = sdf.parse(dataInizio);
				dataConsegnaUtil = sdf.parse(dataConsegna);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    Date data_inizio = new Date(dataInizioUtil.getTime());
		    Date data_consegna = new Date(dataConsegnaUtil.getTime());
			
			Prenotazione reservation = new Prenotazione(0,data_inizio,data_consegna,percorrenza,
					user.getId(), id_parcheggio, "", 0, "","" ,"");
			
			PrenotazioneDaoImp newReservation = new PrenotazioneDaoImp();
			String result = newReservation.insert(reservation);
			request.setAttribute("result", result);
			
			showProfile(request,response);
		}
		else if("paid".equals(selectForm)) 
		{
		
			int idPrenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));

			PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
			resDao.changePaid(idPrenotazione);
			showProfile(request, response);
		}
		else if("consegna".equals(selectForm)) 
		{
		
			int idPrenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));

			PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
			resDao.changeConsegna(idPrenotazione);
			showProfile(request, response);
		}
		
	}

	private void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Utente user = (Utente)session.getAttribute("user");
		
		PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
		resDao.updateStatoPrenotazioni(user.getId());
		
		List<Prenotazione> resList = resDao.selectAllReservation(user.getId());
		request.setAttribute("resList", resList);
		
		request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);
		
	}


	private void showFormReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		List<Parcheggio> ParkList = ParkDao.selectAllParks();
		request.setAttribute("ParkList", ParkList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/prenotazione.jsp");
		dispatcher.forward(request, response);
	}

}
