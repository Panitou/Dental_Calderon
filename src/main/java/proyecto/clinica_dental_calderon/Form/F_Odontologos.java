package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author jcald
 */
public final class F_Odontologos extends javax.swing.JFrame {

    // Imagen
    String actualizar = "/images/actualizar.png";
    ImageIcon actualizarImagen = new ImageIcon(F_Odontologos.class.getResource(actualizar));

    // Conexiones
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public F_Odontologos() throws SQLException {
        initComponents();
        Mostrar_Datos_Tabla_Odontologos(tblOdontologos);
        deshabilitarEdicionTabla(tblOdontologos);

        this.setResizable(false);
        this.setLocationRelativeTo(null);

        btnReiniciar.setIcon(actualizarImagen);

    }

    private void cerrarConexiones() {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet: " + e.getMessage());
        }
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar Connection: " + e.getMessage());
        }
    }

    void LimpiarEntradas() {
        txfID.setText("");
        txfNombre.setText("");
        txfApellidos.setText("");
        txfCelular.setText("");
        txfCorreo.setText("");
        txfEspecialidad.setText("");
    }

    void activarBotones() {
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
    }

    void desactivarBotones() {
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }

    void ReiniciarPrograma() {
        LimpiarEntradas();
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnActualizar.setEnabled(false);
        txfID.setEnabled(true);
        btnGuardar.setEnabled(true);
    }

    private void BuscarID(int id) {
        try {
            c = Conexion.getConnection();
            String query = "SELECT * FROM TB_ODONTOLOGOS WHERE id_odontologo = ?";
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                txfID.setText(rs.getString("id_odontologo"));
                txfNombre.setText(rs.getString("nombre_odontologo"));
                txfApellidos.setText(rs.getString("apellido_odontologo"));
                txfEspecialidad.setText(rs.getString("especialidad"));
                txfCelular.setText(rs.getString("celular_odontologo"));
                txfCorreo.setText(rs.getString("correo"));

                activarBotones();

                JOptionPane.showMessageDialog(this, "Se encontró al odontologo: "
                        + rs.getString("nombre_odontologo")
                        + " " + rs.getString("apellido_odontologo"));

            } else {
                JOptionPane.showMessageDialog(this, "Odontologo no encontrado. Inténtelo nuevamente");
                LimpiarEntradas();
                desactivarBotones();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: ");
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            cerrarConexiones();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOdontologos = new javax.swing.JTable();
        txfID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txfCelular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txfEspecialidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(0, 122, 255));
        btnEliminar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR ODONTOLOGO");
        btnEliminar.setEnabled(false);
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 200, 40));

        btnActualizar.setBackground(new java.awt.Color(0, 122, 255));
        btnActualizar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR ODONTOLOGO");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 220, 40));

        btnEditar.setBackground(new java.awt.Color(0, 122, 255));
        btnEditar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR ODONTOLOGO");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, 40));

        tblOdontologos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Celular", "Especialidad", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tblOdontologos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 780, 340));

        txfID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 60, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("NOMBRE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 170, 20));

        txfNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 180, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("APELLIDO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 170, 20));

        txfApellidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txfApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 180, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CELULAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 170, 20));

        txfCelular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txfCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 180, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("ESPECIALIDAD");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 170, 20));

        txfEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txfEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 190, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("CORREO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 170, 20));

        txfCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 240, 40));

        btnGuardar.setBackground(new java.awt.Color(0, 122, 255));
        btnGuardar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR ODONTOLOGO");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 210, 40));

        btnReiniciar.setBackground(new java.awt.Color(255, 255, 255));
        btnReiniciar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReiniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnReiniciar.setBorder(null);
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 32, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int id = Integer.parseInt(txfID.getText().trim());
        String nombre = txfNombre.getText().trim();
        String apellido = txfApellidos.getText().trim();
        String especialidad = txfEspecialidad.getText().trim();
        String celular = txfCelular.getText().trim();
        String correo = txfCorreo.getText().trim();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int id = Integer.parseInt(txfID.getText());
        String nombre = txfNombre.getText();
        String apellido = txfApellidos.getText();
        String especialidad = txfEspecialidad.getText();
        String celular = txfCelular.getText();
        String correo = txfCorreo.getText();

        try {
            c = Conexion.getConnection();

            if (c != null) {

                // Verificar si el ID ya existe
                String checkQuery = "SELECT COUNT(*) FROM TB_ODONTOLOGOS WHERE id_odontologo = ?";
                ps = c.prepareStatement(checkQuery);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(
                            null, "El ID '" + id + "' ya existe en la base de datos.\n"
                            + "Por favor, intente con otro número.");
                } else {
                    String query = "INSERT INTO TB_ODONTOLOGOS "
                            + "(id_odontologo, nombre_odontologo, apellido_odontologo, celular_odontologo, especialidad, correo) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
                    ps.close(); // Cerraramos el PreStat anterior

                    ps = c.prepareStatement(query);
                    ps.setInt(1, id);
                    ps.setString(2, nombre);
                    ps.setString(3, apellido);
                    ps.setString(4, especialidad);
                    ps.setString(5, celular);
                    ps.setString(6, correo);

                    int columAfec = ps.executeUpdate();

                    if (columAfec > 0) {
                        Mostrar_Datos_Tabla_Odontologos(tblOdontologos);
                        LimpiarEntradas();
                        JOptionPane.showMessageDialog(null, "Odontologo: '"
                                + nombre + " " + apellido + "'. Se guardó correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR. No se pudo guardar los datos");
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR ODONTOLOGO.");
            System.out.println("Error al guardar los datos en la DB: \n" + e);
        } finally {
            cerrarConexiones();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String idInput = JOptionPane.showInputDialog(this, "Ingrese el ID del odontólogo que desea editar");

        if (idInput != null && !idInput.isEmpty()) {
            try {
                int id = Integer.parseInt(idInput.trim());
                BuscarID(id);
            } catch (NumberFormatException e) {
                ReiniciarPrograma();
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de ID válido.");
                System.out.println("ERROR. " + e);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        try {
            ReiniciarPrograma();
            Mostrar_Datos_Tabla_Odontologos(tblOdontologos);
        } catch (SQLException ex) {
            Logger.getLogger(F_Odontologos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    public void Mostrar_Datos_Tabla_Odontologos(JTable tablaOdontologos) throws SQLException {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaOdontologos.getModel();

        // Limpia la tabla para asegurarte de que no haya datos anteriores
        modeloTabla.setRowCount(0);

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
            System.out.print("Error al cargar los datos de la tabla de odontólogos. \nERROR:" + e);
        } finally {
            cerrarConexiones();
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblOdontologos;
    public javax.swing.JTextField txfApellidos;
    public javax.swing.JTextField txfCelular;
    public javax.swing.JTextField txfCorreo;
    public javax.swing.JTextField txfEspecialidad;
    public javax.swing.JTextField txfID;
    public javax.swing.JTextField txfNombre;
    // End of variables declaration//GEN-END:variables
}
