package com.ipn.mx.apiestacionamiento.modelo.services;

import java.util.List;

import com.ipn.mx.apiestacionamiento.modelo.entidades.Entrada;

public interface EntradaService {
	public List<Entrada> findAll();
	public Entrada findById(Long id);
	public Entrada save(Entrada entrada);
	public void delete(Long id);
}
