package main.ui.coursePosts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.views.DocumentViewController;

/**
 * Panel that display a pdf file.
 * @author Daniel
 * @version 1.0
 */
public class PDFViewPanel extends JPanel { 

	/**
	 * Create the panel.
	 */
	public PDFViewPanel() {							//TODO: constructor with parameters: byte array file
		setLayout(new BorderLayout());
		
		//file to be displayed
		File file = new File("res/Analiza Sistemului.pdf");
        FileInputStream fis;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(file);
			byte[] buf = new byte[1024];
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				   bos.write(buf, 0, readNum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        byte[] pdfBytes = bos.toByteArray();
        
        try {
        	//pdf viewer
            SwingController control = new SwingController();
            SwingViewBuilder factry = new SwingViewBuilder(control);
            JPanel viewerCompntpnl = factry.buildViewerPanel();
            viewerCompntpnl.setMaximumSize(new Dimension(1000,700));
            viewerCompntpnl.setPreferredSize(new Dimension(1000,700));
            ComponentKeyBinding.install(control, viewerCompntpnl);
            control.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(control.getDocumentViewController()));
            control.openDocument(new ByteArrayInputStream(pdfBytes), "", null); // create new ByteArrayInputStream object
            add(viewerCompntpnl,BorderLayout.CENTER);
            control.setPageViewMode(DocumentViewController.PAGE_FIT_ACTUAL_SIZE, true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Cannot Load Pdf");
        }
        
	}

}
