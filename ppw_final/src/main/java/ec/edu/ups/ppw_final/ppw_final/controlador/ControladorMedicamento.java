package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsMedicamento;

@Stateless
public class ControladorMedicamento {

	/*
	@Override
	public List<OsMedicamento> findAll() {
		Query consulta = getEm().createNamedQuery("OsMedicamento.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsMedicamento o1, OsMedicamento o2) -> o1.getMdNombre().compareTo(o2.getMdNombre()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		return 0;
	}*/
	
	@PersistenceContext
	private EntityManager em;

	public void insert(OsMedicamento p) {
		em.persist(p);

	}

	public void update(OsMedicamento p) {
		em.merge(p);
	}


	public void delete(String nombre ) {
		OsMedicamento p = em.find(OsMedicamento.class, nombre);
		em.remove(p);
	}
	
	public OsMedicamento read(String nombre ){
		OsMedicamento p = em.find(OsMedicamento.class, nombre);
		return p;
	}
	
	public List<OsMedicamento> findAll(){
		String jpql = "SELECT o FROM OsMedicamento o";
		
		Query q = em.createQuery(jpql, OsMedicamento.class);
		
		return q.getResultList();
	}

}
