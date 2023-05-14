package main.ui.newContent;

import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;

import main.ui.customComponents.RoundButton;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;

public class ScheduleChooserPanel extends JPanel {
	private JButton btnAdd;
	public JLabel lblSchedules;
	public JPanel schedulesPanel;
	private DateTimePicker dateTimeChooser;
	private JCheckBox checkBRepet;
	private DatePicker untilDateChooser;
	private JComboBox<String> comboBRepetAt;
	public Boolean areDisplayedScheduledDates = false;
	private JPanel panel_3;
	private JLabel lblUntil;
	public Map<NewScheduleDatePanel,ScheduleData> scheduledData;
	private JPanel panel_4;
	
	
	/**
	 * Create the panel.
	 */
	public ScheduleChooserPanel() {
		scheduledData = new HashMap<>();
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(32767, 30));
		panel.setPreferredSize(new Dimension(700, 30));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Schedule ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setPreferredSize(new Dimension(200, 40));
		panel_1.setMaximumSize(new Dimension(32767, 40));
		add(panel_1);
		
		dateTimeChooser = new DateTimePicker();
		dateTimeChooser.getTimePicker().getComponentTimeTextField().setFocusable(false);
		dateTimeChooser.getDatePicker().getComponentDateTextField().setFocusable(false);
		dateTimeChooser.setOpaque(false);
		panel_1.add(dateTimeChooser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setPreferredSize(new Dimension(200, 40));
		panel_2.setMaximumSize(new Dimension(32767, 40));
		add(panel_2);
		
		checkBRepet = new JCheckBox("Repet ");
		checkBRepet.setFocusable(false);
		checkBRepet.setOpaque(false);
		checkBRepet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(checkBRepet);
		
		comboBRepetAt = new JComboBox<>();
		comboBRepetAt.setFocusable(false);
		comboBRepetAt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBRepetAt.addItem("at 1 week");
		for(int i = 2;i < 61;i++) {
			comboBRepetAt.addItem("at " + i + " weeks");
		}
		panel_2.add(comboBRepetAt);
		
		lblUntil = new JLabel("until ");
		lblUntil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblUntil);
		
		untilDateChooser = new DatePicker();
		untilDateChooser.getComponentDateTextField().setFocusable(false);
		untilDateChooser.setOpaque(false);
		panel_2.add(untilDateChooser);
		
		btnAdd = new RoundButton("New button");
		btnAdd.setFocusable(false);
		btnAdd.setBackground(new Color(128, 128, 128));
		btnAdd.setText("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnAdd);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setOpaque(false);
		add(panel_3);
		
		schedulesPanel = new JPanel();
		panel_3.add(schedulesPanel);
		schedulesPanel.setOpaque(false);
		schedulesPanel.setLayout(new BoxLayout(schedulesPanel, BoxLayout.Y_AXIS));
		
		panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_4.setOpaque(false);
		schedulesPanel.add(panel_4);
		
		lblSchedules = new JLabel("Scheduled dates: ");
		panel_4.add(lblSchedules);
		lblSchedules.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSchedules.setVisible(false);
		
		btnAdd.addActionListener(addAction());
		checkBRepet.addActionListener(checkRepetAction());
		comboBRepetAt.setVisible(false);
		lblUntil.setVisible(false);
		untilDateChooser.setVisible(false);
	}
	
	private ActionListener checkRepetAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBRepet.isSelected()) {
					comboBRepetAt.setVisible(true);
					lblUntil.setVisible(true);
					untilDateChooser.setVisible(true);
				}else {
					comboBRepetAt.setVisible(false);
					lblUntil.setVisible(false);
					untilDateChooser.setVisible(false);
				}
				
			}
			
		};
	}
	
	private ActionListener addAction() {
		ScheduleChooserPanel t = this;
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {					//TODO check the input the dates must be in the future
				//the dates and time must be different for each schedule,
				//for the onces in the same day need to be checked with the lesson duration
					
				ScheduleData data = new ScheduleData();
				data.startDate = dateTimeChooser.getDatePicker().getDate();
				data.startTime = dateTimeChooser.getTimePicker().getTime();
				data.repeat = checkBRepet.isSelected();
				
				// Check if the start date and time are not null
			    if (data.startDate == null || data.startTime == null) {
			        JOptionPane.showMessageDialog(null, "Please select a valid start date and time.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
				
				// Check if the start date is at least a day apart from the current date
			    LocalDate currentDate = LocalDate.now();
			    LocalDate selectedDate = data.startDate;
			    if (selectedDate.isBefore(currentDate.plusDays(1))) {
			        JOptionPane.showMessageDialog(null, "Start date must be at least a day apart from the current date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
			    
			    // Check if the until date is at least a day apart from the start date
			    LocalDate untilDate = untilDateChooser.getDate();
			    if (untilDate != null && untilDate.isBefore(selectedDate.plusDays(1))) {
			        JOptionPane.showMessageDialog(null, "Until date must be at least a day apart from the start date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
			        return;
			    }

			    // Check if the start time overlaps with another scheduled time
			    LocalTime selectedTime = data.startTime;
			    boolean isTimeOverlap = scheduledData.values().stream()
			            .anyMatch(schedule -> {
			                LocalDateTime scheduledDateTime = LocalDateTime.of(schedule.startDate, schedule.startTime);
			                LocalDateTime selectedDateTime = LocalDateTime.of(selectedDate, selectedTime);
			                return selectedDateTime.equals(scheduledDateTime);
			            });
			    if (isTimeOverlap) {
			        JOptionPane.showMessageDialog(null, "The selected time is already scheduled. Please choose a different time.", "Time Conflict", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
				
				String scheduledDate = dateTimeChooser.getDatePicker().getDateStringOrEmptyString() + " from " +
						dateTimeChooser.getTimePicker().getTimeStringOrEmptyString();
				if(checkBRepet.isSelected()) {
					// Check if the other fields for repetition are not null
			        if (comboBRepetAt.getSelectedItem() == null || untilDate == null) {
			            JOptionPane.showMessageDialog(null, "Please select valid options for until date.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					scheduledDate += ", repeat " + comboBRepetAt.getSelectedItem() + " until " +
							untilDateChooser.getDateStringOrEmptyString();
					data.atEvery = comboBRepetAt.getSelectedItem().toString();
					data.untilDate = untilDateChooser.getDate();
					
					untilDateChooser.setDate(null);
					comboBRepetAt.setSelectedItem(comboBRepetAt.getItemAt(0));
				}
				
				if(!areDisplayedScheduledDates) {							
					lblSchedules.setVisible(true);							
					areDisplayedScheduledDates = true;
				}
				
				data.parent = new NewScheduleDatePanel(scheduledDate, t);
				schedulesPanel.add(data.parent);
				
				scheduledData.put(data.parent, data);
				
				dateTimeChooser.getDatePicker().setDate(null);
				dateTimeChooser.getTimePicker().setTime(null);
				
				schedulesPanel.revalidate();
			}
			
		};
	}
}
