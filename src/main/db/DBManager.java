package main.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.classes.Course;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.classes.User;
import main.ui.content.MainPanel;

public class DBManager {
	
	public static List<MentoringProgram> getMentoringPrograms(User user){
		Connection conn = DbConnection.conn;
		
		List<MentoringProgram> mentoringPrograms = new ArrayList<>();
		
		String sql = "SELECT * FROM mentoring_programs";
		if(user instanceof Mentor) {
			sql = "SELECT * FROM mentoring_programs WHERE id_mentor != " + user.getId();
		}
		
		Statement statement;
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
					
					mentoringPrograms.add(mp);
					
					/*MentoringProgramPost mpp = new MentoringProgramPost(mp, true, m, false);
					mentoringProgramP.add(mpp);*/
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mentoringPrograms;
	}

	/**
	 * Returns the mentors available. If user is mentor, he is erased from the list
	 * @param user
	 * @return
	 */
	public static List<Mentor> getMentors(User user){
		Connection conn = DbConnection.conn;
		
		List<Mentor> mentors = new ArrayList<>();
		
		String sql = "SELECT * FROM users where type='mentor'";
		if(user instanceof Mentor) {
			sql = "SELECT * FROM users where type='mentor' AND id != " + user.getId();
		}
		
		Statement statement;
		
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

				mentors.add(mentor1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mentors;
	}
	
	/**
	 * Return the list of courses that does not belong to any mentoring programs and the owner is not the user
	 * @param user
	 * @return the list of courses
	 */
	public static List<Course> getNotAssignCourses(User user) {
		Connection conn = DbConnection.conn;
		
		List<Course> courses = new ArrayList<>();
		String sql = "SELECT * FROM courses WHERE id_mentoring_program=-1 AND id_mentor !=" + MainPanel.loggedUser.getId();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("Aici 11");
			while(rs.next())
			{
				System.out.println("Aici 12");
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
				System.out.println("Aici 1.3");
				if(rs3.next())
				{
					System.out.println("Aici 1.4");
					mentor1 = new Mentor(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
							rs3.getString(5), rs3.getString(6), null, "", rs3.getString(7), 
							rs3.getString(8), rs3.getInt(9), null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null);

					courses.add(new Course(rs.getInt(1), rs.getString(4), 
							rs.getInt(2), rs.getInt(3), "", rs.getString(5), 
							0, 0, rs.getInt(6), null, new ArrayList<>(), 
							mentor1, files));
					/*coursesP.add(new CoursePost(new Course(rs.getInt(1), rs.getString(4), 
							rs.getInt(2), rs.getInt(3), "", rs.getString(5), 
							0, 0, rs.getInt(6), null, new ArrayList<>(), 
							mentor1, files),user));*/
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courses;
	}
}
