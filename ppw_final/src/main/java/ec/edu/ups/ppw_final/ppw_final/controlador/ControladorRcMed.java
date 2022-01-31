package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsRcMed;

public class ControladorRcMed extends ControladorGenerico<OsRcMed>{

	@Override
	public List<OsRcMed> findAll() {
		Query consulta = getEm().createNamedQuery("OsRcMed.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsRcMed o1, OsRcMed o2) -> o1.getRcMedId().compareTo(o2.getRcMedId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsRcMed o1, OsRcMed o2) -> o1.getRcMedId().compareTo(o2.getRcMedId()));
			return (int) (lista.get(lista.size() - 1).getRcMedId() + 1);
		} else {
			return 1;
		}
	}

}
