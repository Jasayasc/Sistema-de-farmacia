
package Modelo;

public class UserModel {
    int documento;
    String user;
    String pass;
    boolean permiso;

    public UserModel( int documento, String user, String pass, boolean permiso) {
        
        this.documento = documento;
        this.user = user;
        this.pass = pass;
        this.permiso = permiso;
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
