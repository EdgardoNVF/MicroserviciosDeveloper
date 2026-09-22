package com.indra.app.exception;

public class PetNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PetNotFoundException(String cause) {
		super(cause);
	}

}
