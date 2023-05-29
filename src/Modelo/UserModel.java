
package Modelo;

public class UserModel implements Usuario {
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



    @Override
    public int getDocument() {
       return documento;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public boolean isPermiso() {
        return permiso;
    }

    
}
