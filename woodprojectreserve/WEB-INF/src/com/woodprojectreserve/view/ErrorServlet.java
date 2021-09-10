package com.woodprojectreserve.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** <h1>ErrorServlet</h1>
 * <br>
 * <code>ErrorServlet</code> class implements a Error Servlet
 * <br><br>
 * 
 * @version - 9.10.2021
 * @author Christopher Culver
 */
public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String error = (String) session.getAttribute("error");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + error + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + error + "</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
