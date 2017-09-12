/**
 * 
 */
package com.zaloni.application.customers.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zaloni.application.customers.vo.CustomerVO;
import com.zaloni.application.exceptions.GenericTechnicalError;
import com.zaloni.application.customers.service.ICustomerService;

/**
 * @author jbose
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerDetailsController {
	
	@Autowired
    private ICustomerService customerService;
	
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody @Validated CustomerVO customerVO) {
        
        try {
			customerService.saveCustomer(customerVO);
		} catch (GenericTechnicalError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
	
	

}
