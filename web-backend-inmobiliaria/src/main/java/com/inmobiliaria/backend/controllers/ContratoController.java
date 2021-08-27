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

import com.inmobiliaria.backend.models.entities.Contrato;
import com.inmobiliaria.backend.models.service.interfaces.IContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

	//Inyectar el servicio
			@Autowired
			IContratoService service;
				
			//CRUD - L
			//Create
			@PostMapping("/create")
			public ResponseEntity<?> create(@RequestBody Contrato cont) {
				try {
					service.save(cont);
					return ResponseEntity.status(HttpStatus.CREATED).body(cont);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//Retrieve
			@GetMapping("/retrieve/{id}")
			public ResponseEntity<?> retrieve(@PathVariable Integer id) {
				try {
					Optional<Contrato> cont = service.findById(id);
					if(cont.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato no encontrada");
					}
					return ResponseEntity.ok(cont);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}
			
			//Update
			@PutMapping("/update/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Contrato cont) {
				try {
					cont.setIdContrato(id);
					service.save(cont);
					return ResponseEntity.ok(cont);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id) {
				try {
					Optional<Contrato> cont = service.findById(id);
					if(cont.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("contrato no encontrada");
					}
					service.delete(id);
					return ResponseEntity.ok(cont);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//List
			@GetMapping("/list")
			public ResponseEntity<?> list() {
				try {
					List<Contrato> conts = service.findAll();
					if(conts.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay contratos registradas");
					}
					return ResponseEntity.ok(conts);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}
}
