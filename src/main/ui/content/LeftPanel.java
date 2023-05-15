package main.ui.content;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.border.EmptyBorder;

import main.app.App;
import main.classes.Mentor;
import main.classes.User;
import main.ui.displayContent.DisplayCoursesPanel;
import main.ui.displayContent.DisplayMentoringProgramsPanel;
import main.ui.displayContent.DisplayMentorsPanel;
import main.ui.login.LoginPanel;
import main.ui.mentors.MentorProfile;
import main.ui.newContent.NewCoursePost;
import main.ui.newContent.NewMentoringProgram;

public class LeftPanel extends JPanel {

	private JPanel menuPanel;
	private JMenuBar menuBar;
	
	private JMenu mSearch;
	private JMenu mSettings;
	
	private JMenuItem mIHome;
	private JMenuItem mISearchCourses;
	private JMenuItem mISearchMentors;
	private JMenuItem mISearchMentoringPrograms;
	private JMenuItem mILogOut;
	private JMenu mnNewMenu;
	private JMenuItem mINewCourse;
	private JMenuItem mINewMentoringProgram;
	private JMenuItem mIMyProfile;
	
	private Mentor mentor;
	private User user = null;
	private JMenu mnNewMenu_1;
	private JMenuItem mIMyCourses;
	private JMenuItem mIMentoringPrograms;

	//for user
	public LeftPanel(Boolean TODO, Mentor mentor, User user) {
		this(user);
		this.user = user;
		this.mentor = mentor;
		mIHome.addActionListener(actionMIHomeUser());
		mISearchCourses.addActionListener(actionMISearchCourses());
		mISearchMentors.addActionListener(actionMISearchMentors());
		mISearchMentoringPrograms.addActionListener(actionMISearchMentoringPrograms());
		//mINewCourse.addActionListener(actionMINewCourse());
		//mINewMentoringProgram.addActionListener(actionMINewMentoringPrograms());
		//mIMyProfile.addActionListener(actionMIMyProfile());
		mIMyCourses.addActionListener(actionMIMyCourses());
		mIMentoringPrograms.addActionListener(actionMIMyMentoringPrograms());
		
		mILogOut.addActionListener(actionMILogOutS());
	}
	
