package main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	public static Connection conn;
	
	public DbConnection() {
		
	}
	
	public static void initializeDatabase() throws SQLException
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/proiectpc";
	    String username = "root";
	    String password = "db2023";
	    
	    conn = DriverManager.getConnection(jdbcUrl, username, password);
		
		try {
	        Statement stmt = conn.createStatement();
	        String users = "CREATE TABLE IF NOT EXISTS users " +
	                       "(id INTEGER not NULL AUTO_INCREMENT, " +
	                       " first_name VARCHAR(255), " +
	                       " last_name VARCHAR(255), " +
	                       " email VARCHAR(255), " +
	                       " password VARCHAR(255), " +
	                       " phone_number VARCHAR(255), " +
	                       " description VARCHAR(255), " +
	                       " field VARCHAR(50), " +
	       				   " programs_number INTEGER, " +
	                       " card_number VARCHAR(50), " +
	       				   " cvv VARCHAR(3), " +
	                       " card_holder_name VARCHAR(50), " +
	       				   " expiration_month INTEGER, " +
	                       " expiration_year INTEGER, " +
	                       " id_rating INTEGER, " +
	                       " profile_pic LONGBLOB, " +
	                       " type VARCHAR(10), " +
	                       " PRIMARY KEY ( id ))";

	        String feedback = "CREATE TABLE IF NOT EXISTS feedback " +
                    		  "(id INTEGER not NULL AUTO_INCREMENT, " +
		                      " id_user INTEGER, " +
		                      " text VARCHAR(255), " +
		                      " rating INTEGER, " +
		                      " PRIMARY KEY ( id ))";
	        
	        String mentors = "CREATE TABLE IF NOT EXISTS mentors " +
          		  			 "(id INTEGER not NULL AUTO_INCREMENT, " +
          		  			 " id_user INTEGER, " +
          		  			 " description VARCHAR(255), " +
          		  			 " PRIMARY KEY ( id ))";
	        
	        String mentoringPrograms = "CREATE TABLE IF NOT EXISTS mentoring_programs " +
 		  			 				   "(id INTEGER not NULL AUTO_INCREMENT, " +
 		  			 				   " id_mentor INTEGER, " +
 		  			 				   " name VARCHAR(255), " +
 		  			 				   " difficulty_level VARCHAR(255)," +
 		  			 				   " description VARCHAR(255), " +
 		  			 				   " location VARCHAR(255), " +
 		  			 				   " duration VARCHAR(5), " +
 		  			 				   " price INTEGER, " +
 		  			 				   " currency VARCHAR(4), " +
 		  			 				   " field VARCHAR(50), " +
 		  			 				   " PRIMARY KEY ( id ))";
	        
	        String schedule = "CREATE TABLE IF NOT EXISTS schedule " +
 		  			 		  "(id INTEGER not NULL AUTO_INCREMENT, " +
 		  			 		  " id_mentoring_program INTEGER, " +
 		  			 		  " start_datetime VARCHAR(255), " +
 		  			 		  " repeat_bool BOOLEAN, " +
 		  			 		  " repeat_rate VARCHAR(50), " +
 		  			 		  " repeat_until VARCHAR(50), " +
 		  			 		  " PRIMARY KEY ( id ))";
	        
	        String courses = "CREATE TABLE IF NOT EXISTS courses " + 
	        				 "(id INTEGER not NULL AUTO_INCREMENT, " + 
	        				 "id_mentor INTEGER, " + 
	        				 "id_mentoring_program INTEGER, " + 
	        				 "name VARCHAR(50), " + 
	        				 "description VARCHAR(255), " +
	        				 "price INTEGER, " + 
	        				 "currency VARCHAR(4), " +
	        				 "PRIMARY KEY (id))";
	        
	        String resources = "CREATE TABLE IF NOT EXISTS resources " +
	        				   "(id_course INTEGER, " + 
	        				   "id_mentoring_program INTEGER, " +
	        				   "name VARCHAR(50), " + 
	        				   "file LONGBLOB)";
	        
	        stmt.executeUpdate(users);
	        stmt.executeUpdate(feedback);
	        stmt.executeUpdate(mentors);
	        stmt.executeUpdate(mentoringPrograms);
	        stmt.executeUpdate(schedule);
	        stmt.executeUpdate(courses);
	        stmt.executeUpdate(resources);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	        conn = null;
	    }
	}
	
//	public Connection getConnection()
//	{
//		return this.conn;
//	}
}
