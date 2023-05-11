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
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.border.EmptyBorder;

import main.ui.displayContent.DisplayCoursesPanel;
import main.ui.displayContent.DisplayMentoringProgramsPanel;
import main.ui.displayContent.DisplayMentorsPanel;

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

	public LeftPanel(Boolean TODO) {
		this();
		mIHome.addActionListener(actionMIHome());
		mISearchCourses.addActionListener(actionMISearchCourses());
		mISearchMentors.addActionListener(actionMISearchMentors());
		mISearchMentoringPrograms.addActionListener(actionMISearchMentoringPrograms());
		
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
	
	private ActionListener actionMIHome() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.getInstance().getContent().removeAll();
				MainPanel.getInstance().getContent().add(new HomePanel(true));
				MainPanel.getInstance().getContent().validate();
			}
			
		};
	}
	/**
	 * Create the panel.
	 */
	public LeftPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		menuPanel = new JPanel();
		menuPanel.setOpaque(false);
		add(menuPanel);

		menuBar = new JMenuBar();
		menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
		menuBar.setPreferredSize(new Dimension(180, 150));
		menuPanel.add(menuBar);

		mIHome = new JMenuItem("Home");
		mIHome.setBorder(new EmptyBorder(0, 55, 0, 0));
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
		menuBar.add(mSettings);

		mILogOut = new JMenuItem("Log out");
		mSettings.add(mILogOut);
	}




}
