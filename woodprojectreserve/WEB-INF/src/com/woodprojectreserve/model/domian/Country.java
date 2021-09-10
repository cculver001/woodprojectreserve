
package com.woodprojectreserve.model.domian;

/** <h1>Country</h1>
 * <br>
 * <code>Country</code> object that defines an <code>Country</code> for 
 * <code>Customer</code> registration 
 * <br><br>
 * 
 * @version - 9.5.2021
 * @author Christopher Culver
 */
public class Country implements Comparable<Country> {

	private String code;
	private String name;
	
	/**  <h1>Country</h1>
	 * 
	 * <br>
	 * Constructor, builds complete <code>Country</code> Object
	 * <br><br>
	 * 
	 * @param code <code>String</code> country code
	 * @param name <code>String</code> country name
	 */
	public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
 
	/** <h1>getCode</h1>
	 * <br>
	 * @return the address1
	 */
    public String getCode() {
        return code;
    }
 
    /** <h1>setCode</h1>
	 * <br>
	 * @param code the code to set
	 */
    public void setCode(String code) {
        this.code = code;
    }
 
    /** <h1>getName</h1>
	 * <br>
	 * @return the name
	 */
    public String getName() {
        return name;
    }
 
    /** <h1>setName</h1>
	 * <br>
	 * @param name the name to set
	 */
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return this.name;
    }
 
    @Override
    public int compareTo(Country anotherCountry) {
        return this.name.compareTo(anotherCountry.getName());
    }

}