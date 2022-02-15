package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the os_detalle_den database table.
 * 
 */
@Entity
@Table(name="os_detalle_den")
@NamedQuery(name="OsDetalleDen.findAll", query="SELECT o FROM OsDetalleDen o")
public class OsDetalleDen implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * se ha instanciado todos los atributos necesarios para crear 
	 * el objeto detalle dentaura. De la misma manera se ha utilizado anotaciones de persistence
	 * para poder nombrar a la tabla y a las columnas dentro de la base de datos. 
	 * de la misma manera se ha utilizado las anotaciones para poder asignar la relacion que
	 * tendran algunos objetos dentro de la base de datos 
	 */
	@Id
	private int id;

	private String cuadrante;

	//bi-directional many-to-one association to OsDentadura
	@ManyToOne
	@JoinColumn(name="os_dentadura_dent_id")
	private OsDentadura osDentadura;

	//bi-directional many-to-one association to OsHstClinica
	@OneToMany(mappedBy="osDetalleDen")
	private List<OsHstClinica> osHstClinicas;

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

	public List<OsHstClinica> getOsHstClinicas() {
		return this.osHstClinicas;
	}

	public void setOsHstClinicas(List<OsHstClinica> osHstClinicas) {
		this.osHstClinicas = osHstClinicas;
	}

	public OsHstClinica addOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().add(osHstClinica);
		osHstClinica.setOsDetalleDen(this);

		return osHstClinica;
	}

	public OsHstClinica removeOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().remove(osHstClinica);
		osHstClinica.setOsDetalleDen(null);

		return osHstClinica;
	}

	@Override
	public String toString() {
		return "OsDetalleDen [id=" + id + ", cuadrante=" + cuadrante + "]";
	}

}