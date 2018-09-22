package com.estacionamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
@Table(name="Endereco")
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2182007586220830796L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="id")	
	private Long   id;
	
	@Column(name="numero")	
	private Long   numero;
	
	@Column(name="cep")	
	private String cep;
	
	@Column(name="rua")	
	private String rua;
	
	@Column(name="bairro")	
	private String bairro;
	
	@Column(name="complemento")	
	private String complemento;
	
	@Column(name="estado")	
	private String estado;
	
	@Column(name="cidade")	
	private String cidade;
	
	
	
	public Endereco() {
		super();
	}

	public Endereco(Long id,Long numero,String cep, String rua, String bairro,String complemento, String estado,
			String cidade) {
		super();
		this.id = id;
		this.numero = numero;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.estado = estado;
		this.cidade = cidade;
	}
	
	
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}


	
	
	
}
