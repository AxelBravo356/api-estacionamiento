package com.ipn.mx.apiestacionamiento.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.apiestacionamiento.modelo.entidades.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

}
