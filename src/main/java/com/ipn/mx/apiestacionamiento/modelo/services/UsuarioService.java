package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import com.ipn.mx.apiestacionamiento.modelo.entidades.Usuario;


public interface UsuarioService {
	
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario usuario);
	public void delete(Long id);
}
