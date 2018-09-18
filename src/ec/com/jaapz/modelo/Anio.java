package ec.com.jaapz.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the anio database table.
 * 
 */
@Entity
@NamedQuery(name="Anio.findAll", query="SELECT a FROM Anio a")
public class Anio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_anio")
	private Integer idAnio;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AperturaLectura
	@OneToMany(mappedBy="anio")
	private List<AperturaLectura> aperturaLecturas;

	public Anio() {
	}

	public Integer getIdAnio() {
		return this.idAnio;
	}

	public void setIdAnio(Integer idAnio) {
		this.idAnio = idAnio;
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

	public List<AperturaLectura> getAperturaLecturas() {
		return this.aperturaLecturas;
	}

	public void setAperturaLecturas(List<AperturaLectura> aperturaLecturas) {
		this.aperturaLecturas = aperturaLecturas;
	}

	public AperturaLectura addAperturaLectura(AperturaLectura aperturaLectura) {
		getAperturaLecturas().add(aperturaLectura);
		aperturaLectura.setAnio(this);

		return aperturaLectura;
	}

	public AperturaLectura removeAperturaLectura(AperturaLectura aperturaLectura) {
		getAperturaLecturas().remove(aperturaLectura);
		aperturaLectura.setAnio(null);

		return aperturaLectura;
	}

}