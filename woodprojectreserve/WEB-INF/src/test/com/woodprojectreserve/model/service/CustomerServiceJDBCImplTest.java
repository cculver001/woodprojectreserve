
package test.com.woodprojectreserve.model.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.woodprojectreserve.model.buisness.exception.ServiceLoadException;
import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.service.customerservice.ICustomerService;
import com.woodprojectreserve.model.service.exception.CustomerException;
import com.woodprojectreserve.model.service.factory.ServiceFactory;
import com.woodprojectreserve.model.service.manager.PropertyManager;

/** <h1>CustomerServiceImplTest</h1>
 * <br>
 * <code>CustomerServiceJDBCImpl</code> JUnit test  
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class CustomerServiceJDBCImplTest {
	
	private static ServiceFactory serviceFactory;
	private static ICustomerService iCustomerService;
	private static PropertyManager propertyManager;

	/** <h1>setUp</h1>
	 * <br>
	 * Builds <code>CustomerServiceJDBCImpl</code> objects that will be under test
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
			iCustomerService = (ICustomerService) serviceFactory.getService(ICustomerService.NAME);
		} catch (ServiceLoadException serviceLoadException) {
			serviceLoadException.printStackTrace();
			fail("ServiceLoadException");
		}
		
	}

	/** <h1>testStoreCustomerHashtable</h1>
	 * Test method for {@link com.woodprojectreserve.model.service.customerservice.CustomerServiceJDBCImpl#storeCustomerHashtable(java.util.Hashtable)}.
	 */
	@Test
	public final void testStoreCustomerHashtable() {
		
		System.out.println("Starting testStoreCustomerHashtable()");
		
		try {
			
			Customer customer1 = new Customer("John", "Doe", 
					"john.doe.001@regis.edu", "john.doe", "password123", 
					"123 Fake Street", null, "Detroit", "MI", "77845", "USA", 
					"1234567890");
			Customer customer2 = new Customer("Jane", "Doe", 
					"jane.doe.001@regis.edu", "jane.doe", "password456", 
					"123 Fake Street", null, "Detroit", "MI", "77845", "USA", 
					"1234567890");
			
			Hashtable<String, Customer> customers = 
					new Hashtable<String, Customer>();
			
			customers.putIfAbsent(customer1.getUsername(), customer1);
			customers.putIfAbsent(customer2.getUsername(), customer2);
			
			assertTrue("Customer not stored", 
					iCustomerService.storeCustomerHashtable(customers));

			System.out.println("PASSED");
			
		} catch (CustomerException customerException) {
			customerException.printStackTrace();
			fail("CustomerException");
		}
		
	}

	/** <h1>testRetrieveCustomerHashtable</h1>
	 * Test method for {@link com.woodprojectreserve.model.service.customerservice.CustomerServiceJDBCImpl#retrieveCustomerHashtable()}.
	 */
	@Test
	public final void testRetrieveCustomerHashtable() {
		
		System.out.println("Starting testRetrieveCustomerHashtable()");
		
		try {
			
			Hashtable<String, Customer> customers = iCustomerService.retrieveCustomerHashtable();
			assertTrue("Not instance of Hashtable<?, ?>", customers instanceof Hashtable<?, ?>);
			
			System.out.println("PASSED");
		
		} catch (CustomerException customerException) {
			customerException.printStackTrace();
			fail("CustomerException");
		}
		
	}
	
	/** <h1>testStoreCustomer</h1>
	 * Test method for {@link com.woodprojectreserve.model.service.customerservice.CustomerServiceJDBCImpl#storeCustomer(com.woodprojectreserve.model.domian.Customer)}.
	 */
	@Test
	public final void testStoreCustomer() {
		
		System.out.println("Starting testStoreCustomer()");
		
		Customer customer1 = new Customer("Jim", "Doe", "jim.doe.001@regis.edu", 
				"jim.doe", "password789", "123 Fake Street", null, "Detroit", 
				"MI", "77845", "USA", "1234567890");
		
		try {
		
			assertTrue("Customer not stored", 
					iCustomerService.storeCustomer(customer1));
			
			System.out.println("PASSED");
		
		} catch (CustomerException customerException) {
			customerException.printStackTrace();
			fail("CustomerException");
		}
		
	}
	
	/** <h1>testRetrieveCustomer</h1>
	 * Test method for {@link com.woodprojectreserve.model.service.customerservice.CustomerServiceJDBCImpl#retrieveCustomer(java.lang.String)}.
	 */
	@Test
	public final void testRetrieveCustomer() {
		
		System.out.println("Starting testRetrieveCustomer()");
		
		Customer customer1 = new Customer("Jesse", "Doe", 
				"jesse.doe.001@regis.edu", "jesse.doe", "password159", 
				"123 Fake Street", null, "Detroit", "MI", "77845", "USA", 
				"1234567890");
		
		try {
			
			if (iCustomerService.storeCustomer(customer1)) {
		
				Customer customer = iCustomerService.retrieveCustomer("jesse.doe");
				assertTrue("Not instance of Customer", customer instanceof Customer);
				
				System.out.println("PASSED");
			
			}
			
		} catch (CustomerException customerException) {
			customerException.printStackTrace();
			fail("CustomerException");
		}
		
	}

}
