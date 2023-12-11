package proyecto.clinica_dental_calderon.Form;

/**
 *
 * @author jcald
 */
public class F_VistaPrevia_Proforma extends javax.swing.JFrame {

    public F_VistaPrevia_Proforma() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPaneTabla = new javax.swing.JTextPane();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxaAntecedentes = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxaMotivo = new javax.swing.JTextArea();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        dateFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(620, 813));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(TxtPaneTabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, 440));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 30));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 200, 30));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, 30));

        jtxaAntecedentes.setColumns(20);
        jtxaAntecedentes.setRows(5);
        jScrollPane2.setViewportView(jtxaAntecedentes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jtxaMotivo.setColumns(20);
        jtxaMotivo.setRows(5);
        jScrollPane3.setViewportView(jtxaMotivo);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 310, 30));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 170, 30));
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 90, 30));
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_VistaPrevia_Proforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextPane TxtPaneTabla;
    public com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea jtxaAntecedentes;
    public javax.swing.JTextArea jtxaMotivo;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtHora;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
