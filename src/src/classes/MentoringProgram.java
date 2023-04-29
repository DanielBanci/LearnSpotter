package classes;

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
	 */
	public MentoringProgram(int id, int idMentor, String name, String difficultyLevel, String description, String location, Collection<java.sql.Timestamp> schedule) {
		this.id = id;
		this.idMentor = idMentor;
		this.name = name;
		this.difficultyLevel = difficultyLevel;
		this.description = description;
		this.location = location;
		this.schedule = schedule;
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
}
