package main.classes;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import main.db.DbConnection;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.utility.ImageLoader;

/**
 * A class that holds the data related to the mentor.
 * @author Cătălin
 * @version 1.0
 */
public class Mentor extends User {
	private int noReviews;
	
	private String description;
	private String field;
	private int programsNumber;
	private Date registerDate;
	private List<Feedback> feedbacks;
	private Card card;
	private String location;
	private int id;
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public int getProgramsNumber()
	{
		return this.getMentoringPrograms().size();
	}

	/**
	 * Creates a new instance of the Mentor class with default values.
	 */
	public Mentor() {
		super();
		description = null;
		field = null;
		programsNumber = 0;
		registerDate = null;
		feedbacks = new ArrayList<Feedback>();
		card = new Card();
	}
	
	/**
	 * Creates a new instance of the Mentor class with the specified parameters.
	 * @param id
	 * @param idUser
	 * @param description
	 * @param field
	 * @param programsNumber
	 * @param registerDate
	 * @param feedbacks
	 * @param courses
	 * @param mentoringPrograms
	 * @param card
	 * @param profilePic 
	 */
	public Mentor(int id, String firstName, String lastName, String email, String password, 
			String phoneNumber, Image profilePic, String location, String description, String field, 
			int programsNumber,Date registerDate,List<Feedback> feedbacks,List<Course> courses, 
			List<MentoringProgram> mentoringPrograms,Card card) {
		super(id, firstName, lastName, email, password, phoneNumber,courses,mentoringPrograms,profilePic);
		
		this.id = id;
		this.location = location;
		this.description = description;
		this.field = field;
		this.programsNumber = programsNumber;
		this.registerDate = registerDate;
		this.feedbacks = feedbacks;
		this.card = card;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	public void setProgramsNumber(int programsNumber) {
		this.programsNumber = programsNumber;
	}
	
	public int getNoReviews() {
		return noReviews;
	}
	public void setNoReviews(int noReviews) {
		this.noReviews = noReviews;
	}
	
	/**
	 * @deprecated This method is only used for debugging
	 * @return an instance representing a mockup of the class for debugging purposes
	 */
	public static Mentor createMockup() {
		Mentor mockup = new Mentor(0, "OBVIOUS", "FAKENAMINGTON", "obvious.fakenamington@fakemail.gov", "password", "555-93847",
				ImageLoader.getInstance().getUserIcon(),
				"Boston", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Sed ac risus vitae velit sodales bibendum quis eget dui. "
                + "Morbi eget placerat ipsum. Donec nec mi in nisi aliquam volutpat non ac elit. "
                + "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
                + "Nulla facilisi. Sed tincidunt ex ac varius commodo. "
                + "Nam laoreet libero mauris, vel facilisis justo vehicula sed. "
                + "Pellentesque in bibendum velit. Nullam consequat quam ut neque mollis, "
                + "vitae porttitor sapien bibendum. Vivamus mollis purus in justo finibus, "
                + "vel ultricies velit vestibulum. Duis pretium auctor ipsum, a commodo libero consectetur eget.", "garFIELD!!!", 0,new Date(),
                new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),Card.createMockup());
		return mockup;
	}
}
