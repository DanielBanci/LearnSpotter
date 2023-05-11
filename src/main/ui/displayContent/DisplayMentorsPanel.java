package main.ui.displayContent;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.ui.content.MainPanel;
import main.ui.layouts.WrapLayout;
import main.ui.mentors.MentorPost;

public class DisplayMentorsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DisplayMentorsPanel() {
		setLayout(new WrapLayout(FlowLayout.CENTER,10,40));
		setMaximumSize(new Dimension(1200,900000));
		setOpaque(false);
		for(int i = 0;i < 25;i++) {
			add(new MentorPost(true));
		}
		
		DisplayMentorsPanel f = this;
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Dimension dim = MainPanel.getInstance().getViewport().getExtentSize();
				//f.setMaximumSize(new Dimension(1200,900000));
				//f.validate();
				//MainPanel.getInstance().getContent().validate();
				MainPanel.getInstance().getVerticalScrollBar().setValue(0);
				MainPanel.getInstance().getHorizontalScrollBar().setValue(0);
			}
			
		});
	}

}
