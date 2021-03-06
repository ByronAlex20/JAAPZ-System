package ec.com.jaapz.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the liquidacion_detalle database table.
 * 
 */
@Entity
@Table(name="liquidacion_detalle")
@NamedQuery(name="LiquidacionDetalle.findAll", query="SELECT l FROM LiquidacionDetalle l")
public class LiquidacionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private Integer idDetalle;
	
	private double precio;
	
	private Integer cantidad;
	
	private String estado;

	@Column(name="estado_orden")
	private String estadoOrden;

	private Timestamp fecha;

	private double total;

	//bi-directional many-to-one association to LiquidacionOrden
	@ManyToOne
	@JoinColumn(name="id_liquidacion")
	private LiquidacionOrden liquidacionOrden;

	//bi-directional many-to-one association to Rubro
	@ManyToOne
	@JoinColumn(name="id_rubro")
	private Rubro rubro;

	public LiquidacionDetalle() {
	}

	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}
	
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
	
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LiquidacionOrden getLiquidacionOrden() {
		return this.liquidacionOrden;
	}

	public void setLiquidacionOrden(LiquidacionOrden liquidacionOrden) {
		this.liquidacionOrden = liquidacionOrden;
	}

	public Rubro getRubro() {
		return this.rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

}