package main.ui.calendar;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;

import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;

/**
 * The class display a table that store the days of a month.
 * It has a JLabel that display the month in the calendar and it provide 2 buttons.
 * One button for displaying the next month and one for displaying the previous one.
 * @author Daniel
 * @version 1.0
 */
public class SchedulePanel extends RoundPanel {

	/**
	 * Create the panel.
	 */
	public SchedulePanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setOpaque(false);
		setForeground(getBackground());													//hide the border of the panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 53, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 200));
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(700, 200));
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrevious = new RoundButton("Previous");
		btnPrevious.setPreferredSize(new Dimension(100, 30));
		btnPrevious.setMinimumSize(new Dimension(100, 30));
		btnPrevious.setMaximumSize(new Dimension(100, 30));
		btnPrevious.setBackground(new Color(128, 128, 128));
		btnPrevious.setBorderPainted(false);
		btnPrevious.setFocusable(false);
		
		panel_1.add(btnPrevious);
		
		JLabel lblMonthYear = new JLabel("New label");
		lblMonthYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMonthYear.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMonthYear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setMaximumSize(new Dimension(32767, 200));
		panel_2.setOpaque(false);
		panel.add(panel_2);
		
		JButton btnNext = new RoundButton("Next");
		btnNext.setPreferredSize(new Dimension(100, 30));
		btnNext.setMinimumSize(new Dimension(100, 30));
		btnNext.setMaximumSize(new Dimension(100, 30));
		btnNext.setBackground(new Color(128, 128, 128));
		btnNext.setFocusable(false);
		panel_2.add(btnNext);
		
		DateTable calendarPanel = new DateTable(49,70);
		GridBagConstraints gbc_calendarPanel = new GridBagConstraints();
		gbc_calendarPanel.fill = GridBagConstraints.BOTH;
		gbc_calendarPanel.gridx = 0;
		gbc_calendarPanel.gridy = 3;
		add(calendarPanel, gbc_calendarPanel);
		
		//set current month
		Calendar cal = calendarPanel.getCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		String monthName = getMonthName(month);
		lblMonthYear.setText(monthName + " " + year);
		
		//actions for buttons
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarPanel.displayNextMonth();
				Calendar cal = calendarPanel.getCalendar();
				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);
				String monthName = getMonthName(month);
				lblMonthYear.setText(monthName + " " + year);
			}
		});

		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarPanel.displayPreviousMonth();
				Calendar cal = calendarPanel.getCalendar();
				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);
				String monthName = getMonthName(month);
				lblMonthYear.setText(monthName + " " + year);
			}
		});
	}
	
	/**
	 * Get the name of the month as a string.
	 * @param i the month number
	 * @return the month name
	 */
	public String getMonthName(int i) {
		String month = "January";
		switch(i) {
		case 1:month = "February";break;
		case 2:month = "March";break;
		case 3:month = "April";break;
		case 4:month = "May";break;
		case 5:month = "June";break;
		case 6:month = "July";break;
		case 7:month = "August";break;
		case 8:month = "September";break;
		case 9:month = "October";break;
		case 10:month = "November";break;
		case 11:month = "December";break;
		}
		return month;
	}

}
