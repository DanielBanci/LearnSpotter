package test;
import static org.junit.Assert.*;

import org.junit.Test;

import src.main.classes.Course;


public class CourseTest {
	
	@Test
	public void defaultConstructorTest() {
		src.main.classes.Course course = new Course();
		
		int id = course.getId();
		String name = course.getName();
		int idMentor = course.getIdMentor();
		int idMentoringProgram = course.getIdMentoringProgram();
		String url = course.getUrl();
		double price = course.getPrice();
		
		assertEquals(0, id);
		assertEquals(null, name);
		assertEquals(0, idMentor);
		assertEquals(0, idMentoringProgram);
		assertEquals(null, url);
		assertEquals(0.0d, price, 0.001d);
	}
	
	@Test
	public void fullConstructorTest() {
		Course course = new Course(1, "success", 2, 3, "success2", 4.0d);
		
		int id = course.getId();
		String name = course.getName();
		int idMentor = course.getIdMentor();
		int idMentoringProgram = course.getIdMentoringProgram();
		String url = course.getUrl();
		double price = course.getPrice();
		
		assertEquals(1, id);
		assertEquals("success", name);
		assertEquals(2, idMentor);
		assertEquals(3, idMentoringProgram);
		assertEquals("success2", url);
		assertEquals(4.0d, price, 0.001d);
	}

	@Test
	public void settersAndGettersTest() {
		Course course = new Course(-1, "fail", -2, -3, "fail2", -4.0d);
		
		course.setId(1);
		course.setName("success");
		course.setIdMentor(2);
		course.setIdMentoringProgram(3);
		course.setUrl("success2");
		course.setPrice(4.0d);
		
		int id = course.getId();
		String name = course.getName();
		int idMentor = course.getIdMentor();
		int idMentoringProgram = course.getIdMentoringProgram();
		String url = course.getUrl();
		double price = course.getPrice();
		
		assertEquals(1, id);
		assertEquals("success", name);
		assertEquals(2, idMentor);
		assertEquals(3, idMentoringProgram);
		assertEquals("success2", url);
		assertEquals(4.0d, price, 0.001d);
	}

}
