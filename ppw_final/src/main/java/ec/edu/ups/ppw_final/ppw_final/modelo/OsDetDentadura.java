package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the os_det_dentadura database table.
 * 
 */
@Entity
@Table(name="os_det_dentadura")
@NamedQuery(name="OsDetDentadura.findAll", query="SELECT o FROM OsDetDentadura o")
public class OsDetDentadura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="det_dent_id")
	private int detDentId;

	@Column(name="det_dent_estado_trat")
	private String detDentEstadoTrat;

	//bi-directional many-to-one association to OsDentadura
	@ManyToOne
	@JoinColumn(name="dent_id_det_dent_detentadura")
	private OsDentadura osDentadura;

	//bi-directional many-to-one association to OsTratamiento
	@ManyToOne
	@JoinColumn(name="trat_nombre_det_dent_tratamiento")
	private OsTratamiento osTratamiento;

	//bi-directional many-to-one association to OsHstClinica
	@OneToMany(mappedBy="osDetDentadura")
	private List<OsHstClinica> osHstClinicas;

	public OsDetDentadura() {
	}

	public int getDetDentId() {
		return this.detDentId;
	}

	public void setDetDentId(int detDentId) {
		this.detDentId = detDentId;
	}

	public String getDetDentEstadoTrat() {
		return this.detDentEstadoTrat;
	}

	public void setDetDentEstadoTrat(String detDentEstadoTrat) {
		this.detDentEstadoTrat = detDentEstadoTrat;
	}

	public OsDentadura getOsDentadura() {
		return this.osDentadura;
	}

	public void setOsDentadura(OsDentadura osDentadura) {
		this.osDentadura = osDentadura;
	}

	public OsTratamiento getOsTratamiento() {
		return this.osTratamiento;
	}

	public void setOsTratamiento(OsTratamiento osTratamiento) {
		this.osTratamiento = osTratamiento;
	}

	public List<OsHstClinica> getOsHstClinicas() {
		return this.osHstClinicas;
	}

	public void setOsHstClinicas(List<OsHstClinica> osHstClinicas) {
		this.osHstClinicas = osHstClinicas;
	}

	public OsHstClinica addOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().add(osHstClinica);
		osHstClinica.setOsDetDentadura(this);

		return osHstClinica;
	}

	public OsHstClinica removeOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().remove(osHstClinica);
		osHstClinica.setOsDetDentadura(null);

		return osHstClinica;
	}

}