package com.woodprojectreserve.model.service.customerservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.service.exception.CustomerException;
import com.woodprojectreserve.model.service.manager.PropertyManager;

/** <h1>CustomerServiceJDBCImpl</h1>
 * <br>
 * <code>CustomerServiceJDBCImpl</code> class implements a Customer Service 
 * <br><br>
 * 
 * @version - 9.7.2020
 * @author Christopher Culver
 */
public class CustomerServiceJDBCImpl implements ICustomerService {
	
	/** <h1>storeCustomerHashtable</h1>
	 * 
	 * <br>
	 * Stores <code>Customer</code> object <code>Hashtable</code>
	 * <br><br>
	 * @param customers <code>Customer</code> object <code>Hashtable</code> to be stored
	 * @return boolean
	 * @throws CustomerException <code>IOException</code> if issues occur on writing to 
	 * 							 Customer.out file
	 */
	@Override
	public boolean storeCustomerHashtable(Hashtable<String, Customer> customers) throws CustomerException {
		
		boolean result = false;
		
		if (customers != null) {
			
			Set<String> keys = customers.keySet();
			
			for (String key : keys) {
				result = runStatement("INSERT", customers.get(key));
			}
			
		}
		
		return result;
		
	}
	
	/** <h1>storeCustomer</h1>
	 * 
	 * <br>
	 * Stores <code>Customer</code> object 
	 * <br><br>
	 * @param customer <code>Customer</code> object to be stored
	 * @return boolean
	 * @throws CustomerException <code>CustomerException</code> if issues occur on writing to 
	 * 							 Customer.out file
	 */
	@Override
	public boolean storeCustomer(Customer customer) throws CustomerException {
		return runStatement("INSERT", customer);
	}

	/** <h1>retrieveCustomerHashtable</h1>
	 * 
	 * <br>
	 * Retrieves <code>Customer</code> object <code>Hashtable</code>
	 * <br><br>
	 * @return <code>Hashtable</code> of <code>Customer</code> objects
	 * @throws CustomerException <code>IOException</code> if issues occur on writing to 
	 * 							 Customer.out file
	 */
	@Override
	public Hashtable<String, Customer> retrieveCustomerHashtable() throws CustomerException {
		return runStatement();
	}
	
	/** <h1>retrieveCustomer</h1>
	 * 
	 * <br>
	 * Retrieves <code>Customer</code> object given a username. The local variable 
	 * <code>customerHashtable</code> is checked first for requested <code>Customer</code> 
	 * object. If it does not exist in the current <code>Hashtable</code> then the 
	 * Customer.out file is loaded and checked. 
	 * <br><br>
	 * @param username <code>String</code> representing a <code>Customer</code> username
	 * @return Customer <code>Customer</code> object
	 * @throws CustomerException <code>IOException</code> if issues occur on writing to 
	 * 							 Customer.out file
	 */
	@Override
	public Customer retrieveCustomer(String username) throws CustomerException {

		Hashtable<String, Customer> customers = runStatement();
		Customer customer = null;
		
		Set<String> keys = customers.keySet();
		
		for (String key : keys) {
			
			customer = customers.get(key);
			
			if (customer.getUsername().equals(username)) {
				break;
			}
			
		}
		
		return customer;
		
	}
	
	/** <h1>getConnection</h1>
	 * 
	 * <br>
	 * Retrieves <code>JDBC</code> connection
	 * <br><br>
	 * 
	 * @return Connection
	 * 
	 */
	private Connection getConnection() {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		
		try {
			
			Context initalContext = new InitialContext();
			Context envContext = (Context) initalContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/woodprojectreserve");
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Customer");
			
		} catch (SQLException sqlException) {
			System.err.println("SQLException - CustomerServiceJDBCImpl::getConnection "
					+ "- Could not load and register JDBC driver or connect to databse.");
			System.err.println(sqlException.getMessage());
			System.err.println(sqlException);
		} catch (NamingException namingException) {
			System.err.println("NamingException - CustomerServiceJDBCImpl::getConnection");
			System.err.println(namingException.getMessage());
			System.err.println(namingException);
		} finally {
			
			try {
				
				if (resultSet != null) {
					resultSet.close();	
				}
				
				if (statement != null) {
					statement.close();
				}
				
			} catch (SQLException sqlException) {
				System.err.println("SQLException - CustomerServiceJDBCImpl::getConnection "
						+ "- Could not close ResultSet connection to databse.");
				System.err.println(sqlException.getMessage());
				System.err.println(sqlException);
			}
			
		}
		
		return connection;
		
	}
	
