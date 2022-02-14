package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;


@Stateless
public class GestionHstClinicaON {

	@Inject
	private ControladorHstClinica controladorHstC;

	public void guardarHstClinico(OsHstClinica historial) {
		OsHstClinica u = controladorHstC.read(historial.getHstClId());
		if (u == null) {
			controladorHstC.insert(historial);
			System.out.println("historial clinico creado con exito");
		} else {
			controladorHstC.update(historial);
			System.out.println("historial clinico actualizado con exito");
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
	
	public List<OsHstClinica> findListaPorCedula(String cedula) {
		return controladorHstC.findAll().stream().filter(p->p.getOsPersona().getPerCedula().equals(cedula)).collect(Collectors.toList());
	}
}
