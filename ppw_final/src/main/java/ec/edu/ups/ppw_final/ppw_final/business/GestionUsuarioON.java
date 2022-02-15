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

	/**
	 * se inicializa el controlador usuario para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorUsuario controladorU;
	
	/**
	 * este metodo recibe un objeto de tipo usuario y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param usuario.
	 */
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
	
	/**
	 *Este metodo retorna un objeto de tipo usuarioy recibe dos objetos de tipo String en su parametro.
	 *este metodo revisa dentro de la base de datos si es que existe es usuario con ese correo y contraseñia 
	 *y lo retorna caso contrario retorna un objeto de tipo null.
	 *@param usuario.
	 *@param contrasenia.
	 *@return OsUsuario
	 */
	public OsUsuario validar(String usuario, String contrasenia) {
		List<OsUsuario> u=controladorU.Validar(usuario, contrasenia);
		if(u.size()>0) {
			return u.get(0);
		}else {
			return null;
		}
	}
	
	/**
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param usuario
	 */
	public void delete(String usuario) {
		controladorU.delete(usuario);
	}
	
	/**
	 * Este metodo busca un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param usuario
	 * @return OsUsuario
	 */
	public OsUsuario read(String usuario) {
		return controladorU.read(usuario);
	}
	
	/**
	 * Este metodo devuele todo el listado de usuarios dentro de la base de datos.
	 * @return List<OsUsuario>
	 */
	public List<OsUsuario> findAll(){		
		return controladorU.findAll();
	}
	/**
	 * Este metodo realiza una busqueda dentro de la basa de datos y retorna un listado de usuarios 
	 * que sean de tipos pacientes
	 * @return List<OsUsuario> 
	 */
	public List<OsUsuario> findAllPacientes(){		
		return controladorU.findAll().stream().filter(u -> u.getUsTipo().equals("PACIENTE")).collect(Collectors.toList());
	}
	
}
