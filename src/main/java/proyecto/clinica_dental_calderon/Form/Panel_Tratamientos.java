package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.clinica_dental_calderon.DB.Conexion;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Panel_Tratamientos extends javax.swing.JPanel {

    public Connection connection;
    public PreparedStatement ps;
    public ResultSet rs;

    String actualizar = "/images/actualizar.png";

    ImageIcon actualizarImagen = new ImageIcon(Panel_Tratamientos.class.getResource(actualizar));

    public Panel_Tratamientos() throws SQLException {
        initComponents();
        btnActualizar.setIcon(actualizarImagen);
        Mostrar_Datos_Tabla();
    }

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

    public void Mostrar_Datos_Tabla() {
        DefaultTableModel dt = (DefaultTableModel) tableTratamientos.getModel();

        dt.setRowCount(0);

        String query = "SELECT id_tratamiento, dni_paciente, nombre_paciente, apellido_paciente, odontologo, tratamiento, fecha_creacion, costo, estado_pago, estado_tratamiento FROM TB_TRATAMIENTOS";

        try {
            abrirConexion();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idTratamiento = rs.getInt("id_tratamiento");
                String dni = rs.getString("dni_paciente");
                String nombre = rs.getString("nombre_paciente");
                String apellido = rs.getString("apellido_paciente");
                String odontologo = rs.getString("odontologo");
                String tratamiento = rs.getString("tratamiento");
                String fecha_creacion = rs.getString("fecha_creacion");
                double costo = rs.getDouble("costo");
                String estado_pago = rs.getString("estado_pago");
                String estado_tratamiento = rs.getString("estado_tratamiento");

                dt.addRow(new Object[]{idTratamiento, dni, nombre, apellido, odontologo, tratamiento, fecha_creacion, costo, estado_pago, estado_tratamiento});
            }
            rs.close();
            ps.close();

        } catch (SQLException esql) {
            esql.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla de tratamientos.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevo_Tratamiento = new javax.swing.JButton();
        btnAplicarFiltro = new javax.swing.JButton();
        cbxBusquedaTratamientos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_VistaGeneral = new javax.swing.JButton();
        btn_ActualizarEstado = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTratamientos = new javax.swing.JTable();
        btnLimpiarFiltro = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1365, 770));
        setPreferredSize(new java.awt.Dimension(1365, 770));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 770));
        jPanel1.setPreferredSize(new java.awt.Dimension(1365, 770));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 134, 203));
        jLabel1.setText("TRATAMIENTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 500, 80));

        btnNuevo_Tratamiento.setBackground(new java.awt.Color(62, 202, 151));
        btnNuevo_Tratamiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo_Tratamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo_Tratamiento.setText("NUEVA TRATAMIENTO");
        btnNuevo_Tratamiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo_Tratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo_TratamientoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo_Tratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, 40));

        btnAplicarFiltro.setBackground(new java.awt.Color(62, 134, 203));
        btnAplicarFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAplicarFiltro.setForeground(new java.awt.Color(255, 255, 255));
        btnAplicarFiltro.setText("APLICAR FILTRO");
        btnAplicarFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAplicarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFiltroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAplicarFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 170, 40));

        cbxBusquedaTratamientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "COMPLETADO", "CANCELADO" }));
        jPanel1.add(cbxBusquedaTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 220, 180, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 85, 131));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("ORDENAR POR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 190, 100, 30));

        btn_VistaGeneral.setBackground(new java.awt.Color(62, 202, 151));
        btn_VistaGeneral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_VistaGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btn_VistaGeneral.setText("VISTA GENERAL");
        btn_VistaGeneral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_VistaGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VistaGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btn_VistaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 170, 40));

        btn_ActualizarEstado.setBackground(new java.awt.Color(62, 202, 151));
        btn_ActualizarEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ActualizarEstado.setForeground(new java.awt.Color(255, 255, 255));
        btn_ActualizarEstado.setText("ACTUALIZAR ESTADO");
        btn_ActualizarEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ActualizarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ActualizarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 200, 40));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, 32, 32));

        tableTratamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Dni", "Nombre", "Apellido", "Odontologo", "Tratamiento", "Fecha de creación", "Costo", "Estado de la deuda", "Estado del tratamiento"
            }
        ));
        jScrollPane2.setViewportView(tableTratamientos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1330, 480));

        btnLimpiarFiltro.setBackground(new java.awt.Color(62, 134, 203));
        btnLimpiarFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarFiltro.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarFiltro.setText("LIMPIAR FILTROS");
        btnLimpiarFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 160, 40));

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

    private void btnNuevo_TratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo_TratamientoActionPerformed
        try {
            F_Nuevo_Tratamiento nuevo_tratamiento = new F_Nuevo_Tratamiento();
            nuevo_tratamiento.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Tratamientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNuevo_TratamientoActionPerformed

    private void btn_VistaGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VistaGeneralActionPerformed
        // Obtén la fila seleccionada en la tabla
        int selectedRow = tableTratamientos.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro de la tabla para ver los detalles del tratamiento.");
        } else {
            int idTratamiento = Integer.parseInt(tableTratamientos.getValueAt(selectedRow, 0).toString());

            // Realiza una consulta SQL para obtener los detalles del tratamiento con el ID seleccionado
            String query = "SELECT dni_paciente, nombre_paciente, apellido_paciente, tratamiento, odontologo, descripcion, fecha_creacion, citas, costo, deuda, estado_pago, estado_tratamiento FROM TB_TRATAMIENTOS WHERE id_tratamiento = ?";

            try {
                ps = connection.prepareStatement(query);
                ps.setInt(1, idTratamiento);
                rs = ps.executeQuery();

                if (rs.next()) {
                    String dni = rs.getString("dni_paciente");
                    String nombre = rs.getString("nombre_paciente");
                    String apellido = rs.getString("apellido_paciente");
                    String tratamiento = rs.getString("tratamiento");
                    String odontologo = rs.getString("odontologo");
                    String descripcion = rs.getString("descripcion");
                    Date fechaCreacion = rs.getDate("fecha_creacion");
                    int citas = rs.getInt("citas");
                    double costo = rs.getDouble("costo");
                    double deuda = rs.getDouble("deuda");
                    String estadoPago = rs.getString("estado_pago");
                    String estadoTratamiento = rs.getString("estado_tratamiento");

                    F_Vista_General_Tratamiento vista_tratamiento = new F_Vista_General_Tratamiento();
                    vista_tratamiento.setVisible(true);
                    vista_tratamiento.setResizable(false);
                    vista_tratamiento.setLocationRelativeTo(null);

                    vista_tratamiento.txtId.setText(Integer.toString(idTratamiento));
                    vista_tratamiento.txtDni.setText(dni);
                    vista_tratamiento.txtNombre.setText(nombre);
                    vista_tratamiento.txtApellido.setText(apellido);
                    vista_tratamiento.txtTratamiento.setText(tratamiento);
                    vista_tratamiento.txtOdontologo.setText(odontologo);
                    vista_tratamiento.jtxaDesc.setText(descripcion);
                    vista_tratamiento.jdateCreacion.setDate(fechaCreacion);
                    vista_tratamiento.txtCitas.setText(Integer.toString(citas));
                    vista_tratamiento.txtCosto.setText(Double.toString(costo));
                    vista_tratamiento.txtDeuda.setText(Double.toString(deuda));
                    vista_tratamiento.txtEstado_Deuda.setText(estadoPago);
                    vista_tratamiento.txtEstado_Tratamiento.setText(estadoTratamiento);

                    //no-editable
                    vista_tratamiento.txtId.setEditable(false);
                    vista_tratamiento.txtDni.setEditable(false);
                    vista_tratamiento.txtNombre.setEditable(false);
                    vista_tratamiento.txtApellido.setEditable(false);
                    vista_tratamiento.txtTratamiento.setEditable(false);
                    vista_tratamiento.txtOdontologo.setEditable(false);
                    vista_tratamiento.jtxaDesc.setEditable(false);
                    vista_tratamiento.jdateCreacion.setEnabled(false);
                    vista_tratamiento.txtCitas.setEditable(false);
                    vista_tratamiento.txtCosto.setEditable(false);
                    vista_tratamiento.txtDeuda.setEditable(false);
                    vista_tratamiento.txtEstado_Deuda.setEditable(false);
                    vista_tratamiento.txtEstado_Tratamiento.setEditable(false);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al cargar los detalles del tratamiento.");
            }
        }
    }//GEN-LAST:event_btn_VistaGeneralActionPerformed

    private void btn_ActualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarEstadoActionPerformed
        int selectedRow = tableTratamientos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro de la tabla para actualizar su estado.");
            return; // Salir del método si no se seleccionó ninguna fila
        }

        Object value = tableTratamientos.getValueAt(selectedRow, 0);
        int idTratamiento;

        try {
            idTratamiento = Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID del tratamiento seleccionado no es un número válido.");
            return; // Salir del método si el valor no se puede convertir a Integer
        }

        String nu_tratamiento = value.toString();
        String dni = tableTratamientos.getValueAt(selectedRow, 1).toString();
        String tratamiento = tableTratamientos.getValueAt(selectedRow, 5).toString();

        F_Actualizar_Tratamiento actualizar_tratamiento = new F_Actualizar_Tratamiento();

        actualizar_tratamiento.setVisible(true);
        actualizar_tratamiento.setResizable(false);
        actualizar_tratamiento.setLocationRelativeTo(null);

        actualizar_tratamiento.txtN_Tratamiento.setEditable(false);
        actualizar_tratamiento.txtDni.setEditable(false);
        actualizar_tratamiento.txtTratamiento.setEditable(false);

        actualizar_tratamiento.txtN_Tratamiento.setText(nu_tratamiento);
        actualizar_tratamiento.txtDni.setText(dni);
        actualizar_tratamiento.txtTratamiento.setText(tratamiento);
    }//GEN-LAST:event_btn_ActualizarEstadoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarTablaTratamientos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAplicarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFiltroActionPerformed
        String filtroSeleccionado = (String) cbxBusquedaTratamientos.getSelectedItem();
        mostrarTratamientosFiltrados(filtroSeleccionado);
    }//GEN-LAST:event_btnAplicarFiltroActionPerformed

    private void btnLimpiarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroActionPerformed
        actualizarTablaTratamientos();
    }//GEN-LAST:event_btnLimpiarFiltroActionPerformed

    private void mostrarTratamientosFiltrados(String filtro) {
        DefaultTableModel model = (DefaultTableModel) tableTratamientos.getModel();
        model.setRowCount(0);

        String query = "SELECT * FROM TB_TRATAMIENTOS WHERE estado_tratamiento = ?";

        try {
            ps = connection.prepareStatement(query); // Corregimos la asignación aquí
            ps.setString(1, filtro);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("id_tratamiento"),
                    rs.getString("dni_paciente"),
                    rs.getString("nombre_paciente"),
                    rs.getString("apellido_paciente"),
                    rs.getString("odontologo"),
                    rs.getString("tratamiento"),
                    rs.getDate("fecha_creacion"),
                    rs.getDouble("costo"),
                    rs.getString("estado_pago"),
                    rs.getString("estado_tratamiento")
                };
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Maneja la excepción según tu lógica de la aplicación
        }
    }

    void actualizarTablaTratamientos() {
        DefaultTableModel tableModel = (DefaultTableModel) tableTratamientos.getModel();
        tableModel.setRowCount(0); // Limpia los datos existentes en la tabla

        String query = "SELECT * FROM TB_TRATAMIENTOS";

        try {
            abrirConexion();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getInt("id_tratamiento"),
                    rs.getString("dni_paciente"),
                    rs.getString("nombre_paciente"),
                    rs.getString("apellido_paciente"),
                    rs.getString("odontologo"),
                    rs.getString("tratamiento"),
                    rs.getDate("fecha_creacion"),
                    rs.getDouble("costo"),
                    rs.getString("estado_pago"),
                    rs.getString("estado_tratamiento")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAplicarFiltro;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JButton btnNuevo_Tratamiento;
    private javax.swing.JButton btn_ActualizarEstado;
    private javax.swing.JButton btn_VistaGeneral;
    private javax.swing.JComboBox<String> cbxBusquedaTratamientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTratamientos;
    // End of variables declaration//GEN-END:variables
}
