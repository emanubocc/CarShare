package Prenotazione;

import java.sql.Date;

public class Prenotazione {

	private int id_prenotazione;
	private Date data_inizio;
	private Date data_consegna;
	private float percorrenza_effettiva;
	private int id_utente;
	private int id_parcheggio;

	
	public int getId_prenotazione() {
		return id_prenotazione;
	}
	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}
	
	public float getPercorrenza_effettiva() {
		return percorrenza_effettiva;
	}
	public void setPercorrenza_effettiva(float percorrenza_effettiva) {
		this.percorrenza_effettiva = percorrenza_effettiva;
	}
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	public int getId_parcheggio() {
		return id_parcheggio;
	}
	public void setId_parcheggio(int id_parcheggio) {
		this.id_parcheggio = id_parcheggio;
	}
	public Date getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}
	public Date getData_consegna() {
		return data_consegna;
	}
	public void setData_consegna(Date data_consegna) {
		this.data_consegna = data_consegna;
	}
	
}
