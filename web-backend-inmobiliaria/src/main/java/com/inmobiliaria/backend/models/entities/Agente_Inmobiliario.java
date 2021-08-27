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
@Table(name="agentesInmobiliarios")
public class Agente_Inmobiliario extends Persona implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idagente_Inmobiliario")
	private Integer idagenteInmobiliario;
	
	@Column(name="comision")
	private float comision;
	
	@Column(name="sector_de_venta")
	private String sectordeVenta;
	
	@OneToOne(mappedBy = "agenteInmobiliario")
	private Contrato contrato;
	
	public Agente_Inmobiliario() {
		super();
	}
	public Agente_Inmobiliario(Integer id) {
		super();
		this.idagenteInmobiliario=id;
	}
	public Integer getIdagenteInmobiliario() {
		return idagenteInmobiliario;
	}
	public void setIdagenteInmobiliario(Integer idagenteInmobiliario) {
		this.idagenteInmobiliario = idagenteInmobiliario;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public String getSectordeVenta() {
		return sectordeVenta;
	}
	public void setSectordeVenta(String sectordeVenta) {
		this.sectordeVenta = sectordeVenta;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	

}
