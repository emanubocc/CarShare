

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import parcheggio.Parcheggio;
import parcheggio.ParcheggioDaoImp;
import prenotazione.Prenotazione;
import prenotazione.PrenotazioneDaoImp;
import utente.Utente;
import utente.UtenteDaoImp;

import java.util.List;

import automobile.Automobile;
import automobile.AutomobileDaoImp;



@MultipartConfig
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action = request.getParameter("action");
		
		if("aggiungiAuto".equals(action)) { 
			showNewForm(request, response); 
		}
		else if("vediUtenti".equals(action)) {
			showUserList(request,response);
		}
		else if("aggiungiParcheggio".equals(action)) {
			showNewFormPark(request,response);
		}
		else if("deletePark".equals(action)) {
			deletePark(request,response);
		}
		else if("deleteCar".equals(action)) {
			deleteCar(request,response);
		}
		else if("moveCar".equals(action)) {
			moveCar(request,response);
		}
		else {
			showAdminPage(request,response);
		}
		
				
	}


	private void moveCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		List<Parcheggio> ParkList = ParkDao.selectAllParks();
		request.setAttribute("ParkList", ParkList);
		String targaMovedCar = request.getParameter("Targa");
		request.setAttribute("targaMovedCar", targaMovedCar);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/move-car.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String targa = request.getParameter("Targa");
		AutomobileDaoImp CarDao = new AutomobileDaoImp();
		String result = CarDao.deleteCar(targa);
		request.setAttribute("result", result);
		showAdminPage(request,response);
		
	}

	private void deletePark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPark =  Integer.parseInt(request.getParameter("idPark"));
		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		String result = ParkDao.deletePark(idPark);
		request.setAttribute("result", result);
		
		showAdminPage(request,response);
		
	}

	private void showNewFormPark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/add-park.jsp");
		dispatcher.forward(request, response);
	}

	private void showUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	 	UtenteDaoImp UserDao = new UtenteDaoImp();
		List<Utente> listUser = UserDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		
		if ( request.getParameter("View") != null )
		{
			int idView = Integer.parseInt(request.getParameter("View"));
			PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
			List<Prenotazione> resList = resDao.selectAllReservation(idView);
			request.setAttribute("resList", resList);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin-users.jsp");
		dispatcher.forward(request, response);
		
	}

	private void showAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AutomobileDaoImp AutoDao = new AutomobileDaoImp();
		List<Automobile> CarList = AutoDao.selectAllCars();
		request.setAttribute("CarList", CarList);
		
		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		List<Parcheggio> ParkList = ParkDao.selectAllParks();
		request.setAttribute("ParkList", ParkList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
		dispatcher.forward(request, response);
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		List<Parcheggio> ParkList = ParkDao.selectAllParks();
		request.setAttribute("ParkList", ParkList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/add-car.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String selectForm = request.getParameter("hidden");
			
			if("auto".equals(selectForm)) { 
				
				String targa, modello, imgUrl  = "";
				int park;
				
				targa = request.getParameter("targa");
				modello = request.getParameter("modello");
				imgUrl = request.getParameter("imgUrl");
				park = Integer.parseInt(request.getParameter("park"));

				Automobile car = new Automobile(targa, modello, imgUrl, park, null);
				AutomobileDaoImp newCar = new AutomobileDaoImp();
				String result = newCar.insert(car);
				request.setAttribute("result", result);
				
				showNewForm(request, response); 
				
			}
			else if("park".equals(selectForm)) {

				String luogo = "";
				luogo = request.getParameter("luogo");
				Parcheggio park = new Parcheggio(0, luogo);
				ParcheggioDaoImp newPark = new ParcheggioDaoImp();
				String result = newPark.insert(park);
				request.setAttribute("result", result);
				showNewFormPark(request,response);
				
				
			}
			else if("moveCar".equals(selectForm)) {

				String targa = "";
				int parkId;
				targa = request.getParameter("targaMovedCar");
				parkId = Integer.parseInt(request.getParameter("park"));
				
				AutomobileDaoImp newCar = new AutomobileDaoImp();
				String result = newCar.moveCar(targa, parkId);
				request.setAttribute("result", result);
				moveCar(request,response);
			}
			else if("conferma".equals(selectForm)) {
				
					
					int idPrenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));

					PrenotazioneDaoImp resDao = new PrenotazioneDaoImp();
					resDao.changeStato(idPrenotazione, "Erogato");
					showUserList(request, response);
			}
				
	}
			
}
