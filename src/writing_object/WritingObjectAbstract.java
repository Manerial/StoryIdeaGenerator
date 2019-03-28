package writing_object;

public abstract class WritingObjectAbstract implements WritingObjectInterface {
	/**
	 * Display a simple message
	 *
	 * @param message : The message to display
	 */
	public void display(String message) {
		System.out.println(message);
	}
}
