package models;

public class Proyectos extends Persona implements Gestionable {

    private String tipo_proyecto;
    private String descripcion_proyecto;
    private String fechaInicio_proyecto;
    private String fechaFin_proyecto;
    private String estado_proyecto;

    public Proyectos(String id, String nombre, String tipo_proyecto, String descripcion_proyecto,
            String fechaInicio_proyecto, String fechaFin_proyecto, String estado_proyecto) {
        super(id, nombre, "");
        this.tipo_proyecto = tipo_proyecto;
        this.descripcion_proyecto = descripcion_proyecto;
        this.fechaInicio_proyecto = fechaInicio_proyecto;
        this.fechaFin_proyecto = fechaFin_proyecto;
        this.estado_proyecto = estado_proyecto;
    }

    @Override
    public String rol() {
        return "Tipo de proyecto: " + this.tipo_proyecto;
    }

    @Override
    public void cambiarEstado(String nuevoEstado) {
        this.estado_proyecto = nuevoEstado;
    }

    @Override
    public String traerDetalles() {
        return "ID:           " + id + "\n"
                + "Nombre:       " + nombre + "\n"
                + "Tipo:         " + tipo_proyecto + "\n"
                + "Descripcion:  " + descripcion_proyecto + "\n"
                + "Fecha inicio: " + fechaInicio_proyecto + "\n"
                + "Fecha fin:    " + fechaFin_proyecto + "\n"
                + "Estado:       " + estado_proyecto;
    }

    @Override
    public void mostrarinfo() {
        System.out.println(traerDetalles());
    }

    public String getProyectoId()           { return id; }
    public String getNombre_proyecto()      { return nombre; }
    public String getTipo_proyecto()        { return tipo_proyecto; }
    public String getDescripcion_proyecto() { return descripcion_proyecto; }
    public String getFechaInicio_proyecto() { return fechaInicio_proyecto; }
    public String getFechaFin_proyecto()    { return fechaFin_proyecto; }
    public String getEstado_proyecto()      { return estado_proyecto; }

    public void setNombre_proyecto(String nombre)              { this.nombre = nombre; }
    public void setTipo_proyecto(String tipo)                  { this.tipo_proyecto = tipo; }
    public void setDescripcion_proyecto(String descripcion)    { this.descripcion_proyecto = descripcion; }
    public void setFechaInicio_proyecto(String fechaInicio)    { this.fechaInicio_proyecto = fechaInicio; }
    public void setFechaFin_proyecto(String fechaFin)          { this.fechaFin_proyecto = fechaFin; }
    public void setEstado_proyecto(String estado)              { this.estado_proyecto = estado; }
}