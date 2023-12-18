package proyecto.clinica_dental_calderon.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author jcald
 */
public class F_Editar_Proforma extends javax.swing.JFrame {

    private String tratamientoSeleccionado;
    private double costoUnitario;
    double total = 0;

    public F_Editar_Proforma() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGuardar_Proforma = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtxaMotivo = new javax.swing.JTextArea();
        checkPu = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        spnCantidad = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnEliminarTratamiento = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnAgregarTratamiento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTratamiento = new javax.swing.JTable();
        txtCostoUnitario = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        txtNombres = new javax.swing.JTextField();
        btnActualizarDesc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkEditar_Precio = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxaAntecedentes = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxTratamientos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(958, 838));
        jPanel1.setPreferredSize(new java.awt.Dimension(958, 838));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar_Proforma.setBackground(new java.awt.Color(30, 85, 131));
        btnGuardar_Proforma.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar_Proforma.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar_Proforma.setText("ACTUALIZAR PROFORMA");
        btnGuardar_Proforma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar_Proforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_ProformaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar_Proforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 770, 230, 40));

        jtxaMotivo.setColumns(20);
        jtxaMotivo.setRows(5);
        jScrollPane6.setViewportView(jtxaMotivo);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 360, 90));

        checkPu.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        checkPu.setForeground(new java.awt.Color(51, 51, 51));
        checkPu.setText("EDITAR P/U");
        checkPu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkPuItemStateChanged(evt);
            }
        });
        jPanel1.add(checkPu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 100, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 85, 131));
        jLabel10.setText("S/");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 20, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 85, 131));
        jLabel15.setText("DIRECCIÓN");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 20));
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 720, 110, 30));
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 100, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(30, 85, 131));
        jLabel34.setText("TRATAMIENTOS");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 140, 20));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 310, 30));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 160, 30));

        btnEliminarTratamiento.setBackground(new java.awt.Color(24, 177, 135));
        btnEliminarTratamiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarTratamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTratamiento.setText("ELIMINAR");
        btnEliminarTratamiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTratamientoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 120, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 85, 131));
        jLabel12.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 140, 20));

        dateFecha.setEnabled(false);
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 140, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 85, 131));
        jLabel14.setText("CANTIDAD");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 85, 131));
        jLabel13.setText("EDAD");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 60, 20));

        btnAgregarTratamiento.setBackground(new java.awt.Color(24, 177, 135));
        btnAgregarTratamiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarTratamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarTratamiento.setText("AGREGAR");
        btnAgregarTratamiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTratamientoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 120, 40));

        tblTratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tratamiento", "Descripción", "Cantidad", "Costo", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tblTratamiento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 610, 230));
        jPanel1.add(txtCostoUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 120, 40));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 220, 30));

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane5.setViewportView(txaDescripcion);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 440, 70));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 170, 30));

        btnActualizarDesc.setBackground(new java.awt.Color(30, 85, 131));
        btnActualizarDesc.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnActualizarDesc.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarDesc.setText("ACTUALIZAR");
        btnActualizarDesc.setBorder(null);
        btnActualizarDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDescActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 150, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 85, 131));
        jLabel9.setText("MOTIVO DE CONSULTA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 280, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 85, 131));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TOTAL");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 700, 110, 20));

        checkEditar_Precio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkEditar_Precio.setForeground(new java.awt.Color(51, 51, 51));
        checkEditar_Precio.setText("EDITAR PRECIO");
        checkEditar_Precio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEditar_PrecioItemStateChanged(evt);
            }
        });
        checkEditar_Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEditar_PrecioActionPerformed(evt);
            }
        });
        jPanel1.add(checkEditar_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 720, 120, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 85, 131));
        jLabel11.setText("TELÉFONO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 110, 20));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setToolTipText("");
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 870, 10));

        txtHora.setEnabled(false);
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 85, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FECHA Y HORA DE REGISTRO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 260, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 85, 131));
        jLabel8.setText("NOMBRES");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 170, 20));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 70, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 85, 131));
        jLabel3.setText("TRATAMIENTOS REGISTRADOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 390, 20));

        jtxaAntecedentes.setColumns(20);
        jtxaAntecedentes.setRows(5);
        jScrollPane2.setViewportView(jtxaAntecedentes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 360, 90));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 85, 131));
        jLabel4.setText("APELLIDOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 170, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 85, 131));
        jLabel5.setText("ANTECEDENTES");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 280, 20));

        cbxTratamientos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 250, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITAR PROFORMA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 370, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkEditar_PrecioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEditar_PrecioItemStateChanged
        if (checkEditar_Precio.isSelected()) {
            // Habilitar la edición del txtCosto
            txtCosto.setEditable(true);
        } else {
            // Deshabilitar la edición del txtCosto
            txtCosto.setEditable(false);
        }
    }//GEN-LAST:event_checkEditar_PrecioItemStateChanged

    private void checkEditar_PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEditar_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEditar_PrecioActionPerformed

    private void btnAgregarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTratamientoActionPerformed
        checkEditar_Precio.setEnabled(true);

        String tratamientoSeleccionado = cbxTratamientos.getSelectedItem().toString();
        double costoUnitario = Double.parseDouble(txtCostoUnitario.getText());
        int cantidadSeleccionada = (int) spnCantidad.getValue();
        double costoTotal = cantidadSeleccionada * costoUnitario;

        String descripcion = txaDescripcion.getText(); // Obtener la descripción del JTextArea

        // Agregar fila a la tabla con tratamiento, descripción y cantidad
        DefaultTableModel model = (DefaultTableModel) tblTratamiento.getModel();
        model.addRow(new Object[]{tratamientoSeleccionado, descripcion, cantidadSeleccionada, costoUnitario, costoTotal});

        // Actualizar el total
        total += costoTotal;

        // Actualizar el txtCosto con el total
        txtCosto.setText(String.valueOf(total));

        // Reiniciar el spinner a 1
        spnCantidad.setValue(1);

        // Limpiar el JTextArea de la descripción después de agregar
        txaDescripcion.setText("");

        // Habilitar el botón eliminar
        btnEliminarTratamiento.setEnabled(true);
    }//GEN-LAST:event_btnAgregarTratamientoActionPerformed

    private void btnActualizarDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDescActionPerformed
        int selectedRow = tblTratamiento.getSelectedRow();
        String nuevaDescripcion = txaDescripcion.getText();

        if (selectedRow != -1) {
            tblTratamiento.setValueAt(nuevaDescripcion, selectedRow, 1);
            tblTratamiento.setRowSelectionAllowed(false);
            txaDescripcion.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para actualizar la descripción.");
        }
    }//GEN-LAST:event_btnActualizarDescActionPerformed

    private void btnGuardar_ProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_ProformaActionPerformed
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String edad = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String antecedentes = jtxaAntecedentes.getText();
        String motivo = jtxaMotivo.getText();
        Date fechaRegistro = dateFecha.getDate();
        String horaRegistro = txtHora.getText();
        String Costo = txtCosto.getText();

        Connection c = null;
        PreparedStatement ps = null;

        int cantidadTratamientos = tblTratamiento.getRowCount();
        if (cantidadTratamientos == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, añada al menos un tratamiento antes de guardar la proforma.");
            return; // Salir del método si la tabla está vacía
        }

        if (Costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor para el costo.");
            return; // Salir del método si el campo está vacío
        }

        double totalProforma = 0.0;

        try {
            totalProforma = Double.parseDouble(Costo);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el costo.");
            return; // Salir del método si no se puede convertir a número
        }

        // Tratamientos
        StringBuilder tratamientosBuilder = new StringBuilder();
        StringBuilder cantidadesBuilder = new StringBuilder();
        StringBuilder costosUnitariosBuilder = new StringBuilder();
        StringBuilder subtotalesBuilder = new StringBuilder();

        for (int i = 0; i < cantidadTratamientos; i++) {
            String tratamiento = tblTratamiento.getValueAt(i, 0).toString();
            String descripcion = tblTratamiento.getValueAt(i, 1).toString();
            String cantidad = tblTratamiento.getValueAt(i, 2).toString();
            double costoUnitario = Double.parseDouble(tblTratamiento.getValueAt(i, 3).toString());
            double subtotal = Double.parseDouble(tblTratamiento.getValueAt(i, 4).toString());

            // Construir el tratamiento con la descripción entre paréntesis
            String tratamientoConDescripcion = tratamiento + " (" + descripcion + ")" + ", ";

            tratamientosBuilder.append(tratamientoConDescripcion);
            cantidadesBuilder.append(cantidad).append(", ");
            costosUnitariosBuilder.append(costoUnitario).append(", ");
            subtotalesBuilder.append(subtotal).append(", ");
        }

        // Eliminar la última coma de las cadenas
        String tratamientos = tratamientosBuilder.toString();
        String cantidades = cantidadesBuilder.toString();
        String costosUnitarios = costosUnitariosBuilder.toString();
        String subtotales = subtotalesBuilder.toString();
        if (tratamientos.endsWith(",")) {
            tratamientos = tratamientos.substring(0, tratamientos.length() - 1);
        }
        if (cantidades.endsWith(",")) {
            cantidades = cantidades.substring(0, cantidades.length() - 1);
        }
        if (costosUnitarios.endsWith(",")) {
            costosUnitarios = costosUnitarios.substring(0, costosUnitarios.length() - 1);
        }
        if (subtotales.endsWith(",")) {
            subtotales = subtotales.substring(0, subtotales.length() - 1);
        }

        // Verifica si algún campo obligatorio está vacío
        if (nombres.isEmpty() || apellidos.isEmpty() || edad.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || fechaRegistro == null || horaRegistro.isEmpty() || tratamientos.isEmpty() || cantidades.isEmpty() || costosUnitarios.isEmpty() || subtotales.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de guardar la proforma.");
        } else {
            try {
                c = Conexion.getConnection();
                String query = "INSERT INTO TB_PROFORMAS "
                + "(nombre_paciente, apellido_paciente, edad_paciente, telefono_paciente, direccion_paciente, "
                + "antecedentes, motivo_consulta, fecha_registro, hora_registro, tratamientos, cantidades_tratamiento, "
                + "costos_unitarios, subtotales, total) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                ps = c.prepareStatement(query);

                ps.setString(1, nombres);
                ps.setString(2, apellidos);
                ps.setString(3, edad);
                ps.setString(4, telefono);
                ps.setString(5, direccion);
                ps.setString(6, antecedentes);
                ps.setString(7, motivo);
                ps.setDate(8, new java.sql.Date(fechaRegistro.getTime()));
                ps.setString(9, horaRegistro);
                ps.setString(10, tratamientos);
                ps.setString(11, cantidades);
                ps.setString(12, costosUnitarios);
                ps.setString(13, subtotales);
                ps.setDouble(14, totalProforma);

                int rowsInserted = ps.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Proforma guardada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar la proforma.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar la proforma.");
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
    }//GEN-LAST:event_btnGuardar_ProformaActionPerformed

    private void btnEliminarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTratamientoActionPerformed
        int selectedRow = tblTratamiento.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro para eliminar.");
        } else if (selectedRow != -1) {
            // Restar el costo del tratamiento eliminado al total
            double costoTotalEliminado = (double) tblTratamiento.getValueAt(selectedRow, 3);
            total -= costoTotalEliminado;

            // Quitar la fila de la tabla
            DefaultTableModel model = (DefaultTableModel) tblTratamiento.getModel();
            model.removeRow(selectedRow);

            // Actualizar el txtCosto con el nuevo total
            txtCosto.setText(String.valueOf(total));

            // Deshabilitar el botón eliminar si no hay filas seleccionadas
            if (model.getRowCount() == 0) {
                // Si la tabla está vacía, deshabilitar el checkbox también
                checkEditar_Precio.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnEliminarTratamientoActionPerformed

    private void checkPuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkPuItemStateChanged
        if (checkPu.isSelected()) {
            // Habilitar la edición del txtCosto
            txtCostoUnitario.setEditable(true);
        } else {
            // Deshabilitar la edición del txtCosto
            txtCostoUnitario.setEditable(false);
        }
    }//GEN-LAST:event_checkPuItemStateChanged

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Editar_Proforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDesc;
    private javax.swing.JButton btnAgregarTratamiento;
    private javax.swing.JButton btnEliminarTratamiento;
    public javax.swing.JButton btnGuardar_Proforma;
    public javax.swing.JComboBox cbxTratamientos;
    public javax.swing.JCheckBox checkEditar_Precio;
    private javax.swing.JCheckBox checkPu;
    public com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextArea jtxaAntecedentes;
    public javax.swing.JTextArea jtxaMotivo;
    public javax.swing.JSpinner spnCantidad;
    public javax.swing.JTable tblTratamiento;
    private javax.swing.JTextArea txaDescripcion;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtCostoUnitario;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtHora;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
