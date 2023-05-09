package main.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import main.db.DbConnection;

/**
The EmailSender class represents an object that is responsible for sending emails to recipients.
@author Ciprian Banci
@version 1.0
*/
public class EmailSender {
	public EmailSender() { 
		
	}

	public void sendToAsync(String to) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					sendTo(to);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}

	/**
	Sends an email to a user with the given email address and password.
	The email contains the autentification data for the new account
	@param to The email address of the recipient.
	@param password The password of the recipient.
	 * @throws SQLException 
	*/
	public void sendTo(String to) throws SQLException {
		// Sender's email address and password
		final String username = "proiectpc17@gmail.com";
		final String password = "gehukxwlwqnuvsrp";
		
		// Email subject and body
		String subject = "Confirmation email";
		String body = "Dear, " + getUsernameFromDatabase(to) + "\n" + 
					  "This email is to let you know that your payment was successfull.\n" + 
					  "Your transaction id is: " + generateRandomString(10) + "\n" + 
					  "Thank you for using our services, \n" + 
					  "LearnSpotter Inc.";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		session.setDebug(true);
		
		try {
		    // Create a new email message
		    Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(username));
		    message.setRecipients(Message.RecipientType.TO,
		        InternetAddress.parse(to));
		    message.setSubject(subject);
		    message.setText(body);
		
		    // Send the email message
		    Transport.send(message);
		
		    System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
		    throw new RuntimeException(e);
		}
	}
	
	private String getUsernameFromDatabase(String email) throws SQLException
	{
		String lastName = "";
		
		DbConnection dbConnection = new DbConnection();
		Connection conn = dbConnection.getConnection();
		
		// Create a statement to execute the SQL query
        Statement stmt = conn.createStatement();
        
        // Execute the query and get the results
        String query = "SELECT last_name FROM users WHERE email='" + email + "'";
        System.out.println(query);
        
        ResultSet rs = stmt.executeQuery(query);
        
        // Process the results
        while (rs.next()) 
            lastName = rs.getString("last_name");
        
        // Close the connection
        conn.close();
        
        return lastName;
	}
	
	private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Characters to use in the random string
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
