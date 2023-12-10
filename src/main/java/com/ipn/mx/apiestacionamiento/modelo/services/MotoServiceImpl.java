package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.mx.apiestacionamiento.modelo.dao.MotoDAO;
import com.ipn.mx.apiestacionamiento.modelo.entidades.Moto;

@Service
public class MotoServiceImpl implements MotoService{

	@Autowired
	MotoDAO motoDAO;
	
	@Override
	public List<Moto> findAll() {
		return (List<Moto>) motoDAO.findAll();
	}

	@Override
	public Moto findById(Long id) {
		return motoDAO.findById(id).orElse(null);
	}

	@Override
	public Moto save(Moto moto) {
		return motoDAO.save(moto);
	}

	@Override
	public void delete(Long id) {
		motoDAO.deleteById(id);
	}


}
