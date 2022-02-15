package ec.edu.ups.ppw_final.ppw_final.controlador;

//import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Stateless
public class ControladorDetDentadura {

	/*
	@Override
	public List<OsDetDentadura> findAll() {
		Query consulta = getEm().createNamedQuery("OsDetDentadura.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			//Collections.sort(lista,(OsDetDentadura o1, OsDetDentadura o2) -> o1.getDetDentId().compareTo(o2.getDetDentId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsDetDentadura o1, OsDetDentadura o2) -> o2.getDetDentId().compareTo(o1.getDetDentId()));
			//return (int) (lista.get(lista.size() - 1).getDetDentId() + 1);
			return 0;
		} else {
			return 1;
		}
	}*/
	
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
	public void insert(OsDetalleDen p) {
		em.persist(p);
	
	}

	/**
	 * Este metodo realiza la accion de actualizar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void update(OsDetalleDen p) {
		em.merge(p);
	}

	/**
	 * Este metodo realiza la accion de eliminar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public void delete(int id) {
		OsDetalleDen p = em.find(OsDetalleDen.class, id);
		em.remove(p);
	}
	
	/**
	 * Este metodo realiza la accion de buscar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 * @return OsDetalleDen
	 */
	public OsDetalleDen read(int id){
		OsDetalleDen p = em.find(OsDetalleDen.class, id);
		return p;
	}
	
	/**
	 * Este metodo retorna todo el listado de detalles dentaduras que existe dentro de la base de 
	 * datos
	 * @return List<OsDetalleDen>  
	 */
	public List<OsDetalleDen> findAll(){
		String jpql = "SELECT o FROM OsDetalleDen o";		
		Query q = em.createQuery(jpql, OsDetalleDen.class);		
		return q.getResultList();
	}
	
	/**
	 * Este metodo realiza la busqueda de una detalle dentadura mediante el codigo de una dentadura
	 * una vez que haya encontrado el objeto dentro de la base de datos lo retorna al usuario
	 * @param codigo.
	 * @return List<OsDetalleDen> 
	 * 
	 */
	public List<OsDetalleDen> findbyDentadura(int codigo) {
		String jpql = "select * from os_cita where os_persona_per_cedula like ?1";
		Query q = em.createQuery(jpql, OsPersona.class);
		q.setParameter(1, codigo);		
		return q.getResultList();
	}
	
	/**
	 * Este metodo nos retorna el ultimo detalle den que se genero recientemente.
	 * @return OsDetalleDen
	 */
	public OsDetalleDen recuperarUltimoDetalle(){
		String jpql = "SELECT o FROM OsDetalleDen o order by id desc";		
		Query q = em.createQuery(jpql, OsDetalleDen.class);		
		return (OsDetalleDen) q.getResultList().get(0);
	}

}
