package co.edu.uniquindio.empresa.empresaeventos.model;

import co.edu.uniquindio.empresa.empresaeventos.exceptions.EmpleadoException;
import co.edu.uniquindio.empresa.empresaeventos.model.services.IEmpresaEventosService;

import java.util.ArrayList;


public class EmpresaEventos implements IEmpresaEventosService {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	ArrayList<Reserva> listaReservas = new ArrayList<>();
	ArrayList<Evento> listaEventos = new ArrayList<>();


	public EmpresaEventos() {
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	public ArrayList<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(ArrayList<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}



	@Override
	public Empleado crearEmpleado(String nombre, String apellido, String identificacion, String rol) throws EmpleadoException{
		Empleado nuevoEmpleado = null;
		boolean empleadoExiste = verificarEmpleadoExistente(identificacion);
		if(empleadoExiste){
			throw new EmpleadoException("El empleado con identificacion: "+identificacion+" ya existe");
		}else{
			nuevoEmpleado = new Empleado();
			nuevoEmpleado.setNombre(nombre);
			nuevoEmpleado.setApellido(apellido);
			nuevoEmpleado.setIdentificacion(identificacion);
			nuevoEmpleado.setRol(rol);
			getListaEmpleados().add(nuevoEmpleado);
		}
		return nuevoEmpleado;
	}

	public void agregarEmpleado(Empleado nuevoEmpleado) throws EmpleadoException{
		getListaEmpleados().add(nuevoEmpleado);
	}

	@Override
	public boolean consultarEmpleado(String identificacion) throws EmpleadoException {
		Empleado empleadoConsultado = obtenerEmpleado(identificacion);
		if(empleadoConsultado == null) {
			throw new EmpleadoException("El empleado no existe");
		} else {
			return true;
		}
	}
	@Override
	public boolean actualizarEmpleado(String identificacionActual, Empleado empleado) throws EmpleadoException {
		Empleado empleadoActual = obtenerEmpleado(identificacionActual);
		if(empleadoActual == null)
			throw new EmpleadoException("El empleado a actualizar no existe");
		else{
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setApellido(empleado.getApellido());
			empleadoActual.setIdentificacion(empleado.getIdentificacion());
			empleadoActual.setCorreo(empleado.getCorreo());
			empleadoActual.setRol(empleado.getRol());
			empleadoActual.setEventoAsignado(empleado.getEventoAsignado());
			return true;
		}
	}

	@Override
	public Boolean eliminarEmpleado(String identificacion) throws EmpleadoException {
		Empleado empleado = null;
		boolean flagExiste = false;
		empleado = obtenerEmpleado(identificacion);
		if(empleado == null)
			throw new EmpleadoException("El empleado a eliminar no existe");
		else{
			getListaEmpleados().remove(empleado);
			flagExiste = true;
		}
		return flagExiste;
	}

	@Override
	public boolean verificarEmpleadoExistente(String identificacion) throws EmpleadoException {
		if(empleadoExiste(identificacion)){
			throw new EmpleadoException("El empleado con cedula: "+identificacion+" ya existe");
		}else{
			return false;
		}
	}


	@Override
	public Empleado obtenerEmpleado(String identificacion) {
		Empleado empleadoEncontrado = null;
		for (Empleado empleado : getListaEmpleados()) {
			if(empleado.getIdentificacion().equalsIgnoreCase(identificacion)){
				empleadoEncontrado = empleado;
				break;
			}
		}
		return empleadoEncontrado;
	}

	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		// TODO Auto-generated method stub
		return getListaEmpleados();
	}

	public boolean empleadoExiste(String identificacion) {
		boolean empleadoEncontrado = false;
		for (Empleado empleado : getListaEmpleados()) {
			if(empleado.getIdentificacion().equalsIgnoreCase(identificacion)){
				empleadoEncontrado = true;
				break;
			}
		}
		return empleadoEncontrado;
	}
}