	private ActionListener actionMIMyCourses() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new DisplayCoursesPanel(user.getCourses(),user));
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	private ActionListener actionMIMyMentoringPrograms() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new DisplayMentoringProgramsPanel(user.getMentoringPrograms()));
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	//for mentor
	public LeftPanel(Boolean TODO,Mentor mentor) {
		this();
		this.mentor = mentor;
		mIHome.addActionListener(actionMIHome());
		mISearchCourses.addActionListener(actionMISearchCourses());
		mISearchMentors.addActionListener(actionMISearchMentors());
		mISearchMentoringPrograms.addActionListener(actionMISearchMentoringPrograms());
		mINewCourse.addActionListener(actionMINewCourse());
		mINewMentoringProgram.addActionListener(actionMINewMentoringPrograms());
		mIMyProfile.addActionListener(actionMIMyProfile());
		
		mILogOut.addActionListener(actionMILogOutS());
	}
	
	private ActionListener actionMIMyProfile() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new MentorProfile(true,mentor));
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	private ActionListener actionMILogOutS() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel contentPane = new JPanel();
				contentPane.setLayout(new BorderLayout());
				contentPane.add(new LoginPanel(),BorderLayout.CENTER);
				//App.getInstance().getFrame().getContentPane().removeAll();
				App.getInstance().getFrame().setContentPane(contentPane);
				App.getInstance().getFrame().validate();
				
				/*MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new NewCoursePost());
				MainPanel.getInstance().getContent().validate();*/
			}
			
		};
	}
	
	private ActionListener actionMINewCourse() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new NewCoursePost());
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	private ActionListener actionMINewMentoringPrograms() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new NewMentoringProgram());
				MainPanel.getInstance().getContent().validate();
				MainPanel.getInstance().getContent().revalidate();
			}
			
		};
	}
	
	private ActionListener actionMISearchMentoringPrograms() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new DisplayMentoringProgramsPanel());
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	private ActionListener actionMISearchMentors() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new DisplayMentorsPanel());
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	private ActionListener actionMISearchCourses() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new DisplayCoursesPanel());
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	//for user
	private ActionListener actionMIHomeUser() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new HomePanel(true,mentor,user));
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	//for mentor
	private ActionListener actionMIHome() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new HomePanel(true,mentor));
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	/**
	 * Create the panel.
	 */
	public LeftPanel(User user) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		menuPanel = new JPanel();
		menuPanel.setOpaque(false);
		add(menuPanel);

		menuBar = new JMenuBar();
		menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
		menuBar.setPreferredSize(new Dimension(180, 200));
		menuPanel.add(menuBar);

		mIHome = new JMenuItem("Home");
		mIHome.setBorder(new EmptyBorder(0, 46, 0, 0));
		mIHome.setForeground(new Color(0, 0, 0));
		mIHome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mIHome.setMaximumSize(new Dimension(32767, 50));
		mIHome.setHorizontalAlignment(SwingConstants.CENTER);
		mIHome.setHorizontalTextPosition(SwingConstants.CENTER);
		mIHome.setPreferredSize(new Dimension(170, 50));
		menuBar.add(mIHome);

		mSearch = new JMenu("Search");
		mSearch.setBorder(new EmptyBorder(0, 55, 0, 0));
		mSearch.setForeground(new Color(0, 0, 0));
		mSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mSearch.setMaximumSize(new Dimension(32767, 50));
		mSearch.setHorizontalAlignment(SwingConstants.CENTER);
		mSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		mSearch.setPreferredSize(new Dimension(170, 50));
		menuBar.add(mSearch);

		mISearchCourses = new JMenuItem("Courses");
		mSearch.add(mISearchCourses);

		mISearchMentors = new JMenuItem("Mentors");
		mSearch.add(mISearchMentors);

		mISearchMentoringPrograms = new JMenuItem("Mentoring Programs");
		mSearch.add(mISearchMentoringPrograms);

		mSettings = new JMenu("Settings");
		mSettings.setBorder(new EmptyBorder(0, 50, 0, 0));
		mSettings.setForeground(new Color(0, 0, 0));
		mSettings.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mSettings.setMaximumSize(new Dimension(32767, 50));
		mSettings.setHorizontalAlignment(SwingConstants.CENTER);
		mSettings.setHorizontalTextPosition(SwingConstants.CENTER);
		mSettings.setPreferredSize(new Dimension(170, 50));
		mSettings.invalidate();
		
		mnNewMenu_1 = new JMenu("My data");
		mnNewMenu_1.setMaximumSize(new Dimension(32767, 50));
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		
		mIMyCourses = new JMenuItem("My courses");
		mnNewMenu_1.add(mIMyCourses);
		
		mIMentoringPrograms = new JMenuItem("My mentoring ptograms");
		mnNewMenu_1.add(mIMentoringPrograms);
		
		mnNewMenu = new JMenu("New post");
		mnNewMenu.setBorder(new EmptyBorder(0, 45, 0, 0));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setMaximumSize(new Dimension(32767, 50));
		mnNewMenu.setPreferredSize(new Dimension(170, 50));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		mINewCourse = new JMenuItem("New course");
		mnNewMenu.add(mINewCourse);
		
		mINewMentoringProgram = new JMenuItem("New mentoring program");
		mnNewMenu.add(mINewMentoringProgram);
		menuBar.add(mSettings);

		mILogOut = new JMenuItem("Log out");
		mSettings.add(mILogOut);
	}
	public LeftPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		menuPanel = new JPanel();
		menuPanel.setOpaque(false);
		add(menuPanel);

		menuBar = new JMenuBar();
		menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
		menuBar.setPreferredSize(new Dimension(180, 200));
		menuPanel.add(menuBar);

		mIHome = new JMenuItem("Home");
		mIHome.setBorder(new EmptyBorder(0, 46, 0, 0));
		mIHome.setForeground(new Color(0, 0, 0));
		mIHome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mIHome.setMaximumSize(new Dimension(32767, 50));
		mIHome.setHorizontalAlignment(SwingConstants.CENTER);
		mIHome.setHorizontalTextPosition(SwingConstants.CENTER);
		mIHome.setPreferredSize(new Dimension(170, 50));
		menuBar.add(mIHome);

		mSearch = new JMenu("Search");
		mSearch.setBorder(new EmptyBorder(0, 55, 0, 0));
		mSearch.setForeground(new Color(0, 0, 0));
		mSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mSearch.setMaximumSize(new Dimension(32767, 50));
		mSearch.setHorizontalAlignment(SwingConstants.CENTER);
		mSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		mSearch.setPreferredSize(new Dimension(170, 50));
		menuBar.add(mSearch);

		mISearchCourses = new JMenuItem("Courses");
		mSearch.add(mISearchCourses);

		mISearchMentors = new JMenuItem("Mentors");
		mSearch.add(mISearchMentors);

		mISearchMentoringPrograms = new JMenuItem("Mentoring Programs");
		mSearch.add(mISearchMentoringPrograms);

		mSettings = new JMenu("Settings");
		mSettings.setBorder(new EmptyBorder(0, 50, 0, 0));
		mSettings.setForeground(new Color(0, 0, 0));
		mSettings.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mSettings.setMaximumSize(new Dimension(32767, 50));
		mSettings.setHorizontalAlignment(SwingConstants.CENTER);
		mSettings.setHorizontalTextPosition(SwingConstants.CENTER);
		mSettings.setPreferredSize(new Dimension(170, 50));
		mSettings.invalidate();
		
		mIMyProfile = new JMenuItem("My profile");
		mIMyProfile.setBorder(new EmptyBorder(0, 46, 0, 0));
		mIMyProfile.setHorizontalTextPosition(SwingConstants.CENTER);
		mIMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		mIMyProfile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mIMyProfile.setMaximumSize(new Dimension(32767, 50));
		mIMyProfile.setPreferredSize(new Dimension(170, 50));
		menuBar.add(mIMyProfile);
		
		mnNewMenu = new JMenu("New post");
		mnNewMenu.setBorder(new EmptyBorder(0, 45, 0, 0));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setMaximumSize(new Dimension(32767, 50));
		mnNewMenu.setPreferredSize(new Dimension(170, 50));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		mINewCourse = new JMenuItem("New course");
		mnNewMenu.add(mINewCourse);
		
		mINewMentoringProgram = new JMenuItem("New mentoring program");
		mnNewMenu.add(mINewMentoringProgram);
		menuBar.add(mSettings);

		mILogOut = new JMenuItem("Log out");
		mSettings.add(mILogOut);
	}



}
