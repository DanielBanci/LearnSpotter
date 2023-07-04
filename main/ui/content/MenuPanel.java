package main.ui.content;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.ui.customComponents.RoundMenuBar;

/**
 * This panel contains the menu bar.
 * @author Daniel
 * @version 1.0
 */
public class MenuPanel extends JPanel{
    private JMenuBar menuBar;
    private JMenuItem homeItem;
    private JMenuItem searchItem;
    private JMenuItem coursesItem;

    /**
     * Constructor that makes the panel with the menu display in the center.
     * It populates the menu bar with menus and item menus
     */
    public MenuPanel(){
        super();
        setMaximumSize(new Dimension(1500, 50));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(new BorderLayout());
        
        //menu bar
        menuBar = new RoundMenuBar();
        menuBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        menuBar.setMinimumSize(new Dimension(10, 10));

        //items
        homeItem = new JMenuItem("Home");
        homeItem.setOpaque(false);

        searchItem = new JMenuItem("Search");
        searchItem.setOpaque(false);

        coursesItem = new JMenuItem("Courses");
        coursesItem.setOpaque(false);

        menuBar.add(homeItem);
        menuBar.add(searchItem);
        menuBar.add(coursesItem);
        
        this.add(menuBar,BorderLayout.CENTER);
    }


}
