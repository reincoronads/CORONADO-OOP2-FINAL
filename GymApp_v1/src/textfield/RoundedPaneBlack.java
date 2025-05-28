/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfield;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPaneBlack extends JPanel {
    private int cornerRadius;
    private Color backgroundColor;
    private Color borderColor;
    private int borderThickness;

    public RoundedPaneBlack() {
        this(20, new Color(30, 30, 35), Color.BLACK, 1); // Default values
    }

    public RoundedPaneBlack(int cornerRadius, Color backgroundColor, Color borderColor, int borderThickness) {
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

    // Example usage
    public static void main(String[] args) {
        // Set dark theme for the entire application
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("control", new Color(30, 30, 35));
            UIManager.put("nimbusBase", new Color(20, 20, 25));
            UIManager.put("nimbusFocus", new Color(80, 80, 90));
            UIManager.put("nimbusSelectionBackground", new Color(60, 60, 70));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Rounded Panel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create rounded panel
        RoundedPaneBlack roundedPanel = new RoundedPaneBlack();
        roundedPanel.setLayout(new BorderLayout());
        
        // Add some content
        JLabel label = new JLabel("Dark Rounded Panel", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        roundedPanel.add(label, BorderLayout.CENTER);
        
        // Add a button with dark styling
        JButton button = new JButton("Click Me");
        button.setBackground(new Color(50, 50, 55));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        roundedPanel.add(button, BorderLayout.SOUTH);

        frame.add(roundedPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
