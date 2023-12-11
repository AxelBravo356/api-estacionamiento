package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import com.ipn.mx.apiestacionamiento.modelo.entidades.Salida;

public interface SalidaService {
	public List<Salida> findAll();
	public Salida findById(Long id);
	public Salida save(Salida salida);
	public void delete(Long id);
}
