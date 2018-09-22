package com.estacionamento.test;

import java.util.ArrayList;
import java.util.List;

import com.estacionamento.business.service.EnderecoBRAZILServiceImpl;
import com.estacionamento.business.service.EnderecoServiceLocal;
import com.estacionamento.exceptions.ServiceException;
import com.estacionamento.model.Endereco;

public class GeradorMockEnderecos {

	private static EnderecoServiceLocal enderecoService = EnderecoBRAZILServiceImpl.getInstance();

	
	 public void gerarMock(){
		
		
		List<Endereco> enderecos = new ArrayList<Endereco>();

		enderecos.add(new Endereco(null,123l,"06823-180", "RUA TESTE1", "BAIRRO JARDIN SANTO EDUARDO 1","Casa 1", "Sao Paulo", "Embu Das ARtes"));
		enderecos.add(new Endereco(null,123l,"22333-992", "RUA TESTE2", "BAIRRO JARDIN DAS FLORES","Casa 2", "Sao Paulo", "Embu Das ARtes"));
		enderecos.add(new Endereco(null,123l,"22333-000", "RUA TESTE3", "BAIRRO JARDIN TESTE","Casa 3", "Sao Paulo", "Sao Paulo"));
		enderecos.add(new Endereco(null,123l,"22333-990", "RUA TESTE4", "BAIRRO JARDIN SAO LUIZ","Casa 4", "Sao Paulo", "Sao paulo"));
		enderecos.add(new Endereco(null,123l,"23456-781", "RUA TESTE5", "","", "Sao Paulo", "Embu Das ARtes"));
		enderecos.add(new Endereco(null,123l,"12345-567", "RUA TESTE6", "","", "Sao Paulo", "Embu Das ARtes"));
		enderecos.add(new Endereco(null,123l,"12345-000", "RUA TESTE6", "","", "Sao Paulo", "Embu Das ARtes"));
		
		try {
			enderecoService.clearTableEnderecos();
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}

		
		for(Endereco endereco:enderecos){
			try {
				enderecoService.saveEndereco(endereco);
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		}
		
	}
}
