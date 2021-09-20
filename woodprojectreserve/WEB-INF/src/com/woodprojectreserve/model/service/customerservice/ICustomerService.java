package com.woodprojectreserve.model.service.customerservice;

import java.util.Hashtable;

import com.woodprojectreserve.model.domian.Customer;
import com.woodprojectreserve.model.service.IService;
import com.woodprojectreserve.model.service.exception.CustomerException;

/** <h1>ICustomerService</h1>
 * <br>
 * <code>ICustomerService</code> class implements a Customer interface 
 * <br><br>
 * 
 * @version - 9.19.20221
 * @author Christopher Culver
 */
public interface ICustomerService extends IService {
	
	public final String NAME = "ICustomerService";
	
	public boolean storeCustomerHashtable(Hashtable<String, Customer> customers) throws CustomerException;
	public Hashtable<String, Customer> retrieveCustomerHashtable() throws CustomerException;
	
	public boolean storeCustomer(Customer customer) throws CustomerException;
	public Customer retrieveCustomer(String username) throws CustomerException;
	
}
