package main.ui.mentors;

import javax.swing.JPanel;

import main.ui.customComponents.RoundPanel;
import main.ui.customComponents.TextAreaWithPreview;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class AboutPanel extends RoundPanel {
	private TextAreaWithPreview tAAbout;
	
	public AboutPanel(String data) {
		this();
		tAAbout.setTextBody(data);
	}
	/**
	 * Create the panel.
	 */
	public AboutPanel() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		
		tAAbout = new TextAreaWithPreview();
		tAAbout.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(tAAbout, BorderLayout.CENTER);

	}

}
