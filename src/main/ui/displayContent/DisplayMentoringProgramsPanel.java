package main.ui.displayContent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.classes.MentoringProgram;
import main.classes.User;
import main.ui.content.MainPanel;
import main.ui.layouts.WrapLayout;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.ui.mentors.MentorPost;

public class DisplayMentoringProgramsPanel extends JPanel {

	public DisplayMentoringProgramsPanel(List<MentoringProgram> mentoringPrograms) {
		setLayout(new WrapLayout(FlowLayout.CENTER,10,40));
		setMaximumSize(new Dimension(1300,900000));
		if(mentoringPrograms.size() != 0) {
			for(int i = 0;i < mentoringPrograms.size();i++) {
			add(new MentoringProgramPost(mentoringPrograms.get(i),true,User.createMockup()));
		}
		}else {
			JLabel label = new JLabel("No courses to be displayed. Once you joined to a mentoring program it will be displyed here.");
			label.setFont(new Font("Tharoma",Font.PLAIN,16));
			
			add(label);
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
	/**
	 * Create the panel.
	 */
	public DisplayMentoringProgramsPanel() {
		setLayout(new WrapLayout(FlowLayout.CENTER,10,40));
		setMaximumSize(new Dimension(1300,900000));
		for(int i = 0;i < 25;i++) {
			add(new MentoringProgramPost(MentoringProgram.createMockup(),true,User.createMockup()));
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
