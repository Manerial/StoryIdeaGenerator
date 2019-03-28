package writing_object.option;

import java.util.ArrayList;

import writing_object.WritingObjectAbstract;

public class WritingOption extends WritingObjectAbstract {
	private ArrayList<String> style;
	private ArrayList<String> theme;

	/**
	 * Generates writing option with different parameters.
	 * If a parameter is null, it will be generate randomly.
	 *
	 * @param style : An ArrayList containing all the writing style proposed
	 * @param theme : An ArrayList containing all the themes proposed
	 */
	public WritingOption(ArrayList<String> style, ArrayList<String> theme) {
		this.style = style;
		this.theme = theme;
	}

	/**
	 * Empty constructor
	 */
	public WritingOption() {
	}

	/**
	 * Get method for the style
	 *
	 * @return the style ArrayList
	 */
	public ArrayList<String> getStyle() {
		return style;
	}

	/**
	 * Set method for the style
	 *
	 * @param style : The style ArrayList to set
	 */
	public void setStyle(ArrayList<String> style) {
		this.style = style;
	}

	/**
	 * Get method for the theme
	 *
	 * @return the theme ArrayList
	 */
	public ArrayList<String> getTheme() {
		return theme;
	}

	/**
	 * Set method for the theme
	 *
	 * @param theme : The theme ArrayList to set
	 */
	public void setTheme(ArrayList<String> theme) {
		this.theme = theme;
	}

	/**
	 * Display the writing options
	 */
	@Override
	public void display() {
		this.display("Style(s) : ");
		for (String style : this.getStyle()) {
			this.display("\t\t " + style);
		}
		this.display("Theme(s) : ");
		for (String theme : this.getTheme()) {
			this.display("\t\t " + theme);
		}
	}
}
