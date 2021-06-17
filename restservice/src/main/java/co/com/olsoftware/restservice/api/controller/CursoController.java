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
import org.springframework.web.bind.annotation.RestController;

import co.com.olsoftware.restservice.api.entity.Curso;
import co.com.olsoftware.restservice.api.entity.ResponseCurso;
import co.com.olsoftware.restservice.api.service.ICursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private ICursoService serviceCurso;
	
	
	
	@PostMapping("/crear")
	public ResponseCurso crear(@RequestBody  Curso curso) {

		

		return serviceCurso.crear(curso);

	}

	@PutMapping("/actualizar/{idCurso}")
	public ResponseCurso actualizar(@RequestBody Curso curso , @PathVariable("idCurso") int idCurso ) {


		return serviceCurso.actualizar(curso, idCurso);

	}

	@DeleteMapping("/eliminar/{idCurso}")
	public ResponseCurso eliminar(@PathVariable("idCurso") int idCurso) {


		return serviceCurso.eliminar(idCurso);

	}
	
	
	@GetMapping("/listar")
	public List<Curso> listar() {

	
		return serviceCurso.listar();

	}

}
