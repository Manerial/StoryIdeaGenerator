package launcher;

import java.util.ArrayList;

import persona.NobleTitle;
import persona.NobleTitleCreator;
import persona.Persona;
import persona.PersonaCreator;
import persona.Physical;
import persona.PhysicalCreator;
import utilities.FileAccess;
import utilities.Interface;
import utilities.ItemGenerator;
import writingOption.WritingOption;
import writingOption.WritingOptionCreator;

public class Launcher {

	/**
	 * Entry point
	 *
	 * @param args : Not used
	 */
	public static void main(String[] args) {
		// Creates a character
		ItemGenerator.character();
		// Creates some writing options
		ItemGenerator.writingOption();

		// Creates custom physical characteristics
		Physical phys1 = PhysicalCreator.createPhysical("Bleus", "Courts bouclés", null, null, 150, 80000, null, null, -1, FileAccess.FR_DIR);

		// Creates custom title for a character
		NobleTitle t1 = NobleTitleCreator.createNobleTitle(null, "de l'or", null, FileAccess.FR_DIR);

		// Creates custom persona
		Persona p1 = PersonaCreator.createPersona(1, 82, "Zorora", "Miss Terre", null, null, phys1, t1, FileAccess.FR_DIR);

		// Display a persona
		Interface.display(p1);

		// Creates custom writing options
		ArrayList<String> styles = new ArrayList<>();
		styles.add("Fantaisie");
		styles.add("Horreur");
		WritingOption writ1 = WritingOptionCreator.createWritingOption(styles, null, FileAccess.FR_DIR);

		// Display writing options
		Interface.display(writ1);
	}
}
