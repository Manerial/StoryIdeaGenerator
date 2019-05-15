package writing_object.nobility_title;

import java.util.Random;

import utilities.FileAccess;
import utilities.FileLoader;

public class NobilityTitleCreator {
	private static Random random = new Random();

	/**
	 * Create a character title with the different option you want.
	 * If an option is null, it will be generate randomly.
	 *
	 * @param prefix : If null, created randomly
	 * @param suffix : If null, created randomly
	 * @param adjective : If null, created randomly
	 * @param language : The language you want to use for the creation. Uses the one of FileAccess.
	 * @return the NobilityTitle generated
	 */
	public static NobilityTitle createNobilityTitle(String prefix, String suffix, String adjective, String language) {
		prefix = getPrefix(prefix, language);
		suffix = getSuffix(suffix, language);
		adjective = getAdjective(adjective, language);
		return new NobilityTitle(prefix, suffix, adjective);
	}

	/**
	 * If needed, get a random prefix.
	 *
	 * @param prefix : If null, generate a new one
	 * @param language : The generation language
	 * @return the prefix
	 */
	private static String getPrefix(String prefix, String language) {
		if (prefix == null) {
			prefix = FileLoader.getRandomLine(FileAccess.RESOURCES + language + FileAccess.TIT_PREFIX);
		}
		return prefix;
	}

	/**
	 * If needed, get a random suffix.
	 * There is 3 chances out of 5 to generate one.
	 *
	 * @param suffix : If null, generate a new one
	 * @param language : The generation language
	 * @return the suffix
	 */
	private static String getSuffix(String suffix, String language) {
		// 3 chances out of 5
		if (suffix == null && random.nextInt(5) < 3) {
			suffix = FileLoader.getRandomLine(FileAccess.RESOURCES + language + FileAccess.TIT_SUFFIX);
		}
		return suffix;
	}

	/**
	 * If needed, get a random adjective.
	 * There is 3 chances out of 5 to generate one.
	 *
	 * @param adjective : If null, generate a new one
	 * @param language : The generation language
	 * @return the adjective
	 */
	private static String getAdjective(String adjective, String language) {
		// 3 chances out of 5
		if (adjective == null && random.nextInt(5) < 3) {
			adjective = FileLoader.getRandomLine(FileAccess.RESOURCES + language + FileAccess.TIT_ADJECTIVE);
		}
		return adjective;
	}
}
