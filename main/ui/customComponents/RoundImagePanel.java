package main.ui.customComponents;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * A panel that displays an image with a rounded rectangular shape.
 * It extends the ImagePanel class and overrides the paintComponent method to paint the image
 * clipped in the shape of a round rectangle.
 * @author Daniel
 *
 */
public class RoundImagePanel extends ImagePanel {

	private Shape shape;
	private int arcWidth = 1080;
	private int arcHeight = 1080;
	
	/**
	* Constructs a RoundImagePanel object that displays an image with the given maximum size.
	* @param img the image to display
	* @param maxSize the maximum size of the panel
	*/
	public RoundImagePanel(Image img,Dimension maxSize) {
		super(img,maxSize);
		setMaximumSize(maxSize);
		//setOpaque(false);
	}
	
	/**
	* Constructs a RoundImagePanel object that displays an image with the given path and maximum size.
	* @param path the path of the image to display
	* @param maxSize the maximum size of the panel
	*/
	public RoundImagePanel(String path,Dimension maxSize) {
		super(path,maxSize);
		setMaximumSize(maxSize);
		//setOpaque(false);
	}
	
	/**
     * Paints the component's background with a rounded rectangular shape and then calls
     * the super class's paintComponent() method to paint the component's text.
     *
     * @param g the Graphics context to use for painting
     */
    @Override
	public void paintComponent(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g.create();

        // create a clipping region in the shape of the round rectangle
        RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, arcWidth, arcHeight);
        g2d.clip(roundRect);

        // draw the clipped image
        super.paintComponent(g2d);

        g2d.dispose();
    }
    /**
     * Paints the component's border with a rounded rectangular shape.
     *
     * @param g the Graphics context to use for painting
     */
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcWidth, arcHeight);
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
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, arcWidth, arcHeight);
        }
        return shape.contains(x, y);
    }
}
