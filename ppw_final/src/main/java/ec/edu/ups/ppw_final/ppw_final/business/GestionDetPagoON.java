package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorDetPago;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;

@Stateless
public class GestionDetPagoON {

	@Inject
	private ControladorDetPago controladorDetP;

	public void guardarDetPago(OsDetPago pago) {
		OsDetPago u = controladorDetP.read(pago.getDetPgId());
		if (u == null) {
			controladorDetP.insert(pago);
		} else {
			controladorDetP.update(pago);
		}
	}

	public void delete(int id) {
		controladorDetP.delete(id);
	}

	public OsDetPago read(int id) {
		return controladorDetP.read(id);
	}

	public List<OsDetPago> findAll() {
		return controladorDetP.findAll();
	}
}
