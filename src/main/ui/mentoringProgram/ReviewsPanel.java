package main.ui.mentoringProgram;

import javax.swing.JPanel;

import main.classes.MentoringProgram;
import main.ui.coursePosts.FeedbackPanel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class ReviewsPanel extends JPanel {

	public ReviewsPanel(MentoringProgram mentoringProgram) {
		this();
		if(mentoringProgram.getFeedbacks().size() != 0) {
			for(int i=0;i<mentoringProgram.getFeedbacks().size();i++) {
				add(new FeedbackPanel(mentoringProgram.getFeedbacks().get(i)));
			}
		}else {
			add(new JLabel("No reviews to display."));
		}
	}
	/**
	 * Create the panel.
	 */
	public ReviewsPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

}
