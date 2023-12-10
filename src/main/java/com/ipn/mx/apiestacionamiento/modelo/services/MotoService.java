package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;


import com.ipn.mx.apiestacionamiento.modelo.entidades.Moto;

public interface MotoService {
	public List<Moto> findAll();
	public Moto findById(Long id);
	public Moto save(Moto moto);
	public void delete(Long id);
}
