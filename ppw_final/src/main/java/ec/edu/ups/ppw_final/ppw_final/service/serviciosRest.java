package ec.edu.ups.ppw_final.ppw_final.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

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

	/**
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
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de buscar un objeto detalle dentadura mediante la llave primaria
	 * @param id.
	 */
	@POST
	@Path("readDetalleDen")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDetalleDen readDetDentadura(@QueryParam("id") int id) {
		OsDetalleDen dd= detDentaduraOn.read(id);
		OsDetalleDen dNuevo = new OsDetalleDen(dd.getId(), dd.getCuadrante());
		return dNuevo;
	}
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de retornar todo un listado de los detalles dentaduras que existan
	 * dentro de la base de datos.
	 * @return List<OsdetalleDen>
	 */
	@GET
	@Path("findAllDetalleDen")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDetalleDen> findAllDetalleDen(){
		List<OsDetalleDen> detalles = detDentaduraOn.findAll();
		List<OsDetalleDen> detallesnuevos = new ArrayList<>();
		for (OsDetalleDen osDetalleDen : detalles) {
			OsDetalleDen d = new OsDetalleDen(osDetalleDen.getId(), osDetalleDen.getCuadrante());
			detallesnuevos.add(d);
		}
		return detallesnuevos;
	}
	
	
//-----------------------------------------------------------------------------------	
	
	//servicios historial clinico
	/**
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
	
	/**
	 * Este metodo realizara la accion de buscar un objeto historial clinica  mediante la llave primaria
	 * @param id.
	 * @return OsHstClinica
	 */
	@POST
	@Path("readHistorialClinico")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsHstClinica readHistorialClinico(@QueryParam("id") int id) {
		OsHstClinica h= hstClinicaOn.read(id);
		OsHstClinica dNuevo = new OsHstClinica(h.getHstClId(),h.getHstClDetalle(),h.getHstClFase(),h.getHstClFecha(),h.getHstCosto(),
				h.getHstReceta(),h.getHstTratamiento());
		return dNuevo;
	}
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de retornar todo un listado de los historiales clinicos  que existan
	 * dentro de la base de datos.
	 * @return List<OsHstClinica>
	 */
	@GET
	@Path("findAllHistorialClinico")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsHstClinica> findAllHistorialClinico(){
		List<OsHstClinica> historiales = hstClinicaOn.findAll();
		List<OsHstClinica> detallesnuevos = new ArrayList<>();
		for (OsHstClinica osDetalleDen : historiales) {
			OsHstClinica dNuevo = new OsHstClinica(osDetalleDen.getHstClId(),osDetalleDen.getHstClDetalle(),osDetalleDen.getHstClFase(),osDetalleDen.getHstClFecha(),osDetalleDen.getHstCosto(),
					osDetalleDen.getHstReceta(),osDetalleDen.getHstTratamiento());
			detallesnuevos.add(dNuevo);
		}
		return detallesnuevos;
	}
	
//-----------------------------------------------------------------------------------		
	//servicios personas
	/**
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
	
	/**
	 * Este metodo realizara la accion de buscar un objeto persona  mediante la llave primaria
	 * @param cedula.
	 * @return OsPersona
	 */
	@POST
	@Path("readPersona")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsPersona readPersona(@QueryParam("cedula") String cedula) {
		OsPersona p= personaOn.read(cedula);
		OsPersona dNuevo = new OsPersona(p.getPerCedula(),p.getPerApellido(),p.getPerDireccion(),p.getPerNombre());
		return dNuevo;
		//return p;
	}
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de retornar todo un listado de las personas que existan
	 * dentro de la base de datos.
	 * @return List<OsPersona>
	 */
	@GET
	@Path("findAllPersona")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsPersona> findAllPersona(){
		List<OsPersona> personas = personaOn.findAll();
		List<OsPersona> detallesnuevos = new ArrayList<>();
		for (OsPersona osDetalleDen : personas) {
			OsPersona dNuevo = new OsPersona(osDetalleDen.getPerCedula(), osDetalleDen.getPerApellido(),
					osDetalleDen.getPerDireccion(),osDetalleDen.getPerNombre());
			detallesnuevos.add(dNuevo);
		}
		return detallesnuevos;
	}
	
//-----------------------------------------------------------------------------------	
	
	//servicios citas
	/**
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
	
	/**
	 * Este metodo realizara la accion de buscar un objeto cita  mediante la llave primaria
	 * @param id.
	 * @return OsCita
	 */
	@POST
	@Path("readCita")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsCita readCita(@QueryParam("id") int id) {
		OsCita c= citasOn.read(id);
		OsCita dNuevo = new OsCita(c.getCtId(), c.getCtDescripcion(), c.getCtEstado(), c.getCtFecha());
		return dNuevo;
		
	}
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de retornar todo un listado de las citas que existan
	 * dentro de la base de datos.
	 * @return List<OsCita>
	 */
	@GET
	@Path("findAllCita")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsCita> findAllCita(){
		List<OsCita> citas = citasOn.findAll();
		List<OsCita> detallesnuevos = new ArrayList<>();
		for (OsCita c : citas) {
			OsCita dNuevo = new OsCita(c.getCtId(), c.getCtDescripcion(), c.getCtEstado(), c.getCtFecha());
			detallesnuevos.add(dNuevo);
		}
		return detallesnuevos;
	}
