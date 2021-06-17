package co.com.olsoftware.restservice.api.entity;

public class ResponseEstudiante {
	
	private String mensaje;
	private Estudiante estudiante;
	

	public ResponseEstudiante() {
		
	}
	
	public ResponseEstudiante(String mensaje , Estudiante estudiante) {
		
		this.mensaje = mensaje;
		this.estudiante = estudiante;
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	
	
	
	

}
