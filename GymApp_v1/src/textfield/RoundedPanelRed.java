
package textfield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanelRed extends JPanel {
    private int cornerRadius;
    private Color backgroundColor;
    private Color borderColor;
    private int borderThickness;

    // Default red theme constructor
    public RoundedPanelRed() {
        this(20, new Color(230, 50, 50), new Color(180, 30, 30), 2);
    }

    public RoundedPanelRed(int cornerRadius, Color backgroundColor, Color borderColor, int borderThickness) {
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
        
        // Enable anti-aliasing
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
        
        // Fill with background color
        g2d.setColor(backgroundColor);
        g2d.fill(roundedRectangle);
        
        // Draw border
        if (borderThickness > 0) {
            g2d.setColor(borderColor);
            g2d.setStroke(new BasicStroke(borderThickness));
            g2d.draw(roundedRectangle);
        }
        
        g2d.dispose();
    }

    // Example usage with red theme
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            JFrame frame = new JFrame("Red Rounded Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.getContentPane().setBackground(Color.WHITE);
            frame.setLayout(new BorderLayout(10, 10));

            // Create red rounded panel
            RoundedPanel redPanel = new RoundedPanel();
            redPanel.setLayout(new BorderLayout());
            redPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // Add content with appropriate colors
            JLabel title = new JLabel("Important Notice", SwingConstants.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 16));
            title.setForeground(Color.WHITE);
            redPanel.add(title, BorderLayout.NORTH);

            JTextArea content = new JTextArea("This panel uses a vibrant red theme to draw attention to important information. The white text provides good contrast against the red background.");
            content.setFont(new Font("Arial", Font.PLAIN, 12));
            content.setForeground(Color.WHITE);
            content.setBackground(redPanel.backgroundColor);
            content.setLineWrap(true);
            content.setWrapStyleWord(true);
            content.setEditable(false);
            content.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            redPanel.add(content, BorderLayout.CENTER);

            // Add a button with complementary styling
            JButton actionButton = new JButton("Take Action");
            actionButton.setBackground(new Color(255, 255, 255));
            actionButton.setForeground(redPanel.backgroundColor);
            actionButton.setFont(new Font("Arial", Font.BOLD, 12));
            actionButton.setFocusPainted(false);
            actionButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
            ));
            redPanel.add(actionButton, BorderLayout.SOUTH);

            frame.add(redPanel, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
