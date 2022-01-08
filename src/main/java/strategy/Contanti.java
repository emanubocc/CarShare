package strategy;

public class Contanti implements Strategy {

    private double importo;

    public Contanti (double importo){

        this.setImporto(importo);
    }

    @Override
    public String pay(double prezzo) {
    	  String result  = prezzo + " pagato in contanti.";
          return  result;
    }

	
	public double getImporto() {
		return importo;
	}

	
	public void setImporto(double importo) {
		this.importo = importo;
	}
}
