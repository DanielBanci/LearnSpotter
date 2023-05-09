package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Course;

import java.util.List;

import javax.swing.BoxLayout;

public class CoursesPosts extends JPanel {

	public CoursesPosts(List<Course> courses) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	/**
	 * Create the panel.
	 */
	public CoursesPosts() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

}
