package main.ui.coursePosts;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;

import org.icepdf.core.pobjects.acroform.AdditionalActionsDictionary;

import main.app.App;
import main.classes.Course;
import main.classes.Feedback;
import main.classes.Mentor;
import main.ui.content.PaymentPanel;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.ratingBar.StarRatingBar;
import main.utility.ImageLoader;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.FlowLayout;

/**
 * The class represents a panel that display all the informations related to a course before buying it.
 * It let the user to buy the course and let him/her to see the course.
 * @author Daniel
 * @version 1.0
 */
public class CoursePostDetails extends RoundPanel {

	private JPanel profilePicPanel;			//profile pic
	private JLabel lblName;					//name of the author
	private JLabel lblCourseName;			//course title
	private StarRatingBar ratingBarPanel;	//rating bar
	private JLabel lblNoViews;				//people number that rate this
	private JLabel lblPrice;				//the price of the course
	private JTextArea tAFullDescription;	//full description of the course
	private JPanel filePanel;				//the panel with course file and pay/download button
	private JPanel feedbackPanel;			//feddback panel
	private JButton btnBuyCourse;			//button to buy the course
	private JLabel lblPriceBuy;				//lbl to display the price near buy button
	private JLabel lblLastUpdate;			//last date the course was updated
	private PaymentPanel paymentPanel;

	public PaymentPanel getPaymentPanel() {
		return paymentPanel;
	}


	public JPanel getFilePanel() {
		return filePanel;
	}


