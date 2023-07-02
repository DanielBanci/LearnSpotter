package main.ui.coursePosts;

import javax.swing.JPanel;

import main.app.App;
import main.classes.Feedback;
import main.classes.MentoringProgram;
import main.classes.User;
import main.ui.content.MainPanel;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.ratingBar.StarRatingBar;
import main.utility.ImageLoader;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

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
	private JPanel panel_5;
	private JLabel lblDate;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnPostFeedback;
	private User user; 
	private MentoringProgram mentoringProgram;
	
	public FeedbackPanel(Boolean truePostInterface,User user,MentoringProgram mentoringProgram) {
		this(truePostInterface);
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(150,150)));
		this.user = user;
		this.mentoringProgram = mentoringProgram;
		
		//display user data
		lblName.setText(user.getFirstName() + " " + user.getLastName());
		lblDate.setText(formatDate(new Date()));
		//display the rating
		Container parent = ratingBarPanel.getParent();
		int index = findComponentIndex(parent, ratingBarPanel);
		parent.remove(ratingBarPanel);
		ratingBarPanel = new StarRatingBar(1);
		parent.add(ratingBarPanel,index);
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				btnPostFeedback.addActionListener(postFeedbackActionListener());
			}
			
		});
		
		
	}
	
	public String formatDate(Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    return dateFormat.format(date);
	}
	
	private ActionListener postFeedbackActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String feedbackMessage = tAFeedbackMessage.getText();
				if(feedbackMessage.isEmpty()) {
					JOptionPane.showMessageDialog(null,"You need to write a message.",
							"Eroare",JOptionPane.ERROR_MESSAGE);
				}else {
					if(ratingBarPanel.getClicked() == -1) {
						JOptionPane.showMessageDialog(null,"You need to give a rating.",
								"Eroare",JOptionPane.ERROR_MESSAGE);
					}else {	//ok														TODO store and display new feedback
						feedbackMessage.isEmpty();		//message
						Date date = new Date(); 		//current date for new feddback post
						int rating = ratingBarPanel.getClicked() + 1;
						int id = 1;						//getLastFeedbackId() + 1;
						Feedback feedback = new Feedback(id,FeedbackPanel.this.user,feedbackMessage,rating,date);
						
						mentoringProgram.getFeedbacks().add(feedback);
						//TODO: store new feedback
						
						//TODO: get mentoring program from database and refresh the mentoringProgramDetails
						
						//display new feedback
						JPanel parent = (JPanel) FeedbackPanel.this.getParent();
						parent.add(new FeedbackPanel(feedback),1);
						tAFeedbackMessage.setText(null);
						
						JPanel parentRatingBar = (JPanel) ratingBarPanel.getParent();
						parentRatingBar.remove(ratingBarPanel);
						ratingBarPanel = new StarRatingBar(1);
						parentRatingBar.add(ratingBarPanel);
						
						
					}
				}
			}

		};
	}
	/**
	 * Constructor with parameters. It create the panel and fill the related data.
	 * @param feedback
	 */
	public FeedbackPanel(Feedback feedback) {
		this();
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(150,150)));
		lblName.setText(feedback.getUser().getFirstName() + " " + feedback.getUser().getLastName());
		tAFeedbackMessage.setText(feedback.getText());
		lblDate.setText(formatDate(feedback.getDate()));
		
		//display the rating
		Container parent = ratingBarPanel.getParent();
		int index = findComponentIndex(parent, ratingBarPanel);
		parent.remove(ratingBarPanel);
		ratingBarPanel = new StarRatingBar(feedback.getRating(),1);
		parent.add(ratingBarPanel,index);
		
		//ratingBarPanel.repaintIcon(feedback.getRating());
		ratingBarPanel.setLevel(feedback.getRating());			//functioneaza cu setLevel
		
		//update ui
		invalidate();
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
	 * Create the panel.
	 * UI components with a default example.
	 */
	public FeedbackPanel() {
		setOpaque(false);
		//setPreferredSize(new Dimension(600, 200));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(190, 206, 214));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		profilePicPanel.setPreferredSize(new Dimension(100, 100));
		profilePicPanel.setOpaque(false);
		profilePicPanel.setMinimumSize(new Dimension(70, 70));
		profilePicPanel.setMaximumSize(new Dimension(100, 100));
		panel.add(profilePicPanel);
		profilePicPanel.setLayout(new BorderLayout(0, 0));
		
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
		
		panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(400, 30));
		panel_5.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		
		lblDate = new JLabel("Date label");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(lblDate);
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setStrokeSize(3);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_2.setBackground(Color.WHITE);
		feedBackPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tAFeedbackMessage = new JTextArea();
		tAFeedbackMessage.setWrapStyleWord(true);
		tAFeedbackMessage.setLineWrap(true);
		panel_2.add(tAFeedbackMessage,BorderLayout.CENTER);
	}
	
	//for post
	public FeedbackPanel(Boolean postInterface) {
		setOpaque(false);
		//setPreferredSize(new Dimension(600, 200));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(190, 206, 214));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		profilePicPanel.setPreferredSize(new Dimension(100, 100));
		profilePicPanel.setOpaque(false);
		profilePicPanel.setMinimumSize(new Dimension(70, 70));
		profilePicPanel.setMaximumSize(new Dimension(100, 100));
		panel.add(profilePicPanel);
		profilePicPanel.setLayout(new BorderLayout(0, 0));
		
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
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setPreferredSize(new Dimension(400, 30));
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		
		lblDate = new JLabel("Date label");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(lblDate);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		feedBackPanel.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setStrokeSize(3);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_2.setBackground(Color.WHITE);
		panel_6.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tAFeedbackMessage = new JTextArea();
		tAFeedbackMessage.setWrapStyleWord(true);
		tAFeedbackMessage.setLineWrap(true);
		panel_2.add(tAFeedbackMessage,BorderLayout.CENTER);
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setMaximumSize(new Dimension(100, 32767));
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		btnPostFeedback = new RoundButton("Post");
		btnPostFeedback.setForeground(new Color(255, 255, 255));
		btnPostFeedback.setFocusable(false);
		btnPostFeedback.setBackground(new Color(0, 128, 0));
		btnPostFeedback.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPostFeedback.setPreferredSize(new Dimension(100, 30));
		panel_7.add(btnPostFeedback, BorderLayout.SOUTH);
	}

}
