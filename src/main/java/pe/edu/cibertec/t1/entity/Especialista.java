package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especialista database table.
 * 
 */
@Entity
@NamedQuery(name="Especialista.findAll", query="SELECT e FROM Especialista e")
public class Especialista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_especialista")
	private int idEspecialista;

	private String correo;

	private String dni;

	private String especialidad;

	private String nombre;

	public Especialista() {
	}

	public int getIdEspecialista() {
		return this.idEspecialista;
	}

	public void setIdEspecialista(int idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}