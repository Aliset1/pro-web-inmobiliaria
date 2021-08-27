package com.inmobiliaria.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.backend.models.entities.Persona_Natural;

public interface IPersona_NaturalService {
	public void save(Persona_Natural personaNatural); 
	public Optional<Persona_Natural> findById(Integer id);
	public void delete(Integer id); 
	public List<Persona_Natural> findAll(); 

}
