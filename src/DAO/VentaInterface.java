package DAO;

import Modelo.VentaModel;
import java.util.ArrayList;

public interface VentaInterface {
    public void createVenta(VentaModel venta);
    public ArrayList<VentaModel> findAllVentas();
}
