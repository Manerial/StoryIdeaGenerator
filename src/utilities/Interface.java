package utilities;

import persona.Gender;
import persona.Persona;
import writing_option.WritingOption;

public class Interface {
	/**
	 * Display the writing options
	 *
	 * @param options : the options to display
	 */
	public static void display(WritingOption options) {
		display("Style(s) : ");
		for (String style : options.getStyle()) {
			display("\t\t " + style);
		}
		display("Theme(s) : ");
		for (String theme : options.getTheme()) {
			display("\t\t " + theme);
		}
	}

	/**
	 * Display the persona informations
	 *
	 * @param persona : the persona to display
	 */
	public static void display(Persona persona) {
		display(persona.getName() + " : ");
		display("\t Age : " + persona.getAge());
		display("\t Genre : " + ((persona.getGender() == Gender.B) ? "Garçon" : "Fille"));
		display("\t Position : " + persona.getPosition());
		display("\t Titre : " + persona.getTitle());
		display("\t Metier : " + persona.getJob());
		display("\t Informations : ");
		for (String trait : persona.getTraits()) {
			display("\t\t " + trait);
		}
		display("\t Physique : ");
		display("\t\t Taille : " + persona.getPhysical().getHeight() + "cm");
		display("\t\t Poid : " + persona.getPhysical().getWeight() + "g");
		display("\t\t Morphologie : " + persona.getPhysical().getMorphology());
		display("\t\t Couleur Yeux : " + persona.getPhysical().getEyesColor());
		display("\t\t Couleur Cheveux : " + persona.getPhysical().getHairColor());
		display("\t\t Coiffure : " + persona.getPhysical().getHairStyle());
		display("\t\t Forme Visage : " + persona.getPhysical().getFaceShape());
	}

	/**
	 * Display a message
	 *
	 * @param message : the message to display
	 */
	private static void display(String message) {
		System.out.println(message);
	}
}
