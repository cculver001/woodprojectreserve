package test.com.woodprojectreserve.model.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Hashtable;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.woodprojectreserve.model.buisness.exception.ServiceLoadException;
import com.woodprojectreserve.model.domian.Reservation;
import com.woodprojectreserve.model.service.exception.ReservationException;
import com.woodprojectreserve.model.service.factory.ServiceFactory;
import com.woodprojectreserve.model.service.manager.PropertyManager;
import com.woodprojectreserve.model.service.reservationservice.IReservationService;

/** <h1>ReservationServiceImplTest</h1>
 * <br>
 * <code>ReservationServiceImplTest</code> JUnit test  
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class ReservationServiceImplTest {

	private static ServiceFactory serviceFactory;
	private static IReservationService iReservationService;
	private static PropertyManager propertyManager;
	
	/** <h1>setUp</h1>
	 * <br>
	 * Builds <code>ReservationServiceJDBCImpl</code> objects that will be under test
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
			iReservationService = (IReservationService) serviceFactory.getService(IReservationService.NAME);
		} catch (ServiceLoadException serviceLoadException) {
			serviceLoadException.printStackTrace();
			fail("ServiceLoadException");
		}
		
	}

	/** <h1>testStoreReservation</h1>
	 * Test method for {@link com.woodprojectreserve.model.service.reservationservice.ReservationServiceJDBCImpl#storeReservation(com.woodprojectreserve.model.domian.Reservation)}.
	 */
	@Test
	public final void testStoreReservation() {

		System.out.println("Starting testStoreReservation()");
		
		Reservation reservation = new Reservation(0, "test123", "Maple Dinner Table", "Hard Wood", "Maple", "None", "Polyurethane", "1/1/2020", "Family Style Table");
		
		try {
			
			assertTrue("Reservation not stored", iReservationService.storeReservation(reservation));
			
			System.out.println("PASSED");
			
		} catch (ReservationException reservationException) {
			reservationException.printStackTrace();
			fail("ReservationException");
		}
		
	}

	/** <h1>testRetrieveReservation</h1>
	 * Test method for {@link com.woodprojectreserve.model.service.reservationservice.ReservationServiceJDBCImpl#retrieveReservation()}.
	 */
	@Test
	public final void testRetrieveReservation() {

		System.out.println("Starting testRetrieveReservation()");
		
		try {
		
			Hashtable<Integer, Reservation> reservation = iReservationService.retrieveReservation("test123");
			assertTrue("Not instance of Reservation", reservation instanceof Hashtable<?, ?>);
			
			System.out.println("PASSED");
			
		} catch (ReservationException reservationException) {
			reservationException.printStackTrace();
			fail("ReservationException");
		}
		
	}

}
