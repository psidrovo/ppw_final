package ec.edu.ups.ppw_final.ppw_final.controlador;

//import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;

@Stateless
public class ControladorDetPago {

	/*@Override
	public List<OsDetPago> findAll() {
		Query consulta = getEm().createNamedQuery("OsDetPago.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			//Collections.sort(lista,(OsDetPago o1, OsDetPago o2) -> o1.getDetPgId().compareTo(o2.getDetPgId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsDetPago o1, OsDetPago o2) -> o1.getDetPgId().compareTo(o2.getDetPgId()));
			//return (int) (lista.get(lista.size() - 1).getDetPgId() + 1);
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
	public void insert(OsDetPago p) {
		em.persist(p);

	}

	/**
	 * Este metodo realiza la accion de actualizar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void update(OsDetPago p) {
		em.merge(p);
	}

	/**
	 * Este metodo realiza la accion de eliminar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public void delete(int id) {
		OsDetPago p = em.find(OsDetPago.class, id);
		em.remove(p);
	}
	
	/**
	 * Este metodo realiza la accion de buscar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 * @return OsDetPago
	 */
	public OsDetPago read(int id){
		OsDetPago p = em.find(OsDetPago.class, id);
		return p;
	}
	
	/**
	 * Este metodo retorna todo el listado de detalles pagos que existe dentro de la base de 
	 * datos
	 * @return List<OsDetPago>
	 */
	public List<OsDetPago> findAll(){
		String jpql = "SELECT o FROM OsDetPago o";
		
		Query q = em.createQuery(jpql, OsDetPago.class);
		
		return q.getResultList();
	}

}
