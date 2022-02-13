package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorCitas;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;


@Stateless
public class GestionCitasON {

	@Inject
	private ControladorCitas controladorC;
	
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
	
	
	public void delete(int id) {
		controladorC.delete(id);
	}
	
	public OsCita read(int id) {
		return controladorC.read(id);
	}
	
	public List<OsCita> findAll(){
		return controladorC.findAll();
	}
}
