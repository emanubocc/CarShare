package utente;

import java.sql.Date;

public class Utente {
	
	public Utente() {
		super();
	}
	
	public Utente(int id, String nome, String cognome, String email,String tel, String password, String role, Date data_pagamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.role = role;
		this.data_pagamento = data_pagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the data_pagamento
	 */
	public Date getData_pagamento() {
		return data_pagamento;
	}

	/**
	 * @param data_pagamento the data_pagamento to set
	 */
	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int id;
	private String role;
	private String tel;
	private Date data_pagamento;
	
		
}
