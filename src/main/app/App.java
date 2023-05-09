package main.app;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import main.db.*;
import main.utility.*;
import javax.net.ssl.SSLContext;

/**
 * A singleton class that contains the app frame.
 * @author Daniel
 * @version 1.0
 */
public class App {
	private static App instance;
	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the app.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App app = App.getInstance();
					app.frame.setVisible(true);
					
					DbConnection dbConnection = new DbConnection();
					Connection conn = dbConnection.getConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	/**
	 * Get instance of the app class.
	 * @return instance of the app class.
	 */
	public static App getInstance() {
		if(instance == null) {instance = new App();}
		return instance;
	}
	
	/**
	 * Frame getter method.
	 * @return the apps frame.
	 */
	private App() {
		frame = new AppFrame();
	}

}
