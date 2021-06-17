package co.com.olsoftware.restservice.api.entity;

public class ResponseCurso {
	
	private String mensaje;
	private Curso curso;

	public ResponseCurso() {
		
	}
	
	
	public ResponseCurso(String mensaje,Curso curso) {
		
		this.mensaje = mensaje;
		this.curso = curso;
		
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	
	
	
	
	

}
