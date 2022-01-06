package prenotazione;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daofactory.DaoFactory;
import parcheggio.ParcheggioDaoImp;
import automobile.AutomobileDaoImp;

public class PrenotazioneDaoImp implements PrenotazioneDao {

	@Override
	public String insert(Prenotazione reservation) {

		String result = "Success";
		AutomobileDaoImp CarDao = new AutomobileDaoImp();
		String targa = CarDao.trovaAuto(reservation.getId_parcheggio());
		if( targa.equals("no_cars") )
		{
			result = "Nessuna auto disponibile";
			return result;
		}
		Connection con = DaoFactory.getDatabase().openConnection();
		String INSERT_RESERVATION = "INSERT INTO carshare.prenotazioni (data_inizio, data_consegna, percorrenza_effettiva, id_utente, id_parcheggio, stato, tariffa, pagato, auto_consegnata, targa) "
				+ "VALUES (?,?,?,?,?,'Prenotato', ?, 'NO', 'NO', ? )";
		
		
		try {
						
			PreparedStatement ps = con.prepareStatement(INSERT_RESERVATION);
			
			ps.setDate(1, reservation.getData_inizio());
			ps.setDate(2, reservation.getData_consegna());
			ps.setFloat(3, reservation.getPercorrenza_effettiva());
			ps.setInt(4, reservation.getId_utente());
			ps.setInt(5, reservation.getId_parcheggio());
			ps.setFloat(6, calculatePrice(reservation.getPercorrenza_effettiva(), reservation.getData_inizio(),
					reservation.getData_consegna()));
			ps.setString(7, targa);
			

			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
		}

		return result;
	}


