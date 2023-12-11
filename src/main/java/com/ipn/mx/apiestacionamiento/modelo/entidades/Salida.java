package com.ipn.mx.apiestacionamiento.modelo.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="Salida")
public class Salida implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSalida;
	
	@NotBlank(message="time: campo obligatorio")
	@Size(min=4, max=10, message="La fecha de estar entre 4 y 10 caracteres.")
	@Column(name="fechahora", length=10, nullable = false)
	private String fechahora;
	
	@Column(name="idMoto", nullable = false)
	private int idMoto;
	
	@Column(name="idSistemaControl", nullable = false)
	private int idSistemaControl;
}
