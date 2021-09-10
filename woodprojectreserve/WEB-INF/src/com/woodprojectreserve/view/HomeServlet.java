
package com.woodprojectreserve.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** <h1>HomeServlet</h1>
 * <br>
 * <code>HomeServlet</code> class implements a Home Servlet
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String output = (String) session.getAttribute("output");
		
		output(request, response, output);
		
	}
	
	/** <h1>output</h1>
	 * <br>
	 * Confirms the reservation input by displaying a simple 
	 * <code>Complete</code> page to the user. 
	 * @param response - HttpServletResponse
	 * @param reservation - Reservation
	 * @throws IOException
	 */
	private void output(HttpServletRequest request, 
			HttpServletResponse response, String output) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Wood Project Reserve Home</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(output);
		out.println("</body>");
		out.println("</html>");
		
	}

}
