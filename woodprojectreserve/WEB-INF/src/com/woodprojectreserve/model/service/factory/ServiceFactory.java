package com.woodprojectreserve.model.service.factory;

import com.woodprojectreserve.model.buisness.exception.ServiceLoadException;
import com.woodprojectreserve.model.service.IService;
import com.woodprojectreserve.model.service.manager.PropertyManager;

public class ServiceFactory {

	private static ServiceFactory serviceFactory;

	private ServiceFactory() {}

	/** <h1>getInstance</h1>
	 * 
	 * Getter for local <code>ServiceFactory</code> instance. 
	 * 
	 * @return <code>ServiceFactory</code> instance
	 */
	public static ServiceFactory getInstance() {
		
		if (serviceFactory == null) {
			serviceFactory = new ServiceFactory();
		}
		
		return serviceFactory;
		
	}
	
	/** <h1>getService</h1>
	 * 
	 * @param serviceName <code>String</code> representing a service interface
	 * @return <code>IService</code>
	 * @throws ServiceLoadException If service path missing from application.properties
	 */
	@SuppressWarnings("deprecation")
	public IService getService(String serviceName) throws ServiceLoadException {
		
		try {
			
			Class<?> implement = Class.forName(getImplName(serviceName));
			
			return (IService) implement.newInstance();
			
		} catch (ClassNotFoundException exception) {
			
			serviceName = serviceName + " not found";
			throw new ServiceLoadException(serviceName, exception);
			
		} catch (InstantiationException exception) {
			
			serviceName = serviceName + " not instantiated";
			throw new ServiceLoadException(serviceName, exception);
			
		} catch (IllegalAccessException exception) {
			
			serviceName = serviceName + " illegal access";
			throw new ServiceLoadException(serviceName, exception);
			
		}
		
	}
	
	/**
	 * Gets property value for given service name
	 * @param serviceName <code>String</code> representing the service request
	 * @return <code>String</code>
	 * @throws NamingException 
	 */
	private String getImplName(String serviceName) {
		return PropertyManager.getPropertyValue(serviceName);
	}
	
}
