package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;

public class ControladorDentadura extends ControladorGenerico<OsDentadura> {

	@Override
	public List<OsDentadura> findAll() {
		Query consulta = getEm().createNamedQuery("OsDentadura.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsDentadura o1, OsDentadura o2) -> o1.getDentId().compareTo(o2.getDentId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsDentadura o1, OsDentadura o2) -> o2.getDentId().compareTo(o1.getDentId()));
			return (int) (lista.get(lista.size() - 1).getDentId() + 1);
		} else {
			return 1;
		}
	}

}
