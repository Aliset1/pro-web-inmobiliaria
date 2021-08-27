package com.inmobiliaria.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.backend.models.entities.Agente_Inmobiliario;

public interface IAgente_InmobiliarioService {
	//La interface del servicio, sirve para definir el conjunto de métodos que 
		//se van a implementar para la Gestión del modelo-entidad	
		
		public void save(Agente_Inmobiliario agenteInmobiliario); //Guardar -> Create / Update
		public Optional<Agente_Inmobiliario> findById(Integer id); //Consultar -> Retrieve
		public void delete(Integer id); //Borrar -> Delete
		public List<Agente_Inmobiliario> findAll(); //Consultar en conjunto -> List
}
