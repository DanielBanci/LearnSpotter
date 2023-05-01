package main.app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.ui.login.LoginPanel;

import java.awt.BorderLayout;

/**
 * The frame of the app.
 * @author Daniel
 * @version 1.0
 */
public class AppFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new LoginPanel(),BorderLayout.CENTER);
		
	}

}
