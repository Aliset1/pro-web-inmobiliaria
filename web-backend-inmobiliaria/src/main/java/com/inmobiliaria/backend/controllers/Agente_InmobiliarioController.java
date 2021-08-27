package com.inmobiliaria.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.backend.models.entities.Agente_Inmobiliario;
import com.inmobiliaria.backend.models.service.interfaces.IAgente_InmobiliarioService;

@RestController
@RequestMapping("/agente")
public class Agente_InmobiliarioController {
	//Inyectar el servicio
		@Autowired
		IAgente_InmobiliarioService service;
			
		//CRUD - L
		//Create
		@PostMapping("/create")
		public ResponseEntity<?> create(@RequestBody Agente_Inmobiliario agente) {
			try {
				service.save(agente);
				return ResponseEntity.status(HttpStatus.CREATED).body(agente);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}
		}
		
		
		//Retrieve
		@GetMapping("/retrieve/{id}")
		public ResponseEntity<?> retrieve(@PathVariable Integer id) {
			try {
				Optional<Agente_Inmobiliario> agente = service.findById(id);
				if(agente.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agente no encontrada");
				}
				return ResponseEntity.ok(agente);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}		
		}
		
		//Update
		@PutMapping("/update/{id}")
		public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Agente_Inmobiliario agente) {
			try {
				agente.setIdagenteInmobiliario(id);
				service.save(agente);
				return ResponseEntity.ok(agente);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}
		}
		
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> update(@PathVariable Integer id) {
			try {
				Optional<Agente_Inmobiliario> agente = service.findById(id);
				if(agente.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agente no encontrada");
				}
				service.delete(id);
				return ResponseEntity.ok(agente);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}
		}
		
		
		//List
		@GetMapping("/list")
		public ResponseEntity<?> list() {
			try {
				List<Agente_Inmobiliario> agente = service.findAll();
				if(agente.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay agentes registrados");
				}
				return ResponseEntity.ok(agente);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}		
		}
		

}
