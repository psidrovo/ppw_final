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

	private int id;
	private String cuadrante;
	private String cedulaPaciente;
	private String dentaduraSeleccionada;

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

	@PostConstruct
	public void init() {
		dentadura = new OsDentadura();
		detDetdura = new OsDetalleDen();
		System.out.println(dentaduraSeleccionada + " " + cedulaPaciente);
		histortiasClinicas = hstON.findAll();
		System.out.println(histortiasClinicas.toString());
		histortiasClinicas = histortiasClinicas.stream()
				.filter(p -> p.getOsPersona().getPerCedula().equals(cedulaPaciente)).collect(Collectors.toList());
		System.out.println(histortiasClinicas.toString());
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

	public String guardar() {
		detDetdura.setOsDentadura(dentadura);
		denDetON.guardarDetDentadura(detDetdura);

		this.init();
		return null;
	}

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
