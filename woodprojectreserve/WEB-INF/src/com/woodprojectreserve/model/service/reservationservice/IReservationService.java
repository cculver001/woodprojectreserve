package com.woodprojectreserve.model.service.reservationservice;

import java.util.Hashtable;

import com.woodprojectreserve.model.domian.Reservation;
import com.woodprojectreserve.model.service.IService;
import com.woodprojectreserve.model.service.exception.ReservationException;

/** <h1>IReservationService</h1>
 * <br>
 * <code>IReservationService</code> class implements a Reservation interface 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public interface IReservationService extends IService {

	public final String NAME = "IReservationService";
	
	public boolean storeReservation(Reservation reservation) throws ReservationException;
	public boolean storeReservationHashtable(Hashtable<Integer, Reservation> reservations) throws ReservationException;
	
	public Hashtable<Integer, Reservation> retrieveReservation(String userId) throws ReservationException;
	public Hashtable<Integer, Reservation> retrieveReservation() throws ReservationException;
	
	public boolean printReservation(Hashtable<Integer, Reservation> reservation) throws ReservationException;
	
}
