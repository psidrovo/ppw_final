package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetalleDen;

@Named
@RequestScoped
public class DentaduraDetalleBean {

	/**
	 * se ha creado todos los atributos que contienen un detalle dentadura
	 */
	private int id;
	private String cuadrante;

	/**
	 * se ha creado los atributos adicionales para poder utilizarlos
	 * y manipular la base de datos.
	 * 
	 */
	@Inject
	private GestionDetDentaduraON denDetOn;
	private OsDetalleDen detDetdura;
	@Inject
	private GestionDentaduraON detOn;
	private OsDentadura dentadura;
	private List<OsDetalleDen> detallesDentaduras;

	/**
	 * Se ha creado un constructor en el cual se Inicializa los objetos.
	 */
	@PostConstruct
	private void init() {
		dentadura = new OsDentadura();
		detDetdura = new OsDetalleDen();
		detallesDentaduras = denDetOn.findAll();
	}

	public List<OsDetalleDen> getDetallesDentaduras() {
		return detallesDentaduras;
	}

	public void setDetallesDentaduras(List<OsDetalleDen> detallesDentaduras) {
		this.detallesDentaduras = detallesDentaduras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuadrante() {
		return cuadrante;
	}

	public void setCuadrante(String cuadrante) {
		this.cuadrante = cuadrante;
	}

	public OsDetalleDen getDetDetdura() {
		return detDetdura;
	}

	public void setDetDetdura(OsDetalleDen detDetdura) {
		this.detDetdura = detDetdura;
	}

	public GestionDentaduraON getDetOn() {
		return detOn;
	}

	public void setDetOn(GestionDentaduraON detOn) {
		this.detOn = detOn;
	}

	public OsDentadura getDentadura() {
		return dentadura;
	}

	public void setDentadura(OsDentadura dentadura) {
		this.dentadura = dentadura;
	}

	public GestionDetDentaduraON getDenDetOn() {
		return denDetOn;
	}

	public void setDenDetOn(GestionDetDentaduraON denDetOn) {
		this.denDetOn = denDetOn;
	}

	/**
	 * Este metodo realiza la accion de guardar un objeto detalle dentadura.Primero asigna la dentadura a la que pertenece
	 * este detalle y luego lo crea o graba dentro de la base de datos
	 * @return String
	 */
	public String guardar() {
		detDetdura.setOsDentadura(dentadura);
		denDetOn.guardarDetDentadura(detDetdura);

		this.init();
		return null;
	}

	/**
	 * este metodo realizara la busqueda del objeto detalle dentadura medianta la llave primaria.
	 * en caso de no encontrar el objeto se imprimira un mensaje en consola que no ha encontrado el objeto
	 *  @return String
	 */
	public String buscarDetalle() {
		OsDetalleDen dd = denDetOn.read(detDetdura.getId());
		if (dd != null) {
			detDetdura = dd;
		} else {
			System.out.println("detalle no se ha podido encontrar porque no existe");
		}

		this.init();
		return null;
	}

	/**
	 * este metodo realiza la eliminacion de un objeto detalle dentadura mediante la llave primaria. en caso
	 * de que no encuentro el objeto se imprimira un mensaje en consola informando al usuario de que no 
	 * se ha podidio eliminar la cita.
	 *  @return String
	 */
	public String eliminarDetalle() {
		OsDetalleDen dd = denDetOn.read(detDetdura.getId());
		if (dd != null) {
			denDetOn.delete(dd.getId());
			System.out.println("detalle eliminado con exito");
		} else {
			System.out.println("detalle no se ha podido eliminar porque no existe");
		}
		this.init();
		return null;
	}

}
