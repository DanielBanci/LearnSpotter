package main.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

import main.classes.Course;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.classes.User;
import main.db.DBManager;
import main.db.DbConnection;
import main.ui.coursePosts.CoursePost;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.ui.mentors.MentorPost;
//import main.utility.temporaryDatabase.TDB;
import temporaryDatabase.TDB;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	//last implemented
	//do we really need the mentor here?								?
	public HomePanel(Mentor mentor,User user) {
		this();
		List<Course> courses = DBManager.getNotAssignCourses(user);
		List<Mentor> mentors = DBManager.getMentors(user);
		List<MentoringProgram> mentoringPrograms = DBManager.getMentoringPrograms(user);
		System.out.println(courses.size());
		System.out.println(mentors.size());
		System.out.println(mentoringPrograms.size());
		
		//data from db
		for(int i = 0;i<courses.size();i++) {
			coursesP.add(new CoursePost(courses.get(i),user));
			System.out.println("Da courses");
		}
		for(int i = 0;i<mentors.size();i++) {
			mentorsP.add(new MentorPost(mentors.get(i)));
			System.out.println("Da mentors");
		}
		for(int i = 0;i<mentoringPrograms.size();i++) {
			mentoringProgramP.add(new MentoringProgramPost(mentoringPrograms.get(i), true,mentor,false));  //do i relly need mentor in here?
			System.out.println("Da mentoringPrograms");
		}
		
		//data from temporary db
		/*couses = TDB.courses;
		mentors = TDB.mentors;
		mentoringPrograms = TDB.mentoringProgramsStatic;
		
		for(int i = 0;i<couses.size();i++) {
			coursesP.add(new CoursePost(couses.get(i),user));
		}
		for(int i = 0;i<mentors.size();i++) {
			mentorsP.add(new MentorPost(mentors.get(i)));
		}
		for(int i = 0;i<mentoringPrograms.size();i++) {
			mentoringProgramP.add(new MentoringProgramPost(mentoringPrograms.get(i), true,mentor,false));  //do i relly need mentor in here?
		}*/
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
	
	public HomePanel(Boolean TODO,Mentor mentor,User user) {
		this();
		
		Connection conn = DbConnection.conn;

		String sql = "SELECT * FROM courses WHERE id_mentoring_program=-1";
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
					files.put(rs2.getString(3), rs2.getBytes(4));

				String sql3 = "SELECT * FROM users WHERE id=" + rs.getInt(2);
				Statement statement3 = conn.createStatement();
				ResultSet rs3 = statement3.executeQuery(sql3);

				Mentor mentor1 = null;
				if(rs3.next())
				{
					mentor1 = new Mentor(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
							rs3.getString(5), rs3.getString(6), null, "", rs3.getString(7), 
							rs3.getString(8), rs3.getInt(9), null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null);

					coursesP.add(new CoursePost(new Course(rs.getInt(1), rs.getString(4), 
							rs.getInt(2), rs.getInt(3), "", rs.getString(5), 
							0, 0, rs.getInt(6), null, new ArrayList<>(), 
							mentor1, files),user));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		sql = "SELECT * FROM users where type='mentor'";
		
		try {
			statement = conn.createStatement();
			ResultSet rs3 = statement.executeQuery(sql);

			while(rs3.next())
			{
				String sqlCourses = "SELECT * FROM courses WHERE id_mentor=" + rs3.getInt(1) + " AND id_mentoring_program=-1";
				Statement statementCourses = conn.createStatement();
				ResultSet rsCourses = statementCourses.executeQuery(sqlCourses);
				List<Course> courses = new ArrayList<>();
				
				while(rsCourses.next())
				{
					Course course = new Course(rsCourses.getInt(1), rsCourses.getString(4), 
							rsCourses.getInt(2), rsCourses.getInt(3), "", rsCourses.getString(5), 
							0, 0, rsCourses.getInt(6), null, new ArrayList<>(), 
							new Mentor(), new HashMap<>());
					courses.add(course);
				}
				
				Mentor mentor1 = null;
				mentor1 = new Mentor(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
							rs3.getString(5), rs3.getString(6), null, "", rs3.getString(7), 
							rs3.getString(8), rs3.getInt(9), new Date(61271392), new ArrayList<>(), courses, new ArrayList<>(), null);

				mentorsP.add(new MentorPost(mentor1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sql = "SELECT * FROM mentoring_programs";
		
		try {
			statement = conn.createStatement();
			ResultSet rs3 = statement.executeQuery(sql);

			while(rs3.next())
			{
				String sql2 = "SELECT * FROM users WHERE type='mentor' AND id=" + rs3.getInt(2);
				Statement statement2 = conn.createStatement();
				ResultSet rs4 = statement2.executeQuery(sql2);
				
				if(rs4.next())
				{
					Mentor m = new Mentor(rs4.getInt(1), rs4.getString(2), rs4.getString(3), rs4.getString(4),
							rs4.getString(5), rs4.getString(6), null, "", rs4.getString(7), 
							rs4.getString(8), rs4.getInt(9), null, null, null, null, null);
					MentoringProgram mp = new MentoringProgram(rs3.getInt(1), rs3.getInt(2), rs3.getString(3), rs3.getString(4), 
							rs3.getString(5), rs3.getString(6), new ArrayList<>(), rs3.getInt(7), rs3.getInt(8), rs3.getString(9), m,
							0, 0, rs3.getString(10), new ArrayList<>(), new HashMap<String, byte[]>());
					
					MentoringProgramPost mpp = new MentoringProgramPost(mp, true, m, false);
					mentoringProgramP.add(mpp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	private Image convertToImage(Blob blob)
	{
		Image image = null;
		try {
			  // Retrieve the byte array from the Blob
			  byte[] blobBytes = blob.getBytes(1, (int) blob.length());

			  // Create an InputStream from the byte array
			  InputStream inputStream = new ByteArrayInputStream(blobBytes);

			  // Read the image data and create an Image object
			  image = ImageIO.read(inputStream);

			  // Now you can use the "image" object as needed
			  // For example, you can display it in a Swing GUI:
			  // JLabel imageLabel = new JLabel(new ImageIcon(image));
			  // frame.add(imageLabel);

			} catch (Exception e) {
			  e.printStackTrace();
		}
		
		return image;
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
