package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorDetDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetDentadura;


@Stateless
public class GestionDetDentaduraON {

	@Inject
	private ControladorDetDentadura controladorDetD;

	public void guardarDetDentadura(OsDetDentadura dentadura) {
		OsDetDentadura u = controladorDetD.read(dentadura.getDetDentId());
		if (u == null) {
			controladorDetD.insert(dentadura);
		} else {
			controladorDetD.update(dentadura);
		}
	}

	public void delete(int id) {
		controladorDetD.delete(id);
	}

	public OsDetDentadura read(int id) {
		return controladorDetD.read(id);
	}

	public List<OsDetDentadura> findAll() {
		return controladorDetD.findAll();
	}
}
