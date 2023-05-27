
package Modelo;

public class VentaModel {
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

    public int getId() {
        return id;
    }

    public int getId_prod() {
        return id_prod;
    }

    public int getDocumento() {
        return documento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getValor() {
        return valor;
    }
    
}
