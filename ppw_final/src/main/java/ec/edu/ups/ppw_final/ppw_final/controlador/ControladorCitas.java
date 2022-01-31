package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;

public class ControladorCitas extends ControladorGenerico<OsCita> {

	@Override
	public List<OsCita> findAll() {
		Query consulta = getEm().createNamedQuery("OsCita.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsCita o1, OsCita o2) -> o2.getCtId().compareTo(o1.getCtId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsCita o1, OsCita o2) -> o2.getCtId().compareTo(o1.getCtId()));
			return (int) (lista.get(lista.size() - 1).getCtId() + 1);
		} else {
			return 1;
		}
	}

}
