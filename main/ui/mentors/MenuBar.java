package main.ui.mentors;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import main.classes.Mentor;
import main.classes.User;

public class MenuBar extends JMenuBar {

	private JMenuItem menuItemAbout;
	private JMenuItem menuItemMentoringPrograms;
	private JMenuItem menuItemReview;
	private JMenuItem menuItemCourses;
	
	private MentorProfile mentorProfilePanel;
	private AboutPanel aboutPanel;
	private ReviewsPanel reviewsPanel;
	private CoursesPosts coursesPosts;
	private ProgramsPanel programsPanel;
	//for user
	public MenuBar(MentorProfile m,Mentor mentor,User user) {
		this();
		mentorProfilePanel = m;
		System.out.println("AICI!!!");
		//mentor = Mentor.createMockup();
		//create the panels with the required data 							TODO
		aboutPanel = new AboutPanel(mentor,user);
		reviewsPanel = new ReviewsPanel(mentor);							//TODO let the user to give a feedback
		coursesPosts = new CoursesPosts(mentor,user);
		programsPanel = new ProgramsPanel(mentor,user);
	}
	//for mentor
	public MenuBar(MentorProfile m,Mentor mentor) {
		this();
		mentorProfilePanel = m;
		if(mentor == null)System.out.println("DA");
		//mentor = Mentor.createMockup();
		//create the panels with the required data 							TODO
		aboutPanel = new AboutPanel(mentor);
		reviewsPanel = new ReviewsPanel(mentor);
		coursesPosts = new CoursesPosts(mentor);
		programsPanel = new ProgramsPanel(mentor);
	}
	
	public MenuBar() {
		super();
		
		menuItemAbout = new JMenuItem("About");
		add(menuItemAbout);
		menuItemAbout.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		menuItemMentoringPrograms = new JMenuItem("Mentoring programs");
		menuItemMentoringPrograms.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemMentoringPrograms.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		add(menuItemMentoringPrograms);
		
		menuItemCourses = new JMenuItem("Courses");
		menuItemCourses.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemCourses.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		add(menuItemCourses);
		
		menuItemReview = new JMenuItem("Review");
		menuItemReview.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemReview.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		add(menuItemReview);
		
		menuItemAbout.addActionListener(aboutActionListener());
		menuItemMentoringPrograms.addActionListener(mentoringProgramsActionListener());
		menuItemCourses.addActionListener(coursesActionListener());
		menuItemReview.addActionListener(reviewsActionListener());
	}
	
	private ActionListener coursesActionListener() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentorProfilePanel.getContentPanel().removeAll();
				mentorProfilePanel.getContentPanel().add(coursesPosts);
				mentorProfilePanel.revalidate();
				mentorProfilePanel.repaint();
			}
			
		};
		
		return act;
	}
	
	private ActionListener reviewsActionListener() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentorProfilePanel.getContentPanel().removeAll();
				mentorProfilePanel.getContentPanel().add(reviewsPanel);
				mentorProfilePanel.revalidate();
				mentorProfilePanel.repaint();
			}
			
		};
		
		return act;
	}
	
	private ActionListener aboutActionListener() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentorProfilePanel.getContentPanel().removeAll();
				mentorProfilePanel.getContentPanel().add(aboutPanel);
				mentorProfilePanel.revalidate();
				mentorProfilePanel.repaint();
			}
			
		};
		
		return act;
	}
	
	private ActionListener mentoringProgramsActionListener() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentorProfilePanel.getContentPanel().removeAll();
				mentorProfilePanel.getContentPanel().add(programsPanel);
				mentorProfilePanel.revalidate();
				mentorProfilePanel.repaint();
			}
			
		};
		
		return act;
	}
}
