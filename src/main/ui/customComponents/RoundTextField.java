package main.ui.customComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * This class is a round text field.
 * @author Daniel
 * @version 1.0
 */
public class RoundTextField extends JTextField {
    private Shape shape;

    /**
     * Constructs a new RoundTextField object with opaque set to false.
     */
    public RoundTextField() {
        super();
        setOpaque(false);
    }
    /**
     * Paints the component's background with a rounded rectangular shape and then calls
     * the super class's paintComponent() method to paint the component's text.
     *
     * @param g the Graphics context to use for painting
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }
    /**
     * Paints the component's border with a rounded rectangular shape.
     *
     * @param g the Graphics context to use for painting
     */
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    /**
     * Checks if the specified point is contained within the rounded rectangular shape of the component.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return true if the point is contained within the shape of the component, false otherwise
     */
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
