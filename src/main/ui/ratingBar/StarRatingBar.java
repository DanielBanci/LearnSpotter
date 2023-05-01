package main.ui.ratingBar;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * The class represents a rating bar with 5 stars.
 * @author Daniel
 * @version 1.0
 */
public class StarRatingBar extends JPanel{

	private boolean editable;								//whatever the rating bar is editable or not
	private int gap;										//gap between stars
	private final List<ImageIcon> iconList;					//icons
	private final List<JLabel> labelList = Arrays.asList(	//the labels for the icons
			new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel()
			);
	protected final ImageIcon defaultIcon;					//icon for non-rated stars
	protected int clicked = -1;								//the index of clicked star; ratingValue = clicked + 1;
	private transient MouseAdapter handler;					//action for rating bar

	/**
	 * Constructor of the class.
	 * It makes an editable rating bar with the default images for icons.
	 * @param gap the gap between JLabels
	 */
	public StarRatingBar(int gap) {
		super(new GridLayout(1, 5, gap * 2, gap * 2));
		this.gap = gap;
		editable = true;
		clicked = -1;	
		//star icon
		String path = "res/starOff.png";
		Image img;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			img = makeMissingImage();
			e.printStackTrace();
		}
		defaultIcon = new ImageIcon(img);

		ImageIcon star = makeStarImageIcon(img, new SelectedImageFilter(1f, 1f, 0f));
		iconList = Arrays.asList(star, star, star, star, star);
		EventQueue.invokeLater(() -> {
			for (JLabel l : labelList) {
				l.setIcon(defaultIcon);
				add(l);
			}
		});
		setPreferredSize(new Dimension(100,30));
		setOpaque(false);
	}

	/**
	 * Constructor of the class.
	 * It makes an non-editable rating bar with the default images for icons
	 * and it sets it's rating to the value of raringValue
	 * @param ratingValue the rating value
	 * @param gap the gap between JLabels
	 */
	public StarRatingBar(int ratingValue,int gap) {
		super(new GridLayout(1, 5, gap * 2, gap * 2));
		this.gap = gap;
		editable = false;
		clicked = ratingValue;
		//star icon
		String path = "res/starOff.png";
		Image img;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			img = makeMissingImage();
			e.printStackTrace();
		}
		defaultIcon = new ImageIcon(img);

		ImageIcon star = makeStarImageIcon(img, new SelectedImageFilter(1f, 1f, 0f));
		iconList = Arrays.asList(star, star, star, star, star);
		EventQueue.invokeLater(() -> {
			int index = ratingValue;
			for (JLabel l : labelList) {
				if(index > 0) {
					l.setIcon(star);
					index--;
				}else {
					l.setIcon(defaultIcon);
				}
				add(l);
			}
		});

		setPreferredSize(new Dimension(100,30));
		setOpaque(false);

	}

	private static ImageIcon makeStarImageIcon(Image image, ImageFilter filter) {
		FilteredImageSource producer = new FilteredImageSource(image.getSource(), filter);
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(producer));
	}

	/**
	 * Constructor of the class.
	 * It makes a custom editable rating bar.
	 * @param defaultIcon the icon for unselected stars icons
	 * @param list the list of selected stars icons
	 * @param gap the gap between JLabels
	 */
	protected StarRatingBar(ImageIcon defaultIcon, List<ImageIcon> list, int gap) {
		super(new GridLayout(1, 5, gap * 2, gap * 2));
		editable = true;
		clicked = -1;	
		this.defaultIcon = defaultIcon;
		this.iconList = list;
		this.gap = gap;
		EventQueue.invokeLater(() -> {
			for (JLabel l : labelList) {
				l.setIcon(defaultIcon);
				add(l);
			}
		});
		setPreferredSize(new Dimension(200,22));
		setOpaque(false);
	}

	/**
	 * Handle the missing icon.
	 * @return an icon to use in case of error to the firs try
	 */
	private static Image makeMissingImage() {
		Icon missingIcon = UIManager.getIcon("html.missingImage");
		System.out.println("missingImage");
		int iw = missingIcon.getIconWidth();
		int ih = missingIcon.getIconHeight();
		BufferedImage bi = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bi.createGraphics();
		missingIcon.paintIcon(null, g2, (16 - iw) / 2, (16 - ih) / 2);
		g2.dispose();
		return bi;
	}

	/**
	 * Returns a list of ImageIcon objects that are used for rating.
	 * @return a list of ImageIcon objects
	 */
	public List<ImageIcon> getIconList() {
		return iconList;
	}

	/**
	 * Returns a list of JLabel objects that contain the ImageIcon objects used for rating.
	 * @return a list of JLabel objects
	 */
	public List<JLabel> getLabelList() {
		return labelList;
	}

	/**
	 * Rating bar handler.
	 */
	@Override 
	public void updateUI() {
		removeMouseListener(handler);
		removeMouseMotionListener(handler);
		super.updateUI();

		if(iconList != null) {repaintIcon(clicked);}
		handler = new MouseAdapter() {
			@Override 
			public void mouseMoved(MouseEvent e) {
				if(editable)
					repaintIcon(getSelectedIconIndex(e.getPoint()));
			}

			@Override 
			public void mouseEntered(MouseEvent e) {
				if(editable)
					repaintIcon(getSelectedIconIndex(e.getPoint()));
			}

			@Override 
			public void mouseClicked(MouseEvent e) {
				if(editable) {
					clicked = getSelectedIconIndex(e.getPoint());	//clicked represents the rating value - 1;
					//rating value is clicked + 1
					System.out.println("Rating: " + (clicked + 1));
				}
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				if(editable)
					repaintIcon(clicked);
			}
		};
		addMouseListener(handler);
		addMouseMotionListener(handler);

	}

	/**
	 * Clears the rating by setting the clicked index to -1 and repainting the icons.
	 */
	public void clear() {
		clicked = -1;
		repaintIcon(clicked);
	}

	/**
	 * Set rating level to l.
	 * @param l the rating value.
	 */
	public void setLevel(int l) {
		clicked = l-1;
		repaintIcon(clicked);
	}

	/**
	 * This method takes a Point object representing the location of a JLabel and returns the index of the selected icon.
	 * @param p a Point object representing the location of a JLabel.
	 * @return the index of the selected icon or -1 if none was found.
	 */
	protected int getSelectedIconIndex(Point p) {
		for (int i = 0; i < labelList.size(); i++) {
			Rectangle r = labelList.get(i).getBounds();
			r.grow(gap, gap);
			if (r.contains(p)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Repaint the icons.
	 * @param index represents the position of the last "full" star
	 */
	protected void repaintIcon(int index) {
		for (int i = 0; i < labelList.size(); i++) {
			System.out.println("RepaintIcon");
			System.out.println(index);
			labelList.get(i).setIcon(i <= index ? iconList.get(i) : defaultIcon);
			labelList.get(i).invalidate();
		}
		repaint();
	}
}
