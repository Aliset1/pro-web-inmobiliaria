package com.inmobiliaria.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;
import com.inmobiliaria.backend.models.entities.Inmueble;

public interface IInmueble extends CrudRepository<Inmueble, Integer>{

}
