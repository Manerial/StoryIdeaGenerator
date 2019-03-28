package writing_object.persona.physical;

import writing_object.WritingObjectAbstract;

public class Physical extends WritingObjectAbstract {
	private String hairStyle;
	private String hairColor;
	private String eyesColor;
	private String faceShape;
	private String morphology;
	private int weight;
	private int height;
	private Gender gender;

	/**
	 * Generic constructor
	 *
	 * @param hairColor : The hair color of the character
	 * @param hairStyle : The eyes color of the character
	 * @param eyesColor : The eyes color of the character
	 * @param faceShape : The face shape of the character
	 * @param height : The height of the character
	 * @param weight : The weight of the character
	 * @param gender : The gender of the character
	 * @param morphology : The morphology of the character
	 */
	public Physical(String hairColor, String hairStyle, String eyesColor, String faceShape, int height,
			int weight, Gender gender, String morphology) {
		this.hairColor = hairColor;
		this.eyesColor = eyesColor;
		this.faceShape = faceShape;
		this.hairStyle = hairStyle;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.morphology = morphology;
	}

	/**
	 * Empty constructor
	 */
	public Physical() {
	}

	/**
	 * Get method for the hair style
	 *
	 * @return the hair style
	 */
	public String getHairStyle() {
		return hairStyle;
	}

	/**
	 * Set method for the hair style
	 *
	 * @param hairStyle : The hair style to set
	 */
	public void setHairStyle(String hairStyle) {
		this.hairStyle = hairStyle;
	}

	/**
	 * Get method for the hair color
	 *
	 * @return the hair color
	 */
	public String getHairColor() {
		return hairColor;
	}

	/**
	 * Set method for the hair color
	 *
	 * @param hairColor : The hair color to set
	 */
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	/**
	 * Get method for the eyes color
	 *
	 * @return the eyes color
	 */
	public String getEyesColor() {
		return eyesColor;
	}

	/**
	 * Set method for the eyes color
	 *
	 * @param eyesColor : The eyes color to set
	 */
	public void setEyesColor(String eyesColor) {
		this.eyesColor = eyesColor;
	}

	/**
	 * Get method for the face shape
	 *
	 * @return the face shape
	 */
	public String getFaceShape() {
		return faceShape;
	}

	/**
	 * Set method for the face shape
	 *
	 * @param faceShape : The face shape to set
	 */
	public void setFaceShape(String faceShape) {
		this.faceShape = faceShape;
	}

	/**
	 * Get method for the morphology
	 *
	 * @return the morphology
	 */
	public String getMorphology() {
		return morphology;
	}

	/**
	 * Set method for the morphology
	 *
	 * @param morphology : The morphology to set
	 */
	public void setMorphology(String morphology) {
		this.morphology = morphology;
	}

	/**
	 * Get method for the weight
	 *
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Set method for the weight
	 *
	 * @param weight : The weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Get method for the height
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set method for the height
	 *
	 * @param height : The height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Get method for the gender
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Set method for the gender
	 *
	 * @param gender : The gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Get the BMI of the character
	 *
	 * @return the BMI
	 */
	public int getBMI() {
		float weightKG = (float) (weight) / 1000;
		float heightM = (float) (height) / 100;
		int BMI = (int) (weightKG / (heightM * heightM));
		return BMI;
	}

	/**
	 * Get the BMI of a character depending of the given weight and height
	 *
	 * @param weight : The weight used to get the BMI
	 * @param height : The height used to get the BMI
	 * @return the BMI
	 */
	public static int getBMI(int weight, int height) {
		float weightKG = (float) (weight) / 1000;
		float heightM = (float) (height) / 100;
		int BMI = (int) (weightKG / (heightM * heightM));
		return BMI;
	}

	@Override
	public void display() {
		this.display("\t\t Taille : " + this.getHeight() + "cm");
		this.display("\t\t Poid : " + this.getWeight() + "g");
		this.display("\t\t Morphologie : " + this.getMorphology());
		this.display("\t\t Couleur Yeux : " + this.getEyesColor());
		this.display("\t\t Couleur Cheveux : " + this.getHairColor());
		this.display("\t\t Coiffure : " + this.getHairStyle());
		this.display("\t\t Forme Visage : " + this.getFaceShape());
	}
}
