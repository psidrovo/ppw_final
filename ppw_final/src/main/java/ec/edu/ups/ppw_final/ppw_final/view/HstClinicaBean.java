package ec.edu.ups.ppw_final.ppw_final.view;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionHstClinicaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Named
@ViewScoped
public class HstClinicaBean implements Serializable{

	private int id;
	private String detalle;
	private String fase;
	private String fecha;
	private String receta;
	private String tratamiento;
	private String cedulaPaciente;
	
	@Inject
	private GestionHstClinicaON hstOn;
	@Inject
	private GestionDentaduraON denOn;
	@Inject
	private GestionPersonaON perOn;

	private OsPersona persona;
	private OsDentadura dentadura;
	private OsHstClinica hstClincia;

	private List<OsHstClinica> hstClinicas;

	

	public String getReceta() {
		return receta;
	}



	public void setReceta(String receta) {
		this.receta = receta;
	}



	public String getTratamiento() {
		return tratamiento;
	}



	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public GestionHstClinicaON getHstOn() {
		return hstOn;
	}

	public void setHstOn(GestionHstClinicaON hstOn) {
		this.hstOn = hstOn;
	}

	public GestionDentaduraON getDenOn() {
		return denOn;
	}

	public void setDenOn(GestionDentaduraON denOn) {
		this.denOn = denOn;
	}

	public OsDentadura getDentadura() {
		return dentadura;
	}

	public void setDentadura(OsDentadura dentadura) {
		this.dentadura = dentadura;
	}

	public GestionPersonaON getPerOn() {
		return perOn;
	}

	public void setPerOn(GestionPersonaON perOn) {
		this.perOn = perOn;
	}

	public OsPersona getPersona() {
		return persona;
	}

	public void setPersona(OsPersona persona) {
		this.persona = persona;
	}

	public OsHstClinica getHstClincia() {
		return hstClincia;
	}

	public void setHstClincia(OsHstClinica hstClincia) {
		this.hstClincia = hstClincia;
	}

	public List<OsHstClinica> getHstClinicas() {
		return hstClinicas;
	}

	public void setHstClinicas(List<OsHstClinica> hstClinicas) {
		this.hstClinicas = hstClinicas;
	}

	public String guardar() {
		hstClincia.setOsPersona(persona);
		hstClincia.setOsDentadura(dentadura);
		hstOn.guardarHstClinico(hstClincia);

		//this.init();
		return null;
	}
	
	public String historiaPaciente (String cedula) {
		System.out.println("Historial "+ cedula);
		return "historial_clinico?faces-redirect=true";
	}

	public String Buscar() {
		OsHstClinica h = hstOn.read(hstClincia.getHstClId());
		if (h != null) {
			hstClincia = h;
		} else {
			System.out.println("histroial clinico no se ha podido encontrar porque no existe");
		}

		//this.init();
		return null;
	}

	public String EliminarCita() {
		OsHstClinica h = hstOn.read(hstClincia.getHstClId());
		if (h != null) {
			hstOn.delete(hstClincia.getHstClId());
			System.out.println("historial clinico eliminado con exito");
		} else {
			System.out.println("historial clinico no se ha podido eliminar porque no existe");
		}
		//this.init();
		return null;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

}
