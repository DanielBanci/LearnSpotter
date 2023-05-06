package main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	private Connection conn;
	
	public DbConnection() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/proiectpc";
	    String username = "root";
	    String password = "";
	      
	    this.conn = DriverManager.getConnection(jdbcUrl, username, password);
	}
	
	public void initializeDatabase()
	{
		try {
	        Statement stmt = conn.createStatement();
	        String users = "CREATE TABLE IF NOT EXISTS users " +
	                       "(id INTEGER not NULL, " +
	                       " first_name VARCHAR(255), " +
	                       " last_name VARCHAR(255), " +
	                       " email VARCHAR(255), " +
	                       " password VARCHAR(255), " +
	                       " phone_number VARCHAR(255), " +
	                       " id_rating INTEGER, " +
	                       " PRIMARY KEY ( id ))";

	        String feedback = "CREATE TABLE IF NOT EXISTS feedback " +
                    		  "(id INTEGER not NULL, " +
		                      " id_user INTEGER, " +
		                      " text VARCHAR(255), " +
		                      " rating INTEGER, " +
		                      " PRIMARY KEY ( id ))";
	        
	        String mentors = "CREATE TABLE IF NOT EXISTS mentors " +
          		  			 "(id INTEGER not NULL, " +
          		  			 " id_user INTEGER, " +
          		  			 " description VARCHAR(255), " +
          		  			 " PRIMARY KEY ( id ))";
	        
	        String mentoringPrograms = "CREATE TABLE IF NOT EXISTS mentors " +
 		  			 				   "(id INTEGER not NULL, " +
 		  			 				   " id_mentor INTEGER, " +
 		  			 				   " name VARCHAR(255), " +
 		  			 				   " difficulty_level VARCHAR(255)," +
 		  			 				   " description VARCHAR(255), " +
 		  			 				   " location VARCHAR(255), " + 
 		  			 				   " schedule_id INTEGER, " +
 		  			 				   " PRIMARY KEY ( id ))";
	        
	        String schedule = "CREATE TABLE IF NOT EXISTS schedule " +
 		  			 		  "(id INTEGER not NULL, " +
 		  			 		  " id_mentoring_program INTEGER, " +
 		  			 		  " date DATE, " +
 		  			 		  " start_time TIME, " +
 		  			 		  " PRIMARY KEY ( id ))";
	        
	        stmt.executeUpdate(users);
	        stmt.executeUpdate(feedback);
	        stmt.executeUpdate(mentors);
	        stmt.executeUpdate(mentoringPrograms);
	        stmt.executeUpdate(schedule);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	        this.conn = null;
	    }
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
}
