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

import com.inmobiliaria.backend.models.entities.Inmueble;
import com.inmobiliaria.backend.models.service.interfaces.IInmuebleService;

@RestController
@RequestMapping("/inmueble")
public class InmuebleController {
	//Inyectar el servicio
			@Autowired
			IInmuebleService service;
				
			//CRUD - L
			//Create
			@PostMapping("/create")
			public ResponseEntity<?> create(@RequestBody Inmueble inm) {
				try {
					service.save(inm);
					return ResponseEntity.status(HttpStatus.CREATED).body(inm);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//Retrieve
			@GetMapping("/retrieve/{id}")
			public ResponseEntity<?> retrieve(@PathVariable Integer id) {
				try {
					Optional<Inmueble > inm = service.findById(id);
					if(inm.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inmueble no encontrado");
					}
					return ResponseEntity.ok(inm);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}
			
			//Update
			@PutMapping("/update/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Inmueble inm) {
				try {
					inm.setIdInmueble(id);
					service.save(inm);
					return ResponseEntity.ok(inm);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id) {
				try {
					Optional<Inmueble> inm = service.findById(id);
					if(inm.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inmueble no encontrada");
					}
					service.delete(id);
					return ResponseEntity.ok(inm);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//List
			@GetMapping("/list")
			public ResponseEntity<?> list() {
				try {
					List<Inmueble> inms = service.findAll();
					if(inms.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay inmuebles registradas");
					}
					return ResponseEntity.ok(inms);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}
			


}
