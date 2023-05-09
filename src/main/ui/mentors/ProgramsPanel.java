package main.ui.mentors;

import javax.swing.JPanel;

import main.ui.mentoringProgram.MentoringProgramPost;

import javax.swing.BoxLayout;

public class ProgramsPanel extends JPanel {

	public ProgramsPanel(Boolean TODO) {
		this();
		add(new MentoringProgramPost());
	}
	/**
	 * Create the panel.
	 */
	public ProgramsPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

}
