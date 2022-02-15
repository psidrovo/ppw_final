package ec.edu.ups.ppw_final.ppw_final.controlador;

//import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

@Stateless
public class ControladorUsuario {

	/**
	 * Se ha instanciado el Entitymanager para poder realizar las modificacion
	 * dentro de la base de datos 
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Este metodo realiza la accion de crear o insertar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void insert(OsUsuario p) {
		em.persist(p);

	}

	/**
	 * Este metodo realiza la accion de actualizar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void update(OsUsuario p) {
		em.merge(p);
	}

	/**
	 * Este metodo realiza la accion de validar si el usuario existe. En caso de que si exista dentro 
	 * de la base de datos retorna ese usuario. 
	 * @param usuario.
	 * @param contrasenia.
	 * @return List<OsUsuario>
	 */
	public List<OsUsuario> Validar(String usuario, String contrasenia) {
		String jpql = "SELECT p FROM os_usuario p WHERE p.us_correo LIKE ?1 AND p.us_password LIKE ?2";

		Query q = em.createQuery(jpql, OsUsuario.class);
		q.setParameter(1,usuario).setParameter(2, contrasenia);
		return q.getResultList();
	}

	/**
	 * Este metodo realiza la accion de eliminar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param usuario.
	 */
	public void delete(String usuario) {
		OsUsuario p = em.find(OsUsuario.class, usuario);
		em.remove(p);
	}
	
	/**
	 * Este metodo realiza la accion de buscar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param usuario.
	 * @return OsUsuario
	 */
	public OsUsuario read(String usuario){
		OsUsuario p = em.find(OsUsuario.class, usuario);
		return p;
	}
	
	/**
	 * Este metodo realiza la busqueda de un usuario mediante la cedula de una persona
	 * una vez que haya encontrado el objeto dentro de la base de datos lo retorna al usuario
	 * @param cedula.
	 * @return OsUsuario
	 * 
	 */
	public OsUsuario findByPersona(String cedula) {
		String jpql = "SELECT * FROM os_usuario p WHERE p.per_cedula_us_persona_fk LIKE ?";

		Query q = em.createQuery(jpql, OsUsuario.class);
		q.setParameter(1,cedula);
		return (OsUsuario) q.getResultList().get(0);
	}
	
	
	/**
	 * Este metodo retorna todo el listado de usuarios que existen dentro de la base de 
	 * datos
	 * @return List<OsUsuario>
	 */
	public List<OsUsuario> findAll(){
		String jpql = "SELECT o FROM OsUsuario o";
		
		Query q = em.createQuery(jpql, OsUsuario.class);
		
		return q.getResultList();
	}
}
