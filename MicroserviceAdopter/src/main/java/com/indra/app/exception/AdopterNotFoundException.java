package com.indra.app.exception;

public class AdopterNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public AdopterNotFoundException(String cause) {
		super(cause);
	}

}
