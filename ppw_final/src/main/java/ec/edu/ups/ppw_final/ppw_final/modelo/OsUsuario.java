package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the os_usuario database table.
 * 
 */
@Entity
@Table(name="os_usuario")
@NamedQuery(name="OsUsuario.findAll", query="SELECT o FROM OsUsuario o")
public class OsUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * se ha instanciado todos los atributos necesarios para crear 
	 * el objeto usuario. De la misma manera se ha utilizado anotaciones de persistence
	 * para poder nombrar a la tabla y a las columnas dentro de la base de datos. 
	 * de la misma manera se ha utilizado las anotaciones para poder asignar la relacion que
	 * tendran algunos objetos dentro de la base de datos 
	 */
	@Id
	@Column(name="us_correo")
	private String usCorreo;

	@Column(name="us_password")
	private String usPassword;

	@Column(name="us_tipo")
	private String usTipo;

	//bi-directional many-to-one association to OsPersona
	@ManyToOne
	@JoinColumn(name="per_cedula_us_persona_fk")
	private OsPersona osPersona;

	public OsUsuario() {
	}
	
	

	public OsUsuario(String usCorreo, String usPassword, String usTipo) {
		this.usCorreo = usCorreo;
		this.usPassword = usPassword;
		this.usTipo = usTipo;
	}



	public String getUsCorreo() {
		return this.usCorreo;
	}

	public void setUsCorreo(String usCorreo) {
		this.usCorreo = usCorreo;
	}

	public String getUsPassword() {
		return this.usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	public String getUsTipo() {
		return this.usTipo;
	}

	public void setUsTipo(String usTipo) {
		this.usTipo = usTipo;
	}

	public OsPersona getOsPersona() {
		return this.osPersona;
	}

	public void setOsPersona(OsPersona osPersona) {
		this.osPersona = osPersona;
	}

}