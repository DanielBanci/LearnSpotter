package main.classes;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.db.DbConnection;

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
	private Map<String,byte[]> pdfFiles;
	private String field;
	private String description;
	private int rating;
	private int noViews;
	private Double price;
	private Date lastUpdate;
	private List<Feedback> feedback;
	private Mentor owner;
	private String currency;
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Map<String, byte[]> getPdfFiles() {
		return pdfFiles;
	}
	
	public void setPdfFiles(Map<String, byte[]> pdfFiles) {
		this.pdfFiles = pdfFiles;
	}
	
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
		pdfFiles = new HashMap<String, byte[]>();
		field = null;
		description = null;
		rating = 0;
		noViews = 0;
		price = 0.0;
		lastUpdate = null;
		feedback = new ArrayList<Feedback>();
	}
	
	/**
	 * Creates a new instance of the Course class with the specified parameters.
	 * @param id
	 * @param name
	 * @param idMentor
	 * @param idMentoringProgram
	 * @param pdfFiles
	 * @param url
	 * @param description
	 * @param rating
	 * @param noViews
	 * @param price
	 * @param lastUpdate
	 * @param feedback
	 */
	public Course(int id, String name, int idMentor, int idMentoringProgram, String field, String description, int rating, int noViews,
			Double price, Date lastUpdate, List<Feedback> feedback,Mentor owner,Map<String,byte[]> pdfFiles,String currency) {

		this.id = id;
		this.name = name;
		this.idMentor = idMentor;
		this.idMentoringProgram = idMentoringProgram;
		this.pdfFiles = pdfFiles;
		this.field = field;
		this.description = description;
		this.rating = rating;
		this.noViews = noViews;
		this.price = price;
		this.lastUpdate = lastUpdate;
		this.feedback = feedback;
		//this.owner = setupOwner();
		this.owner = owner;
		this.pdfFiles = pdfFiles;
		this.currency = currency;
	}
	
	private Mentor setupOwner()
	{
		Connection conn = DbConnection.conn;
		
		String sql = "SELECT * FROM users where type='mentor' AND id=" + this.idMentor;
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs3 = statement.executeQuery(sql);
			
			if(rs3.next())
			{
				return new Mentor(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
						rs3.getString(5), rs3.getString(6), null, "", rs3.getString(7), 
						rs3.getString(8), rs3.getInt(9), null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return new Mentor();
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
	
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public List<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	/**
	 * @deprecated This method is only used for debugging
	 * @return an instance representing a mockup of the class for debugging purposes
	 */
	static public Course createMockup() {
		String dateString = "09/12/2021";
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		/*java.util.Date parsed = null;
		try {
			parsed = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		Course mockup = new Course(0, "Software Engineering", 0, 0, "field","ceva descriere cum o fi sa fie doar sa fie sa vedem "
				+ "cum e ca de ce nu dor asa", 4, 0, 299.0, new Date(), new ArrayList<Feedback>(),Mentor.createMockup(),
				new HashMap<String,byte[]>(),"currency");
		return mockup;
	}
}
