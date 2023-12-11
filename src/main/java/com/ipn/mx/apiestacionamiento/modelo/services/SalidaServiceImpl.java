package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.apiestacionamiento.modelo.dao.SalidaDAO;
import com.ipn.mx.apiestacionamiento.modelo.entidades.Salida;

@Service
public class SalidaServiceImpl implements SalidaService{

	@Autowired
	SalidaDAO dao;
	
	@Override
	@Transactional(readOnly = false)
	public List<Salida> findAll() {
		return (List<Salida>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Salida findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Salida save(Salida salida) {
		return dao.save(salida);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}

}
