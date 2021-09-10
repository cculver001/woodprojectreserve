
package test.com.woodprojectreserve.model.buisness;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.woodprojectreserve.model.buisness.ReservationManager;
import com.woodprojectreserve.model.domian.Reservation;

/** <h1>ReservationManagerTest</h1>
 * <br>
 * <code>ReservationManagerTest</code> class implements a Reservation Manager 
 * Test
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class ReservationManagerTest {
	
	private static Reservation reservation1;
	private static Reservation reservation2;

	/** <h1>setUpBeforeClass</h1>
	 * <br>
	 * <code>setUpBeforeClass</code> class implements the test setup
	 * <br><br>
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
		reservation1 = new Reservation(0, "id", "name", "material", "wood", 
				"woodSecondary", "finishy", "date", "detail");
		
		//Invalid Reservation
		reservation2 = new Reservation();
		
	}

	@Test
	public void testValidReservation() {

		System.out.println("Starting testValidReservation()");
		
		Reservation reservation = ReservationManager
				.validateReservation(reservation1);
		
		assertNotNull("Validation Failed", reservation);
		
		System.out.println("testValidReservation() \t\t\tPASSED");
		
	}
	
	@Test
	public void testInvalidReservation() {
		
		System.out.println("Starting testInvalidReservation()");
		
		Reservation reservation = ReservationManager
				.validateReservation(reservation2);
		
		assertNull("Validation Failed", reservation);
		
		System.out.println("testInvalidReservation() \t\t\tPASSED");
		
	}

}
