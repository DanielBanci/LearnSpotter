package main.ui.login;

import javax.swing.JPanel;
import java.util.prefs.Preferences;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import main.app.App;
import main.classes.Mentor;
import main.classes.User;
import main.ui.content.MainPanel;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.RoundPasswordField;
import main.ui.customComponents.RoundTextField;
import main.ui.newContent.NewUserProfile;
import main.utility.StaticUtilities;
import main.db.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Component;

public class LoginData extends RoundPanel {
	
	private JTextField tFEmail;					//the Email input  
	private JPasswordField passwordField;		//the password input
	private JButton btnLogin;					//button to log in  
	private JCheckBox checkBox;		//check box to show/hide password
	private JLabel lblNewAccount;
	
	public static String emailIfLoginSucceded;

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
		passwordPanel.setBorder(new EmptyBorder(25, 25, 0, 25));
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		add(passwordPanel);
		
		JPanel checkButtonPanel = new JPanel();
		checkButtonPanel.setOpaque(false);
		add(checkButtonPanel);
		checkButtonPanel.setLayout(new BoxLayout(checkButtonPanel, BoxLayout.X_AXIS));
		
		checkBox = new JCheckBox("Show password");
		checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		checkBox.setOpaque(false);
		checkBox.addActionListener(checkBoxActionListener());
		checkButtonPanel.add(checkBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setMinimumSize(new Dimension(40, 13));
		lblNewLabel_1.setMaximumSize(new Dimension(40, 13));
		lblNewLabel_1.setPreferredSize(new Dimension(40, 13));
		checkButtonPanel.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel.setMaximumSize(new Dimension(32767, 30));
		add(panel);
		
		lblNewAccount = new JLabel("Don't have an account yet? Register now!      ");
		lblNewAccount.setForeground(new Color(240, 150, 0));
		lblNewAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewAccount);
		lblNewAccount.addMouseListener(newAccounMouseAdapter());
		
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
		

