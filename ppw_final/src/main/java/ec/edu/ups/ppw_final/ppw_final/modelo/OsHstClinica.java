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

	//bi-directional many-to-one association to OsPersona
	@ManyToOne
	@JoinColumn(name="per_cedula_hst_cl_paciente_fk")
	private OsPersona osPersona;

	//bi-directional many-to-one association to OsRcMed
	@ManyToOne
	@JoinColumn(name="rc_med_id_hst_cl_receta")
	private OsRcMed osRcMed;

	//bi-directional many-to-one association to OsDetalleDen
	@ManyToOne
	@JoinColumn(name="os_detalle_den_id")
	private OsDetalleDen osDetalleDen;

	//bi-directional many-to-one association to OsTratamiento
	@ManyToOne
	@JoinColumn(name="os_tratamiento_tr_nombre")
	private OsTratamiento osTratamiento;

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

	public OsPersona getOsPersona() {
		return this.osPersona;
	}

	public void setOsPersona(OsPersona osPersona) {
		this.osPersona = osPersona;
	}

	public OsRcMed getOsRcMed() {
		return this.osRcMed;
	}

	public void setOsRcMed(OsRcMed osRcMed) {
		this.osRcMed = osRcMed;
	}

	public OsDetalleDen getOsDetalleDen() {
		return this.osDetalleDen;
	}

	public void setOsDetalleDen(OsDetalleDen osDetalleDen) {
		this.osDetalleDen = osDetalleDen;
	}

	public OsTratamiento getOsTratamiento() {
		return this.osTratamiento;
	}

	public void setOsTratamiento(OsTratamiento osTratamiento) {
		this.osTratamiento = osTratamiento;
	}

}