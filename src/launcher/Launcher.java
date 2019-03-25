package launcher;

import java.util.ArrayList;

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
		ItemGenerator.character();
		ItemGenerator.writingOption();
		Physical phys1 = PhysicalCreator.createPhysical("Bleus", "Courts bouclés", null, null, 150, 80000, null, null, -1, FileAccess.FR_DIR);
		Persona p1 = PersonaCreator.createPersona(1, 82, "Zorora", "Miss Terre", null, null, phys1, FileAccess.FR_DIR);
		Interface.display(p1);
		ArrayList<String> styles = new ArrayList<>();
		styles.add("Fantaisie");
		WritingOption writ1 = WritingOptionCreator.createWritingOption(styles, null, FileAccess.FR_DIR);
		Interface.display(writ1);
	}
}
