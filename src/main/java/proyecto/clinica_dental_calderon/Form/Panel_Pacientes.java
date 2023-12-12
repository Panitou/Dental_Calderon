package proyecto.clinica_dental_calderon.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import proyecto.clinica_dental_calderon.DB.Conexion;

//FILTROS DE BUSQUEDA
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Panel_Pacientes extends javax.swing.JPanel {
    
    String actualizar = "/images/actualizar.png";
    String buscar = "/images/buscar.png";
    String limpiar = "/images/borrar.png";
    
    ImageIcon actualizarImagen = new ImageIcon(Panel_Pacientes.class.getResource(actualizar));
    ImageIcon buscarImagen = new ImageIcon(Panel_Pacientes.class.getResource(buscar));
    ImageIcon limpiarImage = new ImageIcon(Panel_Pacientes.class.getResource(limpiar));
    
    String nombre = "/images/linea.png";
    
    ImageIcon LineaNombreImage = new ImageIcon(Panel_Pacientes.class.getResource(nombre));
    
    private final OkHttpClient client = new OkHttpClient();
    
    public Connection connection;
    public PreparedStatement ps;
    public ResultSet rs;
    
    public void abrirConexion() throws SQLException {
        // Verifica si ya hay una conexión abierta antes de abrir una nueva
        if (connection == null || connection.isClosed()) {
            // Abre una nueva conexión si no hay ninguna abierta
            Conexion cx = new Conexion(); // Instancia de tu clase de conexión
            connection = cx.getConnection(); // Método para obtener la conexión
        }
        // Resto del código para usar la conexión en el panel de pacientes...
    }
    
    public void cerrarRecursos() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close(); // Cierra la conexión si está abierta
        }
    }
    
    public Panel_Pacientes() throws SQLException {
        initComponents();
        
        lblLineaBuscar.setIcon(LineaNombreImage);
        
        ((AbstractDocument) txtBuscar.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text.matches("\\d+") && (fb.getDocument().getLength() + text.length() <= 3)) {
                    super.insertString(fb, offset, text, attr);
                }
            }
            
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d+") && (fb.getDocument().getLength() - length + text.length() <= 3)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        //imagenes
        btnActualizar.setIcon(actualizarImagen);
        btnBuscar.setIcon(buscarImagen);
        btnLimpiar.setIcon(limpiarImage);
        
        JTableHeader header = table_Pacientes.getTableHeader();
        header.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
        table_Pacientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table_Pacientes.getTableHeader().setOpaque(false);
        table_Pacientes.getTableHeader().setBackground(new Color(51, 51, 51));
        table_Pacientes.getTableHeader().setForeground(Color.WHITE);
        table_Pacientes.setRowHeight(30);
        abrirConexion();
        Mostrar_Datos_Tabla_Pacientes(table_Pacientes);
        deshabilitarEdicionTabla(table_Pacientes);
    }
    
    private void obtenerImagen(String url, JButton boton) {
        try {
            Request request = new Request.Builder().url(url).build();
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    byte[] imageData = response.body().bytes();
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    SwingUtilities.invokeLater(() -> boton.setIcon(imageIcon));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void deshabilitarEdicionTabla(JTable tabla) {
        tabla.setDefaultEditor(Object.class, null); // Deshabilitar la edición
        tabla.getTableHeader().setReorderingAllowed(false); // Evitar el movimiento de columnas
        tabla.getTableHeader().setResizingAllowed(false);
    }
    
    public void Mostrar_Datos_Tabla_Pacientes(JTable tablePaciente) throws SQLException {
        DefaultTableModel tableModel = (DefaultTableModel) tablePaciente.getModel();

        // Limpia la tabla para asegurarte de que no haya datos anteriores
        tableModel.setRowCount(0);

        // Realiza una consulta SQL para obtener los datos de TB_CITAS
        String query = "SELECT id_paciente, nombre_paciente, apellido_paciente, dni_paciente, edad_paciente, enfermedad_paciente, celular_paciente, fecha_inscripcion FROM TB_PACIENTES";
        
        try { // Reemplaza esto con tu lógica real de conexión a la base de datos
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int idPaciente = rs.getInt("id_paciente");
                String nombre_paciente = rs.getString("nombre_paciente");
                String apellido_Paciente = rs.getString("apellido_paciente");
                String dni_paciente = rs.getString("dni_paciente");
                String edad_paciente = rs.getString("edad_paciente");
                String enfermedad_paciente = rs.getString("enfermedad_paciente");
                String celular_paciente = rs.getString("celular_paciente");
                Timestamp fecha_ingreso = rs.getTimestamp("fecha_inscripcion");

                // Agrega una nueva fila a la tabla con los datos obtenidos
                tableModel.addRow(new Object[]{idPaciente, nombre_paciente, apellido_Paciente, dni_paciente, edad_paciente, enfermedad_paciente, celular_paciente, fecha_ingreso});
            }

            // Cierra los recursos
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla de citas.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Pacientes = new javax.swing.JTable();
        btnAgregarPaciente = new javax.swing.JButton();
        btnEditar_Datos_Paciente = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCopiar_Dni = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLineaBuscar = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1365, 770));
        setPreferredSize(new java.awt.Dimension(1365, 770));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 770));
        jPanel1.setPreferredSize(new java.awt.Dimension(1365, 770));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 134, 203));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("PACIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 90));

        table_Pacientes.setBackground(new java.awt.Color(207, 255, 251));
        table_Pacientes.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        table_Pacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Nombre", "Apellidos", "Dni", "Edad", "Enfermedad/Alergias", "Celular", "Fecha de Inscripción"
            }
        ));
        table_Pacientes.setFocusable(false);
        table_Pacientes.setGridColor(new java.awt.Color(255, 153, 153));
        table_Pacientes.setMinimumSize(new java.awt.Dimension(600, 100));
        table_Pacientes.setRowHeight(25);
        table_Pacientes.setSelectionForeground(new java.awt.Color(51, 51, 51));
        table_Pacientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_Pacientes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1320, 480));

        btnAgregarPaciente.setBackground(new java.awt.Color(62, 202, 151));
        btnAgregarPaciente.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPaciente.setText("NUEVO PACIENTE");
        btnAgregarPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 40));

        btnEditar_Datos_Paciente.setBackground(new java.awt.Color(62, 202, 151));
        btnEditar_Datos_Paciente.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEditar_Datos_Paciente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar_Datos_Paciente.setText("EDITAR DATOS DE PACIENTE");
        btnEditar_Datos_Paciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar_Datos_Paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_Datos_PacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar_Datos_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 260, 40));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, 32, 32));

        btnCopiar_Dni.setBackground(new java.awt.Color(62, 134, 203));
        btnCopiar_Dni.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnCopiar_Dni.setForeground(new java.awt.Color(255, 255, 255));
        btnCopiar_Dni.setText("COPIAR DNI");
        btnCopiar_Dni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCopiar_Dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiar_DniActionPerformed(evt);
            }
        });
        jPanel1.add(btnCopiar_Dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 150, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 220, 40, 40));

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorder(null);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 220, 180, 40));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 220, 40, 40));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 270, 40));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(62, 134, 203));
        jLabel3.setText("BUSCAR POR DNI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, 170, 20));
        jPanel1.add(lblLineaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 260, 180, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPacienteActionPerformed
        F_Agregar_Paciente agregar_paciente = new F_Agregar_Paciente();
        agregar_paciente.setVisible(true);
    }//GEN-LAST:event_btnAgregarPacienteActionPerformed

    private void btnEditar_Datos_PacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_Datos_PacienteActionPerformed
        int selectedRow = table_Pacientes.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro de la tabla para modificar los datos.");
        } else {
            int id_paciente_seleccionado = (int) table_Pacientes.getValueAt(selectedRow, 0);
            
            String nombre_paciente = table_Pacientes.getValueAt(selectedRow, 1).toString();
            String apellido_paciente = table_Pacientes.getValueAt(selectedRow, 2).toString();
            String dni_paciente = table_Pacientes.getValueAt(selectedRow, 3).toString();
            String edad_paciente = table_Pacientes.getValueAt(selectedRow, 4).toString();
            String enfermedad_paciente = table_Pacientes.getValueAt(selectedRow, 5).toString();
            String celular_paciente = table_Pacientes.getValueAt(selectedRow, 6).toString();
            
            java.sql.Timestamp timestamp = (java.sql.Timestamp) table_Pacientes.getValueAt(selectedRow, 7);
            Date fecha_ingreso = new Date(timestamp.getTime());
            
            F_Modificar_Paciente modificar_paciente = new F_Modificar_Paciente();
            
            modificar_paciente.setVisible(true);
            modificar_paciente.setResizable(false);
            modificar_paciente.setLocationRelativeTo(null);

            // Bloquear la funcionalidad de pegar (Ctrl+V) para evitar que se pegue texto
            modificar_paciente.txtDni.setTransferHandler(null);
            modificar_paciente.txtNombre.setTransferHandler(null);
            modificar_paciente.txtApellidos.setTransferHandler(null);
            modificar_paciente.txtCelular.setTransferHandler(null);
            modificar_paciente.txtEdad.setTransferHandler(null);
            modificar_paciente.txaDescripcion.setTransferHandler(null);
            
            modificar_paciente.txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)
                            || modificar_paciente.txtNombre.getText().length() >= 100) {
                        evt.consume();
                    }
                }
            });
            
            modificar_paciente.txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)
                            || modificar_paciente.txtApellidos.getText().length() >= 100) {
                        evt.consume();
                    }
                }
            });
            
            modificar_paciente.txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
                            || modificar_paciente.txtCelular.getText().length() >= 15) {
                        evt.consume();
                    }
                }
            });
            
            modificar_paciente.txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
                            || modificar_paciente.txtEdad.getText().length() >= 4) {
                        evt.consume();
                    }
                }
            });
            
            modificar_paciente.txaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if (!(Character.isLetterOrDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)) {
                        evt.consume();
                    }
                }
            });
            
            modificar_paciente.txtNombre.setText(nombre_paciente);
            modificar_paciente.txtApellidos.setText(apellido_paciente);
            modificar_paciente.txtCelular.setText(celular_paciente);
            modificar_paciente.txtDni.setText(dni_paciente);
            modificar_paciente.txtEdad.setText(edad_paciente);
            modificar_paciente.txaDescripcion.setText(enfermedad_paciente);
            modificar_paciente.dateFecha_Ingreso.setDate(fecha_ingreso);
            
            modificar_paciente.dateFecha_Ingreso.setEnabled(false);
            
        }
    }//GEN-LAST:event_btnEditar_Datos_PacienteActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos_Paciente();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCopiar_DniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiar_DniActionPerformed
        int selectedRow = table_Pacientes.getSelectedRow();
        
        if (selectedRow != -1) {
            String dni = table_Pacientes.getValueAt(selectedRow, 3).toString(); // Suponiendo que la posición del DNI es la columna 3 (índice 2)

            // Obtener el sistema de portapapeles
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Almacenar el DNI en el portapapeles
            StringSelection stringSelection = new StringSelection(dni);
            clipboard.setContents(stringSelection, null);

            // Modificar el texto del JLabel
            jLabel2.setText("<html><i>DNI: '" + dni + "'. Copiado correctamente</i></html>");

            // Crear un temporizador para ocultar el JLabel después de 3 segundos (3000 milisegundos)
            Timer timer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ocultar el JLabel
                    jLabel2.setText("");
                }
            });

            // Iniciar el temporizador
            timer.setRepeats(false); // Hacer que el temporizador se ejecute una sola vez
            timer.start();
        } else {
            jLabel2.setText("Por favor, seleccione un registro.");
        }
    }//GEN-LAST:event_btnCopiar_DniActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dniBusqueda = txtBuscar.getText().trim();
        
        DefaultTableModel model = (DefaultTableModel) table_Pacientes.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        table_Pacientes.setRowSorter(rowSorter);
        
        if (dniBusqueda.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            // Crear un filtro para el DNI en la columna correspondiente (supongamos que es la columna 3)
            rowSorter.setRowFilter(RowFilter.regexFilter(dniBusqueda, 3));
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed
    
    void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) table_Pacientes.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        table_Pacientes.setRowSorter(rowSorter);
        rowSorter.setRowFilter(null); // Elimina cualquier filtro aplicado
        txtBuscar.setText("");
    }
    
    void actualizarDatos_Paciente() {
        DefaultTableModel tableModel = (DefaultTableModel) table_Pacientes.getModel();
        tableModel.setRowCount(0); // Limpia los datos existentes en la tabla

        String query = "SELECT * FROM TB_PACIENTES";
        
        try {
            abrirConexion();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] rowData = new Object[]{
                    rs.getInt("id_paciente"),
                    rs.getString("nombre_paciente"),
                    rs.getString("apellido_paciente"),
                    rs.getString("dni_paciente"),
                    rs.getString("edad_paciente"),
                    rs.getString("enfermedad_paciente"),
                    rs.getString("celular_paciente"),
                    rs.getTimestamp("fecha_inscripcion")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarPaciente;
    public javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCopiar_Dni;
    private javax.swing.JButton btnEditar_Datos_Paciente;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLineaBuscar;
    public javax.swing.JTable table_Pacientes;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
