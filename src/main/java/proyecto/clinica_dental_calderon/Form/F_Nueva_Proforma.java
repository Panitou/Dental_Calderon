package proyecto.clinica_dental_calderon.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import proyecto.clinica_dental_calderon.DB.Conexion;

public class F_Nueva_Proforma extends javax.swing.JFrame {

    private String tratamientoSeleccionado;
    private double costoUnitario;
    double total = 0;

    String nombre = "/images/linea.png";

    ImageIcon LineaNombreImage = new ImageIcon(F_Nueva_Proforma.class.getResource(nombre));

    String logoimagencirclex200 = "/images/LogoParaProforma.png";
    ImageIcon iconImagen = new ImageIcon(F_Nueva_Proforma.class.getResource(logoimagencirclex200));

    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }

    public F_Nueva_Proforma() throws SQLException {
        initComponents();

        btnActualizarDesc.setEnabled(false);

        // Suponiendo que tblTratamiento es el nombre de tu tabla y txaDescripcion es el JTextArea
        tblTratamiento.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tblTratamiento.getSelectedRow();
                    if (selectedRow != -1) {
                        Object descripcion = tblTratamiento.getValueAt(selectedRow, 1); // Suponiendo que la descripción está en la columna 1
                        txaDescripcion.setText(descripcion != null ? descripcion.toString() : ""); // Actualizar el JTextArea con la descripción seleccionada
                        btnActualizarDesc.setEnabled(true);
                    }
                }
            }
        });

        txtCosto.setDocument(new F_Nueva_Proforma.CostoFilter());

        // Ahora, carga el precio del tratamiento inicialmente seleccionado
        try {
            String tratamientoSeleccionado = cbxTratamientos.getSelectedItem().toString();
            obtenerCostoTratamiento(tratamientoSeleccionado);
        } catch (SQLException ex) {
            Logger.getLogger(F_Nueva_Proforma.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtNombres.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        jtxaAntecedentes.setText("");
        jtxaMotivo.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCostoUnitario.setText("");
        txtCosto.setText("");

        cbxTratamientos.setSelectedIndex(0);

        DefaultTableModel modelo = (DefaultTableModel) tblTratamiento.getModel();
        modelo.setRowCount(0);

        spnCantidad.setValue(0);

        btnEliminarTratamiento.setEnabled(false);

        txtCostoUnitario.setEditable(false);

        txtCosto.setDocument(new F_Nueva_Proforma.CostoFilter());

        checkEditar_Precio.setEnabled(false);

        //Lineas para los campos de texto

        //Deshabilitar campos de la Vista previa
        txtNombrePane.setEditable(false);
        txtApellidoPane.setEditable(false);
        txtDireccionPane.setEditable(false);
        txtEdadPane.setEditable(false);
        txtTelefonoPane.setEditable(false);
        txtAntecedentesPane.setEditable(false);
        txtMotivoPane.setEditable(false);
        txtFechaPane.setEditable(false);

        //Deshabilitar edicion de la tabla tratamientos
        deshabilitarEdicionTabla(tblTratamiento);

        //Logo a imprimir
        Lbllogo.setIcon(iconImagen);
        //DocumentListener - Mostrar datos en tiempo real - Direccion
        txtDireccion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });
        //DocumentListener - Mostrar datos en tiempo real - Telefono
        txtTelefono.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });

        //DocumentListener - Mostrar datos en tiempo real - Nombres
        txtNombres.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });
        //DocumentListener - Mostrar datos en tiempo real - Apellidos
        txtApellidos.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });
        //DocumentListener - Mostrar datos en tiempo real - Edad
        txtEdad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });

        //DocumentListener - Mostrar datos en tiempo real - Antecedentes
        jtxaAntecedentes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });
        //DocumentListener - Mostrar datos en tiempo real - Motivo
        jtxaMotivo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });
        //DocumentListener - Mostrar datos en tiempo real - CostoFinal
        txtCosto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVistaPrevia();
            }
        });

        ((AbstractDocument) txtNombres.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text.matches("[a-zA-Z\\s]+") && (fb.getDocument().getLength() + text.length() <= 100)) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z\\s]+") && (fb.getDocument().getLength() - length + text.length() <= 100)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) txtApellidos.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text.matches("[a-zA-Z\\s]+") && (fb.getDocument().getLength() + text.length() <= 100)) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z\\s]+") && (fb.getDocument().getLength() - length + text.length() <= 100)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) txtEdad.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text.matches("\\d+") && (fb.getDocument().getLength() + text.length() <= 3)) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d+") && (fb.getDocument().getLength() - length + text.length() <= 3)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        txtDireccion.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength() + str.length() <= 100) {
                    super.insertString(offs, str, a);
                }
            }
        });

        txtTelefono.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 15) {
                    if (str.matches("[0-9]+")) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });

        TextPaneVistaPrevia.setEditable(false);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        txtCosto.setEditable(false);
        Cargar_Combos_Tratamientos(cbxTratamientos);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                // Cuando se abre la ventana, establecer la fecha y hora actuales
                Date fechaActual = new Date();
                dateFecha.setDate(fechaActual);

                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                String horaActual = formatoHora.format(fechaActual);
                txtHora.setText(horaActual);
            }
        });
        ListSelectionModel selectionModel = tblTratamiento.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verificar si hay alguna fila seleccionada
                boolean filaSeleccionada = tblTratamiento.getSelectedRow() != -1;

                // Habilitar o deshabilitar el botón según la condición
                btnEliminarTratamiento.setEnabled(filaSeleccionada);
            }
        });
        checkEditar_Precio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEditar_PrecioItemStateChanged(evt);
            }
        });
        // Asegura que el valor mínimo del Spinner es 1
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        spnCantidad.setModel(model);

        // Deshabilita la edición directa del Spinner
        JFormattedTextField txt = ((JSpinner.DefaultEditor) spnCantidad.getEditor()).getTextField();
        txt.setEditable(false);

        // Agrega un ChangeListener al Spinner
        spnCantidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtiene el valor actual del Spinner
                int currentValue = (int) spnCantidad.getValue();

                // Si el valor es menor que 1, establece el valor a 1
                if (currentValue < 1) {
                    spnCantidad.setValue(1);
                }
            }
        });
    }

    private class CostoFilter extends PlainDocument {

        private static final int MAX_DIGITS_BEFORE_DECIMAL = 7; // Máximo de dígitos antes del punto
        private static final int MAX_DECIMAL_PLACES = 2; // Máximo de decimales permitidos

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            String text = getText(0, getLength());
            String result = text.substring(0, offset) + str + text.substring(offset);

            if (isValidInput(result)) {
                super.insertString(offset, str, attr);
            }
        }

        @Override
        public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            String currentText = getText(0, getLength());
            String beforeOffset = currentText.substring(0, offset);
            String afterOffset = currentText.substring(offset + length);

            String resultText = beforeOffset + text + afterOffset;
            if (isValidInput(resultText)) {
                super.replace(offset, length, text, attrs);
            }
        }

        private boolean isValidInput(String input) {
            // Verifica si el texto ingresado es un número válido con las restricciones
            if (input.isEmpty()) {
                return true;
            }

            if (input.equals(".")) {
                return false; // Evita que se ingrese solo el punto decimal
            }

            if (input.matches("\\d{1," + MAX_DIGITS_BEFORE_DECIMAL + "}\\.?\\d{0," + MAX_DECIMAL_PLACES + "}")) {
                double value = Double.parseDouble(input);
                return value <= Double.MAX_VALUE && value >= -Double.MAX_VALUE; // Verifica el rango de Double
            }

            return false;
        }
    }

    private void Cargar_Combos_Tratamientos(JComboBox<String> c) throws SQLException {
        DefaultComboBoxModel<String> box_Tratamiento = new DefaultComboBoxModel<>();
        c.setModel(box_Tratamiento);

        try (Connection cn = Conexion.getConnection(); PreparedStatement ps = cn.prepareStatement("SELECT nombre_tratamiento FROM TB_LISTA_TRATAMIENTOS"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombreTratamiento = rs.getString("nombre_tratamiento");
                box_Tratamiento.addElement(nombreTratamiento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar tratamientos.");
        }

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tratamientoSeleccionado = (String) c.getSelectedItem();
                    costoUnitario = obtenerCostoTratamiento(tratamientoSeleccionado);
                    txtCostoUnitario.setText(String.valueOf(costoUnitario));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(F_Nueva_Proforma.this, "Error al obtener costo del tratamiento.");
                }
            }
        });

        // Obtener y mostrar el costo del primer tratamiento al iniciar el frame
        if (box_Tratamiento.getSize() > 0) {
            String primerTratamiento = box_Tratamiento.getElementAt(0);
            try {
                double costoPrimerTratamiento = obtenerCostoTratamiento(primerTratamiento);
                txtCostoUnitario.setText(String.valueOf(costoPrimerTratamiento));
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al obtener costo del primer tratamiento.");
            }
        }
    }

    private double obtenerCostoTratamiento(String tratamiento) throws SQLException {
        try (Connection c = Conexion.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT costo_tratamiento FROM TB_LISTA_TRATAMIENTOS WHERE nombre_tratamiento = ?")) {

            ps.setString(1, tratamiento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("costo_tratamiento");
                }
            }
        }

        return 0.0; // Devuelve un valor predeterminado si no se encuentra el costo del tratamiento
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar_Proforma = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxaAntecedentes = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        checkEditar_Precio = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        cbxTratamientos = new javax.swing.JComboBox();
        btnAgregarTratamiento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTratamiento = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtCostoUnitario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnEliminarTratamiento = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        btnActualizarDesc = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtxaMotivo = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        checkPu = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
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

        jCheckBox2.setText("jCheckBox2");

        jCheckBox7.setText("jCheckBox7");

        jCheckBox9.setText("jCheckBox9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1375, 813));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(958, 838));
        jPanel1.setPreferredSize(new java.awt.Dimension(958, 838));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 85, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVA PROFORMA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 370, 60));

        btnGuardar_Proforma.setBackground(new java.awt.Color(30, 85, 131));
        btnGuardar_Proforma.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar_Proforma.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar_Proforma.setText("GUARDAR PROFORMA");
        btnGuardar_Proforma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar_Proforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_ProformaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar_Proforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 770, 230, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 85, 131));
        jLabel3.setText("TRATAMIENTOS REGISTRADOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 390, 20));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 85, 131));
        jLabel4.setText("APELLIDOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 170, 20));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 220, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 85, 131));
        jLabel5.setText("ANTECEDENTES");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 280, 20));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 70, 30));

        dateFecha.setEnabled(false);
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 140, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 85, 131));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TOTAL");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 700, 110, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 85, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FECHA Y HORA DE REGISTRO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 260, 20));

        txtHora.setEnabled(false);
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 110, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 85, 131));
        jLabel8.setText("NOMBRES");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 170, 20));
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 720, 110, 30));

        jtxaAntecedentes.setColumns(20);
        jtxaAntecedentes.setRows(5);
        jScrollPane2.setViewportView(jtxaAntecedentes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 360, 90));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 85, 131));
        jLabel10.setText("S/");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 20, 40));

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

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setToolTipText("");
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 870, 10));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 160, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 85, 131));
        jLabel11.setText("TELÉFONO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 110, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 85, 131));
        jLabel9.setText("MOTIVO DE CONSULTA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 280, 20));
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 100, 40));

        cbxTratamientos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 250, 40));

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 85, 131));
        jLabel12.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 140, 20));
        jPanel1.add(txtCostoUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 120, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 85, 131));
        jLabel13.setText("EDAD");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 60, 20));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 310, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 85, 131));
        jLabel14.setText("CANTIDAD");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 85, 131));
        jLabel15.setText("DIRECCIÓN");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 20));

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

        btnImprimir.setBackground(new java.awt.Color(30, 85, 131));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 770, 140, 40));

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane5.setViewportView(txaDescripcion);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 440, 70));

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

        jtxaMotivo.setColumns(20);
        jtxaMotivo.setRows(5);
        jScrollPane6.setViewportView(jtxaMotivo);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 360, 90));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(30, 85, 131));
        jLabel34.setText("TRATAMIENTOS");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 140, 20));

        checkPu.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        checkPu.setForeground(new java.awt.Color(51, 51, 51));
        checkPu.setText("EDITAR P/U");
        checkPu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkPuItemStateChanged(evt);
            }
        });
        jPanel1.add(checkPu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 100, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(596, 813));
        jPanel2.setPreferredSize(new java.awt.Dimension(596, 813));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextPaneVistaPrevia.setBorder(null);
        TextPaneVistaPrevia.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jScrollPane4.setViewportView(TextPaneVistaPrevia);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 574, 480));
        jPanel2.add(Lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 230, 117));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("C.O.P 8994");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 20));

        jLabel16.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 122, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Dr. Oswaldo M.");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 20));

        jLabel17.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 122, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Calderón Flores");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 120, 20));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cirujano - Dentista");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 20));

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Lunes a Sábado 9:00 am. a 1:00 pm. / 3:00 pm. a 9:00 pm.");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 310, 20));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 122, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Av. Universitaria Norte N° 6809 Of. 202 - 203");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 230, 20));

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 122, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Urb. Santa Luzmila, Comas (Esquina con Av. Guillermo de la Fuente)");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 350, 20));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 122, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Telf.: 536-3680");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 90, 20));

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 122, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cel.: 995-302-877");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 100, 20));

        txtNombrePane.setBackground(new java.awt.Color(238, 238, 238));
        txtNombrePane.setBorder(null);
        jPanel2.add(txtNombrePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 130, 20));

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Nombre:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 50, 20));

        txtApellidoPane.setBackground(new java.awt.Color(238, 238, 238));
        txtApellidoPane.setBorder(null);
        jPanel2.add(txtApellidoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 200, 20));

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Apellido:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 50, 20));

        txtEdadPane.setBackground(new java.awt.Color(238, 238, 238));
        txtEdadPane.setBorder(null);
        jPanel2.add(txtEdadPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 30, 20));

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Edad:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 30, 20));

        txtTelefonoPane.setBackground(new java.awt.Color(238, 238, 238));
        txtTelefonoPane.setBorder(null);
        jPanel2.add(txtTelefonoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 110, 20));

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Telefono:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 70, 20));

        txtDireccionPane.setBackground(new java.awt.Color(238, 238, 238));
        txtDireccionPane.setBorder(null);
        jPanel2.add(txtDireccionPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 310, 20));

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Direccion:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, 20));

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Antecedentes:");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 20));

        txtAntecedentesPane.setBackground(new java.awt.Color(238, 238, 238));
        txtAntecedentesPane.setBorder(null);
        jPanel2.add(txtAntecedentesPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 490, 20));

        txtMotivoPane.setBackground(new java.awt.Color(238, 238, 238));
        txtMotivoPane.setBorder(null);
        jPanel2.add(txtMotivoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 360, 20));

        jLabel32.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Motivo:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 20));

        txtFechaPane.setBackground(new java.awt.Color(238, 238, 238));
        txtFechaPane.setBorder(null);
        jPanel2.add(txtFechaPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 110, 20));

        jLabel33.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Fecha:");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 40, 20));

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("N° PROFORMA");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));

        txtId.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarVistaPrevia() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = dateFormat.format(dateFecha.getDate());

        String nombre = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String edad = txtEdad.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String antecedentes = jtxaAntecedentes.getText();
        String motivo = jtxaMotivo.getText();

        // Lógica para obtener los datos de la tabla de tratamientos
        DefaultTableModel model = (DefaultTableModel) tblTratamiento.getModel();
        int rowCount = model.getRowCount();
        double totalTratamientos = 0.0; // Variable para calcular el nuevo total

        // Crear la estructura de la tabla en HTML
        StringBuilder tablaTratamientos = new StringBuilder("<html><head><style>"
                + "table {border-collapse: collapse; width: 100%;}"
                + "th, td {text-align: left; padding: 2px; font-size: 9px; border-right: none; font-family: Arial;}"
                + "th {background-color: #00A0E1; color: #ffffff;}"
                + "td {border-bottom: 1px solid #00354B;}"
                + "</style></head><body>");

        tablaTratamientos.append("<table><tr><th>TRATAMIENTO</th><th>CANT.</th><th>P/U</th><th>S.TOTAL</th></tr>");

        for (int i = 0; i < rowCount; i++) {
            String tratamiento = model.getValueAt(i, 0).toString();
            String descripcion = model.getValueAt(i, 1).toString();
            int cantidad = Integer.parseInt(model.getValueAt(i, 2).toString());
            double costoUnitario = Double.parseDouble(model.getValueAt(i, 3).toString());
            double costoTotal = Double.parseDouble(model.getValueAt(i, 4).toString());

            // Agregar tratamiento y descripción en una nueva línea
            tablaTratamientos.append("<tr>")
                    .append("<td>").append(tratamiento).append(" (").append(descripcion).append(")</td>")
                    .append("<td>").append(cantidad).append("</td>")
                    .append("<td>").append(costoUnitario).append("</td>")
                    .append("<td>").append(costoTotal).append("</td>")
                    .append("</tr>");

            // Sumar el costo total de cada tratamiento
            totalTratamientos += costoTotal;
        }
        tablaTratamientos.append("<tr><td colspan='4'></td></tr>");
        // Añadir la fila del costo final
        tablaTratamientos.append("<tr><td colspan='3'>Costo Final</td><td>").append(txtCosto.getText()).append("</td></tr>");

        tablaTratamientos.append("</table></body></html>");

        // Actualizar el total con el nuevo valor
        total = totalTratamientos;

        //Setear datos al TextPane
        txtNombrePane.setText(nombre);
        txtApellidoPane.setText(apellidos);
        txtEdadPane.setText(edad);
        txtDireccionPane.setText(direccion);
        txtTelefonoPane.setText(telefono);
        txtAntecedentesPane.setText(antecedentes);
        txtMotivoPane.setText(motivo);
        txtFechaPane.setText(fechaFormateada);

        TextPaneVistaPrevia.setContentType("text/html");
        TextPaneVistaPrevia.setText(tablaTratamientos.toString());
    }


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
                    // Actualizar la vista previa
                    actualizarVistaPrevia();
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

        // Actualizar la vista previa
        actualizarVistaPrevia();

        // Reiniciar el spinner a 1
        spnCantidad.setValue(1);

        // Limpiar el JTextArea de la descripción después de agregar
        txaDescripcion.setText("");

        // Habilitar el botón eliminar
        btnEliminarTratamiento.setEnabled(true);
    }//GEN-LAST:event_btnAgregarTratamientoActionPerformed

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

    private void checkEditar_PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEditar_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEditar_PrecioActionPerformed

    private void checkEditar_PrecioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEditar_PrecioItemStateChanged
        if (checkEditar_Precio.isSelected()) {
            // Habilitar la edición del txtCosto
            txtCosto.setEditable(true);
        } else {
            // Deshabilitar la edición del txtCosto
            txtCosto.setEditable(false);
        }
    }//GEN-LAST:event_checkEditar_PrecioItemStateChanged

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

                jPanel2.print(g2); // Reemplaza 'panel' con el nombre de tu panel
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

    private void btnActualizarDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDescActionPerformed
        int selectedRow = tblTratamiento.getSelectedRow();
        String nuevaDescripcion = txaDescripcion.getText();

        if (selectedRow != -1) {
            tblTratamiento.setValueAt(nuevaDescripcion, selectedRow, 1);
            actualizarVistaPrevia();
            tblTratamiento.setRowSelectionAllowed(false);
            txaDescripcion.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para actualizar la descripción.");
        }
    }//GEN-LAST:event_btnActualizarDescActionPerformed

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
                try {
                    new F_Nueva_Proforma().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Nueva_Proforma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbllogo;
    public javax.swing.JTextPane TextPaneVistaPrevia;
    private javax.swing.JButton btnActualizarDesc;
    private javax.swing.JButton btnAgregarTratamiento;
    private javax.swing.JButton btnEliminarTratamiento;
    public javax.swing.JButton btnGuardar_Proforma;
    private javax.swing.JButton btnImprimir;
    public javax.swing.JComboBox cbxTratamientos;
    public javax.swing.JCheckBox checkEditar_Precio;
    private javax.swing.JCheckBox checkPu;
    public com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextArea jtxaAntecedentes;
    public javax.swing.JTextArea jtxaMotivo;
    public javax.swing.JSpinner spnCantidad;
    public javax.swing.JTable tblTratamiento;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextField txtAntecedentesPane;
    public javax.swing.JTextField txtApellidoPane;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtCostoUnitario;
    public javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionPane;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtEdadPane;
    private javax.swing.JTextField txtFechaPane;
    public javax.swing.JTextField txtHora;
    public javax.swing.JLabel txtId;
    private javax.swing.JTextField txtMotivoPane;
    public javax.swing.JTextField txtNombrePane;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoPane;
    // End of variables declaration//GEN-END:variables
}
