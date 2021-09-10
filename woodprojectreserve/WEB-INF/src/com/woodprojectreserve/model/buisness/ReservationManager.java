
package com.woodprojectreserve.model.buisness;

import com.woodprojectreserve.model.domian.Reservation;

/** <h1>ReservationManager</h1>
 * <br>
 * <code>ReservationManager</code> class implements a Reservation Manager 
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class ReservationManager {

	/** <h1>validateReservation</h1>
	 * <br>
	 * Validates reservation data from ReservationController
	 * <br><br>
	 * @param request HttpServletRequest
	 */
	public static Reservation validateReservation(Reservation reservation) {
		
		if (reservation.validate()) {
			return reservation;
		} else {
			return null;
		}
		
	}
	
}
