package textfield;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class panelMemDraggable extends JPanel {
    private Color backgroundColor = new Color(211, 211, 211);
    private Color hoverColor = new Color(80, 80, 90);
    private Color pressedColor = new Color(30, 30, 35);
    private Color borderColor = new Color(80, 80, 90);
    private int borderRadius = 20;
    private int shadowSize = 8;
    private Point initialClick;
    private boolean isDraggable = true;
    private boolean isHovered = false;
    private boolean isPressed = false;

    public panelMemDraggable() {
        setOpaque(false);
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setBackground(backgroundColor);
        
        // Mouse listeners for drag and hover effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isDraggable) {
                    initialClick = e.getPoint();
                }
                isPressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                setCursor(new Cursor(isDraggable ? Cursor.MOVE_CURSOR : Cursor.DEFAULT_CURSOR));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDraggable && initialClick != null) {
                    int thisX = getLocation().x;
                    int thisY = getLocation().y;

                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    int newX = thisX + xMoved;
                    int newY = thisY + yMoved;
                    
                    setLocation(newX, newY);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Determine current state color
        Color currentColor;
        if (isPressed) {
            currentColor = pressedColor;
        } else if (isHovered) {
            currentColor = hoverColor;
        } else {
            currentColor = backgroundColor;
        }

        // Draw shadow
        if (shadowSize > 0) {
            int shadowOffset = 2;
            g2.setColor(new Color(0, 0, 0, 50));
            g2.fillRoundRect(
                shadowOffset, 
                shadowOffset, 
                getWidth() - shadowSize, 
                getHeight() - shadowSize, 
                borderRadius, 
                borderRadius
            );
        }

        // Draw main panel
        g2.setColor(currentColor);
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

        // Draw border
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);
        }

        g2.dispose();
        super.paintComponent(g);
    }

    // Property accessors
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
        repaint();
    }

    public Color getPressedColor() {
        return pressedColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        repaint();
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        repaint();
    }

    public boolean isDraggable() {
        return isDraggable;
    }

    public void setDraggable(boolean draggable) {
        this.isDraggable = draggable;
        setCursor(new Cursor(draggable ? Cursor.MOVE_CURSOR : Cursor.DEFAULT_CURSOR));
    }
}
