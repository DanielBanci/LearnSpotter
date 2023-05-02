package test;


import static org.junit.Assert.*;

import org.junit.Test;

import main.classes.Mentor;

public class MentorTest {

	@Test
	public void defaultConstructorTest() {
		Mentor mentor = new Mentor();
		
		int id = mentor.getId();
		int idUser = mentor.getIdUser();
		String description = mentor.getDescription();
		
		assertEquals(0, id);
		assertEquals(0, idUser);
		assertEquals(null, description);
	}
	
	@Test
	public void fullConstructorTest() {
		Mentor mentor = new Mentor(1, 2, "success");
		
		int id = mentor.getId();
		int idUser = mentor.getIdUser();
		String description = mentor.getDescription();
		
		assertEquals(1, id);
		assertEquals(2, idUser);
		assertEquals("success", description);
	}
	
	@Test
	public void settersAndGettersTest() {
		Mentor mentor = new Mentor(-1, -2, "fail");
		
		mentor.setId(1);
		mentor.setIdUser(2);
		mentor.setDescription("success");
		
		int id = mentor.getId();
		int idUser = mentor.getIdUser();
		String description = mentor.getDescription();
		
		assertEquals(1, id);
		assertEquals(2, idUser);
		assertEquals("success", description);
	}

}
