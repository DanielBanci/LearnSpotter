package main.ui.displayContent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import main.ui.content.MainPanel;
import main.ui.coursePosts.CoursePost;
import main.ui.layouts.WrapLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class DisplayCoursesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DisplayCoursesPanel() {
		//setMaximumSize(new Dimension(900,10000));
		setLayout(new WrapLayout(FlowLayout.CENTER,10,40));
		setMaximumSize(new Dimension(1300,900000));
		setOpaque(false);
		for(int i=0;i<20;i++) {
			add(new CoursePost(true));
		}
		DisplayCoursesPanel f = this;
		
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
