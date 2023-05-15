package main.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import main.app.App;
import main.classes.Mentor;
import main.ui.calendar.SchedulePanel;
import main.ui.coursePosts.CoursePost;
import main.ui.coursePosts.CoursePostDetails;
import main.ui.coursePosts.CoursePostScrollPane;
import main.ui.customComponents.ImagePanel;
import main.ui.customComponents.RoundImagePanel;
import main.ui.displayContent.DisplayCoursesPanel;
import main.ui.displayContent.DisplayMentoringProgramsPanel;
import main.ui.displayContent.DisplayMentorsPanel;
import main.ui.mentoringProgram.MentoringProgramDetails;
import main.ui.mentors.MentorPost;
import main.ui.mentors.MentorProfile;
import main.ui.newContent.NewCoursePost;
import main.ui.newContent.NewMentorProfile;
import main.ui.newContent.NewMentoringProgram;
//import main.ui.newContent.NewUserProfile;
import main.utility.ImageLoader;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Color;

/**
 * The main panel of the app. It has 2 panels, one on the top with the logo, a
 * search bar and the menu. And another one where the content will be displayed.
 * 
 * @author Daniel
 * @version 1.0
 */
public class MainPanel extends JScrollPane {
	private ImagePanel logoPanel;
	private JPanel topPanel;
	private JPanel leftPanel;
	private JPanel content;
	private static MainPanel instance;

	public JPanel getTopPanel() {
		return topPanel;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public JPanel getContent() {
		return content;
	}

	public static MainPanel getInstance() {
		// return instance == null ? (instance = new MainPanel(true)) : instance;
		if (instance == null)
			instance = new MainPanel(true);
		return instance;
	}

	public static MainPanel updateInstance() {
		instance = new MainPanel(true);
		return instance;
	}

	private MainPanel(Boolean TODO) {
		this();
		logoPanel = new ImagePanel(ImageLoader.getInstance().getLogo(), new Dimension(200, 100));
		setCorner(JScrollPane.UPPER_LEFT_CORNER, logoPanel);
		topPanel = new TopPanel();
		topPanel.setPreferredSize(new Dimension(10, 100));
		setColumnHeaderView(topPanel);

		content.add(new HomePanel(true,Mentor.createMockup()));
		// content.add(new DisplayMentoringProgramsPanel());
		// content.setLayout(new FlowLayout(FlowLayout.CENTER));
		 //content.add(new NewMentorProfile(true));
		// content.add(new NewMentoringProgram());
	}

	/**
	 * Method that search for a panel index inside the container.
	 * 
	 * @param target the panel in interest
	 * @return the index of the panel, -1 if not found
	 */
	public int findComponentIndex(Container container, Object target) {
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
	 */
	private MainPanel() {
		getVerticalScrollBar().setUnitIncrement(16);
		getHorizontalScrollBar().setUnitIncrement(16);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(10, 100));
		setColumnHeaderView(topPanel);

		leftPanel = new LeftPanel(true,Mentor.createMockup());
		leftPanel.setBackground(new Color(128, 128, 128));
		leftPanel.setPreferredSize(new Dimension(250, 10));
		setRowHeaderView(leftPanel);

		content = new JPanel();
		setViewportView(content);
		content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));

	}

	/*
	 * setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	 * 
	 * JPanel topPanel = new TopPanel(); topPanel.setMaximumSize(new
	 * Dimension(32767, 150)); topPanel.setMinimumSize(new Dimension(50,100));
	 * topPanel.setPreferredSize(new Dimension(800,150)); add(topPanel);
	 * 
	 * JPanel contentPanel = new JPanel(); contentPanel.setLayout(new
	 * BoxLayout(contentPanel,BoxLayout.Y_AXIS)); //contentPanel.setLayout(new
	 * FlowLayout());
	 * 
	 * CoursePostScrollPane p = new CoursePostScrollPane(); //contentPanel.add(p);
	 * //contentPanel.add(new CoursePostScrollPane()); JScrollPane pane = new
	 * JScrollPane(); pane.setViewportView(new MentoringProgramDetails());
	 * contentPanel.add(pane); //contentPanel.add(new MentorProfile(true));
	 * 
	 * add(contentPanel); /*revalidate(); invalidate(); repaint(); validate();
	 * App.getInstance().getFrame().getContentPane().invalidate();
	 * App.getInstance().getFrame().getContentPane().revalidate();
	 */

}
