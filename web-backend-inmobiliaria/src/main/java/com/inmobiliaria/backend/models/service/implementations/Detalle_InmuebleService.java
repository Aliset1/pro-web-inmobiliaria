package com.inmobiliaria.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.backend.models.entities.Detalle_Inmueble;
import com.inmobiliaria.backend.models.repositories.IDetalle_Inmueble;
import com.inmobiliaria.backend.models.service.interfaces.IDetalle_InmuebleService;

@Service
public class Detalle_InmuebleService implements IDetalle_InmuebleService{

	@Autowired
	IDetalle_Inmueble repository;
	
	@Override
	@Transactional
	public void save(Detalle_Inmueble detalleInmueble) {
		repository.save(detalleInmueble);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Detalle_Inmueble> findById(Integer id) {
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
	public List<Detalle_Inmueble> findAll() {
		// TODO Auto-generated method stub
		return (List<Detalle_Inmueble>) repository.findAll();
	}

}
