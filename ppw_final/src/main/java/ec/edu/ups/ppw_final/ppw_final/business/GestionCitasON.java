package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorCitas;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;


@Stateless
public class GestionCitasON {

	/**
	 * se inicializa el controlador Citas para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorCitas controladorC;
	
	/**
	 * este metodo recibe un objeto de tipo cita y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param cita.
	 */
	public void guardarCita(OsCita cita) {
		OsCita u = controladorC.read(cita.getCtId());
		if(u==null) {
			controladorC.insert(cita);
			System.out.println("cita guardado con exito");
		}else {
			controladorC.update(cita);
			System.out.println("cita actualizado con exito");
		}
	}
	
	/**
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public void delete(int id) {
		controladorC.delete(id);
	}
	
	/**
	 * Este metodo busca un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 * @return OsCita
	 */
	public OsCita read(int id) {
		return controladorC.read(id);
	}
	
	/**
	 * Este metodo devuele todo el listado de citas dentro de la base de datos.
	 * @return List<OsCita>
	 */
	public List<OsCita> findAll(){
		return controladorC.findAll();
	}
}
