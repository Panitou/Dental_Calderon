package proyecto.clinica_dental_calderon.Form;

import javax.swing.ImageIcon;

/**
 *
 * @author jcald
 */
public class Panel_Inicio extends javax.swing.JPanel {

    String fondo = "/images/Opacidad.png";

    ImageIcon fondoImagen = new ImageIcon(F_Sistema.class.getResource(fondo));

    public Panel_Inicio() {
        initComponents();
        
        lblFondo.setIcon(fondoImagen);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFondo = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1365, 770));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 770));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
