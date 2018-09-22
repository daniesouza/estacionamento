package com.estacionamento.test;

import javax.ws.rs.core.MediaType;

import com.estacionamento.model.Endereco;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.security.authorization.resources.WebResource;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.sun.security.ntlm.Client;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por TESTAR o SERVICO DE BUSCA DE CEP -  Questao 1
 *
 */
public class BuscadorCepTest {
	
	public BuscadorCepTest(){
		doGerarMock();	
	}
	
	/**
	 * GERA MOCKS PARA A EXECUCAO DOS TESTES
	 *
	 */
	public void doGerarMock(){
		
		System.out.println("GERANDO MOCKS PARA EXECUCAO DOS TESTES");

		new GeradorMockEnderecos().gerarMock();
		
		System.out.println("MOCKS GERADOS COM SUCESSO\n");
		
		System.out.println("INICIANDO TESTES\n");
	}

	/**
	 * Faz o teste de FALHA DE CEP pasando um cep invalido
	 * 
	 * teste com Cep: abc123-180
	 *
	 */
	@Test
	public void doTesteFalhaCEPInvalido1(){
		
		System.out.println("@Test: doTesteFalhaCEPInvalido1 INICIO TESTE CEP INVALIDO : Cep: abc123-180");

		ClientResponse response = callCepService("abc123-180");
		
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);		
		
