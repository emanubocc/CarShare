package strategy;

public class Contanti implements Strategy {

    private double importo;

    public Contanti (double importo){

        this.setImporto(importo);
    }

 
	@Override
    public String payQuota(double prezzo, int idUtente) {
    	  String result  = prezzo + " pagato in contanti.";
          return  result;
    }


	@Override
	public String payPrenotazione(double prezzo, int idPrenotazione) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @return the importo
	 */
	public double getImporto() {
		return importo;
	}


	/**
	 * @param importo the importo to set
	 */
	public void setImporto(double importo) {
		this.importo = importo;
	}

	
}
