package co.com.olsoftware.restservice.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "curso")
public class Curso {
	
	
	@Id
	@Column(name="id_curso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	
	@Column(name= "nombre" , nullable = false , length = 150)
	private String nombre;
	
	@Column(name = "estado" , nullable = false , length = 50 )
	private String estado;

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
}
