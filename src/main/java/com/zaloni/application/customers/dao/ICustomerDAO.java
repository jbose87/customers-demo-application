/**
 * 
 */
package com.zaloni.application.customers.dao;

import java.math.BigInteger;
import java.util.Date;

import com.zaloni.application.customers.dao.dto.CustomerDTO;
import com.zaloni.application.exceptions.DBException;
/**
 * @author jbose
 *
 */
public interface ICustomerDAO {
	
	int saveCustomer(CustomerDTO customerDTO) throws DBException;
	int updateCustomer(CustomerDTO customerDTO) ;
	CustomerDTO getCustomer(int id);
	CustomerDTO getExistingCustomer(CustomerDTO customerDTO);
	BigInteger getCountOfCustomerRecordsLast24Hours();
}
