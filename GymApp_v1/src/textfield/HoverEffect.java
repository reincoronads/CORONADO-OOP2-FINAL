package textfield;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HoverEffect {
    private static final int ANIMATION_DURATION = 200;
    private static final int FRAME_RATE = 30;
    
    private final Color hoverColor;
    private Color originalColor;
    private Timer timer;
    private float progress;
    private boolean hovering;
    private boolean pressed;

    public HoverEffect(Color hoverColor) {
        this.hoverColor = hoverColor;
    }
    
    public void apply(JComponent component) {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!pressed) {
                    startHoverAnimation(component);
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!pressed) {
                    endHoverAnimation(component);
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                cancelAnimation();
                component.setBackground(hoverColor);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                if (component.contains(e.getPoint())) {
                    startHoverAnimation(component);
                } else {
                    endHoverAnimation(component);
                }
            }
        });
    }
    
    private void cancelAnimation() {
        if (timer != null) {
            timer.stop();
            // NetBeans 8.2 compatible listener removal
            ActionListener[] listeners = timer.getActionListeners();
            for (ActionListener listener : listeners) {
                timer.removeActionListener(listener);
            }
        }
    }
    
    private void startHoverAnimation(JComponent component) {
        originalColor = component.getBackground();
        hovering = true;
        startAnimation(component, true);
        component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    private void endHoverAnimation(JComponent component) {
        hovering = false;
        startAnimation(component, false);
        component.setCursor(Cursor.getDefaultCursor());
    }
    
    private void startAnimation(JComponent component, final boolean entering) {
        cancelAnimation();
        
        int delay = 1000 / FRAME_RATE;
        progress = entering ? Math.max(0f, progress) : Math.min(1f, progress);
        
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hovering && !pressed) {
                    progress += (float)delay / ANIMATION_DURATION;
                    if (progress >= 1f) {
                        progress = 1f;
                        timer.stop();
                    }
                } else if (!hovering && !pressed) {
                    progress -= (float)delay / ANIMATION_DURATION;
                    if (progress <= 0f) {
                        progress = 0f;
                        timer.stop();
                    }
                }
                component.setBackground(blendColors(originalColor, hoverColor, progress));
                component.repaint();
            }
        });
        timer.start();
    }
    
    private Color blendColors(Color start, Color end, float ratio) {
        ratio = Math.min(1f, Math.max(0f, ratio)); // Clamp between 0-1
        int r = (int)(start.getRed() + ratio * (end.getRed() - start.getRed()));
        int g = (int)(start.getGreen() + ratio * (end.getGreen() - start.getGreen()));
        int b = (int)(start.getBlue() + ratio * (end.getBlue() - start.getBlue()));
        return new Color(r, g, b);
    }
    
    public static void applyTo(JComponent component, Color hoverColor) {
        new HoverEffect(hoverColor).apply(component);
    }
    
    public boolean isPressed() {
        return this.pressed;
    }
}