
package com.woodprojectreserve.model.buisness;

import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.domian.Login;

/** <h1>LoginManager</h1>
 * <br>
 * <code>LoginManager</code> class implements a Login Manager 
 * <br><br>
 * 
 * @version - 9.9.2021
 * @author Christopher Culver
 */
public class LoginManager {
	
	/** <h1>authenticateLogin</h1>
	 * <br> 
	 * Authenticates username and password fields from <code>login.html</code> 
	 * form.
	 * <br><br>
	 * @param login Login
	 */
	public static Customer authenticateLogin(Login login) {
		
		Customer customer = null;
		
		if (login.validate()) {
			
			customer = new Customer();
			
			customer.setUsername(login.getUsername());
			customer.setPassword(login.getPassword());
			
			return customer;
			
		} else {
			return null;
		}
		
	}
	
}
