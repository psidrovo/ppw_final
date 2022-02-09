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
	

	public List<OsCita> findAll() {
		
		String jpql = "SELECT o FROM OsCita o";
		
		Query q = em.createQuery(jpql, OsCita.class);
		
		return q.getResultList();
	}


}
