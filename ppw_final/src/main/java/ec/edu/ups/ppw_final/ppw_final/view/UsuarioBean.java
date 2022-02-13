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

	private String usCorreo;
	private String usPassword;
	private String usTipo;
	
	
	@Inject
	private GestionUsuarioON useOn;
	
	private OsUsuario usuario;
	private OsPersona persona;

	private List<OsUsuario> usuarios;
	
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
	
	public String historiaPaciente (String cedula) {
		System.out.println("Historial "+ this.usCorreo);
		return "historial_clinico?faces-redirect=true";
	}
	
}
