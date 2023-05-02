package src.main.classes;

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
	private double price;
	
	/**
	 * Creates a new instance of the Course class with default values.
	 */
	public Course() {
		id = 0;
		name = null;
		idMentor = 0;
		idMentoringProgram = 0;
		url = null;
		price = 0.0f;
	}
	
	/**
	 * Creates a new instance of the Course class with the specified parameters.
	 * @param id
	 * @param name
	 * @param idMentor
	 * @param idMentoringProgram
	 * @param url
	 * @param price
	 */
	public Course(int id, String name, int idMentor, int idMentoringProgram, String url, double price) {
		this.id = id;
		this.name = name;
		this.idMentor = idMentor;
		this.idMentoringProgram = idMentoringProgram;
		this.url = url;
		this.price = price;
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
}
