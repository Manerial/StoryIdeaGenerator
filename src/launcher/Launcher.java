package launcher;

import java.util.ArrayList;

import utilities.FileAccess;
import utilities.ItemGenerator;
import writing_object.nobility_title.NobilityTitle;
import writing_object.nobility_title.NobilityTitleCreator;
import writing_object.option.WritingOption;
import writing_object.option.WritingOptionCreator;
import writing_object.persona.Persona;
import writing_object.persona.PersonaCreator;
import writing_object.persona.physical.Physical;
import writing_object.persona.physical.PhysicalCreator;

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
		NobilityTitle t1 = NobilityTitleCreator.createNobleTitle(null, "de l'or", null, FileAccess.FR_DIR);

		// Creates custom persona
		Persona p1 = PersonaCreator.createPersona(1, 82, "Zorora", "Miss Terre", null, null, phys1, t1, FileAccess.FR_DIR);

		// Display a persona
		p1.display();

		// Creates custom writing options
		ArrayList<String> styles = new ArrayList<>();
		styles.add("Fantaisie");
		styles.add("Horreur");
		WritingOption writ1 = WritingOptionCreator.createWritingOption(styles, null, FileAccess.FR_DIR);

		// Display writing options
		writ1.display();
	}
}
