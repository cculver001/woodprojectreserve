package com.woodprojectreserve.model.service.loginservice;

import com.woodprojectreserve.model.service.IService;
import com.woodprojectreserve.model.service.exception.LoginException;

/** <h1>ILoginService</h1>
 * <br>
 * <code>ILoginService</code> class implements a Login interface 
 * <br><br>
 * 
 * @version - 7.21.2020
 * @author Christopher Culver
 */
public interface ILoginService extends IService {
	
	public final String NAME = "ILoginService";

	public boolean authenticateLogin(String username, String password) throws LoginException;
	
}
