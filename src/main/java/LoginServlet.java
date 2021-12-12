
import java.io.IOException;
import Utente.Utente;
import Utente.UtenteDaoImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
 	
	 	UtenteDaoImp UserDao = new UtenteDaoImp();
		Utente user =  UserDao.validate(email, password);
		
	 	if( user != null ){
	 		 
	 	     HttpSession session = request.getSession(true);	    
	 	     session.setAttribute("user", user);
	 		 request.setAttribute("resultLogin", "Success");
             
	 		 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
			 dispatcher.forward(request, response);
			
	 	}else{
	 		request.setAttribute("resultLogin","Email o password non corretti.");
	 		doGet(request, response);
	 	}
		 
		
	}

}
