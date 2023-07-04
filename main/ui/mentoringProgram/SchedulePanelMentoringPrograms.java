package main.ui.mentoringProgram;

import main.classes.MentoringProgram;
import main.ui.calendar.*;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class SchedulePanelMentoringPrograms extends JPanel {
	private SchedulePanel calendarPanel;
	
	public SchedulePanelMentoringPrograms(MentoringProgram mentoringProgram) {
		this();
		//mentoringProgram.getSchedule()
	}
	/**
	 * Create the panel.
	 */
	public SchedulePanelMentoringPrograms() {
		setOpaque(false);
		setBackground(new Color(255, 255, 128));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		calendarPanel = new SchedulePanel();
		panel.add(calendarPanel);

	}

}
