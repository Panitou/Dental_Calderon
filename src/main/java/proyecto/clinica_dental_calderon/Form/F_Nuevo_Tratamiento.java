package proyecto.clinica_dental_calderon.Form;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import proyecto.clinica_dental_calderon.DB.Conexion;
import proyecto.clinica_dental_calderon.controlador_Odontologos.Lista_Odontologos;
import proyecto.clinica_dental_calderon.controlador_Odontologos.Odontologos;
import proyecto.clinica_dental_calderon.controlador_Tratamiento.Lista_Tratamientos;
import proyecto.clinica_dental_calderon.controlador_Tratamiento.Tratamientos;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class F_Nuevo_Tratamiento extends javax.swing.JFrame {

    public F_Nuevo_Tratamiento() throws SQLException {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDateToCurrent();
        dateFecha_Creacion.setEnabled(false);
        Deshabilitar_Campos();
        Cargar_Combos_Tratamientos(cbxTratamiento);
        Cargar_Combos_Odontologos(cbxOdontologo);

        cbxTratamiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                try {
                    cbxTratamientoItemStateChanged(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Nuevo_Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        txtCosto.setDocument(new CostoFilter());

        // Restricciones para el campo txtDni
        txtDni.setDocument(new JTextFieldLimit(15)); // Limita la cantidad máxima de caracteres
        ((AbstractDocument) txtDni.getDocument()).setDocumentFilter(new NumberFilter()); // Aplica el filtro de solo números

        // Ahora, carga el precio del tratamiento inicialmente seleccionado
        try {
            String tratamientoSeleccionado = cbxTratamiento.getSelectedItem().toString();
            Cargar_PrecioTratamiento(tratamientoSeleccionado);
        } catch (SQLException ex) {
            Logger.getLogger(F_Nuevo_Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        txaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isLetterOrDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)) {
                    evt.consume();
                }
            }
        });

    }

    private class CostoFilter extends PlainDocument {

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            String text = getText(0, getLength());
            if ((text + str).matches("\\d*\\.?\\d{0,2}")) {
                super.insertString(offset, str, attr);
            }
        }

        @Override
        public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            String currentText = getText(0, getLength());
            String beforeOffset = currentText.substring(0, offset);
            String afterOffset = currentText.substring(offset + length);

            String resultText = beforeOffset + text + afterOffset;
            if (resultText.matches("\\d*\\.?\\d{0,2}")) {
                super.replace(offset, length, text, attrs);
            }
        }
    }

    // Clase para limitar la cantidad máxima de caracteres en el campo
    private class JTextFieldLimit extends PlainDocument {

        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    // Clase para filtrar solo números en el campo txtDni
    private class NumberFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.insert(offset, string);

            if (sb.toString().matches("\\d{1,15}")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.replace(offset, offset + length, text);

            if (sb.toString().matches("\\d{1,15}")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    private void setDateToCurrent() {
        Date currentDate = new Date(); // Obtener la fecha actual
        dateFecha_Creacion.setDate(currentDate); // Establecer la fecha actual en el JDateChooser
    }

    public void Deshabilitar_Campos() {
        txtNombre.setEditable(false);
        txtApellidos.setEditable(false);
        txtEdad.setEditable(false);
        txtCelular.setEditable(false);
        txaEnfermedad.setEditable(false);
        dateFecha_Ingreso.setEnabled(false);
        txtCosto.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCompletar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEnfermedad = new javax.swing.JTextArea();
        txtApellidos = new javax.swing.JTextField();
        dateFecha_Ingreso = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxOdontologo = new javax.swing.JComboBox<>();
        cbxTratamiento = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        btn_Crear_Tratamiento = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        dateFecha_Creacion = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        checkEditarPrecio = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 526));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(670, 526));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 526));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("DNI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 20));

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 85, 131));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NUEVO TRATAMIENTO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 310, 40));

        btnCompletar.setBackground(new java.awt.Color(30, 85, 131));
        btnCompletar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCompletar.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletar.setText("COMPLETAR");
        btnCompletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 170, 20));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("APELLIDOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 180, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("EDAD");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 70, 20));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 70, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CELULAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 120, 20));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("ENFERMEDAD/ALERGIA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 360, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("FECHA DE INGRESO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 150, 20));

        txaEnfermedad.setColumns(20);
        txaEnfermedad.setLineWrap(true);
        txaEnfermedad.setRows(5);
        txaEnfermedad.setWrapStyleWord(true);
        txaEnfermedad.setMinimumSize(new java.awt.Dimension(113, 20));
        txaEnfermedad.setPreferredSize(new java.awt.Dimension(113, 20));
        jScrollPane1.setViewportView(txaEnfermedad);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 360, 50));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 180, 30));
        jPanel1.add(dateFecha_Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 150, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 620, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("FECHA DE CREACION");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 190, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("TRATAMIENTO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 190, 20));

        cbxOdontologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOdontologoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxOdontologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 210, 40));

        jPanel1.add(cbxTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("COSTO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 50, 30));

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 120, 30));

        btn_Crear_Tratamiento.setBackground(new java.awt.Color(30, 85, 131));
        btn_Crear_Tratamiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Crear_Tratamiento.setForeground(new java.awt.Color(255, 255, 255));
        btn_Crear_Tratamiento.setText("CREAR TRATAMIENTO");
        btn_Crear_Tratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Crear_TratamientoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Crear_Tratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 200, 40));

        btnCancelar.setBackground(new java.awt.Color(30, 85, 131));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 140, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 390, 20));

        jButton5.setBackground(new java.awt.Color(30, 85, 131));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("COMPLETAR");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 110, 30));

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane3.setViewportView(txaDescripcion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 390, 110));
        jPanel1.add(dateFecha_Creacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 210, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("ODONTÓLOGO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 190, 20));

        checkEditarPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkEditarPrecio.setForeground(new java.awt.Color(51, 51, 51));
        checkEditarPrecio.setText("EDITAR PRECIO");
        checkEditarPrecio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEditarPrecioItemStateChanged(evt);
            }
        });
        checkEditarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEditarPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(checkEditarPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btn_Crear_TratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Crear_TratamientoActionPerformed
        String dni = txtDni.getText();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el DNI del paciente.");
        } else {
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String odontologo = cbxOdontologo.getSelectedItem().toString();
            String tratamiento = cbxTratamiento.getSelectedItem().toString();
            String descripcion = txaDescripcion.getText();
            Date fecha_creacion_tratamiento = dateFecha_Creacion.getDate();
            //  //
            int citas = 0;
            //  //
            Double costo = Double.valueOf(txtCosto.getText());

            //Establecer deuda inicial
            Double deuda = Double.valueOf(txtCosto.getText());

            Connection c = null;
            PreparedStatement ps = null;
            String query = "INSERT INTO TB_TRATAMIENTOS (dni_paciente, nombre_paciente, apellido_paciente, odontologo, tratamiento, descripcion, fecha_creacion, citas, costo, deuda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                c = Conexion.getConnection();
                ps = c.prepareStatement(query);
                ps.setString(1, dni);
                ps.setString(2, nombre);
                ps.setString(3, apellidos);
                ps.setString(4, odontologo);
                ps.setString(5, tratamiento);
                ps.setString(6, descripcion);
                ps.setDate(7, new java.sql.Date(fecha_creacion_tratamiento.getTime()));
                ps.setInt(8, citas);
                ps.setDouble(9, costo);
                ps.setDouble(10, deuda);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Tratamiento agregado exitosamente.");
                    // Limpiar campos o realizar otras acciones necesarias
                } else {
                    JOptionPane.showMessageDialog(this, "Error al agregar el tratamiento.");
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
    }//GEN-LAST:event_btn_Crear_TratamientoActionPerformed

    private void btnCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarActionPerformed

        String dni = txtDni.getText();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM TB_PACIENTES WHERE dni_paciente = ?";

        try {
            c = Conexion.getConnection();
            ps = c.prepareStatement(query);
            ps.setString(1, dni);
            rs = ps.executeQuery();

            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre_paciente"));
                txtApellidos.setText(rs.getString("apellido_paciente"));
                txtEdad.setText(rs.getString("edad_paciente"));
                txaEnfermedad.setText(rs.getString("enfermedad_paciente"));
                txtCelular.setText(rs.getString("celular_paciente"));
                dateFecha_Ingreso.setDate(rs.getTimestamp("fecha_inscripcion"));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un paciente con el DNI proporcionado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_btnCompletarActionPerformed

    private void cbxOdontologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOdontologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOdontologoActionPerformed

    private void checkEditarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEditarPrecioActionPerformed

    }//GEN-LAST:event_checkEditarPrecioActionPerformed

    private void checkEditarPrecioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEditarPrecioItemStateChanged
        if (checkEditarPrecio.isSelected()) {
            // Habilitar la edición del txtCosto
            txtCosto.setEditable(true);
        } else {
            // Deshabilitar la edición del txtCosto
            txtCosto.setEditable(false);
        }
    }//GEN-LAST:event_checkEditarPrecioItemStateChanged

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new F_Nuevo_Tratamiento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Nuevo_Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCompletar;
    private javax.swing.JButton btn_Crear_Tratamiento;
    public javax.swing.JComboBox<String> cbxOdontologo;
    public javax.swing.JComboBox<String> cbxTratamiento;
    private javax.swing.JCheckBox checkEditarPrecio;
    public com.toedter.calendar.JDateChooser dateFecha_Creacion;
    public com.toedter.calendar.JDateChooser dateFecha_Ingreso;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextArea txaDescripcion;
    public javax.swing.JTextArea txaEnfermedad;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCelular;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void Cargar_PrecioTratamiento(String nombreTratamiento) throws SQLException {
        // Conecta a la base de datos
        String query = "SELECT costo_tratamiento FROM TB_LISTA_TRATAMIENTOS WHERE nombre_tratamiento = ?";
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = Conexion.getConnection();
            ps = c.prepareStatement(query);
            ps.setString(1, nombreTratamiento);
            try {
                rs = ps.executeQuery();
                if (rs.next()) {
                    double costo = rs.getDouble("costo_tratamiento");
                    txtCosto.setText(String.valueOf(costo));
                } else {
                    // Si no se encuentra el precio, puedes manejarlo de alguna manera (por ejemplo, establecerlo en blanco)
                    txtCosto.setText("");
                }
            } catch (SQLException eq) {
                eq.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja cualquier error que ocurra durante la consulta
            JOptionPane.showMessageDialog(this, "Error al obtener el precio del tratamiento.");
        } finally {
            if (c != null) {
                c.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    private void cbxTratamientoItemStateChanged(java.awt.event.ItemEvent evt) throws SQLException {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String nombreTratamiento = cbxTratamiento.getSelectedItem().toString();
            Cargar_PrecioTratamiento(nombreTratamiento);
        }
    }

    private void Cargar_Combos_Tratamientos(JComboBox c) throws SQLException {
        DefaultComboBoxModel box_Tratamiento = new DefaultComboBoxModel();
        c.setModel(box_Tratamiento);
        Lista_Tratamientos lista = new Lista_Tratamientos();
        Connection connect = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            connect = Conexion.getConnection();
            ps = connect.createStatement();
            rs = ps.executeQuery("SELECT nombre_tratamiento FROM TB_LISTA_TRATAMIENTOS");
            while (rs.next()) {
                Tratamientos trata = new Tratamientos();
                trata.setNombre_tratamiento(rs.getString(1));
                lista.AgregarTratamiento(trata);
                box_Tratamiento.addElement(trata.getNombre_tratamiento());
            }

        } catch (Exception e) {
            System.out.println("Error" + e);;
        } finally {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    private void Cargar_Combos_Odontologos(JComboBox c) throws SQLException {
        DefaultComboBoxModel box_Odontologos = new DefaultComboBoxModel();
        c.setModel(box_Odontologos);
        Lista_Odontologos lista = new Lista_Odontologos();
        Connection connect = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            connect = Conexion.getConnection();
            s = connect.createStatement();
            rs = s.executeQuery("SELECT nombre_odontologo FROM TB_ODONTOLOGOS");
            while (rs.next()) {
                Odontologos odontologos = new Odontologos();
                odontologos.setNombre_odontologo(rs.getString(1));
                lista.Agregar_Odontologos(odontologos);
                box_Odontologos.addElement(odontologos.getNombre_odontologo());
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        } finally {
            if (connect != null) {
                connect.close();
            }
            if (s != null) {
                s.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
}
