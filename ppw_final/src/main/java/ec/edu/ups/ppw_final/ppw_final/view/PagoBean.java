package ec.edu.ups.ppw_final.ppw_final.view;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDetPagoON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Named
@ViewScoped
public class PagoBean implements Serializable{

	/**
	 * se ha creado todos los atributos que contienen una pago
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private double valor;
	private String cedulaPaciente;

	/**
	 * se ha creado los atributos adicionales para poder utilizarlos
	 * y manipular la base de datos.
	 */
	@Inject
	private GestionDetPagoON pagoOn;
	@Inject
	private GestionPersonaON perOn;
	
	private OsDetPago pago;
	private OsPersona persona;
	private List<OsDetPago> pagos;

	/**
	 * Se ha creado un constructor en el cual se Inicializa los objetos.
	 */
	public void init() {
		pago = new OsDetPago();
		persona = new OsPersona();
		pagos = pagoOn.findAll().stream().filter(pg -> pg.getOsPersona().getPerCedula().equals(cedulaPaciente)).collect(Collectors.toList());
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

	/**
	 * Este metodo realiza la accion de guardar un pago en caso de que no exista 
	 * una vez creada la persona se lo asignara al objeto cita y se creara el objeto cita
	 * @return String
	 */
	public String guardar() {
		System.out.println("Entrando a Guardar");
		persona = perOn.read(cedulaPaciente);
		pago.setOsPersona(persona);
		pagoOn.guardarDetPago(pago);

		this.init();
		return "";
	}

	/**
	 * este metodo realizara la busqueda del objeto pago medianta la llave primaria.
	 * en caso de no encontrar el objeto se imprimira un mensaje en consola que no ha encontrado el objeto
	 * @return String
	 */
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

	/**
	 * este metodo realiza la eliminacion de un objeto pago mediante la llave primaria. en caso
	 * de que no encuentro el objeto se imprimira un mensaje en consola informando al usuario de que no 
	 * se ha podidio eliminar el pago.
	 * @return String
	 */
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
