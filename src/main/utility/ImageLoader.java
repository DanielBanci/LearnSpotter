package main.utility;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.UIManager;

/**
 * Class that load all the images we'll use in the project(only from res folder).
 * It is a singleton class that store the images in a hash map.
 * @author Daniel
 * @version 1.0
 */
public class ImageLoader {

	private Map<String, Image> images; 
	private static ImageLoader instance;

	public static ImageLoader getInstance() {
		if(instance == null) {instance = new ImageLoader();}
		return instance;
	}

	private ImageLoader() {
		images = new HashMap<>();

		//load images
		Image img = null;
		try {
			//dollar_icon
			img = ImageIO.read(new File("res/dollar_icon.png"));
			images.put("dollar_icon", img);
			//locked_icon
			img = ImageIO.read(new File("res/locked_icon.png"));
			images.put("locked_icon", img);
			//unlocked_icon
			img = ImageIO.read(new File("res/unlocked_icon.png"));
			images.put("unlocked_icon", img);
			//pdf_icon
			img = ImageIO.read(new File("res/pdf_icon.png"));
			images.put("pdf_icon", img);
			//user_icon
			img = ImageIO.read(new File("res/user_icon.png"));
			images.put("user_icon", img);
			//card_icon
			img = ImageIO.read(new File("res/card_icon.png"));
			images.put("card_icon", img);
			//location_icon
			img = ImageIO.read(new File("res/location_icon.png"));
			images.put("location_icon", img);
			//study_icon
			img = ImageIO.read(new File("res/study_icon.png"));
			images.put("study_icon", img);
			//programs_number_icon
			img = ImageIO.read(new File("res/programs_number_icon.png"));
			images.put("programs_number_icon", img);
			//money_icon
			img = ImageIO.read(new File("res/money_icon.png"));
			images.put("money_icon", img);
			//logo
			img = ImageIO.read(new File("res/logo.png"));
			images.put("logo", img);
			//delete_icon_red
			img = ImageIO.read(new File("res/delete_icon_red.png"));
			images.put("delete_icon_red", img);
			//plus_icon
			img = ImageIO.read(new File("res/plus_icon.png"));
			images.put("plus_icon", img);
			//plus_icon_24
			img = ImageIO.read(new File("res/plus_icon_24.png"));
			images.put("plus_icon_24", img);
			//plus_icon_16
			img = ImageIO.read(new File("res/plus_icon_16.png"));
			images.put("plus_icon_16", img);
			//search_icon
			img = ImageIO.read(new File("res/search_icon.png"));
			images.put("search_icon", img);
			//search_icon_24
			img = ImageIO.read(new File("res/search_icon_24.png"));
			images.put("search_icon_24", img);
			//edit_icon
			img = ImageIO.read(new File("res/edit_icon.png"));
			images.put("edit_icon", img);
		}catch(IOException e){
			e.printStackTrace();makeMissingImage();

		}
	}

	public Image getDollarIcon() {return images.get("dollar_icon");}
	public Image getLockedIcon() {return images.get("locked_icon");}
	public Image getUnlockedIcon() {return images.get("unlocked_icon");}
	public Image getPdfIcon() {return images.get("pdf_icon");}
	public Image getUserIcon() {return images.get("user_icon");}
	public Image getCardIcon() {return images.get("card_icon");}
	public Image getLocationIcon() {return images.get("location_icon");}
	public Image getStudyIcon() {return images.get("study_icon");}
	public Image getProgramsNumberIcon() {return images.get("programs_number_icon");}
	public Image getMoneyIcon() {return images.get("money_icon");}
	public Image getLogo() {return images.get("logo");}
	public Image getDeleteIconRed() {return images.get("delete_icon_red");}
	public Image getPlusIcon() {return images.get("plus_icon");}
	public Image getPlusIcon24() {return images.get("plus_icon_24");}
	public Image getPlusIcon16() {return images.get("plus_icon_16");}
	public Image getSearchIcon() {return images.get("search_icon");}
	public Image getSearchIcon24() {return images.get("search_icon_24");}
	public Image getEditIcon() {return images.get("edit_icon");}


	/**
	 * Handle the missing icon.
	 * @return an icon to use in case of error to the firs try
	 */
	private static Image makeMissingImage() {
		Image missingIcon = (Image) UIManager.getIcon("html.missingImage");
		/*int iw = missingIcon.getWidth();
		int ih = missingIcon.getHeight();
		BufferedImage bi = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bi.createGraphics();
		missingIcon.paintIcon(null, g2, (16 - iw) / 2, (16 - ih) / 2);
		g2.dispose();*/
		return missingIcon;
	}
}
