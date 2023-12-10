package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.mx.apiestacionamiento.modelo.dao.UsuarioDAO;
import com.ipn.mx.apiestacionamiento.modelo.entidades.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioDAO.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDAO.save(usuario);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioDAO.deleteById(id);
	}

}
