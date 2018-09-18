package ec.com.jaapz.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the liquidacion_orden database table.
 * 
 */
@Entity
@Table(name="liquidacion_orden")
@NamedQuery(name="LiquidacionOrden.findAll", query="SELECT l FROM LiquidacionOrden l")
public class LiquidacionOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_liquidacion")
	private Integer idLiquidacion;

	private String estado;

	@Column(name="estado_orden")
	private String estadoOrden;

	private Timestamp fecha;

	private double total;

	@Column(name="usuario_crea")
	private Integer usuarioCrea;

	//bi-directional many-to-one association to LiquidacionDetalle
	@OneToMany(mappedBy="liquidacionOrden")
	private List<LiquidacionDetalle> liquidacionDetalles;

	//bi-directional many-to-one association to CuentaCliente
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private CuentaCliente cuentaCliente;

	public LiquidacionOrden() {
	}

	public Integer getIdLiquidacion() {
		return this.idLiquidacion;
	}

	public void setIdLiquidacion(Integer idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoOrden() {
		return this.estadoOrden;
	}

	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getUsuarioCrea() {
		return this.usuarioCrea;
	}

	public void setUsuarioCrea(Integer usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}

	public List<LiquidacionDetalle> getLiquidacionDetalles() {
		return this.liquidacionDetalles;
	}

	public void setLiquidacionDetalles(List<LiquidacionDetalle> liquidacionDetalles) {
		this.liquidacionDetalles = liquidacionDetalles;
	}

	public LiquidacionDetalle addLiquidacionDetalle(LiquidacionDetalle liquidacionDetalle) {
		getLiquidacionDetalles().add(liquidacionDetalle);
		liquidacionDetalle.setLiquidacionOrden(this);

		return liquidacionDetalle;
	}

	public LiquidacionDetalle removeLiquidacionDetalle(LiquidacionDetalle liquidacionDetalle) {
		getLiquidacionDetalles().remove(liquidacionDetalle);
		liquidacionDetalle.setLiquidacionOrden(null);

		return liquidacionDetalle;
	}

	public CuentaCliente getCuentaCliente() {
		return this.cuentaCliente;
	}

	public void setCuentaCliente(CuentaCliente cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}

}