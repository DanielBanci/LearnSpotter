package main.ui.coursePosts;

import java.awt.BorderLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class PDFViewPanel extends JPanel { //BETA version

	/**
	 * Create the panel.
	 */
	public PDFViewPanel() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        byte[] pdfBytes = bos.toByteArray();
        
        JScrollPane jScrollPane1 = new JScrollPane();
        
        try {
        	//pdf viewer
            SwingController control = new SwingController();
            SwingViewBuilder factry = new SwingViewBuilder(control);
            JPanel viewerCompntpnl = factry.buildViewerPanel();
            ComponentKeyBinding.install(control, viewerCompntpnl);
            control.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(control.getDocumentViewController()));
            control.openDocument(new ByteArrayInputStream(pdfBytes), "", null); // create new ByteArrayInputStream object
            add(viewerCompntpnl,BorderLayout.CENTER);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Cannot Load Pdf");
        }
        
	}

}
