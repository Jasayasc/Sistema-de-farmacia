package Modelo;

public class ClientModel implements Clienteinter {

   

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
    




    @Override
    public int getDocumento() {
        return documento;
    }

    @Override
    public String getNombre() {
        return  nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public String getCorreo() {
        return correo;
    }


}
