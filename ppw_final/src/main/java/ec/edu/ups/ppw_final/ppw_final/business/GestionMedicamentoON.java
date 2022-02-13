package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorMedicamento;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsMedicamento;

@Stateless
public class GestionMedicamentoON {

	@Inject
	private ControladorMedicamento controladorMediacmiento;

	public void guardarMedicamento(OsMedicamento medicamento) {
		OsMedicamento u = controladorMediacmiento.read(medicamento.getMdNombre());
		if (u == null) {
			controladorMediacmiento.insert(medicamento);
			System.out.println("medicamineto creado con exito");
		} else {
			controladorMediacmiento.update(medicamento);
			System.out.println("medicamineto actualizado con exito");
		}
	}

	public void delete(String nombre ) {
		controladorMediacmiento.delete(nombre);
	}

	public OsMedicamento read(String nombre) {
		return controladorMediacmiento.read(nombre);
	}

	public List<OsMedicamento> findAll() {
		return controladorMediacmiento.findAll();
	}
}
