package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionMedicamentoON;
import ec.edu.ups.ppw_final.ppw_final.business.GestionRCMedON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsMedicamento;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsRcMed;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

@Named
@RequestScoped
public class RCMedicaBean {

	private int id;
	private String rcMedCol;
	
	@Inject
	private GestionRCMedON rcMedOn;
	@Inject
	private GestionMedicamentoON medOn;
	private OsRcMed rcMed;
	private OsMedicamento medicamento;
	private List<OsRcMed> rcMedicas;
	
	@PostConstruct
	private void init() {
		rcMed= new OsRcMed();
		medicamento= new OsMedicamento();
		rcMedicas= rcMedOn.findAll();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRcMedCol() {
		return rcMedCol;
	}

	public void setRcMedCol(String rcMedCol) {
		this.rcMedCol = rcMedCol;
	}

	public GestionRCMedON getRcMedOn() {
		return rcMedOn;
	}

	public void setRcMedOn(GestionRCMedON rcMedOn) {
		this.rcMedOn = rcMedOn;
	}

	public GestionMedicamentoON getMedOn() {
		return medOn;
	}

	public void setMedOn(GestionMedicamentoON medOn) {
		this.medOn = medOn;
	}

	public OsRcMed getRcMed() {
		return rcMed;
	}

	public void setRcMed(OsRcMed rcMed) {
		this.rcMed = rcMed;
	}

	public OsMedicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(OsMedicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<OsRcMed> getRcMedicas() {
		return rcMedicas;
	}

	public void setRcMedicas(List<OsRcMed> rcMedicas) {
		this.rcMedicas = rcMedicas;
	}
	
	public String guardar() {
		OsRcMed r = rcMedOn.read(rcMed.getRcMedId());
		if (r != null) {
			rcMed.setOsMedicamento(medicamento);
			rcMedOn.guardarRCMed(rcMed);
		} else {
			rcMed.setOsMedicamento(medicamento);
			rcMedOn.guardarRCMed(rcMed);
		}
		this.init();
		return null;
	}
	
	public String buscarMedicamento() {
		OsRcMed r = rcMedOn.read(rcMed.getRcMedId());
		if (r != null) {
			rcMed=r;
			System.out.println("Se ha encontrado la receta medica exitosamente");
		} else {
			System.out.println("No se ha podido encontrar a la receta medica porque no existe");
		}

		this.init();
		return null;
	}
	
	public String eliminarMedicamento() {
		OsRcMed r = rcMedOn.read(rcMed.getRcMedId());
		if(r!=null) {
			rcMedOn.delete(rcMed.getRcMedId());
		}else {
			System.out.println("No se ha podido eliminar el usuario y la persona porque no existe");
		}
		
		this.init();
		return null;
	}
}
