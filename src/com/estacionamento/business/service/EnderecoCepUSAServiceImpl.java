package com.estacionamento.business.service;

import java.util.List;

import com.estacionamento.exceptions.ServiceException;
import com.estacionamento.model.Endereco;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por gerenciar o CRUD DE ENDERECOS e validar regras de negocio
 * Implementa  {@link EnderecoServiceLocal}
 *
 */
public class EnderecoCepUSAServiceImpl implements EnderecoServiceLocal{

	@Override
	public List<Endereco> findEnderecoByCep(Endereco endereco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEndereco(Endereco endereco) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEndereco(Endereco endereco) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEndereco(Endereco endereco) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listEnderecos() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearTableEnderecos() throws ServiceException {
		// TODO Auto-generated method stub
		
	}


	//TODO IMPLEMENTAR SE NECESSARIO
}