	/**
	 * Method that search for a panel index inside the container.
	 * @param target the panel in interest
	 * @return the index of the panel, -1 if not found
	 */
	public int findComponentIndex(Container container,Object target) {
		Component[] components = container.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i].equals(target)) {
				return i;
			}
		}
		return -1; // Component not found
	}

	/**
	 * Constructor that fills the files with related data.
	 * @param course params the need to be given
	 * @param suportPanel the panel with the pdf renderer -?
	 */
	public CoursePostDetails(Course course, JPanel courseDetailsParent,Boolean owned) {	//TODO: constructor with parameters that fill the area with the properly information
		this();
		//profile image
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(100,120)));

		//name, couse title, last update and description
		lblName.setText(course.getOwner().getFirstName() + " " + course.getOwner().getLastName());
		lblCourseName.setText(course.getName());
		lblPrice.setText(String.format("(%.2f) RON", course.getPrice()));
		tAFullDescription.setText(course.getDescription());
		lblLastUpdate.setText(course.getLastUpdate().toString());

		//overall feedback data
		Container parent = ratingBarPanel.getParent();
		int index = findComponentIndex(parent,ratingBarPanel);
		parent.remove(ratingBarPanel);
		ratingBarPanel = new StarRatingBar(course.getRating(), 1);
		parent.add(ratingBarPanel,index);

		//update the pdf renderer
		index = findComponentIndex(this,filePanel);
		this.remove(filePanel);
		filePanel = new CourseFilePanel(courseDetailsParent);
		this.add(filePanel,index);

		//display the feedback
		feedbackPanel.add(new FeedbackPanel(Feedback.createMockup()));
		feedbackPanel.add(new FeedbackPanel(Feedback.createMockup()));

		//action for buy button
		if(!owned) {
			btnBuyCourse.addActionListener(btnBuyActionListener());
		}else {
			btnBuyCourse.getParent().getParent().remove(btnBuyCourse.getParent());
			((CourseFilePanel)filePanel).setPayed(true);
		}
		

		//update panel
		setMaximumSize(new Dimension(800,100000));
		App.getInstance().getFrame().getContentPane().revalidate();
	}

	/**
	 * Acrion listener for buy course button.
	 * It display the panel that handle the payment							
	 * and if the payment was usccesfully made it will give access to the user to open the course 
	 * by pressing the view course button from CourseFilePanel (here filePanel)
	 * @return action listener for buy course button.
	 */
	private ActionListener btnBuyActionListener() {
		CoursePostDetails aux = this;
		ActionListener act = new ActionListener() {
			private Boolean paymentPanelIsDisplayed = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!((CourseFilePanel)filePanel).getPayed()) {		//check if the course wasn t bought
				if(!paymentPanelIsDisplayed) {
					paymentPanelIsDisplayed = true;
					if(paymentPanel == null) 						//check if not already created
						paymentPanel = new PaymentPanel(Double.valueOf(extractNumericChars(lblPriceBuy.getText())));
					
					//insert the panel properly
					int parentIndex = findComponentIndex(aux, btnBuyCourse.getParent());
					aux.add(paymentPanel,parentIndex+1);
					
					//update panel
					aux.revalidate();
					
				}else {												//if pressed again it hide the payment panel
					paymentPanelIsDisplayed = false;
					aux.remove(paymentPanel);
					aux.revalidate();
				}
				}else {												//notify the user that he/she alredy bought the course
					JPopupMenu popupMenu = new JPopupMenu();
					popupMenu.setOpaque(false);
					popupMenu.setBorder(new EmptyBorder(0,0,0,0));
					
					JLabel mes = new JLabel("You already bought this course!");
					mes.setForeground(Color.red);
					mes.setFont(new Font("Tahoma", Font.PLAIN, 16));
			        popupMenu.add(mes);
			        
			        //get the position to display the popup menu
			        int xPos = 0;
			        int yPos = - btnBuyCourse.getHeight();										//disply on top
			        popupMenu.show(btnBuyCourse,xPos ,yPos );
			        
			        Timer timer = new Timer(3000, new ActionListener() {						//visible for 3 sec
	                    @Override
	                    public void actionPerformed(ActionEvent evt) {
	                        popupMenu.setVisible(false);
	                    }
	                });
	                timer.setRepeats(false);
	                timer.start();
				}
			}
		};
		return act;
	}

	public static String extractNumericChars(String input) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c) || c == '.') {
				result.append(c);
			}
		}
		return result.toString();
	}


	/**
	 * Create the panel.
	 * UI with an default example input
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
		profilePicPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		profilePicPanel.setPreferredSize(new Dimension(100, 100));
		profilePicPanel.setMinimumSize(new Dimension(100, 100));
		profilePicPanel.setOpaque(false);
		profilePicPanel.setMaximumSize(new Dimension(100, 100));
		panel_1.add(profilePicPanel);
		profilePicPanel.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(100, 0));
		horizontalStrut_4.setMinimumSize(new Dimension(100, 0));
		horizontalStrut_4.setMaximumSize(new Dimension(100, 32767));
		profilePicPanel.add(horizontalStrut_4, BorderLayout.NORTH);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 100));
		verticalStrut.setMinimumSize(new Dimension(2, 100));
		verticalStrut.setMaximumSize(new Dimension(32767, 100));
		profilePicPanel.add(verticalStrut, BorderLayout.WEST);

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setMaximumSize(new Dimension(200, 50));
		panel_1.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));

		lblName = new JLabel("FirstName LastName");
		lblName.setBorder(new EmptyBorder(20, 0, 0, 0));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblName);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 20, 0, 0));
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_3.setMaximumSize(new Dimension(32767, 50));
		panel_3.setOpaque(false);
		panel_2.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel = new JLabel("Course title: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel);

		lblCourseName = new JLabel("Inginerie Software");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblCourseName);

		JPanel panel_4 = new JPanel();
		panel_4.setMaximumSize(new Dimension(32767, 50));
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		ratingBarPanel = new StarRatingBar(3,1);
		ratingBarPanel.setPreferredSize(new Dimension(150, 30));
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

		JPanel panel_5 = new JPanel();
		panel_5.setMaximumSize(new Dimension(32767, 50));
		panel_5.setOpaque(false);
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_11.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_11);

		JLabel lblNewLabel_2 = new JLabel("Price: ");
		panel_11.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblPrice = new JLabel("299 RON");
		panel_11.add(lblPrice);
		lblPrice.setBorder(new EmptyBorder(0, 5, 0, 5));
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_12.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_5.add(panel_12);

		JLabel lblNewLabel_4 = new JLabel("Last update: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_12.add(lblNewLabel_4);

		lblLastUpdate = new JLabel("16/09/2021");
		lblLastUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_12.add(lblLastUpdate);

		JPanel panel_13 = new JPanel();
		panel_13.setMaximumSize(new Dimension(32767, 100));
		panel_13.setOpaque(false);
		panel_2.add(panel_13);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_6.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Description: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_7.add(lblNewLabel_1);

		tAFullDescription = new JTextArea();
		tAFullDescription.setOpaque(false);
		tAFullDescription.setMaximumSize(new Dimension(2000, 2000));
		tAFullDescription.setBorder(new EmptyBorder(5, 5, 5, 5));
		tAFullDescription.setEditable(false);
		tAFullDescription.setLineWrap(true);
		panel_6.add(tAFullDescription);

		filePanel = new JPanel();
		filePanel.setOpaque(false);
		add(filePanel);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(10, 10, 10, 30));
		panel_9.setOpaque(false);
		add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		lblPriceBuy = new JLabel("( 299 RON ) ");
		lblPriceBuy.setMaximumSize(new Dimension(400, 13));
		lblPriceBuy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriceBuy.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblPriceBuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_9.add(lblPriceBuy);

		//image icon
		Image img = ImageLoader.getInstance().getDollarIcon();

		btnBuyCourse = new RoundButton("New button");
		btnBuyCourse.setFocusable(false);
		btnBuyCourse.setText("Buy course");
		btnBuyCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBuyCourse.setBackground(Color.GRAY);
		btnBuyCourse.setOpaque(false);
		btnBuyCourse.setMinimumSize(new Dimension(100, 30));
		btnBuyCourse.setPreferredSize(new Dimension(200, 30));
		btnBuyCourse.setMaximumSize(new Dimension(200, 30));
		btnBuyCourse.setIcon(new ImageIcon(img));
		panel_9.add(btnBuyCourse);

		feedbackPanel = new JPanel();
		feedbackPanel.setOpaque(false);
		add(feedbackPanel);
		feedbackPanel.setLayout(new BoxLayout(feedbackPanel, BoxLayout.Y_AXIS));

		JPanel panel_10 = new JPanel();
		panel_10.setMinimumSize(new Dimension(100, 100));
		panel_10.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		feedbackPanel.add(panel_10);

		JLabel lblNewLabel_3 = new JLabel("Feedback: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_10.add(lblNewLabel_3);

	}

}
