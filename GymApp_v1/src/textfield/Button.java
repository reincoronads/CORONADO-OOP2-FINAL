package textfield;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Button extends JButton {  // Fixed: Now extends JButton
    private Color colorNormal = new Color(0, 0, 0, 0); // Transparent
    private Color colorOver = new Color(0, 0, 0, 20); // Slight black overlay
    private Color colorClick = new Color(0, 0, 0, 50); // Darker overlay when pressed
    private Color borderColor = Color.BLACK;
    private Color textColor = Color.BLACK;
    private int radius = 15; // Default corner radius

    public Button() {
        this(""); // Default constructor with empty text
    }
    
    public Button(String text) {
        super(text); // Call JButton constructor
        initButton();
    }
    
    private void initButton() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(textColor);
        setBackground(colorNormal);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorOver);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorNormal);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (contains(e.getPoint())) {
                    setBackground(colorOver);
                } else {
                    setBackground(colorNormal);
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Paint background (transparent or with overlay)
        if (getBackground().getAlpha() > 0) {  // Only paint if not fully transparent
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }
        
        // Paint border
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
        
        super.paintComponent(g);
    }

    // Getters and setters
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        setForeground(textColor);
        repaint();
    }
    
    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public int getRadius() {
        return radius;
    }
}