	/** <h1>runStatement</h1>
	 * 
	 * <br>
	 * Runs <code>JDBC</code> statement
	 * <br><br>
	 * 
	 * @param type <code>String</code> identifying the SQL statment type
	 * @param customer <code>Address</code> object to be stored
	 * @throws CustomerException <code>Exception</code> if issues occur on writing to 
	 * 							JDBC customer table
	 */
	private boolean runStatement(String type, Customer customer) throws CustomerException {
		
		boolean result = false;
		
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		String sql = null;
		
		final String SELECT_SPECIFIC = PropertyManager.getPropertyValue("Customer.SelectSpecific");
		final String UPDATE = PropertyManager.getPropertyValue("Customer.Update");
		final String INSERT = PropertyManager.getPropertyValue("Customer.Insert");
		
		connection = getConnection();
		
		try {
			
			switch (type) {
				case "INSERT":
					
					//Need to check to see if the insert Address object already exeists in the database
					preparedStatement = connection.prepareStatement(SELECT_SPECIFIC);
					
					preparedStatement.setString(1, customer.getId());
					
					resultSet = preparedStatement.executeQuery();
					
					//If we find the primary key, UPDATE the database, else INSERT the object data
					if (resultSet.next()) {
						sql = UPDATE;
					} else {
						sql = INSERT;
					}
					
					preparedStatement.close();
					
					break;
				case "UPDATE":
					sql = UPDATE;
					break;
			}
			
			preparedStatement = connection.prepareStatement(sql);
			
			int index = 1;
			
			if (sql.equals(INSERT)) {
				preparedStatement.setString(index++, customer.getId());
			}
			
			preparedStatement.setString(index++, customer.getFirstName());
			preparedStatement.setString(index++, customer.getLastName());
			preparedStatement.setString(index++, customer.getEmailAddress());
			preparedStatement.setString(index++, customer.getUsername());
			preparedStatement.setString(index++, customer.getPassword());
			preparedStatement.setString(index++, customer.getAddress1());
			preparedStatement.setString(index++, customer.getAddress2());
			preparedStatement.setString(index++, customer.getCity());
			preparedStatement.setString(index++, customer.getState());
			preparedStatement.setString(index++, customer.getPostalCode());
			preparedStatement.setString(index++, customer.getCountry());
			preparedStatement.setString(index++, customer.getTelephone());
			
			if (sql.equals(UPDATE)) {
				preparedStatement.setString(index++, customer.getId());
			}
			
			preparedStatement.executeUpdate();
			
			result = true;
			
		} catch (SQLException sqlException) {
			throw new CustomerException(sqlException.toString(), sqlException);		
		} finally {
			
			try {
				
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			
			} catch (SQLException sqlException) {
				throw new CustomerException(sqlException.toString(), sqlException);
			}
			
		}
		
		return result;
		
	}
	
	/** <h1>runStatement</h1>
	 * 
	 * <br>
	 * Runs <code>JDBC</code> statement
	 * <br><br>
	 * 
	 * @param type <code>String</code> identifying the SQL statment type
	 * @param customer <code>Reservation</code> object to be stored
	 * @throws CustomerException <code>Exception</code> if issues occur on writing to 
	 * 							JDBC customer table
	 */
	private Hashtable<String, Customer> runStatement() throws CustomerException {
		
		Hashtable<String, Customer> customers = new Hashtable<String, Customer>();
		Customer customer = null;
		
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		String sql = null;
		
		connection = getConnection();
		
		try {
			
			sql = PropertyManager.getPropertyValue("Customer.SelectAll");
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				customer = new Customer();
				
				customer.setId(resultSet.getString("id"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmailAddress(resultSet.getString("emailAddress"));
				customer.setUsername(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("password"));
				customer.setAddress1(resultSet.getString("address1"));
				customer.setAddress2(resultSet.getString("address2"));
				customer.setCity(resultSet.getString("city"));
				customer.setState(resultSet.getString("state"));
				customer.setPostalCode(resultSet.getString("postalCode"));
				customer.setCountry(resultSet.getString("country"));
				customer.setTelephone(resultSet.getString("telephone"));
				
				customers.put(customer.getId(), customer);
				
			}
			
		} catch (SQLException sqlException) {
			throw new CustomerException(sqlException.toString(), sqlException);
		} finally {
			
			try {
				
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			
			} catch (SQLException sqlException) {
				throw new CustomerException(sqlException.toString(), sqlException);
			}
			
		}
		
		return customers;
		
	}
	
}