	@Override
	public List<Prenotazione> selectParkReservation(int idPark) {

		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		List<Prenotazione> resList = new ArrayList<>();
		Connection con = DaoFactory.getDatabase().openConnection();
		String SELECT_RESERVATION = "SELECT * FROM carshare.prenotazioni WHERE id_parcheggio = ? ORDER BY id_prenotazione ASC";

		try {

			PreparedStatement ps = con.prepareStatement(SELECT_RESERVATION);
			ps.setInt(1, idPark);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id_prenotazione = rs.getInt("id_prenotazione");
				Date data_inizio = rs.getDate("data_inizio");
				Date data_consegna = rs.getDate("data_consegna");
				float percorrenza_effettiva = rs.getFloat("percorrenza_effettiva");
				int id_utente = rs.getInt("id_utente");
				int id_parcheggio = rs.getInt("id_parcheggio");
				String luogo = ParkDao.getLuogo(id_parcheggio);
				String stato = rs.getString("stato");
				float tariffa = rs.getFloat("tariffa");
				String pagato = rs.getString("pagato");
				String autoConsegnata = rs.getString("auto_consegnata");
				String targa = rs.getString("targa");

				resList.add(new Prenotazione(id_prenotazione, data_inizio, data_consegna, percorrenza_effettiva,
						id_utente, id_parcheggio, luogo, tariffa, stato, pagato, autoConsegnata, targa));
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resList;
	}

	@Override
	public List<Prenotazione> selectAllReservation(int idUser) {

		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();

		List<Prenotazione> resList = new ArrayList<>();

		Connection con = DaoFactory.getDatabase().openConnection();
		String SELECT_RESERVATION = "SELECT * FROM carshare.prenotazioni WHERE id_utente = ?";

		try {

			PreparedStatement ps = con.prepareStatement(SELECT_RESERVATION);
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id_prenotazione = rs.getInt("id_prenotazione");
				Date data_inizio = rs.getDate("data_inizio");
				Date data_consegna = rs.getDate("data_consegna");
				float percorrenza_effettiva = rs.getFloat("percorrenza_effettiva");
				int id_utente = rs.getInt("id_utente");
				int id_parcheggio = rs.getInt("id_parcheggio");
				String luogo = ParkDao.getLuogo(id_parcheggio);
				String stato = rs.getString("stato");
				float tariffa = rs.getFloat("tariffa");
				String pagato = rs.getString("pagato");
				String autoConsegnata = rs.getString("auto_consegnata");
				String targa = rs.getString("targa");

				resList.add(new Prenotazione(id_prenotazione, data_inizio, data_consegna, percorrenza_effettiva,
						id_utente, id_parcheggio, luogo, tariffa, stato, pagato, autoConsegnata, targa));
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resList;
	}

	@Override
	public float calculatePrice(float percorrenza_effettiva, Date data_inizio, Date data_consegna) {

		float diffTime = data_consegna.getTime() - data_inizio.getTime();
		int diffDays = (int) (diffTime / (1000 * 60 * 60 * 24));
		int TARIFFA_GIORNALIERA = 50;

		float totale = (float) ((diffDays * TARIFFA_GIORNALIERA) + (percorrenza_effettiva * 0.75));

		return totale;
	}

	@Override
	public boolean deleteReservation(int idReservation) {
		
		int rowDeleted = 0;
		String DELETE_RESERVATION_SQL = "DELETE FROM prenotazioni WHERE id_prenotazione = ?";
		Connection con = DaoFactory.getDatabase().openConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_RESERVATION_SQL);
			ps.setInt(1, idReservation);
			rowDeleted = ps.executeUpdate();		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	    if (rowDeleted <= 0) 
	    	return false;
	    return true;
	}

	@Override
	public void updateStatoPrenotazioni(int id_utente) {

		Connection con = DaoFactory.getDatabase().openConnection();
		String SELECT_RESERVATION = "SELECT id_prenotazione,data_consegna,stato,pagato,auto_consegnata FROM carshare.prenotazioni WHERE id_utente = ?";

		try {

			PreparedStatement ps = con.prepareStatement(SELECT_RESERVATION);
			ps.setInt(1, id_utente);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id_prenotazione = rs.getInt("id_prenotazione");
				Date data_consegna = rs.getDate("data_consegna");
				String stato = rs.getString("stato");
				String pagato = rs.getString("pagato");
				String autoConsegnata = rs.getString("auto_consegnata");

				checkStato(id_prenotazione, data_consegna, stato, pagato, autoConsegnata);
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void checkStato(int idRes, Date dataConsegna, String stato, String pagato, String autoConsegnata) {

		long millis = System.currentTimeMillis();
		Date currentDate = new java.sql.Date(millis);

		float diffTime = dataConsegna.getTime() - currentDate.getTime();
		int diffDays = (int) (diffTime / (1000 * 60 * 60 * 24));

		if (autoConsegnata.equals("SI") && pagato.equals("SI")) {
			changeStato(idRes, "Completato");
		}

		if (autoConsegnata.equals("NO") && pagato.equals("SI")) {
			changeStato(idRes, "Da consegnare");
		} else if (pagato.equals("NO") && autoConsegnata.equals("SI")) {
			changeStato(idRes, "Da pagare");
		} else if ((pagato.equals("NO") || autoConsegnata.equals("NO")) && (diffDays < 0)) {
			changeStato(idRes, "Scaduto");
		}
	}

	public void changeStato(int idRes, String newStato) {
		Connection con = DaoFactory.getDatabase().openConnection();
		String UPDATE_STATE = "UPDATE carshare.prenotazioni SET stato=? WHERE id_prenotazione=?";

		try {

			PreparedStatement ps = con.prepareStatement(UPDATE_STATE);
			ps.setString(1, newStato);
			ps.setInt(2, idRes);
			ps.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changePaid(int idRes) {
		Connection con = DaoFactory.getDatabase().openConnection();
		String UPDATE_PAID = "UPDATE carshare.prenotazioni SET pagato='SI' WHERE id_prenotazione=?";

		try {

			PreparedStatement ps = con.prepareStatement(UPDATE_PAID);
			ps.setInt(1, idRes);
			ps.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeConsegna(int idRes) {
		Connection con = DaoFactory.getDatabase().openConnection();
		String UPDATE_CONSEGNA = "UPDATE carshare.prenotazioni SET auto_consegnata='SI' WHERE id_prenotazione=?";

		try {

			PreparedStatement ps = con.prepareStatement(UPDATE_CONSEGNA);
			ps.setInt(1, idRes);
			ps.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
