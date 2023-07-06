package main.ui.search;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.ui.customComponents.ImagePanel;
import main.ui.customComponents.RoundButton;
import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.RoundTextField;
import main.utility.ImageLoader;

/**
 * The class represents a search bar.
 * It has a search icon on the left and an text input field.
 * @author Daniel
 * @version 1.0
 */
public class SearchBarPanel extends RoundPanel {
	
	private JPanel searchImagePanel;
	private JLabel searchLbl;
	private JTextField searchTextField;

	/**
	 * Create the panel.
	 */
	public SearchBarPanel() {
		setMaximumSize(new Dimension(32767, 50));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setMaximumSize(new Dimension(1000,50));
		this.setMinimumSize(new Dimension(100,50));
		
		//search icon
		
		searchLbl = new JLabel();
		searchLbl.setIcon(new ImageIcon(ImageLoader.getInstance().getSearchIcon24()));
		searchLbl.setMaximumSize(new Dimension(24,24));
		add(searchLbl);
		
		//search text field
		searchTextField = new RoundTextField();
		add(searchTextField);
		searchTextField.setColumns(10);

	}

}
