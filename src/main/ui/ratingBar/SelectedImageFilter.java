package main.ui.ratingBar;

import java.awt.image.RGBImageFilter;

/**
 * The class implements an image filter that changes the color of an image to yellow.
 * @author Daniel
 * @version 1.0
 */
class SelectedImageFilter extends RGBImageFilter {
	  private final float rf;
	  private final float gf;
	  private final float bf;

	  /**
		 * Constructor of the class.
		 * It initializes the color values.
		 * @param rf the red value
		 * @param gf the green value
		 * @param bf the blue value
		 */
	  protected SelectedImageFilter(float rf, float gf, float bf) {
	    super();
	    this.rf = Math.min(1f, rf);
	    this.gf = Math.min(1f, gf);
	    this.bf = Math.min(1f, bf);
	    canFilterIndexColorModel = false;
	  }

	  /**
		 * Filters the pixel of the image.
		 * It changes it's color to yellow.
		 * @param x the x coordinate of the pixel
		 * @param y the y coordinate of the pixel
		 * @param argb the pixel
		 * @return the filtered pixel
		 */
	  @Override public int filterRGB(int x, int y, int argb) {
	    int r = Math.round(((argb >> 16) & 0xFF) * rf);
	    int g = Math.round(((argb >> 8) & 0xFF) * gf);
	    int b = Math.round((argb & 0xFF) * bf);
	    return (argb & 0xFF_00_00_00) | (r << 16) | (g << 8) | b;
	  }
	}
