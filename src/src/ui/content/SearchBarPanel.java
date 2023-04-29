package ui.content;

import javax.swing.JPanel;

import ui.customComponents.ImagePanel;
import ui.customComponents.RoundPanel;
import ui.customComponents.RoundTextField;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * The class represents a search bar.
 * It has a search icon on the left and an text input field.
 * @author Daniel
 * @version 1.0
 */
public class SearchBarPanel extends RoundPanel {
	
	private JPanel searchImagePanel;
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
		searchImagePanel = new ImagePanel("res/search_icon.png",new Dimension(45,45));
		searchImagePanel.setOpaque(false);
		add(searchImagePanel);
		
		//search text field
		searchTextField = new RoundTextField();
		add(searchTextField);
		searchTextField.setColumns(10);

	}

}
