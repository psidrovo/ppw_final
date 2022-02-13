package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDetPagoON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Named
@RequestScoped
public class PagoBean {

	private int id;
	private double valor;
	
	@Inject
	private GestionDetPagoON pagoOn;
	private OsDetPago pago;
	private OsPersona persona;
	private List<OsDetPago>pagos;
	
	@PostConstruct
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
		OsDetPago p = pagoOn.read(pago.getDetPgId());
		if(p != null) {
			pago.setOsPersona(persona);
			pagoOn.guardarDetPago(pago);
			System.out.println("se ha modificado existosamente el detalle de pago");
		}else {
			pago.setOsPersona(persona);
			pagoOn.guardarDetPago(pago);
			System.out.println("se ha creado existosamente el detalle de pago");
		}
		
		this.init();
		return null;
	}
	
	public String buscarPago() {
		OsDetPago p = pagoOn.read(pago.getDetPgId());
		if (p != null) {
			pago=p;
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
	
	
}
