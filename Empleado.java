package co.edu.uniquindio.empresa.empresaeventos.model;

import java.util.ArrayList;

public class Empleado extends Persona{

	
	private String rol;
	private String eventoAsignado;
	ArrayList<Evento> listaEventosAsociados = new ArrayList<Evento>();

	
	public Empleado() {
		
	}
	
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEventoAsignado() {
		return eventoAsignado;
	}


	public void setEventoAsignado(String eventoAsignado) {
		this.eventoAsignado = eventoAsignado;
	}


	public ArrayList<Evento> getListaEventosAsociados() {
		return listaEventosAsociados;
	}


	public void setListaEventosAsociados(ArrayList<Evento> listEventosAsociados) {
		this.listaEventosAsociados = listEventosAsociados;
	}
	
	
	
}
