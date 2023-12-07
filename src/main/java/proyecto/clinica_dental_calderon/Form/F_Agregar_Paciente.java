package proyecto.clinica_dental_calderon.Form;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author Panito GitHub https://github.com/Panitou
 */
public class F_Agregar_Paciente extends javax.swing.JFrame {

    public F_Agregar_Paciente() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDateToCurrent();
        dateFecha_Ingreso.setEnabled(false);

        // Bloquear la funcionalidad de pegar (Ctrl+V) para evitar que se pegue texto
        txtDni.setTransferHandler(null);
        txtNombre.setTransferHandler(null);
        txtApellido.setTransferHandler(null);
        txtCelular.setTransferHandler(null);
        txtEdad.setTransferHandler(null);

        //Restricciones
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) || txtDni.getText().length() >= 10) {
                    evt.consume();
                }
            }
        });

        // Validación para Nombre (solo letras, espacios y máximo 100 caracteres)
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)
                        || txtNombre.getText().length() >= 100) {
                    evt.consume();
                }
            }
        });

// Validación para Apellido (solo letras, espacios y máximo 100 caracteres)
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)
                        || txtApellido.getText().length() >= 100) {
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

// Validación para Enfermedad (letras, números, espacios y máximo 100 caracteres)
        txaEnfermedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isLetterOrDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)
                        || txaEnfermedad.getText().length() >= 100) {
                    evt.consume();
                }
            }
        });

    }

    private void setDateToCurrent() {
        Date currentDate = new Date(); // Obtener la fecha actual
        dateFecha_Ingreso.setDate(currentDate); // Establecer la fecha actual en el JDateChooser
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCrearPaciente = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEnfermedad = new javax.swing.JTextArea();
        dateFecha_Ingreso = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(532, 444));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVO PACIENTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 340, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 85, 131));
        jLabel2.setText("ENFERMEDAD/ALERGIA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 220, 20));
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 150, 30));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 150, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 85, 131));
        jLabel3.setText("FECHA DE INGRESO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 180, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 85, 131));
        jLabel4.setText("DNI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 110, 20));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 150, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 85, 131));
        jLabel5.setText("APELLIDOS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 110, 20));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 150, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 85, 131));
        jLabel6.setText("CELULAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 85, 131));
        jLabel7.setText("NOMBRE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, 20));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 90, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 85, 131));
        jLabel8.setText("EDAD");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 90, 20));

        btnCrearPaciente.setBackground(new java.awt.Color(30, 85, 131));
        btnCrearPaciente.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnCrearPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearPaciente.setText("CREAR PACIENTE");
        btnCrearPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 150, 40));

        btnCancelar.setBackground(new java.awt.Color(30, 85, 131));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 120, 40));

        txaEnfermedad.setColumns(20);
        txaEnfermedad.setLineWrap(true);
        txaEnfermedad.setRows(5);
        txaEnfermedad.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txaEnfermedad);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 220, 90));

        dateFecha_Ingreso.setForeground(new java.awt.Color(30, 85, 131));
        jPanel1.add(dateFecha_Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCrearPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPacienteActionPerformed
        if (txtDni.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtApellido.getText().isEmpty() || txtCelular.getText().isEmpty()
                || txtEdad.getText().isEmpty() || dateFecha_Ingreso.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos");
        } else {
            String dni = txtDni.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String celular = txtCelular.getText();
            String enfermedad = txaEnfermedad.getText();
            Date fecha_ingreso = dateFecha_Ingreso.getDate();
            String edad = txtEdad.getText();

            long d = fecha_ingreso.getTime();
            java.sql.Date fecha = new java.sql.Date(d);

            Connection c = null;
            PreparedStatement ps = null;
            String query = "INSERT INTO TB_PACIENTES (nombre_paciente, apellido_paciente, dni_paciente, edad_paciente, enfermedad_paciente, celular_paciente, fecha_inscripcion) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {
                c = Conexion.getConnection();
                ps = c.prepareStatement(query);
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, dni);
                ps.setString(4, edad);
                ps.setString(5, enfermedad);
                ps.setString(6, celular);
                ps.setDate(7, new java.sql.Date(fecha_ingreso.getTime()));

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Paciente creado exitosamente");
                    Limpiar_Campos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al crear el paciente");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Cerrar recursos (PreparedStatement, Connection, etc.)
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCrearPacienteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Agregar_Paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearPaciente;
    private com.toedter.calendar.JDateChooser dateFecha_Ingreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaEnfermedad;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void Limpiar_Campos() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCelular.setText("");
        txtEdad.setText("");
        txaEnfermedad.setText("");
    }

}
