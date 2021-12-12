package Utente;

import java.util.List;

public interface UtenteDao {

    public String insert(Utente user);
    public boolean deleteUser(int id);
    public List<Utente> selectAllUsers();
    public Utente validate(String email,String pass);  
    
}
