package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDetDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionHstClinicaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionRCMedON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsRcMed;

@Named
@RequestScoped
public class HstClinicaBean {

	private int id;
	private String detalle;
	private String fase;
	private String fecha;
	
	@Inject
	private GestionHstClinicaON hstOn;
	@Inject
	private GestionDetDentaduraON denDetOn;
	@Inject
	private GestionPersonaON perOn;
	@Inject
	private GestionRCMedON RCMedOn;
	
	private OsPersona persona;
	private OsDetalleDen detDentadura;
	private OsRcMed RcMed;
	private OsHstClinica hstClincia;
	
	private List<OsHstClinica> hstClinicas;
	
	@PostConstruct
	private void init() {
		persona = new OsPersona();
		RcMed = new OsRcMed();
		detDentadura = new OsDetalleDen();
		hstClincia = new OsHstClinica();
		hstClinicas= hstOn.findAll();
		
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

	public GestionDetDentaduraON getDenDetOn() {
		return denDetOn;
	}

	public void setDenDetOn(GestionDetDentaduraON denDetOn) {
		this.denDetOn = denDetOn;
	}

	public GestionPersonaON getPerOn() {
		return perOn;
	}

	public void setPerOn(GestionPersonaON perOn) {
		this.perOn = perOn;
	}

	public GestionRCMedON getRCMedOn() {
		return RCMedOn;
	}

	public void setRCMedOn(GestionRCMedON rCMedOn) {
		RCMedOn = rCMedOn;
	}

	public OsPersona getPersona() {
		return persona;
	}

	public void setPersona(OsPersona persona) {
		this.persona = persona;
	}

	public OsDetalleDen getDetDentadura() {
		return detDentadura;
	}

	public void setDetDentadura(OsDetalleDen detDentadura) {
		this.detDentadura = detDentadura;
	}

	public OsRcMed getRcMed() {
		return RcMed;
	}

	public void setRcMed(OsRcMed rcMed) {
		RcMed = rcMed;
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
		OsHstClinica h = hstOn.read(hstClincia.getHstClId());
		if (h != null) {
			hstClincia.setOsDetalleDen(detDentadura);
			hstClincia.setOsPersona(persona);
			hstClincia.setOsRcMed(RcMed);
			hstOn.guardarHstClinico(hstClincia);
			//System.out.println("Guardar Cita ->" + cita + "\n" + " persona:" + p);
		} else {
			hstClincia.setOsDetalleDen(detDentadura);
			hstClincia.setOsPersona(persona);
			hstClincia.setOsRcMed(RcMed);
			hstOn.guardarHstClinico(hstClincia);
			//System.out.println("no se ha podido guardar la cita porque la persona no existe");
		}

		this.init();
		return null;
	}
	
	public String Buscar() {
		OsHstClinica h = hstOn.read(hstClincia.getHstClId());
		if (h != null) {
			hstClincia = h;
		} else {
			System.out.println("histroial clinico no se ha podido encontrar porque no existe");
		}

		this.init();
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
		this.init();
		return null;
	}
	
	
}
