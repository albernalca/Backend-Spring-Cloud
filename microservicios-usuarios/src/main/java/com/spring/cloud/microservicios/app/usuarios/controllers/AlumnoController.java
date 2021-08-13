package com.spring.cloud.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.microservicios.app.usuarios.models.entity.Alumno;
import com.spring.cloud.microservicios.app.usuarios.services.AlumnoService;

@RestController
public class AlumnoController {
	
	@Autowired
	private AlumnoService servicioAlumno;
	
	@GetMapping
	public ResponseEntity<?> listarAlumnos(){
		return ResponseEntity.ok().body(servicioAlumno.BuscarTodosAlumnos());
	}
	
	@GetMapping("/{idXAlumno}")
	public ResponseEntity<?> idXAlumno(@PathVariable Long idXAlumno){
		
		Optional<Alumno> o= servicioAlumno.BuscarAlumnoId(idXAlumno);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());
	}
	
	@GetMapping
	public ResponseEntity<?> crearAlumno(@RequestBody Alumno alumno){
		
		Alumno alumnoDB= servicioAlumno.guardarAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDB);
	}
	
	@PutMapping("/{idXAlumno}")
	public ResponseEntity<?> editarAlumno(@RequestBody Alumno alumno, @PathVariable Long idXAlumno){
		
		Optional<Alumno> o= servicioAlumno.BuscarAlumnoId(idXAlumno);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoDB =o.get();
		alumnoDB.setNombresAlumno(alumno.getNombresAlumno());
		alumnoDB.setApellidosAlumno(alumno.getApellidosAlumno());
		alumnoDB.setCorreoAlumno(alumno.getCorreoAlumno());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioAlumno.guardarAlumno(alumnoDB));
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> eliminarAlumno(@PathVariable Long idXAlumno){
		
		servicioAlumno.EliminarAlumnoId(idXAlumno);
		return ResponseEntity.noContent().build();
		
	}

}
