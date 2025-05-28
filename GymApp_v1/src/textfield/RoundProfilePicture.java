package textfield; 

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.beans.*;

public class RoundProfilePicture extends JPanel {
    private Image image;
    private int borderSize = 5;
    private Color borderColor = Color.WHITE;
    private transient PropertyChangeSupport propertySupport;

    public RoundProfilePicture() {
        setOpaque(false);
        setPreferredSize(new Dimension(150, 150));
    }

    // Lazy initialization of PropertyChangeSupport
    private PropertyChangeSupport getPropertySupport() {
        if (propertySupport == null) {
            propertySupport = new PropertyChangeSupport(this);
        }
        return propertySupport;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        getPropertySupport().addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (propertySupport != null) {
            propertySupport.removePropertyChangeListener(listener);
        }
    }

    // Override paintComponent for circular clipping
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Create circular clip area
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);
        g2.setClip(circle);

        // Draw the image
        if (image != null) {
            g2.drawImage(getScaledImage(), 0, 0, width, height, this);
        } else {
            // Default background if no image is set
            g2.setColor(Color.LIGHT_GRAY);
            g2.fill(circle);
        }

        // Draw the border
        if (borderSize > 0) {
            g2.setClip(null);
            g2.setStroke(new BasicStroke(borderSize));
            g2.setColor(borderColor);
            g2.draw(circle);
        }

        g2.dispose();
    }

    // Helper method to scale the image
    private Image getScaledImage() {
        if (image == null) return null;

        BufferedImage scaledImage = new BufferedImage(
                getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = scaledImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g2.dispose();

        return scaledImage;
    }

    // Getters & Setters (required for JavaBean)
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        Image old = this.image;
        this.image = image;
        propertySupport.firePropertyChange("image", old, image);
        repaint();
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        int old = this.borderSize;
        this.borderSize = borderSize;
        propertySupport.firePropertyChange("borderSize", old, borderSize);
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        Color old = this.borderColor;
        this.borderColor = borderColor;
        propertySupport.firePropertyChange("borderColor", old, borderColor);
        repaint();
    }
}