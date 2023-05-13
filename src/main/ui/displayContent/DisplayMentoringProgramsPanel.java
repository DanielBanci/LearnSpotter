package main.ui.displayContent;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.classes.MentoringProgram;
import main.ui.content.MainPanel;
import main.ui.layouts.WrapLayout;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.ui.mentors.MentorPost;

public class DisplayMentoringProgramsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DisplayMentoringProgramsPanel() {
		setLayout(new WrapLayout(FlowLayout.CENTER,10,40));
		setMaximumSize(new Dimension(1300,900000));
		for(int i = 0;i < 25;i++) {
			add(new MentoringProgramPost(MentoringProgram.createMockup(),true));
		}
		
		DisplayMentoringProgramsPanel f = this;
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Dimension dim = MainPanel.getInstance().getViewport().getExtentSize();
				f.setMaximumSize(new Dimension(1300,900000));
				MainPanel.getInstance().getVerticalScrollBar().setValue(0);
				MainPanel.getInstance().getHorizontalScrollBar().setValue(0);
			}
			
		});
	}

}
