
package Modelo;

public class UserModel implements Usuario {
    int documento;
    String user;
    String pass;
    

    public UserModel( int documento, String user, String pass) {
        
        this.documento = documento;
        this.user = user;
        this.pass = pass;
        
    }



    @Override
    public int getDocumento() {
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

    

    
}
