package ec.edu.ups.ppw_final.ppw_final.controlador;

//import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;

@Stateless
public class ControladorHstClinica {

	/*@Override
	public List<OsHstClinica> findAll() {
		Query consulta = getEm().createNamedQuery("OsHstClinica.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsHstClinica o1, OsHstClinica o2) -> o1.getHstClId().compareTo(o2.getHstClId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsHstClinica o1, OsHstClinica o2) -> o1.getHstClId().compareTo(o2.getHstClId()));
			//return (int) (lista.get(lista.size() - 1).getHstClId() + 1);
			return 0;
		} else {
			return 1;
		}
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
	public void insert(OsHstClinica p) {
		em.persist(p);

	}

	/*
	 * Este metodo realiza la accion de actualizar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void update(OsHstClinica p) {
		em.merge(p);
	}

	/*
	 * Este metodo realiza la accion de eliminar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public void delete(int id) {
		OsHstClinica p = em.find(OsHstClinica.class, id);
		em.remove(p);
	}
	
	/*
	 * Este metodo realiza la accion de buscar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public OsHstClinica read(int id){
		OsHstClinica p = em.find(OsHstClinica.class, id);
		return p;
	}
	
	/*
	 * Este metodo retorna todo el listado de historiales clinicos que existe dentro de la base de 
	 * datos
	 */
	public List<OsHstClinica> findAll(){
		String jpql = "SELECT o FROM OsHstClinica o";
		
		Query q = em.createQuery(jpql, OsHstClinica.class);
		
		return q.getResultList();
	}
}
