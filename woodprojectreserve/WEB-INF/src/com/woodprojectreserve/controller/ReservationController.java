
package com.woodprojectreserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.woodprojectreserve.model.buisness.ReservationManager;
import com.woodprojectreserve.model.domian.Reservation;

/** <h1>ReservationController</h1>
 * <br>
 * <code>ReservationController</code> class implements a Reservation Controller 
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class ReservationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String source = request.getParameter("action");
		
		if (source.equals("submit")) {
			
			Reservation reservation = getReservation(request);
			
			reservation = ReservationManager.validateReservation(reservation);
			
			HttpSession session = request.getSession();
			
			if (reservation != null) {
				
				String output = "<h1>Reservation Complete</h1><p>" 
						+ reservation.toString() + "</p>";
				
				session.setAttribute("output", output);
				
				getServletContext().getRequestDispatcher("/home")
					.forward(request, response);
				
			} else {
				
				session.setAttribute("error", "Reservation Failure");
				
				getServletContext().getRequestDispatcher("/error")
					.forward(request, response);
				
			}
			
		}
		
	}
	
	/** <h1>getReservation</h1>
	 * <br>
	 * Pulls reservation data from HttpServletRequest
	 * <br><br>
	 * @param request HttpServletRequest
	 */
	private Reservation getReservation(HttpServletRequest request) {
		
		//Place holder till link with Customer object
		int id = 0;
		String userId = "id";
		
		String name = request.getParameter("name");
		String material = request.getParameter("material");
		String woodMain = request.getParameter("woodMain");
		String woodSecondary = request.getParameter("woodSecondary");
		String finishType = request.getParameter("finishType");
		String completionDate = request.getParameter("completionDate");
		String detail = request.getParameter("detail");
		boolean active = false;
		String comment = request.getParameter("comment");
		
		return new Reservation(id, userId, name, material, woodMain, 
				woodSecondary, finishType, completionDate, detail, active, 
				comment);
		
	}
	
}
