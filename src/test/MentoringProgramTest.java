package test;


import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import main.classes.MentoringProgram;

public class MentoringProgramTest {

	@Test
	public void defaultConstructorTest() {
		MentoringProgram mentoringProgram = new MentoringProgram();
		
		int id = mentoringProgram.getId();
		int idMentor = mentoringProgram.getIdMentor();
		String name = mentoringProgram.getName();
		String difficultyLevel = mentoringProgram.getDifficultyLevel();
		String description = mentoringProgram.getDescription();
		String location = mentoringProgram.getLocation();
		Collection<java.sql.Timestamp> schedule = mentoringProgram.getSchedule();
		
		assertEquals(0, id);
		assertEquals(0, idMentor);
		assertEquals(null, name);
		assertEquals(null, difficultyLevel);
		assertEquals(null, description);
		assertEquals(null, location);
		assertEquals(new ArrayList<java.sql.Timestamp>(), schedule);
	}
	
	@Test
	public void fullConstructorTest() {
		MentoringProgram mentoringProgram = new MentoringProgram(1, 2, "success", "success2", "success3", "success4", new ArrayList<java.sql.Timestamp>(Arrays.asList(new Timestamp(3))));
		
		int id = mentoringProgram.getId();
		int idMentor = mentoringProgram.getIdMentor();
		String name = mentoringProgram.getName();
		String difficultyLevel = mentoringProgram.getDifficultyLevel();
		String description = mentoringProgram.getDescription();
		String location = mentoringProgram.getLocation();
		Collection<java.sql.Timestamp> schedule = mentoringProgram.getSchedule();
		
		assertEquals(1, id);
		assertEquals(2, idMentor);
		assertEquals("success", name);
		assertEquals("success2", difficultyLevel);
		assertEquals("success3", description);
		assertEquals("success4", location);
		assertEquals(new ArrayList<java.sql.Timestamp>(Arrays.asList(new Timestamp(3))), schedule);
	}
	
	@Test
	public void gettersAndSettersTest() {
		MentoringProgram mentoringProgram = new MentoringProgram(-1, -2, "fail", "fail2", "fail3", "fail4", new ArrayList<java.sql.Timestamp>(Arrays.asList(new Timestamp(-3))));
		
		mentoringProgram.setId(1);
		mentoringProgram.setIdMentor(2);
		mentoringProgram.setName("success");
		mentoringProgram.setDifficultyLevel("success2");
		mentoringProgram.setDescription("success3");
		mentoringProgram.setLocation("success4");
		mentoringProgram.setSchedule(new ArrayList<java.sql.Timestamp>(Arrays.asList(new Timestamp(3))));
		
		int id = mentoringProgram.getId();
		int idMentor = mentoringProgram.getIdMentor();
		String name = mentoringProgram.getName();
		String difficultyLevel = mentoringProgram.getDifficultyLevel();
		String description = mentoringProgram.getDescription();
		String location = mentoringProgram.getLocation();
		Collection<java.sql.Timestamp> schedule = mentoringProgram.getSchedule();
		
		assertEquals(1, id);
		assertEquals(2, idMentor);
		assertEquals("success", name);
		assertEquals("success2", difficultyLevel);
		assertEquals("success3", description);
		assertEquals("success4", location);
		assertEquals(new ArrayList<java.sql.Timestamp>(Arrays.asList(new Timestamp(3))), schedule);
	}

}
