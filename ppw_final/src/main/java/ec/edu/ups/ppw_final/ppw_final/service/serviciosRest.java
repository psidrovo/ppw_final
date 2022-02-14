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

	/*
	 * Se ha inicializado todos los gestores que existen para realizar acciones CRUD dentro de la base de datos.
	 */
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
	
	/*
	 * este metodo publicar o realizara la accion de guardar un objeto
	 * de tipo detalle dentadura.
	 * @param detDentadura. 
	 */
	@POST
	@Path("guardarDetalleDen")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarDetDentadura(OsDetalleDen detDentadura) {
		detDentaduraOn.guardarDetDentadura(detDentadura);
	}
	
	/*
	 * Este metodo realizara la accion de buscar un objeto detalle dentadura mediante la llave primaria
	 * @param id.
	 */
	@POST
	@Path("readDetalleDen")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDetalleDen readDetDentadura(@QueryParam("id") int id) {
		OsDetalleDen dd= detDentaduraOn.read(id);
		return dd;
	}
	
	/*
	 * Este metodo realiazara el metodo de eliminar un objeto de tipo detalle dentadura mediante la busqueda de la llaver
	 * primaria
	 * @param id
	 */
	@POST
	@Path("deleteDetalleDen")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteDetDentadura(@QueryParam("id") int id) {
		detDentaduraOn.delete(id);
	}
	
	/*
	 * Este metodo realizara la accion de retornar todo un listado de los detalles dentaduras que existan
	 * dentro de la base de datos.
	 */
	@GET
	@Path("findAllDetalleDen")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDetalleDen> findAllDetalleDen(){
		List<OsDetalleDen> detalles = detDentaduraOn.findAll();
		return detalles;
	}
	
	
//-----------------------------------------------------------------------------------	
	
	//servicios historial clinico
	/*
	 * este metodo publicar o realizara la accion de guardar un objeto
	 * de tipo historial clincio .
	 * @param clinica. 
	 */
	@POST
	@Path("guardarHistorialClinico")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarHistorialClinico(OsHstClinica clinica) {
		hstClinicaOn.guardarHstClinico(clinica);
	}
	
	/*
	 * Este metodo realizara la accion de buscar un objeto historial clinica  mediante la llave primaria
	 * @param id.
	 */
	@POST
	@Path("readHistorialClinico")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsHstClinica readHistorialClinico(@QueryParam("id") int id) {
		OsHstClinica h= hstClinicaOn.read(id);
		return h;
	}
	
	/*
	 * Este metodo realiazara el metodo de eliminar un objeto de tipo historial clinica mediante la busqueda de la llave
	 * primaria
	 * @param id
	 */
	@POST
	@Path("deleteHistorialClinico")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteHistorialClinico(@QueryParam("id") int id) {
		hstClinicaOn.delete(id);
	}
	
	/*
	 * Este metodo realizara la accion de retornar todo un listado de los historiales clinicos  que existan
	 * dentro de la base de datos.
	 */
	@GET
	@Path("findAllHistorialClinico")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsHstClinica> findAllHistorialClinico(){
		List<OsHstClinica> historiales = hstClinicaOn.findAll();
		return historiales;
	}
	
//-----------------------------------------------------------------------------------		
	//servicios personas
	/*
	 * este metodo publicar o realizara la accion de guardar un objeto
	 * de tipo persona.
	 * @param persona. 
	 */
	@POST
	@Path("guardarPersona")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarPersona(OsPersona persona) {
		personaOn.guardarPersona(persona);
	}
	
	/*
	 * Este metodo realizara la accion de buscar un objeto persona  mediante la llave primaria
	 * @param cedula.
	 */
	@POST
	@Path("readPersona")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsPersona readPersona(@QueryParam("cedula") String cedula) {
		OsPersona p= personaOn.read(cedula);
		return p;
	}
	
	/*
	 * Este metodo realiazara el metodo de eliminar un objeto de tipo persona mediante la busqueda de la llave
	 * primaria
	 * @param cedula
	 */
	@POST
	@Path("deletePersona")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deletePersona(@QueryParam("cedula") String cedula) {
		personaOn.delete(cedula);
	}
	
	/*
	 * Este metodo realizara la accion de retornar todo un listado de las personas que existan
	 * dentro de la base de datos.
	 */
	@GET
	@Path("findAllPersona")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsPersona> findAllPersona(){
		List<OsPersona> personas = personaOn.findAll();
		return personas;
	}
	
//-----------------------------------------------------------------------------------	
	
	//servicios citas
	/*
	 * este metodo publicar o realizara la accion de guardar un objeto
	 * de tipo cita.
	 * @param cita. 
	 */
	@POST
	@Path("guardarCita")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarCita(OsCita cita) {
		citasOn.guardarCita(cita);
	}
	
	/*
	 * Este metodo realizara la accion de buscar un objeto cita  mediante la llave primaria
	 * @param id.
	 */
	@POST
	@Path("readCita")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsCita readCita(@QueryParam("id") int id) {
		OsCita c= citasOn.read(id);
		return c;
	}
	
	/*
	 * Este metodo realiazara el metodo de eliminar un objeto de tipo cita mediante la busqueda de la llave
	 * primaria
	 * @param id
	 */
	@POST
	@Path("deleteCita")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteCita(@QueryParam("id") int id) {
		citasOn.delete(id);
	}
	
	/*
	 * Este metodo realizara la accion de retornar todo un listado de las citas que existan
	 * dentro de la base de datos.
	 */
	@GET
	@Path("findAllCita")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsCita> findAllCita(){
		List<OsCita> citas = citasOn.findAll();
		return citas;
	}
