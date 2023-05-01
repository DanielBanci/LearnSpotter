package main.ui.login;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.border.EmptyBorder;

import main.ui.customComponents.ImagePanel;

/**
 * The class represents the login content.
 * It has an image as background and a translucent left panel
 * Witch let the user to log in.
 * @author Daniel
 * @version 1.0
 */
public class LoginPanel extends ImagePanel {
	
	private JPanel textImage;
	private JPanel rightSupportPanel;
	private JPanel loginData;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		super("res/login_background.png",new Dimension(4000,4000));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		textImage = new ImagePanel("res/login_text_image.png",new Dimension(4000,4000));
		textImage.setOpaque(false);
		add(textImage);
		
		rightSupportPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the background color with an alpha value
                g.setColor(new Color(0, 0, 0, 128));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
		rightSupportPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        rightSupportPanel.setOpaque(false);
		rightSupportPanel.setMinimumSize(new Dimension(100, 10));
		rightSupportPanel.setMaximumSize(new Dimension(500, 32767));
		add(rightSupportPanel);
		rightSupportPanel.setLayout(new BoxLayout(rightSupportPanel, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		rightSupportPanel.add(panel);
		
		
		loginData = new LoginData();
		loginData.setPreferredSize(new Dimension(350, 239));
		loginData.setOpaque(false);
		rightSupportPanel.add(loginData);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		rightSupportPanel.add(panel_1);

	}

}
