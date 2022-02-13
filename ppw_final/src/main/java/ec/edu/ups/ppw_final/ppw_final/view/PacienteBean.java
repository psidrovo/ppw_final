package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionUsuarioON;

@Named
@RequestScoped
public class PacienteBean {

	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private List<OsPersona> personas;

	@Inject
	private GestionPersonaON perOn;
	@Inject
	private GestionUsuarioON useOn;
	
	
	private OsPersona persona;
	private OsUsuario usuario;

	@PostConstruct
	private void init() {
		persona = new OsPersona();
		usuario = new OsUsuario();
		personas = perOn.findAll();
		for (OsPersona osPersona : personas) {
			System.out.println(osPersona.toString());
		}
		
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public OsUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(OsUsuario usuario) {
		this.usuario = usuario;
	}

	public GestionUsuarioON getUseOn() {
		return useOn;
	}

	public void setUseOn(GestionUsuarioON useOn) {
		this.useOn = useOn;
	}
	
	public List<OsPersona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<OsPersona> personas) {
		this.personas = personas;
	}

	public String guardar() {		
		System.out.println(persona.toString()+"\n"+usuario.toString());
		OsPersona p = perOn.read(persona.getPerCedula());
		if (p != null) {
			usuario.setUsTipo("PACIENTE");
			usuario.setOsPersona(persona);
			useOn.guardarUsuario(usuario);
			System.out.println("Actualizado ->" + "\n" + persona + "\n" + usuario);
		} else {
			usuario.setUsTipo("PACIENTE");
			usuario.setOsPersona(persona);
			perOn.guardarPersona(persona);
			useOn.guardarUsuario(usuario);
			System.out.println("Nuevo ->" + "\n" + persona + "\n" + usuario);
		}
		//this.init();
		return null;
		
		/*
		 * usuario.setUsTipo("PACIENTE"); 
		 * usuario.setOsPersona(persona);
		 * System.out.println("Guardar--> " + "\n" +persona +"\n"+usuario);
		 * perOn.guardarPersona(persona); 
		 * this.init(); 
		 * return null;
		 */
	}

	public String buscarPaciente() {
		OsPersona p = perOn.read(persona.getPerCedula());
		if (p != null) {
			persona=p;
			System.out.println("Se ha encontrado la persona exitosamente");
		} else {
			System.out.println("No se ha podido encontrar a la persona porque no existe");
		}

		this.init();
		return null;
	}
	public OsPersona listarPacientes() {
		for (OsPersona p : personas) {
			System.out.println(p.toString());			
			this.init();
			return p;
		}
		return null;
	}

	

}
