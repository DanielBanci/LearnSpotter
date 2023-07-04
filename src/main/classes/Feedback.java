package main.classes;

import java.util.Date;
import java.util.Objects;

/**
 * A class that holds the data related to the feedback.
 * @author Cătălin
 * @version 1.0
 */
public class Feedback {
	private int id;
	private User user;
	private String text;
	private int rating;
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Creates a new instance of the Feedback class with default values.
	 */
	public Feedback() {
		id = 0;
		user = new User();
		text = null;
		rating = 0;
		date = new java.util.Date();
	}
	
	/**
	 * Creates a new instance of the Course class with the specified parameters.
	 */
	public Feedback(int id, User user, String text, int rating,Date date) {
		this.id = id;
		this.user = user;
		this.text = text;
		this.rating = rating;
		this.date = date;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	/**
	 * @deprecated This method is only used for debugging
	 * @return an instance representing a mockup of the class for debugging purposes
	 */
	static public Feedback createMockup() {
		Feedback mockup = new Feedback(0, User.createMockup(), 
				"A really nice and easy to understand course! The course was well-organized and easy to navigate, "
				+ "and the content was presented in a clear and concise manner.Thank you for your hard work and dedication to your"
				+ " students' learning.", 4, new Date());
		return mockup;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Feedback otherFeedback = (Feedback)obj;
	    return (this.id == otherFeedback.id) 
	           && Objects.equals(this.user, otherFeedback.user) 
	           && Objects.equals(this.text, otherFeedback.text) 
	           && (this.rating == otherFeedback.rating);
	}
}
