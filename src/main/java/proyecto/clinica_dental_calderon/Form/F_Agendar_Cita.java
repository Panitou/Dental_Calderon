package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import proyecto.clinica_dental_calderon.DB.Conexion;
import proyecto.clinica_dental_calderon.controlador_Odontologos.Lista_Odontologos;
import proyecto.clinica_dental_calderon.controlador_Odontologos.Odontologos;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class F_Agendar_Cita extends javax.swing.JFrame {

    // Crear el modelo de tabla para los tratamientos
    DefaultTableModel tableModel = new DefaultTableModel();

    public F_Agendar_Cita() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Asignar el modelo de tabla al JTable
        tableTratamiento.setModel(tableModel);
        Deshabilitar_Campos();
        Cargar_Combos_Odontologos(cbxOdontologo);
        // Crear un SpinnerNumberModel para el Spinner de Hora
        SpinnerNumberModel hourSpinnerModel = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerHora.setModel(hourSpinnerModel);

        // Crear un SpinnerNumberModel para el Spinner de Minuto
        SpinnerNumberModel minuteSpinnerModel = new SpinnerNumberModel(0, 0, 59, 1);
        SpinnerMinuto.setModel(minuteSpinnerModel);
    }

    private void Cargar_Combos_Odontologos(JComboBox c) {
        DefaultComboBoxModel box_Odontologos = new DefaultComboBoxModel();
        c.setModel(box_Odontologos);
        Lista_Odontologos lista = new Lista_Odontologos();
        Connection connect = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            connect = Conexion.getConnection();
            ps = connect.createStatement();
            rs = ps.executeQuery("SELECT nombre_odontologo FROM TB_ODONTOLOGOS");
            while (rs.next()) {
                Odontologos odontologos = new Odontologos();
                odontologos.setNombre_odontologo(rs.getString(1));
                lista.Agregar_Odontologos(odontologos);
                box_Odontologos.addElement(odontologos.getNombre_odontologo());
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnAgregar_Cita = new javax.swing.JButton();
        btnCompletar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEnfermedad = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        cbxOdontologo = new javax.swing.JComboBox<>();
        dateFecha_Ingreso = new com.toedter.calendar.JDateChooser();
        dateCita = new com.toedter.calendar.JDateChooser();
        SpinnerMinuto = new javax.swing.JSpinner();
        SpinnerHora = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTratamiento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(840, 698));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(840, 698));
        jPanel1.setPreferredSize(new java.awt.Dimension(840, 698));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGENDAR CITA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 270, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("DNI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 20));
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        btnAgregar_Cita.setBackground(new java.awt.Color(30, 85, 131));
        btnAgregar_Cita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar_Cita.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar_Cita.setText("AGREGAR");
        btnAgregar_Cita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_CitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, 140, 40));

        btnCompletar.setBackground(new java.awt.Color(30, 85, 131));
        btnCompletar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCompletar.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletar.setText("COMPLETAR");
        btnCompletar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCompletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 110, 30));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 170, 30));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 140, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ENFERMEDAD O ALERGIA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 220, 20));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 180, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("APELLIDOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 180, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("NOMBRE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 170, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CELULAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 120, 20));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 120, 30));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 70, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("EDAD");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 70, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("FECHA DE INGRESO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 150, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 800, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("FECHA DE LA CITA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 170, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 150, 20));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(360, 50));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(360, 50));

        txaEnfermedad.setColumns(20);
        txaEnfermedad.setLineWrap(true);
        txaEnfermedad.setRows(5);
        txaEnfermedad.setWrapStyleWord(true);
        txaEnfermedad.setPreferredSize(new java.awt.Dimension(113, 20));
        jScrollPane1.setViewportView(txaEnfermedad);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 360, 50));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("ODONTÓLOGO");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 220, 20));

        jPanel1.add(cbxOdontologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 220, 40));
        jPanel1.add(dateFecha_Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 150, 30));
        jPanel1.add(dateCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 170, 40));
        jPanel1.add(SpinnerMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, 80, 30));
        jPanel1.add(SpinnerHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 80, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("HORA DE LA CITA");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 170, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("MINUTOS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 80, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("HORAS");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 80, 20));

        txaDescripcion.setColumns(20);
        txaDescripcion.setLineWrap(true);
        txaDescripcion.setRows(5);
        txaDescripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 360, 180));

        tableTratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "Tratamiento", "Descripción", "Fecha De Creación", "Costo"
            }
        ));
        jScrollPane3.setViewportView(tableTratamiento);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 800, 160));

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

    private void btnCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarActionPerformed

        String dni = txtDni.getText();

        Connection c = null;

        PreparedStatement psPacientes = null;
        ResultSet rsPacientes = null;
        String queryPacientes = "SELECT * FROM TB_PACIENTES WHERE dni_paciente = ?";

        PreparedStatement psTratamientos = null;
        ResultSet rsTratamientos = null;
        String queryTratamientos = "SELECT id_tratamiento, tratamiento, descripcion, fecha_creacion, costo, estado_pago, estado_tratamiento FROM TB_TRATAMIENTOS WHERE dni_paciente = ?";

        try {
            c = Conexion.getConnection();
            psPacientes = c.prepareStatement(queryPacientes);
            psPacientes.setString(1, dni);
            rsPacientes = psPacientes.executeQuery();

            if (rsPacientes.next()) {
                // Si se encontró un paciente, llenar los campos de datos de la cita
                txtNombre.setText(rsPacientes.getString("nombre_paciente"));
                txtApellidos.setText(rsPacientes.getString("apellido_paciente"));
                txtEdad.setText(rsPacientes.getString("edad_paciente"));
                txaEnfermedad.setText(rsPacientes.getString("enfermedad_paciente"));
                txtCelular.setText(rsPacientes.getString("celular_paciente"));
                dateFecha_Ingreso.setDate(rsPacientes.getTimestamp("fecha_inscripcion"));

                // Consultar tratamientos del paciente
                psTratamientos = c.prepareStatement(queryTratamientos);
                psTratamientos.setString(1, dni);
                rsTratamientos = psTratamientos.executeQuery();

                tableModel.addColumn("N°");
                tableModel.addColumn("Tratamiento");
                tableModel.addColumn("Descripción");
                tableModel.addColumn("Fecha De Creación");
                tableModel.addColumn("Costo");
                tableModel.addColumn("Estado deuda");
                tableModel.addColumn("Estado del tratamiento");

                // Ajustar la longitud preferida de las columnas
                tableTratamiento.getColumnModel().getColumn(0).setPreferredWidth(30); // N°
                tableTratamiento.getColumnModel().getColumn(1).setPreferredWidth(100); // Tratamiento
                tableTratamiento.getColumnModel().getColumn(2).setPreferredWidth(220); // Descripción
                tableTratamiento.getColumnModel().getColumn(3).setPreferredWidth(70); // Fecha De Creación
                tableTratamiento.getColumnModel().getColumn(4).setPreferredWidth(50); // Costo
                tableTratamiento.getColumnModel().getColumn(5).setPreferredWidth(80); //Estado de la deuda
                tableTratamiento.getColumnModel().getColumn(6).setPreferredWidth(80); //Estado del tratamiento

                while (rsTratamientos.next()) {
                    Object[] rowData = {
                        rsTratamientos.getInt("id_tratamiento"),
                        rsTratamientos.getString("tratamiento"),
                        rsTratamientos.getString("descripcion"),
                        rsTratamientos.getDate("fecha_creacion"),
                        rsTratamientos.getDouble("costo"),
                        rsTratamientos.getString("estado_pago"),
                        rsTratamientos.getString("estado_tratamiento")
                    };
                    tableModel.addRow(rowData);
                }

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
                if (psPacientes != null) {
                    psPacientes.close();
                }
                if (psTratamientos != null) {
                    psTratamientos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnCompletarActionPerformed

    private void btnAgregar_CitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_CitaActionPerformed
        java.util.Date currentDate = new java.util.Date();
        Date selectedDate = new java.sql.Date(dateCita.getDate().getTime());
        Connection c = null;
        PreparedStatement ps = null;

        if (txtDni.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || dateCita.getDate() == null
                || SpinnerHora.getValue() == null || SpinnerMinuto.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.");
        } else {
            int selectedHour = (int) SpinnerHora.getValue();
            int selectedMinute = (int) SpinnerMinuto.getValue();
            if (selectedDate.before(currentDate)) {
                JOptionPane.showMessageDialog(this, "La fecha de la cita no puede ser en días anteriores.");
            } else if (selectedHour == 0) {
                JOptionPane.showMessageDialog(this, "La hora no puede ser 0. Por favor, seleccione una hora válida.");
            } else {
                String dni = txtDni.getText();
                Time selectedTime = new java.sql.Time(selectedHour, selectedMinute, 0);
                String odontologo = cbxOdontologo.getSelectedItem().toString();
                String descripcion = txaDescripcion.getText();

                if (tableTratamiento.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(this, "Por favor, seleccione un tratamiento de la tabla.");
                } else {
                    
                    String query = "INSERT INTO TB_CITAS (id_tratamiento, dni_paciente, nombre_paciente, apellido_paciente, fecha, hora, odontologo, descripcion, estado_cita) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'PENDIENTE')";

                    try {
                        c = Conexion.getConnection();
                        ps = c.prepareStatement(query);

                        // Obtener el ID del tratamiento seleccionado
                        int filaSeleccionada = tableTratamiento.getSelectedRow();
                        int idTratamientoSeleccionado = (int) tableModel.getValueAt(filaSeleccionada, 0);

                        // Establecer los parámetros en la cita
                        ps.setInt(1, idTratamientoSeleccionado);
                        ps.setString(2, dni);
                        ps.setString(3, txtNombre.getText());
                        ps.setString(4, txtApellidos.getText());
                        ps.setDate(5, selectedDate);
                        ps.setTime(6, selectedTime);
                        ps.setString(7, odontologo);
                        ps.setString(8, descripcion);

                        int rowsAffected = ps.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(this, "Cita agregada exitosamente.");

                            // Actualizar la columna citas en la tabla TB_TRATAMIENTOS
                            String updateQuery = "UPDATE TB_TRATAMIENTOS SET citas = citas + 1 WHERE id_tratamiento = ?";
                            ps = c.prepareStatement(updateQuery);
                            ps.setInt(1, idTratamientoSeleccionado);
                            ps.executeUpdate();

                            // Limpieza o acciones adicionales
                            // ...
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al agregar la cita.");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error al agregar la cita.");
                    } finally {
                        try {
                            if (ps != null) {
                                ps.close();
                            }
                            if (c != null) {
                                c.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregar_CitaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Agendar_Cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerHora;
    private javax.swing.JSpinner SpinnerMinuto;
    private javax.swing.JButton btnAgregar_Cita;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCompletar;
    private javax.swing.JComboBox<String> cbxOdontologo;
    private com.toedter.calendar.JDateChooser dateCita;
    private com.toedter.calendar.JDateChooser dateFecha_Ingreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableTratamiento;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextArea txaEnfermedad;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void Deshabilitar_Campos() {
        txtNombre.setEditable(false);
        txtApellidos.setEditable(false);
        txtEdad.setEditable(false);
        txtCelular.setEditable(false);
        txaEnfermedad.setEditable(false);
        dateFecha_Ingreso.setEnabled(false);
    }
}
