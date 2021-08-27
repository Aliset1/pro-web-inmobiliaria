package com.inmobiliaria.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="contratos")
public class Contrato implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_contrato")
	private Integer idContrato;
	
	@Column(name="fecha_contrato")
	private Calendar fechaContrato;
	
	@Column(name="gastos_Extra")
	private float gastosExtra;
	
	@Column(name="monto_total")
	private float montoTotal;
	
	@JoinColumn(name="id_comprador", nullable=false)
	@OneToOne(fetch=FetchType.LAZY)
	private Persona_Natural comprador;
	
	@JoinColumn(name="id_vendedor", nullable=false)
	@OneToOne(fetch=FetchType.LAZY)
	private Persona_Natural vendedor;
	
	
	@JoinColumn(name="idagente_Inmobiliario", nullable=false)
	@OneToOne(fetch=FetchType.LAZY)
	private Agente_Inmobiliario agenteInmobiliario;
	
	@JoinColumn(name="id_inmueble", nullable=false)
	@OneToOne(fetch=FetchType.LAZY)
	private Inmueble inmueble;
	
	public Contrato() {
		super();
	}
	public Contrato(int id) {
		super();
		this.idContrato=id;
	}
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Calendar getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Calendar fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public float getGastosExtra() {
		return gastosExtra;
	}
	public void setGastosExtra(float gastosExtra) {
		this.gastosExtra = gastosExtra;
	}
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public Persona_Natural getComprador() {
		return comprador;
	}
	public void setComprador(Persona_Natural comprador) {
		this.comprador = comprador;
	}
	public Persona_Natural getVendedor() {
		return vendedor;
	}
	public void setVendedor(Persona_Natural vendedor) {
		this.vendedor = vendedor;
	}
	public Agente_Inmobiliario getAgenteInmobiliario() {
		return agenteInmobiliario;
	}
	public void setAgenteInmobiliario(Agente_Inmobiliario agenteInmobiliario) {
		this.agenteInmobiliario = agenteInmobiliario;
	}
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	
}