package Controlador;

import DAO.DaoImplements;
import DAO.UsuarioInterface;
import Modelo.Connector;
import Modelo.Model;
import Vista.Login;
import Vista.Vista_usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {

    Login login;
    Model model;
    Connector connector;
    Vista_usuarios vistaUser;

    public Controller() {
        login = new Login();
        vistaUser = new Vista_usuarios();
        model = new Model();
        connector = new Connector();

        //Connection con = model.Conectar();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });

        login.getLoginBotton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getLoginBotton()) {
              UsuarioInterface ui = new DaoImplements();
              
              String user;
              String pass;
              
             user = login.getTxtusername().getText();
             char[] arrayC = login.getTxtpassword().getPassword();
             pass = new String(arrayC);
              
              if(ui.LoginUser(user, pass)){
                  login.setVisible(false);
                  vistaUser.setVisible(true);
              }
        }

    }
}
