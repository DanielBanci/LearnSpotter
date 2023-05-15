package main.ui.mentors;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.classes.Mentor;
import main.classes.User;
import main.ui.customComponents.ImagePanel;
import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.ratingBar.StarRatingBar;
import main.utility.ImageLoader;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MentorProfile extends RoundPanel {
	
	private JPanel locationIconPanel;
	private JPanel studyIconPanel;
	private JPanel programsNumberIconPanel;
	private JPanel priceIconPanel;
	private JPanel registerdateIconPanel;
	private JPanel profilePicPanel;
	private MenuBar menuBar;
	private JPanel contentPanel;
	private JPanel ratingBarPanel;
	private JLabel lblMemberSince;
	private JLabel lblName;
	private JLabel lblViewsNumber;
	private JLabel lblProgramsNumber;
	private JLabel lblPrice;
	
	public MentorProfile(Boolean TODO,Mentor mentor,User user) {
		this(mentor,user);
		displayIcons();
		
		//display data
		lblName.setText(mentor.getFirstName() + " " + mentor.getLastName());
		lblMemberSince.setText(mentor.getRegisterDate().toString());
		lblViewsNumber.setText(String.valueOf(mentor.getNoReviews()));
		lblProgramsNumber.setText(String.valueOf(mentor.getProgramsNumber()));
		lblPrice.setText("");															//TODO see what you do with this
		
		//menu bar
		
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(250,250)));	//TODO chenge to mentor pic
		
		setMaximumSize(new Dimension(1000,100000));
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				getParent().revalidate();
				
			}
			
		});
	}
	
	public MentorProfile(Boolean TODO,Mentor mentor) {
		this(mentor);
		displayIcons();
		
		//display data
		lblName.setText(mentor.getFirstName() + " " + mentor.getLastName());
		lblMemberSince.setText(mentor.getRegisterDate().toString());
		lblViewsNumber.setText(String.valueOf(mentor.getNoReviews()));
		lblProgramsNumber.setText(String.valueOf(mentor.getProgramsNumber()));
		lblPrice.setText("");															//TODO see what you do with this
		
		//menu bar
		/*Container parent = menuBar.getParent();
		int index = findComponentIndex(parent, menuBar);
		parent.remove(menuBar);
		menuBar = new MenuBar(this,mentor);
		parent.add(menuBar,index);*/
		
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(250,250)));
		
		setMaximumSize(new Dimension(1000,100000));
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				getParent().revalidate();
				
			}
			
		});
	}
	
	private void displayIcons() {
		Container parent = locationIconPanel.getParent();
		int index = findComponentIndex(parent,locationIconPanel);
		parent.remove(locationIconPanel);
		locationIconPanel = new ImagePanel(ImageLoader.getInstance().getLocationIcon(),new Dimension(60,60));
		parent.add(locationIconPanel, index);
		
		parent = studyIconPanel.getParent();
		index = findComponentIndex(parent,studyIconPanel);
		parent.remove(studyIconPanel);
		studyIconPanel = new ImagePanel(ImageLoader.getInstance().getStudyIcon(),new Dimension(60,60));
		parent.add(studyIconPanel, index);
		
		parent = programsNumberIconPanel.getParent();
		index = findComponentIndex(parent,programsNumberIconPanel);
		parent.remove(programsNumberIconPanel);
		programsNumberIconPanel = new ImagePanel(ImageLoader.getInstance().getProgramsNumberIcon(),new Dimension(60,60));
		parent.add(programsNumberIconPanel, index);
		
		parent = priceIconPanel.getParent();
		index = findComponentIndex(parent,priceIconPanel);
		parent.remove(priceIconPanel);
		priceIconPanel = new ImagePanel(ImageLoader.getInstance().getMoneyIcon(),new Dimension(60,60));
		parent.add(priceIconPanel, index);
		
		parent = registerdateIconPanel.getParent();
		index = findComponentIndex(parent,registerdateIconPanel);
		parent.remove(registerdateIconPanel);
		registerdateIconPanel = new ImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(60,60));
		parent.add(registerdateIconPanel, index);
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
	

	public JPanel getContentPanel() {
		return contentPanel;
	}
	
	/**
	 * Create the panel.
	 */
	public MentorProfile(Mentor mentor) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setMaximumSize(new Dimension(500, 500));
		panel_2.setBorder(new EmptyBorder(15, 0, 0, 0));
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		profilePicPanel = new JPanel();
		profilePicPanel.setOpaque(false);
		profilePicPanel.setPreferredSize(new Dimension(200, 200));
		profilePicPanel.setMaximumSize(new Dimension(200, 200));
		panel_2.add(profilePicPanel);
		profilePicPanel.setLayout(new BoxLayout(profilePicPanel, BoxLayout.X_AXIS));
		
		JPanel ratingBarPanel3 = new JPanel();
		ratingBarPanel3.setBorder(new EmptyBorder(15, 0, 0, 0));
		ratingBarPanel3.setPreferredSize(new Dimension(350, 70));
		ratingBarPanel3.setOpaque(false);
		ratingBarPanel3.setMaximumSize(new Dimension(350, 100));
		panel_2.add(ratingBarPanel3);
		
		ratingBarPanel = new StarRatingBar(3,1);
		ratingBarPanel.setOpaque(false);
		ratingBarPanel3.add(ratingBarPanel);
		
		lblViewsNumber = new JLabel("(reviews)");
		lblViewsNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ratingBarPanel3.add(lblViewsNumber);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setMaximumSize(new Dimension(32767, 250));
		panel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[] {21, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setMaximumSize(new Dimension(32767, 70));
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 0;
		panel_3.add(panel_9, gbc_panel_9);
		
		lblName = new JLabel("FirstName LastName");
		panel_9.add(lblName);
		lblName.setBorder(new EmptyBorder(0, 5, 0, 5));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 1;
		panel_3.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		panel_8.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_8.setMaximumSize(new Dimension(32767, 100));
		
		locationIconPanel = new JPanel();
		locationIconPanel.setOpaque(false);
		locationIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_8.add(locationIconPanel);
		
		JLabel lblNewLabel = new JLabel("LocationName");
		lblNewLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_8.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_11.add(panel_5);
		panel_5.setOpaque(false);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_5.setMaximumSize(new Dimension(32767, 100));
		
		registerdateIconPanel = new JPanel();
		registerdateIconPanel.setOpaque(false);
		registerdateIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_5.add(registerdateIconPanel);
		
		lblMemberSince = new JLabel("registerDate");
		lblMemberSince.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblMemberSince);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setMaximumSize(new Dimension(32767, 100));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		panel_3.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_4);
		
		programsNumberIconPanel = new JPanel();
		programsNumberIconPanel.setOpaque(false);
		programsNumberIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_4.add(programsNumberIconPanel);
		
		lblProgramsNumber = new JLabel("Programs number");
		lblProgramsNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblProgramsNumber);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_10);
		
		priceIconPanel = new JPanel();
		priceIconPanel.setOpaque(false);
		priceIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_10.add(priceIconPanel);
		
		lblPrice = new JLabel("from min to max");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_10.add(lblPrice);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_7.setMaximumSize(new Dimension(32767, 100));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 3;
		panel_3.add(panel_7, gbc_panel_7);
		
		studyIconPanel = new JPanel();
		studyIconPanel.setOpaque(false);
		studyIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_7.add(studyIconPanel);
		
		JLabel lblNewLabel_1 = new JLabel("StudyFieldsNames");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 50));
		panel_1.setOpaque(false);
		add(panel_1);
		
		menuBar = new MenuBar(this,mentor);//MenuBar(this,null);
		panel_1.add(menuBar);
		
		contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));

	}

	//for user
	/**
	 * Create the panel.
	 */
	public MentorProfile(Mentor mentor,User user) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setMaximumSize(new Dimension(500, 500));
		panel_2.setBorder(new EmptyBorder(15, 0, 0, 0));
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		profilePicPanel = new JPanel();
		profilePicPanel.setOpaque(false);
		profilePicPanel.setPreferredSize(new Dimension(200, 200));
		profilePicPanel.setMaximumSize(new Dimension(200, 200));
		panel_2.add(profilePicPanel);
		profilePicPanel.setLayout(new BoxLayout(profilePicPanel, BoxLayout.X_AXIS));
		
		JPanel ratingBarPanel3 = new JPanel();
		ratingBarPanel3.setBorder(new EmptyBorder(15, 0, 0, 0));
		ratingBarPanel3.setPreferredSize(new Dimension(350, 70));
		ratingBarPanel3.setOpaque(false);
		ratingBarPanel3.setMaximumSize(new Dimension(350, 100));
		panel_2.add(ratingBarPanel3);
		
		ratingBarPanel = new StarRatingBar(3,1);
		ratingBarPanel.setOpaque(false);
		ratingBarPanel3.add(ratingBarPanel);
		
		lblViewsNumber = new JLabel("(reviews)");
		lblViewsNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ratingBarPanel3.add(lblViewsNumber);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setMaximumSize(new Dimension(32767, 250));
		panel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[] {21, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setMaximumSize(new Dimension(32767, 70));
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 0;
		panel_3.add(panel_9, gbc_panel_9);
		
		lblName = new JLabel("FirstName LastName");
		panel_9.add(lblName);
		lblName.setBorder(new EmptyBorder(0, 5, 0, 5));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 1;
		panel_3.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		panel_8.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_8.setMaximumSize(new Dimension(32767, 100));
		
		locationIconPanel = new JPanel();
		locationIconPanel.setOpaque(false);
		locationIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_8.add(locationIconPanel);
		
		JLabel lblNewLabel = new JLabel("LocationName");
		lblNewLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_8.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_11.add(panel_5);
		panel_5.setOpaque(false);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_5.setMaximumSize(new Dimension(32767, 100));
		
		registerdateIconPanel = new JPanel();
		registerdateIconPanel.setOpaque(false);
		registerdateIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_5.add(registerdateIconPanel);
		
		lblMemberSince = new JLabel("registerDate");
		lblMemberSince.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblMemberSince);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setMaximumSize(new Dimension(32767, 100));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		panel_3.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_4);
		
		programsNumberIconPanel = new JPanel();
		programsNumberIconPanel.setOpaque(false);
		programsNumberIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_4.add(programsNumberIconPanel);
		
		lblProgramsNumber = new JLabel("Programs number");
		lblProgramsNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblProgramsNumber);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_10);
		
		priceIconPanel = new JPanel();
		priceIconPanel.setOpaque(false);
		priceIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_10.add(priceIconPanel);
		
		lblPrice = new JLabel("from min to max");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_10.add(lblPrice);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_7.setMaximumSize(new Dimension(32767, 100));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 3;
		panel_3.add(panel_7, gbc_panel_7);
		
		studyIconPanel = new JPanel();
		studyIconPanel.setOpaque(false);
		studyIconPanel.setPreferredSize(new Dimension(50, 50));
		panel_7.add(studyIconPanel);
		
		JLabel lblNewLabel_1 = new JLabel("StudyFieldsNames");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 50));
		panel_1.setOpaque(false);
		add(panel_1);
		
		menuBar = new MenuBar(this,mentor,user);//MenuBar(this,null);
		panel_1.add(menuBar);
		
		contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));

	}
}
