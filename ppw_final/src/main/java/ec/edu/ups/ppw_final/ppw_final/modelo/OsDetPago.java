package ec.edu.ups.ppw_final.ppw_final.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the os_det_pagos database table.
 * 
 */
@Entity
@Table(name="os_det_pagos")
@NamedQuery(name="OsDetPago.findAll", query="SELECT o FROM OsDetPago o")
public class OsDetPago implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * se ha instanciado todos los atributos necesarios para crear 
	 * el objeto detalle pago. De la misma manera se ha utilizado anotaciones de persistence
	 * para poder nombrar a la tabla y a las columnas dentro de la base de datos. 
	 * de la misma manera se ha utilizado las anotaciones para poder asignar la relacion que
	 * tendran algunos objetos dentro de la base de datos 
	 */
	@Id
	@Column(name="det_pg_id")
	private int detPgId;

	@Column(name="det_pg_valor")
	private double detPgValor;

	//bi-directional many-to-one association to OsPersona
	@ManyToOne
	@JoinColumn(name="os_persona_per_cedula")
	private OsPersona osPersona;

	public OsDetPago() {
	}

	public OsDetPago(int detPgId, double detPgValor) {
		this.detPgId = detPgId;
		this.detPgValor = detPgValor;
	}



	public int getDetPgId() {
		return this.detPgId;
	}

	public void setDetPgId(int detPgId) {
		this.detPgId = detPgId;
	}

	public double getDetPgValor() {
		return this.detPgValor;
	}

	public void setDetPgValor(double detPgValor) {
		this.detPgValor = detPgValor;
	}

	public OsPersona getOsPersona() {
		return this.osPersona;
	}

	public void setOsPersona(OsPersona osPersona) {
		this.osPersona = osPersona;
	}

}