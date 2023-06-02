
package Modelo;

public class MedicamentoModel implements Medicamento_interface{
    int id;
    String nombre;
    int cantidad;
    int precio;
    String receta;

    public MedicamentoModel(){
        
    }
    
    public MedicamentoModel(int id, String nombre, int cantidad, int precio, String receta) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.receta = receta;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
       return nombre;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public int getPrecio() {
       return precio;
    }

    @Override
    public String getReceta() {
        return receta;
    }


    
    
}
