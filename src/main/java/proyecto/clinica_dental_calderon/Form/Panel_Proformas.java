package proyecto.clinica_dental_calderon.Form;

//PDF
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author jcald
 */
public class Panel_Proformas extends javax.swing.JPanel {

    public Connection connection;
    public PreparedStatement ps;
    public ResultSet rs;

    String actualizar = "/images/actualizar.png";
    ImageIcon actualizarImagen = new ImageIcon(Panel_Proformas.class.getResource(actualizar));

    String buscar = "/images/buscar.png";
    String limpiar = "/images/borrar.png";

    ImageIcon buscarImagen = new ImageIcon(Panel_Pacientes.class.getResource(buscar));
    ImageIcon limpiarImage = new ImageIcon(Panel_Pacientes.class.getResource(limpiar));

    String nombre = "/images/linea.png";
    ImageIcon LineaNombreImage = new ImageIcon(Panel_Proformas.class.getResource(nombre));
    String logoimagencirclex200 = "/images/LogoParaProforma.png";
    ImageIcon iconImagen = new ImageIcon(Panel_Proformas.class.getResource(logoimagencirclex200));

    F_Nueva_Proforma nueva_proforma = new F_Nueva_Proforma();

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

    public Panel_Proformas() throws SQLException {
        initComponents();
        abrirConexion();
        Mostrar_Datos_Tabla();
        deshabilitarEdicionTabla(jtblProformas);
        jbtnActualizar.setIcon(actualizarImagen);

        btnBuscar.setIcon(buscarImagen);
        btnLimpiar.setIcon(limpiarImage);
    }

    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    void Mostrar_Datos_Tabla() {
        DefaultTableModel dt = (DefaultTableModel) jtblProformas.getModel();

        dt.setRowCount(0);

        String query = "SELECT id_proforma, telefono_paciente, nombre_paciente, apellido_paciente, fecha_registro, hora_registro FROM TB_PROFORMAS";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idProforma = rs.getInt("id_proforma");
                String telefono = rs.getString("telefono_paciente");
                String nombre = rs.getString("nombre_paciente");
                String apellido = rs.getString("apellido_paciente");
                Date fecha_registro = rs.getDate("fecha_registro");
                String hora_registro = rs.getString("hora_registro");

                dt.addRow(new Object[]{idProforma, telefono, nombre, apellido, fecha_registro, hora_registro});
            }

        } catch (SQLException esql) {
            esql.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla de proformas.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtnVista_General = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProformas = new javax.swing.JTable();
        jbtnNueva_Proforma = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1365, 770));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 770));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 134, 203));
        jLabel1.setText("PROFORMAS DE SERVICIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 840, 80));

        jbtnVista_General.setBackground(new java.awt.Color(62, 202, 151));
        jbtnVista_General.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnVista_General.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVista_General.setText("VER PROFORMA");
        jbtnVista_General.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnVista_General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVista_GeneralActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnVista_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 220, 40));

        jtblProformas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Telefono", "Nombre", "Apellidos", "Fecha", "Hora"
            }
        ));
        jScrollPane1.setViewportView(jtblProformas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 1100, 540));

        jbtnNueva_Proforma.setBackground(new java.awt.Color(62, 202, 151));
        jbtnNueva_Proforma.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnNueva_Proforma.setForeground(new java.awt.Color(255, 255, 255));
        jbtnNueva_Proforma.setText("NUEVA PROFORMA");
        jbtnNueva_Proforma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnNueva_Proforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNueva_ProformaActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnNueva_Proforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 220, 40));

        jbtnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        jbtnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnActualizar.setBorder(null);
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, 32, 32));

        txtId.setBorder(null);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 170, 170, 40));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Buscar por N°");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, 170, 20));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 170, 40, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 170, 40, 40));

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

    public int obtenerProximoID() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Establece la conexión con tu base de datos
            connection = Conexion.getConnection();// Reemplaza esto con tu lógica para obtener la conexión

            // Consulta para obtener el último ID
            String query = "SELECT MAX(id_proforma) AS id_proforma FROM TB_PROFORMAS";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            int ultimoID = 0;

            if (rs.next()) {
                ultimoID = rs.getInt(1);
            }

            // Suma 1 al último ID para obtener el próximo ID
            return ultimoID + 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Manejo de errores
        } finally {
            // Cierra los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void jbtnNueva_ProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNueva_ProformaActionPerformed
        try {
            F_Nueva_Proforma proforma = new F_Nueva_Proforma();
            proforma.setVisible(true);
            proforma.btnGuardar_Proforma.setVisible(true);
            int proxID = obtenerProximoID();
            proforma.txtId.setText(String.valueOf(proxID));
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Proformas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtnNueva_ProformaActionPerformed

    void actualizarTablaProformas() {
        DefaultTableModel tableModel = (DefaultTableModel) jtblProformas.getModel();
        tableModel.setRowCount(0); // Limpia los datos existentes en la tabla

        String query = "SELECT id_proforma, telefono_paciente, nombre_paciente, apellido_paciente, fecha_registro, hora_registro FROM TB_PROFORMAS";

        try {
            abrirConexion();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getInt("id_proforma"),
                    rs.getString("telefono_paciente"),
                    rs.getString("nombre_paciente"),
                    rs.getString("apellido_paciente"),
                    rs.getDate("fecha_registro"),
                    rs.getString("hora_registro")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla.");
        }
    }

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        actualizarTablaProformas();
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    // Método para construir la tabla en HTML
    private String construirTablaHTML(String tratamientos, String cantidades, String costosUnitarios, String subtotales, double costofinal) {
        StringBuilder tablaHTML = new StringBuilder("<html><head><style>"
                + "table {border-collapse: collapse; width: 100%;}"
                + "th, td {text-align: left; padding: 2px; font-size: 9px; border-right: none; font-family: Arial;}"
                + "th {background-color: #00A0E1; color: #ffffff;}"
                + "td {border-bottom: 1px solid #00354B;}"
                + "</style></head><body>");

        tablaHTML.append("<table><tr><th>TRATAMIENTOS</th><th>CANT.</th><th>P/U</th><th>S.TOTAL</th></tr>");

        // Procesar los datos y construir la tabla en HTML
        String[] tratamientosArray = tratamientos.split(",");
        String[] cantidadesArray = cantidades.split(",");
        String[] costosUnitariosArray = costosUnitarios.split(",");
        String[] subtotalesArray = subtotales.split(",");

        // Suponiendo que todas las matrices tienen la misma longitud
        for (int i = 0; i < tratamientosArray.length; i++) {
            if (!tratamientosArray[i].isEmpty() && !cantidadesArray[i].isEmpty() && !costosUnitariosArray[i].isEmpty() && !subtotalesArray[i].isEmpty()) {
                tablaHTML.append("<tr>")
                        .append("<td>").append(tratamientosArray[i]).append("</td>")
                        .append("<td>").append(cantidadesArray[i]).append("</td>")
                        .append("<td>").append(costosUnitariosArray[i]).append("</td>")
                        .append("<td>").append(subtotalesArray[i]).append("</td>")
                        .append("</tr>");
            }
        }

        // Añadir la fila del costo final
        tablaHTML.append("<tr><td colspan='3'>Costo Final</td><td>").append(costofinal).append("</td></tr>");

        tablaHTML.append("</table></body></html>");
        return tablaHTML.toString();
    }


    private void jbtnVista_GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVista_GeneralActionPerformed

        int filaSeleccionada = jtblProformas.getSelectedRow();
        F_VistaPrevia_Proforma vistaprevia_proforma = new F_VistaPrevia_Proforma();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una proforma.");
        } else {
            int numeroProforma = Integer.parseInt(jtblProformas.getValueAt(filaSeleccionada, 0).toString());

            try {
                connection = Conexion.getConnection();
                String query = "SELECT * FROM TB_PROFORMAS WHERE id_proforma = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, numeroProforma);
                rs = ps.executeQuery();

                if (rs.next()) {
                    // Obtener datos de la proforma desde la consulta
                    int id = rs.getInt("id_proforma");
                    String nombrePaciente = rs.getString("nombre_paciente");
                    String apellidoPaciente = rs.getString("apellido_paciente");
                    String edadPaciente = rs.getString("edad_paciente");
                    String direccionPaciente = rs.getString("direccion_paciente");
                    String telefonoPaciente = rs.getString("telefono_paciente");
                    String antecedentesPaciente = rs.getString("antecedentes");
                    String motivoPaciente = rs.getString("motivo_consulta");
                    Date fechaRegistro = rs.getDate("fecha_registro");
                    Double costoFinal = rs.getDouble("total");

                    vistaprevia_proforma.setVisible(true);
                    vistaprevia_proforma.setLocationRelativeTo(null);
                    vistaprevia_proforma.setResizable(false);

                    //Deshabilitar campos
                    vistaprevia_proforma.txtNombrePane.setEditable(false);
                    vistaprevia_proforma.txtApellidoPane.setEditable(false);
                    vistaprevia_proforma.txtEdadPane.setEditable(false);
                    vistaprevia_proforma.txtDireccionPane.setEditable(false);
                    vistaprevia_proforma.txtTelefonoPane.setEditable(false);
                    vistaprevia_proforma.txtAntecedentesPane.setEditable(false);
                    vistaprevia_proforma.txtMotivoPane.setEditable(false);
                    vistaprevia_proforma.txtFechaPane.setEditable(false);
                    vistaprevia_proforma.TextPaneVistaPrevia.setEditable(false);

                    //Logo
                    vistaprevia_proforma.Lbllogo.setIcon(iconImagen);
                    
                    // Continúa obteniendo los demás campos
                    // Actualizar los campos con los datos de la proforma
                    vistaprevia_proforma.txtId.setText(String.valueOf(id));
                    vistaprevia_proforma.txtNombrePane.setText(nombrePaciente);
                    vistaprevia_proforma.txtApellidoPane.setText(apellidoPaciente);
                    vistaprevia_proforma.txtEdadPane.setText(String.valueOf(edadPaciente));
                    vistaprevia_proforma.txtDireccionPane.setText(direccionPaciente);
                    vistaprevia_proforma.txtTelefonoPane.setText(telefonoPaciente);
                    vistaprevia_proforma.txtAntecedentesPane.setText(antecedentesPaciente);
                    vistaprevia_proforma.txtMotivoPane.setText(motivoPaciente);
                    vistaprevia_proforma.txtFechaPane.setText(fechaRegistro.toString());

                    // Continúa actualizando los demás campos
                    // Obtener los datos separados por comas desde la base de datos
                    String tratamientos = rs.getString("tratamientos");
                    String cantidades = rs.getString("cantidades_tratamiento");
                    String costosUnitarios = rs.getString("costos_unitarios");
                    String subtotales = rs.getString("subtotales");

                    // Procesar los datos y construir la tabla en HTML
                    String tablaHTML = construirTablaHTML(tratamientos, cantidades, costosUnitarios, subtotales, costoFinal);

                    // Establecer el HTML en el TextPane
                    vistaprevia_proforma.TextPaneVistaPrevia.setContentType("text/html");
                    vistaprevia_proforma.TextPaneVistaPrevia.setText(tablaHTML);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Manejar cualquier excepción SQL aquí
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jbtnVista_GeneralActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idBusqueda = txtId.getText().trim();

        DefaultTableModel model = (DefaultTableModel) jtblProformas.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        jtblProformas.setRowSorter(rowSorter);

        if (idBusqueda.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            // Crear un filtro para el DNI en la columna correspondiente (supongamos que es la columna 3)
            rowSorter.setRowFilter(RowFilter.regexFilter(idBusqueda, 0));
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) jtblProformas.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        jtblProformas.setRowSorter(rowSorter);
        rowSorter.setRowFilter(null); // Elimina cualquier filtro aplicado
        txtId.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnNueva_Proforma;
    private javax.swing.JButton jbtnVista_General;
    private javax.swing.JTable jtblProformas;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
