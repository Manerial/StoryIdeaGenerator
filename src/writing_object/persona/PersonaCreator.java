package writing_object.persona;

import utilities.FileAccess;
import utilities.FileLoader;
import utilities.RandomClass;
import writing_object.nobility_title.NobilityTitle;
import writing_object.nobility_title.NobilityTitleCreator;
import writing_object.persona.physical.Gender;
import writing_object.persona.physical.Physical;
import writing_object.persona.physical.PhysicalCreator;

public class PersonaCreator {

	/**
	 * Create a character with the different option you want.
	 * If an option is null, it will be generate randomly.
	 *
	 * @param minAge : The minimum age the character can have
	 * @param maxAge : The maximum age the character can have
	 * @param name : If null, created randomly
	 * @param position : If null, created randomly
	 * @param job : If null, created randomly
	 * @param traits : If null, created randomly
	 * @param physical : If null, created randomly
	 * @param title : If null, created randomly
	 * @param language : The language you want to use for the creation. Uses the one of FileAccess.
	 * @return the created persona
	 */
	public static Persona createPersona(int minAge, int maxAge, String name, String position, String job, String[] traits, Physical physical, NobilityTitle title, String language) {
		int age = getAge(minAge, maxAge);
		position = getPosition(position, age, language);
		job = getJob(job, age, language);
		physical = getPhysical(physical, age, language);
		traits = getTraits(traits, language);
		name = getName(name, physical.getGender());
		title = getTitle(title, language);
		return new Persona(age, name, position, job, traits, physical, title);
	}

	/**
	 * Get a random age between two intervals.
	 *
	 * @param minAge : The minimum age the character can have
	 * @param maxAge : The maximum age the character can have
	 * @return the random age generated
	 */
	public static int getAge(int minAge, int maxAge) {
		return (minAge < maxAge) ? RandomClass.getRandIntoInterval((minAge >= 0) ? minAge : 0, maxAge) : minAge;
	}

	/**
	 * If needed, get a random name depending of the gender.
	 *
	 * @param name : If null, generate a new one
	 * @param gender : The generated name will depend of the gender
	 * @return the name
	 */
	public static String getName(String name, Gender gender) {
		if (name == null) {
			name = (gender == Gender.G) ? FileLoader.getRandomLine(FileAccess.GIRLS_FILE_PATH) : FileLoader.getRandomLine(FileAccess.BOYS_FILE_PATH);
		}
		return name;
	}

