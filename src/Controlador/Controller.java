package Controlador;

import DAO.ClienteInterface;
import DAO.DaoImplements;
import DAO.UsuarioInterface;
import Modelo.ClientModel;
import Modelo.Connector;
import Modelo.Model;
import Modelo.UserModel;
import Vista.Login;
import Vista.Registro;
import Vista.Vista_usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

    Login login;
    Model model;
    Connector connector;
    Vista_usuarios vistaUser;
    Registro registro;

    public Controller() {
        login = new Login();
        vistaUser = new Vista_usuarios();
        registro = new Registro();
        model = new Model();
        connector = new Connector();

        //Connection con = model.Conectar();
        login.setVisible(true);

        login.getLoginButton().addActionListener(this);
        login.getRegistro().addActionListener(this);
        registro.getRegister().addActionListener(this);
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
            String correo = registro.getRegister().getText();
            Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
     
         Matcher mather = pattern.matcher(correo);
         
         String user = registro.getUser().getText();
         String pass = registro.getPass().getText();
 
        if (mather.find() == true) {
            ClienteInterface ci = new DaoImplements();
            UsuarioInterface ui = new DaoImplements();
            ci.createClient(new ClientModel(documento,nombre,direccion,correo));
            ui.createUser(new UserModel(documento, user,pass,false));
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese un correo valido");
        }
            
        }

    }
}
