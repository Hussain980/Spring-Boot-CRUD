package com.hussain.crud.Exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7262473907596158944L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
