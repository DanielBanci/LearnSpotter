package main.ui.search;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.ui.customComponents.ImagePanel;
import main.utility.ImageLoader;
import java.awt.Color;

public class FilterPanel extends JPanel {

	public JButton plusPBField;
	private JLabel lblFilterName;
	
	public FilterPanel(String filter) {
		this();
		/*JPanel parent = (JPanel) plusPBField.getParent();
		parent.remove(plusPBField);
		plusPBField = new ImagePanel(ImageLoader.getInstance().getPlusIcon16(), new Dimension(20,20));
		parent.add(plusPBField);*/
		plusPBField.setIcon(new ImageIcon(ImageLoader.getInstance().getPlusIcon16()));
		plusPBField.setOpaque(false);
		lblFilterName.setText(filter);
		
	}
	
	/**
	 * Create the panel.
	 */
	public FilterPanel() {
		setBackground(new Color(213, 215, 213));

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setMaximumSize(new Dimension(32767, 30));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new EmptyBorder(0, 10, 0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2);
		
		lblFilterName = new JLabel("Field");
		panel_2.add(lblFilterName);
		lblFilterName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 5));
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_3);
		
		plusPBField = new JButton();
		plusPBField.setPreferredSize(new Dimension(20, 20));
		panel_3.add(plusPBField);
	}

}
