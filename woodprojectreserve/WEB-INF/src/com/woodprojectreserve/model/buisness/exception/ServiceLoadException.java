package com.woodprojectreserve.model.buisness.exception;

/** <h1>ServiceLoadException</h1>
 * <br>
 * <code>ServiceLoadException</code> class implements a Business Exception class 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
@SuppressWarnings("serial")
public class ServiceLoadException extends Exception {

	/** <h1>ServiceLoadException</h1>
	 * 
	 * @param message <code>String</code> value representing an exception
	 * @param exception <code>Throwable</code> object that represents an exception
	 */
	public ServiceLoadException(final String message, final Throwable exception) {
        super(message, exception);
    }
	
}