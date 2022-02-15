package ec.edu.ups.ppw_final.ppw_final.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionUsuarioON;

@Named
@ViewScoped
public class PacienteBean implements Serializable{

	/**
	 * se ha creado todos los atributos que contiene un paciente
	 */
	private static final long serialVersionUID = 1L;
	 
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String correo;
	private String contrasenia;
	private String tipo;

	/**
	 * se ha creado los atributos adicionales para poder utilizarlos
	 * y manipular la base de datos.
	 * 
	 */
	@Inject
	private GestionPersonaON perOn;
	@Inject
	private GestionUsuarioON useOn;

	private OsPersona persona;
	private OsUsuario usuario;
	private List<OsPersona> personas;
	private List<OsUsuario> usuarios;

	/**
	 * Se ha creado un constructor en el cual se Inicializa los objetos.
	 */
	public void init() {
		persona = new OsPersona();
		usuario = new OsUsuario();
		personas = perOn.findAll();
		usuarios = useOn.findAll();
		System.out.println(personas.toString());
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<OsUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<OsUsuario> usuarios) {
		this.usuarios = usuarios;
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

	/**
	 * Este metodo realiza la accion de guardar una paciente con su usuario en caso de que no exista 
	 * una vez creada la persona se lo asignara al objeto cita y se creara el objeto cita
	 * @return String.
	 */
	public String guardar() {
		usuario.setUsTipo("PACIENTE");
		perOn.guardarPersona(persona);
		usuario.setOsPersona(persona);
		useOn.guardarUsuario(usuario);
		FacesMessage msg = new FacesMessage("RESGISTRO COMPLETADO");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.init();
		return null;
	}
	
	/**
	 *  Este metodo realiza la accion de guardar una paciente con su usuario en caso de que no exista 
	 * una vez creada la persona se lo asignara al objeto cita y se creara el objeto cita
	 */
	public void guardarSumit() {
		System.out.println(persona.toString());
		usuario.setUsTipo("PACIENTE");
		perOn.guardarPersona(persona);
		usuario.setOsPersona(persona);
		useOn.guardarUsuario(usuario);
		FacesMessage msg = new FacesMessage("RESGISTRO COMPLETADO");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.init();
	}

	/**
	 * este metodo realizara la busqueda del objeto paciente medianta la llave primaria.
	 * en caso de no encontrar el objeto se imprimira un mensaje en consola que no ha encontrado el objeto
	 * @return String.
	 */
	public String buscarPaciente() {
		OsPersona p = perOn.read(persona.getPerCedula());
		if (p != null) {
			persona = p;
			System.out.println("Se ha encontrado la persona exitosamente");
		} else {
			System.out.println("No se ha podido encontrar a la persona porque no existe");
		}

		this.init();
		return null;
	}

	/**
	 * Este metodo retorna todo el listado de paciente que se encuentra dentro de la base de datos.
	 * @return OsPersona
	 */
	public OsPersona listarPacientes() {
		for (OsPersona p : personas) {
			System.out.println(p.toString());
			this.init();
			return p;
		}
		return null;
	}

	/**
	 * este metodo realiza la eliminacion de un objeto paciente mediante la llave primaria. en caso
	 * de que no encuentro el objeto se imprimira un mensaje en consola informando al usuario de que no 
	 * se ha podidio eliminar a persona o el usuario.
	 * @return String.
	 */
	public String eliminarPaciente() {
		OsPersona p = perOn.read(persona.getPerCedula());
		OsUsuario u = useOn.read(usuario.getUsCorreo());
		if (u != null && p != null) {
			perOn.delete(persona.getPerCedula());
			useOn.delete(usuario.getUsCorreo());
		} else {
			System.out.println("No se ha podido eliminar el usuario y la persona porque no existe");
		}

		this.init();
		return null;
	}

}
