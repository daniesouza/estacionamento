package com.estacionamento.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends Exception{


	/**
	 * 
	 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
	 * 
	 * Classe responsavel por lancar SERVICO EXCEPTIONS COM REGRAS DE NEGOCIO
	 *
	 */
	private static final long serialVersionUID = 8756454441289641708L;

	public ServiceException(Throwable e) {
		super(e);
	}

		
	private List<String> mensagens = new ArrayList<String>();
	
	public ServiceException() {
		super("ServicoException - Erro");
	}
	
	public ServiceException(Exception ex){
		
		super(ex);
	}
	
	@Override
	public String getMessage() {
		if(!existeErro()) {
			return super.getMessage();			
		} else {
			return obterMensagens();
		}
	}
	
	public ServiceException(String str) {
		super(str);
		mensagens.add(str);
	}
	
	public void adicionarMensagem(String mensagem) {
		this.mensagens.add(mensagem);
	}

	public List<String> getMensagens() {
		return mensagens;
	}
	
	public boolean existeErro() {
		return !mensagens.isEmpty();
	}
	
	public String obterMensagens() {
		StringBuilder sb = new StringBuilder();
		for (String msg : mensagens) {
			sb.append(msg);
			sb.append(";");
		}
		return sb.substring(0, sb.length()-1).toString();
	}
}
