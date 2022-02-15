package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionUsuarioON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

@Named("dtUsuario")
@RequestScoped
public class UsuarioBean {

	/**
	 * Se han creado los siguientes atributos que pertenencen a un usuario 
	 * de la misma manera se ganerado los getters y setter de cada atributo
	 */
	private String usCorreo;
	private String usPassword;
	private String usTipo;
	
	/**
	 * se ha creado unos atributos adicionales para realizar gestiones dentro de la base de datos
	 * y tambien se han instanciado objetos de tipo usuario,persona y List para poder utilizarlo dentro de la interfaz.
	 */
	@Inject
	private GestionUsuarioON useOn;
	
	private OsUsuario usuario;
	private OsPersona persona;

	private List<OsUsuario> usuarios;
	
	/**
	 * se ha creado un controlador el cual Inicializa  los objetos que se utilizaran en la interfaz
	 */
	@PostConstruct
	private void init() {
		persona = new OsPersona();
		usuario = new OsUsuario();
		usuarios = useOn.findAllPacientes();
	}

	public String getUsCorreo() {
		return usCorreo;
	}

	public void setUsCorreo(String usCorreo) {
		this.usCorreo = usCorreo;
	}

	public String getUsPassword() {
		return usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	public String getUsTipo() {
		return usTipo;
	}

	public void setUsTipo(String usTipo) {
		this.usTipo = usTipo;
	}

	public GestionUsuarioON getUseOn() {
		return useOn;
	}

	public void setUseOn(GestionUsuarioON useOn) {
		this.useOn = useOn;
	}

	public OsUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(OsUsuario usuario) {
		this.usuario = usuario;
	}

	public OsPersona getPersona() {
		return persona;
	}

	public void setPersona(OsPersona persona) {
		this.persona = persona;
	}

	public List<OsUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<OsUsuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 *Este metodo nos ayuda a redirigir los datos de un paciente a otra vista
	 *@param cedula.
	 *@return String.
	 */
	public String historiaPaciente (String cedula) {
		System.out.println("Historial "+ this.usCorreo);
		return "historial_clinico?faces-redirect=true";
	}
	
}
