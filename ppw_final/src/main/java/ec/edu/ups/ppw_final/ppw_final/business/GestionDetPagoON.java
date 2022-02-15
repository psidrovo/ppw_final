package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorDetPago;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;

@Stateless
public class GestionDetPagoON {

	/**
	 * se inicializa el controlador detalle pago para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorDetPago controladorDetP;

	/**
	 * este metodo recibe un objeto de tipo detalle pago y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param pago.
	 */
	public void guardarDetPago(OsDetPago pago) {
		OsDetPago u = controladorDetP.read(pago.getDetPgId());
		if (u == null) {
			controladorDetP.insert(pago);
			System.out.println("detalle de pago es creado con exito");
		} else {
			controladorDetP.update(pago);
			System.out.println("detalle de pago actualizado con exito");
		}
	}

	/**
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public void delete(int id) {
		controladorDetP.delete(id);
	}

	/**
	 * Este metodo busca un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 * @return OsDetPago
	 */
	public OsDetPago read(int id) {
		return controladorDetP.read(id);
	}

	/**
	 * Este metodo devuele todo el listado de detalles pagos dentro de la base de datos.
	 * @return List<OsDetPago>
	 */
	public List<OsDetPago> findAll() {
		return controladorDetP.findAll();
	}
}
