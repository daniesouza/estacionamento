package com.estacionamento.test;

import javax.ws.rs.core.MediaType;

import com.estacionamento.model.Endereco;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.security.authorization.resources.WebResource;
import org.junit.Assert;
import org.junit.Test;

import com.sun.security.ntlm.Client;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por TESTAR O CRUS DE CEP UTILIZANDO O SERVICO DE BUSCA DE CEP - QUESTAO 2
 *
 */
public class EnderecosCRUDTest {
	
	
	/**
	 * Faz o teste de FALHA SALVAR pasando um ENDERECO com CEP Invalido
	 * 
	 * teste com Cep: 223323-180
	 *
	 */
	@Test
	public void doTesteFALHASalvar(){
		try {

			System.out.println("@Test: doTesteFALHASalvar INICIO TESTE DE FALHA Salvar");

			Endereco endereco = new Endereco(null,123l,"223323-180",
					"RUA TESTE1 JUNIT ENDERECO", "JARDIN JUNIT SANTO EDUARDO 1","CASA 1 JUNIT", "Sao Paulo jUINIT", "Embu Das ARtes");		
			
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/save");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, endereco);
			
			String output = response.getEntity(String.class);

			System.out.println("RESPOSTA SERVIDOR :" +output);

			if (response.getStatus() != 200) {
				System.out.println("TESTE SALVAR COM FALHA CONCLUIDO\n");
				Assert.assertTrue(true);
			}else{
				System.out.println("TESTE SALVAR COM FALHA FALHOU\n");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA TESTE SALVAR\n");
			Assert.assertTrue(false);
		}
	}
	
	
	/**
	 * Faz o teste de SALVAR pasando um ENDERECO valido
	 * 
	 *
	 */
	@Test
	public void doTesteSalvar(){
		try {

			System.out.println("@Test: doTesteSalvar INICIO TESTE Salvar");

			Endereco endereco = new Endereco(null,123l,"22323-180",
					"RUA TESTE1 JUNIT ENDERECO", "JARDIN JUNIT SANTO EDUARDO 1","CASA 1 JUNIT", "Sao Paulo jUINIT", "Embu Das ARtes");		
			
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/save");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, endereco);
			
			String output = response.getEntity(String.class);

			System.out.println("RESPOSTA SERVIDOR :" +output);

			if (response.getStatus() == 200) {
				System.out.println("TESTE SALVAR CONCLUIDO\n");
				Assert.assertTrue(true);
			}else{
				System.out.println("FALHA TESTE SALVAR\n");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA TESTE SALVAR\n");
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * Faz o teste de FALHA ALTERAR pasando um ENDERECO com CEP Invalido
	 * 
	 * teste com Cep: 12345-1801
	 *
	 */
	@Test
	public void doTesteFALHAAlterar(){
		try {

			System.out.println("@Test: doTesteAlterar INICIO TESTE FALHA ALTERAR");

			Endereco endereco = new Endereco(null,123l,"22323-180",
					"RUA TESTE1 JUNIT ENDERECO", "JARDIN JUNIT SANTO EDUARDO 1","CASA 1 JUNIT", "Sao Paulo jUINIT", "Embu Das ARtes");		
			
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/save");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, endereco);
			
			String output = response.getEntity(String.class);
						
			if (response.getStatus() == 200) {
				
				ObjectMapper mapper = new ObjectMapper();
				endereco  = mapper.readValue(output, Endereco.class);
				
				Endereco enderecoAlterar = new Endereco(endereco.getId(),123l,"12345-1801",
						"RUA ALTERADO JUNIT ENDERECO", "JARDIN ALTERADO JUNIT SANTO EDUARDO 1"," ALTERADOCASA 1 JUNIT", "ALTERADO Sao Paulo jUINIT", "ALTERADOEmbu Das ARtes");
				
				clientConfig = new DefaultClientConfig();

				clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				
				client = Client.create(clientConfig);
				webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/update");

				
				response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, enderecoAlterar);
				
				output = response.getEntity(String.class);
				
				System.out.println("RESPOSTA SERVIDOR :" +output);

				
				if (response.getStatus() != 200) {
					System.out.println("TESTE ALTERAR FALHA CONCLUIDO\n");
					Assert.assertTrue(true);
				}else{
					System.out.println("TESTE ALTERAR FALHA FALHOU\n");
					Assert.assertTrue(false);
				}
							
			}else{
				System.out.println("TESTE ALTERAR FALHA FALHOU\n");
				Assert.assertTrue(false);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA TESTE ALTERAR\n");
			Assert.assertTrue(false);
		}
	}	
	
	
	/**
	 * Faz o teste de ALTERAR pasando um ENDERECO valido
	 * 
	 *
	 */
	@Test
	public void doTesteAlterar(){
		try {

			System.out.println("@Test: doTesteAlterar INICIO TESTE ALTERAR");

			Endereco endereco = new Endereco(null,123l,"22323-180",
					"RUA TESTE1 JUNIT ENDERECO", "JARDIN JUNIT SANTO EDUARDO 1","CASA 1 JUNIT", "Sao Paulo jUINIT", "Embu Das ARtes");		
			
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/save");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, endereco);
			
			String output = response.getEntity(String.class);
						
			if (response.getStatus() == 200) {
				
				ObjectMapper mapper = new ObjectMapper();
				endereco  = mapper.readValue(output, Endereco.class);
				
				Endereco enderecoAlterar = new Endereco(endereco.getId(),123l,"12345-180",
						"RUA ALTERADO JUNIT ENDERECO", "JARDIN ALTERADO JUNIT SANTO EDUARDO 1"," ALTERADOCASA 1 JUNIT", "ALTERADO Sao Paulo jUINIT", "ALTERADOEmbu Das ARtes");
				
				clientConfig = new DefaultClientConfig();

				clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				
				client = Client.create(clientConfig);
				webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/update");

				
				response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, enderecoAlterar);
				
				output = response.getEntity(String.class);
				
				System.out.println("RESPOSTA SERVIDOR :" +output);

				
				if (response.getStatus() == 200) {
					System.out.println("TESTE ALTERAR CONCLUIDO\n");
					Assert.assertTrue(true);
				}else{
					System.out.println("FALHA TESTE ALTERAR\n");
					Assert.assertTrue(false);
				}
							
			}else{
				System.out.println("FALHA TESTE ALTERAR\n");
				Assert.assertTrue(false);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA TESTE ALTERAR\n");
			Assert.assertTrue(false);
		}
	}
	


	
	/**
	 * Faz o teste de EXCLUIR pasando um ID valido
	 */
	@Test
	public void doTesteExcluir(){
		try {

			System.out.println("@Test: doTesteExcluir INICIO TESTE EXCLUIR");

			Endereco endereco = new Endereco(null,232312l,"22342-180",
					"RUA TESTE1 JUNIT ENDERECO", "JARDIN JUNIT SANTO EDUARDO 1","CASA 1 JUNIT", "Sao Paulo jUINIT", "Embu Das ARtes");		
			
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/save");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, endereco);
			
			String output = response.getEntity(String.class);
						
			if (response.getStatus() == 200) {
				
				ObjectMapper mapper = new ObjectMapper();
				endereco  = mapper.readValue(output, Endereco.class);
				
				Endereco enderecoExcluir = new Endereco();
				enderecoExcluir.setId(endereco.getId());
			
				clientConfig = new DefaultClientConfig();

				clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				
				client = Client.create(clientConfig);
				webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/delete");

				webResource.queryParam("id", enderecoExcluir.getId().toString()).delete();
									
				System.out.println("TESTE EXCLUIR CONCLUIDO\n");
				Assert.assertTrue(true);
							
			}else{
				System.out.println("FALHA TESTE EXCLUIR\n");
				Assert.assertTrue(false);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA TESTE EXCLUIR\n");
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * Faz o teste de LISTAR TODOS OS ENDERECOS
	 */
	@Test
	public void doListar(){
		try {					
			System.out.println("@Test: doListar INICIO TESTE LISTAR TODOS");
			
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/list");

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

			String output = response.getEntity(String.class);

			System.out.println("RESPOSTA SERVIDOR :" +output);

			if (response.getStatus() == 200) {
				System.out.println("TESTE LISTAR CONCLUIDO\n");
				Assert.assertTrue(true);
			}else{
				System.out.println("FALHA TESTE LISTAR\n");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FALHA TESTE LISTAR\n");
			Assert.assertTrue(false);
		}
	}
}
