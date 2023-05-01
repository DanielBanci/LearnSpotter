package main.ui.coursePosts;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import main.app.App;
import main.ui.customComponents.RoundButton;

import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;

/**
 * A panel that countains the course name and a button the let the user to see the course,
 * if the course was bought.
 * @author Daniel
 * @version 1.0
 */
public class CourseFilePanel extends JPanel {
	
	private ImageIcon iconButtonLocked;				//relatede TO DO: change icons after the payed was made
	private ImageIcon iconButtonUnlocked;
	private ImageIcon pdfFileIcon;
	private JPanel pdfViewPanel;
	

	private void loadButtonsImageIcon() {
		Image img = null;
		iconButtonLocked = null;
		iconButtonUnlocked = null;
		pdfFileIcon = null;
		//down
		try {
            img = ImageIO.read(new File("res/locked_icon.png"));
            iconButtonLocked = new ImageIcon(img);
            
            img = ImageIO.read(new File("res/unlocked_icon.png"));
            iconButtonUnlocked = new ImageIcon(img);
            
            img = ImageIO.read(new File("res/pdf_icon.png"));
            pdfFileIcon = new ImageIcon(img);
        }catch(Exception e){
            e.printStackTrace();
        }
		
	}
	
	/**
	 * Create the panel.
	 */
	public CourseFilePanel() {
		loadButtonsImageIcon();
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel courseFilePanel = new JPanel();
		courseFilePanel.setOpaque(false);
		courseFilePanel.setBorder(new EmptyBorder(10, 10, 20, 20));
		add(courseFilePanel);
		courseFilePanel.setLayout(new BoxLayout(courseFilePanel, BoxLayout.X_AXIS));
		
		JLabel lblIconPdfFile = new JLabel("");
		lblIconPdfFile.setBorder(new EmptyBorder(3, 3, 3, 3));
		lblIconPdfFile.setPreferredSize(new Dimension(32, 32));
		lblIconPdfFile.setMinimumSize(new Dimension(32, 32));
		lblIconPdfFile.setMaximumSize(new Dimension(32, 32));
		
		lblIconPdfFile.setIcon(pdfFileIcon);
		
		courseFilePanel.add(lblIconPdfFile);
		
		JLabel lblNewLabel = new JLabel("CourseName.pdf");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseFilePanel.add(lblNewLabel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20000, 10));
		courseFilePanel.add(horizontalStrut_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 10));
		courseFilePanel.add(horizontalStrut);
		
		JButton btnViewCourse = new RoundButton("View course");
		btnViewCourse.setForeground(Color.BLACK);
		btnViewCourse.setBackground(Color.GRAY);
		btnViewCourse.setPreferredSize(new Dimension(200, 30));
		btnViewCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewCourse.setMinimumSize(new Dimension(100, 30));
		btnViewCourse.setMaximumSize(new Dimension(200, 30));
		courseFilePanel.add(btnViewCourse);
		btnViewCourse.setIcon(iconButtonLocked);
		CourseFilePanel p = this;
		btnViewCourse.addActionListener(new ActionListener() { 			//put this in a function
			private Boolean first = true;
			@Override
			public void actionPerformed(ActionEvent e) {
				//condition
				if(first) {
				p.remove(pdfViewPanel);
				pdfViewPanel = new PDFViewPanel();
				btnViewCourse.setIcon(iconButtonUnlocked);
				p.add(pdfViewPanel,1);
				//p.repaint();
				App.getInstance().getFrame().pack();
				first = false;
				}else {
					p.remove(pdfViewPanel);
					btnViewCourse.setIcon(iconButtonLocked);
					first = true;
					App.getInstance().getFrame().pack();
				}
			}
			
		});
		
		pdfViewPanel = /*new PDFViewPanel();*/new JPanel();
		pdfViewPanel.setOpaque(false);
		add(pdfViewPanel);

	}

}
