package com.estacionamento.exceptions;

public class DAOException extends Exception{

	/**
	 * 
	 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
	 * 
	 * Classe responsavel por lancar DAO EXCEPTIONS
	 *
	 */
	private static final long serialVersionUID = 1631342295149844158L;

	public DAOException(Throwable e) {
		super(e);
	}

	public DAOException(String str) {
		super(str);
	}	

}
