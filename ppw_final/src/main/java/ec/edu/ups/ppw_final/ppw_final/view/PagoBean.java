package ec.edu.ups.ppw_final.ppw_final.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDetPagoON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Named
@ViewScoped
public class PagoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private double valor;
	private String cedulaPaciente;

	@Inject
	private GestionDetPagoON pagoOn;
	private OsDetPago pago;
	private OsPersona persona;
	private List<OsDetPago> pagos;


	private void init() {
		pago = new OsDetPago();
		persona = new OsPersona();
		pagos = pagoOn.findAll();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public GestionDetPagoON getPagoOn() {
		return pagoOn;
	}

	public void setPagoOn(GestionDetPagoON pagoOn) {
		this.pagoOn = pagoOn;
	}

	public OsDetPago getPago() {
		return pago;
	}

	public void setPago(OsDetPago pago) {
		this.pago = pago;
	}

	public OsPersona getPersona() {
		return persona;
	}

	public void setPersona(OsPersona persona) {
		this.persona = persona;
	}

	public List<OsDetPago> getPagos() {
		return pagos;
	}

	public void setPagos(List<OsDetPago> pagos) {
		this.pagos = pagos;
	}

	public String guardar() {
		pago.setOsPersona(persona);
		pagoOn.guardarDetPago(pago);

		this.init();
		return "";
	}

	public String buscarPago() {
		OsDetPago p = pagoOn.read(pago.getDetPgId());
		if (p != null) {
			pago = p;
		} else {
			System.out.println("detalle pago no se ha podido encontrar porque no existe");
		}

		this.init();
		return null;
	}

	public String eliminarPago() {
		OsDetPago p = pagoOn.read(pago.getDetPgId());
		if (p != null) {
			pagoOn.delete(pago.getDetPgId());
		} else {
			System.out.println("detalle pago no se ha podido eliminar porque no existe");
		}

		this.init();
		return null;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

}
