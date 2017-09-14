package com.zaloni.application.exceptions;

public class GenericServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericServiceException() {
        super();

   }

   public GenericServiceException(String message, Throwable cause) {
        super(message, cause);

   }

}
