package edu.neu.csye6200.utils;

/**
 * The Admin class represents an administrator with a username and password for authentication.
 * It provides methods to access and modify the username and password.
 */
public class Admin {

	/** The username of the admin. */
	private String username;

	/** The password of the admin. */
	private String password;

	/**
	 * Constructor to initialize the Admin object with the specified username and password.
	 *
	 * @param username The username of the admin.
	 * @param password The password of the admin.
	 */
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Retrieves the username of the admin.
	 *
	 * @return The username of the admin.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the admin.
	 *
	 * @param username The new username of the admin.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Retrieves the password of the admin.
	 *
	 * @return The password of the admin.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the admin.
	 *
	 * @param password The new password of the admin.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}