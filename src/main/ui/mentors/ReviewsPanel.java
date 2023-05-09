package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Feedback;
import main.ui.coursePosts.FeedbackPanel;

import java.util.List;

import javax.swing.BoxLayout;

public class ReviewsPanel extends JPanel {

	public ReviewsPanel(List<Feedback> feedbacks) {
		this();
		//feedbacks.sort();												//TODO sort the feedback after posting date
		for(int i = 0;i < feedbacks.size();i++) {
			add(new FeedbackPanel());									//TODO construct the feedbacks with content  
		}

	}
	/**
	 * Create the panel.
	 */
	public ReviewsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

}
