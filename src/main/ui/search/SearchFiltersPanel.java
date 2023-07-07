package main.ui.search;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

import main.classes.Mentor;
import main.classes.User;
import main.ui.content.MainPanel;
import main.ui.customComponents.ImagePanel;
import main.ui.displayContent.DisplayCoursesPanel;
import main.ui.displayContent.DisplayMentoringProgramsPanel;
import main.ui.displayContent.DisplayMentorsPanel;
import main.utility.ImageLoader;

public class SearchFiltersPanel extends JPanel {

	private SearchBarPanel searchBarPanel;
	private JPanel filtersPanel;
	private FilterPanel fieldPanel;
	private FilterPanel pricePanel;
	private FilterPanel locationPanel;
	private FilterPanel difficultyPanel;
	private FilterPanel teachingTypePanel;

	private String fieldFilter;
	private String teacherFilter;
	private String locationFilter;
	private String difficultyFilter;
	private String teachingTypeFilter;

	private TextFilter teacherCourse;
	private TextFilter teacherMP;
	private TextFilter locationMentor;
	private ComboFilter difficultyP;
	private ComboFilter teachingTypeP;
	private ComboFilter fieldP;

	private TYPE currentType;

	public enum TYPE{
		COURSE,
		MENTOR,
		MENTORINGPROGRAM
	}

	public SearchFiltersPanel(Boolean TODO,TYPE type) {
		this();
		currentType = type;
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
		searchBarPanel.searchLbl.addMouseListener(searchAction());

	}

	private MouseListener searchAction() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(fieldPanel != null) {
					try {
						fieldFilter = (String) fieldP.comboBox.getSelectedItem();
					}catch(Exception e1) {

					}
				}
				if(teacherMP != null) {
					try {
						teacherFilter = (String) teacherMP.textField.getText();
					}catch(Exception e1) {

					}
				}
				if(teacherCourse != null) {
					try {
						teacherFilter = (String) teacherCourse.textField.getText();
					}catch(Exception e1) {

					}
				}
				if(locationMentor != null) {
					try {
						locationFilter = (String) locationMentor.textField.getText();
					}catch(Exception e1) {

					}
				}
				if(difficultyP != null) {
					try {
						teacherFilter = (String) locationMentor.textField.getText();
					}catch(Exception e1) {

					}
				}
				if(teachingTypeP != null) {
					try {
						teacherFilter = (String) teachingTypeP.comboBox.getSelectedItem();
					}catch(Exception e1) {

					}
				}
				//TODO: you need to check if the filters are != null, if null it doesn t count as a filter (no error message displayed)
				switch(currentType) {
				case COURSE:
					//TODO:search related courses

					//refresh UI
					MainPanel.getInstance().getContent().removeAll();
					MainPanel.getInstance().getContent().add(new DisplayCoursesPanel());
					MainPanel.getInstance().getContent().validate();
					break;
				case MENTOR:
					//TODO:search related mentors

					//refresh UI
					MainPanel.getInstance().getContent().removeAll();
					MainPanel.getInstance().getContent().add(new DisplayMentorsPanel());
					MainPanel.getInstance().getContent().validate();
					break;
				case MENTORINGPROGRAM:
					//TODO:search related mentoring program

					//refresh UI
					MainPanel.getInstance().getContent().removeAll();
					MainPanel.getInstance().getContent().add(new DisplayMentoringProgramsPanel());
					MainPanel.getInstance().getContent().validate();
					break;
				}
				/*private String fieldFilter;
			    private String teacherFilter;
			    private String locationFilter;
			    private String difficultyFilter;
			    private String teachingTypeFilter;*/
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		};
	}

	private ActionListener teacherMPFilterActionListener() {
		return new ActionListener() {

			private Boolean displayed = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(teacherMP == null)
					teacherMP = new TextFilter("Teacher s name...");
				if(!displayed) {
					pricePanel.add(teacherMP);
					displayed = true;
				}
				else {
					pricePanel.remove(teacherMP);
					displayed = false;
				}

				pricePanel.revalidate();
			}

		};
	}

	private ActionListener teachingTypeFilterActionListener(String[] model) {
		return new ActionListener() {

			private Boolean displayed = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(teachingTypeP == null)
					teachingTypeP = new ComboFilter(model);
				if(!displayed) {
					teachingTypePanel.add(teachingTypeP);
					displayed = true;
				}
				else {
					teachingTypePanel.remove(teachingTypeP);
					displayed = false;
				}

				teachingTypePanel.revalidate();
			}

		};
	}

	private ActionListener difficultyFilterActionListener(String[] model) {
		return new ActionListener() {

			private Boolean displayed = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(difficultyP == null)
					difficultyP = new ComboFilter(model);
				if(!displayed) {
					difficultyPanel.add(difficultyP);
					displayed = true;
				}
				else {
					difficultyPanel.remove(difficultyP);
					displayed = false;
				}

				difficultyPanel.revalidate();
			}

		};
	}

	private ActionListener locationFilterActionListener() {
		return new ActionListener() {

			private Boolean displayed = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(locationMentor == null)
					locationMentor = new TextFilter("Location s name...");
				if(!displayed) {
					locationPanel.add(locationMentor);
					displayed = true;
				}
				else {
					locationPanel.remove(locationMentor);
					displayed = false;
				}

				locationPanel.revalidate();
			}

		};
	}

	private ActionListener teacherFilterActionListener() {
		return new ActionListener() {

			private Boolean displayed = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(teacherCourse == null)
					teacherCourse = new TextFilter("Teacher s name...");
				if(!displayed) {
					pricePanel.add(teacherCourse);
					displayed = true;
				}
				else {
					pricePanel.remove(teacherCourse);
					displayed = false;
				}

				pricePanel.revalidate();
			}

		};
	}

	private ActionListener fieldFilterActionListener(String[] model) {
		return new ActionListener() {

			private Boolean displayed = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(fieldP == null)
					fieldP = new ComboFilter(model);
				if(!displayed) {
					fieldPanel.add(fieldP);
					displayed = true;
				}
				else {
					fieldPanel.remove(fieldP);
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
		setBorder(new EmptyBorder(5, 0, 0, 0));
		setOpaque(false);
		setMaximumSize(new Dimension(210, 1000));
		setPreferredSize(new Dimension(220, 500));
		setBackground(new Color(213, 215, 213));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		searchBarPanel = new SearchBarPanel();
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
