package main.ui.mentoringProgram;

import javax.swing.JPanel;

import main.ui.customComponents.RoundPanel;
import main.ui.calendar.*;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;

public class MentoringProgramDetails extends MentoringProgramPost {
	private JPanel contentPanel;
	
	public JPanel getContentPanel() {
		return contentPanel;
	}
	public MentoringProgramDetails(Boolean TODO,Boolean shortPanel) {
		super(TODO,shortPanel);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new MenuBar(this);
		panel.add(menuBar);
		
		contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		setMaximumSize(new Dimension(1000,10000));
		
	}
	/**
	 * Create the panel.
	 */
	public MentoringProgramDetails() {
		super();
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new MenuBar(this);
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
