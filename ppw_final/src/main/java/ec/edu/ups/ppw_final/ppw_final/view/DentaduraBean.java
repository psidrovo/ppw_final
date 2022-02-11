package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.edu.ups.ppw_final.ppw_final.modelo.OsDetDentadura;

@Named
@RequestScoped
public class DentaduraBean {

	
	private int id;
	private String codigoMolar;
	private List<OsDetDentadura> DetDentadura;
	
	
	
}
