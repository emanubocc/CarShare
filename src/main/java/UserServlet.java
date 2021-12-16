


import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import prenotazione.Prenotazione;
import prenotazione.PrenotazioneDaoImp;
import utente.Utente;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public UserServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Utente user = (Utente)session.getAttribute("user");
		
		PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
		List<Prenotazione> resList = resDao.selectAllReservation(user.getId());
		request.setAttribute("resList", resList);
		
		
		request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
