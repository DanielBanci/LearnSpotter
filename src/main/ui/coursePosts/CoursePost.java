package main.ui.coursePosts;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.classes.Course;
import main.ui.content.MainPanel;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.TextAreaWithPreview;
import main.ui.ratingBar.StarRatingBar;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
											//TO DO: implement constructors with parameters
public class CoursePost extends RoundPanel {
	private JTextField tFCourseTitle;		//title of the course
	private JLabel lblName;					//owner of the course
	private TextAreaWithPreview tADescription;		//short description of the course; -> probably the first few lines from the description
	private StarRatingBar ratingBar;		//the rating bar - needs to be non-editable for a post
	private JLabel lblNrViewsRating;		//the number of the people who rated the course
	private JTextField txtCoursePrice;		//price of the course
	private JButton btnDetails;				//the button for opening the course panel
	

	public CoursePost(Course course) {
		this();
		btnDetails.addActionListener(makeDetailsActionListener(course));
	}
	
	private ActionListener makeDetailsActionListener(Course course) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().setLayout(new BoxLayout(MainPanel.getInstance().getContent(),BoxLayout.Y_AXIS));
				MainPanel.getInstance().getContent().add(new CoursePostDetails(course, MainPanel.getInstance().getContent()));
				MainPanel.getInstance().getContent().revalidate();
			}
		};
	}
	/**
	 * Create the panel(ui components)
	 */
	public CoursePost() {
		setMaximumSize(new Dimension(400, 32767));
		//ui
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		add(titlePanel);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
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
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Posted by: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblNewLabel_2);
		
		lblName = new JLabel("FirstName LastName");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblName);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 40));
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Short description: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new RoundPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		tADescription = new TextAreaWithPreview();
		panel_1.add(tADescription, BorderLayout.CENTER);
		tADescription.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tADescription.setOpaque(false);
		tADescription.setTextBody("The course presents the fundamentals of crating a project plan.It has a creative and funny structure that will help you understand it very quickly and you'll finsh it before you know it.Have fun learning about Software Engineering.");
		tADescription.setBorder(new EmptyBorder(5, 10, 0, 10));
		tADescription.setEditable(false);
		tADescription.setMaximumSize(new Dimension(2147483647, 100));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Price: ");
		panel_5.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtCoursePrice = new JTextField();
		panel_5.add(txtCoursePrice);
		txtCoursePrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtCoursePrice.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtCoursePrice.setOpaque(false);
		txtCoursePrice.setText("299 RON");
		txtCoursePrice.setMaximumSize(new Dimension(100, 40));
		txtCoursePrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCoursePrice.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_4.add(panel_6);
		
		btnDetails = new RoundButton("Details");
		panel_6.add(btnDetails);
		btnDetails.setFocusable(false);
		btnDetails.setForeground(Color.WHITE);
		btnDetails.setBackground(new Color(0, 113, 20));
		btnDetails.setBorder(null);
		
		btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDetails.setPreferredSize(new Dimension(150, 30));
		btnDetails.setMinimumSize(new Dimension(100, 30));
		btnDetails.setMaximumSize(new Dimension(100, 30));
		btnDetails.setOpaque(false);
		

	}
	
}
