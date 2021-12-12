package Automobile;

import java.util.List;


public interface AutomobileDao {
	
    public String insert(Automobile car);
    public String deleteCar(String targa);
    public String moveCar(String targa, int id_parcheggio);
    public List<Automobile> selectAllCars();
}
