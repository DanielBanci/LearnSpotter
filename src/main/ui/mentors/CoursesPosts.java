package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Course;
import main.classes.Mentor;
import main.classes.User;
import main.ui.coursePosts.CoursePost;
import main.ui.customComponents.RoundButton;
import main.ui.newContent.NewCoursePost;
import main.ui.newContent.NewMentoringProgram;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CoursesPosts extends JPanel {

	private JPanel messagePanel;
	private JPanel buttonPanel;
	private JButton btnAddNewCourse;
	
	//for user
	public CoursesPosts(Mentor mentor,User user) {
		this();
		if(mentor.getCourses().size() == 0) {
			JLabel label = new JLabel("No courses to be displayed");
			label.setFont(new Font("Tharoma",Font.PLAIN,16));
			
			messagePanel = new JPanel();
			messagePanel.setOpaque(false);
			add(messagePanel,0);
			messagePanel.add(label);
		}else {
			for(int i=0;i<mentor.getCourses().size();i++) {
				add(new CoursePost(mentor.getCourses().get(i)));
			}
		}
	}
	
	//for mentor
	public CoursesPosts(Mentor mentor) {
		this();
		if(mentor.getCourses().size() == 0) {
			JLabel label = new JLabel("No courses to be displayed");
			label.setFont(new Font("Tharoma",Font.PLAIN,16));
			
			messagePanel = new JPanel();
			messagePanel.setOpaque(false);
			add(messagePanel,0);
			messagePanel.add(label);
			
			add(buttonPanel,1);
		}else {
			add(buttonPanel,0);
			for(int i=0;i<mentor.getCourses().size();i++) {
				add(new CoursePost(mentor.getCourses().get(i)));
			}
		}
	}

	/**
	 * Method that search for a panel index inside the container.
	 * @param target the panel in interest
	 * @return the index of the panel, -1 if not found
	 */
	public int findComponentIndex(Container container,Object target) {
		Component[] components = container.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i].equals(target)) {
				return i;
			}
		}
		return -1; // Component not found
	}
	/**
	 * Create the panel.
	 */
	public CoursesPosts() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		
		btnAddNewCourse = new RoundButton("Add");
		btnAddNewCourse.setPreferredSize(new Dimension(100, 30));
		btnAddNewCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddNewCourse.setBackground(Color.GRAY);
		buttonPanel.add(btnAddNewCourse);
		btnAddNewCourse.addActionListener(addAction());
	}

	private ActionListener addAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = findComponentIndex(CoursesPosts.this,btnAddNewCourse.getParent());
				add(new NewCoursePost(),index+1);
				revalidate();
			}
			
		};
	}
}
