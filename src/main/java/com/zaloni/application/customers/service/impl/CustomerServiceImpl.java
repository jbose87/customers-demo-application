package com.zaloni.application.customers.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.application.common.elasticSearch.service.IElasticSearchService;
import com.zaloni.application.customers.dao.ICustomerDAO;
import com.zaloni.application.customers.dao.dto.CustomerDTO;
import com.zaloni.application.customers.service.ICustomerService;
import com.zaloni.application.customers.vo.CustomerVO;
import com.zaloni.application.exceptions.DBException;
import com.zaloni.application.exceptions.GenericTechnicalError;

import static com.zaloni.application.common.util.DozerMapperUtils.mapper;
import java.math.BigInteger;




@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private IElasticSearchService elasticSearchService;
	@Override
	public void saveCustomer(CustomerVO customerVO) throws GenericTechnicalError {
		// TODO Auto-generated method stub
		CustomerDTO customerDTO = null;
		
		try {
			
		customerDTO = mapper.map(customerVO, CustomerDTO.class);
		int customerId = customerDAO.saveCustomer(customerDTO);
		customerVO.setId(customerId);
		elasticSearchService.addDocument("customerindex","personal",customerId,customerVO,CustomerVO.class);
		
	    }
		
		 catch (DBException e) {
			 CustomerDTO existingCustomerDTO =  customerDAO.getExistingCustomer(customerDTO);
			 elasticSearchService.updateDocument("customerindex","personal",existingCustomerDTO.getId(),mapper.map(existingCustomerDTO, CustomerVO.class),CustomerVO.class);
			 customerDTO.setId(existingCustomerDTO.getId());
			 customerDAO.updateCustomer(customerDTO);
			 
		 }
		
		catch (Exception e) {
			throw new GenericTechnicalError(e.getMessage(),e.getCause());
			 
		 }
		
		
		
	}
	@Override
	public BigInteger getCountOfCustomerRecordsLast24Hours() {
		// TODO Auto-generated method stub
		return customerDAO.getCountOfCustomerRecordsLast24Hours();
	}
	
}
