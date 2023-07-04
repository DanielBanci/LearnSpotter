package main.ui.customComponents;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * A custom JTextArea component that displays a preview of text with the option to expand and collapse the full text.
 * If the full text is longer than the specified preview length, the preview text ends with "..." and a "See more" link is displayed.
 * Clicking on "See more" expands the full text, and "See less" link is displayed.
 * Clicking on "See less" collapses the text back to the preview.
 * The component is not editable.
 * @author Daniel
 * @version 1.0
 */
public class TextAreaWithPreview extends JTextArea {

	private String fullText;
	private int previewLength = 200;
	private boolean expanded = false;

	/**
	 * Default constructor. Creates a non-editable text area with no text.
	 */
	public TextAreaWithPreview() {
		super();
		this.fullText = "";
		setWrapStyleWord(true);
		setLineWrap(true);
		setEditable(false);
	}
	
	/**
	 * Sets the text to be displayed, if the text is too long a preview is displayed and
	 * a message at the end of the text is displayed to handle the action.
	 * @param text the text to be displayed.
	 */
	public void setTextBody(String text) {
		this.fullText = text;
		setText(getPreviewText(fullText));
		if (!getPreviewText(fullText).equals(fullText)) {
			addSeeMoreAction();
		}
	}
	
	/**
	 * Creats a text area and display the text as required. 
	 * @param fullText the text that needs to be displayed
	 */
	public TextAreaWithPreview(String fullText) {
		super();
		this.fullText = fullText;
		setWrapStyleWord(true);
		setLineWrap(true);
		setText(getPreviewText(fullText));
		setEditable(false);
		if (!getPreviewText(fullText).equals(fullText)) {
			addSeeMoreAction();
		}
	}

	/**
	* Adds a "See more" link to the end of the preview text.
	* When the link is clicked, the full text is displayed and a "See less" link is added to the end of the full text.
	*/
	private void addSeeMoreAction() {
		int length = getText().length();
		append(" See more");
		for (MouseListener listener : getMouseListeners()) {
			removeMouseListener(listener);
		}
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int clickPosition = viewToModel(evt.getPoint());
				if (clickPosition >= length) {							//check if the click where made at the end of the text
					if (expanded) {
						setText(getPreviewText(fullText));
						addSeeMoreAction();
						expanded = false;
					} else {
						setText(fullText);
						addSeeLessAction();
						expanded = true;
					}
				}
			}
		});
	}
	
	/**
	* Adds a "See less" link to the end of the full text.
	* When the link is clicked, the component is collapsed back to the preview.
	*/
	private void addSeeLessAction() {
		int length = getText().length() - 9;
		append(" See less");
		for (MouseListener listener : getMouseListeners()) {
			removeMouseListener(listener);
		}
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int clickPosition = viewToModel(evt.getPoint());
				if (clickPosition >= length) {						//check if the click where made at the end of the text
					setText(getPreviewText(fullText));
					addSeeMoreAction();
					expanded = false;
				}
			}
		});
	}

	/**
	 * Cut the full text as a preview.
	 * @param fullText the full text
	 * @return the preview of the text.
	 */
	private String getPreviewText(String fullText) {
		if (fullText.length() > previewLength) {
			int lastSpaceIndex = fullText.substring(0, previewLength).lastIndexOf(" ");
			return fullText.substring(0, lastSpaceIndex) + "..." ;
		} else {
			return fullText;
		}
	}
}


