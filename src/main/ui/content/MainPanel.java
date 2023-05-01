package main.ui.content;

import javax.swing.JPanel;

import main.ui.coursePosts.CoursePostDetails;
import main.ui.customComponents.RoundImagePanel;

import javax.swing.BoxLayout;
import java.awt.Dimension;

/**
 * The main panel of the app.
 * It has 2 panels, one on the top with the logo, a search  bar and the menu.
 * And another one where the content will be displayed.
 * @author Daniel
 * @version 1.0
 */
public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new TopPanel();
		topPanel.setMaximumSize(new Dimension(32767, 150));
		topPanel.setMinimumSize(new Dimension(50,100));
		topPanel.setPreferredSize(new Dimension(800,150));
		add(topPanel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
		contentPanel.add(new CoursePostDetails(true));
		/*JPanel p = new RoundImagePanel("res/login_background.png",new Dimension(100,100));
		p.setOpaque(false);
		contentPanel.add(p);*/
		add(contentPanel);

	}

}
