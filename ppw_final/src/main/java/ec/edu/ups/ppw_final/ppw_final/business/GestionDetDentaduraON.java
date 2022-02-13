package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorDetDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;


@Stateless
public class GestionDetDentaduraON {

	@Inject
	private ControladorDetDentadura controladorDetD;

	public void guardarDetDentadura(OsDetalleDen dentadura) {
		OsDetalleDen u = controladorDetD.read(dentadura.getId());
		if (u == null) {
			controladorDetD.insert(dentadura);
		} else {
			controladorDetD.update(dentadura);
		}
	}

	public void delete(int id) {
		controladorDetD.delete(id);
	}

	public OsDetalleDen read(int id) {
		return controladorDetD.read(id);
	}

	public List<OsDetalleDen> findAll() {
		return controladorDetD.findAll();
	}
}
