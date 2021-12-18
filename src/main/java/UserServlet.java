


import java.io.IOException;
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

		doGet(request, response);
		
	}


	private void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Utente user = (Utente)session.getAttribute("user");
		
		PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
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
