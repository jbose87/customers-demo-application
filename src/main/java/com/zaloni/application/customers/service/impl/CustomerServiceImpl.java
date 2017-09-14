package com.zaloni.application.customers.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.application.common.elasticSearch.service.IElasticSearchService;
import com.zaloni.application.customers.dao.ICustomerDAO;
import com.zaloni.application.customers.dao.dto.CustomerDTO;
import com.zaloni.application.customers.service.ICustomerService;
import com.zaloni.application.customers.vo.CustomerVO;
import com.zaloni.application.exceptions.DBException;
import com.zaloni.application.exceptions.GenericDAOException;
import com.zaloni.application.exceptions.GenericServiceException;
import static com.zaloni.application.common.util.DozerMapperUtils.mapper;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IElasticSearchService elasticSearchService;

	@Override
	public int saveCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		CustomerDTO customerDTO = null;
        
		try {
			logger.info("Inside saveCustomer method");
			if(logger.isDebugEnabled()) {
				logger.debug("CustomerVO object retrieved inside service" + customerVO.toString());
			}
			customerDTO = mapper.map(customerVO, CustomerDTO.class);
			if(logger.isDebugEnabled()) {
				logger.debug("customerDTO object mapped inside service" + customerDTO.toString());
			}
			int customerId = customerDAO.saveCustomer(customerDTO);
			if(logger.isDebugEnabled()) {
				logger.debug("customerId created inside service" + customerId);
			}
			customerVO.setId(customerId);
			logger.info("Customer details added successfully");
			//performElasticSearchOperation("add", customerId, customerVO);
			return customerId;
		}

		catch (DBException e) {
			logger.info("Found existing customer so going for update... ");
			CustomerDTO existingCustomerDTO = customerDAO.getExistingCustomer(customerVO.getName(),
					customerVO.getEmailId());
			if(logger.isDebugEnabled()) {
				logger.debug("existing customerDTO retrieved inside service" + existingCustomerDTO.toString());
			}
			performElasticSearchOperation(
					mapper.map(existingCustomerDTO, CustomerVO.class));
			customerDTO.setId(existingCustomerDTO.getId());
			if(logger.isDebugEnabled()) {
				logger.debug("Existing customerId retrieved inside service" + existingCustomerDTO.getId());
			}
			
			customerDAO.updateCustomer(customerDTO);
			
			logger.info("Customer details updated successfully");
			return existingCustomerDTO.getId();

		}

		catch (GenericDAOException e) {
			logger.error("Error from DAO layer", e.getMessage(), e);
			throw new GenericServiceException(e.getMessage(), e.getCause());

		}
		
		 

	}

	private void performElasticSearchOperation(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		elasticSearchService.createIndex("customerindex");
		elasticSearchService.addDocument("customerindex", "personal", UUID.randomUUID().toString(), customerVO, CustomerVO.class);
		
		
	}

}
