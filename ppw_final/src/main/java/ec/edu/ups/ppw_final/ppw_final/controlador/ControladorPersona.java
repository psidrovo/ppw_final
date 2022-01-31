package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

public class ControladorPersona extends ControladorGenerico<OsPersona> {

	@Override
	public List<OsPersona> findAll() {
		Query consulta = getEm().createNamedQuery("OsPersona.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsPersona o1, OsPersona o2) -> o1.getPerCedula().compareTo(o2.getPerCedula()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		return 0;
	}

}
