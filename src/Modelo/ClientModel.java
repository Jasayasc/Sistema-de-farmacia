
package Modelo;


public class ClientModel {
    int documento;
    String nombre;
    String apellido;
    String direccion;
    String correo;
    String telefono;
    int nroCompras;

    public ClientModel(int documento, String nombre, String apellido, String direccion, String correo, String telefono, int nroCompras) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.nroCompras = nroCompras;
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNroCompras() {
        return nroCompras;
    }
    
    
}
