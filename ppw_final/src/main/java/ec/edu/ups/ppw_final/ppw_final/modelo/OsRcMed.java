package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the os_rc_med database table.
 * 
 */
@Entity
@Table(name="os_rc_med")
@NamedQuery(name="OsRcMed.findAll", query="SELECT o FROM OsRcMed o")
public class OsRcMed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rc_med_id")
	private int rcMedId;

	@Column(name="os_rc_medcol")
	private String osRcMedcol;

	//bi-directional many-to-one association to OsHstClinica
	@OneToMany(mappedBy="osRcMed")
	private List<OsHstClinica> osHstClinicas;

	//bi-directional many-to-one association to OsMedicamento
	@ManyToOne
	@JoinColumn(name="md_nombre_rc_med_medicacion_fk")
	private OsMedicamento osMedicamento;

	public OsRcMed() {
	}

	public int getRcMedId() {
		return this.rcMedId;
	}

	public void setRcMedId(int rcMedId) {
		this.rcMedId = rcMedId;
	}

	public String getOsRcMedcol() {
		return this.osRcMedcol;
	}

	public void setOsRcMedcol(String osRcMedcol) {
		this.osRcMedcol = osRcMedcol;
	}

	public List<OsHstClinica> getOsHstClinicas() {
		return this.osHstClinicas;
	}

	public void setOsHstClinicas(List<OsHstClinica> osHstClinicas) {
		this.osHstClinicas = osHstClinicas;
	}

	public OsHstClinica addOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().add(osHstClinica);
		osHstClinica.setOsRcMed(this);

		return osHstClinica;
	}

	public OsHstClinica removeOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().remove(osHstClinica);
		osHstClinica.setOsRcMed(null);

		return osHstClinica;
	}

	public OsMedicamento getOsMedicamento() {
		return this.osMedicamento;
	}

	public void setOsMedicamento(OsMedicamento osMedicamento) {
		this.osMedicamento = osMedicamento;
	}

}