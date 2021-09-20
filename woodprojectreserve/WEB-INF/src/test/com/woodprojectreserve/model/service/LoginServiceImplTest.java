package test.com.woodprojectreserve.model.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.woodprojectreserve.model.buisness.exception.ServiceLoadException;
import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.service.customerservice.ICustomerService;
import com.woodprojectreserve.model.service.exception.CustomerException;
import com.woodprojectreserve.model.service.exception.LoginException;
import com.woodprojectreserve.model.service.factory.ServiceFactory;
import com.woodprojectreserve.model.service.loginservice.ILoginService;
import com.woodprojectreserve.model.service.manager.PropertyManager;

/** <h1>LoginServiceImplTest</h1>
 * <br>
 * <code>LoginServiceImplTest</code> JUnit test  
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class LoginServiceImplTest {

	private static ServiceFactory serviceFactory;
	private static ILoginService iLoginService;
	private static PropertyManager propertyManager;
	
	/** <h1>setUp</h1>
	 * <br>
	 * Builds <code>LoginServiceImpl</code> objects that will be under test
	 * <br><br>
	 * @throws Exception - catch all for any errors that might occur during initialization
	 */
	@BeforeAll
	public static void setUp() throws Exception {

		String propertyFileLocation = "config/";
		
		propertyManager = new PropertyManager();
		propertyManager.loadProperties(propertyFileLocation);
		
		serviceFactory = ServiceFactory.getInstance();
		
		try {
			iLoginService = (ILoginService) serviceFactory.getService(ILoginService.NAME);
		} catch (ServiceLoadException serviceLoadException) {
			serviceLoadException.printStackTrace();
			fail("ServiceLoadException");
		}
		
	}

	/**
	 * Test method for {@link com.woodprojectreserve.model.service.loginservice.LoginServiceImpl#authenticateLogin(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAuthenticateLogin() {
		
		System.out.println("Starting testAuthenticateLogin()");
		
		Customer customer = new Customer("John", "Doe", 
				"john.doe.001@regis.edu", "john.doe", "password123", 
				"123 Fake Street", null, "Detroit", "MI", "77845", "USA", 
				"1234567890");
		
		ICustomerService iCustomerService;
		
		try {
			
			iCustomerService = (ICustomerService) serviceFactory.getService(ICustomerService.NAME);
			
			if (iCustomerService.storeCustomer(customer)) {
				
				assertTrue(iLoginService.authenticateLogin(customer.getUsername(), customer.getPassword()));
				
				System.out.println("PASSED");
				
			}
			
		} catch (ServiceLoadException serviceLoadException) {
			System.err.println("testAuthenticateLogin()");
			System.err.println(serviceLoadException.getMessage());
			System.err.println(serviceLoadException);
			fail("ServiceLoadException");
		} catch (LoginException loginException) {
			System.err.println("testAuthenticateLogin()");
			System.err.println(loginException.getMessage());
			System.err.println(loginException);
			fail("LoginException");
		} catch (CustomerException customerException) {
			System.err.println("testAuthenticateLogin()");
			System.err.println(customerException.getMessage());
			System.err.println(customerException);
			fail("CustomerException");
		}
		
		
	}

}
