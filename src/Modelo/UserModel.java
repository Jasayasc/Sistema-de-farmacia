
package Modelo;

public class UserModel {
    int id;
    int documento;
    String user;
    String pass;
    boolean permiso;

    public UserModel(int id, int documento, String user, String pass, boolean permiso) {
        this.id = id;
        this.documento = documento;
        this.user = user;
        this.pass = pass;
        this.permiso = permiso;
    }

    public int getId() {
        return id;
    }

    public int getDocumento() {
        return documento;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public boolean isPermiso() {
        return permiso;
    }
    
}
