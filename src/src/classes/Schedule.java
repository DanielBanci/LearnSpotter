package classes;

/**
 * A class that holds the data related to the schedule.
 * @author Cătălin
 * @version 1.0
 */
public class Schedule {
	private int id;
	private int idMentoringProgram;
	private java.sql.Date date;
	private java.sql.Time startTime;
	
	/**
	 * Creates a new instance of the Schedule class with default values.
	 */
	public Schedule() {
		id = 0;
		idMentoringProgram = 0;
		date = new java.sql.Date(0);
		startTime = new java.sql.Time(0);
	}
	
	/**
	 * Creates a new instance of the Schedule class with the specified parameters.
	 * @param id
	 * @param idMentoringProgram
	 * @param date
	 * @param startTime
	 */
	public Schedule(int id, int idMentoringProgram, java.sql.Date date, java.sql.Time startTime) {
		this.id = id;
		this.idMentoringProgram = idMentoringProgram;
		this.date = date;
		this.startTime = startTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdMentoringProgram() {
		return idMentoringProgram;
	}
	public void setIdMentoringProgram(int idMentoringProgram) {
		this.idMentoringProgram = idMentoringProgram;
	}
	
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	public java.sql.Time getStartTime() {
		return startTime;
	}
	public void setStartTime(java.sql.Time startTime) {
		this.startTime = startTime;
	}
}
