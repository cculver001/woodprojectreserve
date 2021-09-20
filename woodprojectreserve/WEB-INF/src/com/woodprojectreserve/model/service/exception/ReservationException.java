package com.woodprojectreserve.model.service.exception;

/** <h1>ReservationException</h1>
 * <br>
 * <code>ReservationException</code> class implements a Reservation exception
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
@SuppressWarnings("serial")
public class ReservationException extends Exception {

	public ReservationException(final String message) {
		super(message);
	}
	
	public ReservationException(final String message, final Throwable exception) {
		super(message, exception);
	}
	
	public ReservationException(final String message, final Throwable exception, String className, String method) {
		
		super(message, exception);
		
		System.err.println(exception.getClass().toString() + " - " + className + "::" + method);
		
	}
	
}
