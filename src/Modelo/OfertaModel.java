
package Modelo;


public class OfertaModel implements Ofertas_interface{
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getId_prod() {
        return id_prod;
    }

    @Override
    public float getPorcentaje() {
        return  porcentaje;
    }

    @Override
    public int getDias() {
        return dias;
    }


    
}
