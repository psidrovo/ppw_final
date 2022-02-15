package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionHstClinicaON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;

@Named
@RequestScoped
public class DentaduraDetalleBean {

	/**
	 * se ha creado todos los atributos que contienen un detalle dentadura
	 */
	private int id;
	private String cuadrante;
	private String cedulaPaciente;
	private String dentaduraSeleccionada;

	/**
	 * se ha creado los atributos adicionales para poder utilizarlos
	 * y manipular la base de datos.
	 * 
	 */
	@Inject
	private GestionDetDentaduraON denDetON;
	private OsDetalleDen detDetdura;
	@Inject
	private GestionDentaduraON detON;
	@Inject
	private GestionHstClinicaON hstON;

	private OsDentadura dentadura;
	private List<OsDetalleDen> detallesDentaduras;
	private List<OsHstClinica> histortiasClinicas;

	/**
	 * Se ha creado un constructor en el cual se Inicializa los objetos.
	 */
	@PostConstruct
	public void init() {
		dentadura = new OsDentadura();
		detDetdura = new OsDetalleDen();
		System.out.println(dentaduraSeleccionada + " " + cedulaPaciente);
		histortiasClinicas = hstON.findAll();
		histortiasClinicas = histortiasClinicas.stream()
				.filter(p -> p.getOsPersona().getPerCedula().equals(cedulaPaciente)).collect(Collectors.toList());
		histortiasClinicas = histortiasClinicas.stream()
				.filter(d -> d.getOsDetalleDen().getOsDentadura().getDentCdgMolar().equals(dentaduraSeleccionada))
				.collect(Collectors.toList());
	}

	public List<OsDetalleDen> getDetallesDentaduras() {
		return detallesDentaduras;
	}

	public void setDetallesDentaduras(List<OsDetalleDen> detallesDentaduras) {
		this.detallesDentaduras = detallesDentaduras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuadrante() {
		return cuadrante;
	}

	public void setCuadrante(String cuadrante) {
		this.cuadrante = cuadrante;
	}

	public OsDetalleDen getDetDetdura() {
		return detDetdura;
	}

	public void setDetDetdura(OsDetalleDen detDetdura) {
		this.detDetdura = detDetdura;
	}

	public GestionDentaduraON getDetOn() {
		return detON;
	}

	public void setDetOn(GestionDentaduraON detOn) {
		this.detON = detOn;
	}

	public OsDentadura getDentadura() {
		return dentadura;
	}

	public void setDentadura(OsDentadura dentadura) {
		this.dentadura = dentadura;
	}

	public GestionDetDentaduraON getDenDetOn() {
		return denDetON;
	}

	public void setDenDetOn(GestionDetDentaduraON denDetOn) {
		this.denDetON = denDetOn;
	}

	/**
	 * Este metodo realiza la accion de guardar un objeto detalle dentadura.Primero asigna la dentadura a la que pertenece
	 * este detalle y luego lo crea o graba dentro de la base de datos
	 * @return String
	 */
	public String guardar() {
		detDetdura.setOsDentadura(dentadura);
		denDetON.guardarDetDentadura(detDetdura);

		this.init();
		return null;
	}

	/**
	 * este metodo realizara la busqueda del objeto detalle dentadura medianta la llave primaria.
	 * en caso de no encontrar el objeto se imprimira un mensaje en consola que no ha encontrado el objeto
	 *  @return String
	 */
	public String buscarDetalle() {
		OsDetalleDen dd = denDetON.read(detDetdura.getId());
		if (dd != null) {
			detDetdura = dd;
		} else {
			System.out.println("detalle no se ha podido encontrar porque no existe");
		}

		this.init();
		return null;
	}

	/**
	 * este metodo realiza la eliminacion de un objeto detalle dentadura mediante la llave primaria. en caso
	 * de que no encuentro el objeto se imprimira un mensaje en consola informando al usuario de que no 
	 * se ha podidio eliminar la cita.
	 *  @return String
	 */
	public String eliminarDetalle() {
		OsDetalleDen dd = denDetON.read(detDetdura.getId());
		if (dd != null) {
			denDetON.delete(dd.getId());
			System.out.println("detalle eliminado con exito");
		} else {
			System.out.println("detalle no se ha podido eliminar porque no existe");
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

	public String getDentaduraSeleccionada() {
		return dentaduraSeleccionada;
	}

	public void setDentaduraSeleccionada(String dentaduraSeleccionada) {
		this.dentaduraSeleccionada = dentaduraSeleccionada;
	}

	public GestionHstClinicaON getHstON() {
		return hstON;
	}

	public void setHstON(GestionHstClinicaON hstON) {
		this.hstON = hstON;
	}

	public List<OsHstClinica> getHistortiasClinicas() {
		return histortiasClinicas;
	}

	public void setHistortiasClinicas(List<OsHstClinica> histortiasClinicas) {
		this.histortiasClinicas = histortiasClinicas;
	}
	
}
