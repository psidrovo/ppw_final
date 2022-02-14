package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the os_persona database table.
 * 
 */
@Entity
@Table(name="os_persona")
@NamedQuery(name="OsPersona.findAll", query="SELECT o FROM OsPersona o")
public class OsPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_cedula")
	private String perCedula;

	@Column(name="per_apellido")
	private String perApellido;

	@Column(name="per_direccion")
	private String perDireccion;

	@Column(name="per_nombre")
	private String perNombre;

	//bi-directional many-to-one association to OsCita
	@OneToMany(mappedBy="osPersona")
	private List<OsCita> osCitas;

	//bi-directional many-to-one association to OsDetPago
	@OneToMany(mappedBy="osPersona")
	private List<OsDetPago> osDetPagos;

	//bi-directional many-to-one association to OsHstClinica
	@OneToMany(mappedBy="osPersona")
	private List<OsHstClinica> osHstClinicas;

	//bi-directional many-to-one association to OsUsuario
	@OneToMany(mappedBy="osPersona")
	private List<OsUsuario> osUsuarios;

	public OsPersona() {
	}

	public String getPerCedula() {
		return this.perCedula;
	}

	public void setPerCedula(String perCedula) {
		this.perCedula = perCedula;
	}

	public String getPerApellido() {
		return this.perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public String getPerDireccion() {
		return this.perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public List<OsCita> getOsCitas() {
		return this.osCitas;
	}

	public void setOsCitas(List<OsCita> osCitas) {
		this.osCitas = osCitas;
	}

	public OsCita addOsCita(OsCita osCita) {
		getOsCitas().add(osCita);
		osCita.setOsPersona(this);

		return osCita;
	}

	public OsCita removeOsCita(OsCita osCita) {
		getOsCitas().remove(osCita);
		osCita.setOsPersona(null);

		return osCita;
	}

	public List<OsDetPago> getOsDetPagos() {
		return this.osDetPagos;
	}

	public void setOsDetPagos(List<OsDetPago> osDetPagos) {
		this.osDetPagos = osDetPagos;
	}

	public OsDetPago addOsDetPago(OsDetPago osDetPago) {
		getOsDetPagos().add(osDetPago);
		osDetPago.setOsPersona(this);

		return osDetPago;
	}

	public OsDetPago removeOsDetPago(OsDetPago osDetPago) {
		getOsDetPagos().remove(osDetPago);
		osDetPago.setOsPersona(null);

		return osDetPago;
	}

	public List<OsHstClinica> getOsHstClinicas() {
		return this.osHstClinicas;
	}

	public void setOsHstClinicas(List<OsHstClinica> osHstClinicas) {
		this.osHstClinicas = osHstClinicas;
	}

	public OsHstClinica addOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().add(osHstClinica);
		osHstClinica.setOsPersona(this);

		return osHstClinica;
	}

	public OsHstClinica removeOsHstClinica(OsHstClinica osHstClinica) {
		getOsHstClinicas().remove(osHstClinica);
		osHstClinica.setOsPersona(null);

		return osHstClinica;
	}

	public List<OsUsuario> getOsUsuarios() {
		return this.osUsuarios;
	}

	public void setOsUsuarios(List<OsUsuario> osUsuarios) {
		this.osUsuarios = osUsuarios;
	}

	public OsUsuario addOsUsuario(OsUsuario osUsuario) {
		getOsUsuarios().add(osUsuario);
		osUsuario.setOsPersona(this);

		return osUsuario;
	}

	public OsUsuario removeOsUsuario(OsUsuario osUsuario) {
		getOsUsuarios().remove(osUsuario);
		osUsuario.setOsPersona(null);

		return osUsuario;
	}

}