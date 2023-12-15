package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author jcald
 */
public class F_Odontologos extends javax.swing.JFrame {

    public F_Odontologos() throws SQLException {
        initComponents();
        Mostrar_Datos_Tabla_Odontologos(tblOdontologos);
        deshabilitarEdicionTabla(tblOdontologos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOdontologos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(0, 122, 255));
        btnEliminar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR ODONTOLOGO");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 210, 40));

        btnAgregar.setBackground(new java.awt.Color(0, 122, 255));
        btnAgregar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR ODONTOLOGO");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 210, 40));

        btnEditar.setBackground(new java.awt.Color(0, 122, 255));
        btnEditar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR ODONTOLOGO");
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 190, 40));

        tblOdontologos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Nombre", "Apellido", "Celular", "Especialidad", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tblOdontologos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 720, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    public void Mostrar_Datos_Tabla_Odontologos(JTable tablaOdontologos) throws SQLException {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaOdontologos.getModel();

        // Limpia la tabla para asegurarte de que no haya datos anteriores
        modeloTabla.setRowCount(0);
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Realiza una consulta SQL para obtener los datos de TB_ODONTOLOGOS
        String query = "SELECT id_odontologo, nombre_odontologo, apellido_odontologo, celular_odontologo, especialidad, correo FROM TB_ODONTOLOGOS";

        try {
            // Aquí deberás realizar tu lógica de conexión a la base de datos
            c = Conexion.getConnection(); // Reemplaza esto con tu conexión real

            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_odontologo");
                String nombre = rs.getString("nombre_odontologo");
                String apellido = rs.getString("apellido_odontologo");
                String especialidad = rs.getString("celular_odontologo");
                String celular = rs.getString("especialidad");
                String correo = rs.getString("correo");

                // Agrega una nueva fila a la tabla con los datos obtenidos
                modeloTabla.addRow(new Object[]{id, nombre, apellido, especialidad, celular, correo});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de la tabla de odontólogos.");
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new F_Odontologos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Odontologos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblOdontologos;
    // End of variables declaration//GEN-END:variables
}
