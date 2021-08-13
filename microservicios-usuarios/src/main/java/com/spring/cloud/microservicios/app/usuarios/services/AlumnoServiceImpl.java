package com.spring.cloud.microservicios.app.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.cloud.microservicios.app.usuarios.models.entity.Alumno;
import com.spring.cloud.microservicios.app.usuarios.models.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository repositorioAlumnos;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> BuscarTodosAlumnos() {
		// TODO Auto-generated method stub
		return repositorioAlumnos.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> BuscarAlumnoId(Long idAlumno) {
		// TODO Auto-generated method stub
		return repositorioAlumnos.findById(idAlumno);
	}

	@Override
	@Transactional
	public Alumno guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return repositorioAlumnos.save(alumno);
	}

	@Override
	@Transactional
	public void EliminarAlumnoId(Long idAlumno) {
		// TODO Auto-generated method stub
		repositorioAlumnos.deleteById(idAlumno);
	}

}
