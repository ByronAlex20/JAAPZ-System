package ec.com.jaapz.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medidor database table.
 * 
 */
@Entity
@NamedQuery(name="Medidor.findAll", query="SELECT m FROM Medidor m")
public class Medidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medidor")
	private Integer idMedidor;

	private String codigo;

	private String estado;

	private byte[] foto;

	private String marca;

	private String modelo;

	@Column(name="usuario_crea")
	private Integer usuarioCrea;

	//bi-directional many-to-one association to CuentaCliente
	@OneToMany(mappedBy="medidor")
	private List<CuentaCliente> cuentaClientes;

	//bi-directional many-to-one association to EstadoMedidor
	@ManyToOne
	@JoinColumn(name="id_estado")
	private EstadoMedidor estadoMedidor;

	public Medidor() {
	}

	public Integer getIdMedidor() {
		return this.idMedidor;
	}

	public void setIdMedidor(Integer idMedidor) {
		this.idMedidor = idMedidor;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getUsuarioCrea() {
		return this.usuarioCrea;
	}

	public void setUsuarioCrea(Integer usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}

	public List<CuentaCliente> getCuentaClientes() {
		return this.cuentaClientes;
	}

	public void setCuentaClientes(List<CuentaCliente> cuentaClientes) {
		this.cuentaClientes = cuentaClientes;
	}

	public CuentaCliente addCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().add(cuentaCliente);
		cuentaCliente.setMedidor(this);

		return cuentaCliente;
	}

	public CuentaCliente removeCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().remove(cuentaCliente);
		cuentaCliente.setMedidor(null);

		return cuentaCliente;
	}

	public EstadoMedidor getEstadoMedidor() {
		return this.estadoMedidor;
	}

	public void setEstadoMedidor(EstadoMedidor estadoMedidor) {
		this.estadoMedidor = estadoMedidor;
	}

}