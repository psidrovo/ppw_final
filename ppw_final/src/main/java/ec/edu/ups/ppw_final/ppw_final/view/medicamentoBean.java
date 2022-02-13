package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionMedicamentoON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsMedicamento;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

@Named
@RequestScoped
public class medicamentoBean {

	
	private String mdnombre;
	private String mddosis;
	private String mdpresentacion;
	
	@Inject
	private GestionMedicamentoON medOn;
	private OsMedicamento medicamento;
	private List<OsMedicamento>medicamentos;
	
	@PostConstruct
	private void init() {
		medicamento = new OsMedicamento();
		medicamentos= medOn.findAll();
	}

	public String getMdnombre() {
		return mdnombre;
	}

	public void setMdnombre(String mdnombre) {
		this.mdnombre = mdnombre;
	}

	public String getMddosis() {
		return mddosis;
	}

	public void setMddosis(String mddosis) {
		this.mddosis = mddosis;
	}

	public String getMdpresentacion() {
		return mdpresentacion;
	}

	public void setMdpresentacion(String mdpresentacion) {
		this.mdpresentacion = mdpresentacion;
	}

	public GestionMedicamentoON getMedOn() {
		return medOn;
	}

	public void setMedOn(GestionMedicamentoON medOn) {
		this.medOn = medOn;
	}

	public OsMedicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(OsMedicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<OsMedicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<OsMedicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	
	public String Guardar() {
			medOn.guardarMedicamento(medicamento);
		this.init();
		return null;
	}
	
	public String buscarMedicamento() {
		OsMedicamento m = medOn.read(medicamento.getMdNombre());
		if (m != null) {
			medicamento=m;
			System.out.println("Se ha encontrado el medicamento exitosamente");
		} else {
			System.out.println("No se ha podido encontrar el medicamento porque no existe");
		}

		this.init();
		return null;
	}
	
	public String deleteMedicamento() {
		OsMedicamento m = medOn.read(medicamento.getMdNombre());
		if(m != null) {
			medOn.delete(medicamento.getMdNombre());
		}else {
			System.out.println("No se ha podido eliminar el medicamiento porque no existe");
		}
		
		this.init();
		return null;
	}
}
