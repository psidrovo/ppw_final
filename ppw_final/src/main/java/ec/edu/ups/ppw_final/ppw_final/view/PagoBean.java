package ec.edu.ups.ppw_final.ppw_final.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.business.GestionDetPagoON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetPago;

@Named
@RequestScoped
public class PagoBean {

	private int id;
	private double valor;
	
	@Inject
	private GestionDetPagoON pagoOn;
	private OsDetPago pago;
	
	
}
