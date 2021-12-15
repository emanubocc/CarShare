package Prenotazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import DaoFactory.DaoFactory;

public class PrenotazioneDaoImp implements PrenotazioneDao{

	@Override
	public String insert(Prenotazione reservation) {
		
		String result = "Success";
		Connection con = DaoFactory.getDatabase().openConnection();
		String INSERT_RESERVATION= "INSERT INTO carshare.prenotazione (data_inizio, data_consegna, percorrenza_effettiva, id_utente, id_parcheggio) "
				+ "VALUES (?,?,?,?,?)";
		
		try {
				PreparedStatement ps = con.prepareStatement(INSERT_RESERVATION);
				ps.setDate(1, reservation.getData_inizio());
				ps.setDate(2, reservation.getData_consegna());
				ps.setFloat(3, reservation.getPercorrenza_effettiva());
				ps.setInt(4, reservation.getId_utente());
				ps.setInt(5, reservation.getId_parcheggio());
				
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
		return null;
	}

	@Override
	public float calculatePrice() {
		return 0;
	}

	@Override
	public String deleteReservation(int idReservation) {
		return null;
	}

}
