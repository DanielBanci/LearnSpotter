package main.classes;

/**
 * A class that holds the data related to the mentor.
 * @author Cătălin
 * @version 1.0
 */
public class Mentor {
	private int id;
	private int idUser;
	private String description;
	
	/**
	 * Creates a new instance of the Mentor class with default values.
	 */
	public Mentor() {
		id = 0;
		idUser = 0;
		description = null;
	}
	
	/**
	 * Creates a new instance of the Mentor class with the specified parameters.
	 * @param id
	 * @param idUser
	 * @param description
	 */
	public Mentor(int id, int idUser, String description) {
		this.id = id;
		this.idUser = idUser;
		this.description = description;
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
