package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.Comparator;
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
	
	@PersistenceContext
	private EntityManager em;

	public void insert(OsDentadura p) {
		em.persist(p);

	}

	public void update(OsDentadura p) {
		em.merge(p);
	}


	public void delete(int id) {
		OsDentadura p = em.find(OsDentadura.class, id);
		em.remove(p);
	}
	
	public OsDentadura read(int id){
		OsDentadura p = em.find(OsDentadura.class, id);
		return p;
	}
	
	public List<OsDentadura> findAll(){
		String jpql = "SELECT o FROM OsDentadura o";
		
		Query q = em.createQuery(jpql, OsCita.class);
		
		return q.getResultList();
	}

}
