package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionTratamientoON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsTratamiento;

@Named
@RequestScoped
public class TratamientoBean {

	private String nombre;
	private String costo;
	private String descripcion;
	private String tiempo;

	@Inject
	private GestionTratamientoON tratamientoOn;
	private OsTratamiento tratamiento;
	private List<OsTratamiento> tratamientos;

	@PostConstruct
	private void init() {
		tratamiento = new OsTratamiento();
		tratamientos = tratamientoOn.findAll();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public GestionTratamientoON getTratamientoOn() {
		return tratamientoOn;
	}

	public void setTratamientoOn(GestionTratamientoON tratamientoOn) {
		this.tratamientoOn = tratamientoOn;
	}

	public OsTratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(OsTratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public List<OsTratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(List<OsTratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public String guardar() {

		tratamientoOn.guardarTratamiento(tratamiento);

		this.init();
		return null;
	}

	public String buscarTratamiento() {
		OsTratamiento t = tratamientoOn.read(tratamiento.getTrNombre());
		if (t != null) {
			tratamiento = t;
		} else {
			System.out.println("No se ha podido encontrar el tratamiento porque no existe");
		}

		this.init();
		return null;
	}

	public String eliminarTratamiento() {
		OsTratamiento t = tratamientoOn.read(tratamiento.getTrNombre());
		if (t != null) {
			tratamientoOn.delete(tratamiento.getTrNombre());
		} else {
			System.out.println("No se ha podido eliminar el tratamiento porque no existe");
		}

		this.init();
		return null;
	}

}
