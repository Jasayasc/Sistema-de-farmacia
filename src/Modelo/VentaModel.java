
package Modelo;

public class VentaModel implements Venta_interface{
    int id;
    int id_prod;
    String nombre;
    int cantidad;
    int valor;

    public VentaModel(int id, int id_prod, String nombre, int cantidad, int valor) {
        this.id = id;
        this.id_prod = id_prod;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    @Override
    public int getId() {
       return id;
    }

    @Override
    public int getId_prod() {
        return id_prod;
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
    public int getValor() {
        return valor;
    }


    
}
