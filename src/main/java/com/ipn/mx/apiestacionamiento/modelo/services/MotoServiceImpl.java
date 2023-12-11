package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.apiestacionamiento.modelo.dao.MotoDAO;
import com.ipn.mx.apiestacionamiento.modelo.entidades.Moto;

@Service
public class MotoServiceImpl implements MotoService{

	@Autowired
	MotoDAO motoDAO;
	
	@Override
	@Transactional(readOnly = false)
	public List<Moto> findAll() {
		return (List<Moto>) motoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Moto findById(Long id) {
		return motoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Moto save(Moto moto) {
		return motoDAO.save(moto);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		motoDAO.deleteById(id);
	}


}
