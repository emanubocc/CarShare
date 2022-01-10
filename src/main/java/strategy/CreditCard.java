package strategy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import daofactory.DaoFactory;

public class CreditCard implements Strategy {
	
	private String fullName;
    private long cardNumber;
    private int cvv;
    private String dateOfExpiry;


    public CreditCard(String fullName, long cardNumber, int cvv, String dateOfExpiry) {
        this.setFullName(fullName);
        this.setCardNumber(cardNumber);
        this.setCvv(cvv);
        this.setDateOfExpiry(dateOfExpiry);

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
		// TODO Auto-generated method stub
		return null;
	}

    

    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}


}
