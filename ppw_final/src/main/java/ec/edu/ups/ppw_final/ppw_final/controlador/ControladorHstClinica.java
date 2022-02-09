package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsHstClinica;

public class ControladorHstClinica extends ControladorGenerico<OsHstClinica> {

	@Override
	public List<OsHstClinica> findAll() {
		Query consulta = getEm().createNamedQuery("OsHstClinica.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsHstClinica o1, OsHstClinica o2) -> o1.getHstClId().compareTo(o2.getHstClId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			//Collections.sort(lista, (OsHstClinica o1, OsHstClinica o2) -> o1.getHstClId().compareTo(o2.getHstClId()));
			//return (int) (lista.get(lista.size() - 1).getHstClId() + 1);
			return 0;
		} else {
			return 1;
		}
	}
}
