package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import javax.swing.JTable;

import javax.swing.SpinnerNumberModel;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import proyecto.clinica_dental_calderon.DB.Conexion;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Panel_Citas extends javax.swing.JPanel {

    public Connection connection;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    String actualizar = "/images/actualizar.png";

    ImageIcon actualizarImagen = new ImageIcon(Panel_Citas.class.getResource(actualizar));

    public void abrirConexion() throws SQLException {
        // Verifica si ya hay una conexión abierta antes de abrir una nueva
        if (connection == null || connection.isClosed()) {
            // Abre una nueva conexión si no hay ninguna abierta
            Conexion cx = new Conexion(); // Instancia de tu clase de conexión
            connection = cx.getConnection(); // Método para obtener la conexión
        }
        // Resto del código para usar la conexión en el panel de pacientes...
    }

    public void cerrarRecursos() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close(); // Cierra la conexión si está abierta
        }
    }

    public Panel_Citas() throws SQLException {
        initComponents();
        abrirConexion();
        Mostrar_Datos_Tabla_Citas(tableCitas);
        deshabilitarEdicionTabla(tableCitas);

        btnActualizarDatos.setIcon(actualizarImagen);
    }

    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    // Método para mostrar los datos de la tabla TB_CITAS en la JTable tableCitas
    public void Mostrar_Datos_Tabla_Citas(JTable tableCitas) {
        DefaultTableModel tableModel = (DefaultTableModel) tableCitas.getModel();
        // Limpia la tabla para asegurarte de que no haya datos anteriores
        tableModel.setRowCount(0);

        // Realiza una consulta SQL para obtener los datos de TB_CITAS
        String query = "SELECT id_cita, id_tratamiento, dni_paciente, fecha, hora, odontologo, descripcion, estado_cita FROM TB_CITAS";

        try { // Reemplaza esto con tu lógica real de conexión a la base de datos

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCita = rs.getInt("id_cita");
                int idTratamiento = rs.getInt("id_tratamiento");
                String dniPaciente = rs.getString("dni_paciente");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                String odontologo = rs.getString("odontologo");
                String descripcion = rs.getString("descripcion");
                String estadoCita = rs.getString("estado_cita");

                // Agrega una nueva fila a la tabla con los datos obtenidos
                tableModel.addRow(new Object[]{idCita, idTratamiento, dniPaciente, fecha, hora, odontologo, descripcion, estadoCita});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla de citas.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrear_Cita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCitas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxBusquedaCitas = new javax.swing.JComboBox<>();
        btnReprogramar_Cita = new javax.swing.JButton();
        btnVista_General_Cita = new javax.swing.JButton();
        btnActualizar_Cita = new javax.swing.JButton();
        btnBusquedaCitas = new javax.swing.JButton();
        btnActualizarDatos = new javax.swing.JButton();
        btnLimpiarFiltro = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1365, 770));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 770));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 134, 203));
        jLabel1.setText("CITAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 90));

        btnCrear_Cita.setBackground(new java.awt.Color(62, 202, 151));
        btnCrear_Cita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrear_Cita.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear_Cita.setText("CREAR NUEVA CITA");
        btnCrear_Cita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrear_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrear_CitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 180, 40));

        tableCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Cita", "N° Tratamiento", "Dni", "Fecha", "Hora", "Odontólogo", "Descripción", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tableCitas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1320, 480));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(62, 134, 203));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("FILTROS DE BÚSQUEDA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, 230, 30));

        cbxBusquedaCitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "COMPLETADO", "CANCELADO" }));
        jPanel1.add(cbxBusquedaCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 220, 230, 40));

        btnReprogramar_Cita.setBackground(new java.awt.Color(62, 202, 151));
        btnReprogramar_Cita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReprogramar_Cita.setForeground(new java.awt.Color(255, 255, 255));
        btnReprogramar_Cita.setText("REPROGRAMAR CITA");
        btnReprogramar_Cita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReprogramar_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReprogramar_CitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnReprogramar_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, 40));

        btnVista_General_Cita.setBackground(new java.awt.Color(62, 202, 151));
        btnVista_General_Cita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVista_General_Cita.setForeground(new java.awt.Color(255, 255, 255));
        btnVista_General_Cita.setText("VISTA GENERAL DE LA CITA");
        btnVista_General_Cita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVista_General_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVista_General_CitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVista_General_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 230, 40));

        btnActualizar_Cita.setBackground(new java.awt.Color(62, 202, 151));
        btnActualizar_Cita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar_Cita.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar_Cita.setText("ACTUALIZAR ESTADO DE LA CITA");
        btnActualizar_Cita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar_Cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar_CitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar_Cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 270, 40));

        btnBusquedaCitas.setBackground(new java.awt.Color(62, 134, 203));
        btnBusquedaCitas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBusquedaCitas.setForeground(new java.awt.Color(255, 255, 255));
        btnBusquedaCitas.setText("APLICAR FILTRO");
        btnBusquedaCitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBusquedaCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaCitasActionPerformed(evt);
            }
        });
        jPanel1.add(btnBusquedaCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, 150, 40));

        btnActualizarDatos.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizarDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarDatos.setBorder(null);
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, 32, 32));

        btnLimpiarFiltro.setBackground(new java.awt.Color(62, 134, 203));
        btnLimpiarFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarFiltro.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarFiltro.setText("LIMPIAR FILTRO");
        btnLimpiarFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrear_CitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrear_CitaActionPerformed
        try {
            F_Agendar_Cita agendar_cita = new F_Agendar_Cita();
            agendar_cita.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Tratamientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCrear_CitaActionPerformed

    private void btnActualizar_CitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar_CitaActionPerformed
        int selectedRow = tableCitas.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para actualizar el estado de la cita.");
        } else {

            int numeroCita = Integer.parseInt(tableCitas.getValueAt(selectedRow, 0).toString());
            int numeroTratamiento;
            Object value = tableCitas.getValueAt(selectedRow, 1);

            if (value instanceof Integer) {
                numeroTratamiento = (int) value;
            } else if (value instanceof String) {
                numeroTratamiento = Integer.parseInt((String) value);
            } else {
                // Manejar el caso en el que no sea ni Integer ni String
                numeroTratamiento = 0; // O cualquier valor predeterminado que desees
            }

            // Realizar una consulta a la base de datos para obtener el nombre del tratamiento
            String nombreTratamiento = obtenerNombreTratamiento(numeroTratamiento);

            F_Actualizar_Cita actualizarCita = new F_Actualizar_Cita(numeroCita);

            actualizarCita.setVisible(true);
            actualizarCita.setResizable(false);
            actualizarCita.setLocationRelativeTo(null);

            actualizarCita.txtNumeroCita.setEditable(false);
            actualizarCita.txtNumeroTratamiento.setEditable(false);
            actualizarCita.txtTratamiento.setEditable(false);

            actualizarCita.txtNumeroCita.setText(String.valueOf(numeroCita));
            actualizarCita.txtNumeroTratamiento.setText(String.valueOf(numeroTratamiento));
            actualizarCita.txtTratamiento.setText(nombreTratamiento);

        }
    }//GEN-LAST:event_btnActualizar_CitaActionPerformed

    private void btnReprogramar_CitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReprogramar_CitaActionPerformed
        int selectedRow = tableCitas.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para reprogramar la cita.");
            return;
        }
        String Estado = tableCitas.getValueAt(selectedRow, 7).toString();

        if (Estado.equals("COMPLETADO")) {
            JOptionPane.showMessageDialog(this, "No se puede reprogramar una cita que ya ha sido completada.");
        } else if (Estado.equals("CANCELADO")) {
            JOptionPane.showMessageDialog(this, "No se puede reprogramar una cita que ya ha sido cancelada.");
        } else {
            // Obtener el ID de la cita seleccionada
            Object value = tableCitas.getValueAt(selectedRow, 1);
            int numeroTratamiento;
            if (value instanceof Integer) {
                numeroTratamiento = (int) value;
            } else if (value instanceof String) {
                numeroTratamiento = Integer.parseInt((String) value);
            } else {
                // Manejo de error o valor predeterminado si el tipo no es Integer o String
                numeroTratamiento = 0; // Por ejemplo, aquí podrías establecer un valor predeterminado
            }

            // Obtener los datos de la cita desde la tabla
            int numeroCita = Integer.parseInt(tableCitas.getValueAt(selectedRow, 0).toString());

            String dni = tableCitas.getValueAt(selectedRow, 2).toString();
            String odontologo = tableCitas.getValueAt(selectedRow, 5).toString();
            Date fecha_actual = (Date) tableCitas.getValueAt(selectedRow, 3);
            // Obtener la hora completa de la base de datos
            Time horaCompleta = (Time) tableCitas.getValueAt(selectedRow, 4);

            // Dividir la hora en horas y minutos
            Calendar cal = Calendar.getInstance();
            cal.setTime(horaCompleta);
            int hora = cal.get(Calendar.HOUR_OF_DAY);
            int minutos = cal.get(Calendar.MINUTE);

            // Realizar una consulta a la base de datos para obtener el nombre del tratamiento
            String nombreTratamiento = obtenerNombreTratamiento(numeroTratamiento);

            // Pasar los datos a la ventana de reprogramación
            F_Reprogramar_Cita reprogramarCita = new F_Reprogramar_Cita(numeroCita);

            // Crear un SpinnerNumberModel para el Spinner de Horas
            SpinnerNumberModel hourSpinnerModel = new SpinnerNumberModel(0, 0, 23, 1);
            reprogramarCita.spinnerNueva_Hora.setModel(hourSpinnerModel);

            // Crear un SpinnerNumberModel para el Spinner de Minuto
            SpinnerNumberModel minuteSpinnerModel = new SpinnerNumberModel(0, 0, 59, 1);
            reprogramarCita.spinnerNuevo_Minutos.setModel(minuteSpinnerModel);

            JSpinner.NumberEditor editorHora = new JSpinner.NumberEditor(reprogramarCita.spinnerNueva_Hora, "00");
            JFormattedTextField txtFieldHora = editorHora.getTextField();
            ((NumberFormatter) txtFieldHora.getFormatter()).setAllowsInvalid(false);
            reprogramarCita.spinnerNueva_Hora.setEditor(editorHora);

            JSpinner.NumberEditor editorMinuto = new JSpinner.NumberEditor(reprogramarCita.spinnerNuevo_Minutos, "00");
            JFormattedTextField txtFieldMinuto = editorMinuto.getTextField();
            ((NumberFormatter) txtFieldMinuto.getFormatter()).setAllowsInvalid(false);
            reprogramarCita.spinnerNuevo_Minutos.setEditor(editorMinuto);

            reprogramarCita.dateNueva_Fecha.getDateEditor().setEnabled(false);

            reprogramarCita.txtNumeroCita.setEditable(false);
            reprogramarCita.txtTratamiento.setEditable(false);
            reprogramarCita.txtNumeroTratamiento.setEditable(false);
            reprogramarCita.txtDNI.setEditable(false);
            reprogramarCita.txtOdontologo.setEditable(false);
            reprogramarCita.dateChooserFechaCita.setEnabled(false);
            reprogramarCita.spinnerHora.setEnabled(false);
            reprogramarCita.spinnerMinutos.setEnabled(false);

            reprogramarCita.setVisible(true);
            reprogramarCita.setResizable(false);
            reprogramarCita.setLocationRelativeTo(null);

            // Configurar los campos en la ventana de reprogramación
            reprogramarCita.txtNumeroCita.setText(String.valueOf(numeroCita));
            // Configurar el campo de texto con el nombre del tratamiento
            reprogramarCita.txtTratamiento.setText(nombreTratamiento);
            reprogramarCita.txtNumeroTratamiento.setText(String.valueOf(numeroTratamiento));
            reprogramarCita.txtDNI.setText(dni);
            reprogramarCita.txtOdontologo.setText(odontologo);
            reprogramarCita.dateChooserFechaCita.setDate(fecha_actual);
            reprogramarCita.spinnerHora.setValue(hora);
            reprogramarCita.spinnerMinutos.setValue(minutos);
        }
    }//GEN-LAST:event_btnReprogramar_CitaActionPerformed

    private String obtenerNombreTratamiento(int idTratamiento) {
        String nombreTratamiento = null;
        // Realizar una consulta a la base de datos para obtener el nombre del tratamiento
        // Reemplaza "tuConsultaSQL" con la consulta adecuada
        String consultaSQL = "SELECT tratamiento FROM TB_TRATAMIENTOS WHERE id_tratamiento = ?";

        try {
            ps = connection.prepareStatement(consultaSQL);
            ps.setInt(1, idTratamiento);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreTratamiento = rs.getString("tratamiento");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreTratamiento;
    }

    private void btnVista_General_CitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVista_General_CitaActionPerformed
        int selectedRow = tableCitas.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para mostrar los datos.");
        } else {

            F_Mostrar_Datos_Cita mostrar_datos_cita = new F_Mostrar_Datos_Cita();

            mostrar_datos_cita.setVisible(true);
            mostrar_datos_cita.setResizable(false);
            mostrar_datos_cita.setLocationRelativeTo(null);

            mostrar_datos_cita.txtDni.setEditable(false);
            mostrar_datos_cita.txtNombre.setEditable(false);
            mostrar_datos_cita.txtApellidos.setEditable(false);
            mostrar_datos_cita.txtEdad.setEditable(false);
            mostrar_datos_cita.txtCelular.setEditable(false);
            mostrar_datos_cita.txtOdontologo.setEditable(false);
            mostrar_datos_cita.txaDescripcion.setEditable(false);
            mostrar_datos_cita.txtTratamiento.setEditable(false);
            mostrar_datos_cita.txaEnfermedad.setEditable(false);

            mostrar_datos_cita.dateCita.setEnabled(false);
            mostrar_datos_cita.SpinnerHora.setEnabled(false);
            mostrar_datos_cita.SpinnerMinuto.setEnabled(false);

            String idTratamiento = tableCitas.getValueAt(selectedRow, 1).toString();
            String dni = tableCitas.getValueAt(selectedRow, 2).toString();

            Date fecha_cita = (Date) tableCitas.getValueAt(selectedRow, 3);
            Time hora_cita = (Time) tableCitas.getValueAt(selectedRow, 4);
            String odontologo = tableCitas.getValueAt(selectedRow, 5).toString();
            String descripcion = tableCitas.getValueAt(selectedRow, 6).toString();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(hora_cita);
            int horas = calendar.get(Calendar.HOUR_OF_DAY);
            int minutos = calendar.get(Calendar.MINUTE);

            mostrar_datos_cita.txtOdontologo.setText(odontologo);
            mostrar_datos_cita.txaDescripcion.setText(descripcion);
            mostrar_datos_cita.dateCita.setDate(fecha_cita);
            mostrar_datos_cita.SpinnerHora.setValue(horas);
            mostrar_datos_cita.SpinnerMinuto.setValue(minutos);

            String queryTratamiento = "SELECT tratamiento FROM TB_TRATAMIENTOS WHERE id_tratamiento = ?";
            String queryPaciente = "SELECT nombre_paciente, apellido_paciente, edad_paciente, enfermedad_paciente, celular_paciente, fecha_inscripcion FROM TB_PACIENTES WHERE dni_paciente = ?";

            try {
                ps = connection.prepareStatement(queryPaciente);
                ps.setString(1, dni);
                rs = ps.executeQuery();

                if (rs.next()) {
                    mostrar_datos_cita.txtDni.setText(dni);
                    mostrar_datos_cita.txtNombre.setText(rs.getString("nombre_paciente"));
                    mostrar_datos_cita.txtApellidos.setText(rs.getString("apellido_paciente"));
                    mostrar_datos_cita.txtEdad.setText(rs.getString("edad_paciente"));
                    mostrar_datos_cita.txaEnfermedad.setText(rs.getString("enfermedad_paciente"));
                    mostrar_datos_cita.txtCelular.setText(rs.getString("celular_paciente"));
                    mostrar_datos_cita.dateFecha_Ingreso.setDate(rs.getDate("fecha_inscripcion"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                ps = connection.prepareStatement(queryTratamiento);
                ps.setString(1, idTratamiento);
                rs = ps.executeQuery();

                if (rs.next()) {
                    mostrar_datos_cita.txtTratamiento(rs.getString("tratamiento"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnVista_General_CitaActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        actualizarTablaCitas();
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void btnBusquedaCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaCitasActionPerformed
        String filtroSeleccionado = (String) cbxBusquedaCitas.getSelectedItem();
        mostrarTratamientosFiltrados(filtroSeleccionado);
    }//GEN-LAST:event_btnBusquedaCitasActionPerformed

    private void btnLimpiarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroActionPerformed
        actualizarTablaCitas();
    }//GEN-LAST:event_btnLimpiarFiltroActionPerformed

    private void mostrarTratamientosFiltrados(String filtro) {
        DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
        model.setRowCount(0);

        String query = "SELECT * FROM TB_CITAS WHERE estado_cita = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, filtro);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] rowData = {
                        rs.getString("id_cita"),
                        rs.getString("id_tratamiento"),
                        rs.getString("dni_paciente"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("odontologo"),
                        rs.getString("descripcion"),
                        rs.getString("estado_cita")
                    };
                    model.addRow(rowData);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Maneja la excepción según tu lógica de la aplicación
        }
    }

    void actualizarTablaCitas() {
        DefaultTableModel tableModel = (DefaultTableModel) tableCitas.getModel();
        tableModel.setRowCount(0); // Limpia los datos existentes en la tabla

        String query = "SELECT * FROM TB_CITAS";

        try {
            abrirConexion();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getInt("id_cita"),
                    rs.getInt("id_tratamiento"),
                    rs.getString("dni_paciente"),
                    rs.getDate("fecha"),
                    rs.getTime("hora"),
                    rs.getString("odontologo"),
                    rs.getString("descripcion"),
                    rs.getString("estado_cita")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnActualizar_Cita;
    private javax.swing.JButton btnBusquedaCitas;
    private javax.swing.JButton btnCrear_Cita;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JButton btnReprogramar_Cita;
    private javax.swing.JButton btnVista_General_Cita;
    private javax.swing.JComboBox<String> cbxBusquedaCitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableCitas;
    // End of variables declaration//GEN-END:variables
}
