package main.ui.search;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

import main.classes.Mentor;
import main.classes.User;
import main.ui.customComponents.ImagePanel;
import main.utility.ImageLoader;

public class SearchFiltersPanel extends JPanel {
	
	private JPanel searchBarPanel;
    private JPanel filtersPanel;
    private FilterPanel fieldPanel;
    private FilterPanel pricePanel;
    private FilterPanel locationPanel;
    private FilterPanel difficultyPanel;
    private FilterPanel teachingTypePanel;
    
    private String fieldFilter;
    
    public enum TYPE{
    	COURSE,
    	MENTOR,
    	MENTORINGPROGRAM
    }
	
	public SearchFiltersPanel(Boolean TODO,TYPE type) {
		this();
    	
    	//get proper values for filters combos, available from data from database(field availables,types avaiblables etc.)
    	String[] model = new String[] {"type 1","type 2","type 3"};
		
    	switch(type) {
    	case COURSE:
    		remove(searchBarPanel);
    		searchBarPanel = new SearchBarPanel();
    		add(searchBarPanel,0);
    		fieldPanel = new FilterPanel("Field");
    		pricePanel = new FilterPanel("Teacher");
    		add(fieldPanel);
			add(pricePanel);
			fieldPanel.plusPBField.addActionListener(fieldFilterActionListener(model));
			pricePanel.plusPBField.addActionListener(teacherFilterActionListener());
    		break;
    	case MENTOR:
    		remove(searchBarPanel);
    		searchBarPanel = new SearchBarPanel();
    		add(searchBarPanel,0);
    		fieldPanel = new FilterPanel("Field");
    		locationPanel = new FilterPanel("Location");
    		add(fieldPanel);
			add(locationPanel);
			fieldPanel.plusPBField.addActionListener(fieldFilterActionListener(model));
			locationPanel.plusPBField.addActionListener(locationFilterActionListener());
    		break;
    	case MENTORINGPROGRAM:
    		remove(searchBarPanel);
    		searchBarPanel = new SearchBarPanel();
    		add(searchBarPanel,0);
    		fieldPanel = new FilterPanel("Field");
    		pricePanel = new FilterPanel("Teacher");
    		difficultyPanel = new FilterPanel("Difficulty");
    		teachingTypePanel = new FilterPanel("Teaching type");
    		add(fieldPanel);
			add(pricePanel);
			add(difficultyPanel);
			add(teachingTypePanel);
			fieldPanel.plusPBField.addActionListener(fieldFilterActionListener(model));
			difficultyPanel.plusPBField.addActionListener(difficultyFilterActionListener(model));
			teachingTypePanel.plusPBField.addActionListener(teachingTypeFilterActionListener(model));
			pricePanel.plusPBField.addActionListener(teacherMPFilterActionListener());
    		break;
    	}
		
		
	}
	
	private ActionListener teacherMPFilterActionListener() {
		return new ActionListener() {

			private Boolean displayed = false;
			private JPanel p = new TextFilter("Teacher s name...");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!displayed) {
					pricePanel.add(p);
					displayed = true;
				}
				else {
					pricePanel.remove(p);
					displayed = false;
				}
				
				pricePanel.revalidate();
			}
			
		};
	}
	
	private ActionListener teachingTypeFilterActionListener(String[] model) {
		return new ActionListener() {

			private Boolean displayed = false;
			private JPanel p = new ComboFilter(model);
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!displayed) {
					teachingTypePanel.add(p);
					displayed = true;
				}
				else {
					teachingTypePanel.remove(p);
					displayed = false;
				}
				
				teachingTypePanel.revalidate();
			}
			
		};
	}
	
	private ActionListener difficultyFilterActionListener(String[] model) {
		return new ActionListener() {

			private Boolean displayed = false;
			private JPanel p = new ComboFilter(model);
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!displayed) {
					difficultyPanel.add(p);
					displayed = true;
				}
				else {
					difficultyPanel.remove(p);
					displayed = false;
				}
				
				difficultyPanel.revalidate();
			}
			
		};
	}
	
	private ActionListener locationFilterActionListener() {
		return new ActionListener() {

			private Boolean displayed = false;
			private JPanel p = new TextFilter("Location s name...");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!displayed) {
					locationPanel.add(p);
					displayed = true;
				}
				else {
					locationPanel.remove(p);
					displayed = false;
				}
				
				locationPanel.revalidate();
			}
			
		};
	}
	
	private ActionListener teacherFilterActionListener() {
		return new ActionListener() {

			private Boolean displayed = false;
			private JPanel p = new TextFilter("Teacher s name...");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!displayed) {
					pricePanel.add(p);
					displayed = true;
				}
				else {
					pricePanel.remove(p);
					displayed = false;
				}
				
				pricePanel.revalidate();
			}
			
		};
	}
	
	private ActionListener fieldFilterActionListener(String[] model) {
		return new ActionListener() {

			private Boolean displayed = false;
			//private JPanel p = new TextFilter("Field...");
			private JPanel p = new ComboFilter(model);
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!displayed) {
					fieldPanel.add(p);
					displayed = true;
				}
				else {
					fieldPanel.remove(p);
					displayed = false;
				}
				
				fieldPanel.revalidate();
			}
			
		};
	}
	/**
	 * Method that search for a panel index inside the container.
	 * @param target the panel in interest
	 * @return the index of the panel, -1 if not found
	 */
	public int findComponentIndex(Container container,Object target) {
		Component[] components = container.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i].equals(target)) {
				return i;
			}
		}
		return -1; // Component not found
	}
	/**
	 * Create the panel.
	 */
	public SearchFiltersPanel() {
		setOpaque(false);
		setMaximumSize(new Dimension(210, 1000));
		setPreferredSize(new Dimension(220, 500));
		setBackground(new Color(213, 215, 213));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		searchBarPanel = new JPanel();
		searchBarPanel.setOpaque(false);
		searchBarPanel.setMaximumSize(new Dimension(32767, 70));
		add(searchBarPanel);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setMaximumSize(new Dimension(32767, 30));
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Filters");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		filtersPanel = new JPanel();
		filtersPanel.setOpaque(false);
		add(filtersPanel);
		filtersPanel.setLayout(new BoxLayout(filtersPanel, BoxLayout.Y_AXIS));
		
		
	}
}
