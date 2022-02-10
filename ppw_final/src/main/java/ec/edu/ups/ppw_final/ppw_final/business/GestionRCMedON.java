package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorRcMed;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsRcMed;


@Stateless
public class GestionRCMedON {

	@Inject
	private ControladorRcMed controladorRCMed;

	public void guardarRCMed(OsRcMed medicamento) {
		OsRcMed u = controladorRCMed.read(medicamento.getRcMedId());
		if (u == null) {
			controladorRCMed.insert(medicamento);
		} else {
			controladorRCMed.update(medicamento);
		}
	}

	public void delete(int id ) {
		controladorRCMed.delete(id);
	}

	public OsRcMed read(int id) {
		return controladorRCMed.read(id);
	}

	public List<OsRcMed> findAll() {
		return controladorRCMed.findAll();
	}
}
