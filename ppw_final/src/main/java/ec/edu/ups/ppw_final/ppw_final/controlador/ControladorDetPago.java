package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsDentadura;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;

public class ControladorDetPago extends ControladorGenerico<OsDetPago> {

	@Override
	public List<OsDetPago> findAll() {
		Query consulta = getEm().createNamedQuery("OsDetPago.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista,(OsDetPago o1, OsDetPago o2) -> o1.getDetPgId().compareTo(o2.getDetPgId()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		var lista = findAll();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsDetPago o1, OsDetPago o2) -> o1.getDetPgId().compareTo(o2.getDetPgId()));
			return (int) (lista.get(lista.size() - 1).getDetPgId() + 1);
		} else {
			return 1;
		}
	}

}
