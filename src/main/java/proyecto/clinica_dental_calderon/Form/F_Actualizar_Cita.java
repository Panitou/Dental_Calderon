package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyecto.clinica_dental_calderon.DB.Conexion;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class F_Actualizar_Cita extends javax.swing.JFrame {

    private int idCita;

    public F_Actualizar_Cita() {
        initComponents();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }

    public F_Actualizar_Cita(int idCita) {
        initComponents();
        this.idCita = idCita; // Guardar el ID de la cita
    }

    //SETTER DE (TXTFILED, SPINNER, JDATECHOOSER)
    public void txtNumeroCita(String numeroCita) {
        txtNumeroCita.setText(numeroCita);
    }

    public void txtNumeroTratamiento(String numeroTratamiento) {
        txtNumeroTratamiento.setText(numeroTratamiento);
    }

    public void txtTratamiento(String nombreTratamiento) {
        txtTratamiento.setText(nombreTratamiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        txtNumeroCita = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTratamiento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxEstado_Cita = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroTratamiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 330));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 330));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 330));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACTUALIZAR ESTADO DE CITA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 290, 40));

        btnActualizar.setBackground(new java.awt.Color(24, 177, 135));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 140, 40));
        jPanel1.add(txtNumeroCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 110, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ESTADO DE LA CITA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 170, 20));
        jPanel1.add(txtTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 170, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("N° DE LA CITA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 110, 20));

        cbxEstado_Cita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "COMPLETADO", "CANCELADO" }));
        jPanel1.add(cbxEstado_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 170, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("TRATAMIENTO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 170, 20));
        jPanel1.add(txtNumeroTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 140, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("N° DEL TRATAMIENTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, 20));

        btnCancelar.setBackground(new java.awt.Color(24, 177, 135));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int idCita = Integer.parseInt(txtNumeroCita.getText());

        Connection c = null;
        PreparedStatement ps = null;

        // Obtener el nuevo estado de la cita desde el ComboBox
        String nuevoEstado = cbxEstado_Cita.getSelectedItem().toString();
        String actualizarEstadoQuery = "UPDATE TB_CITAS SET estado_cita = ? WHERE id_cita = ?";
        try {
            c = Conexion.getConnection();
            // Actualizar el estado de la cita en la base de datos
            ps = c.prepareStatement(actualizarEstadoQuery);
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idCita);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Estado de la cita actualizado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el estado de la cita.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado de la cita.");
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Actualizar_Cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbxEstado_Cita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtNumeroCita;
    public javax.swing.JTextField txtNumeroTratamiento;
    public javax.swing.JTextField txtTratamiento;
    // End of variables declaration//GEN-END:variables

}
