package com.inmobiliaria.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.backend.models.entities.Detalle_Inmueble;

public interface IDetalle_InmuebleService {
	public void save(Detalle_Inmueble detalleInmueble); 
	public Optional<Detalle_Inmueble> findById(Integer id);
	public void delete(Integer id); 
	public List<Detalle_Inmueble> findAll(); 

}
