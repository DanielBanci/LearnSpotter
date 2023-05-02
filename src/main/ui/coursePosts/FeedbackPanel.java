package main.ui.coursePosts;

import javax.swing.JPanel;

import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.ratingBar.StarRatingBar;
import main.utility.ImageLoader;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

/**
 * Panel that display a feedback message.
 * It contains the user profil pic, the user name, the rating they gave and a message
 * @author Daniel
 * @version 1.0
 */
public class FeedbackPanel extends JPanel {
	private JPanel feedBackPanel;								//Round panel that contains the feedback
	private StarRatingBar ratingBarPanel;						//The rating bar
	private JPanel profilePicPanel;								//The profile pic
	private JLabel lblName;										//the name of the user
	private JTextArea tAFeedbackMessage;						//the feedback message
	
	/**
	 * Constructor with parameters. It create the panel and fill the related data.
	 * @param TODO
	 */
	public FeedbackPanel(Boolean TODO) {
		this();
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(150,150)));
		lblName.setName("Ana Popescu");
		tAFeedbackMessage.setText("A really nice and easy to understand course! The course was well-organized and easy to navigate, "
				+ "and the content was presented in a clear and concise manner.Thank you for your hard work and dedication to your students' learning.");
	}

	/**
	 * Create the panel.
	 * UI components with a default example.
	 */
	public FeedbackPanel() {
		setOpaque(false);
		//setPreferredSize(new Dimension(600, 200));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(190, 206, 214));
		
		feedBackPanel = new RoundPanel();
		feedBackPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		feedBackPanel.setBackground(new Color(190, 206, 214));
		add(feedBackPanel);
		feedBackPanel.setLayout(new BoxLayout(feedBackPanel, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		feedBackPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		profilePicPanel = new JPanel();
		profilePicPanel.setPreferredSize(new Dimension(70, 70));
		profilePicPanel.setOpaque(false);
		profilePicPanel.setMinimumSize(new Dimension(70, 70));
		profilePicPanel.setMaximumSize(new Dimension(70, 70));
		panel.add(profilePicPanel);
		profilePicPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setMaximumSize(new Dimension(2000, 100));
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setMaximumSize(new Dimension(32767, 30));
		panel_3.setBorder(new EmptyBorder(0, 5, 0, 0));
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblName = new JLabel("FirstName LastName");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBorder(new EmptyBorder(0, 3, 0, 10));
		panel_3.add(lblName);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setMaximumSize(new Dimension(32767, 30));
		panel_1.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		ratingBarPanel = new StarRatingBar(3, 1);
		ratingBarPanel.setOpaque(false);
		ratingBarPanel.setMinimumSize(new Dimension(150, 30));
		ratingBarPanel.setMaximumSize(new Dimension(150, 30));
		panel_4.add(ratingBarPanel);
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setStrokeSize(3);
		panel_2.setMaximumSize(new Dimension(32767, 200));
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_2.setBackground(Color.WHITE);
		feedBackPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tAFeedbackMessage = new JTextArea();
		tAFeedbackMessage.setWrapStyleWord(true);
		tAFeedbackMessage.setMaximumSize(new Dimension(2000, 200));
		tAFeedbackMessage.setLineWrap(true);
		panel_2.add(tAFeedbackMessage,BorderLayout.CENTER);
	}

}
