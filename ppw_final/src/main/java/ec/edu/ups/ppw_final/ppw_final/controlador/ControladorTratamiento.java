package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsRcMed;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsTratamiento;

@Stateless
public class ControladorTratamiento {

	/*@Override
	public List<OsTratamiento> findAll() {
		Query consulta = getEm().createNamedQuery("OsTratamiento.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsTratamiento o1, OsTratamiento o2) -> o1.getTrNombre().compareTo(o2.getTrNombre()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	@PersistenceContext
	private EntityManager em;

	public void insert(OsTratamiento p) {
		em.persist(p);

	}

	public void update(OsTratamiento p) {
		em.merge(p);
	}


	public void delete(int id) {
		OsTratamiento p = em.find(OsTratamiento.class, id);
		em.remove(p);
	}
	
	public OsTratamiento read(int id){
		OsTratamiento p = em.find(OsTratamiento.class, id);
		return p;
	}
	
	public List<OsTratamiento> findAll(){
		String jpql = "SELECT o FROM OsTratamiento o";
		
		Query q = em.createQuery(jpql, OsTratamiento.class);
		
		return q.getResultList();
	}

}
