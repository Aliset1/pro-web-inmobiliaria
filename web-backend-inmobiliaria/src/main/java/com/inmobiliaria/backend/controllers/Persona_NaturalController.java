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

import com.inmobiliaria.backend.models.entities.Persona_Natural;
import com.inmobiliaria.backend.models.service.interfaces.IPersona_NaturalService;

@RestController
@RequestMapping("/persona")
public class Persona_NaturalController {
	//Inyectar el servicio
			@Autowired
			IPersona_NaturalService service;
				
			//CRUD - L
			//Create
			@PostMapping("/create")
			public ResponseEntity<?> create(@RequestBody Persona_Natural per) {
				try {
					service.save(per);
					return ResponseEntity.status(HttpStatus.CREATED).body(per);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//Retrieve
			@GetMapping("/retrieve/{id}")
			public ResponseEntity<?> retrieve(@PathVariable Integer id) {
				try {
					Optional<Persona_Natural> per = service.findById(id);
					if(per.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada");
					}
					return ResponseEntity.ok(per);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}
			
			//Update
			@PutMapping("/update/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Persona_Natural per) {
				try {
					per.setIdpersonaNatural(id);
					service.save(per);
					return ResponseEntity.ok(per);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id) {
				try {
					Optional<Persona_Natural> per = service.findById(id);
					if(per.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada");
					}
					service.delete(id);
					return ResponseEntity.ok(per);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//List
			@GetMapping("/list")
			public ResponseEntity<?> list() {
				try {
					List<Persona_Natural> pers = service.findAll();
					if(pers.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay personas registradas");
					}
					return ResponseEntity.ok(pers);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}

}
