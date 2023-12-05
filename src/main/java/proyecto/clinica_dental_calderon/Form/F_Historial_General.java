package proyecto.clinica_dental_calderon.Form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class F_Historial_General extends javax.swing.JFrame {

    public F_Historial_General() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        deshabilitarEdicionTabla(tblRegistroGeneral);

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
        tblRegistroGeneral = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cbxFiltro_Metodos_Pago = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1059, 478));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRegistroGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Pago", "N° Tratamiento", "Fecha de Pago", "Hora de Pago", "Dni", "Nombre", "Apellido", "Monto", "Método de Pago"
            }
        ));
        tblRegistroGeneral.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblRegistroGeneral);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1040, 390));

        jButton1.setBackground(new java.awt.Color(24, 177, 135));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LIMPIAR FILTROS");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 150, 40));

        cbxFiltro_Metodos_Pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxFiltro_Metodos_Pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 200, 40));

        jButton2.setBackground(new java.awt.Color(24, 177, 135));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("APLICAR FILTROS");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 150, 40));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("FECHA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 20));

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 110, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("HORA:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 110, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblRegistroGeneral.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        tblRegistroGeneral.setRowSorter(sorter);

        RowFilter<Object, Object> filter = null;
        try {
            List<RowFilter<Object, Object>> filters = new ArrayList<>(3);
            filters.add(RowFilter.regexFilter("YAPE", 8)); // Filtrar por "YAPE" en la columna 8
            filters.add(RowFilter.regexFilter("EFECTIVO", 8)); // Filtrar por "EFECTIVO" en la columna 8
            filters.add(RowFilter.regexFilter("BCP", 8)); // Filtrar por "BCP" en la columna 8
            filter = RowFilter.orFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(filter);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblRegistroGeneral.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        tblRegistroGeneral.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Historial_General().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cbxFiltro_Metodos_Pago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHora;
    public javax.swing.JTable tblRegistroGeneral;
    // End of variables declaration//GEN-END:variables

}
