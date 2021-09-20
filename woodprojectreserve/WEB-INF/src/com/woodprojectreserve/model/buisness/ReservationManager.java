
package com.woodprojectreserve.model.buisness;

import com.woodprojectreserve.model.domian.Reservation;

/** <h1>ReservationManager</h1>
 * <br>
 * <code>ReservationManager</code> class implements a Reservation Manager 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class ReservationManager {

	/** <h1>validateReservation</h1>
	 * <br>
	 * Validates reservation data from ReservationController
	 * <br><br>
	 * @param request HttpServletRequest
	 */
	public static boolean validateReservation(Reservation reservation) {
		
		String userId = reservation.getUserId();
		String name = reservation.getName();
		String material = reservation.getMaterial();
		String woodMain = reservation.getWoodMain();
		String woodSecondary = reservation.getWoodSecondary();
		String finishType = reservation.getFinishType();
		String completionDate = reservation.getCompletionDate();
		String detail = reservation.getDetail();
		
		if (userId == null || userId.length() == 0) {
			return false;
		}
		
		if (name == null || name.length() == 0) {
			return false;
		}
		
		if (material == null || material.length() == 0) {
			return false;
		}
		
		if (woodMain == null || woodMain.length() == 0) {
			return false;
		}
		
		if (woodSecondary == null || woodSecondary.length() == 0) {
			return false;
		}
		
		if (finishType == null || finishType.length() == 0) {
			return false;
		}
		
		if (completionDate == null || completionDate.length() == 0) {
			return false;
		}
		
		if (detail == null || detail.length() == 0) {
			return false;
		}
		
		return true;
		
	}
	
}
