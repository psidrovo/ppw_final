package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionDetDentaduraON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetDentadura;

@Named
@RequestScoped
public class DentaduraDetalleBean {
	
	private int id;
	private String estadoTrat;
	
	@Inject
	private GestionDetDentaduraON denDetOn;
	private OsDetDentadura detDetdura;
	@Inject
	private GestionDentaduraON detOn;
	private OsDentadura dentadura;
	private List<OsDetDentadura>detallesDentaduras;
	
	@PostConstruct
	private void init() {
		dentadura = new OsDentadura();
		detDetdura= new OsDetDentadura();
		detallesDentaduras= denDetOn.findAll();
	}
	
	public List<OsDetDentadura> getDetallesDentaduras() {
		return detallesDentaduras;
	}

	public void setDetallesDentaduras(List<OsDetDentadura> detallesDentaduras) {
		this.detallesDentaduras = detallesDentaduras;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstadoTrat() {
		return estadoTrat;
	}

	public void setEstadoTrat(String estadoTrat) {
		this.estadoTrat = estadoTrat;
	}

	public OsDetDentadura getDetDetdura() {
		return detDetdura;
	}

	public void setDetDetdura(OsDetDentadura detDetdura) {
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

	public String guardar() {
		OsDetDentadura dd = denDetOn.read(detDetdura.getDetDentId());
		if (dd != null) {
			OsDentadura d = detOn.read(dentadura.getDentId());
			if(dd.getOsDentadura()==d) {
				//dd.setOsDentadura(d);
				denDetOn.guardarDetDentadura(dd);
				System.out.println("se ha modificado un detalle de dentadura existosamente");
			}else {
				System.out.println("la cabecera de dentadura no es similar a la del detalle por ende no se ha podido modificar el detalle");
			}
		} else {
			OsDentadura d = detOn.read(dentadura.getDentId());
			if(d!=null) {
				detDetdura.setOsDentadura(d);
				denDetOn.guardarDetDentadura(detDetdura);
			}else {
				System.out.println("la cabecera de dentadura no existe  por ende no se ha podido modificar el detalle");

			}
			
		}

		this.init();
		return null;
	}
	
	public String buscarDetalle() {
		OsDetDentadura dd = denDetOn.read(detDetdura.getDetDentId());
		if (dd != null) {
			detDetdura=dd;
		} else {
			System.out.println("detalle no se ha podido encontrar porque no existe");
		}

		this.init();
		return null;
	}
	
	public String eliminarDetalle() {
		OsDetDentadura dd = denDetOn.read(detDetdura.getDetDentId());
		if (dd != null) {
			denDetOn.delete(dd.getDetDentId());
			System.out.println("detalle eliminado con exito");
		} else {
			System.out.println("detalle no se ha podido eliminar porque no existe");
		}
		this.init();
		return null;
	}
	

}
