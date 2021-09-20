package com.woodprojectreserve.model.buisness.exception;

/** <h1>PropertyFileNotFoundException</h1>
 * <br>
 * <code>PropertyFileNotFoundException</code> class implements a Property 
 * File Not Found Exception 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class PropertyFileNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/** <h1>PropertyFileNotFoundException</h1>
	 * 
	 * @param message <code>String</code> value representing an exception
	 * @param exception <code>Throwable</code> object that represents an exception
	 */
	public PropertyFileNotFoundException(final String message, final Throwable exception) {
		super(message, exception);
	}

}