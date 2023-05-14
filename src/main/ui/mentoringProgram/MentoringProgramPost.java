package main.ui.mentoringProgram;

import javax.swing.JPanel;

import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.ui.content.MainPanel;
import main.ui.coursePosts.CoursePostDetails;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.TextAreaWithPreview;
import main.ui.ratingBar.StarRatingBar;
import main.utility.ImageLoader;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;

/**
 * Panel for displaying a mentoring program with basic information.
 * @author Daniel
 * @version 1.0
 */
public class MentoringProgramPost extends RoundPanel {

	private JPanel profilePicPanel;
	private JLabel lblMentorName;
	private JLabel lblProgramTitle;
	private StarRatingBar ratingBarPanel;
	private JLabel lblReviewsNumber;
	private JLabel lblField;
	private JLabel lblDuration;
	private JLabel lblPrice;
	protected TextAreaWithPreview tADescription;
	protected JPanel panelTextArea;
	protected JPanel panelAboutLbl;
	private JLabel lblDifficulty;
	private RoundButton btnDetails;
	private MentoringProgram mentoringProgram;
	
	//aux
	private JPanel panel_4;
	
	public MentoringProgramPost(MentoringProgram mentoringProgram,Boolean shortContent) {
		this();
		this.mentoringProgram = mentoringProgram;
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(150,150)));
		panelAboutLbl = new JPanel();
		panelAboutLbl.setBorder(new EmptyBorder(0, 5, 0, 0));
		panelAboutLbl.setOpaque(false);
		FlowLayout fl_panelAbout = (FlowLayout) panelAboutLbl.getLayout();
		fl_panelAbout.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_2 = new JLabel("About: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelAboutLbl.add(lblNewLabel_2);
		
		panelTextArea = new RoundPanel();
		panelTextArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelTextArea.setBackground(new Color(255, 255, 255));
		panelTextArea.setLayout(new BorderLayout(0, 0));
		
		tADescription = new TextAreaWithPreview();
		panelTextArea.add(tADescription, BorderLayout.CENTER);
		
		//display info
		lblMentorName.setText(mentoringProgram.getMentor().getFirstName() + " " + mentoringProgram.getMentor().getLastName());
		lblProgramTitle.setText(mentoringProgram.getName());
		lblReviewsNumber.setText(String.valueOf(mentoringProgram.getNoViews()));
		lblField.setText(mentoringProgram.getField());
		lblDuration.setText(String.valueOf(mentoringProgram.getDuration()));
		lblPrice.setText(String.valueOf(mentoringProgram.getPrice()));
		tADescription.setTextBody(mentoringProgram.getDescription());
		
		
		//rating
		Container parent = ratingBarPanel.getParent();
		int index = findComponentIndex(parent, ratingBarPanel);
		parent.remove(ratingBarPanel);
		ratingBarPanel = new StarRatingBar(mentoringProgram.getRating(),1);
		parent.add(ratingBarPanel,index);
		
		if(shortContent) {
			makeShortContent();
		}
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
	
	private ActionListener detailsActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().setLayout(new BoxLayout(MainPanel.getInstance().getContent(),BoxLayout.Y_AXIS));
				MainPanel.getInstance().getContent().add(new MentoringProgramDetails(mentoringProgram,false));
				MainPanel.getInstance().getContent().revalidate();
			}
			
		};
	}
	
	public void makeShortContent() {
		add(panelAboutLbl);
		add(panelTextArea);
		
		btnDetails = new RoundButton("New button");
		btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDetails.setText("Details");
		btnDetails.setPreferredSize(new Dimension(100, 30));
		btnDetails.setBackground(new Color(128, 128, 128));
		panel_4.add(btnDetails);
		btnDetails.addActionListener(detailsActionListener());
	}
	/**
	 * Create the panel.
	 */
	public MentoringProgramPost() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 220));
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setMaximumSize(new Dimension(500, 500));
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		profilePicPanel = new JPanel();
		profilePicPanel.setOpaque(false);
		profilePicPanel.setMaximumSize(new Dimension(150, 150));
		profilePicPanel.setPreferredSize(new Dimension(150, 150));
		panel_2.add(profilePicPanel);
		profilePicPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setMaximumSize(new Dimension(32767, 50));
		panel_2.add(panel_5);
		
		lblMentorName = new JLabel("FirstName LastName");
		lblMentorName.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblMentorName.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblMentorName);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setMaximumSize(new Dimension(32767, 220));
		panel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {400, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 0;
		panel_3.add(panel_10, gbc_panel_10);
		
		lblProgramTitle = new JLabel("Program title");
		lblProgramTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_10.add(lblProgramTitle);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel_3.add(panel_9, gbc_panel_9);
		
		ratingBarPanel = new StarRatingBar(2,1);
		ratingBarPanel.setOpaque(false);
		ratingBarPanel.setPreferredSize(new Dimension(150, 30));
		panel_9.add(ratingBarPanel);
		
		lblReviewsNumber = new JLabel("(10 views)");
		lblReviewsNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_9.add(lblReviewsNumber);
		
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 2;
		panel_3.add(panel_8, gbc_panel_8);
		
		JLabel lblNewLabel_5 = new JLabel("Field: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(lblNewLabel_5);
		
		lblField = new JLabel("Math");
		lblField.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_8.add(lblField);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 3;
		panel_3.add(panel_7, gbc_panel_7);
		
		JLabel lblNewLabel = new JLabel("Difficulty: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_7.add(lblNewLabel);
		
		lblDifficulty = new JLabel("Advanced");
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(lblDifficulty);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 4;
		panel_3.add(panel_6, gbc_panel_6);
		
		JLabel lblNewLabel_3 = new JLabel("Duration: ");
		panel_6.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblDuration = new JLabel("7 weeks");
		panel_6.add(lblDuration);
		lblDuration.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		FlowLayout flowLayout_5 = (FlowLayout) panel_4.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 5;
		panel_3.add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Price: ");
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblPrice = new JLabel("100 RON");
		panel_4.add(lblPrice);
		lblPrice.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(150, 0));
		horizontalStrut.setMaximumSize(new Dimension(200, 10));
		panel_4.add(horizontalStrut);
		
		
		
		

	}

}
