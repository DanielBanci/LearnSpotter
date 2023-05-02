package main.classes;

/**
 * A class that holds the data related to the feedback.
 * @author Cătălin
 * @version 1.0
 */
public class Feedback {
	private int id;
	private int idUser;
	private String text;
	private int rating;
	
	/**
	 * Creates a new instance of the Feedback class with default values.
	 */
	public Feedback() {
		id = 0;
		idUser = 0;
		text = null;
		rating = 0;
	}
	
	/**
	 * Creates a new instance of the Course class with the specified parameters.
	 */
	public Feedback(int id, int idUser, String text, int rating) {
		this.id = id;
		this.idUser = idUser;
		this.text = text;
		this.rating = rating;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
}
