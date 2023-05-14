package main.ui.mentoringProgram;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.classes.MentoringProgram;


public class MenuBar extends JMenuBar {

	private JMenuItem menuItemAbout;
	private JMenuItem menuItemMentoringPrograms;
	private JMenuItem menuItemReview;
	private JMenuItem menuItemCourses;

	private MentoringProgramDetails mentorProgramDetails;
	private JPanel aboutPanel;
	private ReviewsPanel reviewsPanel;
	private CoursesPanel coursesPanel;
	private SchedulePanelMentoringPrograms schedulePanel;

	public MenuBar(MentoringProgramDetails m,MentoringProgram mentoringProgram) {
		this();
		mentorProgramDetails = m;

		//create the panels with the required data 							TODO
		aboutPanel = new AboutPanel(mentoringProgram);
		reviewsPanel = new ReviewsPanel(mentoringProgram);
		coursesPanel = new CoursesPanel(mentoringProgram,mentorProgramDetails);
		schedulePanel = new SchedulePanelMentoringPrograms(mentoringProgram);
	}

	public MenuBar() {
		super();

		menuItemAbout = new JMenuItem("About");
		add(menuItemAbout);
		menuItemAbout.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		menuItemMentoringPrograms = new JMenuItem("Schedule");
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
				mentorProgramDetails.getContentPanel().removeAll();
				mentorProgramDetails.getContentPanel().add(coursesPanel);
				mentorProgramDetails.revalidate();
				mentorProgramDetails.repaint();
			}

		};

		return act;
	}

	private ActionListener reviewsActionListener() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentorProgramDetails.getContentPanel().removeAll();
				mentorProgramDetails.getContentPanel().add(reviewsPanel);
				mentorProgramDetails.revalidate();
				mentorProgramDetails.repaint();
			}

		};

		return act;
	}

	private ActionListener aboutActionListener() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentorProgramDetails.getContentPanel().removeAll();
				mentorProgramDetails.getContentPanel().add(aboutPanel);
				mentorProgramDetails.revalidate();
				mentorProgramDetails.repaint();
			}

		};

		return act;
	}

	private ActionListener mentoringProgramsActionListener() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mentorProgramDetails.getContentPanel().removeAll();
				mentorProgramDetails.getContentPanel().add(schedulePanel);
				mentorProgramDetails.revalidate();
				mentorProgramDetails.repaint();
			}

		};

		return act;
	}
}

