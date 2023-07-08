package main.ui.search;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class SortPanel extends JPanel {
	public JRadioButton rBPriceAsc;
	public JRadioButton rBPriceDesc;
	public JRadioButton rBBestFeedback;
	public TYPE sortedType = TYPE.NOTSELECTED;
	
	public enum TYPE{
		PRICEASC,
		PRICEDESC,
		BESTFEEDBACK,
		NOTSELECTED
	}
	

	public SortPanel(Boolean todo) {
		this();
		rBPriceAsc.addActionListener(sortPriceAscActionListener());
		rBPriceDesc.addActionListener(sortPriceDescActionListener());
		rBBestFeedback.addActionListener(sortFeedbackActionListener());
	}
	private ActionListener sortPriceAscActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rBPriceDesc.setSelected(false);
				rBBestFeedback.setSelected(false);
				if(!rBPriceAsc.isSelected()) {
					sortedType = TYPE.NOTSELECTED;
				}else {
					sortedType = TYPE.PRICEASC;
				}
				
				System.out.println(sortedType);
			}
			
		};
	}
	private ActionListener sortPriceDescActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rBPriceAsc.setSelected(false);
				rBBestFeedback.setSelected(false);
				if(!rBPriceDesc.isSelected()) {
					sortedType = TYPE.NOTSELECTED;
				}else {
					sortedType = TYPE.PRICEDESC;
				}
				System.out.println(sortedType);
			}
			
		};
	}
	private ActionListener sortFeedbackActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rBPriceDesc.setSelected(false);
				rBPriceAsc.setSelected(false);
				if(!rBBestFeedback.isSelected()) {
					sortedType = TYPE.NOTSELECTED;
				}else {
					sortedType = TYPE.BESTFEEDBACK;
				}
				System.out.println(sortedType);
			}
			
		};
	}
	/**
	 * Create the panel.
	 */
	public SortPanel() {
		setOpaque(false);
		setMaximumSize(new Dimension(180, 32767));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(213, 215, 213));
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel1.setMaximumSize(new Dimension(32767, 30));
		panel1.setBorder(new EmptyBorder(10,0,0,0));
		panel.add(panel1);
		add(panel);
		JLabel lblNewLabel = new JLabel("Sort");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel1.add(lblNewLabel);
		
		rBPriceAsc = new JRadioButton("Price ascending");
		panel.add(rBPriceAsc);
		rBPriceAsc.setHorizontalAlignment(SwingConstants.LEFT);
		rBPriceAsc.setOpaque(false);
		rBPriceAsc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		rBPriceDesc = new JRadioButton("Price descending");
		panel.add(rBPriceDesc);
		rBPriceDesc.setHorizontalAlignment(SwingConstants.LEFT);
		rBPriceDesc.setOpaque(false);
		rBPriceDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		rBBestFeedback = new JRadioButton("Best feedbacks");
		panel.add(rBBestFeedback);
		rBBestFeedback.setHorizontalAlignment(SwingConstants.LEFT);
		rBBestFeedback.setOpaque(false);
		rBBestFeedback.setFont(new Font("Tahoma", Font.PLAIN, 16));

		
	}

}
