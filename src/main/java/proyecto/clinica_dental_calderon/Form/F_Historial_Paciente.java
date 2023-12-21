
package proyecto.clinica_dental_calderon.Form;

import javax.swing.JTable;

public class F_Historial_Paciente extends javax.swing.JFrame {

    public F_Historial_Paciente() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        deshabilitarEdicionTabla(tblHistorial_Paciente);
    }
    
    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial_Paciente = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblNombrePaciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDniPaciente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMontoRestante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(893, 484));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHistorial_Paciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Pago", "N° Tratamiento", "Fecha", "Hora", "Pagado", "Método de Pago"
            }
        ));
        jScrollPane1.setViewportView(tblHistorial_Paciente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 870, 350));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 870, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("PACIENTE:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        lblNombrePaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(lblNombrePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 280, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 50, 30));

        lblDniPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(lblDniPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("MONTO A PAGAR:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 130, 30));

        lblMontoTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(lblMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 50, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("MONTO RESTANTE:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 140, 30));

        lblMontoRestante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(lblMontoRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Historial_Paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblDniPaciente;
    public javax.swing.JLabel lblMontoRestante;
    public javax.swing.JLabel lblMontoTotal;
    public javax.swing.JLabel lblNombrePaciente;
    public javax.swing.JTable tblHistorial_Paciente;
    // End of variables declaration//GEN-END:variables
}
