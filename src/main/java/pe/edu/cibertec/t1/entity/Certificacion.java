package pe.edu.cibertec.t1.entity;

import java.io.Serializable;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
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

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_tipoAudi")
	private Tipoauditoria tipoauditoria;

	@ManyToOne
	@JoinColumn(name = "id_especialista")
	private Especialista especialista;

	

	public Certificacion() {
	}


}