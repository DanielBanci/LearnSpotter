package main.ui.calendar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import main.ui.newContent.ScheduleData;

/**
 * A class that hold the panel which display the table reprezenting a date.
 * It it used as a component for schedule panel.
 * @author Daniel
 * @version 1.0
 */
public class DateTable extends JScrollPane{
	private Table table;
	private int rHeight = 49;
	private int cWidth = 100;

	/**
	 * The table that reprezent a date.
	 * @author Daniel
	 * @version 1.0
	 */
	class Table extends JTable{
		private List<Point> datesOfInterest;
		private Point today;
		private Calendar cal;
		private String currentMessage;
		private JPopupMenu popupMenu = createPopupMenu("No info to display");
		
		/**
		 * Helper class to store the interest dates.
		 * @author Daniel
		 * @version 1.0
		 */
		class Point{
			public int row;
			public int column;
			public int year;
			public int month;//the value of month from calendar
			public String message;
			
			public Point(int row,int column,int month,int year,String message) {
				this.row = row;
				this.column = column;
				this.month = month;
				this.year = year;
				this.message = message;
			}
			
		}
		
		public Table(List<ScheduleData> schedule) {
			this();
			makePointsOfInterest(schedule);
			
			
			orderMessages();
			addMouseListener(mouseAdapter);
			//repaint();
		}
		
		private void orderMessages() {
			for(Point p : datesOfInterest) {
				for(Point p1 : datesOfInterest) {
					if(p.row == p1.row && p.column == p1.column && p.month == p1.month && p.year == p1.year &&
							!p.message.equals(p1.message)) {
						p.message += " " + p1.message;
					}
						
				}
			}
		}
		
		private void makePointsOfInterest(List<ScheduleData> schedule) {			//TODO make something with the times
			Date currentCalTime = cal.getTime();
			for(ScheduleData s : schedule) {
				LocalDate startDate = s.startDate;
				Date date = new Date(startDate.getYear()-1900,startDate.getMonthValue()-1,startDate.getDayOfMonth());
				cal.setTime(date);
				int column = getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
				int row = cal.get(Calendar.WEEK_OF_MONTH)-1;
				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);
				LocalTime time = s.startTime;
				String message = time.toString();
				//datesOfInterest.add(new Point(row,column,month,year));
				
				if(s.repeat) {
					String noW = s.atEvery.split(" ")[1];
					int noWeeks = Integer.parseInt(noW);
					LocalDate uDate = s.untilDate;
					Date untilDate = new Date(uDate.getYear()-1900,uDate.getMonthValue()-1,uDate.getDayOfMonth());
					for(Date d = cal.getTime(); d.compareTo(untilDate) <= 0; 
							cal.add(Calendar.WEEK_OF_MONTH, noWeeks),d = cal.getTime()) {
						column = getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
						row = cal.get(Calendar.WEEK_OF_MONTH)-1;
						month = cal.get(Calendar.MONTH);
						year = cal.get(Calendar.YEAR);
						message = time.toString();
						datesOfInterest.add(new Point(row,column,month,year,message));
					}
				}else {
					datesOfInterest.add(new Point(row,column,month,year,message));
				}
			}
			cal.setTime(currentCalTime);
		}
		/**
		 * Constructor.
		 * It constructs and display the days of the current month.
		 */
		public Table() {
			super();
			cal = Calendar.getInstance();
			cal.setFirstDayOfWeek(Calendar.MONDAY);
			
			//get current date
			cal.setTime(new Date());
			int firstDayIndex = getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
			int firstDayWeekIndex = cal.get(Calendar.WEEK_OF_MONTH)-1;
			today = new Point(firstDayWeekIndex,firstDayIndex,cal.get(Calendar.MONTH),cal.get(Calendar.YEAR),null);
			datesOfInterest = new ArrayList<>();
			// Create the table model with 6 rows and 7 columns
			DefaultTableModel model = new DefaultTableModel() {
				@Override
			    public boolean isCellEditable(int row, int column) {
			        return false; // Make all cells non-editable
			    }
			};
			model.setDataVector(makeContent(new Date()), new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
			
			setModel(model);
			setAutoscrolls(false);
			setGridColor(new Color(255, 255, 255));
			setOpaque(false);
			setFocusable(false);

			//set row and coulmns size
			setRowHeight(rHeight);
			for (int i = 0; i < getColumnCount(); i++) {
				getColumnModel().getColumn(i).setPreferredWidth(cWidth);
			}
			setBackground(new Color(0,0,0,0));

			getTableHeader().setReorderingAllowed(false);
			getTableHeader().setOpaque(false);
			getTableHeader().setBackground(Color.GRAY);
			getTableHeader().setForeground(Color.white);
			getTableHeader().setBorder(new EmptyBorder(0,0,0,0));
			getTableHeader().setResizingAllowed(false);
			
			
		}
		
		/**
		 * Method that display the days of the month from date properly.
		 * @param date the date we want to display
		 * @return data for the calendar
		 */
		private String[][] makeContent(Date date){
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH, 1);										//set the date to first day of month
			
			int maxWeeksOfMonth = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);		//max weeks number
			String [][] data = new String[maxWeeksOfMonth][7];
			
