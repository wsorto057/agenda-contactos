package com.agenda.contactos.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Contacto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="Debe ingresar un nombre")
	private String nombre;
	
	@NotBlank(message="Debe ingresar un apellido")
	private String apellido;
	
	@NotEmpty(message="Debe ingresar un email")
	@Email
	private String email;
	
	@NotBlank(message="Debe ingresar un celular")
	private String celular;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Past
	@NotNull(message="Debe ingresar fecha de nacimiento")
	private LocalDate fechaNacimiento;
	
	
	private LocalDateTime fechaRegistro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	@PrePersist
	public void asignarFechaRegistro() {
		fechaRegistro= LocalDateTime.now();
	}
	
	
	
	public Contacto(Integer id, String nombre, String apellido, String email, String celular,
			LocalDate fechaNacimiento, LocalDateTime fechaRegistro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.celular = celular;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
	}

	public Contacto() {
		super();
	}
	
	
	
	
}
