package main.ui.newContent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import main.classes.Card;
import main.classes.Course;
import main.classes.Feedback;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.ui.content.PaymentPanel;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundImagePanel;
import main.ui.customComponents.RoundPanel;
import main.ui.customUI.HintTextAreaUI;
import main.ui.customUI.HintTextFieldUI;
import main.utility.ImageLoader;
import javax.swing.JLabel;

public class NewMentorProfile extends JPanel {

	private JPanel profilePicPanel;
	private JButton btnUploadImage;
	private Image profilePic;
	private JTextField tFFirstName;
	private JTextField tFLastName;
	private JTextField tFEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JCheckBox checkBShowPassword;
	private PaymentPanel cardDetailsPanel;
	private JButton btnAddCard;
	private Card card;
	private JButton btnRegister;
	private JTextArea tAStudyFields;
	private JTextField tFLocation;
	private JTextField tFPhoneNumber;
	
	public NewMentorProfile(Boolean TODO) {
		this();
		profilePicPanel.add(new RoundImagePanel(ImageLoader.getInstance().getUserIcon(),new Dimension(220,200)));
	}
	/**
	 * Create the panel.
	 */
	public NewMentorProfile() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new RoundPanel();
		panel.setMinimumSize(new Dimension(600, 200));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		profilePicPanel = new JPanel();
		profilePicPanel.setMaximumSize(new Dimension(220, 200));
		profilePicPanel.setOpaque(false);
		profilePicPanel.setPreferredSize(new Dimension(220, 200));
		panel_3.add(profilePicPanel);
		profilePicPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_3.add(panel_5);
		
