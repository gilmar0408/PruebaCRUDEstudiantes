package co.com.olsoftware.restservice.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.olsoftware.restservice.api.entity.Estudiante;
import co.com.olsoftware.restservice.api.entity.ResponseEstudiante;
import co.com.olsoftware.restservice.api.repository.EstudianteRepository;
import co.com.olsoftware.restservice.api.service.IEstudianteService;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	private EstudianteRepository repoEstudiante;

	public EstudianteService() {

	}

	public EstudianteService(EstudianteRepository repoEstudiante) {

		this.repoEstudiante = repoEstudiante;

	}

	@Override
	public ResponseEstudiante crear(Estudiante estudiante) {

		ResponseEstudiante respuesta = new ResponseEstudiante();

		if (buscarPorCorreo(estudiante.getCorreo())) {

			respuesta.setMensaje("El estudiante ya se encuentra registrado");

		} else {

			repoEstudiante.save(estudiante);
			respuesta.setEstudiante(estudiante);
			respuesta.setMensaje("Estudiante creado exitosamente!");
		}

		return respuesta;
	}

	@Override
	public ResponseEstudiante eliminar(int idEstudiante) {

		ResponseEstudiante resp = new ResponseEstudiante();

		resp = buscarPorId(idEstudiante);

		if (resp.getEstudiante() == null) {

			return resp;

		} else {

			repoEstudiante.delete(resp.getEstudiante());
			resp.setMensaje("Estudiante eliminado exitosamente!");
			

			return resp;

		}

	}

	@Override
	public ResponseEstudiante modificar(Estudiante estudiante , int idEstudiante) {

		ResponseEstudiante resp = new ResponseEstudiante();

		resp = buscarPorId(idEstudiante);

		if (resp.getEstudiante() == null) {

			return resp;

		} else {
			
			
			estudiante.setId(idEstudiante);
			repoEstudiante.save(estudiante);
			resp.setMensaje("Estudiante modificado exitosamente!");
			resp.setEstudiante(estudiante);

			return resp;

		}

	}

	@Override
	public ResponseEstudiante buscarPorId(int idEstudiante) {

		ResponseEstudiante resp = new ResponseEstudiante();

		Optional<Estudiante> encontrado = repoEstudiante.findById(idEstudiante);

		if (encontrado.isPresent()) {

			resp.setMensaje("Estudiante encontrado: ");
			resp.setEstudiante(encontrado.get());

		} else {

			resp.setMensaje("El estudiante no se encuentra registrado: ");

		}

		return resp;
	}

	@Override
	public List<Estudiante> Listar() {

		List<Estudiante> estudiantes = repoEstudiante.findAll();

		return estudiantes;
	}

	@Override
	public Boolean buscarPorCorreo(String correo) {

		List<Estudiante> lista = Listar();

		Boolean encontrado = false;

		for (Estudiante e : lista) {

			if (e.getCorreo().equalsIgnoreCase(correo)) {

				encontrado = true;

			}

		}

		return encontrado;
	}

}
