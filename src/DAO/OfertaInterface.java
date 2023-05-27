package DAO;

import Modelo.OfertaModel;
import java.util.ArrayList;

public interface OfertaInterface {
    public void createOferta(OfertaModel oferta);
    public ArrayList<OfertaModel> findAllOfertas();
}
