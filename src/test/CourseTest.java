package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import main.classes.Course;
import main.classes.Feedback;
import main.classes.User;


public class CourseTest {
	@Test
	public void defaultConstructorTest() {
		Course course = new Course();
		
		int id = course.getId();
		String name = course.getName();
		int idMentor = course.getIdMentor();
		int idMentoringProgram = course.getIdMentoringProgram();
		String url = course.getUrl();
		String description = course.getDescription();
		int rating = course.getRating();
		int noViews = course.getNoViews();
		double price = course.getPrice();
		java.sql.Date lastUpdate = course.getLastUpdate();
		Collection<Feedback> feedback = course.getFeedback();
		
		assertEquals(0, id);
		assertEquals(null, name);
		assertEquals(0, idMentor);
		assertEquals(0, idMentoringProgram);
		assertEquals(null, url);
		assertEquals(null, description);
		assertEquals(0, rating);
		assertEquals(0, noViews);
		assertEquals(0.0d, price, 0.001d);
		assertEquals(null, lastUpdate);
		assertEquals(new ArrayList<Feedback>(), feedback);
	}
	
	@Test
	public void fullConstructorTest() {
		Course course = new Course(1, "success", 2, 3, "success2", "success3", 4, 5, 6.0d, new java.sql.Date(7), new ArrayList<Feedback>());
		
		int id = course.getId();
		String name = course.getName();
		int idMentor = course.getIdMentor();
		int idMentoringProgram = course.getIdMentoringProgram();
		String url = course.getUrl();
		String description = course.getDescription();
		int rating = course.getRating();
		int noViews = course.getNoViews();
		double price = course.getPrice();
		java.sql.Date lastUpdate = course.getLastUpdate();
		Collection<Feedback> feedback = course.getFeedback();
		
		assertEquals(1, id);
		assertEquals("success", name);
		assertEquals(2, idMentor);
		assertEquals(3, idMentoringProgram);
		assertEquals("success2", url);
		assertEquals("success3", description);
		assertEquals(4, rating);
		assertEquals(5, noViews);
		assertEquals(6.0d, price, 0.001d);
		assertEquals(new java.sql.Date(7), lastUpdate);
		assertEquals(new ArrayList<Feedback>(), feedback);
	}

	@Test
	public void settersAndGettersTest() {
		Course course = new Course(-1, "fail", -2, -3, "fail2", "fail3", -4, -5, -6.0d, new java.sql.Date(-7), new ArrayList<Feedback>(Arrays.asList(new Feedback(-1, new User(-1, "fail", "fail2", "fail3", "fail4", "fail5"), "fail", -2))));
		
		course.setId(1);
		course.setName("success");
		course.setIdMentor(2);
		course.setIdMentoringProgram(3);
		course.setUrl("success2");
		course.setDescription("success3");
		course.setRating(4);
		course.setNoViews(5);
		course.setPrice(6.0d);
		course.setLastUpdate(new java.sql.Date(7));
		course.setFeedback(new ArrayList<Feedback>(Arrays.asList(new Feedback(1, new User(1, "success", "success2", "success3", "success4", "success5"), "success", 2))));
		
		int id = course.getId();
		String name = course.getName();
		int idMentor = course.getIdMentor();
		int idMentoringProgram = course.getIdMentoringProgram();
		String url = course.getUrl();
		String description = course.getDescription();
		int rating = course.getRating();
		int noViews = course.getNoViews();
		double price = course.getPrice();
		java.sql.Date lastUpdate = course.getLastUpdate();
		Collection<Feedback> feedback = course.getFeedback();
		
		assertEquals(1, id);
		assertEquals("success", name);
		assertEquals(2, idMentor);
		assertEquals(3, idMentoringProgram);
		assertEquals("success2", url);
		assertEquals("success3", description);
		assertEquals(4, rating);
		assertEquals(5, noViews);
		assertEquals(6.0d, price, 0.001d);
		assertEquals(new java.sql.Date(7), lastUpdate);
		assertEquals(new ArrayList<Feedback>(Arrays.asList(new Feedback(1, new User(1, "success", "success2", "success3", "success4", "success5"), "success", 2))), feedback);
	}

}
