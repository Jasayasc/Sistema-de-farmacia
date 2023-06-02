package DAO;

import Modelo.ClientModel;
import Modelo.Connector;
import Modelo.MedicamentoModel;
import Modelo.Model;
import Modelo.UserModel;
import Modelo.VentaModel;
import java.util.ArrayList;
import java.sql.*;

public class DaoImplements implements ClienteInterface, MedicamentoInterface, UsuarioInterface, VentaInterface, AdmiInterface {

    Connector connector;
    MedicamentoModel mm;
    

    public DaoImplements() {
        this.connector = new Connector();
        this.mm = new MedicamentoModel();
    }

    @Override
    public void createClient(ClientModel cliente) {
        String sql = "insert into cliente VALUES (?,?,?,?)";
        try {
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);

            statement.setString(1, cliente.getDocumento() + "");
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getDireccion());
            statement.setString(4, cliente.getCorreo());
            statement.executeUpdate();
            statement.close();
            //connector.getConnection().close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<ClientModel> findAllClient() {
        String sql = "select * from cliente";
        ArrayList<ClientModel> clientes = new ArrayList<>();
        try {
            Statement statement;

            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                clientes.add(new ClientModel(resultSet.getInt("documento"), resultSet.getString("nombre"),
                        resultSet.getString("direccion"), resultSet.getString("correo")));
            }

            resultSet.close();
            statement.close();
            //connector.getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return clientes;
    }

    @Override
    public ArrayList<MedicamentoModel> findAllMedicamentos() {
        String sql = "select * from medicamento";
        ArrayList<MedicamentoModel> medicamentos = new ArrayList<>();
        try {
            Statement statement;

            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                medicamentos.add(new MedicamentoModel(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getInt("cantidad"),
                        resultSet.getInt("precio"), resultSet.getString("receta")));

            }

            resultSet.close();
            statement.close();
            //connector.getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return medicamentos;
    }

    @Override
    public void insertMedicamento(MedicamentoModel medicamento) {
        String sql = "insert into medicamento VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);

            statement.setString(1, medicamento.getId() + "");
            statement.setString(2, medicamento.getNombre());
            statement.setString(3, medicamento.getCantidad() + "");
            statement.setString(4, medicamento.getPrecio() + "");
            statement.setString(5, medicamento.getReceta());

            statement.executeUpdate();

            statement.close();
           // connector.getConnection().close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteMedicamento(int id) {
        String sql = "delete from medicamento where id = ?";

        try {
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            statement.setString(1, id + "");

            statement.executeUpdate();

            statement.close();
            //connector.getConnection().close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

    @Override
    public void modifyMedicamento(MedicamentoModel medicamento) {
        String sql = "update medicamento set nombre = ?, cantiad = ?, precio = ?, receta = ? where id = ?";

        try {

            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);

            statement.setString(1, medicamento.getNombre());
            statement.setString(2, medicamento.getCantidad() + "");
            statement.setString(3, medicamento.getPrecio() + "");
            statement.setString(4, medicamento.getReceta());

            statement.setString(5, medicamento.getId() + "");

            statement.executeUpdate();

            statement.close();
            //connector.getConnection().close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    public boolean LoginUser(String user, String pass) {

        String sql = "select * from usuario";

        try {
            Statement statement;
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getString("usuario").equals(user) && resultSet.getString("contraseña").equals(pass)) {
                    return true;
                }
            }
        } catch (Exception e) {

            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public void createVenta(VentaModel venta) {
        String sql = "insert into venta (id_prod, nombre, cantidad, valor) values (?,?,?,?)";

        try {

            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            statement.setString(1, venta.getId_prod() + "");
            statement.setString(2, venta.getNombre());
            statement.setString(3, venta.getCantidad() + "");
            statement.setString(4, venta.getValor() + "");

            statement.executeUpdate();

            statement.close();
            //connector.getConnection().close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    public ArrayList<VentaModel> findAllVentas() {
        String sql = "select * from venta";
        ArrayList<VentaModel> ventas = new ArrayList<>();
        try {
            Statement statement;
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                ventas.add(new VentaModel(resultSet.getInt("id"), resultSet.getInt("id_prod"), resultSet.getString("nombre"), resultSet.getInt("cantidad"),
                        resultSet.getInt("valor")));

            }

            resultSet.close();
            statement.close();
            //connector.getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return ventas;
    }

    @Override
    public void createUser(UserModel user) {
        String sql = "insert into usuario (documento,usuario,contraseña,permiso) values (?,?,?)";

        try {

            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);

            statement.setString(1, user.getDocumento() + "");
            statement.setString(2, user.getUser());
            statement.setString(3, user.getPass());

            statement.executeUpdate();

            statement.close();
            //connector.getConnection().close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    public boolean isAdmin(String user, String pass) {
        String sql = "select * from admin";

        try {
            Statement statement;
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getString("usuario").equals(user) && resultSet.getString("contraseña").equals(pass)) {
                    return true;
                }
            }
        } catch (Exception e) {

            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public void createAdmin(String user, String pass) {
        String sql = "insert into admin  values (?,?)";

        try {

            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);

            statement.setString(1, user);
            statement.setString(2, pass);

            statement.executeUpdate();

            statement.close();
           // connector.getConnection().close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Model> findAllAdmin() {
        String sql = "select * from admin";
        ArrayList<Model> admins = new ArrayList<>();
        try {
            Statement statement;
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                admins.add(new Model(resultSet.getString("usuario"), resultSet.getString("contraseña")));

            }

            resultSet.close();
            statement.close();
            //connector.getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return admins;
    }

    @Override
    public void deleteAdmin(String user) {
        String sql = "delete from medicamento where usuario = ?";

        try {
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            statement.setString(1, user);

            statement.executeUpdate();

            statement.close();
            //connector.getConnection().close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

    @Override
    public MedicamentoModel findByNombre(String name) {
        String sql = "select * from medicamento where nombre = '" + name +"';";
        
        try {
            Statement statement;
            statement = connector.getConnection().createStatement();

            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
            System.out.println("llego aca resultSet");
            if (resultSet.next()) {
                System.out.println("Otla bandela en china");
                mm = new MedicamentoModel(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("cantidad"),
                        resultSet.getInt("precio"),
                        resultSet.getString("receta")
                );
                return mm;
            }

            
           // connector.getConnection().close();
        } catch (Exception ex) {
            System.out.println("Error123" + ex.getMessage());
        }
        return mm;
    }

}
