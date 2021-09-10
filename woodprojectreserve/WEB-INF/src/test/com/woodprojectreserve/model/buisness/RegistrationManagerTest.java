
package test.com.woodprojectreserve.model.buisness;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Hashtable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.woodprojectreserve.model.buisness.RegistrationManager;
import com.woodprojectreserve.model.domian.Address;
import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.domian.Reservation;

/** <h1>RegistrationManagerTest</h1>
 * <br>
 * <code>RegistrationManagerTest</code> class implements a Registration Manager 
 * Test
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class RegistrationManagerTest {
	
	private static Customer customer1;
	private static Customer customer2;
	private static Customer customer3;
	private static Customer customer4;
	
	private static Address address;

	/** <h1>setUpBeforeClass</h1>
	 * <br>
	 * <code>setUpBeforeClass</code> class implements the test setup
	 * <br><br>
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
		address = new Address("id", "123 Street", "", "Cityton", "Statesville", 
				"12345", "Country", "1234567890");
		
		customer1 = new Customer("John", "Doe", "jdoe@email.com", "john.doe", 
				"password", address);
		
		//Invalid Customer
		customer2 = new Customer();
		customer2.setAddress(address);
		customer2.setReservation(new Hashtable<Integer, Reservation>());
		
		//Invalid Address
		customer3 = new Customer("Jane", "Doe", "jdoe@email.com", "jane.doe", 
				"password");
		
		//Invalid Reservation
		customer4 = new Customer("Jimmy", "Doe", "jdoe@email.com", "jimmy.doe", 
				"password", address, null);
		
	}

	@Test
	public void testValidRegistration() {

		System.out.println("Starting testValidRegistration()");
		
		Customer customer = RegistrationManager.validateRegistration(customer1);
		
		assertNotNull("Validation Failed", customer);
		
		System.out.println("testValidRegistration() \t\t\tPASSED");
		
	}
	
	@Test
	public void testInvalidRegistration() {

		System.out.println("Starting testInvalidRegistration()");
		
		System.out.print("\tTesting Invalid Customer...");
		
		Customer customer = RegistrationManager.validateRegistration(customer2);
		
		assertNull("Validation Failed", customer);
		
		System.out.println("\tPASSED");
		
		System.out.print("\tTesting Invalid Address...");
		
		customer = RegistrationManager.validateRegistration(customer3);
		
		assertNull("Validation Failed", customer);
		
		System.out.println("\tPASSED");
		
		System.out.print("\tTesting Invalid Reservation...");
		
		customer = RegistrationManager.validateRegistration(customer4);
		
		assertNull("Validation Failed", customer);
		
		System.out.println("\tPASSED");
		
		System.out.println("testInvalidRegistration() \t\tPASSED");
		
	}

}
