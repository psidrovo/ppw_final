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

	/*
	 * se inicializa el controlador historial clinica para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorHstClinica controladorHstC;

	/*
	 * este metodo recibe un objeto de tipo historial clinica y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param cita.
	 */
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

	/*
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public void delete(int id) {
		controladorHstC.delete(id);
	}

	/*
	 * Este metodo busca un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public OsHstClinica read(int id) {
		return controladorHstC.read(id);
	}

	/*
	 * Este metodo devuele todo el listado de historiales clinicas dentro de la base de datos.
	 */
	public List<OsHstClinica> findAll() {
		return controladorHstC.findAll();
	}
	
	/*
	 * Este metodo retorna una objeto de tipo historial clinica medante la cedula de la persona
	 * @param cedula.
	 */
	public List<OsHstClinica> findListaPorCedula(String cedula) {
		return controladorHstC.findAll().stream().filter(p->p.getOsPersona().getPerCedula().equals(cedula)).collect(Collectors.toList());
	}
}
