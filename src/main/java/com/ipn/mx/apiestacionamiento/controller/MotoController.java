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

import com.ipn.mx.apiestacionamiento.modelo.entidades.Moto;
import com.ipn.mx.apiestacionamiento.modelo.services.MotoService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class MotoController {
	
	@Autowired
	private MotoService service;
	
	@GetMapping("/motos")
	public List<Moto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/motos/{id}")
	public Moto findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/moto")
	@ResponseStatus(HttpStatus.CREATED)
	public Moto save( @RequestBody Moto moto) {
		return service.save(moto);	
	}
	
	@DeleteMapping("/motos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PutMapping("/motos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Moto update(@RequestBody Moto moto, @PathVariable Long id) {
		Moto m = service.findById(id);
		
		m.setMarcaMoto(moto.getMarcaMoto());
		m.setModeloMoto(moto.getModeloMoto());
		m.setSerieMoto(moto.getSerieMoto());
		m.setPlacasMoto(moto.getPlacasMoto());
		
		return service.save(m);
	}

}
