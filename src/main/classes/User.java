package main.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class that holds the data related to the user.
 * @author Cătălin
 * @version 1.0
 */
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private List<Course> courses;									//payed or owned courses
	private List<MentoringProgram> mentoringPrograms;				//joined or owned mentoring programs
	
	public List<MentoringProgram> getMentoringPrograms() {
		return mentoringPrograms;
	}

	public void setMentoringPrograms(List<MentoringProgram> mentoringPrograms) {
		this.mentoringPrograms = mentoringPrograms;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	/**
	 * Creates a new instance of the User class with default values.
	 */
	public User() {
		id = 0;
		firstName = null;
		lastName = null;
		email = null;
		password = null;
		phoneNumber = null;
		
	}
	
	/**
	 * Creates a new instance of the User class with the specified parameters.
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param phoneNumber
	 */
	public User(int id, String firstName, String lastName, String email, String password, String phoneNumber,
		 List<Course> courses,List<MentoringProgram> mentoringPrograms) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.courses = courses;
		this.mentoringPrograms = mentoringPrograms;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    User otherUser = (User) obj;
	    return (this.id == otherUser.id) 
	           && Objects.equals(this.firstName, otherUser.firstName) 
	           && Objects.equals(this.lastName, otherUser.lastName) 
	           && Objects.equals(this.email, otherUser.email) 
	           && Objects.equals(this.password, otherUser.password) 
	           && Objects.equals(this.phoneNumber, otherUser.phoneNumber);
	}
	/**
	 * @deprecated
	 * @return
	 */
	public static User createMockup() {
	    // Create courses mockup
	    List<Course> courses = new ArrayList<>();
	    courses.add(Course.createMockup());

	    // Create mentoring programs mockup
	    List<MentoringProgram> mentoringPrograms = new ArrayList<>();
	    mentoringPrograms.add(MentoringProgram.createMockup());

	    // Create user mockup
	    User mockup = new User(0, "John", "Doe", "johndoe@example.com", "password", "555-12345", courses, mentoringPrograms);

	    return mockup;
	}

}
