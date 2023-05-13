package main.ui.newContent;

import javax.swing.JPanel;

import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;
import main.ui.customUI.HintTextAreaUI;
import main.ui.customUI.HintTextFieldUI;

import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
/**
 * Panel that let the user to uplod a new course post.
 * The user needs to provide a title, a desciption of the course, a price (or select free) and to upload the file(s)
 * @author Daniel
 * @version 1.0
 */
public class NewCoursePost extends JPanel {						
	private JTextField tFCourseTitle;							
	private JTextField tFPrice;
	private JTextArea tACourseDescription;
	private JCheckBox checkBoxFree;
	private JComboBox<String> comboBoxMoney;
	private FileUploadPanel uploadCoursePanel;
	private JButton btnPost;
	private JPanel panel_4;

	/**
	 * Create the panel.
	 */
	public NewCoursePost() {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_4 = new RoundPanel();
		panel_4.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_4.setOpaque(false);
		panel_4.setMinimumSize(new Dimension(50, 50));
		add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setPreferredSize(new Dimension(700, 30));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setOpaque(false);
		
		tFCourseTitle = new JTextField();
		panel.add(tFCourseTitle);
		tFCourseTitle.setUI(new HintTextFieldUI("Course title",true,Color.GRAY));
		tFCourseTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFCourseTitle.setOpaque(false);
		tFCourseTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tFCourseTitle.setColumns(10);
		
		tACourseDescription = new JTextArea();
		panel_4.add(tACourseDescription);
		tACourseDescription.setFont(new Font("Monospaced", Font.PLAIN, 16));
		tACourseDescription.setLineWrap(true);
		tACourseDescription.setWrapStyleWord(true);
		tACourseDescription.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tACourseDescription.setOpaque(false);
		tACourseDescription.setUI(new HintTextAreaUI("Write a description about the course...",true,Color.GRAY));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		tFPrice = new JTextField();
		tFPrice.setUI(new HintTextFieldUI("Add a price", true, Color.GRAY));
		tFPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFPrice.setOpaque(false);
		tFPrice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_2.add(tFPrice);
		tFPrice.setColumns(10);
		
		comboBoxMoney = new JComboBox<>();
		comboBoxMoney.setFocusable(false);
		comboBoxMoney.addItem("RON");
		comboBoxMoney.addItem("EURO");
		comboBoxMoney.addItem("USD");
		panel_2.add(comboBoxMoney);
		
		checkBoxFree = new JCheckBox("Free");
		checkBoxFree.setFocusable(false);
		checkBoxFree.setOpaque(false);
		checkBoxFree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(checkBoxFree);
		
		checkBoxFree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxFree.isSelected()) {
                    tFPrice.setText("Free");
                    comboBoxMoney.setVisible(false);
                } else {
                    tFPrice.setText(null);
                    comboBoxMoney.setVisible(true);
                }
            }
        });
		
		uploadCoursePanel = new FileUploadPanel();
		panel_4.add(uploadCoursePanel);
		uploadCoursePanel.setOpaque(false);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_3.setOpaque(false);
		
		btnPost = new RoundButton("Post");
		btnPost.setFocusable(false);
		btnPost.setForeground(new Color(255, 255, 255));
		btnPost.setBackground(new Color(35, 146, 16));
		btnPost.setPreferredSize(new Dimension(100, 30));
		panel_3.add(btnPost);
		btnPost.addActionListener(postButtonAction());

	}
	
	/**
	 * It checks the input data and store and display the new course
	 * @return post button action listener
	 */
	private ActionListener postButtonAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {					//TODO create the new course
				Map<String,byte[]> courses = new HashMap<>();
				courses = uploadCoursePanel.uploadedFiles;					//courses
				
				//tFCourseTitle												//TODO get data from the fields and check the input
				//tACourseDescription
				//checkBoxFree
				//tFPrice.getText()											//for checking -> ok if numbers like 45 or with dot
				//comboBoxMoney															   -> ok if string "Free" and checkBoxFree is checked
				
				
				if(courses.size() == 0) {
					JOptionPane.showMessageDialog(null,"You must upload a course.",
							"Eroare",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		};
	}
}
