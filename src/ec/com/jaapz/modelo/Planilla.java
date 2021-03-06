package ec.com.jaapz.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the planilla database table.
 * 
 */
@Entity
@NamedQuery(name="Planilla.findAll", query="SELECT p FROM Planilla p")
public class Planilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_planilla")
	private Integer idPlanilla;

	private String cancelado;

	private Integer consumo;

	@Column(name="consumo_minimo")
	private Integer consumoMinimo;

	private String convenio;

	private String estado;

	private Timestamp fecha;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	private String latitud;

	@Column(name="lectura_actual")
	private Integer lecturaActual;

	@Column(name="lectura_anterior")
	private Integer lecturaAnterior;

	private String longitud;

	@Column(name="total_letras")
	private String totalLetras;

	@Column(name="total_pagar")
	private double totalPagar;

	@Column(name="usuario_crea")
	private Integer usuarioCrea;

	//bi-directional many-to-one association to ConvenioPlanilla
	@OneToMany(mappedBy="planilla")
	private List<ConvenioPlanilla> convenioPlanillas;

	//bi-directional many-to-one association to FacturaDetalle
	@OneToMany(mappedBy="planilla")
	private List<FacturaDetalle> facturaDetalles;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="planilla")
	private List<Pago> pagos;

	//bi-directional many-to-one association to AperturaLectura
	@ManyToOne
	@JoinColumn(name="id_apertura")
	private AperturaLectura aperturaLectura;

	//bi-directional many-to-one association to CuentaCliente
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private CuentaCliente cuentaCliente;

	//bi-directional many-to-one association to PlanillaDetalle
	@OneToMany(mappedBy="planilla")
	private List<PlanillaDetalle> planillaDetalles;

	public Planilla() {
	}

	public Integer getIdPlanilla() {
		return this.idPlanilla;
	}

	public void setIdPlanilla(Integer idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	public String getCancelado() {
		return this.cancelado;
	}

	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}

	public Integer getConsumo() {
		return this.consumo;
	}

	public void setConsumo(Integer consumo) {
		this.consumo = consumo;
	}

	public Integer getConsumoMinimo() {
		return this.consumoMinimo;
	}

	public void setConsumoMinimo(Integer consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}

	public String getConvenio() {
		return this.convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public Integer getLecturaActual() {
		return this.lecturaActual;
	}

	public void setLecturaActual(Integer lecturaActual) {
		this.lecturaActual = lecturaActual;
	}

	public Integer getLecturaAnterior() {
		return this.lecturaAnterior;
	}

	public void setLecturaAnterior(Integer lecturaAnterior) {
		this.lecturaAnterior = lecturaAnterior;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getTotalLetras() {
		return this.totalLetras;
	}

	public void setTotalLetras(String totalLetras) {
		this.totalLetras = totalLetras;
	}

	public double getTotalPagar() {
		return this.totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public Integer getUsuarioCrea() {
		return this.usuarioCrea;
	}

	public void setUsuarioCrea(Integer usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}

	public List<ConvenioPlanilla> getConvenioPlanillas() {
		return this.convenioPlanillas;
	}

	public void setConvenioPlanillas(List<ConvenioPlanilla> convenioPlanillas) {
		this.convenioPlanillas = convenioPlanillas;
	}

	public ConvenioPlanilla addConvenioPlanilla(ConvenioPlanilla convenioPlanilla) {
		getConvenioPlanillas().add(convenioPlanilla);
		convenioPlanilla.setPlanilla(this);

		return convenioPlanilla;
	}

	public ConvenioPlanilla removeConvenioPlanilla(ConvenioPlanilla convenioPlanilla) {
		getConvenioPlanillas().remove(convenioPlanilla);
		convenioPlanilla.setPlanilla(null);

		return convenioPlanilla;
	}

	public List<FacturaDetalle> getFacturaDetalles() {
		return this.facturaDetalles;
	}

	public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
		this.facturaDetalles = facturaDetalles;
	}

	public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
		getFacturaDetalles().add(facturaDetalle);
		facturaDetalle.setPlanilla(this);

		return facturaDetalle;
	}

	public FacturaDetalle removeFacturaDetalle(FacturaDetalle facturaDetalle) {
		getFacturaDetalles().remove(facturaDetalle);
		facturaDetalle.setPlanilla(null);

		return facturaDetalle;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setPlanilla(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setPlanilla(null);

		return pago;
	}

	public AperturaLectura getAperturaLectura() {
		return this.aperturaLectura;
	}

	public void setAperturaLectura(AperturaLectura aperturaLectura) {
		this.aperturaLectura = aperturaLectura;
	}

	public CuentaCliente getCuentaCliente() {
		return this.cuentaCliente;
	}

	public void setCuentaCliente(CuentaCliente cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}

	public List<PlanillaDetalle> getPlanillaDetalles() {
		return this.planillaDetalles;
	}

	public void setPlanillaDetalles(List<PlanillaDetalle> planillaDetalles) {
		this.planillaDetalles = planillaDetalles;
	}

	public PlanillaDetalle addPlanillaDetalle(PlanillaDetalle planillaDetalle) {
		getPlanillaDetalles().add(planillaDetalle);
		planillaDetalle.setPlanilla(this);

		return planillaDetalle;
	}

	public PlanillaDetalle removePlanillaDetalle(PlanillaDetalle planillaDetalle) {
		getPlanillaDetalles().remove(planillaDetalle);
		planillaDetalle.setPlanilla(null);

		return planillaDetalle;
	}

}