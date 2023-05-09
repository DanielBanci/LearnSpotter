package main.ui.mentoringProgram;

import javax.swing.JPanel;

import main.ui.coursePosts.CourseFilePanel;
import main.ui.customComponents.RoundButton;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

public class ItemCoursePanel extends CourseFilePanel {
	private RoundButton btnDescription;
	/**
	 * Create the panel.
	 */
	public ItemCoursePanel() {
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(10, 0));
		horizontalStrut.setMinimumSize(new Dimension(5, 0));
		horizontalStrut.setMaximumSize(new Dimension(10, 10));
		courseFilePanel.add(horizontalStrut);
		
		btnDescription = new RoundButton("New button");
		btnDescription.setForeground(new Color(0, 0, 0));
		btnDescription.setFocusable(false);
		btnDescription.setBackground(new Color(128, 128, 128));
		btnDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDescription.setMaximumSize(new Dimension(200, 30));
		btnDescription.setPreferredSize(new Dimension(200, 30));
		btnDescription.setText("Description");
		courseFilePanel.add(btnDescription);

	}

}
