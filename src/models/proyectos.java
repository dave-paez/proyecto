package models;

public class proyectos extends Persona implements Gestionable {
    private String tipo_proyecto;
    private String descripcion_proyecto;
    private String fechaInicio_proyecto;
    private String fechaFin_proyecto;
    private String estado_proyecto;

    public proyectos(String id, String nombre, String correo, String tipo_proyecto, String descripcion_proyecto,
            String fechaInicio_proyecto, String fechaFin_proyecto, String estado_proyecto) {
        super(id, nombre, correo);
        this.tipo_proyecto = tipo_proyecto;
        this.descripcion_proyecto = descripcion_proyecto;
        this.fechaInicio_proyecto = fechaInicio_proyecto;
        this.fechaFin_proyecto = fechaFin_proyecto;
        this.estado_proyecto = estado_proyecto;
    }

    public proyectos() {
        super("", "", "");
    }

    @Override
    public String rol() {
        return "el rol es" + this.tipo_proyecto;
    }

    @Override
    public void cambiarEstado(String nuevoEstado) {
        this.estado_proyecto = nuevoEstado;
    }

    @Override
    public String traerDetalles() {
        return "ID: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Correo: " + correo + "\n" +
                "Tipo de Proyecto: " + tipo_proyecto + "\n" +
                "Descripción del Proyecto: " + descripcion_proyecto + "\n" +
                "Fecha de Inicio: " + fechaInicio_proyecto + "\n" +
                "Fecha de Fin: " + fechaFin_proyecto + "\n" +
                "Estado del Proyecto: " + estado_proyecto;
    }

    public String getTipo_proyecto() {
        return tipo_proyecto;
    }

    public void setTipo_proyecto(String tipo_proyecto) {
        this.tipo_proyecto = tipo_proyecto;
    }

    public String getDescripcion_proyecto() {
        return descripcion_proyecto;
    }

    public void setDescripcion_proyecto(String descripcion_proyecto) {
        this.descripcion_proyecto = descripcion_proyecto;
    }

    public String getFechaInicio_proyecto() {
        return fechaInicio_proyecto;
    }

    public void setFechaInicio_proyecto(String fechaInicio_proyecto) {
        this.fechaInicio_proyecto = fechaInicio_proyecto;
    }

    public String getFechaFin_proyecto() {
        return fechaFin_proyecto;
    }

    public void setFechaFin_proyecto(String fechaFin_proyecto) {
        this.fechaFin_proyecto = fechaFin_proyecto;
    }

    public String getEstado_proyecto() {
        return estado_proyecto;
    }

    public void setEstado_proyecto(String estado_proyecto) {
        this.estado_proyecto = estado_proyecto;
    }
}
