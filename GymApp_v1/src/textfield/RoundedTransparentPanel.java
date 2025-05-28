package textfield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTransparentPanel extends JPanel {
    private int cornerRadius;
    private Color borderColor;
    private int borderThickness;

    public RoundedTransparentPanel() {
        this(20, Color.BLACK, 1); // Default values: 20px radius, black border, 1px thickness
    }

    public RoundedTransparentPanel(int cornerRadius, Color borderColor, int borderThickness) {
        this.cornerRadius = cornerRadius;
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
        setOpaque(false); // Make panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Enable anti-aliasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Create rounded rectangle
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
            borderThickness / 2f, 
            borderThickness / 2f, 
            getWidth() - borderThickness, 
            getHeight() - borderThickness, 
            cornerRadius, 
            cornerRadius
        );
        
        // Draw the border only (no background fill)
        if (borderThickness > 0) {
            g2d.setColor(borderColor);
            g2d.setStroke(new BasicStroke(borderThickness));
            g2d.draw(roundedRectangle);
        }
        
        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 150); // Default preferred size
    }

    // Getters and setters for customization
    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
        repaint();
    }
}
