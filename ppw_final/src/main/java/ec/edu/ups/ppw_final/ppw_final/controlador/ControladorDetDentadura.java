package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetDentadura;

public class ControladorDetDentadura extends ControladorGenerico<OsDetDentadura>{

	@Override
	public List<OsDetDentadura> findAll() {
		Query consulta = getEm().createNamedQuery("OsDetDentadura.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsDetDentadura o1, OsDetDentadura o2) -> o1.getDetDentId().compareTo(o2.getDetDentId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsDetDentadura o1, OsDetDentadura o2) -> o2.getDetDentId().compareTo(o1.getDetDentId()));
			return (int) (lista.get(lista.size() - 1).getDetDentId() + 1);
		} else {
			return 1;
		}
	}

}
