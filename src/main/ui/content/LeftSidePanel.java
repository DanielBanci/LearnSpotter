package main.ui.content;

import javax.swing.JPanel;

import main.classes.Mentor;
import main.classes.User;
import main.ui.customComponents.ImagePanel;
import main.utility.ImageLoader;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class LeftSidePanel extends JPanel {

	private JPanel logoPanel;
	private JPanel leftPanel;
	
	/**
	 * Create the panel.
	 */
	public LeftSidePanel(Mentor mentor) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{363, 0};
		gridBagLayout.rowHeights = new int[] {120, 273, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		logoPanel = new ImagePanel(ImageLoader.getInstance().getLogo(), new Dimension(200, 200));
		//logoPanel = new JPanel();
		logoPanel.setPreferredSize(new Dimension(200, 180));
		logoPanel.setMaximumSize(new Dimension(32767, 200));
		GridBagConstraints gbc_logoPanel = new GridBagConstraints();
		gbc_logoPanel.fill = GridBagConstraints.BOTH;
		gbc_logoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_logoPanel.gridx = 0;
		gbc_logoPanel.gridy = 0;
		add(logoPanel, gbc_logoPanel);
		
		leftPanel = new LeftPanel(true,mentor);
		//leftPanel = new JPanel();
		leftPanel.setMaximumSize(new Dimension(32767, 1000));
		leftPanel.setOpaque(false);
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.fill = GridBagConstraints.VERTICAL;
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 1;
		add(leftPanel, gbc_leftPanel);

	}
	/**
	 * Create the panel.
	 */
	public LeftSidePanel(User user,Mentor mentor) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		logoPanel = new ImagePanel(ImageLoader.getInstance().getLogo(), new Dimension(200, 200));
		//logoPanel = new JPanel();
		logoPanel.setMaximumSize(new Dimension(32767, 200));
		logoPanel.setPreferredSize(new Dimension(200, 180));
		logoPanel.setMinimumSize(new Dimension(200, 180));
		add(logoPanel);
		
		leftPanel = new LeftPanel(true,mentor,user);
		//leftPanel = new JPanel();
		leftPanel.setMaximumSize(new Dimension(32767, 1000));
		leftPanel.setOpaque(false);
		add(leftPanel);

	}
	
	/**
	 * Create the panel.
	 */
	public LeftSidePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{363, 0};
		gridBagLayout.rowHeights = new int[] {120, 500, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//logoPanel = new ImagePanel(ImageLoader.getInstance().getLogo(), new Dimension(200, 200));
		logoPanel = new JPanel();
		logoPanel.setPreferredSize(new Dimension(200, 180));
		logoPanel.setMaximumSize(new Dimension(32767, 200));
		GridBagConstraints gbc_logoPanel = new GridBagConstraints();
		gbc_logoPanel.fill = GridBagConstraints.BOTH;
		gbc_logoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_logoPanel.gridx = 0;
		gbc_logoPanel.gridy = 0;
		add(logoPanel, gbc_logoPanel);
		
		//leftPanel = new LeftPanel(true,mentor,user);
		leftPanel = new JPanel();
		leftPanel.setMaximumSize(new Dimension(32767, 1000));
		leftPanel.setOpaque(false);
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.fill = GridBagConstraints.VERTICAL;
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 1;
		add(leftPanel, gbc_leftPanel);

	}

}
