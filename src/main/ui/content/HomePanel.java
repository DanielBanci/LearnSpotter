package main.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

import main.classes.Course;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.classes.User;
import main.db.DbConnection;
import main.ui.coursePosts.CoursePost;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.ui.mentors.MentorPost;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
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
		
		DbConnection dbConnection = null;
		try {
			dbConnection = new DbConnection();	
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection conn = dbConnection.getConnection();
		
		String sql = "SELECT * FROM courses";
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				String sql2 = "SELECT * FROM resources WHERE id_course=" + rs.getInt(1);
				Statement statement2 = conn.createStatement();
				ResultSet rs2 = statement2.executeQuery(sql2);
				
				Map<String, byte[]> files = new HashMap<>();
				while(rs2.next())
					files.put(rs.getString(3), rs.getBytes(4));
				
				String sql3 = "SELECT * FROM users WHERE id=" + rs.getInt(2);
				Statement statement3 = conn.createStatement();
				ResultSet rs3 = statement3.executeQuery(sql3);
				
				Mentor mentor1 = null;
				if(rs3.next())
				{
					mentor1 = new Mentor(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
							rs3.getString(5), rs3.getString(6), rs3.getString(7), rs3.getString(8), 
							rs3.getInt(9), null, null, null, null, null);
					
					coursesP.add(new CoursePost(new Course(rs.getInt(1), rs.getString(4), 
							rs.getInt(2), rs.getInt(3), rs.getString(5), 
							0, 0, rs.getInt(6), null, null, 
							mentor1, files),user));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0;i<5;i++) {
			mentorsP.add(new MentorPost(Mentor.createMockup()));
		}
		for(int i = 0;i<5;i++) {
			mentoringProgramP.add(new MentoringProgramPost(MentoringProgram.createMockup(), true,user));
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
		DbConnection dbConnection = null;
		try {
			dbConnection = new DbConnection();	
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection conn = dbConnection.getConnection();
		
		String sql = "SELECT * FROM courses";
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				String sql2 = "SELECT * FROM resources WHERE id_course=" + rs.getInt(1);
				Statement statement2 = conn.createStatement();
				ResultSet rs2 = statement2.executeQuery(sql2);
				
				Map<String, byte[]> files = new HashMap<>();
				while(rs2.next())
					files.put(rs.getString(3), rs.getBytes(4));
				
				String sql3 = "SELECT * FROM users WHERE id=" + rs.getInt(2);
				Statement statement3 = conn.createStatement();
				ResultSet rs3 = statement3.executeQuery(sql3);
				
				Mentor mentor1 = null;
				
				if(rs3.next())
				{
					mentor1 = new Mentor(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
							rs3.getString(5), rs3.getString(6), rs3.getString(7), rs3.getString(8), 
							rs3.getInt(9), null, null, null, null, null);
							
					System.out.println(mentor1.getFirstName());
					
					coursesP.add(new CoursePost(new Course(rs.getInt(1), rs.getString(4), rs.getInt(2), rs.getInt(3), rs.getString(5), 0, 0, rs.getInt(6), null, null, mentor1, files), mentor));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i = 0;i<5;i++) {
			mentorsP.add(new MentorPost(Mentor.createMockup()));
		}
		for(int i = 0;i<5;i++) {
			mentoringProgramP.add(new MentoringProgramPost(MentoringProgram.createMockup(), true,mentor));
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
