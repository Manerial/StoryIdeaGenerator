package utilities;

public class FileAccess {
	static final String ROOT_DIRECTORY = System.getProperty("user.dir");
	public static final String RESSOURCES = ROOT_DIRECTORY + "\\ressources";

	public static final String PERSONNA = "\\persona";
	public static final String PHYSICAL = PERSONNA + "\\physical";
	public static final String WRITTING_OPTIONS = "\\writting options";

	public static final String BOYS_FILE_PATH = RESSOURCES + "\\boys.txt";
	public static final String GIRLS_FILE_PATH = RESSOURCES + "\\girls.txt";

	public static final String PER_BADSIDE_FILE = PERSONNA + "\\bad_traits.txt";
	public static final String PER_GOODSIDE_FILE = PERSONNA + "\\good_traits.txt";
	public static final String PER_CHARACTERISTICS_FILE = PERSONNA + "\\caracteristics.txt";
	public static final String PER_HANDICAP_FILE = PERSONNA + "\\handicap.txt";
	public static final String PER_JOB_FILE = PERSONNA + "\\job.txt";
	public static final String PER_POSITION_FILE = PERSONNA + "\\position.txt";
	public static final String OPT_STYLE_FILE = WRITTING_OPTIONS + "\\style.txt";
	public static final String OPT_THEME_FILE = WRITTING_OPTIONS + "\\theme.txt";
	public static final String PHY_EYESCOLOR_FILE = PHYSICAL + "\\eyes_color.txt";
	public static final String PHY_FACESHAPE_FILE = PHYSICAL + "\\face_shape.txt";
	public static final String PHY_HAIRCOLOR_FILE = PHYSICAL + "\\hair_color.txt";
	public static final String PHY_HAIRSTYLE_FILE = PHYSICAL + "\\hair_style.txt";
	public static final String PHY_MORPHOLOGY_FILE = PHYSICAL + "\\morphology.txt";

	public static final String FR_DIR = "\\french";
	public static final String EN_DIR = "\\english";
}
