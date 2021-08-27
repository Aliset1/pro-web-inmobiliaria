package com.inmobiliaria.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;
import com.inmobiliaria.backend.models.entities.Contrato;

public interface IContrato extends CrudRepository<Contrato, Integer> {

}
