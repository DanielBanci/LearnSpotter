package main.ui.mentoringProgram;

import javax.swing.JPanel;

import main.classes.Course;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.db.DbConnection;
import main.ui.coursePosts.CourseFilePanel;
import main.ui.coursePosts.CoursePost;
import main.ui.coursePosts.FeedbackPanel;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class CoursesPanel extends JPanel {

	public CoursesPanel(MentoringProgram mentoringProgram,MentoringProgramDetails mentoringProgramDetails) {
		this();
		
		DbConnection dbConnection = null;
		try {
			Connection conn = DbConnection.conn;
			
			String sql2 = "SELECT * FROM courses WHERE id_mentoring_program=" + mentoringProgram.getId();
			Statement statement2 = conn.createStatement();
			ResultSet rs4 = statement2.executeQuery(sql2);
			while(rs4.next()) 
			{
				//add(new CoursePost(mentoringProgram.getCourses().get(i9)));
				String sql3 = "SELECT * FROM resources WHERE id_course=" + rs4.getInt(1);
				Statement statement3 = conn.createStatement();
				ResultSet rs2 = statement3.executeQuery(sql3);
		
				Map<String, byte[]> files = new HashMap<>();
				while(rs2.next())
					files.put(rs2.getString(3), rs2.getBytes(4));
		
				Course c = new Course(rs4.getInt(1), rs4.getString(4), 
						rs4.getInt(2), rs4.getInt(3), "", rs4.getString(5), 
						0, 0, rs4.getInt(6), null, new ArrayList<>(), 
						new Mentor(), files);
				
				add(new CourseFilePanel(mentoringProgramDetails, c));
			}	
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	public void setPaymentStatus(Boolean status) {
		for(Component c : getComponents()) {
			((CourseFilePanel)c).setPayed(status);
		}
	}
	/**
	 * Create the panel.
	 */
	public CoursesPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}
