/**
 * 
 */
package com.zaloni.application.customers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zaloni.application.customers.vo.CustomerResponseVO;
import com.zaloni.application.customers.vo.CustomerVO;
import com.zaloni.application.exceptions.GenericControllerException;
import com.zaloni.application.exceptions.GenericServiceException;
import com.zaloni.application.customers.service.ICustomerService;

/**
 * @author jbose
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerDetailsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody @Validated CustomerVO customerVO) throws GenericControllerException {

		logger.info("Inside createCustomer method ");
		if (logger.isDebugEnabled()) {
			logger.debug("CustomerVO object before deserializing" + customerVO.toString());
		}

		try {
			int customerId = customerService.saveCustomer(customerVO);
			logger.info("Customer saved successfully");
			logger.info("Exiting createCustomer method");
			CustomerResponseVO customerResponseVO = new CustomerResponseVO(customerId, "SUCCESS");
			return new ResponseEntity<CustomerResponseVO>(customerResponseVO, HttpStatus.CREATED);
		} catch (GenericServiceException e) {
			// TODO Auto-generated catch block
			logger.error("Error while saving customer", e.getMessage(), e);
			throw new GenericControllerException(e.getMessage(), e.getCause());

		}

	}

}
