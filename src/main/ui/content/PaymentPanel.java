package main.ui.content;

import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import main.ui.coursePosts.CourseFilePanel;
import main.ui.coursePosts.CoursePostDetails;
import main.ui.customComponents.ImagePanel;
import main.ui.customComponents.RoundButton;
import main.utility.*;
import main.ui.login.LoginData;
import main.db.*;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class PaymentPanel extends JPanel {
	private JTextField tFCardNumber;
	private JTextField tFCvcCvv;
	private JComboBox<String> cBMM;
	private JComboBox<String> cBYY;
	private JButton btnCompletePayment;
	public JButton getBtnCompletePayment() {
		return btnCompletePayment;
	}

	private JTextField textField;
	private JPanel cardIconPanel;

	public PaymentPanel(Double totalSum) {
		this();
		//set the sum on the button
		totalSum = Math.round(totalSum*100)/100.0;
		btnCompletePayment.setText("Complete payment (Total $" + totalSum + ")");
		
		//load card icon
		ImagePanel img = new ImagePanel(ImageLoader.getInstance().getCardIcon(),new Dimension(250,120));
		cardIconPanel.add(img,BorderLayout.CENTER);
		
		//set combo models
		cBMM.setModel(mMComboModel());
		cBYY.setModel(yYComboModel());
		
		//set action to the payment button after it was added to a component
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				btnCompletePayment.addActionListener(paymentButtonActionListener());
			}
		});
	}
	
	/**
	 * Action listener for complete payment button.
	 * It handles the payment process and if succed it hide the payment panel and enable the view course button.
	 * @return complete payment action.
	 */
	private ActionListener paymentButtonActionListener() {
		CoursePostDetails aux = (CoursePostDetails)this.getParent();
		ActionListener act = new ActionListener() {
			String message = "";

			@Override
			public void actionPerformed(ActionEvent e) {
				// implement here	
				if(tFCardNumber.getText().length() == 16) 
				{
					if(tFCvcCvv.getText().length() == 3)
					{
						if(Integer.parseInt(cBMM.getSelectedItem().toString()) >= 6)
						{
							if(Integer.parseInt(cBYY.getSelectedItem().toString()) >= 2023)
							{
								////after the payments was successfully made			//TODO: check if the payment was succesfully
								//notify the view course button the the payment was successfully made
								((CourseFilePanel)aux.getFilePanel()).setPayed(true);
								//change icon of viewCourse button to unlock
								JButton btn = ((CourseFilePanel)aux.getFilePanel()).getBtnViewCourse();
								
								btn.setIcon(new ImageIcon(ImageLoader.getInstance().getUnlockedIcon()));
								aux.remove(aux.getPaymentPanel());
								aux.revalidate();
								
								EmailSender emailSender = new EmailSender();
								emailSender.sendToAsync(LoginData.emailIfLoginSucceded);
								
								return;
							} else {
								message = "The year must be greater or equal than 2023";
							}
						} else {
							message = "The month must be greater or equal than 6";
						}
					} else {
						message = "The cvv must have 3 digits";
					}
				} else {
					message = "Card number must have 16 digits";
				}
			}
			
		};
		return act;
	}
	
	public DefaultComboBoxModel<String> yYComboModel() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
		Integer year;
		for(year = 2023;year < 2030;year++) {
			model.addElement(year.toString());
		}
		
		return model;
	}
	
	public DefaultComboBoxModel<String> mMComboModel() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
		model.addElement("01");
		model.addElement("02");
		model.addElement("03");
		model.addElement("04");
		model.addElement("05");
		model.addElement("06");
		model.addElement("07");
		model.addElement("08");
		model.addElement("09");
		model.addElement("10");
		model.addElement("11");
		model.addElement("12");
		
		return model;
	}
	
	/**
	 * Create the panel.
	 */
	public PaymentPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setOpaque(false);
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 130));
		panel.setOpaque(false);
		add(panel);
		
		cardIconPanel = new JPanel();
		cardIconPanel.setOpaque(false);
		cardIconPanel.setPreferredSize(new Dimension(250, 120));
		cardIconPanel.setMinimumSize(new Dimension(250, 120));
		cardIconPanel.setMaximumSize(new Dimension(250, 120));
		panel.add(cardIconPanel);
		cardIconPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setMaximumSize(new Dimension(32767, 80));
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {523, 0, 0};
		gbl_panel_2.rowHeights = new int[] {28, 50, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setMaximumSize(new Dimension(32767, 30));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Card number: ");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setMaximumSize(new Dimension(32767, 30));
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 0;
		panel_2.add(panel_5, gbc_panel_5);
		
		JLabel lblNewLabel = new JLabel("CVC/CVV ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setMaximumSize(new Dimension(32767, 50));
		panel_6.setOpaque(false);
		panel_6.setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panel_2.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		tFCardNumber = new JTextField();
		tFCardNumber.setOpaque(false);
		tFCardNumber.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
		tFCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(tFCardNumber, BorderLayout.CENTER);
		tFCardNumber.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setMaximumSize(new Dimension(32767, 50));
		panel_7.setOpaque(false);
		panel_7.setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 1;
		panel_2.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		tFCvcCvv = new JTextField();
		tFCvcCvv.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
		tFCvcCvv.setOpaque(false);
		tFCvcCvv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(tFCvcCvv, BorderLayout.CENTER);
		tFCvcCvv.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setMaximumSize(new Dimension(32767, 80));
		panel_3.add(panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JPanel panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_15.setMaximumSize(new Dimension(32767, 30));
		FlowLayout flowLayout_2 = (FlowLayout) panel_15.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(0, 0, 5, 0);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 0;
		gbc_panel_15.gridy = 0;
		panel_8.add(panel_15, gbc_panel_15);
		
		JLabel lblNewLabel_2 = new JLabel("Card holder name: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_15.add(lblNewLabel_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setMaximumSize(new Dimension(32767, 50));
		panel_9.setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel_8.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setOpaque(false);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_9.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_10.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_10.setMaximumSize(new Dimension(32767, 30));
		panel_3.add(panel_10);
		
		JLabel lblNewLabel_3 = new JLabel("Expiration date: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_10.add(lblNewLabel_3);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setMaximumSize(new Dimension(32767, 30));
		panel_3.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_11.add(panel_12);
		
		JLabel lblNewLabel_4 = new JLabel("MM");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_12.add(lblNewLabel_4);
		
		cBMM = new JComboBox();
		panel_12.add(cBMM);
		
		JPanel panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_11.add(panel_13);
		
		JLabel lblNewLabel_5 = new JLabel("YY");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_13.add(lblNewLabel_5);
		
		cBYY = new JComboBox();
		panel_13.add(cBYY);
		
		JPanel panel_14 = new JPanel();
		panel_14.setOpaque(false);
		panel_14.setMaximumSize(new Dimension(32767, 50));
		panel_1.add(panel_14);
		
		btnCompletePayment = new RoundButton("Complete payment (Total $200)");
		btnCompletePayment.setBackground(new Color(128, 128, 128));
		btnCompletePayment.setPreferredSize(new Dimension(300, 30));
		btnCompletePayment.setOpaque(false);
		btnCompletePayment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_14.add(btnCompletePayment);

	}

}
