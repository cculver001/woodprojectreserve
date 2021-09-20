
package com.woodprojectreserve.model.buisness;

import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.domian.Login;

/** <h1>LoginManager</h1>
 * <br>
 * <code>LoginManager</code> class implements a Login Manager 
 * <br><br>
 * 
 * @version - 9.18.2021
 * @author Christopher Culver
 */
public class LoginManager {
	
	/** <h1>getCustomer</h1>
	 * <br> 
	 * Retrieves <code>Customer</code> object from <code>login</code> 
	 * object
	 * <br><br>
	 * @param login Login
	 */
	public static Customer getCustomer(Login login) {
		
		Customer customer = new Customer();
			
		customer.setUsername(login.getUsername());
		customer.setPassword(login.getPassword());
		
		return customer;
		
	}
	
	/** <h1>authenticateLogin</h1>
	 * <br> 
	 * Authenticates username and password fields from <code>login.html</code> 
	 * form.
	 * <br><br>
	 * @param login Login
	 */
	public static boolean authenticateLogin(Login login) {
		
		String username = login.getUsername();
		String password = login.getPassword();
		
		if (username == null
				|| username.length() == 0) {
			return false;
		}
		
		if (password == null 
				|| password.length() == 0) {
			return false;
		}
		
		return true;
		
	}
	
}
