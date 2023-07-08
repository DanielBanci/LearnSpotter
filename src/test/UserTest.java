package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.classes.Course;
import main.classes.MentoringProgram;
import main.classes.User;

public class UserTest {

	@Test
	public void defaultConstructorTest() {
		User user = new User();
		
		int id = user.getId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		List<Course> courses = user.getCourses();
		List<MentoringProgram> mentoringPrograms = user.getMentoringPrograms();
		
		assertEquals(0, id);
		assertEquals(null, firstName);
		assertEquals(null, lastName);
		assertEquals(null, email);
		assertEquals(null, password);
		assertEquals(null, phoneNumber);
		assertEquals(new ArrayList<Course>(), courses);
		assertEquals(new ArrayList<MentoringProgram>(), mentoringPrograms);
	}
	
	@Test
	public void fullConstructorTest() {
		User user = new User(1, "success", "success2", "success3", "success4", "success5", new ArrayList<Course>(), new ArrayList<MentoringProgram>(), null);
		
		int id = user.getId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		List<Course> courses = user.getCourses();
		List<MentoringProgram> mentoringPrograms = user.getMentoringPrograms();
		
		assertEquals(1, id);
		assertEquals("success", firstName);
		assertEquals("success2", lastName);
		assertEquals("success3", email);
		assertEquals("success4", password);
		assertEquals("success5", phoneNumber);
		assertEquals(new ArrayList<Course>(), courses);
		assertEquals(new ArrayList<MentoringProgram>(), mentoringPrograms);
	}
	
	@Test
	public void settersAndGettersTest() {
		User user = new User(-1, "fail", "fail2", "fail3", "fail4", "fail5", new ArrayList<Course>(), new ArrayList<MentoringProgram>(), null);
		
		user.setId(1);
		user.setFirstName("success");
		user.setLastName("success2");
		user.setEmail("success3");
		user.setPassword("success4");
		user.setPhoneNumber("success5");
		user.setCourses(new ArrayList<Course>());
		user.setMentoringPrograms(new ArrayList<MentoringProgram>());
		
		int id = user.getId();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		List<Course> courses = user.getCourses();
		List<MentoringProgram> mentoringPrograms = user.getMentoringPrograms();
		
		assertEquals(1, id);
		assertEquals("success", firstName);
		assertEquals("success2", lastName);
		assertEquals("success3", email);
		assertEquals("success4", password);
		assertEquals("success5", phoneNumber);
		assertEquals(new ArrayList<Course>(), courses);
		assertEquals(new ArrayList<MentoringProgram>(), mentoringPrograms);
	}

}
