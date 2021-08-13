package com.spring.cloud.microservicios.app.usuarios.services;

import java.util.Optional;

import com.spring.cloud.microservicios.app.usuarios.models.entity.Alumno;

public interface AlumnoService {

	public Iterable<Alumno> BuscarTodosAlumnos();
	
	public Optional<Alumno> BuscarAlumnoId(Long idAlumno);
	
	public Alumno guardarAlumno(Alumno alumno);
	
	public void EliminarAlumnoId(Long idAlumno);
}
