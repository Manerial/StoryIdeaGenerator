package utilities;

import java.util.Random;

public class RandomClass {
	private static final Random random = new Random();

	/**
	 * Get a random number between 0 and max
	 *
	 * @param max : the maximum value the random number can take
	 * @return a random number
	 */
	public static int getRandBelow(int max) {
		return random.nextInt(max + 1);
	}

	/**
	 * Get a random number between min and max (both included)
	 *
	 * @param min : the minimum value the random number can take
	 * @param max : the maximum value the random number can take
	 * @return a random number
	 */
	public static int getRandIntoInterval(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}
}
