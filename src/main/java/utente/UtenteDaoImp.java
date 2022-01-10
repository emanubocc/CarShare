package utente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import daofactory.DaoFactory;

import java.util.ArrayList;

public class UtenteDaoImp implements UtenteDao{
	
	@Override
	public String insert(Utente user)
	{
		String result = "Success";
		Connection con = DaoFactory.getDatabase().openConnection();
		String INSERT_USER = "INSERT INTO carshare.utente (nome,cognome,email,tel,password,role,data_pagamento_quota) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(INSERT_USER);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCognome());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getRole());
			ps.setDate(7, user.getData_pagamento());
			ps.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			result = e.getMessage();
		}
		
		return result;
	}
	
	@Override
	public boolean deleteUser(int id) {
		
		int rowDeleted = 0;
		String DELETE_USERS_SQL = "DELETE FROM utente WHERE id_utente = ?";
		Connection con = DaoFactory.getDatabase().openConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_USERS_SQL);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate();		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	    if (rowDeleted <= 0) 
	    	return false;
	    return true;
	}

	@Override
	public List<Utente> selectAllUsers() {
		
		List<Utente> users = new ArrayList<>();
		
		Connection con = DaoFactory.getDatabase().openConnection();
		String SELECT_ALL_USERS = "SELECT id_utente,nome,cognome,email,tel,data_pagamento_quota FROM carshare.utente WHERE utente.role = 'user'";
	
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				int id = rs.getInt("id_utente");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				Date data_pagamento = rs.getDate("data_pagamento_quota");
				users.add(new Utente(id, nome, cognome, email, tel, null, "user", data_pagamento));
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public Utente validate(String email, String pass) {

		Connection con = DaoFactory.getDatabase().openConnection();
		String VALIDATE_USER = "SELECT * FROM carshare.utente WHERE utente.email = ? AND utente.password = ?";
		boolean status = false;

		try {
			PreparedStatement ps = con.prepareStatement(VALIDATE_USER);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();  
			
			if(status)
			{
				int id = rs.getInt("id_utente");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String tel = rs.getString("tel");
				String role = rs.getString("role");
				Date data_pagamento = rs.getDate("data_pagamento_quota");
			
				Utente user = new Utente( id, nome, cognome, email , tel, null, role, data_pagamento);
				con.close();
				return user;
			}
	
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Date updateDate(int idUtente) {

		Connection con = DaoFactory.getDatabase().openConnection();
		String SHOW_DATE = "SELECT data_pagamento_quota FROM carshare.utente WHERE id_utente=?";
		

		try {
			PreparedStatement ps = con.prepareStatement(SHOW_DATE);
			ps.setInt(1, idUtente);

			ResultSet rs = ps.executeQuery();
			rs.next();

			Date data_pagamento = rs.getDate("data_pagamento_quota");

			con.close();
			return data_pagamento;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
