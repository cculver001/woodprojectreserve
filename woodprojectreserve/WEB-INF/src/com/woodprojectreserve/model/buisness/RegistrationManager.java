
package com.woodprojectreserve.model.buisness;

import com.woodprojectreserve.model.domian.Customer;

/** <h1>RegistrationManager</h1>
 * <br>
 * <code>RegistrationManager</code> class implements a Registration Manager 
 * <br><br>
 * 
 * @version - 9.9.2021
 * @author Christopher Culver
 */
public class RegistrationManager {

	/** <h1>validateRegistration</h1>
	 * <br>
	 * Validates registration data from RegistrationController
	 * <br><br>
	 * @param request HttpServletRequest
	 */
	public static Customer validateRegistration(Customer customer) {
		
		if (customer.validate()) {
			return customer;
		} else {
			return null;
		}
		
	}
	
}
