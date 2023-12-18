package proyecto.clinica_dental_calderon.Form;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

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
        txtNombrePane = new javax.swing.JTextField();
        txtApellidoPane = new javax.swing.JTextField();
        txtEdadPane = new javax.swing.JTextField();
        txtDireccionPane = new javax.swing.JTextField();
        txtTelefonoPane = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxaAntecedentesPane = new javax.swing.JTextField();
        jtxaMotivoPane = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Lbllogo = new javax.swing.JLabel();
        lblLineaFecha = new javax.swing.JLabel();
        lblLineaApellido = new javax.swing.JLabel();
        lblLineaDireccion = new javax.swing.JLabel();
        lblLineaTelefono = new javax.swing.JLabel();
        lblLineaNombre = new javax.swing.JLabel();
        lblLineaAntecedentes = new javax.swing.JLabel();
        lblLineaMotivo = new javax.swing.JLabel();
        lblLineaEdad = new javax.swing.JLabel();
        dateFechaPane = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        btnEditarProforma = new javax.swing.JButton();
        btnCrearPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(596, 813));
        jPanel1.setPreferredSize(new java.awt.Dimension(596, 813));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtPaneTabla.setPreferredSize(new java.awt.Dimension(62, 17));
        jScrollPane1.setViewportView(TxtPaneTabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 570, 470));

        txtNombrePane.setBackground(new java.awt.Color(255, 255, 255));
        txtNombrePane.setBorder(null);
        jPanel1.add(txtNombrePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 140, 20));

        txtApellidoPane.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoPane.setBorder(null);
        jPanel1.add(txtApellidoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 200, 20));

        txtEdadPane.setBackground(new java.awt.Color(255, 255, 255));
        txtEdadPane.setBorder(null);
        jPanel1.add(txtEdadPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 30, 20));

        txtDireccionPane.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccionPane.setBorder(null);
        jPanel1.add(txtDireccionPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 270, 20));

        txtTelefonoPane.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefonoPane.setBorder(null);
        jPanel1.add(txtTelefonoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 130, 20));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Apellido:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 60, 20));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Edad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 40, 20));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Telefono:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 70, 20));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 60, 20));

        jtxaAntecedentesPane.setBackground(new java.awt.Color(255, 255, 255));
        jtxaAntecedentesPane.setBorder(null);
        jPanel1.add(jtxaAntecedentesPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 460, 20));

        jtxaMotivoPane.setBackground(new java.awt.Color(255, 255, 255));
        jtxaMotivoPane.setBorder(null);
        jPanel1.add(jtxaMotivoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 310, 20));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 50, 20));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Dirección:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 70, 20));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Antecedentes:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 20));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Motivo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 60, 20));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 122, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Av. Universitaria Norte N° 6809 Of. 202 - 203");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 230, 20));

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 122, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Urb. Santa Luzmila, Comas (Esquina con Av. Guillermo de la Fuente)");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 350, 20));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 122, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Telf.: 536-3680");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 90, 20));

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 122, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cel.: 995-302-877");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 100, 20));

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Lunes a Sábado 9:00 am. a 1:00 pm. / 3:00 pm. a 9:00 pm.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 310, 20));
        jPanel1.add(Lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 117));
        jPanel1.add(lblLineaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 120, 2));
        jPanel1.add(lblLineaApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 200, 2));
        jPanel1.add(lblLineaDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 280, 2));
        jPanel1.add(lblLineaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 140, 2));
        jPanel1.add(lblLineaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 140, 2));
        jPanel1.add(lblLineaAntecedentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 460, 2));
        jPanel1.add(lblLineaMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 310, 2));
        jPanel1.add(lblLineaEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 30, 2));

        dateFechaPane.setBackground(new java.awt.Color(255, 255, 255));
        dateFechaPane.setBorder(null);
        jPanel1.add(dateFechaPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 120, 20));

        jLabel16.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 122, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Dr. Oswaldo M.");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 120, 20));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("C.O.P 8994");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 120, 20));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cirujano - Dentista");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 120, 20));

        jLabel17.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 122, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Calderón Flores");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 120, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnImprimir.setBackground(new java.awt.Color(0, 122, 255));
        btnImprimir.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("IMPRIMIR PROFORMA");
        btnImprimir.setBorder(null);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 190, 30));

        btnEditarProforma.setBackground(new java.awt.Color(0, 122, 255));
        btnEditarProforma.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnEditarProforma.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProforma.setText("EDITAR PROFORMA");
        btnEditarProforma.setBorder(null);
        btnEditarProforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProformaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarProforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 170, 30));

        btnCrearPaciente.setBackground(new java.awt.Color(0, 122, 255));
        btnCrearPaciente.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnCrearPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearPaciente.setText("CREAR PACIENTE");
        btnCrearPaciente.setBorder(null);
        jPanel2.add(btnCrearPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        PageFormat pageFormat = printerJob.defaultPage();
        pageFormat.setOrientation(PageFormat.PORTRAIT); // Orientación vertical
        Paper paper = new Paper();
        double paperWidth = 8.3 * 72; // Ancho en puntos (1 pulgada = 72 puntos)
        double paperHeight = 11.7 * 72; // Altura en puntos
        paper.setSize(paperWidth, paperHeight);
        paper.setImageableArea(0, 0, paperWidth, paperHeight);
        pageFormat.setPaper(paper);

        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                jPanel1.print(g2); // Reemplaza 'panel' con el nombre de tu panel
                return Printable.PAGE_EXISTS;
            }
        }, pageFormat);

        boolean printDialog = printerJob.printDialog();
        if (printDialog) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnEditarProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProformaActionPerformed
        F_Editar_Proforma editarProforma = new F_Editar_Proforma();
        editarProforma.setVisible(true);

        editarProforma.txtNombres.setText(String.valueOf(txtNombrePane));
        editarProforma.txtApellidos.setText(String.valueOf(txtApellidoPane));
        editarProforma.txtEdad.setText(String.valueOf(txtEdadPane));
        editarProforma.txtDireccion.setText(String.valueOf(txtDireccionPane));
        editarProforma.txtTelefono.setText(String.valueOf(txtTelefonoPane));
        editarProforma.jtxaAntecedentes.setText(String.valueOf(jtxaAntecedentesPane));
        editarProforma.jtxaMotivo.setText(String.valueOf(jtxaMotivoPane));
    }//GEN-LAST:event_btnEditarProformaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_VistaPrevia_Proforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Lbllogo;
    public javax.swing.JTextPane TxtPaneTabla;
    private javax.swing.JButton btnCrearPaciente;
    private javax.swing.JButton btnEditarProforma;
    private javax.swing.JButton btnImprimir;
    public javax.swing.JTextField dateFechaPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jtxaAntecedentesPane;
    public javax.swing.JTextField jtxaMotivoPane;
    public javax.swing.JLabel lblLineaAntecedentes;
    public javax.swing.JLabel lblLineaApellido;
    public javax.swing.JLabel lblLineaDireccion;
    public javax.swing.JLabel lblLineaEdad;
    public javax.swing.JLabel lblLineaFecha;
    public javax.swing.JLabel lblLineaMotivo;
    public javax.swing.JLabel lblLineaNombre;
    public javax.swing.JLabel lblLineaTelefono;
    public javax.swing.JTextField txtApellidoPane;
    public javax.swing.JTextField txtDireccionPane;
    public javax.swing.JTextField txtEdadPane;
    public javax.swing.JTextField txtNombrePane;
    public javax.swing.JTextField txtTelefonoPane;
    // End of variables declaration//GEN-END:variables
}
