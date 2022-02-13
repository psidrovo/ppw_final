package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the os_medicamentos database table.
 * 
 */
@Entity
@Table(name="os_medicamentos")
@NamedQuery(name="OsMedicamento.findAll", query="SELECT o FROM OsMedicamento o")
public class OsMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="md_nombre")
	private String mdNombre;

	@Column(name="md_dosis")
	private String mdDosis;

	@Column(name="md_presentacion")
	private String mdPresentacion;

	//bi-directional many-to-one association to OsRcMed
	@OneToMany(mappedBy="osMedicamento")
	private List<OsRcMed> osRcMeds;

	public OsMedicamento() {
	}

	public String getMdNombre() {
		return this.mdNombre;
	}

	public void setMdNombre(String mdNombre) {
		this.mdNombre = mdNombre;
	}

	public String getMdDosis() {
		return this.mdDosis;
	}

	public void setMdDosis(String mdDosis) {
		this.mdDosis = mdDosis;
	}

	public String getMdPresentacion() {
		return this.mdPresentacion;
	}

	public void setMdPresentacion(String mdPresentacion) {
		this.mdPresentacion = mdPresentacion;
	}

	public List<OsRcMed> getOsRcMeds() {
		return this.osRcMeds;
	}

	public void setOsRcMeds(List<OsRcMed> osRcMeds) {
		this.osRcMeds = osRcMeds;
	}

	public OsRcMed addOsRcMed(OsRcMed osRcMed) {
		getOsRcMeds().add(osRcMed);
		osRcMed.setOsMedicamento(this);

		return osRcMed;
	}

	public OsRcMed removeOsRcMed(OsRcMed osRcMed) {
		getOsRcMeds().remove(osRcMed);
		osRcMed.setOsMedicamento(null);

		return osRcMed;
	}

}