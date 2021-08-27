package com.inmobiliaria.backend.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="detalleInmuebles")
public class Detalle_Inmueble implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="iddetalle_Inmueble")
	private Integer iddetalleInmueble;
	
	@Column(name="num_Habitaciones")
	private int cantidadHabitaciones;
	
	@Column(name="num_Banios")
	private int cantidadBanios;
	
	@Column(name="num_Pisos")
	private int cantidadPisos;
	
	@Column(name="num_Parqueaderos")
	private int cantidadParqueaderos;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@JoinColumn(name="id_inmueble", referencedColumnName= "id_inmueble")
	@ManyToOne
	@JsonIgnore
	private Inmueble inmueble;

	public Detalle_Inmueble() {
		super();
	}

	public Detalle_Inmueble(Integer iddetalleInmueble) {
		super();
		this.iddetalleInmueble = iddetalleInmueble;
	}
	

	public Integer getIddetalleInmueble() {
		return iddetalleInmueble;
	}

	public void setIddetalleInmueble(Integer iddetalleInmueble) {
		this.iddetalleInmueble = iddetalleInmueble;
	}

	public int getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}

	public void setCantidadHabitaciones(int cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}

	public int getCantidadBanios() {
		return cantidadBanios;
	}

	public void setCantidadBanios(int cantidadBanios) {
		this.cantidadBanios = cantidadBanios;
	}

	public int getCantidadPisos() {
		return cantidadPisos;
	}

	public void setCantidadPisos(int cantidadPisos) {
		this.cantidadPisos = cantidadPisos;
	}

	public int getCantidadParqueaderos() {
		return cantidadParqueaderos;
	}

	public void setCantidadParqueaderos(int cantidadParqueaderos) {
		this.cantidadParqueaderos = cantidadParqueaderos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	
	

}
