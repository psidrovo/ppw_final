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

	
	private int id;
	private String codigoMolar;
	
	@Inject
	private GestionDentaduraON detOn;
	private OsDentadura dentadura;
	
	@PostConstruct
	private void init() {
		dentadura = new OsDentadura();
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
	
	public String guardar() {
		OsDentadura d = detOn.read(dentadura.getDentId());
		if(d!=null) {
			detOn.guardarDentadura(d);
			System.out.println("Se ha modificado " + d);
		}else {
			detOn.guardarDentadura(d);
			System.out.println("Se ha creado " + d);
		}
		this.init();
		return null;
	}
	
	public String Buscar() {
		OsDentadura d = detOn.read(dentadura.getDentId());
		if (d != null) {
			dentadura.setDentCdgMolar(d.getDentCdgMolar());
		} else {
			System.out.println("dentadura no se ha podido encontrar porque no existe");
		}

		this.init();
		return null;
	}
	
	public String delete() {
		OsDentadura d = detOn.read(dentadura.getDentId());
		if (d != null) {
			detOn.delete(d.getDentId());
		} else {
			System.out.println("dentadura no se ha podido eliminar porque no existe");
		}

		this.init();
		return null;
	}
	
	
	
}
