package prenotazione;

import java.sql.Date;
import java.util.List;


public interface PrenotazioneDao {
	
    public String insert(Prenotazione reservation);
    public List<Prenotazione> selectAllReservation(int idUser);
    public List<Prenotazione> selectParkReservation(int idPark);
    public float calculatePrice(float percorrenza_effettiva, Date data_inizio, Date data_consegna );
    public boolean deleteReservation(int idReservation);
	void updateStatoPrenotazioni(int id_utente);
}
