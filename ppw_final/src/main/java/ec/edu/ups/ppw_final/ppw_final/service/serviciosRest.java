package ec.edu.ups.ppw_final.ppw_final.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.ppw_final.ppw_final.business.GestionCitasON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetPagoON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionHstClinicaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionUsuarioON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

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
	
	/*private OsDetalleDen detalleDen;
	private OsHstClinica hstClinica;
	private OsPersona persona;
	private OsCita cita;
	private OsDentadura dentadura;
	private OsDetPago detPago;
	private OsUsuario usuario;*/
	
//---------------------------------------------------------------------------	
	//servicios detalle dentadura
	@POST
	@Path("guardarDetalleDen")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarDetDentadura(OsDetalleDen detDentadura) {
		detDentaduraOn.guardarDetDentadura(detDentadura);
	}
	
	@POST
	@Path("readDetalleDen")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDetalleDen readDetDentadura(@QueryParam("id") int id) {
		OsDetalleDen dd= detDentaduraOn.read(id);
		return dd;
	}
	
	@POST
	@Path("deleteDetalleDen")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteDetDentadura(@QueryParam("id") int id) {
		detDentaduraOn.delete(id);
	}
	
	@GET
	@Path("findAllDetalleDen")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDetalleDen> findAllDetalleDen(){
		List<OsDetalleDen> detalles = detDentaduraOn.findAll();
		return detalles;
	}
	
	
//-----------------------------------------------------------------------------------	
	
	//servicios historial clinico
	@POST
	@Path("guardarHistorialClinico")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarHistorialClinico(OsHstClinica clinica) {
		hstClinicaOn.guardarHstClinico(clinica);
	}
	
	@POST
	@Path("readHistorialClinico")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsHstClinica readHistorialClinico(@QueryParam("id") int id) {
		OsHstClinica h= hstClinicaOn.read(id);
		return h;
	}
	
	@POST
	@Path("deleteHistorialClinico")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteHistorialClinico(@QueryParam("id") int id) {
		hstClinicaOn.delete(id);
	}
	
	@GET
	@Path("findAllHistorialClinico")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsHstClinica> findAllHistorialClinico(){
		List<OsHstClinica> historiales = hstClinicaOn.findAll();
		return historiales;
	}
	
//-----------------------------------------------------------------------------------		
	//servicios personas
	@POST
	@Path("guardarPersona")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarPersona(OsPersona persona) {
		personaOn.guardarPersona(persona);
	}
	
	@POST
	@Path("readPersona")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsPersona readPersona(@QueryParam("cedula") String cedula) {
		OsPersona p= personaOn.read(cedula);
		return p;
	}
	
	@POST
	@Path("deletePersona")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deletePersona(@QueryParam("cedula") String cedula) {
		personaOn.delete(cedula);
	}
	
	@GET
	@Path("findAllPersona")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsPersona> findAllPersona(){
		List<OsPersona> personas = personaOn.findAll();
		return personas;
	}
	
//-----------------------------------------------------------------------------------	
	
	//servicios citas
	@POST
	@Path("guardarCita")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarCita(OsCita cita) {
		citasOn.guardarCita(cita);
	}
	
	@POST
	@Path("readCita")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsCita readCita(@QueryParam("id") int id) {
		OsCita c= citasOn.read(id);
		return c;
	}
	
	@POST
	@Path("deleteCita")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteCita(@QueryParam("id") int id) {
		citasOn.delete(id);
	}
	
	@GET
	@Path("findAllCita")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsCita> findAllCita(){
		List<OsCita> citas = citasOn.findAll();
		return citas;
	}
//-----------------------------------------------------------------------------------
	
	//servicios dentaduras
	@POST
	@Path("guardarDentadura")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarDentadura(OsDentadura dentadura) {
		dentaduraOn.guardarDentadura(dentadura);
	}
	
	@POST
	@Path("readDentadura")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDentadura readDentadura(@QueryParam("id") int id) {
		OsDentadura d= dentaduraOn.read(id);
		return d;
	}
	
	@POST
	@Path("deleteDentadura")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteDentadura(@QueryParam("id") int id) {
		dentaduraOn.delete(id);
	}
	
	@GET
	@Path("findAllDentadura")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDentadura> findAllDentadura(){
		List<OsDentadura> dentaduras = dentaduraOn.findAll();
		return dentaduras;
	}
	
//-----------------------------------------------------------------------------------
	//servicios detalle de pago
	@POST
	@Path("guardarDetallePago")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarDetallePago(OsDetPago pago) {
		detPagoOn.guardarDetPago(pago);
	}
	
	@POST
	@Path("readDetallePago")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDetPago readDetallePago(@QueryParam("id") int id) {
		OsDetPago p= detPagoOn.read(id);
		return p;
	}
	
	@POST
	@Path("deleteDetallePago")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteDetallePago(@QueryParam("id") int id) {
		detPagoOn.delete(id);
	}
	
	@GET
	@Path("findAllDetallePago")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDetPago> findAllDetallePago(){
		List<OsDetPago> pagos = detPagoOn.findAll();
		return pagos;
	}
	
//-----------------------------------------------------------------------------------
	//servicios usuarios
	@POST
	@Path("guardarUsuarios")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarUsuarios(OsUsuario usuario) {
		usuarioOn.guardarUsuario(usuario);
	}
	
	@POST
	@Path("readUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsUsuario readUsuarios(@QueryParam("correo") String correo) {
		OsUsuario u= usuarioOn.read(correo);
		return u;
	}
	
	@POST
	@Path("deleteUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteUsuarios(@QueryParam("correo") String correo) {
		usuarioOn.delete(correo);
	}
	
	@GET
	@Path("findAllUsuarios")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsUsuario> findAllUsuarios(){
		List<OsUsuario> usuarios = usuarioOn.findAll();
		return usuarios;
	}
	
	@POST
	@Path("validarUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsUsuario validarUsuarios(@QueryParam("correo") String correo,@QueryParam("contrasenia") String contrasenia) {
		OsUsuario u= usuarioOn.validar(correo, contrasenia);
		return u;
	}
	
	
	
}
