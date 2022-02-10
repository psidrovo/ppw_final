package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetDentadura;

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
	
	@PersistenceContext
	private EntityManager em;

	public void insert(OsDetDentadura p) {
		em.persist(p);

	}

	public void update(OsDetDentadura p) {
		em.merge(p);
	}


	public void delete(int id) {
		OsDetDentadura p = em.find(OsDetDentadura.class, id);
		em.remove(p);
	}
	
	public OsDetDentadura read(int id){
		OsDetDentadura p = em.find(OsDetDentadura.class, id);
		return p;
	}
	
	public List<OsDetDentadura> findAll(){
		String jpql = "SELECT o FROM OsDetDentadura o";
		
		Query q = em.createQuery(jpql, OsDetDentadura.class);
		
		return q.getResultList();
	}
	

}
