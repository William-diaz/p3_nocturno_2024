package co.edu.uniquindio.empresa.empresaeventos.model;

import java.util.ArrayList;

public class Evento {

    private String identificacion;
    private String nombre;
    private String descripcion;
    private String fecha;
    private Integer capacidadMax;
    private String hora;
    private String ubicacion;
    Empleado empleadoAsociado;

    ArrayList<Reserva> listaReservasAsociadas = new ArrayList<Reserva>();

    public Evento(String identificacion, String nombre, String descripcion, String fecha, Integer capacidadMax, String hora, String ubicacion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.capacidadMax = capacidadMax;
        this.hora = hora;
        this.ubicacion = ubicacion;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }


    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Reserva> getListaReservasAsociadas(){ return listaReservasAsociadas;}

    public void setListaReservasAsociadas(ArrayList<Reserva> listReservasAsociadas){
        this.listaReservasAsociadas = listReservasAsociadas;
    }
}
