package textfield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanelBlue extends JPanel {
    private int cornerRadius = 20;
    private Color backgroundColor = new Color(173, 216, 230); // Light blue
    private Color borderColor = new Color(135, 206, 235); // Slightly darker light blue
    private int borderThickness = 2;
    private int shadowSize = 5;
    private boolean isHovered = false;
    private boolean isPressed = false;

    public RoundedPanelBlue() {
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add hover effects
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                isHovered = true;
                repaint();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                isHovered = false;
                repaint();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                isPressed = true;
                repaint();
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                isPressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Determine current color based on state
        Color currentColor;
        if (isPressed) {
            currentColor = new Color(150, 200, 220); // Pressed state - slightly darker
        } else if (isHovered) {
            currentColor = new Color(193, 226, 240); // Hover state - slightly lighter
        } else {
            currentColor = backgroundColor;
        }

        // Draw shadow
        if (shadowSize > 0) {
            g2d.setColor(new Color(0, 0, 0, 30)); // Lighter shadow for light panel
            g2d.fillRoundRect(
                shadowSize, 
                shadowSize, 
                getWidth() - shadowSize * 2, 
                getHeight() - shadowSize * 2, 
                cornerRadius, 
                cornerRadius
            );
        }

        // Draw main panel
        g2d.setColor(currentColor);
        g2d.fillRoundRect(
            0, 
            0, 
            getWidth() - shadowSize, 
            getHeight() - shadowSize, 
            cornerRadius, 
            cornerRadius
        );

        // Draw border
        if (borderThickness > 0) {
            g2d.setColor(borderColor);
            g2d.setStroke(new BasicStroke(borderThickness));
            g2d.drawRoundRect(
                borderThickness / 2, 
                borderThickness / 2, 
                getWidth() - shadowSize - borderThickness, 
                getHeight() - shadowSize - borderThickness, 
                cornerRadius, 
                cornerRadius
            );
        }

        g2d.dispose();
        super.paintComponent(g);
    }

    // Getters and setters for customization
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
        repaint();
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        repaint();
    }
}