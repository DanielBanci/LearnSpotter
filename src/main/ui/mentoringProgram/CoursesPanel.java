package main.ui.mentoringProgram;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class CoursesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CoursesPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new ItemCoursePanel());
	}

}
