package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto.clinica_dental_calderon.DB.Conexion;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class F_Reprogramar_Cita extends javax.swing.JFrame {

    private int idCita; // Agregar un campo para almacenar el ID de la cita

    public F_Reprogramar_Cita() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(this);

    }

    // Constructor que acepta el ID de la cita
    public F_Reprogramar_Cita(int idCita) {
        initComponents();
        this.idCita = idCita; // Guardar el ID de la cita
    }

    //SETTER DE (TXTFILED, SPINNER, JDATECHOOSER)
    public void txtNumeroCita(String numeroCita) {
        txtNumeroCita.setText(numeroCita);
    }

    public void txtTratamiento(String nombre_tratamiento) {
        txtTratamiento.setText(nombre_tratamiento);
    }

    public void txtNumeroTratamiento(String numeroTratamiento) {
        txtNumeroTratamiento.setText(numeroTratamiento);
    }

    public void txtDNI(String dni) {
        txtDNI.setText(dni);
    }

    public void txtOdontologo(String odontologo) {
        txtOdontologo.setText(odontologo);
    }

    public void dateChooserFechaCita(Date fecha_actual) {
        dateChooserFechaCita.setDate(fecha_actual);
    }

    public void spinnerHora(Time hora) {
        spinnerHora.setValue(hora);
    }

    public void spinnerMinutos(Time minutos) {
        spinnerMinutos.setValue(minutos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateChooserFechaCita = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spinnerHora = new javax.swing.JSpinner();
        spinnerMinutos = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        dateNueva_Fecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        spinnerNueva_Hora = new javax.swing.JSpinner();
        spinnerNuevo_Minutos = new javax.swing.JSpinner();
        checkMantener_Fecha = new javax.swing.JCheckBox();
        txtNumeroCita = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        checkMantener_Hora = new javax.swing.JCheckBox();
        txtTratamiento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtOdontologo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnReprogramar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNumeroTratamiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(593, 552));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(490, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(593, 552));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(dateChooserFechaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 180, 40));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REPROGRAMAR CITA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 310, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("FECHA ACTUAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 180, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("HORA ACTUAL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 180, 30));
        jPanel1.add(spinnerHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 80, 40));
        jPanel1.add(spinnerMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 80, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("NUEVA FECHA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 180, 30));
        jPanel1.add(dateNueva_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 180, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("NUEVA HORA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 180, 30));
        jPanel1.add(spinnerNueva_Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 80, 40));
        jPanel1.add(spinnerNuevo_Minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 80, 40));

        checkMantener_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        checkMantener_Fecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkMantener_Fecha.setForeground(new java.awt.Color(51, 51, 51));
        checkMantener_Fecha.setText("MANTENER FECHA");
        checkMantener_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMantener_FechaActionPerformed(evt);
            }
        });
        jPanel1.add(checkMantener_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 180, 30));
        jPanel1.add(txtNumeroCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 100, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("N° DE LA CITA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 100, 20));
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("DNI");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 40, 20));

        checkMantener_Hora.setBackground(new java.awt.Color(255, 255, 255));
        checkMantener_Hora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkMantener_Hora.setForeground(new java.awt.Color(51, 51, 51));
        checkMantener_Hora.setText("MANTENER HORA");
        checkMantener_Hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMantener_HoraActionPerformed(evt);
            }
        });
        jPanel1.add(checkMantener_Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 180, 30));
        jPanel1.add(txtTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("TRATAMIENTO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 110, 20));
        jPanel1.add(txtOdontologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 130, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("ODONTOLOGO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 110, 20));

        btnCancelar.setBackground(new java.awt.Color(24, 177, 135));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 160, 40));

        btnReprogramar.setBackground(new java.awt.Color(24, 177, 135));
        btnReprogramar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReprogramar.setForeground(new java.awt.Color(255, 255, 255));
        btnReprogramar.setText("REPROGRAMAR");
        btnReprogramar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReprogramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReprogramarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReprogramar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 200, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("N° DEL TRATAMIENTO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, 20));
        jPanel1.add(txtNumeroTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 150, 30));

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


    private void btnReprogramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReprogramarActionPerformed
        // Obtener el ID de la cita seleccionada
        int idCita;
        Connection c = null;
        PreparedStatement ps = null;
        idCita = Integer.parseInt(txtNumeroCita.getText());

        // Obtener la nueva fecha desde los componentes gráficos
        java.util.Date nuevaFecha = dateNueva_Fecha.getDate();

        // Validar si la nueva fecha es anterior a la fecha actual
        if (nuevaFecha != null && nuevaFecha.before(new java.util.Date())) {
            JOptionPane.showMessageDialog(this, "No se puede programar una cita en días anteriores.");
            return;
        }

        // Verificar si se debe mantener la fecha original
        boolean mantenerFecha = checkMantener_Fecha.isSelected();

        // Verificar si se debe mantener la hora y minutos originales
        boolean mantenerHoraMinutos = checkMantener_Hora.isSelected();

        // Obtener la nueva hora y minutos desde los componentes gráficos
        int nuevaHora = (int) spinnerNueva_Hora.getValue();
        int nuevaMinutos = (int) spinnerNuevo_Minutos.getValue();

        // Validar límites de horas y minutos
        if (nuevaHora < 0 || nuevaHora > 23 || nuevaMinutos < 0 || nuevaMinutos > 59) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una hora y minutos válidos.");
            return;
        }

        // Validar si la hora es 0
        if (nuevaHora == 0 && !mantenerFecha && !mantenerHoraMinutos) {
            JOptionPane.showMessageDialog(this, "No se puede seleccionar la hora 0. Coloque una hora válida o marque 'MANTENER HORA'");
            return;
        } else if (nuevaHora == 0 && mantenerFecha && !mantenerHoraMinutos) {
            JOptionPane.showMessageDialog(this, "No se puede seleccionar la hora 0. Coloque una hora válida o marque 'MANTENER HORA'");
            return;
        }

        if (nuevaFecha == null && !mantenerFecha) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una nueva fecha o marque 'MANTENER FECHA'.");
            return;
        }

        // Crear una consulta SQL base
        String updateQuery = "UPDATE TB_CITAS SET ";

        // Crear una lista para almacenar los parámetros que necesitamos establecer
        List<Object> parameters = new ArrayList<>();

        if (!mantenerFecha) {
            updateQuery += "fecha = ?, ";
            parameters.add(new java.sql.Timestamp(nuevaFecha.getTime()));
        }
        if (!mantenerHoraMinutos) {
            updateQuery += "hora = ?, ";
            parameters.add(String.format("%02d:%02d:00", nuevaHora, nuevaMinutos));
        }

        if (parameters.isEmpty()) {
            // Si no hay parámetros para establecer, no actualizamos nada
            JOptionPane.showMessageDialog(this, "No se realizaron cambios en la cita.");
            return;
        }

        // Eliminar la última coma y espacio de la consulta SQL
        updateQuery = updateQuery.substring(0, updateQuery.length() - 2);

        // Agregar la cláusula WHERE
        updateQuery += " WHERE id_cita = ?";

        // Agregar el ID de la cita a los parámetros
        parameters.add(idCita);

        try {
            c = Conexion.getConnection();
            ps = c.prepareStatement(updateQuery);

            // Establecer los parámetros dinámicos
            int parameterIndex = 1;
            for (Object parameter : parameters) {
                ps.setObject(parameterIndex++, parameter);
            }

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Cita reprogramada con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo reprogramar la cita.");
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al reprogramar la cita.");
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
    }//GEN-LAST:event_btnReprogramarActionPerformed


    private void checkMantener_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMantener_FechaActionPerformed
        if (checkMantener_Fecha.isSelected()) {
            // Deshabilitar el JDateChooser y usar la fecha original
            dateNueva_Fecha.setEnabled(false);
            dateNueva_Fecha.setDate(null);
        } else {
            // Habilitar el JDateChooser para seleccionar una nueva fecha
            dateNueva_Fecha.setEnabled(true);
        }
    }//GEN-LAST:event_checkMantener_FechaActionPerformed

    private void checkMantener_HoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMantener_HoraActionPerformed
        if (checkMantener_Hora.isSelected()) {
            // Deshabilitar los JSpinners para la hora y minutos y usar los valores originales
            spinnerNueva_Hora.setEnabled(false);
            spinnerNuevo_Minutos.setEnabled(false);
            // Establecer valores originales o cualquier otro valor apropiado
            spinnerNueva_Hora.setValue(0);
            spinnerNuevo_Minutos.setValue(0);
        } else {
            // Habilitar los JSpinners para seleccionar una nueva hora y minutos
            spinnerNueva_Hora.setEnabled(true);
            spinnerNuevo_Minutos.setEnabled(true);
        }
    }//GEN-LAST:event_checkMantener_HoraActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Reprogramar_Cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReprogramar;
    private javax.swing.JCheckBox checkMantener_Fecha;
    private javax.swing.JCheckBox checkMantener_Hora;
    public com.toedter.calendar.JDateChooser dateChooserFechaCita;
    private com.toedter.calendar.JDateChooser dateNueva_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JSpinner spinnerHora;
    public javax.swing.JSpinner spinnerMinutos;
    public javax.swing.JSpinner spinnerNueva_Hora;
    public javax.swing.JSpinner spinnerNuevo_Minutos;
    public javax.swing.JTextField txtDNI;
    public javax.swing.JTextField txtNumeroCita;
    public javax.swing.JTextField txtNumeroTratamiento;
    public javax.swing.JTextField txtOdontologo;
    public javax.swing.JTextField txtTratamiento;
    // End of variables declaration//GEN-END:variables
}
