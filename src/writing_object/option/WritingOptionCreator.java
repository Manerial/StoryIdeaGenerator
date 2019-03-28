package writing_object.option;

import java.util.ArrayList;

import utilities.FileAccess;
import utilities.FileLoader;

public class WritingOptionCreator {

	/**
	 * Generates writing option with different parameters.
	 * If a parameter is null, it will be generate randomly.
	 *
	 * @param style : If null, created randomly
	 * @param theme : If null, created randomly
	 * @param language : The language you want to use for the creation. Uses the one of FileAccess.
	 * @return the created writing options
	 */
	public static WritingOption createWritingOption(ArrayList<String> style, ArrayList<String> theme, String language) {
		style = getStyle(style, language);
		theme = getTheme(theme, language);
		return new WritingOption(style, theme);
	}

	/**
	 * If needed, get a random style list
	 *
	 * @param style : If null, generate a new one
	 * @param language : The generation language
	 * @return the style list
	 */
	private static ArrayList<String> getStyle(ArrayList<String> style, String language) {
		if (style == null) {
			style = new ArrayList<>();
			style.add(FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.OPT_STYLE_FILE));
		}
		return style;
	}

	/**
	 * If needed, get a random theme list
	 *
	 * @param theme : If null, generate a new one
	 * @param language : The generation language
	 * @return the theme list
	 */
	private static ArrayList<String> getTheme(ArrayList<String> theme, String language) {
		if (theme == null) {
			theme = new ArrayList<>();
			theme.add(FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.OPT_THEME_FILE));
		}
		return theme;
	}
}
