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
 * Let the user to see the scheduled dates before posting the contend and gives the chance to delete
 * them if needed
 * @author Daniel
 * @version 1.0
 */
public class NewScheduleDatePanel extends JPanel{
	JLabel lblCourseName;
	JButton deleteButton;
	ScheduleChooserPanel parent;

	public NewScheduleDatePanel(String name,ScheduleChooserPanel parent) {
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
		NewScheduleDatePanel target = this;
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//remove from map
				parent.scheduledData.remove(target);
				//remove from panel
				parent.schedulesPanel.remove(target);
				
				if(parent.scheduledData.size() == 0) {
					parent.lblSchedules.setVisible(false);
					parent.areDisplayedScheduledDates = false;
				}
				//update panel
				parent.revalidate();
				/*JPanel target = parent.coursesPanels.get(lblCourseName.getText());
				parent.uploadedCoursesPanel.remove(target);
				parent.uploadedFiles.remove(lblCourseName.getText());
				parent.uploadedCoursesPanel.revalidate();*/
			}

		});
	}

}
