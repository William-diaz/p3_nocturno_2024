package co.edu.uniquindio.empresa.empresaeventos.model;

public class Reserva {
    private String identificacion;
    private String fechaSolicitud;

    private Estado estado;

    Usuario usuarioAsociado;
    Evento eventoAsociado;

    public Reserva(String identificacion, String fechaSolicitud) {
        this.identificacion = identificacion;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Usuario getUsuarioAsociado(){
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado){ this.usuarioAsociado = usuarioAsociado;}

    public Evento getEventoAsociado(){
        return eventoAsociado;
    }

    public void setEventoAsociado(Evento eventoAsociado){ this.eventoAsociado = eventoAsociado;}
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
