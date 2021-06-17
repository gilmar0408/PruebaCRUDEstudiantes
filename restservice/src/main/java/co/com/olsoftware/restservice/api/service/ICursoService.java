package co.com.olsoftware.restservice.api.service;

import java.util.List;

import co.com.olsoftware.restservice.api.entity.Curso;
import co.com.olsoftware.restservice.api.entity.ResponseCurso;

public interface ICursoService {
	
	ResponseCurso crear (Curso curso);
	ResponseCurso actualizar (Curso curso , int idCurso);
	ResponseCurso eliminar (int id);
	ResponseCurso buscarPorId (int id);
	List<Curso>  listar ();
	
}
