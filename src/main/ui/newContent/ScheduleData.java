package main.ui.newContent;

/**
 * This class store the information about the mentoring program schedules.
 * The parent param is the container that has this panel and store and display the input data.
 * It has a starting date and a starting time and a boolean value(necessary).
 * The boolean value say whatever the date have to be repeated at a certain period or not.
 * TIP: Always check the value of repet(the boolean value) before using any of the following attributes:
 * atEvery, untilDate;
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleData{
	public LocalDate startDate;
	public LocalTime startTime;
	public LocalDate untilDate;
	public String atEvery;
	public Boolean repeat;
	public NewScheduleDatePanel parent;
	
	public ScheduleData() {}
	
	public ScheduleData(LocalDate startDate, LocalTime startTime, LocalDate untilDate, String atEvery, Boolean repeat,NewScheduleDatePanel parent) {
	this.startDate = startDate;
	this.startTime = startTime;
	this.untilDate = untilDate;
	this.atEvery = atEvery;
	this.repeat = repeat;
	}
	
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		ScheduleData otherSchedule = (ScheduleData)obj;
		return (startDate == otherSchedule.startDate
				&& startTime == otherSchedule.startTime
				&& untilDate == otherSchedule.untilDate
				&& atEvery == otherSchedule.atEvery
				&& repeat == otherSchedule.repeat);
	}
}
