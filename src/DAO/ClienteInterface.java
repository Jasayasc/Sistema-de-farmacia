
package DAO;

import Modelo.ClientModel;
import java.util.ArrayList;

public interface ClienteInterface {
    public void createClient(ClientModel cliente);
    public ArrayList<ClientModel> findAllClient();
}
