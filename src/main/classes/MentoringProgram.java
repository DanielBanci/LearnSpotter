package main.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.db.DbConnection;
import main.ui.newContent.ScheduleData;

/**
 * A class that holds the data related to the mentoring program.
 * @author Cătălin
 * @version 1.0
 */
public class MentoringProgram {
	private int id;
	private int mentorId;
	private String name;
	private String difficultyLevel;
	private String description;
	private String location;
	private List<ScheduleData> schedule;
	private int duration; //in weeks
	private Double price;
	private Mentor mentor;
	private int rating;
	private int noViews;
	private String field;
	private List<Feedback> feedbacks;
	private Map<String,byte[]> files;
	private String currency;

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	
	public Map<String, byte[]> getFiles() {
		return files;
	}

	public void setFiles(Map<String, byte[]> files) {
		this.files = files;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Map<String,byte[]> getCourses() {
		return files;
	}

	public void setCourses(Map<String,byte[]> files) {
		this.files = files;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

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
	 * @param id
	 * @param name
	 * @param difficultyLevel
	 * @param description
	 * @param location
	 * @param schedule
	 * @param duration
	 * @param price
	 * @param mentor
	 * @param rating
	 * @param noViews
	 * @param field
	 * @param feedbacks
	 * @param files
	 * @param currency
	 */
	public MentoringProgram(int id,int mentorId, String name, String difficultyLevel, String description, String location, 
			List<ScheduleData> schedule, int duration, Double price,String currency,Mentor mentor,
			int rating,int noViews,String field, List<Feedback> feedbacks,Map<String,byte[]> files) {
		this.id = id;
		this.mentorId = mentorId;
		this.name = name;
		this.difficultyLevel = difficultyLevel;
		this.description = description;
		this.location = location;
		this.schedule = setupSchedule();
		this.duration = duration;
		this.price = price;
		this.currency = currency;
		this.mentor = mentor;
		this.rating = rating;
		this.noViews = noViews;
		this.field = field;
		this.feedbacks = feedbacks;
		this.files = files;
	}
	
	private List<ScheduleData> setupSchedule()
	{
		List<ScheduleData> schedules = new ArrayList<>();
		Connection conn = DbConnection.conn;

		String sql = "SELECT * FROM schedule WHERE id_mentoring_program=" + this.id;
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next())
				schedules.add(new ScheduleData(LocalDate.parse(rs.getString("start_datetime").split(" ")[0]), 
						LocalTime.parse(rs.getString("start_datetime").split(" ")[1]), 
						LocalDate.parse(rs.getString("repeat_until")), rs.getString("repeat_rate"), 
						rs.getBoolean("repeat_bool"), null));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return schedules;
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
	
	public List<ScheduleData> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<ScheduleData> schedule) {
		this.schedule = schedule;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @deprecated
	 */
	public static MentoringProgram createMockup() {
        // Create a mock mentor for the mentoring program
        Mentor mentor = Mentor.createMockup();
        MentoringProgram mockup = new MentoringProgram(0,0, "Sample Program", "Intermediate",
                "Sample program description", "Sample location", new ArrayList<ScheduleData>(), 12, 100.0,"RON",
                mentor, 4, 100, "Sample Field", new ArrayList<Feedback>(),new HashMap<String,byte[]>());
        return mockup;
    }
}
