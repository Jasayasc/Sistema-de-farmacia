package Controlador;


import Modelo.Model;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Controller implements ActionListener{

    Login login;
    Model model;

    public Controller() {
        login = new Login();
        model = new Model();
        //Connection con = model.Conectar();
        login.setVisible(true);
        login.setLocationRelativeTo(null);

        login.getLoginBotton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getLoginBotton()) {
            Connection con = model.Conectar();
            ResultSet resul = null;
            try {
                String sql = "Select * from usuarios";
                PreparedStatement st = con.prepareStatement(sql);
                resul = st.executeQuery();

                while (resul.next()) {
                    String user = resul.getString("usuario");
                    String pass = resul.getString("contraseña");

                    char[] arrayC;
                    arrayC = login.getTxtpassword().getPassword();
                    String password = new String(arrayC);

                    if (login.getTxtusername().getText() == user && password == pass) {
                        JOptionPane.showMessageDialog(login, "Ingreso con exito :D");
                        /*sql = "Select nombre from datos where user = "+login.getTxtusername().getText();
                        st= con.prepareStatement(sql);
                        resul = st.executeQuery();
                        System.out.println("Bienvenido "+ resul.getString("nombre"));*/
                        break;
                    }
                }

            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}