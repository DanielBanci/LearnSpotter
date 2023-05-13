package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Feedback;
import main.classes.Mentor;
import main.ui.coursePosts.FeedbackPanel;

import java.util.List;

import javax.swing.BoxLayout;

public class ReviewsPanel extends JPanel {

	public ReviewsPanel(Mentor mentor) {
		this();
		//feedbacks.sort();												//TODO sort the feedback after posting date
		for(int i = 0;i < mentor.getFeedbacks().size();i++) {
			
			add(new FeedbackPanel(mentor.getFeedbacks().get(i)));									//TODO construct the feedbacks with content  
		}

	}
	
	/**
	 * Create the panel.
	 */
	public ReviewsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

}
