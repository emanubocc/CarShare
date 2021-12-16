package automobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import daofactory.DaoFactory;

import java.util.ArrayList;
//import java.util.List;

public class AutomobileDaoImp implements AutomobileDao{

	@Override
	public String insert(Automobile car) {
	{
			String result = "Success";
			Connection con = DaoFactory.getDatabase().openConnection();
			String INSERT_CAR = "INSERT INTO carshare.automobile (targa, modello ,imgUrl, id_park) VALUES (?,?,?,?)";
			
			try {
					PreparedStatement ps = con.prepareStatement(INSERT_CAR);
					ps.setString(1, car.getTarga());
					ps.setString(2, car.getModello());
					ps.setString(3, car.getImgUrl());
					ps.setInt(4, car.getIdPark());
					
					ps.executeUpdate();
					con.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = e.getMessage();
				}

			return result;
		}
	}

	@Override
	public String deleteCar(String targa) {
		
		String result = "Success";
		String DELETE_CARS_SQL = "DELETE FROM automobile WHERE targa = ?";
		Connection con = DaoFactory.getDatabase().openConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_CARS_SQL);
			ps.setString(1, targa);
			ps.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
			return result;
		}

	    return result;
	}
	
	@Override
	public String moveCar(String targa, int id_parcheggio) {
		
		
		String result = "Success";
		String MOVE_CAR_SQL = "UPDATE carshare.automobile SET id_park = ? WHERE  targa = ?"; 
		Connection con = DaoFactory.getDatabase().openConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(MOVE_CAR_SQL);
			ps.setInt(1, id_parcheggio);
			ps.setString(2, targa);
			ps.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
			return result;
		}

	    return result;
		
	}

	@Override
	public List<Automobile> selectAllCars() {
		
		List<Automobile> cars = new ArrayList<>();
		
		Connection con = DaoFactory.getDatabase().openConnection();
		String SELECT_ALL_CARS = "SELECT automobile.targa,automobile.modello,automobile.imgUrl,automobile.id_park,parcheggio.luogo  FROM carshare.automobile \r\n"
				+ "INNER JOIN parcheggio ON automobile.id_park = parcheggio.id_parcheggio";
	
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_CARS);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				String targa = rs.getString("targa");
				String modello = rs.getString("modello");
				String imgUrl = rs.getString("imgUrl");
				int park_id = rs.getInt("id_park");
				String luogo = rs.getString("luogo");
				
				cars.add(new Automobile(targa, modello, imgUrl, park_id, luogo));
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cars;
	}


	

}
