package test;


import static org.junit.Assert.*;

import org.junit.Test;

import src.main.classes.Feedback;

public class FeedbackTest {

	@Test
	public void defaultConstructorTest() {
		Feedback feedback = new Feedback();
		
		int id = feedback.getId();
		int idUser = feedback.getIdUser();
		String text = feedback.getText();
		int rating = feedback.getRating();
		
		assertEquals(0, id);
		assertEquals(0, idUser);
		assertEquals(null, text);
		assertEquals(0, rating);
	}
	
	@Test
	public void fullConstructorTest() {
		Feedback feedback = new Feedback(1, 2, "success", 3);
		
		int id = feedback.getId();
		int idUser = feedback.getIdUser();
		String text = feedback.getText();
		int rating = feedback.getRating();

		assertEquals(1, id);
		assertEquals(2, idUser);
		assertEquals("success", text);
		assertEquals(3, rating);
	}
	
	@Test
	public void settersAndGettersTest() {
		Feedback feedback = new Feedback(-1, -2, "fail", -3);
		
		feedback.setId(1);
		feedback.setIdUser(2);
		feedback.setText("success");
		feedback.setRating(3);
		
		int id = feedback.getId();
		int idUser = feedback.getIdUser();
		String text = feedback.getText();
		int rating = feedback.getRating();
		
		assertEquals(1, id);
		assertEquals(2, idUser);
		assertEquals("success", text);
		assertEquals(3, rating);
	}

}
