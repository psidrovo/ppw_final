package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the os_hst_clinica database table.
 * 
 */
@Entity
@Table(name="os_hst_clinica")
@NamedQuery(name="OsHstClinica.findAll", query="SELECT o FROM OsHstClinica o")
public class OsHstClinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hst_cl_id")
	private int hstClId;

	@Column(name="hst_cl_detalle")
	private String hstClDetalle;

	@Column(name="hst_cl_fase")
	private String hstClFase;

	@Temporal(TemporalType.DATE)
	@Column(name="hst_cl_fecha")
	private Date hstClFecha;

	@Column(name="hst_receta")
	private String hstReceta;

	@Column(name="hst_tratamiento")
	private String hstTratamiento;

	@Column(name="hst_costo")
	private String hstCosto;
	
	//bi-directional many-to-one association to OsPersona
	@ManyToOne
	@JoinColumn(name="per_cedula_hst_cl_paciente_fk")
	private OsPersona osPersona;

	//bi-directional many-to-one association to OsDentadura
	@ManyToOne
	@JoinColumn(name="os_dentadura_dent_id")
	private OsDentadura osDentadura;

	public OsHstClinica() {
	}

	public int getHstClId() {
		return this.hstClId;
	}

	public void setHstClId(int hstClId) {
		this.hstClId = hstClId;
	}

	public String getHstClDetalle() {
		return this.hstClDetalle;
	}

	public void setHstClDetalle(String hstClDetalle) {
		this.hstClDetalle = hstClDetalle;
	}

	public String getHstClFase() {
		return this.hstClFase;
	}

	public void setHstClFase(String hstClFase) {
		this.hstClFase = hstClFase;
	}

	public Date getHstClFecha() {
		return this.hstClFecha;
	}

	public void setHstClFecha(Date hstClFecha) {
		this.hstClFecha = hstClFecha;
	}

	public String getHstReceta() {
		return this.hstReceta;
	}

	public void setHstReceta(String hstReceta) {
		this.hstReceta = hstReceta;
	}

	public String getHstTratamiento() {
		return this.hstTratamiento;
	}

	public void setHstTratamiento(String hstTratamiento) {
		this.hstTratamiento = hstTratamiento;
	}

	public OsPersona getOsPersona() {
		return this.osPersona;
	}

	public void setOsPersona(OsPersona osPersona) {
		this.osPersona = osPersona;
	}

	public OsDentadura getOsDentadura() {
		return this.osDentadura;
	}

	public void setOsDentadura(OsDentadura osDentadura) {
		this.osDentadura = osDentadura;
	}

	public String getHstCosto() {
		return hstCosto;
	}

	public void setHstCosto(String hstCosto) {
		this.hstCosto = hstCosto;
	}
	
}