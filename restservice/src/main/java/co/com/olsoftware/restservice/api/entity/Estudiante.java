package co.com.olsoftware.restservice.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", nullable = false, length = 150)
	private String nombre;

	@Column(name = "segundo_nombre", nullable = true, length = 150)
	private String segundoNombre;

	@Column(name = "apellido", nullable = false, length = 150)
	private String apellido;

	@Column(name = "segundo_apellido", nullable = true, length = 150)
	private String segundoApellido;

	@Column(name = "correo", nullable = false, length = 150)
	private String correo;

	@Column(name = "estado", nullable = false, length = 50)
	private String estado;

	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;

	@OneToOne
	@JoinColumn(name = "curso")
	private Curso curso;

	public 	boolean validarCamposDiligenciados() {
		
		Boolean esValido = true;
		
		if (nombre == null || nombre == "" ||
			apellido==null || apellido=="" ||
			correo == null || correo == "" ||
			String.valueOf(fechaNacimiento) == null || 
			curso.getNombre() == null || curso.getNombre() == "" ) {
			
			esValido= false;
			
		}
		
		
		return esValido;
	}

	public Boolean validarCamposActivo() {
		
		Boolean estadoEsValido = true;
		
		if (!(estado.equalsIgnoreCase("activo") || estado.equalsIgnoreCase("inactivo")) ||
		    !(curso.getEstado().equalsIgnoreCase("activo") || curso.getEstado().equalsIgnoreCase("inactivo"))) {
			
			estadoEsValido= false;
			
		}
		
		return estadoEsValido;
		
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
