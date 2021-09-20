package com.woodprojectreserve.model.service.loginservice;

import com.woodprojectreserve.model.buisness.exception.ServiceLoadException;
import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.service.customerservice.ICustomerService;
import com.woodprojectreserve.model.service.exception.CustomerException;
import com.woodprojectreserve.model.service.exception.LoginException;
import com.woodprojectreserve.model.service.factory.ServiceFactory;

/** <h1>LoginServiceImpl</h1>
 * <br>
 * <code>LoginServiceImpl</code> class implements a Login Service 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class LoginServiceJDBCImpl implements ILoginService {

private ServiceFactory serviceFactory = ServiceFactory.getInstance();
	
	/** <h1>authenticateLogin</h1>
	 * 
	 * <br>
	 * Authenticates login attempt with username and password variables passed. 
	 * Checks username and password against <code>Hashtable</code> of 
	 * <code>Customer</code> objects for valid login.
	 * <br><br>
	 * @param username Login attempt username
	 * @param password Login attempt password
	 * @return boolean
	 */
	@Override
	public boolean authenticateLogin(String username, String password) throws LoginException {
		
		boolean result = false;
		
		ICustomerService iCustomerService;
		
		try {
			
			iCustomerService = (ICustomerService) serviceFactory.getService(ICustomerService.NAME);
			
			Customer customer = iCustomerService.retrieveCustomer(username);
			
			if (customer != null) {
				result = customer.getPassword().equals(password);
			}
			
		} catch (ServiceLoadException serviceLoadException) {
			throw new LoginException(serviceLoadException.toString(), serviceLoadException);
		} catch (CustomerException customerException) {
			throw new LoginException(customerException.toString(), customerException);
		}
		
		return result;
		
	}
	
}
