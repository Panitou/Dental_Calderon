package proyecto.clinica_dental_calderon.Form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author jcald
 */
public class Panel_Inicio extends javax.swing.JPanel {

    String fondo = "/images/Opacidad.png";

    ImageIcon fondoImagen = new ImageIcon(F_Sistema.class.getResource(fondo));

    public Panel_Inicio() throws SQLException {
        initComponents();

        JTableHeader header = tblCitasHoy.getTableHeader();
        header.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

        //Width
        tblCitasHoy.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblCitasHoy.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblCitasHoy.getColumnModel().getColumn(2).setPreferredWidth(20);
        tblCitasHoy.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblCitasHoy.getColumnModel().getColumn(4).setPreferredWidth(10);
        tblCitasHoy.getColumnModel().getColumn(5).setPreferredWidth(300);
        tblCitasHoy.getColumnModel().getColumn(6).setPreferredWidth(30);

        tblCitasHoy.getTableHeader().setOpaque(false);
        tblCitasHoy.getTableHeader().setBackground(new Color(62, 134, 203));
        tblCitasHoy.getTableHeader().setForeground(Color.WHITE);
        tblCitasHoy.setRowHeight(30);

        Dimension headerSize = header.getPreferredSize();
        headerSize.height = 30;
        header.setPreferredSize(headerSize);
        header.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        lblFondo.setIcon(fondoImagen);

        Mostrar_Datos_Tabla_Citas_Hoy(tblCitasHoy);
        deshabilitarEdicionTabla(tblCitasHoy);
    }

    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    public void actualizarTabla() throws SQLException {
        DefaultTableModel tableModel = (DefaultTableModel) tblCitasHoy.getModel();
        tableModel.setRowCount(0); // Limpia los datos existentes en la tabla

        String query = "SELECT id_cita, id_tratamiento, dni_paciente, fecha, hora, odontologo, descripcion, estado_cita FROM TB_CITAS WHERE DATE(fecha) = CURDATE()";
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = Conexion.getConnection();
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getInt("id_cita"),
                    rs.getInt("id_tratamiento"),
                    rs.getString("dni_paciente"),
                    rs.getDate("fecha"),
                    rs.getTime("hora"),
                    rs.getString("descripcion"),
                    rs.getString("odontologo"),};
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla.");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }

    public void Mostrar_Datos_Tabla_Citas_Hoy(JTable tableCitas) throws SQLException {
        DefaultTableModel tableModel = (DefaultTableModel) tableCitas.getModel();
        // Limpia la tabla para asegurarte de que no haya datos anteriores
        tableModel.setRowCount(0);

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection c = null;

        // Realiza una consulta SQL para obtener los datos de TB_CITAS del día actual
        String query = "SELECT id_cita, id_tratamiento, dni_paciente, fecha, hora, odontologo, descripcion, estado_cita FROM TB_CITAS WHERE DATE(fecha) = CURDATE()";

        try {
            c = Conexion.getConnection();
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCita = rs.getInt("id_cita");
                int idTratamiento = rs.getInt("id_tratamiento");
                String dniPaciente = rs.getString("dni_paciente");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                String descripcion = rs.getString("descripcion");
                String odontologo = rs.getString("odontologo");
                // Agrega una nueva fila a la tabla con los datos obtenidos
                tableModel.addRow(new Object[]{idCita, idTratamiento, dniPaciente, fecha, hora, descripcion, odontologo});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla de citas.");
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOdontologos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitasHoy = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1365, 770));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOdontologos.setBackground(new java.awt.Color(0, 122, 255));
        btnOdontologos.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        btnOdontologos.setForeground(new java.awt.Color(255, 255, 255));
        btnOdontologos.setText("MÓDULO ODONTÓLOGOS");
        btnOdontologos.setBorder(null);
        btnOdontologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdontologosActionPerformed(evt);
            }
        });
        add(btnOdontologos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, 220, 50));

        tblCitasHoy.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        tblCitasHoy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº Cita", "Nº Tratamiento", "Dni", "Fecha", "Hora", "Descripcion", "Odontologo"
            }
        ));
        tblCitasHoy.setFocusable(false);
        tblCitasHoy.setRowHeight(25);
        tblCitasHoy.setShowGrid(true);
        tblCitasHoy.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCitasHoy);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1000, 270));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CITAS PARA HOY");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 40));
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdontologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdontologosActionPerformed
        try {
            F_Odontologos odontologos = new F_Odontologos();
            odontologos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOdontologosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdontologos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    public javax.swing.JTable tblCitasHoy;
    // End of variables declaration//GEN-END:variables
}
