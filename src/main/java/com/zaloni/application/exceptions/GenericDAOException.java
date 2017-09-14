package com.zaloni.application.exceptions;

public class GenericDAOException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericDAOException() {
        super();

   }

   public GenericDAOException(String message, Throwable cause) {
        super(message, cause);

   }

}
