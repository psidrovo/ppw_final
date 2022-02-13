package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;


@Stateless
public class GestionDentaduraON {

	@Inject
	private ControladorDentadura controladorD;

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

	public void delete(int id) {
		controladorD.delete(id);
	}

	public OsDentadura read(int id) {
		return controladorD.read(id);
	}

	public List<OsDentadura> findAll() {
		return controladorD.findAll();
	}
}
