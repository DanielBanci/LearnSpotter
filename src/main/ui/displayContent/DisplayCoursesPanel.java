package main.ui.displayContent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import main.classes.Course;
import main.classes.User;
import main.ui.content.MainPanel;
import main.ui.coursePosts.CoursePost;
import main.ui.layouts.WrapLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

public class DisplayCoursesPanel extends JPanel {

	public DisplayCoursesPanel(List<Course> courses,User user) {
		this();
		if(courses.size() != 0) {
			for(int i=0;i<courses.size();i++) {
				add(new CoursePost(courses.get(i),true,user));
			}
		}else {
			JLabel label = new JLabel("No courses to be displayed. Once you bought a course it will be displyed here.");
			label.setFont(new Font("Tharoma",Font.PLAIN,16));
			
			add(label);
		}
		DisplayCoursesPanel f = this;

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Dimension dim = MainPanel.getInstance().getViewport().getExtentSize();
				f.setMaximumSize(new Dimension(1300,900000));
				DisplayCoursesPanel.this.revalidate();
				MainPanel.getInstance().getVerticalScrollBar().setValue(0);
				MainPanel.getInstance().getHorizontalScrollBar().setValue(0);
			}

		});
	}
	public DisplayCoursesPanel(Boolean TODO) {
		this();

		for(int i=0;i<20;i++) {
			add(new CoursePost(Course.createMockup(),User.createMockup()));
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
	/**
	 * Create the panel.
	 */
	public DisplayCoursesPanel() {
		setLayout(new WrapLayout(FlowLayout.CENTER,10,40));
		setMaximumSize(new Dimension(1300,900000));
		setOpaque(false);

	}

}
