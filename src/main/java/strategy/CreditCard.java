package strategy;

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
    public String pay(double prezzo) {
        String result  = prezzo + " pagato con Carta di Credito.";
        return  result;
    }

    
    
	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
