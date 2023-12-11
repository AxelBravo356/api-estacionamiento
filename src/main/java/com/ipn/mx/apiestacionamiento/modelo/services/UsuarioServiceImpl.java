package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.apiestacionamiento.modelo.dao.UsuarioDAO;
import com.ipn.mx.apiestacionamiento.modelo.entidades.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	@Transactional(readOnly = false)
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Usuario findById(Long id) {
		return usuarioDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDAO.deleteById(id);
	}

}
