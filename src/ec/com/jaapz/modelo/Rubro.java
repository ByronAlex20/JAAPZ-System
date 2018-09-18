package ec.com.jaapz.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rubro database table.
 * 
 */
@Entity
@NamedQuery(name="Rubro.findAll", query="SELECT r FROM Rubro r")
public class Rubro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rubro")
	private Integer idRubro;

	private String descripcion;

	private String estado;

	private String marca;

	private double precio;

	private Integer stock;

	@Column(name="usuario_crea")
	private Integer usuarioCrea;

	//bi-directional many-to-one association to IngresoDetalle
	@OneToMany(mappedBy="rubro")
	private List<IngresoDetalle> ingresoDetalles;

	//bi-directional many-to-one association to InstalacionDetalle
	@OneToMany(mappedBy="rubro")
	private List<InstalacionDetalle> instalacionDetalles;

	//bi-directional many-to-one association to LiquidacionDetalle
	@OneToMany(mappedBy="rubro")
	private List<LiquidacionDetalle> liquidacionDetalles;

	//bi-directional many-to-one association to PrecioUnitario
	@OneToMany(mappedBy="rubro")
	private List<PrecioUnitario> precioUnitarios;

	//bi-directional many-to-one association to ReparacionDetalle
	@OneToMany(mappedBy="rubro")
	private List<ReparacionDetalle> reparacionDetalles;

	//bi-directional many-to-one association to TipoRubro
	@ManyToOne
	@JoinColumn(name="id_tipo_rubro")
	private TipoRubro tipoRubro;

	public Rubro() {
	}

	public Integer getIdRubro() {
		return this.idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getUsuarioCrea() {
		return this.usuarioCrea;
	}

	public void setUsuarioCrea(Integer usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}

	public List<IngresoDetalle> getIngresoDetalles() {
		return this.ingresoDetalles;
	}

	public void setIngresoDetalles(List<IngresoDetalle> ingresoDetalles) {
		this.ingresoDetalles = ingresoDetalles;
	}

	public IngresoDetalle addIngresoDetalle(IngresoDetalle ingresoDetalle) {
		getIngresoDetalles().add(ingresoDetalle);
		ingresoDetalle.setRubro(this);

		return ingresoDetalle;
	}

	public IngresoDetalle removeIngresoDetalle(IngresoDetalle ingresoDetalle) {
		getIngresoDetalles().remove(ingresoDetalle);
		ingresoDetalle.setRubro(null);

		return ingresoDetalle;
	}

	public List<InstalacionDetalle> getInstalacionDetalles() {
		return this.instalacionDetalles;
	}

	public void setInstalacionDetalles(List<InstalacionDetalle> instalacionDetalles) {
		this.instalacionDetalles = instalacionDetalles;
	}

	public InstalacionDetalle addInstalacionDetalle(InstalacionDetalle instalacionDetalle) {
		getInstalacionDetalles().add(instalacionDetalle);
		instalacionDetalle.setRubro(this);

		return instalacionDetalle;
	}

	public InstalacionDetalle removeInstalacionDetalle(InstalacionDetalle instalacionDetalle) {
		getInstalacionDetalles().remove(instalacionDetalle);
		instalacionDetalle.setRubro(null);

		return instalacionDetalle;
	}

	public List<LiquidacionDetalle> getLiquidacionDetalles() {
		return this.liquidacionDetalles;
	}

	public void setLiquidacionDetalles(List<LiquidacionDetalle> liquidacionDetalles) {
		this.liquidacionDetalles = liquidacionDetalles;
	}

	public LiquidacionDetalle addLiquidacionDetalle(LiquidacionDetalle liquidacionDetalle) {
		getLiquidacionDetalles().add(liquidacionDetalle);
		liquidacionDetalle.setRubro(this);

		return liquidacionDetalle;
	}

	public LiquidacionDetalle removeLiquidacionDetalle(LiquidacionDetalle liquidacionDetalle) {
		getLiquidacionDetalles().remove(liquidacionDetalle);
		liquidacionDetalle.setRubro(null);

		return liquidacionDetalle;
	}

	public List<PrecioUnitario> getPrecioUnitarios() {
		return this.precioUnitarios;
	}

	public void setPrecioUnitarios(List<PrecioUnitario> precioUnitarios) {
		this.precioUnitarios = precioUnitarios;
	}

	public PrecioUnitario addPrecioUnitario(PrecioUnitario precioUnitario) {
		getPrecioUnitarios().add(precioUnitario);
		precioUnitario.setRubro(this);

		return precioUnitario;
	}

	public PrecioUnitario removePrecioUnitario(PrecioUnitario precioUnitario) {
		getPrecioUnitarios().remove(precioUnitario);
		precioUnitario.setRubro(null);

		return precioUnitario;
	}

	public List<ReparacionDetalle> getReparacionDetalles() {
		return this.reparacionDetalles;
	}

	public void setReparacionDetalles(List<ReparacionDetalle> reparacionDetalles) {
		this.reparacionDetalles = reparacionDetalles;
	}

	public ReparacionDetalle addReparacionDetalle(ReparacionDetalle reparacionDetalle) {
		getReparacionDetalles().add(reparacionDetalle);
		reparacionDetalle.setRubro(this);

		return reparacionDetalle;
	}

	public ReparacionDetalle removeReparacionDetalle(ReparacionDetalle reparacionDetalle) {
		getReparacionDetalles().remove(reparacionDetalle);
		reparacionDetalle.setRubro(null);

		return reparacionDetalle;
	}

	public TipoRubro getTipoRubro() {
		return this.tipoRubro;
	}

	public void setTipoRubro(TipoRubro tipoRubro) {
		this.tipoRubro = tipoRubro;
	}

}