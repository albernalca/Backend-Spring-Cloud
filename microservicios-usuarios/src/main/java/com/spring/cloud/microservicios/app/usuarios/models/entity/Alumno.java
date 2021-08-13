package com.spring.cloud.microservicios.app.usuarios.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alumno_id")
	private Long idAlumno;

	@Column(name = "alumno_nombres")
	private String nombresAlumno;

	@Column(name = "alumno_apellidos")
	private String apellidosAlumno;

	@Column(name = "alumno_correo")
	private String correoAlumno;

	@Column(name = "fecha_creacion_alumno")
	@Temporal(TemporalType.TIMESTAMP)
	private Date crearAlumno;
	
	@PrePersist
	public void prepersist() {
		this.crearAlumno = new Date();
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombresAlumno() {
		return nombresAlumno;
	}

	public void setNombresAlumno(String nombresAlumno) {
		this.nombresAlumno = nombresAlumno;
	}

	public String getApellidosAlumno() {
		return apellidosAlumno;
	}

	public void setApellidosAlumno(String apellidosAlumno) {
		this.apellidosAlumno = apellidosAlumno;
	}

	public String getCorreoAlumno() {
		return correoAlumno;
	}

	public void setCorreoAlumno(String correoAlumno) {
		this.correoAlumno = correoAlumno;
	}

	public Date getCrearAlumno() {
		return crearAlumno;
	}

	public void setCrearAlumno(Date crearAlumno) {
		this.crearAlumno = crearAlumno;
	}
	
}
