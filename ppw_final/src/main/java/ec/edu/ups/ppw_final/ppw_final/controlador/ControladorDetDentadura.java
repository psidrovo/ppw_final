package ec.edu.ups.ppw_final.ppw_final.controlador;

//import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

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

	public void insert(OsDetalleDen p) {
		em.persist(p);
	
	}

	public void update(OsDetalleDen p) {
		em.merge(p);
	}


	public void delete(int id) {
		OsDetalleDen p = em.find(OsDetalleDen.class, id);
		em.remove(p);
	}
	
	public OsDetalleDen read(int id){
		OsDetalleDen p = em.find(OsDetalleDen.class, id);
		return p;
	}
	
	public List<OsDetalleDen> findAll(){
		String jpql = "SELECT o FROM OsDetalleDen o";		
		Query q = em.createQuery(jpql, OsDetalleDen.class);		
		return q.getResultList();
	}
	
	public List<OsDetalleDen> findbyDentadura(int codigo) {
		String jpql = "select * from os_cita where os_persona_per_cedula like ?1";
		Query q = em.createQuery(jpql, OsPersona.class);
		q.setParameter(1, codigo);		
		return q.getResultList();
	}
	
	public OsDetalleDen recuperarUltimoDetalle(){
		String jpql = "SELECT o FROM OsDetalleDen o order by id desc";		
		Query q = em.createQuery(jpql, OsDetalleDen.class);		
		return (OsDetalleDen) q.getResultList().get(0);
	}

}
