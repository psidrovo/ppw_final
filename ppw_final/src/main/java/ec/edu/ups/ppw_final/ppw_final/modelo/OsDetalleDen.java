package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the os_detalle_den database table.
 * 
 */
@Entity
@Table(name="os_detalle_den")
@NamedQuery(name="OsDetalleDen.findAll", query="SELECT o FROM OsDetalleDen o")
public class OsDetalleDen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cuadrante;

	//bi-directional many-to-one association to OsDentadura
	@ManyToOne
	@JoinColumn(name="os_dentadura_dent_id")
	private OsDentadura osDentadura;

	public OsDetalleDen() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuadrante() {
		return this.cuadrante;
	}

	public void setCuadrante(String cuadrante) {
		this.cuadrante = cuadrante;
	}

	public OsDentadura getOsDentadura() {
		return this.osDentadura;
	}

	public void setOsDentadura(OsDentadura osDentadura) {
		this.osDentadura = osDentadura;
	}

}