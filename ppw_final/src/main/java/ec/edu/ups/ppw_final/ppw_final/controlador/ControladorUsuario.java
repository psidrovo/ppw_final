package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

@Stateless
public class ControladorUsuario {

	@PersistenceContext
	private EntityManager em;

	public void insert(OsUsuario p) {
		em.persist(p);

	}

	public void update(OsUsuario p) {
		em.merge(p);
	}

	public List<OsUsuario> Validar(String usuario, String contrasenia) {
		String jpql = "SELECT p FROM OsUsuario p WHERE usCorreo LIKE ?1 AND usPassword LIKE ?2";

		Query q = em.createQuery(jpql, OsUsuario.class);
		q.setParameter(1,usuario).setParameter(2, contrasenia);
		return q.getResultList();
	}

	public void delete(String usuario) {
		OsUsuario p = em.find(OsUsuario.class, usuario);
		em.remove(p);
	}
	
	public OsUsuario read(String usuario){
		OsUsuario p = em.find(OsUsuario.class, usuario);
		return p;
	}
}
