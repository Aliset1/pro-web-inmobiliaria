package com.inmobiliaria.backend.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="personasNatural")
public class Persona_Natural extends Persona implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idpersona_Natural")
	private Integer idpersonaNatural;
	
	@OneToOne(mappedBy = "comprador")
	private Contrato compradorContrato;
	
	@OneToOne(mappedBy = "vendedor")
	private Contrato vendedorContrato;
	
	public Persona_Natural() {
		super();
	}

	public Persona_Natural(Integer idpersonaNatural) {
		super();
		this.idpersonaNatural = idpersonaNatural;
	}

	
	public Integer getIdpersonaNatural() {
		return idpersonaNatural;
	}

	public void setIdpersonaNatural(Integer idpersonaNatural) {
		this.idpersonaNatural = idpersonaNatural;
	}

	public Contrato getCompradorContrato() {
		return compradorContrato;
	}

	public void setCompradorContrato(Contrato compradorContrato) {
		this.compradorContrato = compradorContrato;
	}

	public Contrato getVendedorContrato() {
		return vendedorContrato;
	}

	public void setVendedorContrato(Contrato vendedorContrato) {
		this.vendedorContrato = vendedorContrato;
	}


	

}
