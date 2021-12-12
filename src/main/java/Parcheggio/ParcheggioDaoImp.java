package Parcheggio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DaoFactory.DaoFactory;

public class ParcheggioDaoImp implements ParcheggioDao {

	@Override
	public String insert(Parcheggio park) {
		
			String result = "Success";
			Connection con = DaoFactory.getDatabase().openConnection();
			String INSERT_PARK = "INSERT INTO carshare.parcheggio (luogo) VALUES (?)";
			
			try {
					PreparedStatement ps = con.prepareStatement(INSERT_PARK);
					ps.setString(1, park.getLuogo());
					ps.executeUpdate();
					con.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = e.getMessage();
				}

			return result;
	}
	

	@Override
	public String deletePark(int idPark) {
		
		String result = "Success";
		String DELETE_PARK_SQL = "DELETE FROM parcheggio WHERE id_parcheggio = ?";
		Connection con = DaoFactory.getDatabase().openConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_PARK_SQL);
			ps.setInt(1, idPark);
			ps.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if( e.getErrorCode() == 1451 )
			{
				result = "Il parcheggio deve essere svuotato prima di poter essere eliminato";
				return result;
			}
			else {
				result = e.getMessage();
				return result;
			}
		}

	    return result;
	}

	@Override
	public List<Parcheggio> selectAllParks() {
		
		List<Parcheggio> parks = new ArrayList<>();
		
		Connection con = DaoFactory.getDatabase().openConnection();
		String SELECT_ALL_PARKS = "SELECT parcheggio.id_parcheggio, parcheggio.luogo FROM carshare.parcheggio ";
	
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_PARKS);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				int park_id = rs.getInt("id_parcheggio");
				String luogo = rs.getString("luogo");
				parks.add(new Parcheggio(park_id, luogo));
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parks;
	}
	

}
