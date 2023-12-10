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
@Table(name="Usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idUsuario;
	
	@NotBlank(message="El nombre del usuario es obligatorio")
	@Size(min=4, max=50, message="El nombre de estar entre 4 y 50 caracteres.")
	@Column(name="nombreUsuario", length=50, nullable = false)
	private String nombreUsuario;
	
	@NotBlank(message="El ap paterno del usuario es obligatorio")
	@Size(min=4, max=50, message="El nombre de estar entre 4 y 50 caracteres.")
	@Column(name="paternoUsuario", length=50, nullable = false)
	private String paternoUsuario;
	
	@NotBlank(message="El ap materno del usuario es obligatorio")
	@Size(min=4, max=50, message="El nombre de estar entre 4 y 50 caracteres.")
	@Column(name="maternoUsuario", length=50, nullable = false)
	private String maternoUsuario;
	
	@Column(name="idMoto", nullable = false)
	private int idMoto;
}
