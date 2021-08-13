package com.spring.cloud.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.cloud.microservicios.app.usuarios.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
