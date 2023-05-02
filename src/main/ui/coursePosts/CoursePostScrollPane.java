package main.ui.coursePosts;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import main.app.App;

/**
 * Scroll panel that holds all the details related to a course.
 * @author Daniel
 * @version 1.0
 */
public class CoursePostScrollPane extends JScrollPane {

	private JPanel scrollView;
	private JPanel support;
	/**
	 * Create the panel.
	 */
	public CoursePostScrollPane() {									//TODO: display missing data
		scrollView = new JPanel();
		scrollView.setLayout(new BoxLayout(scrollView,BoxLayout.X_AXIS));
		scrollView.setMaximumSize(new Dimension(2500,30000));
		
		support = new JPanel();
		support.setLayout(new BoxLayout(support,BoxLayout.Y_AXIS));
		support.setMaximumSize(new Dimension(2000,30000));
		support.add(new CoursePostDetails(true,support)); 			//needs support to resize on action listener
		scrollView.add(support);
		
		setViewportView(scrollView);
		setBorder(new EmptyBorder(0, 10, 0, 10));
		getVerticalScrollBar().setUnitIncrement(16);
		getHorizontalScrollBar().setUnitIncrement(16);
		
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//set viewport position to top after display
		SwingUtilities.invokeLater(() -> {
		        getVerticalScrollBar().setValue(0);
		    });
	}
}
