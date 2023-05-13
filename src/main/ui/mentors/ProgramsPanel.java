package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Mentor;
import main.ui.mentoringProgram.MentoringProgramPost;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class ProgramsPanel extends JPanel {

	public ProgramsPanel(Mentor mentor) {
		this();
		if(mentor.getMentoringPrograms().size() == 0) {
			add(new JLabel("No programs to be displayed"));
		}else {
			for(int i=0;i<mentor.getMentoringPrograms().size();i++) {
				add(new MentoringProgramPost(mentor.getMentoringPrograms().get(i),true));
			}
		}
		
	}
	/**
	 * Create the panel.
	 */
	public ProgramsPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

}
