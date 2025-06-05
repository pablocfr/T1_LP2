package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipoauditoria database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoauditoria.findAll", query="SELECT t FROM Tipoauditoria t")
public class Tipoauditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_tipoAudi;

	private String descripcion;

	public Tipoauditoria() {
	}

	public int getId_tipoAudi() {
		return this.id_tipoAudi;
	}

	public void setId_tipoAudi(int id_tipoAudi) {
		this.id_tipoAudi = id_tipoAudi;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}