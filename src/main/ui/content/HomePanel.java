package main.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

import main.ui.coursePosts.CoursePost;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.ui.mentors.MentorPost;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class HomePanel extends JPanel {
	private JScrollPane coursesPanel;
	private JScrollPane mentorsPanel;
	private JScrollPane mentoringProgramPanel;
	private JPanel panel;
	private JLabel lblNewLabel;
	
	public HomePanel(Boolean TODO) {
		this();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainPanel.getInstance().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			}
			
		});
		
	}
	/**
	 * Create the panel.
	 */
	public HomePanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel coursesP = new JPanel();
		coursesP.setBorder(new EmptyBorder(10, 10, 10, 10));
		coursesPanel = new ScrollPane();
		coursesPanel.setViewportView(coursesP);
		//add(coursesPanel);
		coursesP.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
		
		JPanel mentorsP = new JPanel();
		mentorsP.setBorder(new EmptyBorder(10, 10, 10, 10));
		mentorsPanel = new ScrollPane();
		mentorsPanel.setViewportView(mentorsP);
		//add(mentorsPanel);
		mentorsP.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
		
		JPanel mentoringProgramP = new JPanel();
		mentoringProgramP.setBorder(new EmptyBorder(10, 10, 10, 10));
		mentoringProgramPanel = new ScrollPane();
		mentoringProgramPanel.setViewportView(mentoringProgramP);
		//add(mentoringProgramPanel);
		mentoringProgramP.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
		
		for(int i = 0;i<5;i++) {
			coursesP.add(new CoursePost(true));
		}
		for(int i = 0;i<5;i++) {
			mentorsP.add(new MentorPost(true));
		}
		for(int i = 0;i<5;i++) {
			mentoringProgramP.add(new MentoringProgramPost(true, true));
		}
		
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
