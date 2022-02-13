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
	private String correo;
	private String contrasenia;
	private String tipo;
	
	@Inject
	private GestionPersonaON perOn;
	@Inject
	private GestionUsuarioON useOn;
	
	
	private OsPersona persona;
	private OsUsuario usuario;	
	private List<OsPersona> personas;
	private List<OsUsuario> usuarios;
	

	@PostConstruct
	private void init() {
		persona = new OsPersona();
		usuario = new OsUsuario();
		personas= perOn.findAll();
		usuarios=useOn.findAll();
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

	public String guardar() {		

		usuario.setUsTipo("PACIENTE");
		perOn.guardarPersona(persona);
		usuario.setOsPersona(persona);
		useOn.guardarUsuario(usuario);
		this.init();
		return null;
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
	
	public String eliminarPaciente() {
		OsPersona p = perOn.read(persona.getPerCedula());
		OsUsuario u = useOn.read(usuario.getUsCorreo());
		if(u!=null && p!=null) {
			perOn.delete(persona.getPerCedula());
			useOn.delete(usuario.getUsCorreo());
		}else {
			System.out.println("No se ha podido eliminar el usuario y la persona porque no existe");
		}
		
		this.init();
		return null;
	}

}
