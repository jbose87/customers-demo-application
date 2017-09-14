/**
 * 
 */
package com.zaloni.application.customers.dao;

import java.math.BigInteger;
import com.zaloni.application.customers.dao.dto.CustomerDTO;

/**
 * @author jbose
 *
 */
public interface ICustomerDAO {
	
	int saveCustomer(CustomerDTO customerDTO);
	int updateCustomer(CustomerDTO customerDTO) ;
	CustomerDTO getCustomer(int id);
	CustomerDTO getExistingCustomer(String name, String email);
	BigInteger getCountOfCustomerRecordsLast24Hours();
}
