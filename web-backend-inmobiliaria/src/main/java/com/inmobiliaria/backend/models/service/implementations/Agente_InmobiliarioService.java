package com.inmobiliaria.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.backend.models.entities.Agente_Inmobiliario;
import com.inmobiliaria.backend.models.repositories.IAgente_Inmobiliario;
import com.inmobiliaria.backend.models.service.interfaces.IAgente_InmobiliarioService;

@Service
public class Agente_InmobiliarioService implements IAgente_InmobiliarioService{

	@Autowired
	IAgente_Inmobiliario repository;
	//no se utiliza instancia, se utiliza inyeccion de dependencia a travez de un decorador
	//@Autowired
	
	@Override
	@Transactional
	public void save(Agente_Inmobiliario agenteInmobiliario) {
		repository.save(agenteInmobiliario);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Agente_Inmobiliario> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Agente_Inmobiliario> findAll() {
		// TODO Auto-generated method stub
		return (List<Agente_Inmobiliario>) repository.findAll();
	}

}
