
package com.woodprojectreserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.woodprojectreserve.model.buisness.RegistrationManager;
import com.woodprojectreserve.model.domian.Customer;

/** <h1>RegistrationController</h1>
 * <br>
 * <code>RegistrationController</code> class implements a R Controller 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String source = request.getParameter("action");
		
		if (source.equals("submit")) {
			
			Customer customer = getCustomer(request);
			
			HttpSession session = request.getSession();
			
			if (RegistrationManager.validateRegistration(customer)) {

				String output = "<h1>Registration Complete</h1><p>" 
						+ customer.toString() + "</p>";
				
				session.setAttribute("output", output);
				
				getServletContext().getRequestDispatcher("/home")
					.forward(request, response);
				
			} else {
				
				session.setAttribute("error", "Registration Failure");
				
				getServletContext().getRequestDispatcher("/error")
					.forward(request, response);
				
			}
			
		}
		
	}
	
	/** <h1>getCustomer</h1>
	 * <br>
	 * Pulls customer data from HttpServletRequest
	 * <br><br>
	 * @param request HttpServletRequest
	 */
	private Customer getCustomer(HttpServletRequest request) {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		String telephone = request.getParameter("telephone");
		
		Customer customer = new Customer(firstName, lastName, emailAddress, 
				username, password, address1, address2, city, state, postalCode,
				country, telephone);
		
		return customer;
		
	}
	
}
