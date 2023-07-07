package main.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.classes.Course;
import main.classes.Feedback;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.classes.User;
import main.ui.content.MainPanel;

public class DBManager {
	
	public static List<Feedback> getFeedback(int userId){
		Connection conn = DbConnection.conn;
		List<Feedback> feedbacks = new ArrayList<>();

		String sql = "SELECT * FROM feedback WHERE id_user=" + userId;
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs3 = statement.executeQuery(sql);

			while(rs3.next())
			{	
				Feedback feedback = new Feedback(rs3.getInt(1), getUser(userId), rs3.getString(3), rs3.getInt(4), null);	
				feedbacks.add(feedback);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feedbacks;
	}
	
	public static User getUser(int id){
		Connection conn = DbConnection.conn;

		String sql = "SELECT * FROM users WHERE type='user' AND id=" + id;
		Statement statement;

		try {
			statement = conn.createStatement();
			ResultSet rs3 = statement.executeQuery(sql);

			while(rs3.next())
			{
				User user = null;
				user = new User(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
							rs3.getString(5), rs3.getString(6), new ArrayList<>(), new ArrayList<>(), null);

				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
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
	
	public static Mentor getMentor(int id){
		Connection conn = DbConnection.conn;

		String sql = "SELECT * FROM users WHERE type='mentor' AND id=" + id;
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

				return mentor1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
	
	public static void updateUser(User updatedUser) throws SQLException {
		Connection conn = DbConnection.conn;

		String sql = "UPDATE users SET first_name=?, last_name=?, email=?, password=?, phone_number=? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, updatedUser.getFirstName());
        statement.setString(2, updatedUser.getLastName());
        statement.setString(3, updatedUser.getEmail());
        statement.setString(4, updatedUser.getPassword());
        statement.setString(5, updatedUser.getPhoneNumber());
        statement.setInt(6, updatedUser.getId());
        
        int rowsUpdated = statement.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("No records were updated.");
        }
	}
	
	public static void updateMentor(Mentor updatedMentor) throws SQLException {
		Connection conn = DbConnection.conn;

		String sql = "UPDATE users SET first_name=?, last_name=?, email=?, password=?, phone_number=?, description=?, field=?,"
				+ "programs_number=?, card_number=?, cvv=?, card_holder_name=?, expiration_month=?, expiration_year=?, "
				+ "profile_pic=? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, updatedMentor.getFirstName());
        statement.setString(2, updatedMentor.getLastName());
        statement.setString(3, updatedMentor.getEmail());
        statement.setString(4, updatedMentor.getPassword());
        statement.setString(5, updatedMentor.getPhoneNumber());
        statement.setString(6, updatedMentor.getDescription());
        statement.setString(7, updatedMentor.getField());
        statement.setInt(8, updatedMentor.getProgramsNumber());
        statement.setString(9, updatedMentor.getCard().getCardNumber());
        statement.setString(10, updatedMentor.getCard().getCvvCvc());
        statement.setString(11, updatedMentor.getCard().getCardHolderName());
        statement.setString(12, updatedMentor.getCard().getExpirationMonth());
        statement.setString(13, updatedMentor.getCard().getExpirationYear());
        statement.setInt(14, updatedMentor.getId());
        
        int rowsUpdated = statement.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("No records were updated.");
        }
	}
	
	public static void updateCourse(Course updatedCourse) throws SQLException {
		Connection conn = DbConnection.conn;

		String sql = "UPDATE courses SET name=?, description=?, price=? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, updatedCourse.getName());
        statement.setString(2, updatedCourse.getDescription());
        statement.setDouble(3, updatedCourse.getPrice());
        statement.setInt(4, updatedCourse.getId());
        
        int rowsUpdated = statement.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("No records were updated.");
        }
	}
	
	public static void updateMentoringProgram(MentoringProgram updatedMentoringProgram) throws SQLException {
		Connection conn = DbConnection.conn;

		String sql = "UPDATE mentoring_programs SET name=?, difficulty_level=?, description=?, location=?, duration=?, price=?, currency=?, field=? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, updatedMentoringProgram.getName());
        statement.setString(2, updatedMentoringProgram.getDifficultyLevel());
        statement.setString(3, updatedMentoringProgram.getDescription());
        statement.setString(4, updatedMentoringProgram.getLocation());
        statement.setDouble(5, updatedMentoringProgram.getDuration());
        statement.setDouble(6, updatedMentoringProgram.getPrice());
        statement.setString(7, updatedMentoringProgram.getCurrency());
        statement.setString(8, updatedMentoringProgram.getField());
        statement.setInt(9, updatedMentoringProgram.getId());
        
        int rowsUpdated = statement.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("No records were updated.");
        }
	}
}
