
package com.woodprojectreserve.model.domian;

import java.io.Serializable;
import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.woodprojectreserve.model.buisness.RegistrationManager;

/** <h1>Customer</h1>
 * <br>
 * <code>Customer</code> object that defines a customer of the WoodProjectReserve application. 
 * Includes <code>Reservation</code> and <code>Address</code> objects.   
 * <br><br>
 * 
 * @version - 9.18.2021
 * @author Christopher Culver
 */
@ManagedBean
@SessionScoped
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String username;
	private String password;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String telephone;
	private Hashtable<Integer, Reservation> reservation;
	
	/** <h1>Customer</h1>
	 * 
	 * <br>
	 * Default constructor
	 * 
	 */
	public Customer() {
	}

	/** <h1>Customer</h1>
	 * 
	 * <br>
	 * Constructor, builds complete <code>Customer</code> Object
	 * <br><br>
	 * @param firstName - first name
	 * @param lastName - last name
	 * @param emailAddress - email address
	 * @param username - username
	 * @param password - password
	 * @param address - object storing <code>Customer Address</code> data
	 * @param reservation - object storing <code>Customer Reservation</code>  data
	 */
	public Customer( 
			String firstName, 
			String lastName, 
			String emailAddress, 
			String username, 
			String password,
			String address1, 
			String address2, 
			String city, 
			String state, 
			String postalCode, 
			String country,
			String telephone, 
			Hashtable<Integer, Reservation> reservation) {
		this.id = generateId(firstName, lastName, username);
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.telephone = telephone;
		this.reservation = reservation;
	}

	/** <h1>Customer</h1>
	 * 
	 * <br>
	 * Constructor, builds <code>Customer</code> object without <code>Reservation</code> object
	 * <br><br>
	 * @param firstName - first name
	 * @param lastName - last name
	 * @param emailAddress - email address
	 * @param username - user name
	 * @param password - password
	 * @param address - object storing <code>Customer Address</code> data
	 */
	public Customer(
			String firstName, 
			String lastName, 
			String emailAddress, 
			String username, 
			String password,
			String address1, 
			String address2, 
			String city, 
			String state, 
			String postalCode, 
			String country,
			String telephone) {
		this.id = generateId(firstName, lastName, username);
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.telephone = telephone;
		this.reservation = new Hashtable<Integer, Reservation>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String firstName, String lastName, String username) {
		this.id = generateId(firstName, lastName, username);
	}
	
	/** <h1>getFirstName</h1>
	 * 
	 * <br>
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/** <h1>setFirstName</h1>
	 * 
	 * <br>
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** <h1>getLastName</h1>
	 * 
	 * <br>
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** <h1>setLastName</h1>
	 * 
	 * <br>
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** <h1>getEmailAddress</h1>
	 * 
	 * <br>
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/** <h1>setEmailAddress</h1>
	 * 
	 * <br>
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/** <h1>getUsername</h1>
	 * 
	 * <br>
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/** <h1>setUsername</h1>
	 * 
	 * <br>
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** <h1>getPassword</h1>
	 * 
	 * <br>
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/** <h1>setPassword</h1>
	 * 
	 * <br>
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** <h1>getReservation</h1>
	 * 
	 * <br>
	 * @return the reservation list
	 */
	public Hashtable<Integer, Reservation> getReservation() {
		return reservation;
	}
	
	/** <h1>getReservation</h1>
	 * 
	 * <br>
	 * @param key <code>int</code> representing a key value
	 * @return the reservation object
	 */
	public Reservation getReservation(int key) {
		return reservation.get(key);
	}

	/** <h1>setReservation</h1>
	 * 
	 * <br>
	 * @param reservation the reservation list to set
	 */
	public void setReservation(Hashtable<Integer, Reservation> reservation) {
		this.reservation = reservation;
	}
	
	/** <h1>addReservation</h1>
	 * 
	 * <br>
	 * @param reservation the reservation to add
	 */
	public void addReservation(Reservation reservation) {
		
		int key = reservation.getId();
		
		if (this.reservation == null) {
			this.reservation = new Hashtable<Integer, Reservation>();
		}
		
		if (this.reservation.containsKey(key)) {
			this.reservation.replace(key, reservation);
		} else {
			this.reservation.put(key, reservation);
		}
		
	}
	
	/** <h1>deleteReservation</h1>
	 * 
	 * <br>
	 * @param key the key value representing the 
	 * 			  <code>Reservation</code> to remove
	 */
	public void deleteReservation(int key) {
		this.reservation.remove(key);
	}
	
	/** <h1>getAddress1</h1>
	 * <br>
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/** <h1>setAddress1</h1>
	 * <br>
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/** <h1>getAddress2</h1>
	 * <br>
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/** <h1>setAddress2</h1>
	 * <br>
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/** <h1>getCity</h1>
	 * <br>
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/** <h1>setCity</h1>
	 * <br>
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/** <h1>getState</h1>
	 * <br>
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/** <h1>setState</h1>
	 * <br>
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/** <h1>getPostalCode</h1>
	 * <br>
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/** <h1>setPostalCode</h1>
	 * <br>
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/** <h1>getCountry</h1>
	 * <br>
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/** <h1>setCountry</h1>
	 * <br>
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/** <h1>getTelephone</h1>
	 * <br>
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/** <h1>setTelephone</h1>
	 * <br>
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/** <h1>authenticate</h1>
	 * <br>
	 * Authenticates <code>Customer</code> object
	 * <br>
	 * <br><br>
	 * 
	 * @return the view
	 */
	public String authenticate() {
		
		this.id = "0";
		this.reservation = new Hashtable<Integer, Reservation>();
		
		if (RegistrationManager.validateRegistration(this)) {
			return "login";
		} else {
			return "error-page";
		}
	}
	
	public String registrationPage() {
		return "registration";
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Customer)) {
			return false;
		}
		
		Customer other = (Customer) obj;
		
		if (address1 == null) {
			
			if (other.address1 != null) {
				return false;
			}
			
		} else if (!address1.equals(other.address1)) {
			return false;
		}
		
		if (address2 == null) {
			
			if (other.address2 != null) {
				return false;
			}
			
		} else if (!address2.equals(other.address2)) {
			return false;
		}
		
		if (city == null) {
			
			if (other.city != null) {
				return false;
			}
			
		} else if (!city.equals(other.city)) {
			return false;
		}
		
		if (country == null) {
			
			if (other.country != null) {
				return false;
			}
			
		} else if (!country.equals(other.country)) {
			return false;
		}
		
		if (id == null) {
			
			if (other.id != null) {
				return false;
			}
			
		} else if (!id.equals(other.id)) {
			return false;
		}
		
		if (postalCode == null) {
			
			if (other.postalCode != null) {
				return false;
			}
			
		} else if (!postalCode.equals(other.postalCode)) {
			return false;
		}
		
		if (state == null) {
			
			if (other.state != null) {
				return false;
			}
			
		} else if (!state.equals(other.state)) {
			return false;
		}
		
		if (telephone == null) {
			
			if (other.telephone != null) {
				return false;
			}
			
		} else if (!telephone.equals(other.telephone)) {
			return false;
		}
		
		if (emailAddress == null) {
		
			if (other.emailAddress != null) {
				return false;
			}
			
		} else if (!emailAddress.equals(other.emailAddress)) {
			return false;
		}
		
		if (firstName == null) {
		
			if (other.firstName != null) {
				return false;
			}
			
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		
		if (id == null) {
		
			if (other.id != null) {
				return false;
			}
			
		} else if (!id.equals(other.id)) {
			return false;
		}
		
		if (lastName == null) {
		
			if (other.lastName != null) {
				return false;
			}
			
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		
		if (password == null) {
		
			if (other.password != null) {
				return false;
			}
			
		} else if (!password.equals(other.password)) {
			return false;
		}
		
		if (reservation == null) {
		
			if (other.reservation != null) {
				return false;
			}
			
		} else if (!reservation.equals(other.reservation)) {
			return false;
		}
		
		if (username == null) {
		
			if (other.username != null) {
				return false;
			}
			
		} else if (!username.equals(other.username)) {
			return false;
		}
		
		return true;
		
	}

	/** <h1>generateId</h1>
	 * 
	 * <br>
	 * Generates a unique ID for the <code>Customer</code> object using 
	 * the <code>Customer</code> firstName, lastName, and username attributes
	 * <br><br>
	 * @param firstName - first name
	 * @param lastName - last name
	 * @param username - username
	 */
	public static String generateId(String firstName, String lastName, String username) {
		
		final int SUB_LENGTH = 3;
		
		//Checks added into pulling substring for names that have a length less than 3 characters
		String firstSub = firstName.substring(0, Math.min(SUB_LENGTH, firstName.length()));
		String lastSub = lastName.substring(0, Math.min(SUB_LENGTH, lastName.length()));
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(firstSub);
		builder.append(".");
		builder.append(lastSub);
		builder.append(".");
		
		/* hashCode can return a negative number
		 * to negate that run the Math.abs() 
		 * method to remove the negative sign
		 */
		builder.append(Math.abs(username.hashCode()));
		
		return builder.toString();
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (lastName != null) {
			builder.append("lastName=");
			builder.append(lastName);
			builder.append(", ");
		}
		if (emailAddress != null) {
			builder.append("emailAddress=");
			builder.append(emailAddress);
			builder.append(", ");
		}
		if (username != null) {
			builder.append("username=");
			builder.append(username);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}
		if (address1 != null) {
			builder.append("address1=");
			builder.append(address1);
			builder.append(", ");
		}
		
		if (address2 != null) {
			builder.append("address2=");
			builder.append(address2);
			builder.append(", ");
		}
		
		if (city != null) {
			builder.append("city=");
			builder.append(city);
			builder.append(", ");
		}
		
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}
		
		if (postalCode != null) {
			builder.append("postalCode=");
			builder.append(postalCode);
			builder.append(", ");
		}
		
		if (country != null) {
			builder.append("country=");
			builder.append(country);
			builder.append(", ");
		}
		
		if (telephone != null) {
			builder.append("telephone=");
			builder.append(telephone);
		}
		if (reservation != null) {
			builder.append("reservation=");
			builder.append(reservation);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
