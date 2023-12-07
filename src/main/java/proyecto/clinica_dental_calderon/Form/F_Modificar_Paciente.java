package proyecto.clinica_dental_calderon.Form;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyecto.clinica_dental_calderon.DB.Conexion;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class F_Modificar_Paciente extends javax.swing.JFrame {

    public F_Modificar_Paciente() {
        initComponents();

        //Restricciones
        // Validación para Nombre (solo letras, máximo 100 caracteres)
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
                        || txtNombre.getText().length() >= 100) {
                    evt.consume();
                }
            }
        });

// Validación para Apellido (solo letras, máximo 100 caracteres)
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
                        || txtApellidos.getText().length() >= 100) {
                    evt.consume();
                }
            }
        });

// Validación para Celular (solo números, máximo 15 dígitos)
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
                        || txtCelular.getText().length() >= 15) {
                    evt.consume();
                }
            }
        });

// Validación para Edad (solo números, máximo 4 dígitos)
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
                        || txtEdad.getText().length() >= 4) {
                    evt.consume();
                }
            }
        });

// Validación para Enfermedad (letras y números, no signos)
        txaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isLetterOrDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

    }

    public void txtDni(String dni) {
        txtDni.setText(dni);
    }

    public void txtNombre(String nombre) {
        txtNombre.setText(nombre);
    }

    public void txtApellidos(String apellidos) {
        txtApellidos.setText(apellidos);
    }

    public void txtCelular(String celular) {
        txtCelular.setText(celular);
    }

    public void txtEdad(String edad) {
        txtEdad.setText(edad);
    }

    public void txaDescripcion(String descripcion) {
        txaDescripcion.setText(descripcion);
    }

    public void dateFecha_Ingreso(Date fecha_ingreso) {
        dateFecha_Ingreso.setDate(fecha_ingreso);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateFecha_Ingreso = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(532, 444));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(532, 444));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITAR DATOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 330, 50));

        btnActualizar.setBackground(new java.awt.Color(30, 85, 131));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 150, 40));

        btnCancelar.setBackground(new java.awt.Color(30, 85, 131));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 150, 40));

        txtDni.setEnabled(false);
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 150, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 85, 131));
        jLabel2.setText("ENFERMEDAD O ALERGIA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 230, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 85, 131));
        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 150, 20));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 30));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 150, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 85, 131));
        jLabel4.setText("FECHA DE INGRESO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 160, 20));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 150, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 85, 131));
        jLabel5.setText("CELULAR");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 150, 20));

        dateFecha_Ingreso.setEnabled(false);
        jPanel1.add(dateFecha_Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 160, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 85, 131));
        jLabel7.setText("APELLIDOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 150, 20));

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txaDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 85, 131));
        jLabel8.setText("DNI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 150, 20));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 85, 131));
        jLabel9.setText("EDAD");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 80, 20));

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

// Obtener los datos editados desde los campos de texto y otros controles
        String nuevoNombre = txtNombre.getText();
        String nuevoApellido = txtApellidos.getText();
        String nuevoDNI = txtDni.getText(); // DNI del paciente que quieres actualizar
        String nuevaEdad = txtEdad.getText();
        String nuevaEnfermedad = txaDescripcion.getText();
        String nuevoCelular = txtCelular.getText();
        java.util.Date nuevaFechaInscripcion = dateFecha_Ingreso.getDate();
        Connection c = null;
        PreparedStatement ps = null;
        String queryPacientes = "UPDATE TB_PACIENTES SET nombre_paciente=?, apellido_paciente=?, edad_paciente=?, enfermedad_paciente=?, celular_paciente=?, fecha_inscripcion=? WHERE dni_paciente=?";
        try {

            c = Conexion.getConnection();
            c.setAutoCommit(false);

            ps = c.prepareStatement(queryPacientes);
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoApellido);
            ps.setString(3, nuevaEdad);
            ps.setString(4, nuevaEnfermedad);
            ps.setString(5, nuevoCelular);
            ps.setDate(6, new java.sql.Date(nuevaFechaInscripcion.getTime()));
            ps.setString(7, nuevoDNI); // Usar el DNI para identificar al paciente

            int rowsUpdatedPacientes = ps.executeUpdate();

            if (rowsUpdatedPacientes > 0) {
                // Actualizar TB_TRATAMIENTOS
                String queryTratamientos = "UPDATE TB_TRATAMIENTOS SET nombre_paciente=?, apellido_paciente=? WHERE dni_paciente=?";
                PreparedStatement psTratamientos = c.prepareStatement(queryTratamientos);
                psTratamientos.setString(1, nuevoNombre);
                psTratamientos.setString(2, nuevoApellido);
                psTratamientos.setString(3, nuevoDNI);

                int rowsUpdatedTratamientos = ps.executeUpdate();

                // Actualizar TB_CITAS
                String queryCitas = "UPDATE TB_CITAS SET nombre_paciente=?, apellido_paciente=? WHERE dni_paciente=?";
                PreparedStatement psCitas = c.prepareStatement(queryCitas);
                psCitas.setString(1, nuevoNombre);
                psCitas.setString(2, nuevoApellido);
                psCitas.setString(3, nuevoDNI);

                int rowsUpdatedCitas = ps.executeUpdate();

                if (rowsUpdatedTratamientos > 0 && rowsUpdatedCitas > 0) {
                    c.commit(); // Confirmar la transacción
                    JOptionPane.showMessageDialog(this, "Los cambios se guardaron exitosamente.");
                } else {
                    c.rollback(); // Revertir la transacción si hay algún problema
                    JOptionPane.showMessageDialog(this, "Hubo un problema al actualizar los tratamientos o las citas.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se pudieron guardar los cambios en pacientes.");
            }
        } catch (SQLException e) {
            try {
                if (c != null) {
                    c.rollback(); // Revertir la transacción en caso de excepción
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios: " + e.getMessage());
        } finally {
            // Cerrar recursos y restaurar configuración de auto-commit
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.setAutoCommit(true); // Restaurar auto-commit a su valor predeterminado
                    c.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Modificar_Paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    public com.toedter.calendar.JDateChooser dateFecha_Ingreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txaDescripcion;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCelular;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
