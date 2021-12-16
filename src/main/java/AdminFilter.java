


import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utente.Utente;

@WebFilter("/Admin/*")
public class AdminFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 1L;


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
    	
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        
        
        if( session.getAttribute("user") != null )
        { 
        	Utente user = (Utente)session.getAttribute("user");

        	 if ( user.getRole().equals("admin") ) { // se sei loggato come admin 
                 chain.doFilter(request, response);
             } else {
             	request.setAttribute("role","ADMIN"); // se sei loggato come user
             	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/access-denied.jsp");
         		dispatcher.forward(request, response);
             }
        	
        }else { //  se non sei loggato
            response.sendRedirect( request.getContextPath() + "/Login" );

        }
        

       
    }

}
