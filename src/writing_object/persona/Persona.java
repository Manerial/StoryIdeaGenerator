package writing_object.persona;

import writing_object.WritingObjectAbstract;
import writing_object.nobility_title.NobilityTitle;
import writing_object.persona.physical.Gender;
import writing_object.persona.physical.Physical;

public class Persona extends WritingObjectAbstract {
	private int age;
	private String job;
	private String name;
	private Physical physical;
	private String position;
	private String[] traits;
	private NobilityTitle title;

	/**
	 * Generic constructor
	 *
	 * @param age : The age of the character
	 * @param name : The name of the character
	 * @param position : Position towards the hero
	 * @param job : The job of the character
	 * @param traits : A list containing the different traits the character has
	 * @param physical : The physical of the character
	 * @param title : The title of the character
	 */
	public Persona(int age, String name, String position, String job, String[] traits, Physical physical, NobilityTitle title) {
		this.age = age;
		this.position = position;
		this.job = job;
		this.name = name;
		this.traits = traits;
		this.physical = physical;
		this.title = title;
	}

	/**
	 * Empty constructor
	 */
	public Persona() {
	}

	/**
	 * Get method for the age
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set method for the age
	 *
	 * @param age : The age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Get method for the job
	 *
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Set method for the job
	 *
	 * @param job : The job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * Get method for the name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set method for the name
	 *
	 * @param name : The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get method for the physical
	 *
	 * @return the physical
	 */
	public Physical getPhysical() {
		return physical;
	}

	/**
	 * Set method for the physical
	 *
	 * @param physical : The physical to set
	 */
	public void setPhysical(Physical physical) {
		this.physical = physical;
	}

	/**
	 * Get method for the position
	 *
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Set method for the position
	 *
	 * @param position : The position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Get method for the traits
	 *
	 * @return the traits list
	 */
	public String[] getTraits() {
		return traits;
	}

	/**
	 * Set method for the traits
	 *
	 * @param traits : The traits list to set
	 */
	public void setTraits(String[] traits) {
		this.traits = traits;
	}

	/**
	 * Get method for the gender
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return physical.getGender();
	}

	/**
	 * Set method for the gender
	 *
	 * @param gender : The gender to set
	 */
	public void setGender(Gender gender) {
		physical.setGender(gender);
	}

	/**
	 * Get method for the title
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title.getTitle();
	}

	/**
	 * Set method for the title
	 *
	 * @param title : The title to set
	 */
	public void setTitle(NobilityTitle title) {
		this.title = title;
	}

	/**
	 * Display the persona
	 */
	@Override
	public void display() {
		this.display(this.getName() + " : ");
		this.display("\t Age : " + this.getAge());
		this.display("\t Genre : " + ((this.getGender() == Gender.B) ? "Gar�on" : "Fille"));
		this.display("\t Position : " + this.getPosition());
		this.display("\t Titre : " + this.getTitle());
		this.display("\t Metier : " + this.getJob());
		this.display("\t Informations : ");
		for (String trait : this.getTraits()) {
			this.display("\t\t " + trait);
		}
		this.display("\t Physique : ");
		physical.display();
	}
}