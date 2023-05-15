package main.ui.mentors;

import javax.swing.JPanel;

import main.classes.Mentor;
import main.classes.User;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.TextAreaWithPreview;

import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutPanel extends JPanel {
	private TextAreaWithPreview tAAbout;
	private JTextArea tAEditAbout;
	private JButton btnEdit;
	private Mentor mentor;
	private Container tAParent;
	private JButton btnSave;
	
	//for user
	public AboutPanel(Mentor mentor,User user) {
		this();
		this.mentor = mentor;
		
		if(!mentor.getDescription().isEmpty()) {
			tAAbout.setTextBody(mentor.getDescription());
		}else {
			tAAbout.setTextBody("No description to be displayed.");
		}
		
		
	}
	
	//for mentor
	public AboutPanel(Mentor mentor) {
		this();
		this.mentor = mentor;
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_1,0);
		
		btnEdit = new RoundButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBackground(Color.GRAY);
		btnEdit.setPreferredSize(new Dimension(100, 30));
		btnEdit.setText("Edit");
		panel_1.add(btnEdit);
		if(!mentor.getDescription().isEmpty()) {
			tAAbout.setTextBody(mentor.getDescription());
		}else {
			tAAbout.setTextBody("No description to be displayed.");
		}
		
		btnEdit.addActionListener(editAction());
		
	}
	
	private ActionListener editAction() {
		return new ActionListener() {
			private int count = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentDescription = mentor.getDescription();
				tAParent = tAAbout.getParent();
				tAParent.remove(tAAbout);
				if(count == 0) {
					tAEditAbout = new JTextArea();
					tAEditAbout.setBorder(new EmptyBorder(0,0,0,0));
					tAEditAbout.setFont(new Font("Tahoma", Font.PLAIN, 16));
					tAEditAbout.setWrapStyleWord(true);
					tAEditAbout.setLineWrap(true);
				}
				tAEditAbout.setText(currentDescription);
				tAParent.add(tAEditAbout);
				
				//add save button
				if(count == 0) {
				btnSave = new RoundButton("Save");
				btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnSave.setBackground(Color.GRAY);
				btnSave.setPreferredSize(new Dimension(100, 30));
				btnSave.setText("Save");
				btnSave.addActionListener(saveAction());
				count++;
				}
				
				AboutPanel.this.btnEdit.getParent().add(btnSave);
				AboutPanel.this.revalidate();
			}
			
		};
	}
	
	private ActionListener saveAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String newDescription = tAEditAbout.getText();
				tAParent = tAEditAbout.getParent();
				tAParent.remove(tAEditAbout);
				
				tAParent.add(tAAbout);
				tAAbout.setTextBody(newDescription);
				
				//save new description
				mentor.setDescription(newDescription); 								//TODO: update database
				//remove save button
				btnSave.getParent().remove(btnSave);
				AboutPanel.this.revalidate();
			}
			
		};
	}
	/**
	 * Create the panel.
	 */
	public AboutPanel() {
		setOpaque(false);
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
		JPanel panel = new RoundPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tAAbout = new TextAreaWithPreview();
		tAAbout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tAAbout.setOpaque(false);
		panel.add(tAAbout);
		tAAbout.setBorder(new EmptyBorder(0, 0, 0, 10));

	}

}
