package automobile;

public class Automobile {
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getIdPark() {
		return idPark;
	}
	public void setIdPark(int idPark) {
		this.idPark = idPark;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public Automobile(String targa, String modello, String imgUrl, int idPark, String luogo) {
		super();
		this.targa = targa;
		this.modello = modello;
		this.imgUrl = imgUrl;
		this.idPark = idPark;
		this.luogo = luogo;
	}

	private String targa;
	private String modello;
	private String imgUrl;
	private int idPark;
	private String luogo;
}
