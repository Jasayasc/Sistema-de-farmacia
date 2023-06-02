package Controlador;

import DAO.AdmiInterface;
import DAO.ClienteInterface;
import DAO.DaoImplements;
import DAO.MedicamentoInterface;
import DAO.UsuarioInterface;
import DAO.VentaInterface;
import Modelo.ClientModel;
import Modelo.Connector;
import Modelo.MedicamentoModel;
import Modelo.Model;
import Modelo.UserModel;
import Modelo.VentaModel;
import Vista.Admin;
import Vista.Agregar_producto;
import Vista.AñadirAdmin;
import Vista.EliminarAdmin;
import Vista.Eliminar_producto;
import Vista.Login;
import Vista.Modificar_producto;
import Vista.Registro;
import Vista.Vista_administador;
import Vista.Vista_usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

    Model model;
    Connector connector;

    Login login;
    Vista_usuarios vistaUser;
    Registro registro;
    Admin admin;
    Vista_administador v;
    Agregar_producto a;
    Modificar_producto m;
    Eliminar_producto el;

    AñadirAdmin aa;

    EliminarAdmin ea;

    MedicamentoInterface mi = new DaoImplements();
    AdmiInterface ai = new DaoImplements();

    public Controller() {
        login = new Login();
        vistaUser = new Vista_usuarios();
        registro = new Registro();
        //model = new Model();
        connector = new Connector();
        admin = new Admin();
        v = new Vista_administador();

        a = new Agregar_producto();
        m = new Modificar_producto();
        el = new Eliminar_producto();

        aa = new AñadirAdmin();
        ea = new EliminarAdmin();
        //Connection con = model.Conectar();
        login.setVisible(true);

        login.getLoginButton().addActionListener(this);
        login.getRegistro().addActionListener(this);

        registro.getRegister().addActionListener(this);
        registro.getSalir().addActionListener(this);
        registro.getSalir().addActionListener(this);

        vistaUser.getAdmin().addActionListener(this);
        vistaUser.getPedido().addActionListener(this);
        //vistaUser.getAñadir().addActionListener(this);
        // vistaUser.getSalir().addActionListener(this);

        admin.getAdminLogin().addActionListener(this);

        v.getAgregarProducto().addActionListener(this);
        v.getEliminarProducto().addActionListener(this);
        v.getModificarProducto().addActionListener(this);
        v.getSalir().addActionListener(this);
        v.getGenerarReporte().addActionListener(this);
        v.getEliminarAdmin().addActionListener(this);
        v.getCrearAdmin().addActionListener(this);

        a.getAgregar().addActionListener(this);
        a.getAtras().addActionListener(this);

        el.getEliminar().addActionListener(this);
        el.getSalir().addActionListener(this);

        m.getSalir().addActionListener(this);

        aa.getAdminRegister().addActionListener(this);
        ea.getAdminDelete().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getLoginButton()) {
            UsuarioInterface ui = new DaoImplements();

            String user;
            String pass;

            user = login.getTxtUser().getText();
            char[] arrayC = login.getTxtPassword().getPassword();
            pass = new String(arrayC);
            /* if(user.equals("joel") && pass.equals("123")){
                  JOptionPane.showMessageDialog(null, "Ha ingresado con exito");
              }*/
            if (ui.LoginUser(user, pass)) {
                login.setVisible(false);
                vistaUser.setVisible(true);
            } else {
                login.getEstado().setText("Usuario o clave erronea");
            }
        }
        if (e.getSource() == login.getRegistro()) {
            login.setVisible(false);
            registro.setVisible(true);
        }
        if (e.getSource() == registro.getRegister()) {
            int documento = Integer.parseInt(registro.getDocument().getText());
            String nombre = registro.getNombre().getText();
            String direccion = registro.getAddress().getText();
            String correo = registro.getEmail().getText();
            /*Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
     
         Matcher mather = pattern.matcher(correo);*/

            String user = registro.getUser().getText();
            String pass = registro.getPass();

            //if (mather.find() == true) {
            ClienteInterface ci = new DaoImplements();
            UsuarioInterface ui = new DaoImplements();
            ci.createClient(new ClientModel(documento, nombre, direccion, correo));
            ui.createUser(new UserModel(documento, user, pass));
            JOptionPane.showMessageDialog(null, "Registrado con exito");
            /*} else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese un correo valido");
        }*/

        }
        if (e.getSource() == vistaUser.getAdmin()) {
            admin.setVisible(true);
        }
        if (e.getSource() == admin.getAdminLogin()) {
            String user = admin.getAdminUser().getText();
            String pass = admin.getAdminPass();
            AdmiInterface ai = new DaoImplements();
            if (ai.isAdmin(user, pass)) {
                admin.setVisible(false);
                vistaUser.setVisible(false);
                v.setVisible(true);
            }
        }
        if (e.getSource() == vistaUser.getPedido()) {
            ArrayList<VentaModel> ventas = vistaUser.getVentas();
            VentaInterface vi = new DaoImplements();
            for (VentaModel venta : ventas) {
                vi.createVenta(venta);
            }
        }
        if (e.getSource() == v.getAgregarProducto()) {
            v.setVisible(false);
            a.setVisible(true);
        }
        if (e.getSource() == v.getEliminarProducto()) {
            v.setVisible(false);
            el.setVisible(true);
        }
        if (e.getSource() == v.getModificarProducto()) {
            v.setVisible(false);
            m.setVisible(true);
        }
        if (e.getSource() == v.getSalir()) {
            v.setVisible(false);
            vistaUser.setVisible(true);
        }
        if (e.getSource() == v.getEliminarAdmin()) {

        }
        if (e.getSource() == v.getCrearAdmin()) {
            aa.setVisible(true);
        }
        if (e.getSource() == a.getAgregar()) {
            int id = Integer.parseInt(a.getId().getText());
            int cantidad = Integer.parseInt(a.getCantidadDis().getText());
            int precio = Integer.parseInt(a.getPrecioU().getText());

            mi.insertMedicamento(new MedicamentoModel(id, a.getNombre().getText(), cantidad, precio, a.getReceta().getSelectedItem().toString()));
            JOptionPane.showMessageDialog(null, "Medicamento registrado con exito");
            a.setVisible(false);
            v.llenar();
            v.setVisible(true);
        }

        if (e.getSource() == a.getAtras()) {
            a.setVisible(false);
            v.setVisible(true);
        }

        if (e.getSource() == el.getEliminar()) {
            mi.deleteMedicamento(el.getIdRow());
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            el.setVisible(false);
            v.setVisible(true);
        }
        if (e.getSource() == el.getSalir()) {
            el.setVisible(false);
            v.setVisible(true);
        }

        if (e.getSource() == m.getSalir()) {
            m.setVisible(false);
            v.setVisible(true);
        }
        if (e.getSource() == aa.getAdminRegister()) {

            String user = aa.getAdminUser().getText();
            String pass = aa.getAdminPass();
            ai.createAdmin(user, pass);
            JOptionPane.showMessageDialog(null, "Agregado con exito!");
            aa.setVisible(false);
        }
        if (e.getSource() == ea.getAdminDelete()) {
            String user = ea.getComboBox().getSelectedItem().toString();
            ai.deleteAdmin(user);
            JOptionPane.showMessageDialog(null, "Eliminado con exito!");
            ea.setVisible(false);
        }
        if (e.getSource() == registro.getSalir()) {
            registro.setVisible(false);
            login.setVisible(true);
        }
        if (e.getSource() == v.getGenerarReporte()) {
            BufferedWriter outStream=null;
            try {
                
                VentaInterface vi = new DaoImplements();
                ArrayList<VentaModel> ventas = vi.findAllVentas();
                int i=0;
                
                while (i< ventas.size()) {
                    outStream = new BufferedWriter(new FileWriter("./datosVentas.csv", true));
                    //System.out.println(venta.getNombre());
                    VentaModel venta = ventas.get(i);
                    outStream.write(venta.getId() + ";" + venta.getId_prod() + ";" + venta.getNombre() + ";" + venta.getCantidad() + ";" + venta.getValor() + "\n");
                    i++;
                    outStream.close();
                }
                
                JOptionPane.showMessageDialog(null, "Generado con exito");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
