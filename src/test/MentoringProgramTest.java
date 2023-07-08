package test;


import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.classes.Feedback;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.ui.newContent.ScheduleData;

public class MentoringProgramTest {

	/*
	@Test
	public void defaultConstructorTest() {
		MentoringProgram mentoringProgram = new MentoringProgram();
		
		int id = mentoringProgram.getId();
		String name = mentoringProgram.getName();
		String difficultyLevel = mentoringProgram.getDifficultyLevel();
		String description = mentoringProgram.getDescription();
		String location = mentoringProgram.getLocation();
		Collection<ScheduleData> schedule = mentoringProgram.getSchedule();
		int duration = mentoringProgram.getDuration();
		Double price = mentoringProgram.getPrice();
		String currency = mentoringProgram.getCurrency();
		Mentor mentor = mentoringProgram.getMentor();
		int rating = mentoringProgram.getRating();
		int noViews = mentoringProgram.getNoViews();
		String field = mentoringProgram.getField();
		List<Feedback> feedbacks = mentoringProgram.getFeedbacks();
		Map<String, byte[]> files = mentoringProgram.getFiles();
		
		assertEquals(0, id);
		assertEquals(null, name);
		assertEquals(null, difficultyLevel);
		assertEquals(null, description);
		assertEquals(null, location);
		assertEquals(new ArrayList<ScheduleData>(), schedule);
		assertEquals(0, duration);
		assertEquals(0.0d, price, 0.001d);
		assertEquals(null, currency);
		assertEquals(new Mentor(), mentor);
		assertEquals(0, rating);
		assertEquals(0, noViews);
		assertEquals(null, field);
		assertEquals(new ArrayList<Feedback>(), feedbacks);
		assertEquals(new HashMap<String, byte[]>(), files);
	}
	*/
	
	@Test
	public void fullConstructorTest() {
		MentoringProgram mentoringProgram = new MentoringProgram(1, 2, "success", "success2", "success3", "success4", new ArrayList<ScheduleData>(Arrays.asList(new ScheduleData())), 3, 4.0d, "success5", new Mentor(), 5, 6, "success6", new ArrayList<Feedback>(), new HashMap<String, byte[]>());
		
		int id = mentoringProgram.getId();
		int mentorId = mentoringProgram.getMentorId();
		String name = mentoringProgram.getName();
		String difficultyLevel = mentoringProgram.getDifficultyLevel();
		String description = mentoringProgram.getDescription();
		String location = mentoringProgram.getLocation();
		Collection<ScheduleData> schedule = mentoringProgram.getSchedule();
		int duration = mentoringProgram.getDuration();
		Double price = mentoringProgram.getPrice();
		String currency = mentoringProgram.getCurrency();
		Mentor mentor = mentoringProgram.getMentor();
		int rating = mentoringProgram.getRating();
		int noViews = mentoringProgram.getNoViews();
		String field = mentoringProgram.getField();
		List<Feedback> feedbacks = mentoringProgram.getFeedbacks();
		Map<String, byte[]> files = mentoringProgram.getFiles();
		
		assertEquals(1, id);
		assertEquals(2, mentorId);
		assertEquals("success", name);
		assertEquals("success2", difficultyLevel);
		assertEquals("success3", description);
		assertEquals("success4", location);
		assertEquals(Collections.emptyList(), schedule);
		assertEquals(3, duration);
		assertEquals(4.0, price, 0.001d);
		assertEquals("success5", currency);
		assertEquals(new Mentor(), mentor);
		assertEquals(5, rating);
		assertEquals(6, noViews);
		assertEquals("success6", field);
		assertEquals(new ArrayList<Feedback>(), feedbacks);
		assertEquals(new HashMap<String, byte[]>(), files);
	}
	
	@Test
	public void gettersAndSettersTest() {
		MentoringProgram mentoringProgram = new MentoringProgram(-1, -2, "fail", "fail2", "fail3", "fail4", new ArrayList<ScheduleData>(), -3, -4.0d, "fail5", new Mentor(), -5, -6, "fail6", new ArrayList<Feedback>(), new HashMap<String, byte[]>());
		
		mentoringProgram.setId(1);
		mentoringProgram.setMentorId(2);
		mentoringProgram.setName("success");
		mentoringProgram.setDifficultyLevel("success2");
		mentoringProgram.setDescription("success3");
		mentoringProgram.setLocation("success4");
		mentoringProgram.setSchedule(new ArrayList<ScheduleData>(Arrays.asList(new ScheduleData())));
		mentoringProgram.setDuration(3);
		mentoringProgram.setPrice(4.0d);
		mentoringProgram.setCurrency("success5");
		mentoringProgram.setMentor(new Mentor());
		mentoringProgram.setRating(5);
		mentoringProgram.setNoViews(6);
		mentoringProgram.setField("success6");
		mentoringProgram.setFeedbacks(new ArrayList<Feedback>());
		mentoringProgram.setFiles(new HashMap<String, byte[]>());
		
		int id = mentoringProgram.getId();	
		int mentorId = mentoringProgram.getMentorId();		
		String name = mentoringProgram.getName();
		String difficultyLevel = mentoringProgram.getDifficultyLevel();
		String description = mentoringProgram.getDescription();
		String location = mentoringProgram.getLocation();
		Collection<ScheduleData> schedule = mentoringProgram.getSchedule();
		int duration = mentoringProgram.getDuration();
		Double price = mentoringProgram.getPrice();
		String currency = mentoringProgram.getCurrency();
		Mentor mentor = mentoringProgram.getMentor();
		int rating = mentoringProgram.getRating();
		int noViews = mentoringProgram.getNoViews();
		String field = mentoringProgram.getField();
		List<Feedback> feedbacks = mentoringProgram.getFeedbacks();
		Map<String, byte[]> files = mentoringProgram.getFiles();
		
		assertEquals(1, id);
		assertEquals(2, mentorId);
		assertEquals("success", name);
		assertEquals("success2", difficultyLevel);
		assertEquals("success3", description);
		assertEquals("success4", location);
		assertEquals(new ArrayList<ScheduleData>(Arrays.asList(new ScheduleData())), schedule);
		assertEquals(3, duration);
		assertEquals(4.0, price, 0.001d);
		assertEquals("success5", currency);
		assertEquals(new Mentor(), mentor);
		assertEquals(5, rating);
		assertEquals(6, noViews);
		assertEquals("success6", field);
		assertEquals(new ArrayList<Feedback>(), feedbacks);
		assertEquals(new HashMap<String, byte[]>(), files);
	}

}
