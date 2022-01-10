package strategy;

public interface Strategy {

    public String payQuota(double prezzo, int idUtente);
    public String payPrenotazione(double prezzo, int idPrenotazione);

}
