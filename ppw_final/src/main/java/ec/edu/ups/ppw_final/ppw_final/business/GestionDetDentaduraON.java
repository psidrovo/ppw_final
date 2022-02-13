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
			System.out.println("detalle de dentadura creado exitosamente");
		} else {
			controladorDetD.update(dentadura);
			System.out.println("detalle de dentadura actualizado exitosamente");
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
