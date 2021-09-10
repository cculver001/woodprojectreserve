
package test.com.woodprojectreserve.model.buisness;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.woodprojectreserve.model.buisness.LoginManager;
import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.domian.Login;

/** <h1>LoginManagerTest</h1>
 * <br>
 * <code>LoginManagerTest</code> class implements a Login Manager Test
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class LoginManagerTest {
	
	private static Login login1;
	private static Login login2;
	private static Login login3;
	private static Login login4;

	/** <h1>setUpBeforeClass</h1>
	 * <br>
	 * <code>setUpBeforeClass</code> class implements the test setup
	 * <br><br>
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
		login1 = new Login("username", "password");
		
		//Zero Length Username
		login2 = new Login("", "password");
		
		//Zero Length Password
		login3 = new Login("username", "");
		
		//Null Values
		login4 = new Login();
		
	}

	@Test
	public void testValidLogin() {
		
		System.out.println("Starting testValidLogin()");
		
		Customer customer = LoginManager.authenticateLogin(login1);
		
		assertNotNull("Authentication Failed", customer);
		
		System.out.println("testValidLogin() \t\t\tPASSED");
		
	}
	
	@Test
	public void testInvalidLogin() {
		
		System.out.println("Starting testInvalidLogin()");
		
		System.out.print("\tTesting Zero Length Username...");
		
		Customer customer = LoginManager.authenticateLogin(login2);
		
		assertNull("Authentication Failed", customer);
		
		System.out.println("\tPASSED");
		
		System.out.print("\tTesting Zero Length Password...");
		
		customer = LoginManager.authenticateLogin(login3);
		
		assertNull("Authentication Failed", customer);
		
		System.out.println("\tPASSED");
		
		System.out.print("\tTesting Null Values...");
		
		customer = LoginManager.authenticateLogin(login4);
		
		assertNull("Authentication Failed", customer);
		
		System.out.println("\t\tPASSED");
		
		System.out.println("testInvalidLogin() \t\t\tPASSED");
		
	}

}
