package proyecto.clinica_dental_calderon.Form;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author jcald
 */
public class Panel_Inicio extends javax.swing.JPanel {

    String fondo = "/images/Opacidad.png";

    ImageIcon fondoImagen = new ImageIcon(F_Sistema.class.getResource(fondo));

    public Panel_Inicio() throws SQLException {
        initComponents();

        lblFondo.setIcon(fondoImagen);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOdontologos = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1365, 770));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOdontologos.setBackground(new java.awt.Color(0, 122, 255));
        btnOdontologos.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        btnOdontologos.setForeground(new java.awt.Color(255, 255, 255));
        btnOdontologos.setText("MÓDULO ODONTÓLOGOS");
        btnOdontologos.setBorder(null);
        btnOdontologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdontologosActionPerformed(evt);
            }
        });
        add(btnOdontologos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 50));
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdontologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdontologosActionPerformed
        try {
            F_Odontologos odontologos = new F_Odontologos();
            odontologos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOdontologosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdontologos;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
