package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;


@Stateless
public class GestionHstClinicaON {

	@Inject
	private ControladorHstClinica controladorHstC;

	public void guardarHstClinico(OsHstClinica historial) {
		OsHstClinica u = controladorHstC.read(historial.getHstClId());
		if (u == null) {
			controladorHstC.insert(historial);
		} else {
			controladorHstC.update(historial);
		}
	}

	public void delete(int id) {
		controladorHstC.delete(id);
	}

	public OsHstClinica read(int id) {
		return controladorHstC.read(id);
	}

	public List<OsHstClinica> findAll() {
		return controladorHstC.findAll();
	}
}