package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;

@Stateless
public class ControladorCitas {

	@PersistenceContext
	private EntityManager em;

	public void insert(OsCita p) {
		em.persist(p);

	}

	public void update(OsCita p) {
		em.merge(p);
	}


	public void delete(int id) {
		OsCita p = em.find(OsCita.class, id);
		em.remove(p);
	}
	
	public OsCita read(int id){
		OsCita p = em.find(OsCita.class, id);
		return p;
	}
	
	public List<OsCita> findAll(){
		String jpql = "SELECT o FROM OsCita o";
		
		Query q = em.createQuery(jpql, OsCita.class);
		
		return q.getResultList();
	}

}
