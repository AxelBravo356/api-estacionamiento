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
import com.ipn.mx.apiestacionamiento.modelo.entidades.SistemaControl;
import com.ipn.mx.apiestacionamiento.modelo.services.SistemaControlService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class SistemaControlController {
	@Autowired
	private SistemaControlService service;
	
	@GetMapping("/sistemascontrol")
	public List<SistemaControl> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/sistemascontrol/{id}")
	public SistemaControl findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/sistemacontrol")
	@ResponseStatus(HttpStatus.CREATED)
	public SistemaControl save( @RequestBody SistemaControl sistemacontrol) {
		return service.save(sistemacontrol);	
	}
	
	@DeleteMapping("/sistemascontrol/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PutMapping("/sistemascontrol/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public SistemaControl update(@RequestBody SistemaControl sistemacontrol, @PathVariable Long id) {
		SistemaControl sc = service.findById(id);
		sc.setAcceso(sistemacontrol.getAcceso());
		return service.save(sc);
	}
}
