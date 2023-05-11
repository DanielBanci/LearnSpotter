package main.ui.newContent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.app.App;
import main.ui.content.MainPanel;
import main.ui.customComponents.ImagePanel;
import main.utility.ImageLoader;

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
