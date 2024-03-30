package co.edu.uniquindio.empresa.empresaeventos.model;

import java.util.ArrayList;

public class Usuario extends Persona{

	//atributos
	private String contrasenia;

	ArrayList<Reserva> listaReservasAsociadas = new ArrayList<Reserva>();
	
		
	public Usuario() {

	}

	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public ArrayList<Reserva> getListaReservasAsociadas(){ return listaReservasAsociadas;}

	public void setListaReservasAsociadas(ArrayList<Reserva> listReservasAsociadas){
		this.listaReservasAsociadas = listReservasAsociadas;
	}


}
