package com.inmobiliaria.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.backend.models.entities.Contrato;
import com.inmobiliaria.backend.models.repositories.IContrato;
import com.inmobiliaria.backend.models.service.interfaces.IContratoService;

@Service
public class ContratoService implements IContratoService{
	
	@Autowired
	IContrato repository;

	@Override
	@Transactional
	public void save(Contrato contrato) {
		repository.save(contrato);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Contrato> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Contrato> findAll() {
		// TODO Auto-generated method stub
		return (List<Contrato>) repository.findAll();
	}

}
