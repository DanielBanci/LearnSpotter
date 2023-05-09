package main.ui.content;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ScrollPane extends JScrollPane {

	/**
	 * Create the panel.
	 */
	public ScrollPane() {
		//setMaximumSize(new Dimension(400,100));
		setBorder(new EmptyBorder(0,0,0,0));
		getVerticalScrollBar().setUnitIncrement(16);
		getHorizontalScrollBar().setUnitIncrement(32);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		getHorizontalScrollBar().setOpaque(false);
		getHorizontalScrollBar().setVisible(false);
		//pane.setMaximumSize(MainPanel.getInstance().getViewport().getExtentSize());
		//pane.getViewport().getExtentSize();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Dimension dim = MainPanel.getInstance().getViewport().getExtentSize();
				setMaximumSize(new Dimension(dim.width,dim.height));
				//MainPanel.getInstance().getContent().setMaximumSize(MainPanel.getInstance().getViewport().getExtentSize());
				//MainPanel.getInstance().getViewport().setPreferredSize(new Dimension(400,200));
			}
			
		});
	}

}
