package com.woodprojectreserve.model.service.exception;

/** <h1>LoginException</h1>
 * <br>
 * <code>LoginException</code> class implements a Login exception
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {

	public LoginException(final String message) {
		super(message);
	}
	
	public LoginException(final String message, final Throwable exception) {
		super(message, exception);
	}
	
}