


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Logout() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("user");
	 		request.setAttribute("resultLogin","Logout");

		}
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
}