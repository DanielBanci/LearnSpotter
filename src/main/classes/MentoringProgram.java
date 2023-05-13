package main.classes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A class that holds the data related to the mentoring program.
 * @author Cătălin
 * @version 1.0
 */
public class MentoringProgram {
	private int id;
	private int idMentor;
	private String name;
	private String difficultyLevel;
	private String description;
	private String location;
	private Collection<java.sql.Timestamp> schedule;
	private int duration; //in weeks
	private int price;
	private Mentor mentor;
	private int rating;
	private int noViews;
	private String field;
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
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

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	/**
	 * Creates a new instance of the MentoringProgram class with the specified parameters.
	 */
	public MentoringProgram() {
		id = 0;
		idMentor = 0;
		name = null;
		difficultyLevel = null;
		description = null;
		location = null;
		schedule = new ArrayList<java.sql.Timestamp>();
		duration = 0;
		price = 0;
	}
	
	/**
	 * Creates a new instance of the MentoringProgram class with the specified parameters.
	 * @param id
	 * @param idMentor
	 * @param name
	 * @param difficultyLevel
	 * @param description
	 * @param location
	 * @param schedule
	 * @param duration
	 * @param price
	 */
	public MentoringProgram(int id, int idMentor, String name, String difficultyLevel, String description, String location,
			Collection<java.sql.Timestamp> schedule, int duration, int price,Mentor mentor,int rating,int noViews,String field) {
		this.id = id;
		this.idMentor = idMentor;
		this.name = name;
		this.difficultyLevel = difficultyLevel;
		this.description = description;
		this.location = location;
		this.schedule = schedule;
		this.duration = duration;
		this.price = price;
		this.mentor = mentor;
		this.rating = rating;
		this.noViews = noViews;
		this.field = field;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdMentor() {
		return idMentor;
	}
	public void setIdMentor(int idMentor) {
		this.idMentor = idMentor;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Collection<java.sql.Timestamp> getSchedule() {
		return schedule;
	}
	public void setSchedule(Collection<java.sql.Timestamp> schedule) {
		this.schedule = schedule;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @deprecated
	 */
	public static MentoringProgram createMockup() {
        // Create a mock mentor for the mentoring program
        Mentor mentor = Mentor.createMockup();

        MentoringProgram mockup = new MentoringProgram(0, 0, "Sample Program", "Intermediate",
                "Sample program description", "Sample location", new ArrayList<>(), 12, 100,
                mentor, 4, 100, "Sample Field");
        return mockup;
    }
}
