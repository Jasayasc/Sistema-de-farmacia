
package DAO;

import Modelo.Model;
import java.util.ArrayList;

public interface AdmiInterface {
    public boolean isAdmin(String user, String pass);
    public void createAdmin(String user, String pass);
    public ArrayList<Model> findAllAdmin();
    public void deleteAdmin(String user);
}
