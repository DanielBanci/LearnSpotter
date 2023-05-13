package main.ui.login;

import javax.swing.JPanel;

import main.ui.newContent.NewMentorProfile;
import main.ui.newContent.NewUserProfile;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JLabel;

public class NewAccountPanel extends JPanel {
	private JLabel lblInfo;
	private JPanel newAccountPanel;
	private JButton btnUserAccount;
	private JButton btnMentorAccount;
	private String message;
	/**
	 * Create the panel.
	 */
	public NewAccountPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 30));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(100);
		add(panel);
		
		btnUserAccount = new JButton("User account");
		btnUserAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnUserAccount);
		
		btnMentorAccount = new JButton("Mentor account");
		btnMentorAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnMentorAccount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 30));
		add(panel_1);
		message = "You can search and buy courses and mentors and you can join mentoring prgrams";
		lblInfo = new JLabel(message);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblInfo);
		
		newAccountPanel = new JPanel();
		add(newAccountPanel);
		newAccountPanel.add(new NewUserProfile(true));

		btnUserAccount.addActionListener(userAccountAction());
		btnMentorAccount.addActionListener(mentorAccountAction());
		
	}
	private ActionListener userAccountAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message = "You can search and buy courses and mentors and you can join mentoring prgrams";
				lblInfo.setText(message);
				newAccountPanel.removeAll();
				newAccountPanel.add(new NewUserProfile(true));
				newAccountPanel.repaint();
				NewAccountPanel.this.revalidate();
				
			}
			
		};
	}
	
	private ActionListener mentorAccountAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message = "Additional to user account you can post courses and you can add mentoring programs";
				lblInfo.setText(message);
				newAccountPanel.removeAll();
				newAccountPanel.add(new NewMentorProfile(true));
				newAccountPanel.repaint();
				NewAccountPanel.this.revalidate();
			}
			
		};
	}
}
