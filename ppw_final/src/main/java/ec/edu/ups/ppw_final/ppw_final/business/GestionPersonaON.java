package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Stateless
public class GestionPersonaON {

	/*
	 * se inicializa el controlador persona para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorPersona controladorP;
	
	/*
	 * este metodo recibe un objeto de tipo persona y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param persona.
	 */
	public void guardarPersona(OsPersona persona) {
		if(controladorP.read(persona.getPerCedula())==null) {
			controladorP.insert(persona);
			System.out.println("persona creado con exito" );
		}else {
			controladorP.update(persona);
			System.out.println("persona actualizada con exito");
		}
	}
	
	/*
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param cedula
	 */
	public void delete(String cedula) {
		controladorP.delete(cedula);
	}
	
	/*
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param cedula
	 */
	public OsPersona read(String cedula) {
		return controladorP.read(cedula);
	}
	
	/*
	 * Este metodo devuele todo el listado de personas dentro de la base de datos.
	 */
	public List<OsPersona> findAll(){
		return controladorP.findAll();
	}
	
	
}
