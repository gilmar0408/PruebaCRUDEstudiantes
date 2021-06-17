package co.com.olsoftware.restservice.api.service;

import java.util.List;

import co.com.olsoftware.restservice.api.entity.Estudiante;
import co.com.olsoftware.restservice.api.entity.ResponseEstudiante;

public interface IEstudianteService {
	
	ResponseEstudiante  crear (Estudiante estudiante);
	ResponseEstudiante  eliminar (int idEstudiante);
	ResponseEstudiante  modificar (Estudiante estudiante , int idEstudiante);
	ResponseEstudiante  buscarPorId (int idEstudiante);
	Boolean  buscarPorCorreo (String correo);
	List<Estudiante>    Listar();

	
}
