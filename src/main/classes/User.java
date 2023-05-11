package main.classes;

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
	public User(int id, String firstName, String lastName, String email, String password, String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
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
}
