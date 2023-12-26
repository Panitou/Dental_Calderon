package proyecto.clinica_dental_calderon.Form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import proyecto.clinica_dental_calderon.DB.Conexion;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Panel_Pagos extends javax.swing.JPanel {

    public Connection connection;
    public PreparedStatement ps;
    public ResultSet rs;

    String actualizar = "/images/actualizar.png";

    ImageIcon actualizarImagen = new ImageIcon(Panel_Pagos.class.getResource(actualizar));

    F_Historial_General historial = new F_Historial_General();

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

    public Panel_Pagos() throws SQLException {
        initComponents();
        abrirConexion();

        JTableHeader header = tablePagos.getTableHeader();
        header.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

        //Width
        tablePagos.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablePagos.getColumnModel().getColumn(1).setPreferredWidth(20);
        tablePagos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tablePagos.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablePagos.getColumnModel().getColumn(4).setPreferredWidth(250);
        tablePagos.getColumnModel().getColumn(5).setPreferredWidth(20);
        tablePagos.getColumnModel().getColumn(6).setPreferredWidth(20);
        tablePagos.getColumnModel().getColumn(7).setPreferredWidth(50);

        tablePagos.getTableHeader().setOpaque(false);
        tablePagos.getTableHeader().setBackground(new Color(62, 134, 203));
        tablePagos.getTableHeader().setForeground(Color.WHITE);
        tablePagos.setRowHeight(30);

        Dimension headerSize = header.getPreferredSize();
        headerSize.height = 30;
        header.setPreferredSize(headerSize);
        header.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        Mostrar_Datos_Tabla_Pagos();
        deshabilitarEdicionTabla(tablePagos);

        btnActualizar.setIcon(actualizarImagen);
    }

    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    public void Mostrar_Datos_Tabla_Pagos() {
        DefaultTableModel dt = (DefaultTableModel) tablePagos.getModel();
        ps = null;
        rs = null;

        dt.setRowCount(0);

        String query = "SELECT id_tratamiento, dni_paciente, nombre_paciente, apellido_paciente, tratamiento, costo,"
                + "deuda, estado_pago FROM TB_TRATAMIENTOS";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idTratamiento = rs.getInt("id_tratamiento");
                String dni = rs.getString("dni_paciente");
                String nombre = rs.getString("nombre_paciente");
                String apellido = rs.getString("apellido_paciente");
                String tratamiento = rs.getString("tratamiento");
                double costo = rs.getDouble("costo");
                double deuda = rs.getDouble("deuda");
                String estado_pago = rs.getString("estado_pago");

                dt.addRow(new Object[]{idTratamiento, dni, nombre, apellido, tratamiento, costo, deuda, estado_pago});
            }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePagos = new javax.swing.JTable();
        btnCancelar_Deuda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxBusquedaPagos = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        jbtnHistorial_Paciente = new javax.swing.JButton();
        jbtnRegistro_General = new javax.swing.JButton();
        btnAplicarfiltro = new javax.swing.JButton();
        btnLimpiarFiltro = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1365, 770));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 770));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 134, 203));
        jLabel1.setText("PAGOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 90));

        tablePagos.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        tablePagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Dni", "Nombre", "Apellidos", "Tratamiento", "Costo", "Deuda", "Estado de Deuda"
            }
        ));
        jScrollPane1.setViewportView(tablePagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 267, 1320, 440));

        btnCancelar_Deuda.setBackground(new java.awt.Color(62, 202, 151));
        btnCancelar_Deuda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar_Deuda.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar_Deuda.setText("CANCELAR DEUDA");
        btnCancelar_Deuda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar_Deuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_DeudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar_Deuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 190, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(62, 134, 203));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("FILTROS DE BUSQUEDA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, 230, 30));

        cbxBusquedaPagos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "PAGADO" }));
        jPanel1.add(cbxBusquedaPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 220, 180, 40));

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, 32, 32));

        jbtnHistorial_Paciente.setBackground(new java.awt.Color(62, 202, 151));
        jbtnHistorial_Paciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnHistorial_Paciente.setForeground(new java.awt.Color(255, 255, 255));
        jbtnHistorial_Paciente.setText("VER HISTORIAL DEL TRATAMIENTO");
        jbtnHistorial_Paciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnHistorial_Paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHistorial_PacienteActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnHistorial_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 290, 40));

        jbtnRegistro_General.setBackground(new java.awt.Color(62, 202, 151));
        jbtnRegistro_General.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnRegistro_General.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegistro_General.setText("HISTORIAL GENERAL DE PAGOS");
        jbtnRegistro_General.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnRegistro_General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegistro_GeneralActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnRegistro_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 720, 260, 40));

        btnAplicarfiltro.setBackground(new java.awt.Color(62, 134, 203));
        btnAplicarfiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAplicarfiltro.setForeground(new java.awt.Color(255, 255, 255));
        btnAplicarfiltro.setText("APLICAR FILTRO");
        btnAplicarfiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAplicarfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarfiltroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAplicarfiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 160, 40));

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
        jPanel1.add(btnLimpiarFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar_DeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_DeudaActionPerformed
        int selectedRow = tablePagos.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro de la tabla para poder realizar la cancelación de la deuda");
        } else {
            // Obtener deuda
            double deuda = (double) tablePagos.getValueAt(selectedRow, 6);

            if (deuda == 0) {
                JOptionPane.showMessageDialog(this, "La deuda ya fue cancelada completamente.");
            } else {
                // Obtener id
                int id_tratamiento = Integer.parseInt(tablePagos.getValueAt(selectedRow, 0).toString());

                // Obtener datos para colocarlos en los txtFields
                String id = tablePagos.getValueAt(selectedRow, 0).toString();
                String dni_paciente = tablePagos.getValueAt(selectedRow, 1).toString();
                String nombre_paciente = tablePagos.getValueAt(selectedRow, 2).toString();
                String apellido_paciente = tablePagos.getValueAt(selectedRow, 3).toString();
                String tratamiento_paciente = tablePagos.getValueAt(selectedRow, 4).toString();
                double costo_tratamiento = (double) tablePagos.getValueAt(selectedRow, 5);

                F_Cancelar_Deuda cancelar_deuda = new F_Cancelar_Deuda(id_tratamiento);

                cancelar_deuda.setVisible(true);
                cancelar_deuda.setResizable(false);
                cancelar_deuda.setLocationRelativeTo(null);

                cancelar_deuda.txtACancelar.setDocument(new Panel_Pagos.CostoFilter());

                // Deshabilitar campos
                cancelar_deuda.txtId.setEditable(false);
                cancelar_deuda.txtDni.setEditable(false);
                cancelar_deuda.txtNombre.setEditable(false);
                cancelar_deuda.txtApellidos.setEditable(false);
                cancelar_deuda.txtTratamiento.setEditable(false);
                cancelar_deuda.txtCosto.setEditable(false);
                cancelar_deuda.txtDeuda.setEditable(false);

                // Agregar datos en los txtFields
                cancelar_deuda.txtId.setText(id);
                cancelar_deuda.txtDni.setText(dni_paciente);
                cancelar_deuda.txtNombre.setText(nombre_paciente);
                cancelar_deuda.txtApellidos.setText(apellido_paciente);
                cancelar_deuda.txtTratamiento.setText(tratamiento_paciente);
                cancelar_deuda.txtCosto.setText(String.valueOf(costo_tratamiento));
                cancelar_deuda.txtDeuda.setText(String.valueOf(deuda));
                Cargar_Metodos_Pago(cancelar_deuda.cbxMetodos);

                // Obtener la fecha y hora actual
                Date fechaActual = new Date();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

                // Establecer la fecha actual en el jdateFecha
                cancelar_deuda.lblFecha.setText(String.valueOf(formatoFecha.format(fechaActual)));

                // Establecer la hora actual en el txtHora
                cancelar_deuda.lblHora.setText(formatoHora.format(fechaActual));
            }
        }
    }//GEN-LAST:event_btnCancelar_DeudaActionPerformed

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

    private void Cargar_Metodos_Pago(JComboBox<String> c) {
        DefaultComboBoxModel<String> box_Metodos = new DefaultComboBoxModel<>();
        c.setModel(box_Metodos);

        try {
            // Consulta para obtener los métodos de pago desde la base de datos
            String query = "SELECT metodo_pago FROM TB_METODO_PAGO";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            // Agrega los métodos de pago al JComboBox
            while (rs.next()) {
                String metodoPago = rs.getString("metodo_pago");
                box_Metodos.addElement(metodoPago);
            }

            // Cierra los recursos
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarTablaPagos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jbtnHistorial_PacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHistorial_PacienteActionPerformed
        int selectedRow = tablePagos.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro para ver el historial de pagos.");
        } else {
            int idtratamiento = Integer.parseInt(tablePagos.getValueAt(selectedRow, 0).toString());

            // Realizar la consulta a la base de datos
            String query = "SELECT id_pago, fecha_pago, hora_pago, dinero_ingresado, metodo_pago FROM TB_HISTORIAL_PAGOS WHERE id_tratamiento=?";

            try {
                ps = connection.prepareStatement(query);
                ps.setInt(1, idtratamiento);
                rs = ps.executeQuery();

                // Crear modelo de tabla
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID Pago");
                model.addColumn("Fecha de Pago");
                model.addColumn("Hora de Pago");
                model.addColumn("Dinero Ingresado");
                model.addColumn("Método de Pago");

                // Llenar modelo con datos de la consulta
                while (rs.next()) {
                    int idPago = rs.getInt("id_pago");
                    Date fechaPago = rs.getDate("fecha_pago");
                    Time horaPago = rs.getTime("hora_pago");
                    double dineroIngresado = rs.getDouble("dinero_ingresado");
                    String metodoPago = rs.getString("metodo_pago");

                    model.addRow(new Object[]{idPago, fechaPago, horaPago, dineroIngresado, metodoPago});
                }
                F_Historial_Paciente registropaciente = new F_Historial_Paciente();
                registropaciente.setVisible(true);
                // Asignar modelo a la tabla
                registropaciente.tblHistorial_Paciente.setModel(model);

                // Llenar JLabels con datos de la primera tabla
                String nombre = (String) tablePagos.getValueAt(selectedRow, 2);
                String apellido = (String) tablePagos.getValueAt(selectedRow, 3);
                String dni = (String) tablePagos.getValueAt(selectedRow, 1);
                double costo = (double) tablePagos.getValueAt(selectedRow, 5);
                double deuda = (double) tablePagos.getValueAt(selectedRow, 6);

                registropaciente.lblNombrePaciente.setText(nombre + " " + apellido);
                registropaciente.lblDniPaciente.setText(dni);
                registropaciente.lblMontoTotal.setText(String.valueOf(costo));
                registropaciente.lblMontoRestante.setText(String.valueOf(deuda));
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al cargar el historial de pagos.");
            }
        }


    }//GEN-LAST:event_jbtnHistorial_PacienteActionPerformed

    private void jbtnRegistro_GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegistro_GeneralActionPerformed
        // Crear instancia de F_Historial_General
        F_Historial_General registrogeneral = new F_Historial_General();
        registrogeneral.setVisible(true);

        // Obtener la fecha y hora actual
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        // Establecer la fecha actual en el lblFecha
        registrogeneral.lblFecha.setText(String.valueOf(formatoFecha.format(fechaActual)));

        // Establecer la hora actual en el lblHora
        registrogeneral.lblHora.setText(formatoHora.format(fechaActual));

        // Cargar datos en la tabla desde la base de datos
        Mostrar_Datos_Tabla_Historial_Pagos(registrogeneral);
        Cargar_Metodos_Pago(registrogeneral.cbxFiltro_Metodos_Pago);
    }//GEN-LAST:event_jbtnRegistro_GeneralActionPerformed

    private void btnAplicarfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarfiltroActionPerformed
        String filtroSeleccionado = (String) cbxBusquedaPagos.getSelectedItem();
        mostrarTratamientosFiltrados(filtroSeleccionado);
    }//GEN-LAST:event_btnAplicarfiltroActionPerformed

    private void mostrarTratamientosFiltrados(String filtro) {
        DefaultTableModel model = (DefaultTableModel) tablePagos.getModel();
        model.setRowCount(0);

        String query = "SELECT * FROM TB_TRATAMIENTOS WHERE estado_pago = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, filtro);

            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    Object[] rowData = {
                        rs.getString("id_tratamiento"),
                        rs.getString("dni_paciente"),
                        rs.getString("nombre_paciente"),
                        rs.getString("apellido_paciente"),
                        rs.getString("tratamiento"),
                        rs.getDouble("costo"),
                        rs.getDouble("deuda"),
                        rs.getString("estado_pago"),};
                    model.addRow(rowData);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Maneja la excepción según tu lógica de la aplicación
        }
    }


    private void btnLimpiarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroActionPerformed
        actualizarTablaPagos();
    }//GEN-LAST:event_btnLimpiarFiltroActionPerformed

    public void Mostrar_Datos_Tabla_Historial_Pagos(F_Historial_General historial) {
        DefaultTableModel dt = (DefaultTableModel) historial.tblRegistroGeneral.getModel();

        dt.setRowCount(0);

        String query = "SELECT id_pago, id_tratamiento, fecha_pago, hora_pago, dni_paciente, nombre_paciente, apellido_paciente, dinero_ingresado, metodo_pago FROM TB_HISTORIAL_PAGOS";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idpago = rs.getInt("id_pago");
                int idtratamiento = rs.getInt("id_tratamiento");
                Date fecha = rs.getDate("fecha_pago");
                Time hora = rs.getTime("hora_pago");
                String dni = rs.getString("dni_paciente");
                String nombre = rs.getString("nombre_paciente");
                String apellido = rs.getString("apellido_paciente");
                Double dinero_ingresado = rs.getDouble("dinero_ingresado");
                String metodo_pago = rs.getString("metodo_pago");

                dt.addRow(new Object[]{idpago, idtratamiento, fecha, hora, dni, nombre, apellido, dinero_ingresado, metodo_pago});
            }

        } catch (SQLException esql) {
            esql.printStackTrace();
            JOptionPane.showMessageDialog(historial, "Error al cargar los datos de la tabla de tratamientos: " + esql.getMessage());
        } finally {
            try {
                // Cerrar recursos
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAplicarfiltro;
    private javax.swing.JButton btnCancelar_Deuda;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JComboBox<String> cbxBusquedaPagos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnHistorial_Paciente;
    private javax.swing.JButton jbtnRegistro_General;
    public javax.swing.JTable tablePagos;
    // End of variables declaration//GEN-END:variables

    void actualizarTablaPagos() {
        DefaultTableModel tableModel = (DefaultTableModel) tablePagos.getModel();
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
                    rs.getString("tratamiento"),
                    rs.getDouble("costo"),
                    rs.getDouble("deuda"),
                    rs.getString("estado_pago")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla.");
        }
    }
}
