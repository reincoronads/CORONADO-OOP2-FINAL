package textfield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanelWhite extends JPanel {
    private int cornerRadius;
    private Color backgroundColor;
    private Color borderColor;
    private int borderThickness;

    public RoundedPanelWhite() {
        this(20, new Color(255, 255, 255), new Color(220, 220, 220), 1); // Default light values
    }

    public RoundedPanelWhite(int cornerRadius, Color backgroundColor, Color borderColor, int borderThickness) {
        this.cornerRadius = cornerRadius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
        setOpaque(false);
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
        
        // Fill the background
        g2d.setColor(backgroundColor);
        g2d.fill(roundedRectangle);
        
        // Draw the border
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

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
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

    // Example usage
    public static void main(String[] args) {
        // Set light theme for the entire application
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Panel.background", Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Light Rounded Panel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());

        // Create rounded panel
        RoundedPanelWhite roundedPanel = new RoundedPanelWhite();
        roundedPanel.setLayout(new BorderLayout());
        
        // Add some content
        JLabel label = new JLabel("Light Rounded Panel", SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        roundedPanel.add(label, BorderLayout.CENTER);
        
        // Add a button with light styling
        JButton button = new JButton("Click Me");
        button.setBackground(new Color(240, 240, 240));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        roundedPanel.add(button, BorderLayout.SOUTH);

        frame.add(roundedPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
