package com.inmobiliaria.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.backend.models.entities.Inmueble;

public interface IInmuebleService {
	public void save(Inmueble inmueble); 
	public Optional<Inmueble> findById(Integer id);
	public void delete(Integer id); 
	public List<Inmueble> findAll(); 

}
