

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.Utente;
import utente.UtenteDaoImp;

@WebServlet("/Registrazione")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrazioneServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/registrazione.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome, cognome, email, password, tel  = "";
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		email = request.getParameter("email");
		tel = request.getParameter("tel");
		password = request.getParameter("password");
		
		Utente user = new Utente( 0, nome,cognome, email, tel, password, "user", null);
		
		UtenteDaoImp newUser = new UtenteDaoImp();
		String result = newUser.insert(user);
		
		request.setAttribute("resultLogin", result);
		request.getRequestDispatcher("WEB-INF/registrazione.jsp").forward(request, response);
	}

}
