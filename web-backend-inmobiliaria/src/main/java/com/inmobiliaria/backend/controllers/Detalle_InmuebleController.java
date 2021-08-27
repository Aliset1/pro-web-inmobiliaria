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

import com.inmobiliaria.backend.models.entities.Detalle_Inmueble;
import com.inmobiliaria.backend.models.service.interfaces.IDetalle_InmuebleService;

@RestController
@RequestMapping("/detalle")
public class Detalle_InmuebleController {
	//Inyectar el servicio
			@Autowired
			IDetalle_InmuebleService service;
				
			//CRUD - L
			//Create
			@PostMapping("/create")
			public ResponseEntity<?> create(@RequestBody Detalle_Inmueble det) {
				try {
					service.save(det);
					return ResponseEntity.status(HttpStatus.CREATED).body(det);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//Retrieve
			@GetMapping("/retrieve/{id}")
			public ResponseEntity<?> retrieve(@PathVariable Integer id) {
				try {
					Optional<Detalle_Inmueble> det = service.findById(id);
					if(det.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle del inmueble no encontrada");
					}
					return ResponseEntity.ok(det);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}
			
			//Update
			@PutMapping("/update/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Detalle_Inmueble det) {
				try {
					det.setIddetalleInmueble(id);
					service.save(det);
					return ResponseEntity.ok(det);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> update(@PathVariable Integer id) {
				try {
					Optional<Detalle_Inmueble> det = service.findById(id);
					if(det.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle del inmueble no encontrada");
					}
					service.delete(id);
					return ResponseEntity.ok(det);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}
			}
			
			
			//List
			@GetMapping("/list")
			public ResponseEntity<?> list() {
				try {
					List<Detalle_Inmueble> dets = service.findAll();
					if(dets.isEmpty()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay detalles del inmueble registrados");
					}
					return ResponseEntity.ok(dets);
				}
				catch(Exception ex) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
				}		
			}
			

}
