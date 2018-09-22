package com.estacionamento.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.estacionamento.exceptions.DAOException;
import com.estacionamento.model.Endereco;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel por gerenciar o CRUD DE ENDERECOS e validar regras de negocio
 * Implementa  {@link EnderecoDAOLocal}
 *
 */
public class EnderecoDAOImpl implements EnderecoDAOLocal{
	
	private  static EnderecoDAOImpl instance;
	private  EntityManager entityManager;

	
	/**
	 * Retorna a instancia estatica do EnderecoDAOImpl
	 *
	 * @return  {@link EnderecoDAOImpl}
	 * 	  
	 */
	public static EnderecoDAOImpl newInstance() {		
		if(instance == null){			
			instance =  new EnderecoDAOImpl();
		}		
		return instance;
	}
	
    
	public EnderecoDAOImpl() {
        entityManager = getEntityManager();
    }
	
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("estacionamentoServicoEnderecosPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
 
        return entityManager;
    }

	/**
	 * Retorna uma lista de Enderecos dado o Parametro com CEP Existente e VALIDO
	 * @param {@link Endereco}
	 * @return  {@link List< Endereco >}
	 * 	  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> findEnderecoByCep(Endereco endereco) throws DAOException {
		
		Query query = entityManager.createQuery("FROM " + Endereco.class.getName() +" endereco where endereco.cep = :cep");
		query.setParameter("cep", endereco.getCep());
		
		return query.getResultList();		
	}
	
	/**
	 * Salva um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	@Override
	public void saveEndereco(Endereco endereco) throws DAOException {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {            
            entityManager.getTransaction().rollback();
            throw new DAOException(ex);
        }
		
	}

	/**
	 * atualiza um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	@Override
	public void updateEndereco(Endereco endereco) throws DAOException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DAOException(ex);
        }
	}

	/**
	 * deleta um Endereco VALIDO
	 * @param {@link Endereco}
	 * @throws  {@link ServiceException} CASO O ENDERECO informado SEJA INVALIDO
	 * 	  
	 */
	@Override
	public void deleteEndereco(Endereco endereco) throws DAOException {
        try {
            entityManager.getTransaction().begin();
            endereco = entityManager.find(Endereco.class, endereco.getId());
            entityManager.remove(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DAOException(ex);
        }
	}

	/**
	 * Retorna uma lista de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listEnderecos() throws DAOException {
		try{
	        return entityManager.createQuery("FROM " + Endereco.class.getName()).getResultList();
		}catch (Exception ex) {
            throw new DAOException(ex);
        }
	}
	
	/**
	 * limpa a tabela de Enderecos
	 * @return  {@link List<Endereco>}
	 * 	  
	 */
	@Override
	public void clearTableEnderecos() throws DAOException {
        try {
            entityManager.getTransaction().begin();
    		Query query = entityManager.createQuery("DELETE FROM " + Endereco.class.getName());		
    		query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DAOException(ex);
        }

	}
 

}
