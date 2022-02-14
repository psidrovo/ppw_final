package ec.edu.ups.ppw_final.ppw_final.controlador;

//import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Stateless
public class ControladorPersona{

	/*@Override
	public List<OsPersona> findAll() {
		Query consulta = getEm().createNamedQuery("OsPersona.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsPersona o1, OsPersona o2) -> o1.getPerCedula().compareTo(o2.getPerCedula()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		return 0;
	}*/
	
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
	public void insert(OsPersona p) {
		em.persist(p);

	}

	/*
	 * Este metodo realiza la accion de actualizar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void update(OsPersona p) {
		em.merge(p);
	}

	/*
	 * Este metodo realiza la accion de eliminar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public void delete(String cedula) {
		OsPersona p = em.find(OsPersona.class, cedula);
		em.remove(p);
	}
	
	/*
	 * Este metodo realiza la accion de buscar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public OsPersona read(String cedula){
		OsPersona p = em.find(OsPersona.class, cedula);
		return p;
	}
	
	/*
	 * Este metodo retorna todo el listado de personas que existen dentro de la base de 
	 * datos
	 */
	public List<OsPersona> findAll(){
		String jpql = "SELECT o FROM OsPersona o";
		
		Query q = em.createQuery(jpql, OsPersona.class);
		
		return q.getResultList();
	}

}
