package main.ui.mentoringProgram;

import javax.swing.JPanel;

import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;
import main.classes.MentoringProgram;
import main.classes.User;
import main.ui.calendar.*;
import main.ui.content.MainPanel;
import main.ui.content.PaymentPanel;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

public class MentoringProgramDetails extends MentoringProgramPost {
	private JPanel contentPanel;
	private MentoringProgram mentoringProgram;
	private JPanel paymentPanel;
	private JPanel buttonPanel;
	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public MenuBar menuBar;
	private User user;
	
	public JPanel getPaymentPanel() {
		return paymentPanel;
	}
	public MentoringProgram getMentoringProgram() {
		return mentoringProgram;
	}
	public JPanel getContentPanel() {
		return contentPanel;
	}
	
	public void setPaymentStatus(Boolean status) {
		menuBar.getCoursesPanel().setPaymentStatus(status);
	}
	public MentoringProgramDetails(MentoringProgram mentoringProgram,Boolean shortPanel,User user,Boolean owned) {
		super(mentoringProgram,shortPanel,user,owned);
		this.mentoringProgram = mentoringProgram;
		this.user = user;
		/*JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new MenuBar(this,mentoringProgram);
		panel.add(menuBar);
		
		contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		setMaximumSize(new Dimension(1000,10000));*/
		
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setMaximumSize(new Dimension(32767, 40));
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(buttonPanel);
		
		JButton btnJoin = new RoundButton("Join");
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setBackground(new Color(0, 128, 0));
		btnJoin.setPreferredSize(new Dimension(100, 30));
		btnJoin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonPanel.add(btnJoin);
		
		btnJoin.addActionListener(joinAction());
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		menuBar = new MenuBar(this,mentoringProgram);
		panel.add(menuBar);
		
		setPaymentStatus(owned);
		if(owned) {
			remove(buttonPanel);
			panel.remove(menuBar);
			//menuBar = new MenuBar(this,mentoringProgram,user);
			menuBar = new MenuBar(this,mentoringProgram,MainPanel.loggedUser);
			panel.add(menuBar);
		}
		contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
	}
	
	private ActionListener joinAction() {
		return new ActionListener() {
			private int count = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(paymentPanel == null)
					paymentPanel = new PaymentPanel(Double.valueOf(mentoringProgram.getPrice()),user,mentoringProgram);
				if(count == 0) {
					int index = findComponentIndex(MentoringProgramDetails.this, buttonPanel) + 1;
					MentoringProgramDetails.this.add(paymentPanel,index);
					MentoringProgramDetails.this.revalidate();
					count = 1;
				}else {
					MentoringProgramDetails.this.remove(paymentPanel);
					MentoringProgramDetails.this.revalidate();
					count = 0;
				}
				
			}
			
		};
	}
	
	/**
	 * Method that search for a panel index inside the container.
	 * @param target the panel in interest
	 * @return the index of the panel, -1 if not found
	 */
	public int findComponentIndex(Container container,Object target) {
		Component[] components = container.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i].equals(target)) {
				return i;
			}
		}
		return -1; // Component not found
	}
	
	/**
	 * Create the panel.
	 */
	public MentoringProgramDetails() {
		super();
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setMaximumSize(new Dimension(32767, 40));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_1);
		
		JButton btnJoin = new RoundButton("Join");
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setBackground(new Color(0, 128, 0));
		btnJoin.setPreferredSize(new Dimension(100, 30));
		btnJoin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnJoin);
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new MenuBar(this,null);
		panel.add(menuBar);
		
		contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		
		
		
		
		
		/*setBorder(new EmptyBorder(1, 1, 1, 1));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		mentoringProgramPostPanel = new MentoringProgramPost();
		mentoringProgramPostPanel.setForeground(mentoringProgramPostPanel.getBackground());
		add(mentoringProgramPostPanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.setOpaque(false);
		add(panel_1);*/

	}

}
