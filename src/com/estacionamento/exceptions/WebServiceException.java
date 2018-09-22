package com.estacionamento.exceptions;



/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por lancar WEB SERVICE EXCEPTIONS
 *
 */
public class WebServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5606506990286597937L;
	

	public WebServiceException(Throwable e) {
		super(e);
	}

	public WebServiceException(String str) {
		super(str);
	}	


}
