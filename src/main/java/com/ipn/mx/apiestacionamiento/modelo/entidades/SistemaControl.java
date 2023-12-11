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
@Table(name="SistemaControl")
public class SistemaControl implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSistemaControl;
	
	@NotBlank(message="El nombre del acceso es un campo obligatorio")
	@Size(min=4, max=50, message="El nombre debe de estar entre 4 y 50 caracteres.")
	@Column(name="acceso", length=45, nullable = false)
	private String acceso;
}
