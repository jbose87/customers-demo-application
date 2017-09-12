package com.zaloni.application.customers.dao;



import java.math.BigInteger;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import com.zaloni.application.common.dao.AbstractDAO;
import com.zaloni.application.customers.dao.dto.CustomerDTO;
import com.zaloni.application.exceptions.DBException;

@Repository
@Transactional
public class CustomerDAO extends AbstractDAO implements ICustomerDAO { 
	@Override
	public int saveCustomer(CustomerDTO customerDTO) throws DBException {
		// TODO Auto-generated method stub
		
		try {
		getSession().save(customerDTO);
		getSession().flush();
		} catch (ConstraintViolationException e) {
			getSession().clear();
			throw new DBException(e.getMessage(),e.getCause());
		}
		
		return customerDTO.getId();
	}

	@Override
	public int updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		
		getSession().update(customerDTO);
		return customerDTO.getId();
	}

	@Override
	public CustomerDTO getCustomer(int id) {
		// TODO Auto-generated method stub
		return getSession().get(CustomerDTO.class, id);
	}
	
	
	public CustomerDTO getExistingCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		String queryString = "FROM " + CustomerDTO.class.getName() + " WHERE name = :name";
		Query query = getSession().createQuery(queryString);
        query.setParameter("name", customerDTO.getName());
        return (CustomerDTO) query.list().get(0);
        
        
        
	}

	@Override
	public BigInteger getCountOfCustomerRecordsLast24Hours() {
		// TODO Auto-generated method stub
		//String queryString = "select count(*) FROM " + CustomerDTO.class.getName() + " WHERE DATE_SUB(CURDATE(), INTERVAL 1 DAY)";
		//Query query = getSession().createQuery(queryString);
		//query.setParameter("startDate", startDate);
		//query.setParameter("endDate", endDate);
		Query query = getSession().createSQLQuery("select count(*) from CUSTOMER_DATA where updated_time >= NOW() - INTERVAL 1 DAY");
		System.out.println("COUNT OF CUSTOMERS"+query.uniqueResult());
		return  (BigInteger) query.uniqueResult();
		
	}
	
	

}
