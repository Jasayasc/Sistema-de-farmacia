
package Modelo;

public class MedicamentoModel {
    int id;
    String nombre;
    int cantidad;
    int precio;
    String receta;

    public MedicamentoModel(int id, String nombre, int cantidad, int precio, String receta) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.receta = receta;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getReceta() {
        return receta;
    }
    
    
}
