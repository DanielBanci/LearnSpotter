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
import main.classes.Course;
import main.classes.Mentor;
import main.classes.User;
import main.ui.customComponents.ImagePanel;
import main.ui.displayContent.DisplayCoursesPanel;
import main.ui.displayContent.DisplayMentoringProgramsPanel;
import main.ui.displayContent.DisplayMentorsPanel;
import main.ui.login.LoginPanel;
import main.ui.mentors.MentorProfile;
import main.ui.newContent.NewCoursePost;
import main.ui.newContent.NewMentorProfile;
import main.ui.newContent.NewMentoringProgram;
import main.ui.newContent.NewUserProfile;
//import main.utility.temporaryDatabase.TDB;
import main.ui.search.SearchFiltersPanel;
import main.ui.search.SortPanel;
import main.utility.ImageLoader;
import temporaryDatabase.DELETE;

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
	private JMenuItem mIAccountSettings;
	private JMenu mnNewMenu;
	private JMenuItem mINewCourse;
	private JMenuItem mINewMentoringProgram;
	private JMenuItem mIMyProfile;
	
	private Mentor mentor;
	private User user = null;
	private JMenu mnNewMenu_1;
	private JMenuItem mIMyCourses;
	private JMenuItem mIMentoringPrograms;
	private SearchFiltersPanel filtersPanel = new SearchFiltersPanel();
	private ImagePanel logoPanel;

	//for user
	public LeftPanel(Boolean TODO, Mentor mentor, User user) {
		this(user);
		this.user = user;
		this.mentor = mentor;
		mIHome.addActionListener(actionMIHomeUser());
		mISearchCourses.addActionListener(actionMISearchCourses());
		mISearchMentors.addActionListener(actionMISearchMentors());
		mISearchMentoringPrograms.addActionListener(actionMISearchMentoringPrograms());
		menuBar.remove(mnNewMenu);
		mnNewMenu_1.setBorder(new EmptyBorder(0, 50, 0, 0));
		//mINewCourse.addActionListener(actionMINewCourse());
		//mINewMentoringProgram.addActionListener(actionMINewMentoringPrograms());
		//mIMyProfile.addActionListener(actionMIMyProfile());
		mIMyCourses.addActionListener(actionMIMyCourses());
		mIMentoringPrograms.addActionListener(actionMIMyMentoringPrograms());
		
		mILogOut.addActionListener(actionMILogOutS());
		mIAccountSettings.addActionListener(actionMIAccountSettings());
	}
	
	private ActionListener actionMIAccountSettingsMentor(Mentor mentor){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				//getInstance().getContent().add(new DisplayCoursesPanel(user.getCourses(),user,true));
				MainPanel.getInstance().getContent().setLayout(new BoxLayout(MainPanel.getInstance().getContent(),BoxLayout.X_AXIS));
				//MainPanel.getInstance().getContent().setMaximumSize(new Dimension(1300,90000000));
				//MainPanel.getInstance().getContent().setPreferredSize(new Dimension(1300,90000000));
				NewMentorProfile p = new NewMentorProfile(mentor);
				p.setMaximumSize(new Dimension(1300,900));
				MainPanel.getInstance().getContent().add(p);
				
				MainPanel.getInstance().getContent().revalidate();
				MainPanel.getInstance().getContent().repaint();
			}
		};
	}
	
	private ActionListener actionMIAccountSettings(){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				//getInstance().getContent().add(new DisplayCoursesPanel(user.getCourses(),user,true));
				MainPanel.getInstance().getContent().setLayout(new BoxLayout(MainPanel.getInstance().getContent(),BoxLayout.X_AXIS));
				//MainPanel.getInstance().getContent().setMaximumSize(new Dimension(1300,90000000));
				//MainPanel.getInstance().getContent().setPreferredSize(new Dimension(1300,90000000));
				NewUserProfile p = new NewUserProfile(user);
				p.setMaximumSize(new Dimension(1300,500));
				MainPanel.getInstance().getContent().add(p);
				
				MainPanel.getInstance().getContent().revalidate();
				MainPanel.getInstance().getContent().repaint();
			}
		};
	}
	
	private ActionListener actionMIMyCourses() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				//getInstance().getContent().add(new DisplayCoursesPanel(user.getCourses(),user,true));
				MainPanel.getInstance().getContent().add(new DisplayCoursesPanel(MainPanel.loggedUser.getCourses(),MainPanel.loggedUser,true));
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	
	private ActionListener actionMIMyMentoringPrograms() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new DisplayMentoringProgramsPanel(user.getMentoringPrograms(),true));
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
		mIAccountSettings.addActionListener(actionMIAccountSettingsMentor(mentor));
	}
	
	private ActionListener actionMIMyProfile() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().setLayout(new BoxLayout(MainPanel.getInstance().getContent(),BoxLayout.Y_AXIS));
				MainPanel.getInstance().getContent().add(new MentorProfile(true,mentor));
				MainPanel.getInstance().getContent().repaint();
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
				MainPanel.getInstance().getContent().add(new NewCoursePost(mentor));
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
				LeftPanel.this.remove(filtersPanel);
				filtersPanel = new SearchFiltersPanel(true,SearchFiltersPanel.TYPE.MENTORINGPROGRAM);
				LeftPanel.this.add(filtersPanel);
				//filtersPanel.content.add(new SortPanel());
				//LeftPanel.this.add(new SortPanel());
				//LeftPanel.this.add(makeEmptyPanel());
				LeftPanel.this.revalidate();
			}
			
		};
	}
	private JPanel makeEmptyPanel() {
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.setMaximumSize(new Dimension(999,999999999));
		return p;
	}
	private ActionListener actionMISearchMentors() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new DisplayMentorsPanel());
				MainPanel.getInstance().getContent().validate();
				LeftPanel.this.remove(filtersPanel);
				filtersPanel = new SearchFiltersPanel(true,SearchFiltersPanel.TYPE.MENTOR);
				LeftPanel.this.add(filtersPanel);
				//filtersPanel.content.add(new SortPanel());
				//LeftPanel.this.add(new SortPanel());
				//LeftPanel.this.add(makeEmptyPanel());
				LeftPanel.this.revalidate();
			}
			
		};
	}
	
	private ActionListener actionMISearchCourses() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				if(user == null) user = mentor;
				MainPanel.getInstance().getContent().add(new DisplayCoursesPanel());
				MainPanel.getInstance().getContent().validate();
				LeftPanel.this.remove(filtersPanel);
				filtersPanel = new SearchFiltersPanel(true,SearchFiltersPanel.TYPE.COURSE);
				LeftPanel.this.add(filtersPanel);
				//filtersPanel.content.add(new SortPanel());
				//LeftPanel.this.add(new SortPanel());
				//LeftPanel.this.add(makeEmptyPanel());
				LeftPanel.this.revalidate();
			}
			
		};
	}
	//for user
	private ActionListener actionMIHomeUser() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				//MainPanel.getInstance().getContent().add(new HomePanel(true,mentor,user));
				MainPanel.getInstance().getContent().add(new HomePanel(mentor,user));
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

		logoPanel = new ImagePanel(ImageLoader.getInstance().getLogo(), new Dimension(200, 100));
		logoPanel.setMaximumSize(new Dimension(200,100));
		logoPanel.setPreferredSize(new Dimension(200,100));
		//add(logoPanel);
		menuPanel = new JPanel();
		menuPanel.setOpaque(false);
		menuPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
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
		
		mIMentoringPrograms = new JMenuItem("My mentoring programs");
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

		mIAccountSettings = new JMenuItem("Account settings");
		mSettings.add(mIAccountSettings);
		
		mILogOut = new JMenuItem("Log out");
		mSettings.add(mILogOut);
		
	}
	public LeftPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		logoPanel = new ImagePanel(ImageLoader.getInstance().getLogo(), new Dimension(200, 100));
		//add(logoPanel);
		menuPanel = new JPanel();
		menuPanel.setMinimumSize(new Dimension(180, 300));
		menuPanel.setMaximumSize(new Dimension(180, 300));
		menuPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		menuPanel.setOpaque(false);
		add(menuPanel);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));

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

		mISearchMentoringPrograms = new JMenuItem("Mentoring programs");
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
		
		mIAccountSettings = new JMenuItem("Account settings");
		mSettings.add(mIAccountSettings);

		mILogOut = new JMenuItem("Log out");
		mSettings.add(mILogOut);
		filtersPanel = new SearchFiltersPanel();
	}



}
