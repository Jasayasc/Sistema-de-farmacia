package Modelo;

public class ClientModel {

    int documento;
    String nombre;
    String direccion;
    String correo;

    public ClientModel(int documento, String nombre, String direccion, String correo) {
        this.documento = documento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
       
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }


    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }


}
