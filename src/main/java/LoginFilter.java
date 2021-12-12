

import java.io.IOException;

import Utente.Utente;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/Admin/*")
public class LoginFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 1L;


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
    	
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/Login";
        
        boolean loggedIn = false;
        
        if( session.getAttribute("user") != null )
        {
        	Utente user = (Utente)session.getAttribute("user");
            loggedIn =  user.getRole().equals("admin");
        }

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

}
