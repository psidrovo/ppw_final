package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the os_cita database table.
 * 
 */
@Entity
@Table(name="os_cita")
@NamedQuery(name="OsCita.findAll", query="SELECT o FROM OsCita o")
public class OsCita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ct_id")
	private int ctId;

	@Column(name="ct_descripcion")
	private String ctDescripcion;

	@Column(name="ct_estado")
	private String ctEstado;

	@Column(name="ct_fecha")
	private String ctFecha;

	//bi-directional many-to-one association to OsPersona
	@ManyToOne
	@JoinColumn(name="os_persona_per_cedula")
	private OsPersona osPersona;

	public OsCita() {
	}

	public int getCtId() {
		return this.ctId;
	}

	public void setCtId(int ctId) {
		this.ctId = ctId;
	}

	public String getCtDescripcion() {
		return this.ctDescripcion;
	}

	public void setCtDescripcion(String ctDescripcion) {
		this.ctDescripcion = ctDescripcion;
	}

	public String getCtEstado() {
		return this.ctEstado;
	}

	public void setCtEstado(String ctEstado) {
		this.ctEstado = ctEstado;
	}

	public String getCtFecha() {
		return this.ctFecha;
	}

	public void setCtFecha(String ctFecha) {
		this.ctFecha = ctFecha;
	}

	public OsPersona getOsPersona() {
		return this.osPersona;
	}

	public void setOsPersona(OsPersona osPersona) {
		this.osPersona = osPersona;
	}

}