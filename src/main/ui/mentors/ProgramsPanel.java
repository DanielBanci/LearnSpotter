package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Mentor;
import main.classes.User;
import main.ui.customComponents.RoundButton;
import main.ui.mentoringProgram.MentoringProgramPost;
import main.ui.newContent.NewMentoringProgram;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public class ProgramsPanel extends JPanel {
	private JPanel messagePanel;
	private JPanel buttonPanel;
	private JButton btnAddNewMProgram;
	
	//for user
	public ProgramsPanel(Mentor mentor,User user) {
		this();
		if(mentor.getMentoringPrograms().size() == 0) {
			JLabel label = new JLabel("No programs to be displayed");
			label.setFont(new Font("Tharoma",Font.PLAIN,16));
			
			messagePanel = new JPanel();
			messagePanel.setOpaque(false);
			add(messagePanel,0);
			messagePanel.add(label);
		}else {
			for(int i=0;i<mentor.getMentoringPrograms().size();i++) {
				add(new MentoringProgramPost(mentor.getMentoringPrograms().get(i),true,User.createMockup(),false));
				
			}
		}
		
	}
	
	//for mentor
	public ProgramsPanel(Mentor mentor) {
		this();
		if(mentor.getMentoringPrograms().size() == 0) {
			JLabel label = new JLabel("No programs to be displayed");
			label.setFont(new Font("Tharoma",Font.PLAIN,16));
			
			messagePanel = new JPanel();
			messagePanel.setOpaque(false);
			add(messagePanel,0);
			messagePanel.add(label);
			
			add(buttonPanel,1);
		}else {
			add(buttonPanel,0);
			for(int i=0;i<mentor.getMentoringPrograms().size();i++) {
				add(new MentoringProgramPost(mentor.getMentoringPrograms().get(i),true,User.createMockup(),false));
				
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
	public ProgramsPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		
		btnAddNewMProgram = new RoundButton("Add");
		btnAddNewMProgram.setPreferredSize(new Dimension(100, 30));
		btnAddNewMProgram.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddNewMProgram.setBackground(Color.GRAY);
		buttonPanel.add(btnAddNewMProgram);
		btnAddNewMProgram.addActionListener(addAction());
	}
	
	private ActionListener addAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = findComponentIndex(ProgramsPanel.this,btnAddNewMProgram.getParent());
				add(new NewMentoringProgram(),index+1);
				revalidate();
			}
			
		};
	}
}
