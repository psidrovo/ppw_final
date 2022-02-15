package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionCitasON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Named
@RequestScoped
public class CitaBean {

	/**
	 * se ha creado todos los atributos que contienen una cita
	 */
	private int id;
	private String descripcion;
	private String estado;
	private String fecha;

	/**
	 * se ha creado los atributos adicionales para poder utilizarlos
	 * y manipular la base de datos.
	 * 
	 */
	@Inject
	private GestionPersonaON perOn;
	@Inject
	private GestionCitasON citaOn;
	private OsPersona persona;
	private OsCita cita;
	private List<OsPersona> personas;
	private List<OsCita> citas;

	/**
	 * Se ha creado un constructor en el cual se Inicializa los objetos.
	 */
	@PostConstruct
	private void init() {
		persona = new OsPersona();
		cita = new OsCita();
		citas = citaOn.findAll();
		personas = perOn.findAll();
	}

	public List<OsPersona> getPersonas() {
		return personas;
	}





	public void setPersonas(List<OsPersona> personas) {
		this.personas = personas;
	}





	public List<OsCita> getCitas() {
		return citas;
	}



	public void setCitas(List<OsCita> citas) {
		this.citas = citas;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public GestionPersonaON getPerOn() {
		return perOn;
	}

	public void setPerOn(GestionPersonaON perOn) {
		this.perOn = perOn;
	}

	public GestionCitasON getCitaOn() {
		return citaOn;
	}

	public void setCitaOn(GestionCitasON citaOn) {
		this.citaOn = citaOn;
	}

	public OsPersona getPersona() {
		return persona;
	}

	public void setPersona(OsPersona persona) {
		this.persona = persona;
	}

	public OsCita getCita() {
		return cita;
	}

	public void setCita(OsCita cita) {
		this.cita = cita;
	}

	/**
	 * Este metodo realiza la accion de guardar una persona en caso de que no exista 
	 * una vez creada la persona se lo asignara al objeto cita y se creara el objeto cita
	 */
	public String guardar() {
			perOn.guardarPersona(persona);
			cita.setOsPersona(persona);
			citaOn.guardarCita(cita);

		this.init();
		return null;
	}

	/**
	 * este metodo realizara la busqueda del objeto cita medianta la llave primaria.
	 * en caso de no encontrar el objeto se imprimira un mensaje en consola que no ha encontrado el objeto
	 */
	public String BuscarCita() {
		OsCita c = citaOn.read(cita.getCtId());
		if (c != null) {
			cita = c;
		} else {
			System.out.println("Cita no se ha podido encontrar porque no existe");
		}

		this.init();
		return null;
	}

	/**
	 * este metodo realiza la eliminacion de un objeto cita mediante la llave primaria. en caso
	 * de que no encuentro el objeto se imprimira un mensaje en consola informando al usuario de que no 
	 * se ha podidio eliminar la cita.
	 */
	public String EliminarCita() {
		OsCita c = citaOn.read(cita.getCtId());
		if (c != null) {
			citaOn.delete(cita.getCtId());
			System.out.println("Cita eliminado con exito");
		} else {
			System.out.println("Cita no se ha podido eliminar porque no existe");
		}
		this.init();
		return null;
	}

}
