/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import DAO.DaoImplements;
import DAO.MedicamentoInterface;
import Modelo.MedicamentoModel;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Furotsuki
 */
public class Vista_administador extends javax.swing.JFrame {
    DefaultTableModel dtm = new DefaultTableModel();
    /**
     * Creates new form Vista_administador
     */
    
    //Nombre tabla
    public Vista_administador() {
        initComponents();
         setLocationRelativeTo(null);
        String[] titulos = new String[]{"ID","Nombre medicamento","Cantidad","Costo","Requiere receta"};
        dtm.setColumnIdentifiers(titulos);
        llenar();
        Tabla_productos_admin.setModel(dtm);
    }
    
    public void llenar(){
        dtm.setRowCount(0);
        MedicamentoInterface mi = new DaoImplements();
        ArrayList<MedicamentoModel> medicamentos= mi.findAllMedicamentos();
        for (MedicamentoModel medicamento : medicamentos) {
            dtm.addRow(new Object[]{medicamento.getId(),medicamento.getNombre(),medicamento.getCantidad(),
            medicamento.getPrecio(),medicamento.getReceta()});
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_productos_admin = new javax.swing.JTable();
        agregarProducto = new javax.swing.JButton();
        eliminarProducto = new javax.swing.JButton();
        modificarProducto = new javax.swing.JButton();
        generarReporte = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        crearAdmin = new javax.swing.JMenuItem();
        eliminarAdmin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(25, 118, 211));

        Tabla_productos_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla_productos_admin);

        agregarProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        agregarProducto.setForeground(new java.awt.Color(25, 118, 211));
        agregarProducto.setText("Agregar producto");
        agregarProducto.setAutoscrolls(true);

        eliminarProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarProducto.setForeground(new java.awt.Color(25, 118, 211));
        eliminarProducto.setText("Eliminar producto");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });

        modificarProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modificarProducto.setForeground(new java.awt.Color(25, 118, 211));
        modificarProducto.setText("Modificar producto");

        generarReporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        generarReporte.setForeground(new java.awt.Color(25, 118, 211));
        generarReporte.setText("Generar reporte");

        salir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salir.setForeground(new java.awt.Color(25, 118, 211));
        salir.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(generarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarProducto)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarProducto)
                        .addComponent(modificarProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generarReporte)
                    .addComponent(salir))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jMenu1.setText("Administrar Adminstradores");

        crearAdmin.setText("Crear administrador");
        jMenu1.add(crearAdmin);

        eliminarAdmin.setText("Eliminar Administrador");
        jMenu1.add(eliminarAdmin);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarProductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_administador().setVisible(true);
            }
        });
    }

    public JButton getAgregarProducto() {
        return agregarProducto;
    }

    public JButton getEliminarProducto() {
        return eliminarProducto;
    }

    public JButton getGenerarReporte() {
        return generarReporte;
    }

    public JButton getModificarProducto() {
        return modificarProducto;
    }

    public JButton getSalir() {
        return salir;
    }

    public JMenuItem getCrearAdmin() {
        return crearAdmin;
    }

    public JMenuItem getEliminarAdmin() {
        return eliminarAdmin;
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_productos_admin;
    private javax.swing.JButton agregarProducto;
    private javax.swing.JMenuItem crearAdmin;
    private javax.swing.JMenuItem eliminarAdmin;
    private javax.swing.JButton eliminarProducto;
    private javax.swing.JButton generarReporte;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarProducto;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