//-----------------------------------------------------------------------------------
	
	//servicios dentaduras
	/*
	 * este metodo publicar o realizara la accion de guardar un objeto
	 * de tipo dentadura.
	 * @param dentadura. 
	 */
	@POST
	@Path("guardarDentadura")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarDentadura(OsDentadura dentadura) {
		dentaduraOn.guardarDentadura(dentadura);
	}
	
	/*
	 * Este metodo realizara la accion de buscar un objeto dentadura  mediante la llave primaria
	 * @param id.
	 */
	@POST
	@Path("readDentadura")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDentadura readDentadura(@QueryParam("id") int id) {
		OsDentadura d= dentaduraOn.read(id);
		return d;
	}
	
	/*
	 * Este metodo realiazara el metodo de eliminar un objeto de dentadura mediante la busqueda de la llave
	 * primaria
	 * @param id
	 */
	@POST
	@Path("deleteDentadura")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteDentadura(@QueryParam("id") int id) {
		dentaduraOn.delete(id);
	}
	
	/*
	 * Este metodo realizara la accion de retornar todo un listado de las dentaduras que existan
	 * dentro de la base de datos.
	 */
	@GET
	@Path("findAllDentadura")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDentadura> findAllDentadura(){
		List<OsDentadura> dentaduras = dentaduraOn.findAll();
		return dentaduras;
	}
	
//-----------------------------------------------------------------------------------
	//servicios detalle de pago
	/*
	 * este metodo publicar o realizara la accion de guardar un objeto
	 * de tipo detalle pago.
	 * @param pago. 
	 */
	@POST
	@Path("guardarDetallePago")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarDetallePago(OsDetPago pago) {
		detPagoOn.guardarDetPago(pago);
	}
	
	/*
	 * Este metodo realizara la accion de buscar un objeto detalle pago  mediante la llave primaria
	 * @param id.
	 */
	@POST
	@Path("readDetallePago")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDetPago readDetallePago(@QueryParam("id") int id) {
		OsDetPago p= detPagoOn.read(id);
		return p;
	}
	
	/*
	 * Este metodo realiazara el metodo de eliminar un objeto de detalle pago mediante la busqueda de la llave
	 * primaria
	 * @param id
	 */
	@POST
	@Path("deleteDetallePago")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteDetallePago(@QueryParam("id") int id) {
		detPagoOn.delete(id);
	}
	
	/*
	 * Este metodo realizara la accion de retornar todo un listado de los detalles pagos que existan
	 * dentro de la base de datos.
	 */
	@GET
	@Path("findAllDetallePago")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDetPago> findAllDetallePago(){
		List<OsDetPago> pagos = detPagoOn.findAll();
		return pagos;
	}
	
//-----------------------------------------------------------------------------------
	//servicios usuarios
	/*
	 * este metodo publicara o realizara la accion de guardar un objeto
	 * de tipo usuario.
	 * @param usuario. 
	 */
	@POST
	@Path("guardarUsuarios")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void guardarUsuarios(OsUsuario usuario) {
		usuarioOn.guardarUsuario(usuario);
	}
	
	/*
	 * Este metodo realizara la accion de buscar un objeto usuario mediante la llave primaria
	 * @param correo.
	 */
	@POST
	@Path("readUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsUsuario readUsuarios(@QueryParam("correo") String correo) {
		OsUsuario u= usuarioOn.read(correo);
		return u;
	}
	
	/*
	 * Este metodo realiazara el metodo de eliminar un objeto de usuario mediante la busqueda de la llave
	 * primaria
	 * @param correo
	 */
	@POST
	@Path("deleteUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteUsuarios(@QueryParam("correo") String correo) {
		usuarioOn.delete(correo);
	}
	
	/*
	 * Este metodo realizara la accion de retornar todo un listado de los usuarios que existan
	 * dentro de la base de datos.
	 */
	@GET
	@Path("findAllUsuarios")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsUsuario> findAllUsuarios(){
		List<OsUsuario> usuarios = usuarioOn.findAll();
		return usuarios;
	}
	
	/*
	 * Este metodo se utilizara para validar si es que el usuario existe o no. Este metodo
	 * recibe dos objetos en su parametro de tipo String. si es que existe regresara el usuario caso contrario 
	 * retornara null.
	 * @param correo
	 * @param contrasenia
	 */
	@POST
	@Path("validarUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsUsuario validarUsuarios(@QueryParam("correo") String correo,@QueryParam("contrasenia") String contrasenia) {
		OsUsuario u= usuarioOn.validar(correo, contrasenia);
		return u;
	}
	
	
	
}
