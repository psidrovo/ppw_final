package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;

@Named
@RequestScoped
public class DentaduraBean {

	/**
	 * se ha creado todos los atributos que contienen una dentdura
	 */
	private int id;
	private String codigoMolar;
	
	/**
	 * se ha creado los atributos adicionales para poder utilizarlos
	 * y manipular la base de datos.
	 * 
	 */
	@Inject
	private GestionDentaduraON detOn;
	private OsDentadura dentadura;
	private List<OsDentadura>dentaduras;
	
	/**
	 * Se ha creado un constructor en el cual se Inicializa los objetos.
	 */
	@PostConstruct
	private void init() {
		dentadura = new OsDentadura();
		dentaduras=detOn.findAll();
	}
	
	public List<OsDentadura> getDentaduras() {
		return dentaduras;
	}

	public void setDentaduras(List<OsDentadura> dentaduras) {
		this.dentaduras = dentaduras;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoMolar() {
		return codigoMolar;
	}

	public void setCodigoMolar(String codigoMolar) {
		this.codigoMolar = codigoMolar;
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
	
	/**
	 * Este metodo realiza la accion de guardar una dentadura
	 * @return String.
	 */
	public String guardar() {

		detOn.guardarDentadura(dentadura);
		this.init();
		return null;
	}
	
	/**
	 * este metodo realizara la busqueda del objeto dentadura medianta la llave primaria.
	 * en caso de no encontrar el objeto se imprimira un mensaje en consola que no ha encontrado el objeto
	 * @return String
	 */
	public String Buscar() {
		OsDentadura d = detOn.read(dentadura.getDentId());
		if (d != null) {
			dentadura=d;
		} else {
			System.out.println("dentadura no se ha podido encontrar porque no existe");
		}

		this.init();
		return null;
	}
	
	/**
	 * este metodo realiza la eliminacion de un objeto dentadura mediante la llave primaria. en caso
	 * de que no encuentro el objeto se imprimira un mensaje en consola informando al usuario de que no 
	 * se ha podidio eliminar la cita.
	 * @return String
	 */
	public String delete() {
		OsDentadura d = detOn.read(dentadura.getDentId());
		if (d != null) {
			detOn.delete(dentadura.getDentId());
		} else {
			System.out.println("dentadura no se ha podido eliminar porque no existe");
		}

		this.init();
		return null;
	}
	
	
	
}
