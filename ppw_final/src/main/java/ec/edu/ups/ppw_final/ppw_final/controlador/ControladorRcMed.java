package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.ups.ppw_final.ppw_final.modelo.OsRcMed;

@Stateless
public class ControladorRcMed {

	/*@Override
	public List<OsRcMed> findAll() {
		Query consulta = getEm().createNamedQuery("OsRcMed.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			//Collections.sort(lista,(OsRcMed o1, OsRcMed o2) -> o1.getRcMedId().compareTo(o2.getRcMedId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsRcMed o1, OsRcMed o2) -> o1.getRcMedId().compareTo(o2.getRcMedId()));
			//return (int) (lista.get(lista.size() - 1).getRcMedId() + 1);
			return 0;
		} else {
			return 1;
		}
	}*/
	
	@PersistenceContext
	private EntityManager em;

	public void insert(OsRcMed p) {
		em.persist(p);

	}

	public void update(OsRcMed p) {
		em.merge(p);
	}


	public void delete(int id) {
		OsRcMed p = em.find(OsRcMed.class, id);
		em.remove(p);
	}
	
	public OsRcMed read(int id){
		OsRcMed p = em.find(OsRcMed.class, id);
		return p;
	}
	
	public List<OsRcMed> findAll(){
		String jpql = "SELECT o FROM OsRcMed o";
		
		Query q = em.createQuery(jpql, OsRcMed.class);
		
		return q.getResultList();
	}

}
