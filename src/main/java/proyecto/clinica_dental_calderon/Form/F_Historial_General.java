package proyecto.clinica_dental_calderon.Form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        cbxFiltro_Metodos_Pago = new javax.swing.JComboBox<>();
        lblFecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFinal = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnExportar = new javax.swing.JButton();
        btnAplicarFiltros = new javax.swing.JButton();
        btnLimpiarFiltros = new javax.swing.JButton();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1240, 390));

        cbxFiltro_Metodos_Pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxFiltro_Metodos_Pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 200, 40));

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
        jPanel1.add(dateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 210, 40));
        jPanel1.add(dateFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 210, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExportar.setBackground(new java.awt.Color(0, 122, 255));
        btnExportar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setText("EXPORTAR TABLA");
        btnExportar.setBorder(null);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jPanel2.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 40));

        btnAplicarFiltros.setBackground(new java.awt.Color(24, 177, 135));
        btnAplicarFiltros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAplicarFiltros.setForeground(new java.awt.Color(255, 255, 255));
        btnAplicarFiltros.setText("APLICAR FILTROS");
        btnAplicarFiltros.setBorder(null);
        btnAplicarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFiltrosActionPerformed(evt);
            }
        });
        jPanel2.add(btnAplicarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 150, 40));

        btnLimpiarFiltros.setBackground(new java.awt.Color(24, 177, 135));
        btnLimpiarFiltros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarFiltros.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarFiltros.setText("LIMPIAR FILTROS");
        btnLimpiarFiltros.setBorder(null);
        btnLimpiarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltrosActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiarFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAplicarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFiltrosActionPerformed
        String metodoSeleccionado = cbxFiltro_Metodos_Pago.getSelectedItem().toString();

        // Obtener fechas seleccionadas
        Date fechaInicio = dateInicio.getDate();
        Date fechaFin = dateFinal.getDate();

        // Crear filtros para método de pago y rango de fecha
        RowFilter<Object, Object> metodoPagoFilter = RowFilter.regexFilter(metodoSeleccionado, 8); // Filtrar por columna 8 (columna del método de pago)
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblRegistroGeneral.getModel());
        tblRegistroGeneral.setRowSorter(sorter);

        // Crear una lista para almacenar los filtros
        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        // Aplicar filtro de método de pago
        if (!metodoSeleccionado.equals("Todos")) {
            filters.add(metodoPagoFilter);
        }

        if (!filters.isEmpty()) {
            RowFilter<Object, Object> combinedDateFilter = RowFilter.andFilter(filters); // Filtro compuesto de fechas
            sorter.setRowFilter(combinedDateFilter);
        }

        // Aplicar filtro de rango de fecha si ambas fechas han sido seleccionadas
        if (fechaInicio != null && fechaFin != null) {
            RowFilter<Object, Object> fechaFilter = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, fechaInicio, 2); // Filtrar por columna 7 (columna de fecha)
            RowFilter<Object, Object> fechaFilterFin = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, fechaFin, 2);

            filters.add(fechaFilter);
            filters.add(fechaFilterFin);
        }

        // Aplicar los filtros combinados
        if (!filters.isEmpty()) {
            sorter.setRowFilter(RowFilter.andFilter(filters));
        } else {
            sorter.setRowFilter(null); // Mostrar todos los registros si no hay filtros aplicados
        }
    }//GEN-LAST:event_btnAplicarFiltrosActionPerformed

    private void btnLimpiarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltrosActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblRegistroGeneral.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        tblRegistroGeneral.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }//GEN-LAST:event_btnLimpiarFiltrosActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            Workbook workbook = new XSSFWorkbook(); // Crear un libro Excel
            Sheet hoja = workbook.createSheet("Datos"); // Crear una hoja

            TableModel modelo = tblRegistroGeneral.getModel();
            int rowCount = modelo.getRowCount();
            int colCount = modelo.getColumnCount();

            Row headerRow = hoja.createRow(0); // Crear la fila de encabezados
            for (int j = 0; j < colCount; j++) {
                headerRow.createCell(j).setCellValue(modelo.getColumnName(j)); // Establecer los nombres de las columnas como encabezados
            }

            for (int i = 0; i < rowCount; i++) {
                Row row = hoja.createRow(i + 1); // Crear filas para los datos
                for (int j = 0; j < colCount; j++) {
                    Object valorCelda = modelo.getValueAt(i, j); // Obtener el valor de la celda
                    row.createCell(j).setCellValue(valorCelda != null ? valorCelda.toString() : ""); // Establecer el valor en la celda
                }
            }

            // Guardar el libro Excel
            try (FileOutputStream fileOut = new FileOutputStream("tabla_exportada.xlsx")) {
                workbook.write(fileOut);
            }

            workbook.close(); // Cerrar el libro Excel
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Historial_General().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarFiltros;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnLimpiarFiltros;
    public javax.swing.JComboBox<String> cbxFiltro_Metodos_Pago;
    private com.toedter.calendar.JDateChooser dateFinal;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHora;
    public javax.swing.JTable tblRegistroGeneral;
    // End of variables declaration//GEN-END:variables

}