			int firstDayIndex = getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
			//fill empty data
			int column = 0;
			int row = 0;
			while(column < firstDayIndex) {
				data[row][column++] = "";
			}
			
			Integer day = 1;
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);				//max number of days
			//fill days
			while(day <= maxDay) {
				data[row][column] = day.toString();
				
				column++;
				if(column == 7) {													//switch row
					if(day != maxDay) row++;
					column = 0;
				}
				day++;
			}
			if(column != 0) {														//fill empty space of any
				while(column <= 6) {
					data[row][column++] = "";
				}
			}
			return data;
		}
		
		/**
		 * The method display the next month on the panel.
		 */
		public void displayNextMonth() {
			cal.add(Calendar.MONTH, 1);
			setNewModel(cal.getTime());
		}
		
		/**
		 * The method display the previous month on the panel.
		 */
		public void displayPreviousMonth() {
			cal.add(Calendar.MONTH, -1);
			setNewModel(cal.getTime());
		}
		
		/**
		 * The method sets the new model to the calendar table.
		 * @param date the new date to display
		 */
		public void setNewModel(Date date) {
			DefaultTableModel model = new DefaultTableModel();
			model.setDataVector(makeContent(date), new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
			setModel(model);
			setRowHeight(rHeight);
			for (int i = 0; i < getColumnCount(); i++) {
				getColumnModel().getColumn(i).setPreferredWidth(cWidth);
			}
		}
		
		/**
		 * @return the calendar displayed.
		 */
		public Calendar getCalendar() {
			return cal;
		}
		
		/**
		 * Sets the font, the alignment and color the interest dates									//TODO: fill interest dates
		 */
		@Override
	    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	        Component c = super.prepareRenderer(renderer, row, column);
	        c.setBackground(getBackground());
	        c.setFont(new Font("Tharoma", Font.BOLD, 25));
	        ((DefaultTableCellRenderer) c).setHorizontalAlignment( JLabel.CENTER );
	        c.setForeground(Color.white);
	        for(Point p : datesOfInterest) {
	        	if(p.row == row && p.column == column
		        		&& p.month == ((Table)table).cal.get(Calendar.MONTH)
		        		&& p.year == ((Table)table).cal.get(Calendar.YEAR)) {
		        	c.setBackground(new Color(144, 238, 144, 128));
		        	
		        	
		        }
	        }
	        /*if(((Table)table).today.row == row && ((Table)table).today.column == column
	        		&& ((Table)table).today.month == ((Table)table).cal.get(Calendar.MONTH)
	        		&& ((Table)table).today.year == ((Table)table).cal.get(Calendar.YEAR)) {
	        	c.setBackground(new Color(144, 238, 144, 128));
	        }*/

	        return c;
	    }
		
		private boolean shouldDisplayPopupMenu(int row, int column) {
			for(Point p : datesOfInterest) {
				if(p.row == row && p.column == column && p.month == ((Table)table).cal.get(Calendar.MONTH) &&
						p.year == ((Table)table).cal.get(Calendar.YEAR)){
					
					if(p.message != null && !p.message.equals(currentMessage)) {
						popupMenu = createPopupMenu(p.message);
					}
							return true;
						}
			}
			return false;
		}

		
		private JPopupMenu createPopupMenu(String message) {
		    JPopupMenu popupMenu = new JPopupMenu();
		    popupMenu.setOpaque(false);
		    popupMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		    
		    currentMessage = message;
		    for(String s : message.split(" ")) {
		    	JLabel mes = new JLabel("from " + s);
		    mes.setForeground(Color.red);
		    mes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    popupMenu.add(mes);
		    }
		    
		    

		    return popupMenu;
		}

		private MouseAdapter mouseAdapter = new MouseAdapter() {
		    

		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (SwingUtilities.isLeftMouseButton(e)) {
		            JTable table = (JTable) e.getSource();
		            int row = table.rowAtPoint(e.getPoint());
		            int column = table.columnAtPoint(e.getPoint());

		            // Check your condition for displaying the popup menu
		            if (shouldDisplayPopupMenu(row, column)) {
		                popupMenu.show(table, e.getX(), e.getY());
		            }
		        }
		    }
		    @Override
		    public void mouseEntered(MouseEvent e) {
		            
		        
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		            
		        
		    }
		};
		
		/**
		 * Calculate the position of the day in a week that starts from monday
		 * @param position the current position
		 * @return the new position
		 */
		private int getDayOfWeek(int position) {
			position = (position - 1) > 0 ? (position - 1) : 7;
			return position - 1;
		}
		
	}
	
	/**
	 * Constructor. Creats a scroll panel that helps us to display the calendar panel.
	 */
	public DateTable(int rHeight,int cWidth) {
		this.rHeight = rHeight;
		this.cWidth = cWidth;
		setOpaque(false);
		setBorder(new EmptyBorder(-1, -1, -1, -1));
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		ScheduleData scheduleData = new ScheduleData();
        scheduleData.startDate = LocalDate.of(2023, 5, 1);
        scheduleData.startTime = LocalTime.of(10, 0);
        scheduleData.untilDate = LocalDate.of(2023, 5, 31);
        scheduleData.atEvery = "at 2 week(s)";
        scheduleData.repeat = true;
        
        List<ScheduleData> schedule = new ArrayList<>();
        schedule.add(scheduleData);
        scheduleData = new ScheduleData();
        scheduleData.startDate = LocalDate.of(2023, 6, 1);
        scheduleData.startTime = LocalTime.of(17, 0);
        scheduleData.untilDate = LocalDate.of(2023, 6, 15);
        scheduleData.atEvery = "at 2 week(s)";
        scheduleData.repeat = true;
        schedule.add(scheduleData);
        
        scheduleData = new ScheduleData();
        scheduleData.startDate = LocalDate.of(2023, 6, 1);
        scheduleData.startTime = LocalTime.of(19, 0);
        scheduleData.untilDate = LocalDate.of(2023, 6, 30);
        scheduleData.atEvery = "at 2 week(s)";
        scheduleData.repeat = true;
        schedule.add(scheduleData);
        
		table = new Table(schedule);
		
		//optimize size
		optimizeSize();

		getViewport().setOpaque(false);
		setOpaque(false);
		setViewportView(table);
		
	}
	/**
	 * Optimize the size of the scroll panel based of the table sizes.
	 */
	public void optimizeSize() {
		setMaximumSize(new Dimension(
				table.getColumnModel().getColumn(0).getPreferredWidth() * table.getColumnCount(),
				table.getRowHeight() * table.getRowCount() + 15));
		setPreferredSize(new Dimension(
				table.getColumnModel().getColumn(0).getPreferredWidth()* table.getColumnCount(),
				table.getRowHeight()* table.getRowCount() + 15));
	}
	
	/**
	 * Display the next month.
	 */
	public void displayNextMonth() {
		table.displayNextMonth();
		optimizeSize();
		getParent().revalidate();
	}
	
	/**
	 * Display the previous month.
	 */
	public void displayPreviousMonth() {
		table.displayPreviousMonth();
		optimizeSize();
		getParent().revalidate();
	}
	
	/**
	 * @return the calendar displayed.
	 */
	public Calendar getCalendar() {
		return table.getCalendar();
	}
}
