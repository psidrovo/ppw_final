package ec.edu.ups.ppw_final.ppw_final.service;

import javax.inject.Inject;
import javax.ws.rs.Path;

import ec.edu.ups.ppw_final.ppw_final.business.GestionCitasON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetPagoON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionHstClinicaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionUsuarioON;

@Path("servicios")
public class serviciosRest {

	@Inject
	private GestionDetDentaduraON detDentaduraOn;
	private GestionHstClinicaON hstClinicaOn;
	private GestionPersonaON personaOn;
	private GestionCitasON citasOn;
	private GestionDentaduraON dentaduraOn;
	private GestionDetPagoON detPagoOn;
	private GestionUsuarioON usuarioOn;
	
	
}
