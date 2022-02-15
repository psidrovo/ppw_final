package ec.edu.ups.ppw_final.ppw_final.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionHstClinicaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Named
@ViewScoped
public class HstClinicaBean implements Serializable{

	/**
	 * se ha creado todos los atributos que contienen una cita
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String detalle;
	private String fase;
	private String fecha;
	private String receta;
	private String tratamiento;
	private String cedulaPaciente;
	
	/**
	 * se ha creado los atributos adicionales para poder utilizarlos
	 * y manipular la base de datos.
	 * 
	 */
	@Inject
	private GestionHstClinicaON hstOn;
	@Inject
	private GestionDentaduraON denOn;
	@Inject
	private GestionPersonaON perOn;
	@Inject
	private GestionDetDentaduraON dtDOn;

	private OsDetalleDen detDentadura;
	private OsPersona persona;
	private OsDentadura dentadura;
	private OsHstClinica hstClincia;

	private List<OsHstClinica> hstClinicas;
	
	/**
	 * Se ha creado un constructor en el cual se Inicializa los objetos.
	 */
	public void init() {	
		persona=new OsPersona();
		detDentadura=new OsDetalleDen();
		System.out.println("Inicializando");
		dentadura=new OsDentadura();		
		hstClincia = new OsHstClinica();
		hstClinicas = hstOn.findListaPorCedula(cedulaPaciente);
	}

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

	/**
	 * Este metodo guarda un objeto de tipo histroial clinica en el cual,
	 * primero se asigna su respectiva persona y detalle de dentadura. una vez asignado se guarda el historial 
	 * dentro de la base de datos.
	 * @return String.
	 */
	public String guardar() {
		
		persona = perOn.read(cedulaPaciente);	
		int idDentadura= dentadura.getDentId();
		dentadura = denOn.read(idDentadura);
		

		detDentadura.setOsDentadura(dentadura);
		dtDOn.guardarDetDentadura(detDentadura);
		detDentadura = dtDOn.recuperarUltimoDetalle();
		hstClincia.setHstClFecha(new java.util.Date());
		System.out.println(hstClincia.getHstClFecha());		
		hstClincia.setOsPersona(persona);
		hstClincia.setOsDetalleDen(detDentadura);		
		hstOn.guardarHstClinico(hstClincia);
		hstClinicas = hstOn.findListaPorCedula(cedulaPaciente);
		FacesMessage msg = new FacesMessage("RESGISTRO COMPLETADO");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return null;
	}
	
	/**
	 * Este metodo encuentra el historial clinica mediante la persona relacionada a ella.
	 * una vez encontrada carga los datos encontrados en la pagina a la que se redirecciona
	 * @param cedula
	 * @return String.
	 */
	public String historiaPaciente (String cedula) {
		System.out.println("Historial "+ cedula);
		return "historial_clinico?faces-redirect=true";
	}

	/**
	 * este metodo realizara la busqueda del objeto historial cinica medianta la llave primaria.
	 * en caso de no encontrar el objeto se imprimira un mensaje en consola que no ha encontrado el objeto
	 * @return String
	 */
	public String Buscar() {
		OsHstClinica h = hstOn.read(hstClincia.getHstClId());
		if (h != null) {
			hstClincia = h;
		} else {
			System.out.println("histroial clinico no se ha podido encontrar porque no existe");
		}

		return null;
	}

	/**
	 * este metodo realiza la eliminacion de un objeto histroail clinica mediante la llave primaria. en caso
	 * de que no encuentro el objeto se imprimira un mensaje en consola informando al usuario de que no 
	 * se ha podidio eliminar el historial clinico.
	 * @return
	 */
	public String EliminarCita() {
		OsHstClinica h = hstOn.read(hstClincia.getHstClId());
		if (h != null) {
			hstOn.delete(hstClincia.getHstClId());
			System.out.println("historial clinico eliminado con exito");
		} else {
			System.out.println("historial clinico no se ha podido eliminar porque no existe");
		}
		return null;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public GestionDetDentaduraON getDtDOn() {
		return dtDOn;
	}

	public void setDtDOn(GestionDetDentaduraON dtDOn) {
		this.dtDOn = dtDOn;
	}

	public OsDetalleDen getDetDentadura() {
		return detDentadura;
	}

	public void setDetDentadura(OsDetalleDen detDentadura) {
		this.detDentadura = detDentadura;
	}

}
