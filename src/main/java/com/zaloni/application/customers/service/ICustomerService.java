/**
 * 
 */
package com.zaloni.application.customers.service;

import java.math.BigInteger;
import com.zaloni.application.customers.vo.CustomerVO;
import com.zaloni.application.exceptions.GenericTechnicalError;

/**
 * @author jbose
 *
 */
public interface ICustomerService {
	
	void saveCustomer(CustomerVO customerVO) throws GenericTechnicalError;
	
	BigInteger getCountOfCustomerRecordsLast24Hours();

}
