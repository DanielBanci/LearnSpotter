package ui.content;

import javax.swing.JPanel;

import ui.customComponents.RoundButton;
import ui.customComponents.RoundPanel;
import ui.ratingBar.StarRatingBar;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
											//TO DO: implement constructors with parameters
public class CoursePost extends RoundPanel {
	private JTextField tFCourseTitle;		//title of the course
	private JLabel lblName;					//owner of the course
	private JTextArea tADescription;		//short description of the course; -> probably the first few lines from the description
	private StarRatingBar ratingBar;		//the rating bar - needs to be non-editable for a post
	private JLabel lblNrViewsRating;		//the number of the people who rated the course
	private JTextField txtCoursePrice;		//price of the course
	private JButton btnDetails;				//the button for opening the course panel
	

	/**
	 * Create the panel(ui components)
	 */
	public CoursePost() {					//TO DO: get rid of the hardcoded code
		//ui
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		add(titlePanel);
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Course title: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titlePanel.add(lblNewLabel);
		
		tFCourseTitle = new JTextField();
		tFCourseTitle.setEditable(false);
		tFCourseTitle.setBorder(new EmptyBorder(0, 10, 0, 0));
		tFCourseTitle.setOpaque(false);
		tFCourseTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFCourseTitle.setText("Inginerie Software");
		tFCourseTitle.setMaximumSize(new Dimension(2147483647, 40));
		titlePanel.add(tFCourseTitle);
		tFCourseTitle.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.setOpaque(false);
		add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_2 = new JLabel("Posted by: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblNewLabel_2);
		
		lblName = new JLabel("FirstName LastName");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblName);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(4000, 10));
		panel_2.add(horizontalStrut_2);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 40));
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Short description: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(32767, 32767));
		panel.add(horizontalStrut);
		
		tADescription = new JTextArea();
		tADescription.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tADescription.setOpaque(false);
		tADescription.setText("The course presents the fundamentals of crating a \r\nproject plan.It has a creative and funny structure \r\nthat will help you understand it very quickly and \r\nyou'll finsh it before you know it.\r\nHave fun learning about Software Engineering.");
		tADescription.setBorder(new EmptyBorder(5, 10, 0, 10));
		tADescription.setEditable(false);
		tADescription.setMaximumSize(new Dimension(2147483647, 100));
		add(tADescription);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_5 = new JLabel("Rating: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_5);
		
		ratingBar = new StarRatingBar(3,1);//new JPanel();
		ratingBar.setMinimumSize(new Dimension(200, 30));
		ratingBar.setMaximumSize(new Dimension(200, 30));
		ratingBar.setBorder(new EmptyBorder(0,0,0,0));
		panel_3.add(ratingBar);
		
		lblNrViewsRating = new JLabel("(10 reviews)  ");
		lblNrViewsRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(lblNrViewsRating);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(500, 10));
		panel_3.add(horizontalStrut_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_3 = new JLabel("Price: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_3);
		
		txtCoursePrice = new JTextField();
		txtCoursePrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtCoursePrice.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtCoursePrice.setOpaque(false);
		txtCoursePrice.setText("299 RON");
		txtCoursePrice.setMaximumSize(new Dimension(100, 40));
		txtCoursePrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(txtCoursePrice);
		txtCoursePrice.setColumns(10);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(220, 10));
		panel_1.add(horizontalStrut_1);
		
		btnDetails = new RoundButton("Details");
		btnDetails.setForeground(Color.WHITE);
		btnDetails.setBackground(new Color(0, 113, 20));
		btnDetails.setBorder(null);
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDetails.setPreferredSize(new Dimension(150, 30));
		btnDetails.setMinimumSize(new Dimension(100, 30));
		btnDetails.setMaximumSize(new Dimension(100, 30));
		btnDetails.setOpaque(false);
		panel_1.add(btnDetails);
		

	}

}
