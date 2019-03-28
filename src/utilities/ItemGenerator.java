package utilities;

import persona.Persona;
import persona.PersonaCreator;
import writing_option.WritingOption;
import writing_option.WritingOptionCreator;

public class ItemGenerator {
	/**
	 * Generates random character
	 */
	public static void character() {
		Persona persona = PersonaCreator.createPersona(0, 100, null, null, null, null, null, null, FileAccess.FR_DIR);
		Interface.display(persona);
	}

	/**
	 * Generates random writing options
	 */
	public static void writingOption() {
		WritingOption options = WritingOptionCreator.createWritingOption(null, null, FileAccess.FR_DIR);
		Interface.display(options);
	}
}
