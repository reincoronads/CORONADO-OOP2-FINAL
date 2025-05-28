package textfield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundPanelGreen extends JPanel {
    private int cornerRadius = 20;
    private Color backgroundColor = new Color(200, 255, 200); // Light green
    private Color borderColor = new Color(150, 220, 150); // Medium green border
    private int borderThickness = 1;
    private boolean isHovered = false;
    private boolean isPressed = false;

    public RoundPanelGreen() {
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Add hover effects
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                isHovered = true;
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                repaint();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                isHovered = false;
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
            currentColor = new Color(180, 230, 180); // Slightly darker when pressed
        } else if (isHovered) {
            currentColor = new Color(220, 255, 220); // Slightly lighter when hovered
        } else {
            currentColor = backgroundColor;
        }

        // Draw panel background
        g2d.setColor(currentColor);
        g2d.fillRoundRect(
            0, 
            0, 
            getWidth(), 
            getHeight(), 
            cornerRadius, 
            cornerRadius
        );

        // Draw border
        if (borderThickness > 0) {
            g2d.setColor(borderColor);
            g2d.setStroke(new BasicStroke(borderThickness));
            g2d.drawRoundRect(
                0, 
                0, 
                getWidth() - 1, 
                getHeight() - 1, 
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
}