package main.ui.newContent;

import javax.swing.JPanel;
import java.util.prefs.Preferences;

import main.classes.Feedback;
import main.classes.Mentor;
import main.classes.MentoringProgram;
import main.db.DbConnection;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;
import main.ui.customUI.HintTextAreaUI;
import main.ui.customUI.HintTextFieldUI;

import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JButton;

public class NewMentoringProgram extends JPanel {
	private JTextField tFTitle;
	private JTextField tFField;
	private JTextField tFLessonDuration;
	private JTextField tFCoursePrice;
	private JButton btnPost;
	private JTextArea tADescription;
	private JComboBox<String> cBDifficulty;
	private JComboBox<String> comboBoxCurrency;
	private FileUploadPanel coursesPanel;
	private ScheduleChooserPanel scheduleChooserPanel;
	private JComboBox<String> comboBoxLocation;
	private Mentor mentor;

	public NewMentoringProgram(Mentor mentor) {
		this();
		this.mentor = mentor;
	}
	/**
	 * Create the panel.
	 */
	public NewMentoringProgram() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) getLayout();

		JPanel panel_10 = new RoundPanel();
		panel_10.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_10.setOpaque(false);
		add(panel_10);

		JPanel panel_8 = new JPanel();
		panel_10.add(panel_8);
		panel_8.setOpaque(false);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_8.add(panel_1);
		FlowLayout flowLayout_4 = (FlowLayout) panel_1.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_1.setOpaque(false);

		tFTitle = new JTextField();
		panel_1.add(tFTitle);
		tFTitle.setUI(new HintTextFieldUI("Program title", true, Color.GRAY));
		tFTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tFTitle.setOpaque(false);
		tFTitle.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_8.add(panel_2);
		panel_2.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);

		tFField = new JTextField();
		tFField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tFField.setUI(new HintTextFieldUI("Field(s)", true, Color.GRAY));
		tFField.setOpaque(false);
		tFField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(tFField);
		tFField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_8.add(panel_3);

		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_11.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_11.setOpaque(false);
		panel_8.add(panel_11);

		JLabel lblNewLabel_3 = new JLabel("Location: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_11.add(lblNewLabel_3);

		comboBoxLocation = new JComboBox<>();
		comboBoxLocation.setFocusable(false);
		comboBoxLocation.addItem("Online");
		comboBoxLocation.addItem("Hybrid");
		comboBoxLocation.addItem("Onsite");
		panel_11.add(comboBoxLocation);

		panel_3.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);

		JLabel lblNewLabel = new JLabel("Difficulty: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel);

		cBDifficulty = new JComboBox<>();
		cBDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBDifficulty.addItem("Beginner");
		cBDifficulty.addItem("Intermediate");
		cBDifficulty.addItem("Advanced");
		panel_3.add(cBDifficulty);

		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setOpaque(false);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));



		JPanel panel = new JPanel();
		panel_9.add(panel);
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel.add(panel_4);

		JLabel lblNewLabel_1 = new JLabel("Duration of a lesson: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1);

		tFLessonDuration = new JTextField();
		tFLessonDuration.setUI(new HintTextFieldUI("Minutes", true, Color.GRAY));
		tFLessonDuration.setOpaque(false);
		tFLessonDuration.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tFLessonDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(tFLessonDuration);
		tFLessonDuration.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel.add(panel_5);

		JLabel lblNewLabel_2 = new JLabel("Price: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblNewLabel_2);

		tFCoursePrice = new JTextField();
		tFCoursePrice.setUI(new HintTextFieldUI("Price/lesson", true, Color.GRAY));
		tFCoursePrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFCoursePrice.setOpaque(false);
		tFCoursePrice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_5.add(tFCoursePrice);
		tFCoursePrice.setColumns(10);

		comboBoxCurrency = new JComboBox<>();
		comboBoxCurrency.addItem("RON");
		comboBoxCurrency.addItem("EURO");
		comboBoxCurrency.addItem("USD");
		comboBoxCurrency.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(comboBoxCurrency);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 5, 0, 0));
		panel_6.setOpaque(false);
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		tADescription = new JTextArea();
		tADescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tADescription.setUI(new HintTextAreaUI("Description...", true, Color.GRAY));
		tADescription.setOpaque(false);
		tADescription.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_6.add(tADescription, BorderLayout.NORTH);

		coursesPanel = new FileUploadPanel();
		panel.add(coursesPanel);

		scheduleChooserPanel = new ScheduleChooserPanel();
		panel_8.add(scheduleChooserPanel);
		scheduleChooserPanel.setOpaque(false);



		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_8.add(panel_7);

		btnPost = new RoundButton("New button");
		btnPost.setPreferredSize(new Dimension(200, 30));
		btnPost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPost.setForeground(new Color(255, 255, 255));
		btnPost.setBackground(new Color(44, 122, 20));
		btnPost.setText("Post");
		panel_7.add(btnPost);
		btnPost.addActionListener(postAction());
	}

	private ActionListener postAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {					//TODO post new mentoring program

				//TODO check the input

				int id = 1;//getLastCourseId() + 1;
				int duration = 1;
				Double price = 0.0;

				Preferences prefs = Preferences.userNodeForPackage(main.ui.login.LoginData.class);
				int mentorId = Integer.parseInt(prefs.get("id", "-1"));

				String title = tFTitle.getText();//a title, not empty
				if(title.isEmpty()) {
					JOptionPane.showMessageDialog(null, "A non-blank title is required.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String field = tFField.getText();//one or more fields
				if(field.isEmpty()) {
					JOptionPane.showMessageDialog(null, "At least one field is required.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(tFLessonDuration.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Setting a duration is required.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					duration = Integer.valueOf(tFLessonDuration.getText());//integer
				} catch(NumberFormatException _) {
					JOptionPane.showMessageDialog(null, tFLessonDuration.getText() + " is not a integer.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(tFCoursePrice.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Setting a price is required.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					price = Double.valueOf(tFCoursePrice.getText());//integer?
				} catch(NumberFormatException _) {
					JOptionPane.showMessageDialog(null, tFCoursePrice.getText() + " is not a integer.", "Error", JOptionPane.ERROR_MESSAGE); //My class says double but if you say so, I'm ready to oblige
					return;
				}
				String description = tADescription.getText();//not empty
				if(description.isEmpty()) {
					JOptionPane.showMessageDialog(null, "A non-blank description is required.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String difficulty = cBDifficulty.getSelectedItem().toString();//no check necessary
				String currency = comboBoxCurrency.getSelectedItem().toString();//no check necessary
				String location = comboBoxLocation.getSelectedItem().toString();//no check necessary
				Map<String,byte[]> uploadedFiles = coursesPanel.uploadedFiles; //no check necessary
				List<ScheduleData> scheduledData = new ArrayList<>();

				System.out.println(mentorId);

				//get schedule details
				for(Object i : scheduleChooserPanel.scheduledData.keySet()) {
					//System.out.println(i);
					scheduledData.add(scheduleChooserPanel.scheduledData.get(i));
				}

				List<Feedback> feedbacks = new ArrayList<>();//empty when the account just created
				int rating = 0;
				int noViews = 0;

				Mentor programMentor = mentor;

				MentoringProgram mentoringProgram = new MentoringProgram(id,mentorId,title,difficulty,description,location,scheduledData,
						duration,price,currency,mentor,rating,noViews,field,feedbacks,uploadedFiles);

				//TODO upload data to database and display new mentoring program
				Connection conn = DbConnection.conn;

				int insertedMentoringProgramId = -1;

				String sql = "INSERT INTO mentoring_programs(id_mentor, name, difficulty_level, description, location, duration, price, currency, field) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					pstmt.setInt(1, mentorId);
					pstmt.setString(2, title);
					pstmt.setString(3, difficulty);
					pstmt.setString(4, description);
					pstmt.setString(5, location);
					pstmt.setInt(6, duration);
					pstmt.setDouble(7, price);
					pstmt.setString(8, currency);
					pstmt.setString(9, field);

					pstmt.executeUpdate();
					ResultSet rs = pstmt.getGeneratedKeys();

					if(rs.next())
						insertedMentoringProgramId = rs.getInt(1);

					System.out.println("Mentoring program added successfully with id " + insertedMentoringProgramId);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				//upload files to database

				Set<String> keys = uploadedFiles.keySet();
				for(String key : keys) {
					byte[] file = uploadedFiles.get(key);

					sql = "INSERT INTO courses (id_mentor, id_mentoring_program, name, description, price, currency) VALUES (?, ?, ?, ?, ?, ?)";

					
					int mentoringProgramId = insertedMentoringProgramId;	//does not belong to a mentoring program
					PreparedStatement statement;


					try {
						System.out.println("Aici 1");
						statement = conn.prepareStatement(sql);

						statement.setInt(1, mentorId);
						statement.setInt(2, mentoringProgramId);
						statement.setString(3, key);
						statement.setString(4, "");
						statement.setDouble(5, price);
						statement.setString(6, currency);
						

						int rowsInserted = statement.executeUpdate();

						System.out.println("Aici 2");
						if (rowsInserted > 0) {

							System.out.println("Aici 2.1");
							sql = "SELECT id FROM courses ORDER BY id DESC LIMIT 1";
							Statement lastIdStatement = conn.createStatement();
							ResultSet result = lastIdStatement.executeQuery(sql);

							int lastId = 1;
							if(result.next())
								lastId = result.getInt("id");
							
							System.out.println("Aici 3");

							sql = "INSERT INTO resources(id_course, id_mentoring_program, name, file) VALUES(?, ?, ?, ?)";
							PreparedStatement pstmt1 = conn.prepareStatement(sql);
							pstmt1.setInt(1, lastId); // set id value to 1
							pstmt1.setInt(2, insertedMentoringProgramId);
							pstmt1.setString(3, key);
							pstmt1.setBytes(4, file);
							pstmt1.executeUpdate();
							System.out.println("Aici 4");
						}
					}catch(Exception e2) {
						e2.printStackTrace();
						System.out.println("error during storing courses for mentoring program");
						return;
					}
				}


				for(ScheduleData sD : scheduledData) {
					String startDateTime = sD.startDate + " " + sD.startTime;
					boolean repeat = sD.repeat;

					String repeatRate = "", repeatUntil = "";
					if(repeat) {
						repeatRate = sD.atEvery;
						repeatUntil = sD.untilDate.toString();
					}

					sql = "INSERT INTO schedule(id_mentoring_program, start_datetime, repeat_bool, repeat_rate, repeat_until) VALUES(?, ?, ?, ?, ?)";

					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, insertedMentoringProgramId);
						pstmt.setString(2, startDateTime);
						pstmt.setBoolean(3, repeat);
						pstmt.setString(4, repeatRate);
						pstmt.setString(5, repeatUntil);

						pstmt.executeUpdate();

						System.out.println("One schedule added in database");
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}

		};
	}
}
