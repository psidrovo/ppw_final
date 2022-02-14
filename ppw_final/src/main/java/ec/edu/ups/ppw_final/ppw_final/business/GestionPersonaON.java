package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

@Stateless
public class GestionPersonaON {

	@Inject
	private ControladorPersona controladorP;
	
	public void guardarPersona(OsPersona persona) {
		if(controladorP.read(persona.getPerCedula())==null) {
			controladorP.insert(persona);
			System.out.println("persona creado con exito" );
		}else {
			controladorP.update(persona);
			System.out.println("persona actualizada con exito");
		}
	}
	
	
	public void delete(String cedula) {
		controladorP.delete(cedula);
	}
	
	public OsPersona read(String cedula) {
		return controladorP.read(cedula);
	}
	
	public List<OsPersona> findAll(){
		return controladorP.findAll();
	}
	
	
}
