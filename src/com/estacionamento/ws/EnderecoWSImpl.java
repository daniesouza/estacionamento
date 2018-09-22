package com.estacionamento.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.estacionamento.business.service.EnderecoBRAZILServiceImpl;
import com.estacionamento.business.service.EnderecoServiceLocal;
import com.estacionamento.exceptions.ServiceException;
import com.estacionamento.exceptions.WebServiceException;
import com.estacionamento.model.Endereco;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por Expor o servico de CRUD DE CEP
 * Implementa  {@link EnderecoWSLocal}
 *
 */
@Path("/endereco")
public class EnderecoWSImpl implements EnderecoWSLocal {
	
	private static EnderecoServiceLocal enderecoService = EnderecoBRAZILServiceImpl.getInstance();

	/**
	 * Retorna uma lista de Enderecos dado o Parametro com CEP Existente e VALIDO
	 * @param {@link Endereco}
	 * @return  {@link Response,List< Endereco >}
	 * @throws	{@link WebServiceException , JSONException}
	 */	
	@Override
	@POST
	@Path("/findByCep")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findEnderecoByCep(Endereco endereco) throws WebServiceException, JSONException {
		
		try {
			 		 
			List<Endereco> enderecosRetorno = enderecoService.findEnderecoByCep(endereco);

			return Response.status(Status.OK).entity(new GenericEntity<List<Endereco>>(enderecosRetorno) {}).build();
			 
			 
		} catch (ServiceException e) {
					
			System.out.println("Server: Erro ao buscar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();

			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
			
		}catch (Exception e) {
			System.out.println("Server: Erro ao buscar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();
			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
		}
		
	}
	
	
	/**
	 * Salva um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	@Override
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEndereco(Endereco endereco) throws WebServiceException, JSONException {
		
		try {
			 		 
			enderecoService.saveEndereco(endereco);
	 
			return Response.status(Status.OK).entity(endereco).build();
			 
			 
		} catch (ServiceException e) {
					
			System.out.println("Server: Erro ao salvar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();

			jsonErro.put("status", "error");
			jsonErro.put("errorcode", 400);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
			
		}catch (Exception e) {
			System.out.println("Server: Erro ao salvar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();
			jsonErro.put("status", "error");
			jsonErro.put("errorcode", 400);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
		}
		
	}
	
	/**
	 * atualiza um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	@Override
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEndereco(Endereco endereco) throws WebServiceException, JSONException {
		
		try {
			 		 
			enderecoService.updateEndereco(endereco);
	 
			return Response.status(Status.OK).entity(endereco).build();
			 
			 
		} catch (ServiceException e) {
					
			System.out.println("Server: Erro ao atualizar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();

			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
			
		}catch (Exception e) {
			System.out.println("Server: Erro ao atualizar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();
			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
		}
		
	}
	
	/**
	 * DELETA um Endereco VALIDO
	 * @param {@link id}
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	@Override
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEndereco(@QueryParam("id")Long id) throws WebServiceException, JSONException {
		
		try {
			
			Endereco endereco = new Endereco();
			endereco.setId(id);
			enderecoService.deleteEndereco(endereco);
	 
			return Response.status(Status.OK).entity(endereco).build();
			 
			 
		} catch (ServiceException e) {
					
			System.out.println("Server: Erro ao deletar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();

			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
			
		}catch (Exception e) {
			System.out.println("Server: Erro ao deletar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();
			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
		}
		
	}
	
	/**
	 * Retorna uma lista de Enderecos
	 * @throws	{@link WebServiceException, JSONException}
	 * 	  
	 */
	@Override
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listEnderecos() throws WebServiceException, JSONException {
		
		try {
			 		  
			return Response.status(Status.OK).entity(new GenericEntity<List<Endereco>>(enderecoService.listEnderecos()) {}).build();
			 
			 
		} catch (ServiceException e) {
					
			System.out.println("Server: Erro ao buscar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();

			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
			
		}catch (Exception e) {
			System.out.println("Server: Erro ao buscar Endereco: - "+e.getMessage());
			JSONObject jsonErro = new JSONObject();
			jsonErro.put("status", "error");
			jsonErro.put("errorcode", Status.BAD_REQUEST);
			jsonErro.put("error", e.getMessage());
	
			
			return Response.status(Status.BAD_REQUEST).entity(jsonErro.toString()).build();
		}
		
	}

}
