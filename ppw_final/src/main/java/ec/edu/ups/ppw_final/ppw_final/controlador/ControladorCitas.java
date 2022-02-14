package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Stateless
public class ControladorCitas {

	/*
	 * Se ha instanciado el Entitymanager para poder realizar las modificacion
	 * dentro de la base de datos 
	 */
	@PersistenceContext
	private EntityManager em;
	
	/*
	 * Este metodo realiza la accion de crear o insertar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void insert(OsCita p) {
		em.persist(p);

	}

	/*
	 * Este metodo realiza la accion de actualizar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void update(OsCita p) {
		em.merge(p);
	}

	/*
	 * Este metodo realiza la accion de eliminar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public void delete(int id) {
		OsCita p = em.find(OsCita.class, id);
		em.remove(p);
	}

	/*
	 * Este metodo realiza la accion de buscar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public OsCita read(int id) {
		OsCita p = em.find(OsCita.class, id);
		return p;
	}

	/*
	 * Este metodo retorna todo el listado de citas que existe dentro de la base de 
	 * datos
	 */
	public List<OsCita> findAll() {
		String jpql = "SELECT o FROM OsCita o";

		Query q = em.createQuery(jpql, OsCita.class);

		return  q.getResultList();
	}

	/*
	 * Este metodo realiza la busqueda de una persona mediante la cedula de una persona
	 * una vez que haya encontrado el objeto dentro de la base de datos lo retorna al usuario
	 * @param cedula.
	 * 
	 */
	public OsCita findPersona(String cedula) {
		String jpql = "select * from os_cita where os_persona_per_cedula like ?1";

		Query q = em.createQuery(jpql, OsPersona.class);
		q.setParameter(1, cedula);
		
		return  (OsCita) q.getResultList().get(0);
		
	}

}
