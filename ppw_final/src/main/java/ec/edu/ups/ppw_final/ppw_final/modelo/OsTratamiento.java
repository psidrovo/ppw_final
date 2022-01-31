package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the os_tratamiento database table.
 * 
 */
@Entity
@Table(name="os_tratamiento")
@NamedQuery(name="OsTratamiento.findAll", query="SELECT o FROM OsTratamiento o")
public class OsTratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tr_nombre")
	private String trNombre;

	@Column(name="os_costo")
	private String osCosto;

	@Column(name="tr_descripcion")
	private String trDescripcion;

	@Column(name="tr_tiempo")
	private String trTiempo;

	//bi-directional many-to-one association to OsDetDentadura
	@OneToMany(mappedBy="osTratamiento")
	private List<OsDetDentadura> osDetDentaduras;

	public OsTratamiento() {
	}

	public String getTrNombre() {
		return this.trNombre;
	}

	public void setTrNombre(String trNombre) {
		this.trNombre = trNombre;
	}

	public String getOsCosto() {
		return this.osCosto;
	}

	public void setOsCosto(String osCosto) {
		this.osCosto = osCosto;
	}

	public String getTrDescripcion() {
		return this.trDescripcion;
	}

	public void setTrDescripcion(String trDescripcion) {
		this.trDescripcion = trDescripcion;
	}

	public String getTrTiempo() {
		return this.trTiempo;
	}

	public void setTrTiempo(String trTiempo) {
		this.trTiempo = trTiempo;
	}

	public List<OsDetDentadura> getOsDetDentaduras() {
		return this.osDetDentaduras;
	}

	public void setOsDetDentaduras(List<OsDetDentadura> osDetDentaduras) {
		this.osDetDentaduras = osDetDentaduras;
	}

	public OsDetDentadura addOsDetDentadura(OsDetDentadura osDetDentadura) {
		getOsDetDentaduras().add(osDetDentadura);
		osDetDentadura.setOsTratamiento(this);

		return osDetDentadura;
	}

	public OsDetDentadura removeOsDetDentadura(OsDetDentadura osDetDentadura) {
		getOsDetDentaduras().remove(osDetDentadura);
		osDetDentadura.setOsTratamiento(null);

		return osDetDentadura;
	}

}