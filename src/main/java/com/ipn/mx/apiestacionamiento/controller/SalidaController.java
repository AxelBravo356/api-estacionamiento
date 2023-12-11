package com.ipn.mx.apiestacionamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.apiestacionamiento.modelo.entidades.Salida;
import com.ipn.mx.apiestacionamiento.modelo.services.SalidaService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class SalidaController {

	@Autowired
    private SalidaService service;
	
	@GetMapping("/salidas")
	public List<Salida> readAll(){
		return service.findAll();
	}
	
	@GetMapping("/salidas/{id}")
	public Salida read(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/salidas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PostMapping("/salida")
	@ResponseStatus(HttpStatus.CREATED)
	public Salida save(@RequestBody Salida salida) {
		return service.save(salida);
	}
	
	@PutMapping("/salidas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Salida update(@RequestBody Salida salida, @PathVariable Long id) {
		Salida p = service.findById(id);
		p.setFechahora(salida.getFechahora());
		return service.save(p);
	}
}
