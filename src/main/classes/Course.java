package main.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A class that holds the data related to the course.
 * @author Cătălin
 * @version 1.0
 */
public class Course {
	private int id;
	private String name;
	private int idMentor;
	private int idMentoringProgram;
	private String url;
	private String description;
	private int rating;
	private int noViews;
	private double price;
	private java.sql.Date lastUpdate;
	private Collection<Feedback> feedback;
	private Mentor owner;
	
	public Mentor getOwner() {
		return owner;
	}

	public void setOwner(Mentor owner) {
		this.owner = owner;
	}

	/**
	 * Creates a new instance of the Course class with default values.
	 */
	public Course() {
		id = 0;
		name = null;
		idMentor = 0;
		idMentoringProgram = 0;
		url = null;
		description = null;
		rating = 0;
		noViews = 0;
		price = 0.0f;
		lastUpdate = null;
		feedback = new ArrayList<Feedback>();
	}
	
	/**
	 * Creates a new instance of the Course class with the specified parameters.
	 * @param id
	 * @param name
	 * @param idMentor
	 * @param idMentoringProgram
	 * @param url
	 * @param description
	 * @param rating
	 * @param noViews
	 * @param price
	 * @param lastUpdate
	 * @param feedback
	 */
	public Course(int id, String name, int idMentor, int idMentoringProgram, String url, String description, int rating, int noViews,
			double price, java.sql.Date lastUpdate, Collection<Feedback> feedback,Mentor owner) {
		this.id = id;
		this.name = name;
		this.idMentor = idMentor;
		this.idMentoringProgram = idMentoringProgram;
		this.url = url;
		this.description = description;
		this.rating = rating;
		this.noViews = noViews;
		this.price = price;
		this.lastUpdate = lastUpdate;
		this.feedback = feedback;
		this.owner = owner;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdMentor() {
		return idMentor;
	}
	public void setIdMentor(int idMentor) {
		this.idMentor = idMentor;
	}
	
	public int getIdMentoringProgram() {
		return idMentoringProgram;
	}
	public void setIdMentoringProgram(int idMentoringProgram) {
		this.idMentoringProgram = idMentoringProgram;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getNoViews() {
		return noViews;
	}
	public void setNoViews(int noViews) {
		this.noViews = noViews;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public java.sql.Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(java.sql.Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Collection<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(Collection<Feedback> feedback) {
		this.feedback = feedback;
	}
	
	/**
	 * @deprecated This method is only used for debugging
	 * @return an instance representing a mockup of the class for debugging purposes
	 */
	static public Course createMockup() {
		String dateString = "09/12/2021";
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		Course mockup = new Course(0, "Software Engineering", 0, 0, "", "ceva descriere cum o fi sa fie doar sa fie sa vedem "
				+ "cum e ca de ce nu dor asa", 4, 0, 299.0d, sqlDate, new ArrayList<Feedback>(),new Mentor());
		return mockup;
	}
}
