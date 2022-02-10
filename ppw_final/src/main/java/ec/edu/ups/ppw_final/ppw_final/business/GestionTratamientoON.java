package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorTratamiento;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsTratamiento;


@Stateless
public class GestionTratamientoON {

	@Inject
	private ControladorTratamiento controladorT;

	public void guardarRCMed(OsTratamiento tratamineto) {
		OsTratamiento u = controladorT.read(tratamineto.getTrNombre());
		if (u == null) {
			controladorT.insert(tratamineto);
		} else {
			controladorT.update(tratamineto);
		}
	}

	public void delete(String nombre ) {
		controladorT.delete(nombre);
	}

	public OsTratamiento read(String nombre) {
		return controladorT.read(nombre);
	}

	public List<OsTratamiento> findAll() {
		return controladorT.findAll();
	}
}
