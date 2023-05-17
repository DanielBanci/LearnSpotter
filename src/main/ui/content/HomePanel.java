package main.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

import main.classes.Course;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.classes.User;
import main.ui.coursePosts.CoursePost;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.ui.mentors.MentorPost;
import main.utility.temporaryDatabase.TDB;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;

public class HomePanel extends JPanel {
	private JScrollPane coursesPanel;
	private JPanel coursesP;
	private JScrollPane mentorsPanel;
	private JPanel mentorsP;
	private JScrollPane mentoringProgramPanel;
	private JPanel mentoringProgramP;
	private JPanel panel;
	private JLabel lblNewLabel;
	
	public HomePanel(Boolean TODO,Mentor mentor,User user) {
		this();
		
		for(int i = 0;i<5;i++) {
			//coursesP.add(new CoursePost(Course.createMockup(),user));
			coursesP.add(new CoursePost());
		}
		for(int i = 0;i<5;i++) {
			mentorsP.add(new MentorPost(Mentor.createMockup()));
		}
		for(int i = 0;i<5;i++) {
			mentoringProgramP.add(new MentoringProgramPost(MentoringProgram.createMockup(), true,user,false));
		}
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				//MainPanel.getInstance().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				MainPanel.getInstance().getContent().setMaximumSize(new Dimension(1300,9000000));
				MainPanel.getInstance().getContent().validate();
				coursesPanel.getHorizontalScrollBar().setValue(0);
				mentorsPanel.getHorizontalScrollBar().setValue(0);
				mentoringProgramPanel.getHorizontalScrollBar().setValue(0);
				
			}
			
		});
		
	}
	
	public HomePanel(Boolean TODO,Mentor mentor) {
		this();
		for(int i = 0;i<5;i++) {
			coursesP.add(new CoursePost(Course.createMockup(),User.createMockup()));
		}
		for(int i = 0;i<5;i++) {
			mentorsP.add(new MentorPost(Mentor.createMockup()));
		}
		for(int i = 0;i<5;i++) {
			mentoringProgramP.add(new MentoringProgramPost(MentoringProgram.createMockup(), true,mentor,false));
		}
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				//MainPanel.getInstance().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				MainPanel.getInstance().getContent().setMaximumSize(new Dimension(1300,9000000));
				MainPanel.getInstance().getContent().validate();
				coursesPanel.getHorizontalScrollBar().setValue(0);
				mentorsPanel.getHorizontalScrollBar().setValue(0);
				mentoringProgramPanel.getHorizontalScrollBar().setValue(0);
				
			}
			
		});
		
	}
	/**
	 * Create the panel.
	 */
	public HomePanel() {
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		coursesP = new JPanel();
		coursesP.setBorder(new EmptyBorder(10, 10, 10, 10));
		coursesPanel = new ScrollPane();
		coursesPanel.setViewportView(coursesP);
		//add(coursesPanel);
		coursesP.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
		
		mentorsP = new JPanel();
		mentorsP.setBorder(new EmptyBorder(10, 10, 10, 10));
		mentorsPanel = new ScrollPane();
		mentorsPanel.setViewportView(mentorsP);
		//add(mentorsPanel);
		mentorsP.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
		
		mentoringProgramP = new JPanel();
		mentoringProgramP.setBorder(new EmptyBorder(10, 10, 10, 10));
		mentoringProgramPanel = new ScrollPane();
		mentoringProgramPanel.setViewportView(mentoringProgramP);
		//add(mentoringProgramPanel);
		mentoringProgramP.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
		
		
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(30, 0, 30, 0));
		panel.setMaximumSize(new Dimension(1200, 50));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		lblNewLabel = new JLabel("Courses ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		add(coursesPanel);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(30, 0, 30, 0));
		panel1.setMaximumSize(new Dimension(1200, 50));
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.LEFT);
		add(panel1);
		
		JLabel lblNewLabel1 = new JLabel("Mentors ");
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel1.add(lblNewLabel1);
		
		add(mentorsPanel);
		
		JPanel panel11 = new JPanel();
		panel11.setBorder(new EmptyBorder(30, 0, 30, 0));
		panel11.setMaximumSize(new Dimension(1200, 50));
		FlowLayout flowLayout11 = (FlowLayout) panel11.getLayout();
		flowLayout11.setAlignment(FlowLayout.LEFT);
		add(panel11);
		
		JLabel lblNewLabel11 = new JLabel("Mentoring Programs ");
		lblNewLabel11.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel11.add(lblNewLabel11);
		
		add(mentoringProgramPanel);
		
		
	}

	private JScrollPane makeScrollPane() {
		JScrollPane pane = new JScrollPane();
		pane.getVerticalScrollBar().setUnitIncrement(16);
		pane.getHorizontalScrollBar().setUnitIncrement(16);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		pane.getHorizontalScrollBar().setOpaque(false);
		pane.getHorizontalScrollBar().setVisible(false);
		//pane.setMaximumSize(MainPanel.getInstance().getViewport().getExtentSize());
		//pane.getViewport().getExtentSize();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				pane.setMaximumSize(MainPanel.getInstance().getViewport().getExtentSize());
				//setMaximumSize(MainPanel.getInstance().getViewport().getExtentSize());
				MainPanel.getInstance().getContent().setMaximumSize(new Dimension(400,200));
				MainPanel.getInstance().getContent().invalidate();
				MainPanel.getInstance().getContent().revalidate();
				MainPanel.getInstance().getContent().repaint();
				MainPanel.getInstance().getContent().validate();
			}
			
		});
		return pane;
	}
}
