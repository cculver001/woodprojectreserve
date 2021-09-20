
package com.woodprojectreserve.model.buisness;

import java.util.Hashtable;
import java.util.Set;

import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.domian.Reservation;

/** <h1>RegistrationManager</h1>
 * <br>
 * <code>RegistrationManager</code> class implements a Registration Manager 
 * <br><br>
 * 
 * @version - 9.18.2021
 * @author Christopher Culver
 */
public class RegistrationManager {

	/** <h1>validateRegistration</h1>
	 * <br>
	 * Validates registration data from RegistrationController
	 * <br><br>
	 * @param request HttpServletRequest
	 */
	public static boolean validateRegistration(Customer customer) {
		
		boolean result = true;
		
		String id = customer.getId();
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
		String emailAddress = customer.getEmailAddress();
		String username = customer.getUsername();
		String password = customer.getPassword();
		String address1 = customer.getAddress1();
		String city = customer.getCity();
		String state = customer.getState();
		String postalCode = customer.getPostalCode();
		String country = customer.getCountry();
		String telephone = customer.getTelephone();
		Hashtable<Integer, Reservation> reservation = customer.getReservation();
		
		if (id == null 
				|| id.length() == 0) {
			result = false;
		}
		
		if (firstName == null
				|| firstName.length() == 0) {
			result = false;
		}
		
		if (lastName == null
				|| lastName.length() == 0) {
			result = false;
		}
		
		if (emailAddress == null
				|| emailAddress.length() == 0) {
			result = false;
		}
		
		if (username == null
				|| username.length() == 0) {
			result = false;
		}
		
		if (password == null
				|| password.length() == 0) {
			result = false;
		}
		
		if (address1 == null 
				|| address1.length() == 0) {
			result = false;
		}
		
		if (city == null
				|| city.length() == 0) {
			result = false;
		}
		
		if (state == null 
				|| state.length() == 0) {
			result = false;
		}
		
		if (postalCode == null 
				|| postalCode.length() == 0) {
			result = false;
		}
		
		if (country == null
				|| country.length() == 0) {
			result = false;
		}
		
		if (telephone == null 
				|| telephone.length() == 0) {
			result = false;
		}
		
		if (reservation != null) {
		
			if (reservation.size() > 0) {
				
				Set<Integer> keys = reservation.keySet();
				
				for (int key : keys) {
					
					Reservation res = reservation.get(key);
					
					if (ReservationManager.validateReservation(res) == false) {
						result = false;
						break;
					}
					
				}
				
			}
			
		} else {
			result = false;
		}
		
		return result;
		
	}
	
}
