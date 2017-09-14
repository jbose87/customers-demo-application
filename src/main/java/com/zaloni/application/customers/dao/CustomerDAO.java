package com.zaloni.application.customers.dao;

import java.math.BigInteger;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.zaloni.application.common.dao.AbstractDAO;
import com.zaloni.application.customers.dao.dto.CustomerDTO;
import com.zaloni.application.exceptions.DBException;
import com.zaloni.application.exceptions.GenericDAOException;

@Repository
@Transactional
public class CustomerDAO extends AbstractDAO implements ICustomerDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public int saveCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub

		try {
			logger.info("Inside saveCustomer method");
			if(logger.isDebugEnabled()) {
				logger.debug("customerDTO object before saving" + customerDTO.toString());
			}
			getSession().save(customerDTO);
			getSession().flush();
		} catch (ConstraintViolationException e) {
			getSession().clear();
			logger.error("Error while saving customer into database", e.getMessage(), e);
			throw new DBException(e.getMessage(), e.getCause());
		}

		return customerDTO.getId();
	}

	@Override
	public int updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		try {
			logger.info("Inside updateCustomer method");
			if(logger.isDebugEnabled()) {
				logger.debug("customerDTO object before updating" + customerDTO.toString());
			}
			getSession().update(customerDTO);
		} catch (Exception e) {
			logger.error("Error while updating customer into database", e.getMessage(), e);
			throw new GenericDAOException(e.getMessage(), e.getCause());
		}
		return customerDTO.getId();
	}

	@Override
	public CustomerDTO getCustomer(int id) {
		// TODO Auto-generated method stub
		CustomerDTO customerDTO = null;
		try {
			logger.info("Inside getCustomer method of ");
			customerDTO = getSession().get(CustomerDTO.class, id);
			if(logger.isDebugEnabled()) {
				logger.debug("customerDTO retrieved from database" + customerDTO.toString());
			}
			 
		} catch (Exception e) {
			logger.error("Error while retrieving customer from database", e.getMessage(), e);
			throw new GenericDAOException(e.getMessage(), e.getCause());
		}
		
		return customerDTO;
	}

	public CustomerDTO getExistingCustomer(String name, String email) {
		// TODO Auto-generated method stub
		Query query = null;
		try {
			logger.info("Inside getExistingCustomer method");
			String queryString = "FROM " + CustomerDTO.class.getName() + " WHERE name = :name and emailId = :email";
			query = getSession().createQuery(queryString);
			query.setParameter("name", name);
			query.setParameter("email", email);
		} catch (Exception e) {
			logger.error("Error while retrieving customer from database", e.getMessage(), e);
			throw new GenericDAOException(e.getMessage(), e.getCause());
		}
		return (CustomerDTO) query.list().get(0);

	}

	@Override
	public BigInteger getCountOfCustomerRecordsLast24Hours() {
		// TODO Auto-generated method stub
		Query query = null;
		try {
			logger.info("Inside getCountOfCustomerRecordsLast24Hours method");
			query = getSession()
					.createSQLQuery("select count(*) from CUSTOMER_DATA where updated_time >= NOW() - INTERVAL 1 DAY");
		} catch (Exception e) {
			logger.error("Error while retrieving count of customers from database", e.getMessage(), e);
			throw new GenericDAOException(e.getMessage(), e.getCause());
		}

		return (BigInteger) query.uniqueResult();

	}

}
