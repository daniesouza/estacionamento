package com.estacionamento.business.service;

import java.util.List;

import com.estacionamento.dao.EnderecoDAOImpl;
import com.estacionamento.dao.EnderecoDAOLocal;
import com.estacionamento.exceptions.DAOException;
import com.estacionamento.exceptions.ServiceException;
import com.estacionamento.model.Endereco;
import com.estacionamento.util.ValidateUtils;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por gerenciar o CRUD DE ENDERECOS e validar regras de negocio
 * Implementa  {@link EnderecoServiceLocal}
 *
 */
public class EnderecoBRAZILServiceImpl implements EnderecoServiceLocal{
	
	private EnderecoDAOLocal enderecoDAO = EnderecoDAOImpl.newInstance();
	private static EnderecoBRAZILServiceImpl instance;
	
	
	/**
	 * Retorna a instancia estatica do EnderecoBRAZILServiceImpl
	 *
	 * @return  {@link EnderecoBRAZILServiceImpl}
	 * 	  
	 */
	public static EnderecoBRAZILServiceImpl getInstance() {		
		if(instance == null){			
			instance =  new EnderecoBRAZILServiceImpl();
		}		
		return instance;
	}

	/**
	 * Retorna uma lista de Enderecos dado o Parametro com CEP Existente e VALIDO
	 * @param {@link Endereco}
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	@Override
	public List<Endereco> findEnderecoByCep(Endereco endereco) throws ServiceException{		
		try {
			
			validarBuscaEndereco(endereco);
			
			endereco.setCep(endereco.getCep().replace("-", "")); // retira traco
			
		    String zeros = "0";
		    int len = endereco.getCep().length();
		    
		    List<Endereco> enderecosRetorno = enderecoDAO.findEnderecoByCep(endereco);
		    
		    while(enderecosRetorno.isEmpty()  && len>0){
		    	
		    	String cepComZero = endereco.getCep().substring(0,--len)+zeros;
		    	endereco.setCep(cepComZero);
		    	
		    	enderecosRetorno = enderecoDAO.findEnderecoByCep(endereco);
		    			        
		        zeros = zeros+"0";
		    }
		    
			 if(enderecosRetorno.isEmpty()){
				 throw new ServiceException("Endereco do cep informado nao encontrado.");
			 }
			
			return enderecosRetorno;
		} catch (DAOException e) {
			e.printStackTrace();			
			throw new ServiceException(e);
			
		}
	}
	
	/**
	 * valida se o CEP digitado � VALIDO para realizar a Busca
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} caso o cep seja INVALIDO
	 * 	  
	 */
	private void validarBuscaEndereco(Endereco endereco) throws ServiceException{
		ServiceException se = new ServiceException();
		
		if(endereco.getCep() == null || "".equals(endereco.getCep().trim())){
			se.adicionarMensagem("CEP NAO PODE SER VAZIO");
		}else if(!ValidateUtils.ValidaCepBrasil(endereco.getCep())){
			se.adicionarMensagem("CEP INVALIDO");
		}
		

		if (se.existeErro()) {
			throw se;
		}
	}

	/**
	 * Salva um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	@Override
	public void saveEndereco(Endereco endereco) throws ServiceException {
		
		try {
			
			validarSalvarEndereco(endereco);
			
			endereco.setCep(endereco.getCep().replace("-", "")); // retira traco
			
			enderecoDAO.saveEndereco(endereco);
			
		} catch (DAOException e) {
			e.printStackTrace();			
			throw new ServiceException(e);
			
		}
		
	}
	
	/**
	 * valida se o ENDERECO informado � VALIDO para realizar o save
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} caso o cep seja INVALIDO
	 * 	  
	 */
	private void validarSalvarEndereco(Endereco endereco) throws ServiceException{
		ServiceException se = new ServiceException();
		
		if(endereco.getRua() == null || "".equals(endereco.getRua().trim())){
			se.adicionarMensagem("RUA NAO PODE SER VAZIO");
		}
		
		if(endereco.getNumero() == null || endereco.getNumero() == 0l){
			se.adicionarMensagem("NUMERO NAO PODE SER VAZIO");
		}
		
		if(endereco.getCep() == null || "".equals(endereco.getCep().trim())){
			se.adicionarMensagem("CEP NAO PODE SER VAZIO");
		}else if(!ValidateUtils.ValidaCepBrasil(endereco.getCep())){
			se.adicionarMensagem("CEP INVALIDO");
		}
		
		if(endereco.getCidade() == null || "".equals(endereco.getCidade().trim())){
			se.adicionarMensagem("CIDADE NAO PODE SER VAZIO");
		}
		
		if(endereco.getEstado() == null || "".equals(endereco.getEstado().trim())){
			se.adicionarMensagem("ESTADO NAO PODE SER VAZIO");
		}

		if (se.existeErro()) {
			throw se;
		}
	}

	/**
	 * atualiza um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	@Override
	public void updateEndereco(Endereco endereco) throws ServiceException {
		try {
			
			validarSalvarEndereco(endereco);
			
			endereco.setCep(endereco.getCep().replace("-", "")); // retira traco
			
			enderecoDAO.updateEndereco(endereco);
			
		} catch (DAOException e) {
			e.printStackTrace();			
			throw new ServiceException(e);
			
		}
		
	}
	
	/**
	 * deleta um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	@Override
	public void deleteEndereco(Endereco endereco) throws ServiceException {
		try {
			
			validarDeletarEndereco(endereco);
			
			
			enderecoDAO.deleteEndereco(endereco);
			
		} catch (DAOException e) {
			e.printStackTrace();			
			throw new ServiceException(e);
			
		}
		
	}
	
	/**
	 * valida se o ENDERECO informado � VALIDO para realizar o DELTE
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	private void validarDeletarEndereco(Endereco endereco) throws ServiceException{
		ServiceException se = new ServiceException();
		
		if(endereco.getId() == null || endereco.getId() == 0l){
			se.adicionarMensagem("ID NAO PODE SER VAZIO");
		}

		if (se.existeErro()) {
			throw se;
		}
	}

	/**
	 * Retorna uma lista de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	@Override
	public List<Endereco> listEnderecos() throws ServiceException {
		
		try {
			
			return enderecoDAO.listEnderecos();
			
		} catch (DAOException e) {
			e.printStackTrace();			
			throw new ServiceException(e);
			
		}
	}

	/**
	 * limpa a tabela de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	@Override
	public void clearTableEnderecos() throws ServiceException {
		try {
			
			enderecoDAO.clearTableEnderecos();
			
		} catch (DAOException e) {
			e.printStackTrace();			
			throw new ServiceException(e);
			
		}
		
	}

}
