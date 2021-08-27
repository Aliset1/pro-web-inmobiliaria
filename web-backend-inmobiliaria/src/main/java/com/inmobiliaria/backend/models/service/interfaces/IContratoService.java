package com.inmobiliaria.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.backend.models.entities.Contrato;

public interface IContratoService {
	public void save(Contrato contrato); 
	public Optional<Contrato> findById(Integer id);
	public void delete(Integer id); 
	public List<Contrato> findAll(); 

}
