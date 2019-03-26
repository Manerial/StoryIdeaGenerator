package persona;

public class NobleTitle {
	private String prefix;
	private String suffix;
	private String adjective;

	/**
	 * Generic constructor
	 *
	 * @param prefix : The first part of the title (should not be empty)
	 * @param suffix : The second part of the title (can be empty)
	 * @param adjective : The third part of the title (can be empty)
	 */
	public NobleTitle(String prefix, String suffix, String adjective) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.adjective = adjective;
	}

	/**
	 * Empty constructor
	 */
	public NobleTitle() {
	}

	/**
	 * Get method for the title
	 *
	 * @return the title
	 */
	public String getTitle() {
		return prefix + ((suffix != null) ? " " + suffix : "") + ((adjective != null) ? " " + adjective : "");
	}

	/**
	 * Set method for the prefix
	 *
	 * @param prefix : The prefix to set
	 */
	public void setName(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Set method for the suffix
	 *
	 * @param suffix : The suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * Set method for the adjective
	 *
	 * @param adjective : The adjective to set
	 */
	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}
}
