package ui.login;

import javax.swing.JPanel;

import ui.content.MainPanel;
import ui.customComponents.RoundButton;
import ui.customComponents.RoundPanel;
import ui.customComponents.RoundPasswordField;
import ui.customComponents.RoundTextField;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import app.App;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginData extends RoundPanel {
	
	private JTextField tFEmail;					//the Email input  
	private JPasswordField passwordField;		//the password input
	private JButton btnLogin;					//button to log in  

	/**
	 * Create the panel.
	 */
	public LoginData() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//panels
		JPanel emailPanel = new JPanel();
		emailPanel.setOpaque(false);
		emailPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
		add(emailPanel);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setOpaque(false);
		passwordPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		add(passwordPanel);
		
		JPanel loginButtonPanel = new JPanel();
		loginButtonPanel.setOpaque(false);
		loginButtonPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
		loginButtonPanel.setLayout(new BoxLayout(loginButtonPanel, BoxLayout.X_AXIS));
		add(loginButtonPanel);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setPreferredSize(new Dimension(80, 13));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailPanel.add(lblNewLabel);
		
		tFEmail = new RoundTextField();
		tFEmail.setMaximumSize(new Dimension(2147483647, 50));
		emailPanel.add(tFEmail);
		tFEmail.setColumns(10);
		
		
		JLabel lblNewLabel2 = new JLabel("Password:");
		lblNewLabel2.setPreferredSize(new Dimension(80, 13));
		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordPanel.add(lblNewLabel2);
		
		passwordField = new RoundPasswordField();
		passwordField.setMaximumSize(new Dimension(2147483647, 50));
		passwordPanel.add(passwordField);
		
		//login button
		
		btnLogin = new RoundButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(35, 78, 36));
		btnLogin.setMaximumSize(new Dimension(300, 30));
		loginButtonPanel.add(btnLogin);
		btnLogin.addActionListener(loginButtonActionListener());
		

	}
	
	/**
     * Makes the action from login button.
     * It will check user input, try to get user s account info and log in the user
     * @return action for login button
     */
	private ActionListener loginButtonActionListener(){
        ActionListener act = new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {                        //TO DO: check input and login the users
                //complete code here

                //Open the app for the user
            	App.getInstance().getFrame().getContentPane().removeAll();
            	App.getInstance().getFrame().setContentPane(new MainPanel());
            	
            	//update the frame
            	App.getInstance().getFrame().pack();
            	App.getInstance().getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        };

        return act;
    }

}
