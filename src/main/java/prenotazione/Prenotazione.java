package prenotazione;

import java.sql.Date;

public class Prenotazione {


	public Prenotazione(int id_prenotazione, Date data_inizio, Date data_consegna, float percorrenza_effettiva,
			int id_utente, int id_parcheggio, String luogo, float tariffa) {
		super();
		this.id_prenotazione = id_prenotazione;
		this.data_inizio = data_inizio;
		this.data_consegna = data_consegna;
		this.percorrenza_effettiva = percorrenza_effettiva;
		this.id_utente = id_utente;
		this.id_parcheggio = id_parcheggio;
		this.luogo = luogo;
		this.tariffa = tariffa;
	}

	private int id_prenotazione;
	private Date data_inizio;
	private Date data_consegna;
	private float percorrenza_effettiva;
	private int id_utente;
	private int id_parcheggio;
	private String luogo;
	private float tariffa;

	
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
	/**
	 * @return the luogo
	 */
	public String getLuogo() {
		return luogo;
	}
	/**
	 * @param luogo the luogo to set
	 */
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	/**
	 * @return the tariffa
	 */
	public float getTariffa() {
		return tariffa;
	}
	/**
	 * @param tariffa the tariffa to set
	 */
	public void setTariffa(float tariffa) {
		this.tariffa = tariffa;
	}
	
}
