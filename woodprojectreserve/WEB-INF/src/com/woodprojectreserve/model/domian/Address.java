
package com.woodprojectreserve.model.domian;

import java.io.Serializable;

/** <h1>Address</h1>
 * <br>
 * <code>Address</code> object that defines an <code>Address</code> within WoodProjectReserve application. 
 * <br><br>
 * 
 * @version - 9.5.2021
 * @author Christopher Culver
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String telephone;
	
	/** <h1>Address</h1>
	 * 
	 * <br>
	 * Default constructor for the <code>Address</code> object
	 * 
	 */
	public Address() {
	}

	/** <h1>Address</h1>
	 * 
	 * <br>
	 * Constructor, builds complete <code>Address</code> Object
	 * <br><br>
	 * 
	 * @param address1 - first address line
	 * @param address2 - second address line
	 * @param city - city
	 * @param state - state
	 * @param postalCode - zipcode/postal code
	 * @param country - country
	 * @param telephone - phone number
	 */
	public Address(
			String id,
			String address1, 
			String address2, 
			String city, 
			String state, 
			String postalCode, 
			String country,
			String telephone) {
		this.id = id;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.telephone = telephone;
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
	
	/** <h1>validate</h1>
	 * <br>
	 * Validates <code>Address</code> object by checking for null values
	 * <br>
	 * <b>Note:</b> Attribute <code>address2</code> can be null.
	 * <br><br>
	 * 
	 * @return the validation
	 */
	public boolean validate() {
		
		if (id == null
				|| id.length() == 0) {
			return false;
		}
		
		if (address1 == null 
				|| address1.length() == 0) {
			return false;
		}
		
		if (city == null
				|| city.length() == 0) {
			return false;
		}
		
		if (state == null 
				|| state.length() == 0) {
			return false;
		}
		
		if (postalCode == null 
				|| postalCode.length() == 0) {
			return false;
		}
		
		if (country == null
				|| country.length() == 0) {
			return false;
		}
		
		if (telephone == null 
				|| telephone.length() == 0) {
			return false;
		}
		
		return true;
		
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
		
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Address)) {
			return false;
		}
		
		Address other = (Address) obj;
		
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
		
		return true;
		
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Address [");
		
		if (id != null) {
			builder.append("id=");
			builder.append(id);
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
		
		builder.append("]");
		
		return builder.toString();
		
	}
	
}