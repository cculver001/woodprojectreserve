package com.woodprojectreserve.model.service.exception;

/** <h1>CustomerException</h1>
 * <br>
 * <code>CustomerException</code> class implements a Customer exception
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
@SuppressWarnings("serial")
public class CustomerException extends Exception {

	public CustomerException(final String message) {
		super(message);
	}
	
	public CustomerException(final String message, final Throwable exception) {
		super(message, exception);
	}
	
	public CustomerException(final String message, final Throwable exception, String className, String method) {
		
		super(message, exception);
		
		System.err.println(exception.getClass().toString() + " - " + className + "::" + method);
		
	}
	
}
