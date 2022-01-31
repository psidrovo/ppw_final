package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsTratamiento;

public class ControladorTratamiento extends ControladorGenerico<OsTratamiento> {

	@Override
	public List<OsTratamiento> findAll() {
		Query consulta = getEm().createNamedQuery("OsTratamiento.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsTratamiento o1, OsTratamiento o2) -> o1.getTrNombre().compareTo(o2.getTrNombre()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
