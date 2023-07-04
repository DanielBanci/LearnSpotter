package test.java;


import static org.junit.Assert.*;

import org.junit.Test;

import main.classes.Schedule;

public class ScheduleTest {

	@Test
	public void defaultConstructorTest() {
		Schedule schedule = new Schedule();
		
		int id = schedule.getId();
		int idMentoringProgram = schedule.getIdMentoringProgram();
		java.sql.Date date = schedule.getDate();
		java.sql.Time startTime = schedule.getStartTime();
		
		assertEquals(0, id);
		assertEquals(0, idMentoringProgram);
		assertEquals(new java.sql.Date(0), date);
		assertEquals(new java.sql.Time(0), startTime);
	}
	
	@Test
	public void fullConstructorTest() {
		Schedule schedule = new Schedule(1, 2, new java.sql.Date(3), new java.sql.Time(4));
		
		int id = schedule.getId();
		int idMentoringProgram = schedule.getIdMentoringProgram();
		java.sql.Date date = schedule.getDate();
		java.sql.Time startTime = schedule.getStartTime();
		
		assertEquals(1, id);
		assertEquals(2, idMentoringProgram);
		assertEquals(new java.sql.Date(3), date);
		assertEquals(new java.sql.Time(4), startTime);
	}
	
	@Test
	public void gettersAndSettersTest() {
		Schedule schedule = new Schedule(-1, -2, new java.sql.Date(-3), new java.sql.Time(-4));
		
		schedule.setId(1);
		schedule.setIdMentoringProgram(2);
		schedule.setDate(new java.sql.Date(3));
		schedule.setStartTime(new java.sql.Time(4));
		
		int id = schedule.getId();
		int idMentoringProgram = schedule.getIdMentoringProgram();
		java.sql.Date date = schedule.getDate();
		java.sql.Time startTime = schedule.getStartTime();
		
		assertEquals(1, id);
		assertEquals(2, idMentoringProgram);
		assertEquals(new java.sql.Date(3), date);
		assertEquals(new java.sql.Time(4), startTime);
	}
}
