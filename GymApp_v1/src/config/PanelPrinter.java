package config;

import java.awt.*;
import java.awt.print.*;
import javax.swing.JPanel;

public class PanelPrinter implements Printable {

    private JPanel panelToPrint;

    public PanelPrinter(JPanel panelToPrint) {
        this.panelToPrint = panelToPrint;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;

        // Set custom receipt size: 3.125 x 11.7 inches (approx 80mm wide)
        double width = 3.125 * 72; // width in points
        double height = 11.7 * 72; // height in points
        Paper paper = new Paper();
        paper.setSize(width, height);

        // Set small margins (e.g., 0.2 inch)
        double margin = 14.4; // 0.2 inch in points
        paper.setImageableArea(margin, margin, width - 2 * margin, height - 2 * margin);
        pageFormat.setOrientation(PageFormat.PORTRAIT);
        pageFormat.setPaper(paper);

        // Get panel dimensions
        double panelWidth = panelToPrint.getWidth();
        double panelHeight = panelToPrint.getHeight();

        // Calculate scaling factor
        double scaleX = pageFormat.getImageableWidth() / panelWidth;
        double scaleY = pageFormat.getImageableHeight() / panelHeight;
        double scale = Math.min(scaleX, scaleY);

        // Apply transformations
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.scale(scale, scale);

        // Center the panel
        double xOffset = (pageFormat.getImageableWidth() / scale - panelWidth) / 2;
        double yOffset = (pageFormat.getImageableHeight() / scale - panelHeight) / 2;
        g2d.translate(xOffset, yOffset);

        // Print the panel
        panelToPrint.printAll(g2d);

        return Printable.PAGE_EXISTS;
    }

    public void printPanel() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
