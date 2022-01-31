package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsMedicamento;

public class ControladorMedicamento extends ControladorGenerico<OsMedicamento> {

	@Override
	public List<OsMedicamento> findAll() {
		Query consulta = getEm().createNamedQuery("OsMedicamento.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsMedicamento o1, OsMedicamento o2) -> o1.getMdNombre().compareTo(o2.getMdNombre()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		return 0;
	}

}
