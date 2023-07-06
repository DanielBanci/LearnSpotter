package main.ui.search;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.ui.customComponents.RoundTextField;
import main.ui.customUI.HintTextFieldUI;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;

public class TextFilter extends JPanel{
	private JTextField textField;
	
	public TextFilter(String hint) {
		this();
		textField.setUI(new HintTextFieldUI(hint));
	}
	
	public TextFilter() {
		setOpaque(false);
		setBackground(new Color(255, 0, 0));
		setMaximumSize(new Dimension(327, 40));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		textField = new RoundTextField();
		textField.setPreferredSize(new Dimension(250, 40));
		textField.setMaximumSize(new Dimension(2147483647, 40));
		add(textField);
		textField.setColumns(10);
	}

}
