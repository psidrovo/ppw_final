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

	/**
	 * se ha instanciado todos los atributos necesarios para crear 
	 * el objeto dentadura. De la misma manera se ha utilizado anotaciones de persistence
	 * para poder nombrar a la tabla y a las columnas dentro de la base de datos. 
	 * de la misma manera se ha utilizado las anotaciones para poder asignar la relacion que
	 * tendran algunos objetos dentro de la base de datos 
	 */
	@Id
	@Column(name="dent_id")
	private int dentId;

	@Column(name="dent_cdg_molar")
	private String dentCdgMolar;

	//bi-directional many-to-one association to OsDetalleDen
	@OneToMany(mappedBy="osDentadura")
	private List<OsDetalleDen> osDetalleDens;
	
	

	public OsDentadura(int dentId, String dentCdgMolar) {
		this.dentId = dentId;
		this.dentCdgMolar = dentCdgMolar;
	}

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

	public List<OsDetalleDen> getOsDetalleDens() {
		return this.osDetalleDens;
	}

	public void setOsDetalleDens(List<OsDetalleDen> osDetalleDens) {
		this.osDetalleDens = osDetalleDens;
	}

	public OsDetalleDen addOsDetalleDen(OsDetalleDen osDetalleDen) {
		getOsDetalleDens().add(osDetalleDen);
		osDetalleDen.setOsDentadura(this);

		return osDetalleDen;
	}

	public OsDetalleDen removeOsDetalleDen(OsDetalleDen osDetalleDen) {
		getOsDetalleDens().remove(osDetalleDen);
		osDetalleDen.setOsDentadura(null);

		return osDetalleDen;
	}

	@Override
	public String toString() {
		return "OsDentadura [dentId=" + dentId + ", dentCdgMolar=" + dentCdgMolar + "]";
	}
	
}