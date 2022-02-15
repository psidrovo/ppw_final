package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;


@Stateless
public class GestionDentaduraON {

	/**
	 * se inicializa el controlador dentaduras para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorDentadura controladorD;

	/**
	 * este metodo recibe un objeto de tipo dentadura y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param dentadura.
	 */
	public void guardarDentadura(OsDentadura dentadura) {
		OsDentadura u = controladorD.read(dentadura.getDentId());
		if (u == null) {
			controladorD.insert(dentadura);
			System.out.println("dentadura creado con exito");
		} else {
			controladorD.update(dentadura);
			System.out.println("dentadura actualizado con exito");
		}
	}

	/**
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public void delete(int id) {
		controladorD.delete(id);
	}

	/**
	 * Este metodo busca un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 * @return OsDentadura
	 */
	public OsDentadura read(int id) {
		return controladorD.read(id);
	}

	/**
	 * Este metodo devuele todo el listado de citas dentro de la base de datos.
	 * @return List<OsDentadura>
	 */
	public List<OsDentadura> findAll() {
		return controladorD.findAll();
	}
}
