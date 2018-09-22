package com.estacionamento.dao;

import java.util.List;

import com.estacionamento.exceptions.DAOException;
import com.estacionamento.model.Endereco;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por gerenciar o CRUD DE ENDERECOS e validar regras de negocio
 *
 */
public interface EnderecoDAOLocal {

	/**
	 * Retorna uma lista de Enderecos dado o Parametro com CEP Existente e VALIDO
	 * @param {@link Endereco}
	 * @return  {@link List< Endereco >}
	 * 	  
	 */	
	public List<Endereco> findEnderecoByCep(Endereco endereco) throws DAOException;

	/**
	 * Salva um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link DAOException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	public void saveEndereco(Endereco endereco) throws DAOException;
	
	/**
	 * atualiza um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link DAOException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	public void updateEndereco(Endereco endereco) throws DAOException;
	
	/**
	 * deleta um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link DAOException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */	
	public void deleteEndereco(Endereco endereco) throws DAOException;
	
	/**
	 * Retorna uma lista de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	public List<Endereco> listEnderecos() throws DAOException;
	
	/**
	 * limpa a tabela de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	public void clearTableEnderecos() throws DAOException;
}
