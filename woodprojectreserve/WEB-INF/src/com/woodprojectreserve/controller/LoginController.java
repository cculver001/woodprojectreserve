
package com.woodprojectreserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.woodprojectreserve.model.buisness.LoginManager;
import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.domian.Login;

/** <h1>LoginController</h1>
 * <br>
 * <code>LoginController</code> class implements a Login Controller 
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Login login = new Login(username, password);
		
		String source = request.getParameter("action");
		
		if (source.equals("login")) {
			
			Customer customer = LoginManager.authenticateLogin(login);
			
			HttpSession session = request.getSession();
			
			if (customer != null) {
				
				String output = "<h1>Welcome</h1><p>" + customer.toString() + "</p>";
				
				session.setAttribute("output", output);
				
				getServletContext().getRequestDispatcher("/home")
					.forward(request, response);
				
			} else  {
				
				session.setAttribute("error", "Login Failure");
				
				getServletContext().getRequestDispatcher("/error")
					.forward(request, response);
				
			}
			
		}
		
	}
	
}
