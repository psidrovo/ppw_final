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

	/**
	 * se ha instanciado todos los atributos necesarios para crear 
	 * el objeto histroail clinico pago. De la misma manera se ha utilizado anotaciones de persistence
	 * para poder nombrar a la tabla y a las columnas dentro de la base de datos. 
	 * de la misma manera se ha utilizado las anotaciones para poder asignar la relacion que
	 * tendran algunos objetos dentro de la base de datos 
	 */
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

	@Column(name="hst_costo")
	private String hstCosto;

	@Column(name="hst_receta")
	private String hstReceta;

	@Column(name="hst_tratamiento")
	private String hstTratamiento;

	//bi-directional many-to-one association to OsDetalleDen
	@ManyToOne
	@JoinColumn(name="os_detalle_den_id")
	private OsDetalleDen osDetalleDen;

	//bi-directional many-to-one association to OsPersona
	@ManyToOne
	@JoinColumn(name="per_cedula_hst_cl_paciente_fk")
	private OsPersona osPersona;

	public OsHstClinica() {
	}
	
	

	public OsHstClinica(int hstClId, String hstClDetalle, String hstClFase, Date hstClFecha, String hstCosto,
			String hstReceta, String hstTratamiento) {
		this.hstClId = hstClId;
		this.hstClDetalle = hstClDetalle;
		this.hstClFase = hstClFase;
		this.hstClFecha = hstClFecha;
		this.hstCosto = hstCosto;
		this.hstReceta = hstReceta;
		this.hstTratamiento = hstTratamiento;
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

	public String getHstCosto() {
		return this.hstCosto;
	}

	public void setHstCosto(String hstCosto) {
		this.hstCosto = hstCosto;
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

	public OsDetalleDen getOsDetalleDen() {
		return this.osDetalleDen;
	}

	public void setOsDetalleDen(OsDetalleDen osDetalleDen) {
		this.osDetalleDen = osDetalleDen;
	}

	public OsPersona getOsPersona() {
		return this.osPersona;
	}

	public void setOsPersona(OsPersona osPersona) {
		this.osPersona = osPersona;
	}

	@Override
	public String toString() {
		return "OsHstClinica [hstClId=" + hstClId + ", hstClDetalle=" + hstClDetalle + ", hstClFase=" + hstClFase
				+ ", hstClFecha=" + hstClFecha + ", hstCosto=" + hstCosto + ", hstReceta=" + hstReceta
				+ ", hstTratamiento=" + hstTratamiento + "]";
	}	
}