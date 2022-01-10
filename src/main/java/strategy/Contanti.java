package strategy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import daofactory.DaoFactory;

public class Contanti implements Strategy {

    private double importo;

    public Contanti (double importo){

        this.setImporto(importo);
    }

 
    @Override
    public String payQuota(double prezzo, int idUtente) {
    	
    	String result = "Pagamento non riuscito.";
    	Connection con = DaoFactory.getDatabase().openConnection();
		String PAY_QUOTA = "UPDATE carshare.utente SET data_pagamento_quota=? WHERE id_utente=?";
		
		try {
			Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
			
			PreparedStatement ps = con.prepareStatement(PAY_QUOTA);
			ps.setDate(1, currentDate);
			ps.setInt(2, idUtente);
			ps.executeUpdate();
			con.close();
			
			result  = "Success";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        return  result;
    }


	@Override
	public String payPrenotazione(double prezzo, int idPrenotazione) {
		
		String result = "Pagamento non riuscito.";
    	Connection con = DaoFactory.getDatabase().openConnection();
		String PAY_QUOTA = "UPDATE carshare.prenotazioni SET pagato='SI' WHERE id_prenotazione=?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(PAY_QUOTA);
			ps.setInt(1, idPrenotazione);
			ps.executeUpdate();
			con.close();
			
			result  = "Success";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        return  result;
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
