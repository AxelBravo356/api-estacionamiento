package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.apiestacionamiento.modelo.dao.EntradaDAO;
import com.ipn.mx.apiestacionamiento.modelo.entidades.Entrada;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	EntradaDAO dao;
	
	@Override
	@Transactional(readOnly = false)
	public List<Entrada> findAll() {
		return (List<Entrada>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Entrada findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Entrada save(Entrada entrada) {
		return dao.save(entrada);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}

}
