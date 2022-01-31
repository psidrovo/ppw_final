package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public abstract class ControladorGenerico <T> {

	@PersistenceContext
    private EntityManager em;
    private Class<T> clase;

    /*
    public ControladorGenerico() {
        this.em = JPAUtils.getEntityManager();

        java.lang.reflect.Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;

        clase = (Class) pt.getActualTypeArguments()[0];
    }*/

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public boolean create(T objeto) {
        try {

            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public T read(int id) {
        return em.find(clase, id);
    }

    public boolean update(T objeto) {
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        return true;

    }

    public boolean delete(T objeto) {
        em.getTransaction().begin();
        if (!em.contains(objeto)) {
            objeto = em.merge(objeto);
        }

        em.remove(objeto);
        em.getTransaction().commit();
        return true;
    }

    public abstract List<T> findAll();

    /**
     * Metodo para devolver el último codigo en la bbdd
     * @return 
     */
    public abstract int codigo();
}
