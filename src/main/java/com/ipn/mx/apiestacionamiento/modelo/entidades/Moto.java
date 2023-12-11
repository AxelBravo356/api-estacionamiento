package com.ipn.mx.apiestacionamiento.modelo.entidades;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="Moto")
public class Moto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMoto;
	
	@NotBlank(message="La marca es un campo obligatorio")
	@Size(min=4, max=45, message="La marca de estar entre 4 y 45 caracteres.")
	@Column(name="marcaMoto", length=45, nullable = false)
	private String marcaMoto;
	
	
	@NotBlank(message="El modelo es un campo obligatorio")
	@Size(min=4, max=45, message="El modelo de estar entre 4 y 45 caracteres.")
	@Column(name="modeloMoto", length=45, nullable = false)
	private String modeloMoto;
	
	@NotBlank(message="La serie es un campo obligatorio")
	@Size(min=4, max=45, message="La serie de estar entre 4 y 45 caracteres.")
	@Column(name="serieMoto", length=45, nullable = false)
	private String serieMoto;
	
	@NotBlank(message="La marca es un campo obligatorio")
	@Size(min=6, max=10, message="La marca de estar entre 6 y 10 caracteres.")
	@Column(name="placas", length=45, nullable = false)
	private String placasMoto;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="idUsuario")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Usuario idUsuario;
	
	public void setIdUsuario(Usuario usuario) {
		this.idUsuario = usuario;
	}
	
}
