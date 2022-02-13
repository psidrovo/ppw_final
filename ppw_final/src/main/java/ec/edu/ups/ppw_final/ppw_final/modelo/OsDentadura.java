package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the os_dentadura database table.
 * 
 */
@Entity
@Table(name="os_dentadura")
@NamedQuery(name="OsDentadura.findAll", query="SELECT o FROM OsDentadura o")
public class OsDentadura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dent_id")
	private int dentId;

	@Column(name="dent_cdg_molar")
	private String dentCdgMolar;

	//bi-directional many-to-one association to OsDetDentadura
	@OneToMany(mappedBy="osDentadura")
	private List<OsDetDentadura> osDetDentaduras;

	public OsDentadura() {
	}

	public int getDentId() {
		return this.dentId;
	}

	public void setDentId(int dentId) {
		this.dentId = dentId;
	}

	public String getDentCdgMolar() {
		return this.dentCdgMolar;
	}

	public void setDentCdgMolar(String dentCdgMolar) {
		this.dentCdgMolar = dentCdgMolar;
	}

	public List<OsDetDentadura> getOsDetDentaduras() {
		return this.osDetDentaduras;
	}

	public void setOsDetDentaduras(List<OsDetDentadura> osDetDentaduras) {
		this.osDetDentaduras = osDetDentaduras;
	}

	public OsDetDentadura addOsDetDentadura(OsDetDentadura osDetDentadura) {
		getOsDetDentaduras().add(osDetDentadura);
		osDetDentadura.setOsDentadura(this);

		return osDetDentadura;
	}

	public OsDetDentadura removeOsDetDentadura(OsDetDentadura osDetDentadura) {
		getOsDetDentaduras().remove(osDetDentadura);
		osDetDentadura.setOsDentadura(null);

		return osDetDentadura;
	}

}