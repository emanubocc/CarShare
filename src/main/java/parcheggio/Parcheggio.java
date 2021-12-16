package parcheggio;

public class Parcheggio {

	private int id_parcheggio;
	public Parcheggio(int idPark, String luogo) {
		super();
		this.id_parcheggio = idPark;
		this.luogo = luogo;
	}
	public int getId_parcheggio() {
		return id_parcheggio;
	}
	public void setId_parcheggio(int id_parcheggio) {
		this.id_parcheggio = id_parcheggio;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	private String luogo;
	
}