		tFEmail.setText("johndoe@example.com");
		passwordField.setText("PassWord1@3");
		//tFEmail.setText("janesmith@example.com");
		//passwordField.setText("passWord!2");
	}
	
	private MouseAdapter newAccounMouseAdapter() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				App.getInstance().getFrame().getContentPane().removeAll();
				App.getInstance().getFrame().getContentPane().add(new NewAccountPanel());
				App.getInstance().getFrame().getContentPane().revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c = lblNewAccount.getBackground();
				lblNewAccount.setBackground(lblNewAccount.getForeground());
				lblNewAccount.setForeground(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c = lblNewAccount.getBackground();
				lblNewAccount.setBackground(lblNewAccount.getForeground());
				lblNewAccount.setForeground(c);
			}
		};
	}
	
	/**
     * Makes the action from login button.
     * It will check user input, try to get user s account info and log in the user
     * @return action for login button
     */
	private ActionListener loginButtonActionListener(){
        ActionListener act = new ActionListener() {
            //@Override
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {                        //TO DO: check input and login the users
            	String inputEmail = tFEmail.getText();
            	
                if(inputEmail.isEmpty()) {
                	JOptionPane.showMessageDialog(null, "An email is required to log in.", "Login Error", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                if(!NewUserProfile.isValidEmail(inputEmail)) {
                	JOptionPane.showMessageDialog(null, "Invalid email format.", "Login Error", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                
                if(passwordField.getPassword().toString().isEmpty()) {
                	JOptionPane.showMessageDialog(null, "A password is required to log in.", "Login Error", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                
            	try {
					Connection conn = DbConnection.conn;
					
					String query = "SELECT * FROM users WHERE email=? AND password=?";
					
					PreparedStatement statement = conn.prepareStatement(query);
					
					statement.setString(1, tFEmail.getText());
		            statement.setString(2, passwordField.getText());
		            
					ResultSet resultSet = statement.executeQuery();
					
					Preferences prefs = Preferences.userNodeForPackage(LoginData.class);
		            
		            if (resultSet.next()) {
		                System.out.println("Login success");
		                
		                prefs.put("id", String.valueOf(resultSet.getInt("id")));
		                emailIfLoginSucceded = tFEmail.getText();
		                if(resultSet.getString("type").equals("mentor")) {				//mentor
		                	int id = resultSet.getInt("id");
		                	String firstName = resultSet.getString("first_name");
		                	String lastName = resultSet.getString("last_name");
		                	String email = resultSet.getString("email");
		                	String password = resultSet.getString("password");
		                	String phoneNumber = resultSet.getString("phone_number");
		                	String description = resultSet.getString("description");
		                	String field = resultSet.getString("field");
		                	int programNumbers = resultSet.getInt("programs_number");
		                	String cardNumber = resultSet.getString("card_number");
		                	int cvv = resultSet.getInt("cvv");
		                	String cardHolderName = resultSet.getString("card_holder_name");
		                	String expirationMonth = resultSet.getString("expiration_month");
		                	String expirationYear = resultSet.getString("expiration_year");
		                	int idRating = resultSet.getInt("id_rating");
		                	byte[] profilePic = resultSet.getBytes("profile_pic");
		                	String location = resultSet.getString("location");
		                	
		                	//TODO: implement method in DBManager for getting a mentor with all related data:
		                	//user data,mentoring programs,courses,feedback and so on...
		                	
		                	/*MainPanel.loggedUser = new Mentor(id,firstName,lastName,email,password,phoneNumber,profilePic,location,description,field,
		                			programsNumber,registerDate,feedbacks,courses,mentoringPrograms,card);*/
		                	
		                	//to be continued
		                	//Open the app for the mentor
			            	App.getInstance().getFrame().getContentPane().removeAll();
			            	App.getInstance().getFrame().setContentPane(MainPanel.updateInstance(Mentor.createMockup()));
		                	
		                }else {															//user
		                	int id = resultSet.getInt("id");
		                	String firsName = resultSet.getString("first_name");
		                	String lastname = resultSet.getString("last_name");
		                	String email = resultSet.getString("email");
		                	String password = resultSet.getString("password");
		                	String phoneNumber = resultSet.getString("phone_number");
		                	//String description = resultSet.getString("description");
		                	//String field = resultSet.getString("Field");
		                	//int programNumbers = resultSet.getInt("program_number");
		                	//String cardNumber = resultSet.getString("card_number");
		                	//int cvv = resultSet.getInt("cvv");
		                	//String cardHolderName = resultSet.getString("card_holder_name");
		                	//String expirationMonth = resultSet.getString("expiration_month");
		                	//String expirationYear = resultSet.getString("expiration_year");
		                	//int idRating = resultSet.getInt("id-rating");
		                	byte[] profilePic = resultSet.getBytes("profile_pic");
		                	//String location = resultSet.getString("location");
		                	//Open the app for the user
			            	App.getInstance().getFrame().getContentPane().removeAll();
			            	App.getInstance().getFrame().setContentPane(MainPanel.updateInstance(User.createMockup()));
		                }
		                
		            	
		            	//update the frame
		            	App.getInstance().getFrame().invalidate();
		            	App.getInstance().getFrame().revalidate();
		            } else {
		            	JOptionPane.showMessageDialog(null,"Wrong email or password!\nLogin failed.","Eroare",JOptionPane.ERROR_MESSAGE);
		                System.out.println("Login failed");
		            }
		            
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        };

        return act;
    }
	
	private ActionListener checkBoxActionListener() {
		ActionListener act = new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {                        
            	if (checkBox.isSelected()) {
                    passwordField.setEchoChar((char) 0); // Show password
                } else {
                    passwordField.setEchoChar(StaticUtilities.bullet); // Hide password
                }
            }
        };

        return act;
	}

}
