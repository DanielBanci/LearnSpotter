package main.ui.customComponents;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * The ImagePanel class represents a JPanel that displays an image.
 * The image can be set either from a file path or from an Image object.
 * The panel automatically scales the image to fit the panel's dimensions,
 * while maintaining its aspect ratio.
 */
public class ImagePanel extends JPanel {

    private Image img;
    private Image scaled;
    private Dimension preferedSize;
    private Dimension maximumSize;

    /**
     * Default constructor.
     */
    public ImagePanel(Dimension max) {
    	maximumSize = max;
    }
    
    public void setImage(Image img) {
    	this.img = img;
    }
    /**
     *Constructs a new ImagePanel with an image loaded from the given file path.
     *The image is scaled to fit the preferred size of the panel.
     *@param path the path of the image file to load.
     *@param dim the preferred size of the panel.
     */
    public ImagePanel(String path,Dimension dim){
        try {
            img = ImageIO.read(new File(path));
        }catch(Exception e){
            e.printStackTrace();
        }
        preferedSize = new Dimension(50,50);
        maximumSize = dim;
        setOpaque(false);
    }

    /**
     *Constructs a new ImagePanel with the given image.
     *The image is scaled to fit the preferred size of the panel.
     *@param img the image to display.
     *@param dim the preferred size of the panel.
     */
    public ImagePanel(Image img,Dimension dim) {
        this.img = img;
        this.preferedSize = new Dimension(50,50);
        this.maximumSize = dim;
        setOpaque(false);
    }

    /**
     *Scales the image to fit the dimensions of the panel.
     */
    @Override
    public void invalidate() {
        super.invalidate();
        int width = getWidth();
        int height = getHeight();

        if (width > 0 && height > 0) {
        	if(width > maximumSize.width) {
        		width = maximumSize.width;
        	}
        	if(height > maximumSize.getHeight()) {
        		height = (int) maximumSize.getHeight();
        	}
            scaled = img.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
        }
    }

    /**
     *Returns the preferred size of the panel.
     *If the image has not been loaded, returns the preferred size provided at construction time.
     *@return the preferred size of the panel.
     */
    @Override
    public Dimension getPreferredSize() {
    	int width = img.getWidth(this);
        int height = img.getHeight(this);
        if (width > 0 && height > 0) {
        	if(width > maximumSize.getWidth()) {
        		width = (int) maximumSize.getWidth();
        	}
        	if(height > maximumSize.getHeight()) {
        		height = (int) maximumSize.getHeight();
        	}
        }
        	
        return img == null ? maximumSize : preferedSize;
    }

    /**
     *Paints the scaled image onto the panel.
     *@param g the Graphics object used for painting.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaled, 0, 0, null);
    }
}
