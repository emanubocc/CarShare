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


public class PrenotazioneDaoImp implements PrenotazioneDao{

	@Override
	public String insert(Prenotazione reservation) {
		
		String result = "Success";
		Connection con = DaoFactory.getDatabase().openConnection();
		String INSERT_RESERVATION= "INSERT INTO carshare.prenotazione (data_inizio, data_consegna, percorrenza_effettiva, id_utente, id_parcheggio) "
				+ "VALUES (?,?,?,?,?,'Prenotato', ?, 'NO' )";
		
		try {
				PreparedStatement ps = con.prepareStatement(INSERT_RESERVATION);
				ps.setDate(1, reservation.getData_inizio());
				ps.setDate(2, reservation.getData_consegna());
				ps.setFloat(3, reservation.getPercorrenza_effettiva());
				ps.setInt(4, reservation.getId_utente());
				ps.setInt(5, reservation.getId_parcheggio());
				ps.setFloat(6,  calculatePrice( reservation.getPercorrenza_effettiva(),
						reservation.getData_consegna(), reservation.getData_consegna() ) );
				
				 
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
	public List<Prenotazione> selectAllReservation(int idUser) {
		
		ParcheggioDaoImp ParkDao = new ParcheggioDaoImp();
		
		List<Prenotazione> resList = new ArrayList<>();
		
		Connection con = DaoFactory.getDatabase().openConnection();
		String SELECT_RESERVATION = "SELECT * FROM carshare.prenotazioni WHERE id_utente = ?";
	
		try {
			
			PreparedStatement ps = con.prepareStatement(SELECT_RESERVATION);
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				int id_prenotazione = rs.getInt("id_prenotazione");
				Date data_inizio = rs.getDate("data_inizio");
				Date data_consegna = rs.getDate("data_consegna");
				float percorrenza_effettiva = rs.getFloat("percorrenza_effettiva");
				int id_utente = rs.getInt("id_utente");
				int id_parcheggio = rs.getInt("id_parcheggio");
				String luogo = ParkDao.getLuogo( id_parcheggio );
				String stato = rs.getString("stato");
				
				//float tariffa = rs.getFloat("tariffa");
				float tariffa = calculatePrice(percorrenza_effettiva, data_inizio, data_consegna);
				
				String pagato = rs.getString("pagato");
				String autoConsegnata = rs.getString("auto_consegnata");
			
				resList.add(new Prenotazione( id_prenotazione,  data_inizio,  data_consegna,  percorrenza_effettiva,
						 id_utente,  id_parcheggio, luogo, tariffa, stato, pagato, autoConsegnata));
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resList;
	}

	@Override
	public float calculatePrice(float percorrenza_effettiva, Date data_inizio, Date data_consegna ) {

		float diffTime =  data_consegna.getTime() - data_inizio.getTime();
		float diffDays = (diffTime / (1000 * 60 * 60 * 24));
		int TARIFFA_GIORNALIERA = 50;
		
		float totale = (float) ((diffDays*TARIFFA_GIORNALIERA) + (percorrenza_effettiva*0.75 ));
		
		return totale;
	}

	@Override
	public String deleteReservation(int idReservation) {
		return null;
	}

	@Override
	public String checkStatoPrenotazione(Prenotazione res) {

		String esci ="ciao";
		return esci;
				
	}
	


}
