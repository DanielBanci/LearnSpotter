package main.ui.mentoringProgram;

import javax.swing.JPanel;

import main.classes.MentoringProgram;
import main.ui.coursePosts.CourseFilePanel;
import main.ui.coursePosts.CoursePost;
import main.ui.coursePosts.FeedbackPanel;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class CoursesPanel extends JPanel {

	public CoursesPanel(MentoringProgram mentoringProgram,MentoringProgramDetails mentoringProgramDetails) {
		this();
		if(mentoringProgram.getCourses().size() != 0) {
			for(int i=0;i<mentoringProgram.getCourses().size();i++) {
				//add(new CoursePost(mentoringProgram.getCourses().get(i)));
				add(new CourseFilePanel());
			}
		}else {
			//add(new JLabel("No courses to display."));
			for(int i=0;i<10;i++) {
				//add(new CoursePost(mentoringProgram.getCourses().get(i)));
				add(new CourseFilePanel(mentoringProgramDetails,false));
			}
		}
	}
	
	public void setPaymentStatus(Boolean status) {
		for(Component c : getComponents()) {
			((CourseFilePanel)c).setPayed(status);
		}
	}
	/**
	 * Create the panel.
	 */
	public CoursesPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}
