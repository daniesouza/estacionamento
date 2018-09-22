/**
 * 
 */
package com.estacionamento.ws;

import javax.ws.rs.core.Response;

import com.estacionamento.exceptions.WebServiceException;
import com.estacionamento.model.Endereco;
import org.json.JSONException;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por Expor o servico de CRUD DE CEP
 *
 */
public interface EnderecoWSLocal {

	/**
	 * Retorna uma lista de Enderecos dado o Parametro com CEP Existente e VALIDO
	 * @param {@link Endereco}
	 * @return  {@link Response,List< Endereco >}
	 * @throws	{@link WebServiceException , JSONException}
	 */	
	public Response findEnderecoByCep(Endereco endereco) throws WebServiceException,JSONException;

	/**
	 * Salva um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	public Response saveEndereco(Endereco endereco) throws WebServiceException,JSONException;
	
	/**
	 * atualiza um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	public Response updateEndereco(Endereco endereco) throws WebServiceException, JSONException;

	/**
	 * DELETA um Endereco VALIDO
	 * @param {@link id}
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	public Response deleteEndereco(Long id) throws WebServiceException,JSONException;

	/**
	 * Retorna uma lista de Enderecos
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	public Response listEnderecos() throws WebServiceException, JSONException;
	
}