		if (response.getStatus() != 200) {

	        String result = null;
			try {
				JSONObject jsonRetorno = new JSONObject(output);
				 result = (String) jsonRetorno.get("error");			 
			} catch (JSONException e) {			
				e.printStackTrace();
			}
			
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals("CEP INVALIDO", result);
		}else{
			System.out.println("TESTE FALHA NO TESTE\n");
			Assert.assertEquals("CEP INVALIDO", "");
		}
       
	}
	
	
	/**
	 * Faz o teste de FALHA DE CEP pasando um cep invalido por tamanho
	 * 
	 * teste com Cep: 0123-180
	 *
	 */
	@Test
	public void doTesteFalhaCEPInvalido2(){
		
		System.out.println("@Test: doTesteFalhaCEPInvalido2 INICIO TESTE CEP INVALIDO 2 : Cep: 0123-180");

		ClientResponse response = callCepService("0123-180");
				
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);		
		
		if (response.getStatus() != 200) {

	        String result = null;
			try {
				JSONObject jsonRetorno = new JSONObject(output);
				 result = (String) jsonRetorno.get("error");			 
			} catch (JSONException e) {			
				e.printStackTrace();
			}
			
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals("CEP INVALIDO", result);
		}else{
			System.out.println("TESTE FALHA NO TESTE\n");
			Assert.assertEquals("CEP INVALIDO", "");
		}
       
	}
	
	/**
	 * Faz o teste de FALHA DE CEP pasando um cep invalido por tamanho
	 * 
	 * teste com Cep: 221544595566-181210
	 *
	 */
	@Test
	public void doTesteFalhaCEPInvalido3(){
		
		System.out.println("@Test: doTesteFalhaCEPInvalido3 INICIO TESTE CEP INVALIDO 3 : Cep: 221544595566-181210");

		ClientResponse response = callCepService("221544595566-181210");
		
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);		
		
		if (response.getStatus() != 200) {

	        String result = null;
			try {
				JSONObject jsonRetorno = new JSONObject(output);
				 result = (String) jsonRetorno.get("error");			 
			} catch (JSONException e) {			
				e.printStackTrace();
			}
			
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals("CEP INVALIDO", result);
		}else{
			System.out.println("TESTE FALHA NO TESTE\n");
			Assert.assertEquals("CEP INVALIDO", "");
		}
       
	}
	
	/**
	 * Faz o teste de FALHA DE CEP pasando um cep invalido por tamanho
	 * 
	 * teste com Cep: 06823-
	 *
	 */
	@Test
	public void doTesteFalhaCEPInvalido4(){
		
		System.out.println("@Test: doTesteFalhaCEPInvalido4 INICIO TESTE CEP INVALIDO 4 : Cep: 06823-");

		ClientResponse response = callCepService("06823-");
		
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);
		
		if (response.getStatus() != 200) {

	        String result = null;
			try {
				JSONObject jsonRetorno = new JSONObject(output);
				 result = (String) jsonRetorno.get("error");			 
			} catch (JSONException e) {			
				e.printStackTrace();
			}
			
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals("CEP INVALIDO", result);
		}else{
			System.out.println("TESTE FALHA NO TESTE\n");
			Assert.assertEquals("CEP INVALIDO", "");
		}
       
	}
	
	/**
	 * Faz o teste de FALHA DE CEP pasando um cep vazio
	 * 
	 * teste com Cep: 
	 *
	 */
	@Test
	public void doTesteFalhaCEPVazio(){
		
		System.out.println("@Test: doTesteFalhaCEPVazio INICIO TESTE CEP VAZIO : Cep:''");

		ClientResponse response = callCepService("''");
		
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);
		
		if (response.getStatus() != 200) {

	        String result = null;
			try {
				JSONObject jsonRetorno = new JSONObject(output);
				 result = (String) jsonRetorno.get("error");			 
			} catch (JSONException e) {			
				e.printStackTrace();
			}
			
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals("CEP INVALIDO", result);
		}else{
			System.out.println("TESTE FALHA NO TESTE\n");
			Assert.assertEquals("CEP INVALIDO", "");
		}
       
	}
	
	/**
	 * Faz o teste CEP VALIDO pasando um cep VALIDO
	 * 
	 * teste com Cep: 06823-180
	 *
	 */
	@Test
	public void doTesteSuccessCEPValido(){
		
		System.out.println("@Test: doTesteSuccessCEPValido INICIO TESTE CEP VALIDO : Cep: 06823-180");

		ClientResponse response = callCepService("06823-180");
		
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);
		
		if (response.getStatus() == 200) {
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals(true,true);

		}else{
			System.out.println("FALHA NO TESTE\n");
			Assert.assertEquals("Falha", "");
		}
       
	}
	
	/**
	 * Faz o teste CEP VALIDO pasando um cep VALIDO executando o algoritmo de troca por ZEROS
	 * 
	 * teste com Cep: 22333-993
	 *
	 */
	@Test
	public void doTesteSuccessCEPValidoTrocandoPorZero(){
		
		System.out.println("@Test: doTesteSuccessCEPValidoTrocandoPorZero INICIO TESTE CEP VALIDO TROCANDO POR ZEROS : Cep: 22333-993");

		ClientResponse response = callCepService("22333-993");
		
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);
		
		if (response.getStatus() == 200) {
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals(true,true);

		}else{
			System.out.println("FALHA NO TESTE\n");
			Assert.assertEquals("Falha", "");
		}
       
       
	}
	
	/**
	 * Faz o teste CEP VALIDO pasando um cep VALIDO PASSANDO UM CEP SEM TRACO
	 * 
	 * teste com Cep: 22333992
	 *
	 */
	@Test
	public void doTesteSuccessCEPValidoSemTraco(){
		
		System.out.println("@Test: doTesteSuccessCEPValidoSemTraco INICIO TESTE CEP VALIDO COM CEP SEM TRACO : Cep: 22333992");

		ClientResponse response = callCepService("22333992");
		
		String output = response.getEntity(String.class);

		System.out.println("RESPOSTA SERVIDOR :" +output);
		
		if (response.getStatus() == 200) {
			System.out.println("TESTE CONCLUIDO\n");
			Assert.assertEquals(true,true);

		}else{
			System.out.println("FALHA NO TESTE\n");
			Assert.assertEquals("Falha", "");
		}
          
	}
	
	/**
	 * FAZ A CHAMADA DO WEB SERVICE
	 * 
	 */
	private ClientResponse callCepService(String cep){
		ClientResponse response = null;
		try {
		
			Endereco endereco = new Endereco();
			endereco.setCep(cep);
			
			
			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:8080/estacionamento/services/endereco/findByCep");

			response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, endereco);

			
			return response;
			
		} catch (Exception e) {
			System.out.println("\nErro na chamada do servico");
			System.out.println(e);
		}
		
		return response;
	}
	
	
}
