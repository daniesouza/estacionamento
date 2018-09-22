package com.estacionamento.business.service;

import java.util.List;

import com.estacionamento.exceptions.ServiceException;
import com.estacionamento.model.Endereco;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por gerenciar o CRUD DE ENDERECOS e validar regras de negocio
 *
 */
public interface EnderecoServiceLocal {

	/**
	 * Retorna uma lista de Enderecos dado o Parametro com CEP Existente e VALIDO
	 * @param {@link Endereco}
	 * @return  {@link List< Endereco >}
	 * 	  
	 */	
	public List<Endereco> findEnderecoByCep(Endereco endereco) throws ServiceException;

	/**
	 * Salva um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	public void saveEndereco(Endereco endereco) throws ServiceException;
	
	/**
	 * atualiza um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	public void updateEndereco(Endereco endereco) throws ServiceException;
	
	/**
	 * deleta um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */	
	public void deleteEndereco(Endereco endereco) throws ServiceException;
	
	/**
	 * Retorna uma lista de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	public List<Endereco> listEnderecos() throws ServiceException;
	
	/**
	 * limpa a tabela de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	public void clearTableEnderecos() throws ServiceException;
	
	
}
