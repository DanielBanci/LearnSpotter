package test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.classes.Card;
import main.classes.Course;
import main.classes.Feedback;
import main.classes.Mentor;
import main.classes.MentoringProgram;

public class MentorTest {
	@Test
	public void defaultConstructorTest() {
		Mentor mentor = new Mentor();
		
		int id = mentor.getId();
		String firstName = mentor.getFirstName();
		String lastName = mentor.getLastName();
		String email = mentor.getEmail();
		String password = mentor.getPassword();
		String phoneNumber = mentor.getPhoneNumber();
		String description = mentor.getDescription();
		String field = mentor.getField();
		int programsNumber = mentor.getProgramsNumber();
		java.util.Date registerDate = mentor.getRegisterDate();
		List<Feedback> feedbacks = mentor.getFeedbacks();
		List<Course> courses = mentor.getCourses();
		List<MentoringProgram> mentoringPrograms = mentor.getMentoringPrograms();
		
		assertEquals(0, id);
		assertEquals(null, firstName);
		assertEquals(null, lastName);
		assertEquals(null, email);
		assertEquals(null, password);
		assertEquals(null, phoneNumber);
		assertEquals(null, description);
		assertEquals(null, field);
		assertEquals(0, programsNumber);
		assertEquals(null, registerDate);
		assertEquals(new ArrayList<Feedback>(), feedbacks);
		assertEquals(new ArrayList<Course>(), courses);
		assertEquals(new ArrayList<MentoringProgram>() ,mentoringPrograms);
	}
	
	@Test
	public void fullConstructorTest() {
		Mentor mentor = new Mentor(1, "success", "success2", "success3", "success4", "success5", "success6", "success7", 2, new java.util.Date(3), new ArrayList<Feedback>(), new ArrayList<Course>(), new ArrayList<MentoringProgram>(), new Card());
		
		int id = mentor.getId();
		String firstName = mentor.getFirstName();
		String lastName = mentor.getLastName();
		String email = mentor.getEmail();
		String password = mentor.getPassword();
		String phoneNumber = mentor.getPhoneNumber();
		String description = mentor.getDescription();
		String field = mentor.getField();
		int programsNumber = mentor.getProgramsNumber();
		java.util.Date registerDate = mentor.getRegisterDate();
		List<Feedback> feedbacks = mentor.getFeedbacks();
		List<Course> courses = mentor.getCourses();
		List<MentoringProgram> mentoringPrograms = mentor.getMentoringPrograms();
		Card card = mentor.getCard();
		
		assertEquals(1, id);
		assertEquals("success", firstName);
		assertEquals("success2", lastName);
		assertEquals("success3", email);
		assertEquals("success4", password);
		assertEquals("success5", phoneNumber);
		assertEquals("success6", description);
		assertEquals("success7", field);
		assertEquals(2, programsNumber);
		assertEquals(new java.util.Date(3), registerDate);
		assertEquals(new ArrayList<Feedback>(), feedbacks);
		assertEquals(new ArrayList<Course>(), courses);
		assertEquals(new ArrayList<MentoringProgram>() ,mentoringPrograms);
		assertEquals(new Card(), card);
	}
	
	@Test
	public void settersAndGettersTest() {
		Mentor mentor = new Mentor(-1, "fail", "fail2", "fail3", "fail4", "fail5", "fail6", "fail7", -2, new java.util.Date(-3), new ArrayList<Feedback>(), new ArrayList<Course>(), new ArrayList<MentoringProgram>(), new Card());
		
		mentor.setId(1);
		mentor.setFirstName("success");
		mentor.setLastName("success2");
		mentor.setEmail("success3");
		mentor.setPassword("success4");
		mentor.setPhoneNumber("success5");
		mentor.setDescription("success6");
		mentor.setField("success7");
		mentor.setProgramsNumber(2);
		mentor.setRegisterDate(new java.util.Date(3));
		mentor.setFeedbacks(new ArrayList<Feedback>());
		mentor.setCourses(new ArrayList<Course>());
		mentor.setMentoringPrograms(new ArrayList<MentoringProgram>());
		mentor.setCard(new Card());
		
		int id = mentor.getId();
		String firstName = mentor.getFirstName();
		String lastName = mentor.getLastName();
		String email = mentor.getEmail();
		String password = mentor.getPassword();
		String phoneNumber = mentor.getPhoneNumber();
		String description = mentor.getDescription();
		String field = mentor.getField();
		int programsNumber = mentor.getProgramsNumber();
		java.util.Date registerDate = mentor.getRegisterDate();
		List<Feedback> feedbacks = mentor.getFeedbacks();
		List<Course> courses = mentor.getCourses();
		List<MentoringProgram> mentoringPrograms = mentor.getMentoringPrograms();
		Card card = mentor.getCard();
		
		assertEquals(1, id);
		assertEquals("success", firstName);
		assertEquals("success2", lastName);
		assertEquals("success3", email);
		assertEquals("success4", password);
		assertEquals("success5", phoneNumber);
		assertEquals("success6", description);
		assertEquals("success7", field);
		assertEquals(2, programsNumber);
		assertEquals(new java.util.Date(3), registerDate);
		assertEquals(new ArrayList<Feedback>(), feedbacks);
		assertEquals(new ArrayList<Course>(), courses);
		assertEquals(new ArrayList<MentoringProgram>() ,mentoringPrograms);
		assertEquals(new Card(), card);
	}

}
