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
	@Inject
	private GestionHstClinicaON hstClinicaOn;
	@Inject
	private GestionPersonaON personaOn;
	@Inject
	private GestionCitasON citasOn;
	@Inject
	private GestionDentaduraON dentaduraOn;
	@Inject
	private GestionDetPagoON detPagoOn;
	@Inject
	private GestionUsuarioON usuarioOn;
	
	//servicios detalle dentadura
	
	//servicios historial clinico
	
	//servicios personas
	
	//servicios citas
	
	//servicios dentaduras
	
	//servicios detalle de pago
	
	//servicios usuarios
}
