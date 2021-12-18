package parcheggio;

import java.util.List;

public interface ParcheggioDao {

	
    public String insert(Parcheggio park);
    public String deletePark(int idPark);
    public List<Parcheggio> selectAllParks();
    public String getLuogo(int idPark);
 
}
