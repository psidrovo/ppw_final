package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorDetDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;


@Stateless
public class GestionDetDentaduraON {

	/*
	 * se inicializa el controlador detalle dentadura para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorDetDentadura controladorDetD;

	/*
	 * este metodo recibe un objeto de tipo detalle dentadura y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param dentadura.
	 */
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

	/*
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public void delete(int id) {
		controladorDetD.delete(id);
	}

	/*
	 * Este metodo busca un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public OsDetalleDen read(int id) {
		return controladorDetD.read(id);
	}

	/*
	 * Este metodo devuele todo el listado de detalles dentaduras dentro de la base de datos.
	 */
	public List<OsDetalleDen> findAll() {
		return controladorDetD.findAll();
	}
	
	public OsDetalleDen recuperarUltimoDetalle() {
		return controladorDetD.recuperarUltimoDetalle();
	}
	
	public List<OsDetalleDen> encontrarDetalleDentadura(String cedulaPaciente, String dentadura) {
		return controladorDetD.encontrarDetalleDentadura(cedulaPaciente,dentadura);
	}
}
