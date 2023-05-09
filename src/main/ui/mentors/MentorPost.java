package main.ui.mentors;

import javax.swing.JPanel;

import main.app.App;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.TextAreaWithPreview;
import main.ui.ratingBar.StarRatingBar;
import main.utility.ImageLoader;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.GridLayout;

/**
 * Panel that display the main details of a mentor as a small post.
 * It provide a button to see the full details
 * @author Daniel
 * @version 1.0
 */
public class MentorPost extends RoundPanel {
	private JPanel ratingBarPanel;									//display the rating of the mentor
	private JPanel profilePicPanel;									//profile pic of the mentor
	private JLabel lblName;											//name of the mentor
	private JLabel lblNoReviews;									//number of reviews from feedback
	private JButton btnDetails;										//button to see full details
	private JLabel lblFieldName;									//the name of the field the mentor teach
	private JLabel lblProgramsNumber;								//the number of the programe he/she has
	private TextAreaWithPreview tADescription;								//description of the mentor

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
	 * Construct the panel and fill the proper data in the fields.		//TODO: fill the data properly
	 * @param TODO
	 */
	public MentorPost(Boolean TODO) {
		this();
		//profile pic
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(150,150)));
		
		//rating bar
		Container parent = ratingBarPanel.getParent();
		int index = findComponentIndex(parent,ratingBarPanel);
		parent.remove(ratingBarPanel);
		//ratingBarPanel = new StarRatingBar(4,1);		  				//TODO: give the proper rating value
		parent.add(ratingBarPanel,index);

		//lblName.setText();				//name
		
		//lblNoReviews.setText();			//no of reviews
		
		//lblFieldName.setText();			//filed name
		
		//lblProgramsNumber.setText();		//mentoring programs number
		
		//tADescription.setText();			//mentor's description
		tADescription.setTextBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Sed ac risus vitae velit sodales bibendum quis eget dui. "
                + "Morbi eget placerat ipsum. Donec nec mi in nisi aliquam volutpat non ac elit. "
                + "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
                + "Nulla facilisi. Sed tincidunt ex ac varius commodo. "
                + "Nam laoreet libero mauris, vel facilisis justo vehicula sed. "
                + "Pellentesque in bibendum velit. Nullam consequat quam ut neque mollis, "
                + "vitae porttitor sapien bibendum. Vivamus mollis purus in justo finibus, "
                + "vel ultricies velit vestibulum. Duis pretium auctor ipsum, a commodo libero consectetur eget.");
		
		//btnDetails						//button action

		SwingUtilities.invokeLater(() -> {								//for all the components to be displayed properly
			App.getInstance().getFrame().getContentPane().revalidate();
	    });
	}

	/**
	 * Create the panel. The ui components with default text example.
	 */
	public MentorPost() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		profilePicPanel = new JPanel();
		profilePicPanel.setOpaque(false);
		profilePicPanel.setPreferredSize(new Dimension(150, 150));
		profilePicPanel.setMinimumSize(new Dimension(100, 100));
		profilePicPanel.setMaximumSize(new Dimension(150, 150));
		panel.add(profilePicPanel);
		profilePicPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setMaximumSize(new Dimension(32767, 50));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_3);

		lblName = new JLabel("FirstName LastName");
		lblName.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblName);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setMaximumSize(new Dimension(32767, 60));
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_7);

		ratingBarPanel = new StarRatingBar(3,1);//new JPanel();
		panel_7.add(ratingBarPanel);
		ratingBarPanel.setOpaque(false);
		ratingBarPanel.setMinimumSize(new Dimension(150, 50));
		ratingBarPanel.setPreferredSize(new Dimension(150, 50));
		ratingBarPanel.setMaximumSize(new Dimension(150, 50));

		lblNoReviews = new JLabel("(10) views");
		panel_7.add(lblNoReviews);
		lblNoReviews.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(0, 20, 0, 0));
		panel_8.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_8.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_4.add(panel_8);

		btnDetails = new RoundButton("Details\r\n");
		btnDetails.setBackground(new Color(50, 104, 38));
		btnDetails.setOpaque(false);
		btnDetails.setPreferredSize(new Dimension(100, 30));
		btnDetails.setMinimumSize(new Dimension(70, 30));
		btnDetails.setMaximumSize(new Dimension(100, 30));
		btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(btnDetails);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_9.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("Field: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_10.add(lblNewLabel_1);
		
		lblFieldName = new JLabel("FieldName");
		lblFieldName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_10.add(lblFieldName);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_9.add(panel_11);
		
		JLabel lblNewLabel_2 = new JLabel("Programs number: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_11.add(lblNewLabel_2);
		
		lblProgramsNumber = new JLabel("3");
		lblProgramsNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_11.add(lblProgramsNumber);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_5.setMaximumSize(new Dimension(32767, 35));
		panel_5.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);

		JLabel lblNewLabel = new JLabel("Description: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel);

		JPanel panel_6 = new RoundPanel();
		panel_6.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setOpaque(false);
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		tADescription = new TextAreaWithPreview();
		tADescription.setLineWrap(true);
		tADescription.setWrapStyleWord(true);
		tADescription.setBorder(new EmptyBorder(0, 0, 0, 0));
		tADescription.setOpaque(false);
		panel_6.add(tADescription, BorderLayout.CENTER);


	}

}
