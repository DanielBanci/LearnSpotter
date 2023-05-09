package main.ui.mentoringProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.TextAreaWithPreview;
import javax.swing.BoxLayout;

public class AboutPanel extends JPanel {
	private TextAreaWithPreview tADescription;
	private JPanel panelTextArea;
	/**
	 * Create the panel.
	 */
	public AboutPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panelTextArea = new RoundPanel();
		panelTextArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelTextArea.setBackground(new Color(255, 255, 255));
		panelTextArea.setLayout(new BorderLayout(0, 0));
		
		tADescription = new TextAreaWithPreview();
		panelTextArea.add(tADescription, BorderLayout.CENTER);
		
		add(panelTextArea);
	}
}
