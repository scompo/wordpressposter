/**
 * ThesisPiece.java
 */
package it.scompo.wordpressposter.mods.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Piece of a thesis.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class ThesisPiece {
	
	private String title="";
	private String subtitle="";
	private List<String> paragraphs = new ArrayList<String>();
	
	public ThesisPiece(){
		
	}

	/**
	 * Gets the title.
	 *
	 * @return the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the subtitle.
	 *
	 * @return the subtitle.
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Sets subtitle.
	 *
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * Gets the paragraphs.
	 *
	 * @return the paragraphs.
	 */
	public List<String> getParagraphs() {
		return paragraphs;
	}

	/**
	 * Sets paragraphs.
	 *
	 * @param paragraphs the paragraphs to set
	 */
	public void setParagraphs(List<String> paragraphs) {
		this.paragraphs = paragraphs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ThesisPiece [title=" + title + ", subtitle=" + subtitle
				+ ", paragraphs=" + paragraphs + "]";
	}

	public void addParagraph(String text) {
		this.paragraphs.add(text);		
	}
	
}
