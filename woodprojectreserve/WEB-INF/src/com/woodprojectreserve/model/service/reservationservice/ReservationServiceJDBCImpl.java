package com.woodprojectreserve.model.service.reservationservice;

import java.io.FileWriter;
import java.io.IOException;
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

import com.woodprojectreserve.model.domian.Reservation;
import com.woodprojectreserve.model.service.exception.ReservationException;
import com.woodprojectreserve.model.service.manager.PropertyManager;

/** <h1>ReservationServiceJDBCImpl</h1>
 * <br>
 * <code>ReservationServiceJDBCImpl</code> class implements a Reservation Service 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
public class ReservationServiceJDBCImpl implements IReservationService {
	
	/** <h1>storeReservation</h1>
	 * 
	 * <br>
	 * Stores <code>Reservation</code> object
	 * <br><br>
	 * @param reservation <code>Reservation</code> object to be stored
	 * @return boolean
	 * @throws ReservationException <code>Exception</code> if issues occur on writing to 
	 * 								JDBC reservation table
	 */
	@Override
	public boolean storeReservation(Reservation reservation) throws ReservationException {
		return runStatement("INSERT", reservation);
	}
	
	/** <h1>storeReservationHashtable</h1>
	 * 
	 * <br>
	 * Stores <code>Reservation Hashtable</code> object
	 * <br><br>
	 * @param reservation <code>Reservation</code> object to be stored
	 * @return boolean
	 * @throws ReservationException <code>Exception</code> if issues occur on writing to 
	 * 								JDBC reservation table
	 */
	@Override
	public boolean storeReservationHashtable(Hashtable<Integer, Reservation> reservations) throws ReservationException {
		
		Boolean result = false;
		
		Set<Integer> keys = reservations.keySet();
		
		for (int key : keys) {
			result = runStatement("INSERT", reservations.get(key));
		}
		
		return result;
		
	}

	/** <h1>retrieveReservation</h1>
	 * 
	 * <br>
	 * Retrieves <code>Reservation</code> object
	 * <br><br>
	 * @return Reservation
	 * @throws ReservationException <code>Exception</code> if issues occur on writing to 
	 * 								JDBC reservation table
	 */
	@Override
	public Hashtable<Integer, Reservation> retrieveReservation(String userId) throws ReservationException {
		return runStatement(userId);
	}
	
	/** <h1>retrieveReservation</h1>
	 * 
	 * <br>
	 * Retrieves <code>Reservation</code> object
	 * <br><br>
	 * @return Hashtable<String, Reservation>
	 * @throws ReservationException <code>Exception</code> if issues occur on writing to 
	 * 								JDBC reservation table
	 */
	@Override
	public Hashtable<Integer, Reservation> retrieveReservation() throws ReservationException {
		return runStatement();
	}

	/** <h1>printReservation</h1>
	 * <br>
	 * Prints out the <code>Hashtable</code> to a text file
	 * <br><br>
	 * @param reservation <code>Hashtable</code> to be printed
	 */
	@Override
	public boolean printReservation(Hashtable<Integer, Reservation> reservation) throws ReservationException {
		
		boolean result = false;
		
		try {
			
			FileWriter fileWriter = new FileWriter("reservations.txt");
			
			fileWriter.write(reservation.toString());
			
			fileWriter.close();
			
			result = true;
			
		} catch (IOException ioException) {
			throw new ReservationException(ioException.toString(), ioException, "ReservationException", "printReservation");
		}
		
		return result;
		
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
			resultSet = statement.executeQuery("SELECT * FROM Reservation");
			
		} catch (SQLException sqlException) {
			System.err.println("SQLException - ReservationServiceJDBCImpl::getConnection "
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
				System.err.println("SQLException - ReservationServiceJDBCImpl::getConnection "
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
	 * @param reservation <code>Reservation</code> object to be stored
	 * @throws ReservationException <code>Exception</code> if issues occur on writing to 
	 * 							JDBC reservation table
	 */
	private Boolean runStatement(String type, Reservation reservation) throws ReservationException {
		
		Boolean result = false;
		
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		String sql = null;
		
		String SELECT_SPECIFIC = null;
		String UPDATE = null;
		String INSERT = null;
		
		try {

			SELECT_SPECIFIC = PropertyManager.getPropertyValue("Reservation.SelectSpecific");
			UPDATE = PropertyManager.getPropertyValue("Reservation.Update");
			INSERT = PropertyManager.getPropertyValue("Reservation.Insert");
			
			connection = getConnection();
			
			switch (type) {
				case "INSERT":
					
					//Need to check to see if the insert Address object already exeists in the database
					preparedStatement = connection.prepareStatement(SELECT_SPECIFIC);
					
					int index = 1;
					
					preparedStatement.setInt(index++, reservation.getId());
					preparedStatement.setString(index++, reservation.getUserId());
					
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
				preparedStatement.setInt(index++, reservation.getId());
				preparedStatement.setString(index++, reservation.getUserId());
			}
			
			preparedStatement.setString(index++, reservation.getName());
			preparedStatement.setString(index++, reservation.getMaterial());
			preparedStatement.setString(index++, reservation.getWoodMain());
			preparedStatement.setString(index++, reservation.getWoodSecondary());
			preparedStatement.setString(index++, reservation.getFinishType());
			preparedStatement.setString(index++, reservation.getCompletionDate());
			preparedStatement.setString(index++, reservation.getDetail());
			preparedStatement.setBoolean(index++, reservation.isActive());
			preparedStatement.setString(index++, reservation.getComment());
			
			if (sql.equals(UPDATE)) {
				preparedStatement.setInt(index++, reservation.getId());
				preparedStatement.setString(index++, reservation.getUserId());
			}
			
			preparedStatement.executeUpdate();
			
			result = true;
			
		} catch (SQLException sqlException) {
			throw new ReservationException(sqlException.toString(), sqlException);
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
				throw new ReservationException(sqlException.toString(), sqlException);
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
	 * @throws ReservationException <code>Exception</code> if issues occur on writing to 
	 * 							JDBC reservation table
	 */
	private Hashtable<Integer, Reservation> runStatement() throws ReservationException {
		
		Hashtable<Integer, Reservation> reservations = new Hashtable<Integer, Reservation>();
		Reservation reservation = null;
		
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		String sql = null;
		
		connection = getConnection();
		
		try {
			
			sql = PropertyManager.getPropertyValue("Reservation.SelectAll");
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				reservation = new Reservation();
				
				reservation.setId(resultSet.getInt("id"));
				reservation.setUserId(resultSet.getString("userId"));
				reservation.setName(resultSet.getString("name"));
				reservation.setMaterial(resultSet.getString("material"));
				reservation.setWoodMain(resultSet.getString("woodMain"));
				reservation.setWoodSecondary(resultSet.getString("woodSecondary"));
				reservation.setFinishType(resultSet.getString("finishType"));
				reservation.setCompletionDate(resultSet.getString("completionDate"));
				reservation.setDetail(resultSet.getString("detail"));
				reservation.setActive(resultSet.getBoolean("active"));
				reservation.setComment(resultSet.getString("comment"));
				
				reservations.put(reservation.getId(), reservation);
				
			}
			
		} catch (SQLException sqlException) {
			throw new ReservationException(sqlException.toString(), sqlException);
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
				throw new ReservationException(sqlException.toString(), sqlException);
			}
			
		}
		
		return reservations;
		
	}
	
	/** <h1>runStatement</h1>
	 * 
	 * <br>
	 * Runs <code>JDBC</code> statement
	 * <br><br>
	 * 
	 * @param type <code>String</code> identifying the SQL statment type
	 * @param customer <code>Reservation</code> object to be stored
	 * @throws ReservationException <code>Exception</code> if issues occur on writing to 
	 * 							JDBC reservation table
	 */
	private Hashtable<Integer, Reservation> runStatement(String userId) throws ReservationException {
		
		Hashtable<Integer, Reservation> reservations = new Hashtable<Integer, Reservation>();
		Reservation reservation = null;
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		String sql = null;
		
		connection = getConnection();
		
		try {
			
			sql = PropertyManager.getPropertyValue("Reservation.SelectSpecificUserID");
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, userId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				reservation = new Reservation();
				
				reservation.setId(resultSet.getInt("id"));
				reservation.setUserId(resultSet.getString("userId"));
				reservation.setName(resultSet.getString("name"));
				reservation.setMaterial(resultSet.getString("material"));
				reservation.setWoodMain(resultSet.getString("woodMain"));
				reservation.setWoodSecondary(resultSet.getString("woodSecondary"));
				reservation.setFinishType(resultSet.getString("finishType"));
				reservation.setCompletionDate(resultSet.getString("completionDate"));
				reservation.setDetail(resultSet.getString("detail"));
				reservation.setActive(resultSet.getBoolean("active"));
				reservation.setComment(resultSet.getString("comment"));
				
				reservations.put(reservation.getId(), reservation);
				
			}
			
		} catch (SQLException sqlException) {
			throw new ReservationException(sqlException.toString(), sqlException);
		} finally {
			
			try {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			
			} catch (SQLException sqlException) {
				throw new ReservationException(sqlException.toString(), sqlException);
			}
			
		}
		
		return reservations;
		
	}

}

