package main.ui.coursePosts;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;

import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.ratingBar.StarRatingBar;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * The class represents a panel that display all the informations related to a course before buying it.
 * It let the user to buy the course and let him/her to see the course.
 * @author Daniel
 * @version 1.0
 */
public class CoursePostDetails extends RoundPanel {

	private JPanel profilePicPanel;		//profile pic
	private JLabel lblName;				//name of the author
	private JLabel lblCourseName;		//course title
	private JPanel ratingBarPanel;		//rating bar
	private JLabel lblNoViews;			//people number that rate this
	private JLabel lblPrice;			//the price of the course
	private JTextArea tAFullDescription;//full description of the course
	private JPanel filePanel;			//the panel with course file and pay/download button
	private JPanel feedbackPanel;		//feddback panel

	public CoursePostDetails(Boolean ToDo) {	//TO DO: constructor with parameters that fill the area with the properly information
		this();
		profilePicPanel.add(new RoundImagePanel("res/need_delete.jpg",new Dimension(200,220)),BorderLayout.CENTER);
		
		lblName.setText("Ana Popescu");
		lblCourseName.setText("Software Engineering");
		tAFullDescription.setText("ceva descriere cum o fi sa fie doar sa fie sa vedem cum e ca de ce nu dor asa");
		
		setMinimumSize(new Dimension(600,600));
		repaint();
		/*
		profilePicPanel =
		lblName =
		lblCourseName =
		ratingBarPanel =
		lblNoViews =
		lblPrice =
		tAFullDescription =
		filePanel =
		feedbackPanel =
		 */
	}

	/**
	 * Create the panel.
	 */
	public CoursePostDetails() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 10, 10));
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		profilePicPanel = new JPanel();
		profilePicPanel.setPreferredSize(new Dimension(100, 100));
		profilePicPanel.setMinimumSize(new Dimension(100, 100));
		profilePicPanel.setOpaque(false);
		profilePicPanel.setMaximumSize(new Dimension(200, 200));
		panel_1.add(profilePicPanel);
		profilePicPanel.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(200, 0));
		horizontalStrut_4.setMinimumSize(new Dimension(200, 0));
		horizontalStrut_4.setMaximumSize(new Dimension(200, 32767));
		profilePicPanel.add(horizontalStrut_4, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 200));
		verticalStrut.setMinimumSize(new Dimension(2, 200));
		verticalStrut.setMaximumSize(new Dimension(32767, 200));
		profilePicPanel.add(verticalStrut, BorderLayout.WEST);
		
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setMaximumSize(new Dimension(200, 50));
		panel_1.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblName = new JLabel("FirstName LastName");
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblName);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Course title: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel);

		lblCourseName = new JLabel("Inginerie Software");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblCourseName);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(2000, 5));
		panel_3.add(horizontalStrut_1);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		ratingBarPanel = new StarRatingBar(3,1);
		ratingBarPanel.setMinimumSize(new Dimension(130, 30));
		ratingBarPanel.setMaximumSize(new Dimension(200, 30));
		ratingBarPanel.setOpaque(false);
		panel_4.add(ratingBarPanel);

		lblNoViews = new JLabel("(x) views");
		lblNoViews.setMaximumSize(new Dimension(500, 20));
		lblNoViews.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoViews.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNoViews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNoViews);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(900, 5));
		panel_4.add(horizontalStrut);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		JLabel lblNewLabel_2 = new JLabel("Price: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_2);

		lblPrice = new JLabel("299 RON");
		lblPrice.setBorder(new EmptyBorder(0, 5, 0, 5));
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblPrice);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(2000, 5));
		panel_5.add(horizontalStrut_2);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_6.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		JLabel lblNewLabel_1 = new JLabel("Full description: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_7.add(lblNewLabel_1);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(2000, 10));
		panel_7.add(horizontalStrut_3);

		tAFullDescription = new JTextArea();
		tAFullDescription.setOpaque(false);
		tAFullDescription.setMaximumSize(new Dimension(2000, 2000));
		tAFullDescription.setBorder(new EmptyBorder(5, 5, 5, 5));
		tAFullDescription.setEditable(false);
		tAFullDescription.setLineWrap(true);
		panel_6.add(tAFullDescription);

		filePanel = new CourseFilePanel();//new JPanel();
		filePanel.setOpaque(false);
		add(filePanel);

		feedbackPanel = new JPanel();
		feedbackPanel.setOpaque(false);
		add(feedbackPanel);

	}

}
