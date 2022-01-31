package ec.edu.ups.ppw_final.ppw_final.controlador;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;

public class ControladorUsuario extends ControladorGenerico<OsUsuario>{

	@Override
	public List<OsUsuario> findAll() {
		Query consulta = getEm().createNamedQuery("OsUsuario.findAll");
		var lista = consulta.getResultList();

		if (lista.size() > 0) {
			Collections.sort(lista, (OsUsuario o1, OsUsuario o2) -> o1.getUsCorreo().compareTo(o2.getUsCorreo()));
		}
		return consulta.getResultList();
	}

	@Override
	public int codigo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
