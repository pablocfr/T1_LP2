package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the certificacion database table.
 * 
 */
@Entity
@NamedQuery(name="Certificacion.findAll", query="SELECT c FROM Certificacion c")
public class Certificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_certificacion")
	private int idCertificacion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_emi")
	private Date fechaEmi;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ven")
	private Date fechaVen;

	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="id_especialista")
	private int idEspecialista;

	private int id_tipoAudi;

	public Certificacion() {
	}

	public int getIdCertificacion() {
		return this.idCertificacion;
	}

	public void setIdCertificacion(int idCertificacion) {
		this.idCertificacion = idCertificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEmi() {
		return this.fechaEmi;
	}

	public void setFechaEmi(Date fechaEmi) {
		this.fechaEmi = fechaEmi;
	}

	public Date getFechaVen() {
		return this.fechaVen;
	}

	public void setFechaVen(Date fechaVen) {
		this.fechaVen = fechaVen;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEspecialista() {
		return this.idEspecialista;
	}

	public void setIdEspecialista(int idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public int getId_tipoAudi() {
		return this.id_tipoAudi;
	}

	public void setId_tipoAudi(int id_tipoAudi) {
		this.id_tipoAudi = id_tipoAudi;
	}

}