package main.ui.newContent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.utility.ImageLoader;

/**
 * Let the user to see the uploaded courses before posting the contend and gives the chance to delete
 * them if needed
 * @author Daniel
 * @version 1.0
 */
public class NewCoursePanel extends JPanel{
	JLabel lblCourseName;
	JButton deleteButton;
	FileUploadPanel parent;
	
	public NewCoursePanel(String name,FileUploadPanel parent) {
		super();
		setOpaque(false);
		this.parent = parent;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		lblCourseName = new JLabel();
		lblCourseName.setText(name);
		deleteButton = new JButton();
		deleteButton.setFocusable(false);
		deleteButton.setIcon(new ImageIcon(ImageLoader.getInstance().getDeleteIconRed()));
		deleteButton.setPreferredSize(new Dimension(20,20));
		deleteButton.setOpaque(false);
		deleteButton.setBorder(new EmptyBorder(0,0,0,0));
		add(lblCourseName);
		add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel target = parent.coursesPanels.get(lblCourseName.getText());
				parent.uploadedCoursesPanel.remove(target);
				parent.uploadedFiles.remove(lblCourseName.getText());
				parent.uploadedCoursesPanel.revalidate();
			}
			
		});
	}
	
}
