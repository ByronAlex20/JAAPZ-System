package ec.com.jaapz.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the inspeccion database table.
 * 
 */
@Entity
@NamedQuery(name="Inspeccion.findAll", query="SELECT i FROM Inspeccion i")
public class Inspeccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inspeccion")
	private Integer idInspeccion;

	private String estado;

	@Column(name="estado_inspeccion")
	private String estadoInspeccion;

	private String factibilidad;

	private Timestamp fecha;

	private String habitar;

	@Column(name="id_usu_encargado")
	private Integer idUsuEncargado;

	private String observacion;

	private String referencia;

	@Column(name="usuario_crea")
	private Integer usuarioCrea;

	//bi-directional many-to-one association to Barrio
	@ManyToOne
	@JoinColumn(name="id_barrio")
	private Barrio barrio;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Inspeccion() {
	}

	public Integer getIdInspeccion() {
		return this.idInspeccion;
	}

	public void setIdInspeccion(Integer idInspeccion) {
		this.idInspeccion = idInspeccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoInspeccion() {
		return this.estadoInspeccion;
	}

	public void setEstadoInspeccion(String estadoInspeccion) {
		this.estadoInspeccion = estadoInspeccion;
	}

	public String getFactibilidad() {
		return this.factibilidad;
	}

	public void setFactibilidad(String factibilidad) {
		this.factibilidad = factibilidad;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getHabitar() {
		return this.habitar;
	}

	public void setHabitar(String habitar) {
		this.habitar = habitar;
	}

	public Integer getIdUsuEncargado() {
		return this.idUsuEncargado;
	}

	public void setIdUsuEncargado(Integer idUsuEncargado) {
		this.idUsuEncargado = idUsuEncargado;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getUsuarioCrea() {
		return this.usuarioCrea;
	}

	public void setUsuarioCrea(Integer usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}

	public Barrio getBarrio() {
		return this.barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}