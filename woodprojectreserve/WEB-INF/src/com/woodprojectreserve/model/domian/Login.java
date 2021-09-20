package com.woodprojectreserve.model.domian;

import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.woodprojectreserve.model.buisness.LoginManager;

/** <h1>Login</h1>
 * <br>
 * <code>Login</code> object that defines a login of the WoodProjectReserve application.    
 * <br><br>
 * 
 * @version - 9.18.2021
 * @author Christopher Culver
 */
@ManagedBean
@SessionScoped
public class Login {
	
	private String username;
	private String password;
	
	/** <h1>Login</h1>
	 * 
	 * <br>
	 * Default constructor
	 * 
	 */
	public Login() {
	}
	
	/** <h1>Customer</h1>
	 * 
	 * <br>
	 * Constructor, builds complete <code>Customer</code> Object
	 * <br><br>
	 * @param username - username
	 * @param password - password
	 */
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** <h1>authenticate</h1>
	 * <br>
	 * Authenticates <code>Login</code> object
	 * <br>
	 * <br><br>
	 * 
	 * @return the view
	 */
	public String authenticate() {
		
		if (LoginManager.authenticateLogin(this)) {
			return "reservation";
		} else {
			return "error-page";
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
