package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorUsuario;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

@Stateless
public class GestionUsuarioON {

	@Inject
	private ControladorUsuario controladorU;
	
	public void guardarUsuario(OsUsuario usuario) {
		OsUsuario u = controladorU.read(usuario.getUsCorreo());
		if(u==null) {
			controladorU.insert(usuario);
			System.out.println("usuario creado con exito");
		}else {
			controladorU.update(usuario);
			System.out.println("usuario modificado con exito");
		}
	}
	
	public OsUsuario validar(String usuario, String contrasenia) {
		List<OsUsuario> u=controladorU.Validar(usuario, contrasenia);
		if(u.size()>0) {
			return u.get(0);
		}else {
			return null;
		}
	}
	
	public void delete(String usuario) {
		controladorU.delete(usuario);
	}
	
	public OsUsuario read(String usuario) {
		return controladorU.read(usuario);
	}
	
	public List<OsUsuario> findAll(){		
		return controladorU.findAll();
	}
	
	public List<OsUsuario> findAllPacientes(){		
		return controladorU.findAll().stream().filter(u -> u.getUsTipo().equals("PACIENTE")).collect(Collectors.toList());
	}
	
}
