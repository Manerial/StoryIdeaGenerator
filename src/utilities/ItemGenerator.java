package utilities;

import writing_object.option.WritingOption;
import writing_object.option.WritingOptionCreator;
import writing_object.persona.Persona;
import writing_object.persona.PersonaCreator;

public class ItemGenerator {
	/**
	 * Generates random character
	 */
	public static void character() {
		Persona persona = PersonaCreator.createPersona(0, 100, null, null, null, null, null, null, FileAccess.FR_DIR);
		persona.display();
	}

	/**
	 * Generates random writing options
	 */
	public static void writingOption() {
		WritingOption options = WritingOptionCreator.createWritingOption(null, null, FileAccess.FR_DIR);
		options.display();
	}
}
