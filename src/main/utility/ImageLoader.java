package main.utility;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

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
        }catch(IOException e){
            e.printStackTrace();
        }
	}
	
	public Image getDollarIcon() {return images.get("dollar_icon");}
	public Image getLockedIcon() {return images.get("locked_icon");}
	public Image getUnlockedIcon() {return images.get("unlocked_icon");}
	public Image getPdfIcon() {return images.get("pdf_icon");}
	public Image getUserIcon() {return images.get("user_icon");}
	
}
