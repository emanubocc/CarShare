package Prenotazione;

import java.util.List;


public interface PrenotazioneDao {
	
    public String insert(Prenotazione reservation);
    public List<Prenotazione> selectAllReservation(int idUser);
    public float calculatePrice();
    public String deleteReservation(int idReservation);
    
}
