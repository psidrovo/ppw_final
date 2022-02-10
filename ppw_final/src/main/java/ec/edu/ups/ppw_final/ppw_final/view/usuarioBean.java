package ec.edu.ups.ppw_final.ppw_final.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import ec.edu.ups.ppw_final.ppw_final.business.GestionPersonaON;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;

import javax.annotation.PostConstruct;

@Named
@RequestScoped
public class usuarioBean {

	@Inject
	private GestionPersonaON PerON;

	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;

	private OsPersona newPersona = new OsPersona();

	private String filtro;

	private List<OsPersona> personas;

	@PostConstruct
	public void init() {
		personas = PerON.findAll();
	}


	public GestionPersonaON getPerON() {
		return PerON;
	}




	public void setPerON(GestionPersonaON perON) {
		PerON = perON;
	}




	public String getCedula() {
		return cedula;
	}




	public void setCedula(String cedula) {
		this.cedula = cedula;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public OsPersona getNewPersona() {
		return newPersona;
	}




	public void setNewPersona(OsPersona newPersona) {
		this.newPersona = newPersona;
	}




	public String getFiltro() {
		return filtro;
	}




	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}




	public List<OsPersona> getPersonas() {
		return personas;
	}




	public void setPersonas(List<OsPersona> personas) {
		this.personas = personas;
	}



//metodos
	
	public String guardar() {

		OsPersona p = new OsPersona();
		p.setPerCedula(cedula);
		p.setPerNombre(nombre);
		p.setPerApellido(apellido);
		p.setPerDireccion(direccion);
		newPersona = p;
		//System.out.println("cliente = " + this.cedula + " Nombre " + this.nombre);
		//System.out.println("cleitne ? " + this.cedula);
		PerON.guardarPersona(newPersona);
		this.init();

		return "#";
	}

	public String buscarPorNombre() {

		//System.out.println("Ingreso a buscar");
		List<OsPersona>p= new ArrayList<OsPersona>();
		p.add(PerON.read(this.filtro));
		personas = p;
		return null;
	}

	public String editarCliente(String id) {
		System.out.println("editando " + id);
		return "Crear-Persona?faces-redirect=true&id=" + id;

	}

	public OsPersona listarClientes() {
		for (OsPersona p : personas) {
			//System.out.println(p.getCedula() + " cedula >>");
			this.cedula = p.getPerCedula();
			this.nombre = p.getPerNombre();
			this.apellido = p.getPerApellido();
			this.direccion = p.getPerDireccion();
			this.init();
			return p;
		}
		return null;
	}

	public void loadDatos() {
		if (cedula == null)
			return;

		if (cedula != null)
			return;

	}
}
