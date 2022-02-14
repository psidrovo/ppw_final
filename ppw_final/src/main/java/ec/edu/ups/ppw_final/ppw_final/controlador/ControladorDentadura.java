package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;

@Stateless
public class ControladorDentadura {

	/*@Override
	public List<OsDentadura> findAll() {
		Query consulta = getEm().createNamedQuery("OsDentadura.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			//Collections.sort(lista,(OsDentadura o1, OsDentadura o2) -> o1.getDentId().compareTo(o2.getDentId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsDentadura o1, OsDentadura o2) -> o2.getDentId().compareTo(o1.getDentId()));
			//return (int) (lista.get(lista.size() - 1).getDentId() + 1);
			return 0;
		} else {
			return 1;
		}
	}*/
	
	/*
	 * Se ha instanciado el Entity manager para poder realizar las modificacion
	 * dentro de la base de datos 
	 */
	@PersistenceContext
	private EntityManager em;

	/*
	 * Este metodo realiza la accion de crear o insertar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void insert(OsDentadura p) {
		em.persist(p);

	}

	/*
	 * Este metodo realiza la accion de actualizar el objeto dentro
	 * de la base de datos
	 * @param p.
	 */
	public void update(OsDentadura p) {
		em.merge(p);
	}


	/*
	 * Este metodo realiza la accion de eliminar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public void delete(int id) {
		OsDentadura p = em.find(OsDentadura.class, id);
		em.remove(p);
	}
	
	/*
	 * Este metodo realiza la accion de buscar el objeto dentro
	 * de la base de datos y los hace mediante la llave primaria del objeto
	 * @param id.
	 */
	public OsDentadura read(int id){
		OsDentadura p = em.find(OsDentadura.class, id);
		return p;
	}
	
	/*
	 * Este metodo retorna todo el listado de dentaduras que existe dentro de la base de 
	 * datos
	 */
	public List<OsDentadura> findAll(){
		String jpql = "SELECT o FROM OsDentadura o";
		
		Query q = em.createQuery(jpql, OsCita.class);
		
		return q.getResultList();
	}

}
