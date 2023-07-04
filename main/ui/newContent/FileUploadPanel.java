package main.ui.newContent;

import main.ui.customComponents.RoundButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

/**
 * Let the user to upload one or more pdf files.
 * @author Daniel
 * @version 1.0
 */
public class FileUploadPanel extends JPanel {

	private byte[] uploadedFile;
	public Map<String,byte[]> uploadedFiles;
	public Map<String,JPanel> coursesPanels;
	public JPanel uploadedCoursesPanel;

	public FileUploadPanel() {
		setOpaque(false);
		uploadedFiles = new HashMap<>();
		coursesPanels = new HashMap<>();
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		JButton uploadButton = new RoundButton("Upload PDF");
		uploadButton.setFocusable(false);
		uploadButton.setBackground(new Color(128, 128, 128));
		uploadButton.setOpaque(false);
		uploadButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		uploadButton.addActionListener(uploadAction());

		add(uploadButton);

		uploadedCoursesPanel = new JPanel();
		uploadedCoursesPanel.setOpaque(false);
		add(uploadedCoursesPanel);
		uploadedCoursesPanel.setLayout(new BoxLayout(uploadedCoursesPanel, BoxLayout.Y_AXIS));

		JLabel lblCourseName = new JLabel("Course name");
		//uploadedCoursesPanel.add(lblCourseName);
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}

	private ActionListener uploadAction() {
		FileUploadPanel t = this;
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int option = fileChooser.showOpenDialog(FileUploadPanel.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					if (isPDFFile(selectedFile)) {
						try {
							uploadedFile = Files.readAllBytes(selectedFile.toPath());
							if(coursesPanels.containsKey(selectedFile.getName())) {
								JOptionPane.showMessageDialog(null,"You already uploaded this file.",
										"Eroare",JOptionPane.ERROR_MESSAGE);
							}else {
								uploadedFiles.put(selectedFile.getName(), uploadedFile);

								//display new uploaded course
								NewCoursePanel p = new NewCoursePanel(selectedFile.getName(),t);

								//store the JPanel
								coursesPanels.put(selectedFile.getName(), p);

								uploadedCoursesPanel.add(p);
								t.validate();
								t.revalidate();
								System.out.println("File uploaded successfully.");
							}

						} catch (IOException ex) {
							ex.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null,"Invalid file format. Please select a PDF file.",
								"Eroare",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};
	}

	private boolean isPDFFile(File file) {
		String extension = getFileExtension(file);
		return extension != null && extension.equalsIgnoreCase("pdf");
	}

	private String getFileExtension(File file) {
		String name = file.getName();
		int lastDotIndex = name.lastIndexOf('.');
		if (lastDotIndex > 0 && lastDotIndex < name.length() - 1) {
			return name.substring(lastDotIndex + 1).toLowerCase();
		}
		return null;
	}

	public byte[] getUploadedFile() {
		return uploadedFile;
	}
}
