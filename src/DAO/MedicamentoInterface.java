
package DAO;

import Modelo.MedicamentoModel;
import java.util.ArrayList;

public interface MedicamentoInterface {
    public ArrayList<MedicamentoModel> findAllMedicamentos();
    public MedicamentoModel findByNombre(String name);
    public void insertMedicamento(MedicamentoModel medicamento);
    public void deleteMedicamento(int id);
    public void modifyMedicamento(MedicamentoModel medicamento);
}