//-----------------------------------------------------------------------------------
	
	//servicios dentaduras
	/**
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
	
	/**
	 * Este metodo realizara la accion de buscar un objeto dentadura  mediante la llave primaria
	 * @param id.
	 * @return OsDentadura
	 */
	@POST
	@Path("readDentadura")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDentadura readDentadura(@QueryParam("id") int id) {
		OsDentadura d= dentaduraOn.read(id);
		OsDentadura dNuevo = new OsDentadura(d.getDentId(),d.getDentCdgMolar());
		return dNuevo;
	}
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de retornar todo un listado de las dentaduras que existan
	 * dentro de la base de datos.
	 * @return List<OsDentadura>
	 */
	@GET
	@Path("findAllDentadura")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDentadura> findAllDentadura(){
		List<OsDentadura> dentaduras = dentaduraOn.findAll();
		List<OsDentadura> detallesnuevos = new ArrayList<>();
		for (OsDentadura d : dentaduras) {
			OsDentadura dNuevo = new OsDentadura(d.getDentId(),d.getDentCdgMolar());
			detallesnuevos.add(dNuevo);
		}
		return detallesnuevos;
	}
	
//-----------------------------------------------------------------------------------
	//servicios detalle de pago
	/**
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
	
	/**
	 * Este metodo realizara la accion de buscar un objeto detalle pago  mediante la llave primaria
	 * @param id.
	 * @return OsDetPago
	 */
	@POST
	@Path("readDetallePago")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsDetPago readDetallePago(@QueryParam("id") int id) {
		OsDetPago p= detPagoOn.read(id);
		OsDetPago dNuevo = new OsDetPago(p.getDetPgId(), p.getDetPgValor());
		return dNuevo;
	}
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de retornar todo un listado de los detalles pagos que existan
	 * dentro de la base de datos.
	 * @return List<OsDetPago>
	 */
	@GET
	@Path("findAllDetallePago")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsDetPago> findAllDetallePago(){
		List<OsDetPago> pagos = detPagoOn.findAll();
		List<OsDetPago> detallesnuevos = new ArrayList<>();
		for (OsDetPago p : pagos) {
			OsDetPago dNuevo = new OsDetPago(p.getDetPgId(), p.getDetPgValor());
			detallesnuevos.add(dNuevo);
		}
		return detallesnuevos;
	}
	
//-----------------------------------------------------------------------------------
	//servicios usuarios
	/**
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
	
	/**
	 * Este metodo realizara la accion de buscar un objeto usuario mediante la llave primaria
	 * @param correo.
	 * @return OsUsuario
	 */
	@POST
	@Path("readUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsUsuario readUsuarios(@QueryParam("correo") String correo) {
		OsUsuario u= usuarioOn.read(correo);
		OsUsuario dNuevo = new OsUsuario(u.getUsCorreo(),u.getUsPassword(),u.getUsTipo());
		return dNuevo;
	}
	
	/**
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
	
	/**
	 * Este metodo realizara la accion de retornar todo un listado de los usuarios que existan
	 * dentro de la base de datos.
	 * @return List<OsUsuario>
	 */
	@GET
	@Path("findAllUsuarios")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<OsUsuario> findAllUsuarios(){
		List<OsUsuario> usuarios = usuarioOn.findAll();
		List<OsUsuario> detallesnuevos = new ArrayList<>();
		for (OsUsuario u : usuarios) {
			OsUsuario dNuevo = new OsUsuario(u.getUsCorreo(),u.getUsPassword(),u.getUsTipo());
			detallesnuevos.add(dNuevo);
		}
		return detallesnuevos;
	}
	
	/**
	 * Este metodo se utilizara para validar si es que el usuario existe o no. Este metodo
	 * recibe dos objetos en su parametro de tipo String. si es que existe regresara el usuario caso contrario 
	 * retornara null.
	 * @param correo
	 * @param contrasenia
	 * @return OsUsuario
	 */
	@POST
	@Path("validarUsuarios")
	//@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public OsUsuario validarUsuarios(@QueryParam("correo") String correo,@QueryParam("contrasenia") String contrasenia) {
		OsUsuario u= usuarioOn.validar(correo, contrasenia);
		OsUsuario dNuevo = new OsUsuario(u.getUsCorreo(),u.getUsPassword(),u.getUsTipo());
		return dNuevo;
	}
	
	
	
}
