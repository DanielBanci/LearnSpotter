package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Course;
import main.classes.Mentor;
import main.ui.coursePosts.CoursePost;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class CoursesPosts extends JPanel {

	public CoursesPosts(Mentor mentor) {
		this();
		if(mentor.getCourses().size() == 0) {
			add(new JLabel("No courses to be displayed"));
		}else {
			for(int i=0;i<mentor.getCourses().size();i++) {
				add(new CoursePost(mentor.getCourses().get(i)));
			}
		}
	}

	/**
	 * Create the panel.
	 */
	public CoursesPosts() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

}
