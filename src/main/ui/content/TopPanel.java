package main.ui.content;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.border.EmptyBorder;

import main.ui.customComponents.ImagePanel;
import main.ui.search.SearchBarPanel;

import javax.swing.BoxLayout;

/**
 * The class represents a panel with the logo on the left side,
 * a search bar in the middle and a menu in the left
 * @author Daniel
 * @version 1.0
 */
public class TopPanel extends JPanel {

	private JPanel logoPanel;
	private SearchBarPanel searchBar;
	
	/**
	 * Create the panel.
	 */
	public TopPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setMaximumSize(new Dimension(32767, 500));
		setMinimumSize(new Dimension(100,200));
		
		//logo
		logoPanel = new JPanel();
		GridBagConstraints gbc_logoPanel = new GridBagConstraints();
		gbc_logoPanel.insets = new Insets(0, 0, 0, 5);
		gbc_logoPanel.fill = GridBagConstraints.BOTH;
		gbc_logoPanel.gridx = 0;
		gbc_logoPanel.gridy = 0;
		add(logoPanel, gbc_logoPanel);
		logoPanel.setLayout(new BorderLayout(0, 0));
		//logoPanel.add(new ImagePanel("res/logo.png",new Dimension(400,200)),BorderLayout.CENTER);
		logoPanel.setMaximumSize(new Dimension(500,200));
		
		//search bar
		JPanel searchBarSupport = new JPanel();
		searchBarSupport.setBorder(new EmptyBorder(0, 30, 0, 15));
		GridBagConstraints gbc_searchBarSupport = new GridBagConstraints();
		gbc_searchBarSupport.insets = new Insets(0, 0, 0, 5);
		gbc_searchBarSupport.fill = GridBagConstraints.BOTH;
		gbc_searchBarSupport.gridx = 1;
		gbc_searchBarSupport.gridy = 0;
		add(searchBarSupport, gbc_searchBarSupport);
		searchBarSupport.setLayout(new BoxLayout(searchBarSupport, BoxLayout.X_AXIS));
		searchBar = new SearchBarPanel();
		searchBar.setMaximumSize(new Dimension(500,50));
		searchBarSupport.add(searchBar);
		
		

	}

}
