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
        jScrollPane4 = new javax.swing.JScrollPane();
        TextPaneVistaPrevia = new javax.swing.JTextPane();
        Lbllogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNombrePane = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtApellidoPane = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtEdadPane = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTelefonoPane = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtDireccionPane = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtAntecedentesPane = new javax.swing.JTextField();
        txtMotivoPane = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtFechaPane = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(596, 813));
        jPanel1.setPreferredSize(new java.awt.Dimension(596, 813));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextPaneVistaPrevia.setBorder(null);
        TextPaneVistaPrevia.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jScrollPane4.setViewportView(TextPaneVistaPrevia);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 574, 460));
        jPanel1.add(Lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 230, 117));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("C.O.P 8994");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 20));

        jLabel16.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 122, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Dr. Oswaldo M.");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 20));

        jLabel17.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 122, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Calderón Flores");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 120, 20));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cirujano - Dentista");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 20));

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Lunes a Sábado 9:00 am. a 1:00 pm. / 3:00 pm. a 9:00 pm.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 310, 20));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 122, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Av. Universitaria Norte N° 6809 Of. 202 - 203");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 230, 20));

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 122, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Urb. Santa Luzmila, Comas (Esquina con Av. Guillermo de la Fuente)");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 350, 20));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 122, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Telf.: 536-3680");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 90, 20));

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 122, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cel.: 995-302-877");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 100, 20));

        txtNombrePane.setBackground(new java.awt.Color(238, 238, 238));
        txtNombrePane.setBorder(null);
        jPanel1.add(txtNombrePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 130, 20));

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Nombre:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 50, 20));

        txtApellidoPane.setBackground(new java.awt.Color(238, 238, 238));
        txtApellidoPane.setBorder(null);
        jPanel1.add(txtApellidoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 200, 20));

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Apellido:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 50, 20));

        txtEdadPane.setBackground(new java.awt.Color(238, 238, 238));
        txtEdadPane.setBorder(null);
        jPanel1.add(txtEdadPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 30, 20));

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Edad:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 30, 20));

        txtTelefonoPane.setBackground(new java.awt.Color(238, 238, 238));
        txtTelefonoPane.setBorder(null);
        jPanel1.add(txtTelefonoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 110, 20));

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Telefono:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 70, 20));

        txtDireccionPane.setBackground(new java.awt.Color(238, 238, 238));
        txtDireccionPane.setBorder(null);
        jPanel1.add(txtDireccionPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 310, 20));

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Direccion:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, 20));

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Antecedentes:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 20));

        txtAntecedentesPane.setBackground(new java.awt.Color(238, 238, 238));
        txtAntecedentesPane.setBorder(null);
        jPanel1.add(txtAntecedentesPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 490, 20));

        txtMotivoPane.setBackground(new java.awt.Color(238, 238, 238));
        txtMotivoPane.setBorder(null);
        jPanel1.add(txtMotivoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 360, 20));

        jLabel32.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Motivo:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 20));

        txtFechaPane.setBackground(new java.awt.Color(238, 238, 238));
        txtFechaPane.setBorder(null);
        jPanel1.add(txtFechaPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 110, 20));

        jLabel33.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Fecha:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 40, 20));

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("N° PROFORMA");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));

        txtId.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 60, 30));

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
        jPanel2.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 190, 30));

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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_VistaPrevia_Proforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Lbllogo;
    public javax.swing.JTextPane TextPaneVistaPrevia;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTextField txtAntecedentesPane;
    public javax.swing.JTextField txtApellidoPane;
    public javax.swing.JTextField txtDireccionPane;
    public javax.swing.JTextField txtEdadPane;
    public javax.swing.JTextField txtFechaPane;
    public javax.swing.JLabel txtId;
    public javax.swing.JTextField txtMotivoPane;
    public javax.swing.JTextField txtNombrePane;
    public javax.swing.JTextField txtTelefonoPane;
    // End of variables declaration//GEN-END:variables
}
