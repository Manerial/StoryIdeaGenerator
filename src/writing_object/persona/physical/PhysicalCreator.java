package writing_object.persona.physical;

import utilities.FileAccess;
import utilities.FileLoader;
import utilities.RandomClass;

public class PhysicalCreator {

	/**
	 * Create a physical with the different option you want.
	 * If an option is null, it will be generate randomly.
	 *
	 * @param hairColor : If null, created randomly
	 * @param hairStyle : If null, created randomly
	 * @param eyesColor : If null, created randomly
	 * @param faceShape : If null, created randomly
	 * @param height : If null, created randomly
	 * @param weight : If null, created randomly
	 * @param gender : If null, created randomly
	 * @param morphology : If null, created randomly
	 * @param age : Used to generate a height randomly
	 * @param language : The language you want to use for the creation. Uses the one of FileAccess.
	 * @return the generated physical
	 */
	public static Physical createPhysical(String hairColor, String hairStyle, String eyesColor, String faceShape, int height, int weight, Gender gender, String morphology, int age, String language) {
		hairColor = getHairColor(hairColor, language);
		hairStyle = getHairStyle(hairStyle, language);
		eyesColor = getEyesColor(eyesColor, language);
		faceShape = getFaceShape(faceShape, language);
		gender = getGender(gender);
		height = getHeight(height, age, gender);
		weight = getWeight(weight, height);
		morphology = getMorphology(morphology, Physical.getBMI(weight, height), language);
		return new Physical(hairColor, hairStyle, eyesColor, faceShape, height, weight, gender, morphology);
	}

	/**
	 * If needed, get a random hair color
	 *
	 * @param hairColor : If null, generate a new one
	 * @param language : The generation language
	 * @return the hair color
	 */
	public static String getHairColor(String hairColor, String language) {
		if (hairColor == null) {
			hairColor = FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.PHY_HAIRCOLOR_FILE);
		}
		return hairColor;
	}

	/**
	 * If needed, get a random hair style
	 *
	 * @param hairStyle : If null, generate a new one
	 * @param language : The generation language
	 * @return the hair style
	 */
	public static String getHairStyle(String hairStyle, String language) {
		if (hairStyle == null) {
			hairStyle = FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.PHY_HAIRSTYLE_FILE);
		}
		return hairStyle;
	}

	/**
	 * If needed, get a random eyes color
	 *
	 * @param eyesColor : If null, generate a new one
	 * @param language : The generation language
	 * @return the eyes color
	 */
	public static String getEyesColor(String eyesColor, String language) {
		if (eyesColor == null) {
			eyesColor = FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.PHY_EYESCOLOR_FILE);
		}
		return eyesColor;
	}

	/**
	 * If needed, get a random face shape
	 *
	 * @param faceShape : If null, generate a new one
	 * @param language : The generation language
	 * @return the face shape
	 */
	public static String getFaceShape(String faceShape, String language) {
		if (faceShape == null) {
			faceShape = FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.PHY_FACESHAPE_FILE);
		}
		return faceShape;
	}

	/**
	 * If needed, get a random morphology depending of the BMI
	 *
	 * @param morphology : If null, generate a new one
	 * @param BMI : The generated morphology will depend of the BMI
	 * @param language : The generation language
	 * @return the morphology
	 */
	public static String getMorphology(String morphology, int BMI, String language) {
		if (morphology == null) {
			String[] morphoTemp;
			do {
				morphoTemp = FileLoader.getRandomLine(FileAccess.RESSOURCES + language + FileAccess.PHY_MORPHOLOGY_FILE).split("\t");
			} while (!checkBMI(morphoTemp[0], BMI));
			morphology = morphoTemp[1];
		}
		return morphology;
	}

	/**
	 * If needed, get a random height depending of the age and the gender
	 *
	 * @param height : If lesser than 0, will generate a new one
	 * @param age : The generated height will depend of the age
	 * @param gender : The generated height will depend of the gender
	 * @return the height
	 */
	public static int getHeight(int height, int age, Gender gender) {
		if (height <= 0) {
			if (age <= 1) {
				height = RandomClass.getRandIntoInterval(70, 90);
			} else if (age <= 3) {
				height = RandomClass.getRandIntoInterval(70, 110);
			} else if (age <= 8) {
				height = RandomClass.getRandIntoInterval(100, 130);

			} else if (gender == Gender.B) {
				if (age >= 95) {
					height = RandomClass.getRandIntoInterval(150, 190);
				} else {
					height = RandomClass.getRandIntoInterval(130, 230);
				}

			} else if (gender == Gender.G) {
				if (age >= 95) {
					height = RandomClass.getRandIntoInterval(140, 170);
				} else {
					height = RandomClass.getRandIntoInterval(130, 190);
				}
			}
		}
		return height;
	}

	/**
	 * If needed, get a random weight depending of the height
	 *
	 * @param weight : If lesser than 0, will generate a new one
	 * @param height : The generated weight will depend of the height
	 * @return the weight
	 */
	public static int getWeight(int weight, int height) {
		if (weight <= 0) {
			float heightM = (float) height / 100;
			int minWeight = (int) ((15 * (heightM * heightM)) * 1000);
			int maxWeight = (int) ((31 * (heightM * heightM)) * 1000);
			weight = RandomClass.getRandIntoInterval(minWeight, maxWeight);
		}
		return weight;
	}

	/**
	 * If needed, get a random gender
	 *
	 * @param gender : If null, generate a new one
	 * @return the gender
	 */
	public static Gender getGender(Gender gender) {
		if (gender == null) {
			gender = (RandomClass.getRandIntoInterval(0, 1) == 0) ? Gender.G : Gender.B;
		}
		return gender;
	}

	/**
	 * Check if the morphology matches the BMI
	 *
	 * @param morphology : The morphology to check
	 * @param BMI : The BMI to check
	 * @return the morphology
	 */
	private static boolean checkBMI(String morphology, int BMI) {
		String BMIString;
		int BMIMin;
		int BMIMax;
		if (morphology.contains("+")) {
			BMIString = morphology.split("[+]")[0];
			BMIMin = Integer.parseInt(BMIString);
			return BMIMin <= BMI;
		} else if (morphology.contains("-")) {
			BMIString = morphology.split("[-]")[0];
			BMIMax = Integer.parseInt(BMIString);
			return BMI <= BMIMax;
		} else if (morphology.contains("/")) {
			BMIString = morphology.split("[/]")[0];
			BMIMin = Integer.parseInt(BMIString);
			BMIString = morphology.split("[/]")[1];
			BMIMax = Integer.parseInt(BMIString);
			return BMIMin <= BMI && BMI <= BMIMax;
		} else if (morphology.equals("ALL")) {
			return true;
		}
		return false;
	}
}
