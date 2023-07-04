package main.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

public class SearchFiltersPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SearchFiltersPanel() {
		setPreferredSize(new Dimension(280, 500));
		setBackground(new Color(128, 255, 255));
		setLayout(null);
		
		JPanel searchBarPanel = new JPanel();
		searchBarPanel.setBounds(0, 50, 287, 72);
		searchBarPanel.setMaximumSize(new Dimension(32767, 500));
		searchBarPanel.setOpaque(false);
		add(searchBarPanel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 132, 287, 336);
		panel.setMaximumSize(new Dimension(32767, 3276));
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 128, 192));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filters");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 95, 30);
		add(lblNewLabel);

	}
}
