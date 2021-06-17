package co.com.olsoftware.restservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.olsoftware.restservice.api.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
	

}
