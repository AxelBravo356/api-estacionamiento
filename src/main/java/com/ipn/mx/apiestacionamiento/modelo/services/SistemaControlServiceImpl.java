package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.apiestacionamiento.modelo.dao.SistemaControlDAO;
import com.ipn.mx.apiestacionamiento.modelo.entidades.SistemaControl;

@Service
public class SistemaControlServiceImpl implements SistemaControlService{

	@Autowired
	SistemaControlDAO sistemaDAO;
	
	@Override
	@Transactional(readOnly = false)
	public List<SistemaControl> findAll() {
		return (List<SistemaControl>) sistemaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public SistemaControl findById(Long id) {
		return sistemaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public SistemaControl save(SistemaControl sc) {
		return sistemaDAO.save(sc);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		sistemaDAO.deleteById(id);
	}

}
