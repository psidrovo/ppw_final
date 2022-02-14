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
	
	@PersistenceContext
	private EntityManager em;

	public void insert(OsHstClinica p) {
		em.persist(p);

	}

	public void update(OsHstClinica p) {
		em.merge(p);
	}


	public void delete(int id) {
		OsHstClinica p = em.find(OsHstClinica.class, id);
		em.remove(p);
	}
	
	public OsHstClinica read(int id){
		OsHstClinica p = em.find(OsHstClinica.class, id);
		return p;
	}
	
	public List<OsHstClinica> findAll(){
		String jpql = "SELECT o FROM OsHstClinica o";
		
		Query q = em.createQuery(jpql, OsHstClinica.class);
		
		return q.getResultList();
	}
}
