package main.ui.search;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboFilter extends JPanel {
	public JComboBox comboBox;
	
	public ComboFilter(String[] model){
		this();
		DefaultComboBoxModel<String> m = new DefaultComboBoxModel<>();
		m.addElement("...");
		for(String e : model) m.addElement(e);
		comboBox.setModel(m);
	}

	/**
	 * Create the panel.
	 */
	public ComboFilter() {
		setMaximumSize(new Dimension(32767, 40));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		comboBox = new JComboBox();
		comboBox.setMaximumSize(new Dimension(32767, 40));
		add(comboBox);

	}

}
