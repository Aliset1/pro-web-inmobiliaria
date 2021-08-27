package com.inmobiliaria.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.backend.models.entities.Persona_Natural;
import com.inmobiliaria.backend.models.repositories.IPersona_Natural;
import com.inmobiliaria.backend.models.service.interfaces.IPersona_NaturalService;

@Service
public class Persona_NaturalService implements IPersona_NaturalService{

	@Autowired
	IPersona_Natural repository;
	
	@Override
	@Transactional
	public void save(Persona_Natural personaNatural) {
		repository.save(personaNatural);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Persona_Natural> findById(Integer id) {
		// TODO Auto-generated method stub
		return  repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona_Natural> findAll() {
		// TODO Auto-generated method stub
		return (List<Persona_Natural>) repository.findAll();
	}

}
