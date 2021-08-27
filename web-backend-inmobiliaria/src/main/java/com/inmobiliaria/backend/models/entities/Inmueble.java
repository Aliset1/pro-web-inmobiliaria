package com.inmobiliaria.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="inmuebles")
public class Inmueble implements Serializable{
	private static final long serialVersionUID=1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_inmueble")
	private Integer idInmueble;
	
	@Column(name="metros_Cuadrados")
	private float metrosCuadrado;
	
	@Column(name="fecha_Construccion")
	private Calendar fechaConstruccion;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="costo_Inmueble")
	private float costoInmueble;
	
	@Column(name="tipo_Inmueble")
	private String tipoInmueble;
	
	@Column(name="estado_Inmueble")
	private String estadoInmueble;
	
	@OneToMany(mappedBy="inmueble", fetch = FetchType.LAZY)	
	private List<Detalle_Inmueble> divisiones;
	
	@OneToOne(mappedBy = "inmueble")
	private Contrato contrato;
	
	public Inmueble() {
		super();
	}
	public Inmueble(int id) {
		super();
		this.idInmueble=id;
	}
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	public float getMetrosCuadrado() {
		return metrosCuadrado;
	}
	public void setMetrosCuadrado(float metrosCuadrado) {
		this.metrosCuadrado = metrosCuadrado;
	}
	public Calendar getFechaConstruccion() {
		return fechaConstruccion;
	}
	public void setFechaConstruccion(Calendar fechaConstruccion) {
		this.fechaConstruccion = fechaConstruccion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public float getCostoInmueble() {
		return costoInmueble;
	}
	public void setCostoInmueble(float costoInmueble) {
		this.costoInmueble = costoInmueble;
	}
	public String getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	public String isEstadoInmueble() {
		return estadoInmueble;
	}
	public void setEstadoInmueble(String estadoInmueble) {
		this.estadoInmueble = estadoInmueble;
	}
	public List<Detalle_Inmueble> getDivisiones() {
		return divisiones;
	}
	public void setDivisiones(List<Detalle_Inmueble> divisiones) {
		this.divisiones = divisiones;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
}
