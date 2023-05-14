package test;


import static org.junit.Assert.*;

import org.junit.Test;

import main.classes.Feedback;
import main.classes.User;

public class FeedbackTest {

	@Test
	public void defaultConstructorTest() {
		Feedback feedback = new Feedback();
		
		int id = feedback.getId();
		User user = feedback.getUser();
		String text = feedback.getText();
		int rating = feedback.getRating();
		java.util.Date date = feedback.getDate();
		
		assertEquals(0, id);
		assertEquals(new User(), user);
		assertEquals(null, text);
		assertEquals(0, rating);
		assertEquals(new java.util.Date(), date);
	}
	
	@Test
	public void fullConstructorTest() {
		Feedback feedback = new Feedback(1, new User(1, "success", "success2", "success3", "succes4", "success5"), "success", 2, new java.util.Date(3));
		
		int id = feedback.getId();
		User user = feedback.getUser();
		String text = feedback.getText();
		int rating = feedback.getRating();
		java.util.Date date = feedback.getDate();

		assertEquals(1, id);
		assertEquals(new User(1, "success", "success2", "success3", "succes4", "success5"), user);
		assertEquals("success", text);
		assertEquals(2, rating);
		assertEquals(new java.util.Date(3), date);
	}
	
	@Test
	public void settersAndGettersTest() {
		Feedback feedback = new Feedback(-1, new User(-1, "fail", "fail2", "fail3", "fail4", "fail5"), "fail", -2, new java.util.Date(-3));
		
		feedback.setId(1);
		feedback.setUser(new User(1, "success", "success2", "success3", "succes4", "success5"));
		feedback.setText("success");
		feedback.setRating(2);
		feedback.setDate(new java.util.Date(3));
		
		int id = feedback.getId();
		User user = feedback.getUser();
		String text = feedback.getText();
		int rating = feedback.getRating();
		java.util.Date date = feedback.getDate();
		
		assertEquals(1, id);
		assertEquals(new User(1, "success", "success2", "success3", "succes4", "success5"), user);
		assertEquals("success", text);
		assertEquals(2, rating);
		assertEquals(new java.util.Date(3), date);
	}

}
