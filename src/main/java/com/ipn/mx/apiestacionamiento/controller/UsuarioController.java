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

import com.ipn.mx.apiestacionamiento.modelo.entidades.Usuario;
import com.ipn.mx.apiestacionamiento.modelo.services.UsuarioService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> readAll(){
		return service.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario read(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario usuario) {
		return service.save(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario u = service.findById(id);
		
		u.setNombreUsuario(usuario.getNombreUsuario());
		u.setPaternoUsuario(usuario.getPaternoUsuario());
		u.setMaternoUsuario(usuario.getMaternoUsuario());
		//u.setIdMoto(usuario.getIdMoto());
		u.setIdMoto(usuario.getMoto());
		/*
		p.setNombreProducto(producto.getNombreProducto());
		p.setDescripcionProducto(producto.getDescripcionProducto());
		p.setExistencia(producto.getExistencia());
		p.setIdCategoria(producto.getIdCategoria());
		*/
		return service.save(u);
	}
	
	
}
