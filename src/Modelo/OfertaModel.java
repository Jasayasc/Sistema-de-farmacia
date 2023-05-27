
package Modelo;


public class OfertaModel {
    int id;
    int id_prod;
    float porcentaje;
    int dias;

    public OfertaModel(int id, int id_prod, float porcentaje, int dias) {
        this.id = id;
        this.id_prod = id_prod;
        this.porcentaje = porcentaje;
        this.dias = dias;
    }

    public int getId() {
        return id;
    }

    public int getId_prod() {
        return id_prod;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public int getDias() {
        return dias;
    }
    
}