	/**
	 * If needed, get a random position depending of the age.
	 *
	 * @param position : If null, generate a new one
	 * @param age : The generated position will depend of the age
	 * @param language : The generation language
	 * @return the position
	 */
	public static String getPosition(String position, int age, String language) {
		if (position == null) {
			String[] posTemp;
			do {
				posTemp = FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.PER_POSITION_FILE).split("\t");
			} while (!checkAge(posTemp[0], age));
			position = posTemp[1];
		}
		return position;
	}

	/**
	 * If needed, get a random job depending of the age.
	 *
	 * @param job : If null, generate a new one
	 * @param age : The generated job will depend of the age
	 * @param language : The generation language
	 * @return the job
	 */
	public static String getJob(String job, int age, String language) {
		if (age < 18) {
			job = "";
		} else if (job == null) {
			job = FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.PER_JOB_FILE);
		}
		return job;
	}

	/**
	 * If needed, get a random physic depending of the age.
	 *
	 * @param physical : If null, generate a new one
	 * @param age : The generated age will depend of the age
	 * @param language : The generation language
	 * @return the physical
	 */
	public static Physical getPhysical(Physical physical, int age, String language) {
		if (physical == null) {
			physical = PhysicalCreator.createPhysical(null, null, null, null, -1, -1, null, null, age, language);
		}
		return physical;
	}

	/**
	 * If needed, get a random set of traits.
	 *
	 * @param traits : If null, generate a new set
	 * @param language : The generation language
	 * @return the set of traits
	 */
	public static String[] getTraits(String[] traits, String language) {
		if (traits == null) {
			String pathGoodSide = FileAccess.RESSOURCES + language + FileAccess.PER_GOODSIDE_FILE;
			String pathBadSide = FileAccess.RESSOURCES + language + FileAccess.PER_BADSIDE_FILE;
			String pathHandicap = FileAccess.RESSOURCES + language + FileAccess.PER_HANDICAP_FILE;
			String pathCharacteristics = FileAccess.RESSOURCES + language + FileAccess.PER_CHARACTERISTICS_FILE;
			traits = createTraits(pathGoodSide, pathBadSide, pathHandicap, pathCharacteristics);
		}
		return traits;
	}

	/**
	 * If needed, get a random title.
	 *
	 * @param title : If null, generate a new one
	 * @param language : The generation language
	 * @return the title
	 */
	public static NobilityTitle getTitle(NobilityTitle title, String language) {
		if (title == null) {
			title = NobilityTitleCreator.createNobleTitle(null, null, null, language);
		}
		return title;
	}

	/**
	 * Generate a bunch of traits, handicap and characteristics.
	 *
	 * @param pathGoodTraits : The path to access the good traits
	 * @param pathBadTraits : The path to access the bad traits
	 * @param pathHandicap : The path to access the handicaps
	 * @param pathCharacteristics : The path to access the characteristics
	 * @return a new set of traits
	 */
	private static String[] createTraits(String pathGoodTraits, String pathBadTraits, String pathHandicap, String pathCharacteristics) {
		int positif = RandomClass.getRandIntoInterval(1, 4);
		int negatif = RandomClass.getRandIntoInterval(1, 2);
		int handicap = RandomClass.getRandIntoInterval(0, 10);
		int caracteristiques = RandomClass.getRandIntoInterval(0, 20);
		handicap = (handicap > 2) ? 0 : handicap;
		caracteristiques = (caracteristiques < 10) ? 0 : (caracteristiques < 18) ? 1 : 2;
		String[] traits = new String[positif + negatif + handicap + caracteristiques];
		traits = addTrait(traits, positif, 0, pathGoodTraits);
		traits = addTrait(traits, negatif, positif, pathBadTraits);
		traits = addTrait(traits, handicap, positif + negatif, pathHandicap);
		traits = addTrait(traits, caracteristiques, positif + negatif + handicap, pathCharacteristics);
		return traits;
	}

	/**
	 * Read a file to generate a random number of traits.
	 *
	 * @param traits : Where the new traits will be stored
	 * @param numberOfTraits : The number of traits to generate
	 * @param offset : The position to register the new traits
	 * @param traitsFilePath : The file that contains the traits
	 * @return a new set of traits
	 */
	private static String[] addTrait(String[] traits, int numberOfTraits, int offset, String traitsFilePath) {
		for (int i = 0; i < numberOfTraits; i++) {
			String trait;
			do {
				trait = FileLoader.getRandomLine(traitsFilePath);
			} while (contains(traits, trait));

			traits[offset + i] = trait;
		}
		return traits;
	}

	/**
	 * Check if a list of string contains a string.
	 *
	 * @param list : The list to check
	 * @param word : The word to check
	 * @return true if the list contains the word
	 */
	private static boolean contains(String[] list, String word) {
		for (String str : list) {
			if (word.equals(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the ageRank matches the given age.
	 *
	 * @param ageRankStr : The age rank to check
	 * @param age : The age to check
	 * @return true if the age matches the age rank
	 */
	private static boolean checkAge(String ageRankStr, int age) {
		if (ageRankStr.contains("+")) {
			String ageString = ageRankStr.split("[+]")[0];
			int ageRank = Integer.parseInt(ageString);
			return ageRank < age;
		} else if (ageRankStr.contains("-")) {
			String ageString = ageRankStr.split("-")[0];
			int ageRank = Integer.parseInt(ageString);
			return ageRank > age;
		} else if (ageRankStr.equals("ALL")) {
			return true;
		}
		return false;
	}
}
