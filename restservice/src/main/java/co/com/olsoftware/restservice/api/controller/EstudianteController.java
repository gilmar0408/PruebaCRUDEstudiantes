package co.com.olsoftware.restservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.olsoftware.restservice.api.entity.Estudiante;
import co.com.olsoftware.restservice.api.entity.ResponseEstudiante;
import co.com.olsoftware.restservice.api.service.ICursoService;
import co.com.olsoftware.restservice.api.service.IEstudianteService;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

	@Autowired
	private IEstudianteService serviceEstudiante;

	@PostMapping("/crear")
	public ResponseEstudiante crear(@RequestBody Estudiante estudiante) {
		
		ResponseEstudiante  resp = new ResponseEstudiante();
		
		if (!estudiante.validarCamposDiligenciados()) {
			
			
			resp.setMensaje("Algunos campos necesarios se encuentran vacios!");
			
		} else if (!estudiante.validarCamposActivo()) {
			
			resp.setMensaje("el estado debe ser ACTIVO/INACTIVO");
			
		}else {
			
			resp = serviceEstudiante.crear(estudiante);
		}
		
		

		return resp;
		
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEstudiante eliminar(@PathVariable("id") int id) {

		ResponseEstudiante  resp = new ResponseEstudiante();
		
		if (id < 1) {
			
			resp.setMensaje("Valide el id del estudiante porfavor");
			
		}else {
			
			resp= serviceEstudiante.eliminar(id);
			
		}
		
		return resp;
	}
	

	
	@GetMapping("/consultar/{id}")
	public ResponseEstudiante consultar(@PathVariable("id") int id) {
		
		ResponseEstudiante  resp = new ResponseEstudiante();
		
		if (id < 1) {
			
			resp.setMensaje("Valide el id del estudiante porfavor");
			
		}else {
			
			resp= serviceEstudiante.buscarPorId(id);
			
		}
		
		return resp;
	}
	
	

	@PutMapping("/actualizar/{id}")
	public ResponseEstudiante Actualizar(@RequestBody Estudiante estudiante , @PathVariable("id") int id) {
		
		ResponseEstudiante  resp = new ResponseEstudiante();
		
		if (!estudiante.validarCamposDiligenciados()) {
			
			if (!estudiante.validarCamposActivo()) {
				
				resp.setMensaje("Algunos campos necesarios se encuentran vacios , el estado debe ser ACTIVO/INACTIVO");
			}
			
			resp.setMensaje("Algunos campos necesarios se encuentran vacios!");
			
		} else {
			
			resp = serviceEstudiante.modificar(estudiante , id);
			
		}

		return resp;
	}

	
	
	
	@GetMapping("/listar")
	public List<Estudiante> Listar() {

		return serviceEstudiante.Listar();
	}

}
