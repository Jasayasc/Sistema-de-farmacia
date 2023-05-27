
package DAO;

import Modelo.UserModel;


public interface UsuarioInterface {
    public void createUser(UserModel user);
    public boolean LoginUser(String user, String pass);
}
