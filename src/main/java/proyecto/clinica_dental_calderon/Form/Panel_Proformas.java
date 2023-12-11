package proyecto.clinica_dental_calderon.Form;

//PDF
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

        dateChooserFechaInicio.getDateEditor().setEnabled(false);
        dateChooserFechaFin.getDateEditor().setEnabled(false);
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
        dateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        btnLimpiarFiltro = new javax.swing.JButton();
        btnAplicarFiltro = new javax.swing.JButton();
        dateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1365, 770));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 770));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 134, 203));
        jLabel1.setText("PROFORMAS DE SERVICIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 840, 80));

        jbtnVista_General.setBackground(new java.awt.Color(30, 85, 131));
        jbtnVista_General.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnVista_General.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVista_General.setText("VISTA GENERAL ");
        jbtnVista_General.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnVista_General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVista_GeneralActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnVista_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 200, 40));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 1100, 540));

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
        jPanel1.add(jbtnNueva_Proforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 40));

        jbtnActualizar.setBackground(new java.awt.Color(62, 134, 203));
        jbtnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnActualizar.setText("ACTUALIZAR DATOS");
        jbtnActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, 150, 30));
        jPanel1.add(dateChooserFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, 190, 40));

        btnLimpiarFiltro.setBackground(new java.awt.Color(62, 202, 151));
        btnLimpiarFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarFiltro.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarFiltro.setText("LIMPIAR FILTRO");
        btnLimpiarFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 170, 40));

        btnAplicarFiltro.setBackground(new java.awt.Color(62, 202, 151));
        btnAplicarFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAplicarFiltro.setForeground(new java.awt.Color(255, 255, 255));
        btnAplicarFiltro.setText("APLICAR FILTRO");
        btnAplicarFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAplicarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFiltroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAplicarFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 170, 40));
        jPanel1.add(dateChooserFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, 190, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("HASTA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 190, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("DE:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, 190, 20));

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

    private void limpiarCampos() {
        nueva_proforma.txtNombres.setText("");
        nueva_proforma.txtApellidos.setText("");
        nueva_proforma.txtTelefono.setText("");
        nueva_proforma.txtDireccion.setText("");
        nueva_proforma.txtEdad.setText("");
        nueva_proforma.txtEdadPane.setText("");
        nueva_proforma.txtApellidoPane.setText("");
        nueva_proforma.txtNombrePane.setText("");
        nueva_proforma.jtxaAntecedentes.setText("");
        nueva_proforma.jtxaMotivo.setText("");
        nueva_proforma.txtCostoUnitario.setText("");
        nueva_proforma.txtCosto.setText("");

        nueva_proforma.cbxTratamientos.setSelectedIndex(0);

        DefaultTableModel model = (DefaultTableModel) nueva_proforma.tblTratamiento.getModel();
        model.setRowCount(0);

        nueva_proforma.spnCantidad.setValue(0);
        nueva_proforma.TextPaneVistaPrevia.setText("");

    }
    private void jbtnNueva_ProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNueva_ProformaActionPerformed

        nueva_proforma.setVisible(true);
        nueva_proforma.btnGuardar_Proforma.setVisible(true);
        limpiarCampos();

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

    private void jbtnVista_GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVista_GeneralActionPerformed
        nueva_proforma.setVisible(true);
        nueva_proforma.btnGuardar_Proforma.setVisible(false);
    }//GEN-LAST:event_jbtnVista_GeneralActionPerformed

    private void btnAplicarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFiltroActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (dateChooserFechaInicio.getDate() == null || dateChooserFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione ambas fechas de inicio y fin.");
            return;
        }

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) jtblProformas.getModel());
        jtblProformas.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
            public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
                try {
                    java.sql.Date rowDate = (java.sql.Date) entry.getValue(4); // Cambia el índice a 4, la columna de fecha

                    // Convertir la fecha a cadena para comparar
                    String rowDateStr = sdf.format(rowDate);
                    Date fechaInicio = sdf.parse(sdf.format(dateChooserFechaInicio.getDate()));
                    Date fechaFin = sdf.parse(sdf.format(dateChooserFechaFin.getDate()));

                    // Ajustar la fecha de inicio al inicio del día (00:00:00)
                    Calendar calInicio = Calendar.getInstance();
                    calInicio.setTime(fechaInicio);
                    calInicio.set(Calendar.HOUR_OF_DAY, 0);
                    calInicio.set(Calendar.MINUTE, 0);
                    calInicio.set(Calendar.SECOND, 0);
                    fechaInicio = calInicio.getTime();

                    // Ajustar la fecha de fin al final del día (23:59:59)
                    Calendar calFin = Calendar.getInstance();
                    calFin.setTime(fechaFin);
                    calFin.set(Calendar.HOUR_OF_DAY, 23);
                    calFin.set(Calendar.MINUTE, 59);
                    calFin.set(Calendar.SECOND, 59);
                    fechaFin = calFin.getTime();

                    // Filtro por rango de fechas
                    return (rowDate.after(fechaInicio) || rowDate.equals(fechaInicio))
                            && (rowDate.before(fechaFin) || rowDate.equals(fechaFin));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };

        sorter.setRowFilter(filter);
    }//GEN-LAST:event_btnAplicarFiltroActionPerformed

    private void btnLimpiarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroActionPerformed
        DefaultTableModel model = (DefaultTableModel) jtblProformas.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        jtblProformas.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }//GEN-LAST:event_btnLimpiarFiltroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarFiltro;
    private javax.swing.JButton btnLimpiarFiltro;
    private com.toedter.calendar.JDateChooser dateChooserFechaFin;
    private com.toedter.calendar.JDateChooser dateChooserFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnNueva_Proforma;
    private javax.swing.JButton jbtnVista_General;
    private javax.swing.JTable jtblProformas;
    // End of variables declaration//GEN-END:variables
}
