package proyecto.clinica_dental_calderon.Form;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Aguante Khea
 *
 * @author Panito
 */
public class PanelPrinter implements Printable {

    private JTextPane textPaneToPrint;
    private JPanel panelToPrint;

    public PanelPrinter(JTextPane textPaneToPrint, JPanel panelToPrint) {
        this.textPaneToPrint = textPaneToPrint;
        this.panelToPrint = panelToPrint;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        textPaneToPrint.setSize((int) pageFormat.getImageableWidth(), Integer.MAX_VALUE);
        textPaneToPrint.printAll(g2d);

        panelToPrint.paint(g2d);

        return Printable.PAGE_EXISTS;
    }

    public void printTextPaneAndPanel() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
