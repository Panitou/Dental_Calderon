package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author jcald
 */
public class F_Cancelar_Deuda extends javax.swing.JFrame {

    public F_Cancelar_Deuda() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        txtACancelar.setDocument(new F_Cancelar_Deuda.CostoFilter());

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

    public F_Cancelar_Deuda(int id) {
        initComponents();
        this.txtId = txtId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDeuda = new javax.swing.JTextField();
        txtACancelar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        txtTratamiento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cbxMetodos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(402, 417));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(486, 376));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("N°");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 20));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("CANCELAR DEUDA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 170, 30));
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("DNI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, 20));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 140, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("NOMBRE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 140, 20));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 140, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("APELLIDOS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 20));
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("COSTO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("MÉTODO DE PAGO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, 20));
        jPanel1.add(txtDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 110, 30));
        jPanel1.add(txtACancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 110, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("A CANCELAR");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 110, 20));

        btnPagar.setBackground(new java.awt.Color(30, 85, 131));
        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 130, 40));
        jPanel1.add(txtTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 190, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("TRATAMIENTO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("DEUDA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 110, 20));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, 30));

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 110, 30));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 360, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Hora:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 50, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Fecha:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 50, 30));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 360, 10));

        cbxMetodos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxMetodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        Connection c = null;
        PreparedStatement ps = null;

        if (txtACancelar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresa un monto válido");
        } else {

            // Obtener el id del tratamiento
            int id_tratamiento = Integer.parseInt(txtId.getText());

            // Valor que se ingresará
            double a_pagar = Double.parseDouble(txtACancelar.getText());

            // Deuda actual
            double deuda = Double.parseDouble(txtDeuda.getText());

            if (a_pagar > deuda) {
                JOptionPane.showMessageDialog(this, "El monto a cancelar no puede ser mayor que la deuda.");
                return; // Detener el proceso si el monto es mayor que la deuda
            }

            double cancelado = deuda - a_pagar;

            // Verificar si la deuda se ha pagado completamente
            if (cancelado == 0) {
                // Si la deuda es menor o igual a cero, establece el estado de pago en 'PAGADO'
                try {
                    c = Conexion.getConnection();
                    String updateEstadoQuery = "UPDATE TB_TRATAMIENTOS SET estado_pago = 'PAGADO' WHERE id_tratamiento = ?";
                    ps = c.prepareStatement(updateEstadoQuery);
                    ps.setInt(1, id_tratamiento);
                    ps.executeUpdate();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al actualizar el estado de pago.");
                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                        if (c != null) {
                            c.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            try {
                c = Conexion.getConnection();
                // Actualizar la deuda
                String updateDeudaQuery = "UPDATE TB_TRATAMIENTOS SET deuda = ? WHERE id_tratamiento = ?";
                ps = c.prepareStatement(updateDeudaQuery);
                ps.setDouble(1, cancelado);
                ps.setInt(2, id_tratamiento);

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    // Insertar en la tabla de historial de pagos
                    insertarHistorialPagos(id_tratamiento, a_pagar);
                    JOptionPane.showMessageDialog(this, "Monto pagado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo proceder con el pago.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void insertarHistorialPagos(int id_tratamiento, double dineroIngresado) {
        // Obtener la fecha y hora actual
        Date fechaActual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String fechaPago = dateFormat.format(fechaActual);
        String horaPago = timeFormat.format(fechaActual);

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = Conexion.getConnection();
            // Insertar en la tabla de historial de pagos
            String insertQuery = "INSERT INTO TB_HISTORIAL_PAGOS (id_tratamiento, fecha_pago, hora_pago, dni_paciente, nombre_paciente, apellido_paciente, dinero_ingresado, metodo_pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = c.prepareStatement(insertQuery);
            ps.setInt(1, id_tratamiento);
            ps.setString(2, fechaPago);
            ps.setString(3, horaPago);
            ps.setString(4, txtDni.getText());
            ps.setString(5, txtNombre.getText());
            ps.setString(6, txtApellidos.getText());
            ps.setDouble(7, dineroIngresado);
            ps.setString(8, cbxMetodos.getSelectedItem().toString());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar en el historial de pagos.");
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Cancelar_Deuda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    public javax.swing.JComboBox cbxMetodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHora;
    public javax.swing.JTextField txtACancelar;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtDeuda;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTratamiento;
    // End of variables declaration//GEN-END:variables
}