		btnUploadImage = new RoundButton("Upload image");
		btnUploadImage.setBackground(new Color(128, 128, 128));
		btnUploadImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUploadImage.setPreferredSize(new Dimension(120, 30));
		panel_5.add(btnUploadImage);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_3.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel_4.setMinimumSize(new Dimension(300, 200));
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(12, 10));
		panel_11.setOpaque(false);
		panel_4.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(300, 20));
		panel_6.setMaximumSize(new Dimension(32767, 30));
		panel_6.setOpaque(false);
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		tFFirstName = new JTextField();
		tFFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFFirstName.setUI(new HintTextFieldUI("Your first name...", true, Color.GRAY));
		tFFirstName.setOpaque(false);
		tFFirstName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_6.add(tFFirstName);
		tFFirstName.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setPreferredSize(new Dimension(12, 10));
		panel_12.setOpaque(false);
		panel_4.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setMaximumSize(new Dimension(32767, 30));
		panel_4.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		tFLastName = new JTextField();
		tFLastName.setUI(new HintTextFieldUI("Your last name...", true, Color.GRAY));
		tFLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFLastName.setOpaque(false);
		tFLastName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_7.add(tFLastName);
		tFLastName.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setPreferredSize(new Dimension(12, 10));
		panel_13.setOpaque(false);
		panel_4.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setMaximumSize(new Dimension(500, 500));
		panel_8.setOpaque(false);
		panel_4.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		tAStudyFields = new JTextArea();
		tAStudyFields.setLineWrap(true);
		tAStudyFields.setWrapStyleWord(true);
		tAStudyFields.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tAStudyFields.setUI(new HintTextAreaUI("Your study field(s)...", true, Color.GRAY));
		tAStudyFields.setMaximumSize(new Dimension(2147483647, 500));
		tAStudyFields.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tAStudyFields.setOpaque(false);
		panel_8.add(tAStudyFields);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(12, 10));
		panel_9.setOpaque(false);
		panel_4.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_22.setOpaque(false);
		panel_4.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));
		JPanel panel_221 = new JPanel();
		panel_221.setPreferredSize(new Dimension(12, 10));
		panel_221.setOpaque(false);
		panel_4.add(panel_221);
		panel_221.setLayout(new BorderLayout(0, 0));
		JPanel panel_222 = new JPanel();
		panel_222.setOpaque(false);
		panel_4.add(panel_222);
		panel_222.setLayout(new BorderLayout(0, 0));
		
		tFPhoneNumber = new JTextField();
		tFPhoneNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tFPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFPhoneNumber.setUI(new HintTextFieldUI("Your phone number...", true, Color.GRAY));
		tFPhoneNumber.setOpaque(false);
		panel_222.add(tFPhoneNumber, BorderLayout.NORTH);
		tFPhoneNumber.setColumns(10);
		
		tFLocation = new JTextField();
		tFLocation.setUI(new HintTextFieldUI("Your location...", true, Color.GRAY));
		tFLocation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tFLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFLocation.setOpaque(false);
		panel_22.add(tFLocation, BorderLayout.NORTH);
		tFLocation.setColumns(10);
		JPanel panel_23 = new JPanel();
		panel_23.setOpaque(false);
		panel_23.setPreferredSize(new Dimension(12, 10));
		panel_4.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setMaximumSize(new Dimension(32767, 30));
		panel_14.setOpaque(false);
		panel_4.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		tFEmail = new JTextField();
		tFEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tFEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFEmail.setUI(new HintTextFieldUI("Your e-mail...", true, Color.GRAY));
		tFEmail.setOpaque(false);
		panel_14.add(tFEmail, BorderLayout.CENTER);
		tFEmail.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		panel_15.setPreferredSize(new Dimension(12, 10));
		panel_15.setOpaque(false);
		panel_4.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setMaximumSize(new Dimension(32767, 30));
		panel_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_16.setOpaque(false);
		panel_4.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setUI(new main.ui.customUI.HintPasswordFieldUI("Your password",false,Color.GRAY));
		passwordField.setOpaque(false);
		panel_16.add(passwordField, BorderLayout.CENTER);
		
		JPanel panel_17 = new JPanel();
		panel_17.setPreferredSize(new Dimension(12, 10));
		panel_17.setOpaque(false);
		panel_4.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_18.setOpaque(false);
		panel_4.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setUI(new main.ui.customUI.HintPasswordFieldUI("Verify your password",false,Color.GRAY));
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField_1.setOpaque(false);
		panel_18.add(passwordField_1, BorderLayout.CENTER);
		
		JPanel panel_19 = new JPanel();
		panel_19.setOpaque(false);
		panel_4.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		checkBShowPassword = new JCheckBox("Show password");
		checkBShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBShowPassword.setOpaque(false);
		panel_19.add(checkBShowPassword, BorderLayout.WEST);
		
		JPanel panel_20 = new JPanel();
		panel_20.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_20.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_20);
		
		JLabel lblNewLabel = new JLabel("Card details ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_20.add(lblNewLabel);
		
		cardDetailsPanel = new PaymentPanel(card);
		panel_1.add(cardDetailsPanel);
		
		JPanel panel_21 = new JPanel();
		panel_21.setOpaque(false);
		panel_1.add(panel_21);
		
		btnRegister = new RoundButton("Register");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(44, 122, 20));
		btnRegister.setPreferredSize(new Dimension(150, 30));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_21.add(btnRegister);
		
		
		btnUploadImage.addActionListener(uploadPicAction());
		checkBShowPassword.addActionListener(checkBShowPasswordAction());
		btnRegister.addActionListener(registerActionListener());
	}
	
	private ActionListener registerActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = 1;//getLastUserId() + 1;
				String firstName = tFFirstName.getText();
				String lastName = tFLastName.getText();
				String field = tAStudyFields.getText();
				String location = tFLocation.getText();
				String phoneNumber = tFPhoneNumber.getText();								//verify to be write corectly
				String email = tFEmail.getText();											//verify email to be write correctly
				String password = passwordField.getPassword().toString();					//verify if passwords match and make a chanck to be strong
				String passwordVerify = passwordField_1.getPassword().toString();
				
				String description = ""; 										//no description when account just created
				int programsNumber = 0;											//no programsNumber when account just created
				Date registerDate = new Date();
				
				List<Course> courses = new ArrayList<>();						//no buyed courses when account just created
				List<MentoringProgram> mentoringPrograms = new ArrayList<>();	//no mentoring program joined when account just created
				List<Feedback> feedback = new ArrayList<>();					//no feedback when account just created
				
				//check if the user added succesfylly a card
				if(cardDetailsPanel.getCard() != null) {
					card = cardDetailsPanel.getCard();
				}else {
					JOptionPane.showMessageDialog(null,"You need to add a card first","Eroare",JOptionPane.ERROR_MESSAGE);
				}
				
				//if test passed
				Mentor mentor = new Mentor(id,firstName,lastName,email,password,phoneNumber,description,field,programsNumber,registerDate,
						feedback,courses,mentoringPrograms,card);
				//TODO store new mentor
			}
			
		};
	}
	
	private ActionListener checkBShowPasswordAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBShowPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0); // Show password
                    passwordField_1.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('•'); // Hide password
                    passwordField_1.setEchoChar('•');
                }
			}
			
		};
	}
	
	private ActionListener uploadPicAction() {
		return new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JFileChooser fileChooser = new JFileChooser();
	            int option = fileChooser.showOpenDialog(NewMentorProfile.this);
	            if (option == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                if (isImageFile(selectedFile)) {
	                    try {
	                    	BufferedImage image = ImageIO.read(selectedFile);
	                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                        ImageIO.write(image, "jpg", baos);
	                        byte[] imageData = baos.toByteArray();
	                        // Create Image from byte array
	                        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
	                        profilePic = ImageIO.read(bais);
	                        // Use the newImage as needed
	                        profilePicPanel.removeAll();
	                        profilePicPanel.add(new RoundImagePanel(profilePic,new Dimension(220,200)));
	                        NewMentorProfile.this.validate();
	                        
	                    } catch (IOException ex) {
	                        ex.printStackTrace();
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid file format. Please select an image file.",
	                            "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }

	        private boolean isImageFile(File file) {
	            String extension = getFileExtension(file);
	            return extension != null && (extension.equalsIgnoreCase("jpg")
	                    || extension.equalsIgnoreCase("jpeg")
	                    || extension.equalsIgnoreCase("png"));
	        }

	        private String getFileExtension(File file) {
	            String name = file.getName();
	            int lastDotIndex = name.lastIndexOf('.');
	            if (lastDotIndex > 0 && lastDotIndex < name.length() - 1) {
	                return name.substring(lastDotIndex + 1).toLowerCase();
	            }
	            return null;
	        }
	    };
	}

}
