package co.com.olsoftware.restservice.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.com.olsoftware.restservice.api.entity.Curso;
import co.com.olsoftware.restservice.api.entity.ResponseCurso;
import co.com.olsoftware.restservice.api.repository.CursoRepository;
import co.com.olsoftware.restservice.api.service.ICursoService;


@Service
public class CursoService implements ICursoService {
	
	
	
	
	@Autowired
	private CursoRepository repoCurso;
	
	
	public CursoService () {
		
		
	}
	
	
	public CursoService (CursoRepository repoCurso) {
		
		this.repoCurso = repoCurso;
	}
	
	

	@Override
	public ResponseCurso crear(Curso curso) {
		
		ResponseCurso resp = new ResponseCurso();
		
		
		List<Curso>  cursos = listar();
		
		boolean encontrado = false;
		
		for (Curso c : cursos) {
			
			if (c.getNombre().equalsIgnoreCase(curso.getNombre())) {
				encontrado= true;
				resp.setMensaje("El curso ya se encuentra registrado");
			}
			
		}
		
		if (!encontrado) {
			
			repoCurso.save(curso);
			resp.setMensaje("Se ha registrado el curso con exito!");
			resp.setCurso(curso);
			
		}
		
		
		return resp;
	}

	@Override
	public ResponseCurso actualizar(Curso curso , int idCurso) {
		
		ResponseCurso resp = new ResponseCurso();
		
		Optional<Curso> encontrado = repoCurso.findById(idCurso);
		
		
		if (encontrado.isPresent()) {
			
			resp.setCurso(encontrado.get());
			resp.getCurso().setIdCurso(idCurso);
			repoCurso.save(resp.getCurso());
			resp.setMensaje("Curso actualizado exitosamente!");
		
			
		}else {
			
			resp.setMensaje("Porfavor validar id del curso , no se encuentra registrado");
		}
		
		return resp;
	}

	@Override
	public ResponseCurso eliminar(int id) {
		
		ResponseCurso resp = new ResponseCurso();
		
		Optional<Curso> encontrado = repoCurso.findById(id);
		
		
		if (encontrado.isPresent()) {
			
			repoCurso.delete(encontrado.get());
			resp.setMensaje("Curso eliminado exitosamente");
			resp.setCurso(encontrado.get());
			
		}else {
			
			resp.setMensaje("Porfavor validar id del curso , no se encuentra registrado");
		}
		
		
		return resp;
	}

	@Override
	public ResponseCurso buscarPorId(int id) {
		
		ResponseCurso resp = new ResponseCurso();
		
		Optional<Curso> encontrado = repoCurso.findById(id);
		
		if (encontrado.isPresent()) {
			
			resp.setMensaje("Curso encontrado: ");
			resp.setCurso(encontrado.get());
			
		}
		
		return resp;
	}

	
	
	@Override
	public List<Curso> listar() {
		
		List<Curso> cursos = repoCurso.findAll();
		
		return cursos;
	}

}
