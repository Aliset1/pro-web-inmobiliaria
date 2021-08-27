package com.inmobiliaria.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.backend.models.entities.Detalle_Inmueble;
import com.inmobiliaria.backend.models.entities.Inmueble;
import com.inmobiliaria.backend.models.repositories.IDetalle_Inmueble;
import com.inmobiliaria.backend.models.repositories.IInmueble;
import com.inmobiliaria.backend.models.service.interfaces.IInmuebleService;

@Service
public class InmuebleService implements IInmuebleService{
	
	@Autowired
	IInmueble repository;
	
	@Autowired
	IDetalle_Inmueble repositorydi;
	

	@Override
	@Transactional
	public void save(Inmueble inmueble) {
		repository.save(inmueble);
		
		for(Detalle_Inmueble b : inmueble.getDivisiones()) {
			b.setInmueble(inmueble);
			repositorydi.save(b);
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Inmueble> findById(Integer id) {
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
	public List<Inmueble> findAll() {
		// TODO Auto-generated method stub
		return (List<Inmueble>) repository.findAll();
	}

}
