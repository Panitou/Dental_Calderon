package proyecto.clinica_dental_calderon.Form;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author Panito GitHub https://github.com/Panitou
 */
public final class F_Login extends javax.swing.JFrame {

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

    String logo = "/images/diente.png";

    String portadaImagen = "/images/Equipo_DentalCalderon.png";
    String logoCuadrado = "/images/LogoDental.jpg";
    String ojoAbierto = "/images/ojo.png";
    String ojoCerrado = "/images/dormir.png";
    String Linea = "/images/linea.png";

    ImageIcon portada = new ImageIcon(F_Sistema.class.getResource(portadaImagen));
    ImageIcon logo_cuadrado = new ImageIcon(F_Sistema.class.getResource(logoCuadrado));
    ImageIcon ojo_abierto = new ImageIcon(F_Sistema.class.getResource(ojoAbierto));
    ImageIcon ojo_cerrado = new ImageIcon(F_Sistema.class.getResource(ojoCerrado));
    ImageIcon linea = new ImageIcon(F_Sistema.class.getResource(Linea));

    public F_Login() throws SQLException {
        initComponents();

        abrirConexion();

        //Validar user
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    evt.consume();
                }
            }
        });

        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtUsuario.getText().isEmpty() || txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
                    txtUsuario.setText("Ingrese su nombre de usuario");
                    txtUsuario.setForeground(new Color(204, 204, 204));
                }
            }
        });

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                    txtPass.requestFocus();
                }
            }
        });

        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(txtPass.getPassword()).equals("************")) {
                    txtPass.setText("");
                    txtPass.setForeground(Color.black);
                }
            }
        });

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    evt.consume();
                }
            }
        });

        this.setIconImage(new ImageIcon(F_Sistema.class.getResource(logo)).getImage());

        //---
        lblTeam.setIcon(portada);
        lblLogo.setIcon(logo_cuadrado);
        lblOjo1.setIcon(ojo_abierto);
        lblDormir.setIcon(ojo_cerrado);
        lblLine1.setIcon(linea);
        lblLine.setIcon(linea);
        //---

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        lblAcceder.requestFocus();
        lblOjo1.setVisible(false);
    }

    // Sobrescribir dispose para limpiar recursos
    public void CerrarFrame() {
        this.dispose(); // Llamar al método dispose original de JFrame
    }

    public void ProgresoBar() {
        BarraProgreso bp = new BarraProgreso();
        bp.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblAcceder = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblLine = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lblContra = new javax.swing.JLabel();
        lblLine1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsu = new javax.swing.JLabel();
        lblDormir = new javax.swing.JLabel();
        lblOjo1 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        lblTeam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clínica Dental Calderón");
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(590, 423));
        setName("Clínica Dental Calderón"); // NOI18N
        setSize(new java.awt.Dimension(590, 423));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        PanelLogin.setMinimumSize(new java.awt.Dimension(590, 423));
        PanelLogin.setLayout(null);
        PanelLogin.add(jLabel3);
        jLabel3.setBounds(530, 130, 250, 250);

        lblAcceder.setBackground(new java.awt.Color(51, 51, 51));
        lblAcceder.setFont(new java.awt.Font("Ubuntu Condensed", 1, 30)); // NOI18N
        lblAcceder.setForeground(new java.awt.Color(62, 134, 203));
        lblAcceder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcceder.setText("Iniciar Sesión");
        PanelLogin.add(lblAcceder);
        lblAcceder.setBounds(110, 290, 210, 39);
        PanelLogin.add(lblLogo);
        lblLogo.setBounds(60, 0, 300, 300);
        PanelLogin.add(lblLine);
        lblLine.setBounds(60, 520, 300, 2);

        txtPass.setFont(new java.awt.Font("Fira Code Light", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(204, 204, 204));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setText("************");
        txtPass.setBorder(null);
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPassMousePressed(evt);
            }
        });
        PanelLogin.add(txtPass);
        txtPass.setBounds(60, 490, 300, 30);

        lblContra.setFont(new java.awt.Font("Roboto Thin", 1, 18)); // NOI18N
        lblContra.setForeground(new java.awt.Color(62, 134, 203));
        lblContra.setText("CONTRASEÑA");
        PanelLogin.add(lblContra);
        lblContra.setBounds(60, 450, 170, 30);
        PanelLogin.add(lblLine1);
        lblLine1.setBounds(60, 430, 300, 2);

        txtUsuario.setFont(new java.awt.Font("Fira Code Light", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        PanelLogin.add(txtUsuario);
        txtUsuario.setBounds(60, 390, 300, 40);

        lblUsu.setFont(new java.awt.Font("Roboto Thin", 1, 18)); // NOI18N
        lblUsu.setForeground(new java.awt.Color(62, 134, 203));
        lblUsu.setText("USUARIO");
        PanelLogin.add(lblUsu);
        lblUsu.setBounds(60, 350, 110, 30);

        lblDormir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDormir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDormirMouseClicked(evt);
            }
        });
        PanelLogin.add(lblDormir);
        lblDormir.setBounds(370, 480, 40, 40);

        lblOjo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOjo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOjo1MouseClicked(evt);
            }
        });
        PanelLogin.add(lblOjo1);
        lblOjo1.setBounds(370, 480, 40, 40);

        btnIngresar.setBackground(new java.awt.Color(62, 134, 203));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("ENTRAR");
        btnIngresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        PanelLogin.add(btnIngresar);
        btnIngresar.setBounds(130, 540, 160, 50);

        getContentPane().add(PanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 630));
        getContentPane().add(lblTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 870, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int intentosFallidos = 0;

    void validarPass() {
        String username = txtUsuario.getText();
        String pass = String.valueOf(txtPass.getPassword());

        String query = "SELECT * FROM TB_USUARIO WHERE usuarios = ? AND contrasena = ?";

        try {
            abrirConexion(); // Abre la conexión aquí

            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                CerrarFrame();
                ProgresoBar();
            } else {
                intentosFallidos++;
                if (intentosFallidos >= 3) {
                    mostrarAyuda();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Intentos restantes: " + (3 - intentosFallidos));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cerrarRecursos();
            } catch (SQLException ex) {
                Logger.getLogger(F_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void mostrarAyuda() {
        int opcion = JOptionPane.showOptionDialog(null, "¿Necesitas ayuda para iniciar sesión?", "Ayuda",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");

        if (opcion == JOptionPane.YES_OPTION) {
            validarRespuestaOdontologo();
        } else {
            reiniciarIntentos();
        }
    }

    void validarRespuestaOdontologo() {
        String respuesta = JOptionPane.showInputDialog(null, "Escribe el nombre de un odontólogo de la clínica:");

        if (respuesta != null) {
            respuesta = respuesta.toLowerCase(); // Convertir la respuesta a minúsculas para comparar

            // Nombres permitidos para la validación
            String[] nombresPermitidos = {"oswaldo", "victor", "alexis"};

            boolean nombreValido = false;
            for (String nombre : nombresPermitidos) {
                if (respuesta.equals(nombre)) {
                    nombreValido = true;
                    break;
                }
            }

            if (nombreValido) {
                JOptionPane.showMessageDialog(null, "Acceso concedido."
                        + "\nUser: admin"
                        + "\nPassword: admin");
                reiniciarIntentos();
            } else {
                JOptionPane.showMessageDialog(null, "Nombre incorrecto. Intenta de nuevo.");
                validarRespuestaOdontologo(); // Volver a pedir el nombre
            }
        } else {
            reiniciarIntentos();
        }
    }

    void reiniciarIntentos() {
        intentosFallidos = 0;
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setForeground(new Color(204, 204, 204));
        txtPass.setText("************");
        txtPass.setForeground(new Color(204, 204, 204));
    }

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        //EVT
        //CONDICIONALES PARA VACIAR LOS TextFields si es que se entra en el
        //E IDENTIFICA SI SE A ESCRITO ALGO EN EL TEXT FIEL
        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }

        if (String.valueOf(txtPass.getPassword()).isEmpty()) {
            txtPass.setText("************");
            txtPass.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMousePressed
        //EVT
        //CONDICIONALES PARA VACIAR LOS TextFields si es que se entra en el
        //E IDENTIFICA SI SE A ESCRITO ALGO EN EL TEXT FIEL
        if (String.valueOf(txtPass.getPassword()).equals("************")) {
            txtPass.setText("");
            txtPass.setForeground(Color.black);
        }
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese su nombre de usuario");
            txtUsuario.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtPassMousePressed

    private void lblDormirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDormirMouseClicked
        txtPass.requestFocus();

        lblDormir.setVisible(false);
        lblOjo1.setVisible(true);
        txtPass.setEchoChar((char) 0);

    }//GEN-LAST:event_lblDormirMouseClicked

    private void lblOjo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOjo1MouseClicked
        lblOjo1.setVisible(false);
        lblDormir.setVisible(true);
        txtPass.setEchoChar('*');
    }//GEN-LAST:event_lblOjo1MouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        validarPass();
    }//GEN-LAST:event_btnIngresarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new F_Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblAcceder;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblDormir;
    private javax.swing.JLabel lblLine;
    private javax.swing.JLabel lblLine1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblOjo1;
    private javax.swing.JLabel lblTeam;
    private javax.swing.JLabel lblUsu;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
