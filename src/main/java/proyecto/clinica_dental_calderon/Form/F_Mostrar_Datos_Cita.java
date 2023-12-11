package proyecto.clinica_dental_calderon.Form;


import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class F_Mostrar_Datos_Cita extends javax.swing.JFrame {
    
    public F_Mostrar_Datos_Cita() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
            defaults.put("TextPane.inactiveForeground", Color.BLACK);
            dateFecha_Ingreso.setForeground(Color.BLACK);
            dateFecha_Ingreso.setEnabled(false);
    }
    
    public void txtDni(String dni){
        txtDni.setText(dni);
    }
    public void txtNombre(String nombre){
        txtNombre.setText(nombre);
    }
    public void txtApellidos(String apellidos){
        txtApellidos.setText(apellidos);
    }
    public void txtEdad(String edad){
        txtEdad.setText(edad);
    }
    public void txtCelular(String celular){
        txtCelular.setText(celular);
    }
    public void dateFecha_Ingreso(Date fecha_ingreso){
        dateFecha_Ingreso.setDate(fecha_ingreso);
    }
    public void txaEnfermedad(String enfermedad){
        txaEnfermedad.setText(enfermedad);
    }
    
    public void txtTratamiento(String tratamiento){
        txtTratamiento.setText(tratamiento);
    }
    
    public void dateCita(Date fecha){
        dateCita.setDate(fecha);
    }
    public void txtOdontologo(String odontologo){
        txtOdontologo.setText(odontologo);
    }
    public void txaDescripcion(String descripcion){
        txaDescripcion.setText(descripcion);
    }
    public void SpinnerHora(Time hora){
        SpinnerHora.setValue(hora);
    }
    public void SpinnerMinuto(Time minutos){
        SpinnerMinuto.setValue(minutos);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtOdontologo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEnfermedad = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        dateFecha_Ingreso = new com.toedter.calendar.JDateChooser();
        dateCita = new com.toedter.calendar.JDateChooser();
        SpinnerMinuto = new javax.swing.JSpinner();
        SpinnerHora = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        txtTratamiento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(631, 488));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(631, 488));
        jPanel1.setPreferredSize(new java.awt.Dimension(631, 488));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VISTA GENERAL DE LA CITA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 380, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("DNI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 110, 20));
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 30));

        txtOdontologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOdontologoActionPerformed(evt);
            }
        });
        jPanel1.add(txtOdontologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 170, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ENFERMEDAD O ALERGIA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 220, 20));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 180, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("APELLIDOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 180, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("NOMBRE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 170, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CELULAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 120, 20));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 120, 30));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 70, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("EDAD");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 70, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("FECHA DE INGRESO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 150, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("FECHA DE LA CITA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 170, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("DESCRIPCIÓN DE LA CITA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 150, 20));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(360, 50));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(360, 50));

        txaEnfermedad.setColumns(20);
        txaEnfermedad.setLineWrap(true);
        txaEnfermedad.setRows(5);
        txaEnfermedad.setWrapStyleWord(true);
        txaEnfermedad.setPreferredSize(new java.awt.Dimension(113, 20));
        jScrollPane1.setViewportView(txaEnfermedad);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 360, 50));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("ODONTÓLOGO");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 170, 20));
        jPanel1.add(dateFecha_Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 150, 30));
        jPanel1.add(dateCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 170, 40));
        jPanel1.add(SpinnerMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 80, 30));
        jPanel1.add(SpinnerHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 80, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("HORA DE LA CITA");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 170, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("MINUTOS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 80, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("HORAS");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 80, 20));

        txaDescripcion.setColumns(20);
        txaDescripcion.setLineWrap(true);
        txaDescripcion.setRows(5);
        txaDescripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 550, 90));
        jPanel1.add(txtTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 170, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("TRATAMIENTO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 170, 20));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 170, 30));

        btnCerrar.setBackground(new java.awt.Color(30, 85, 131));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("CERRAR");
        btnCerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOdontologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOdontologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOdontologoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new F_Agendar_Cita().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Mostrar_Datos_Cita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JSpinner SpinnerHora;
    public javax.swing.JSpinner SpinnerMinuto;
    private javax.swing.JButton btnCerrar;
    public com.toedter.calendar.JDateChooser dateCita;
    public com.toedter.calendar.JDateChooser dateFecha_Ingreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea txaDescripcion;
    public javax.swing.JTextArea txaEnfermedad;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCelular;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtOdontologo;
    public javax.swing.JTextField txtTratamiento;
    // End of variables declaration//GEN-END:variables

    private void Deshabilitar_Campos() {
        txtOdontologo.setEditable(false);
        txtApellidos.setEditable(false);
        txtEdad.setEditable(false);
        txtCelular.setEditable(false);
        txaEnfermedad.setEditable(false);
        dateFecha_Ingreso.setEnabled(false);
    }
}
