
package Modelo;

public class VentaModel implements Venta_interface{
    int id;
    int id_prod;
    int documento;
    int cantidad;
    int valor;

    public VentaModel(int id, int id_prod, int documento, int cantidad, int valor) {
        this.id = id;
        this.id_prod = id_prod;
        this.documento = documento;
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
    public int getDocumento() {
        return documento;
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
