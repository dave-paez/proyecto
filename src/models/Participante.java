package models;

// Clase hija de Persona - Johan Gonzalez

public class Participante extends Persona {

    private String ubicacion;
    private String rolEspecifico;

    public Participante(String id, String nombre, String correo, String ubicacion, String rolEspecifico) {
        super(id, nombre, correo);
        this.ubicacion = ubicacion;
        this.rolEspecifico = rolEspecifico;
    }

    @Override
    public String rol() {
        return "Rol: Participante - " + this.rolEspecifico;
    }

    @Override
    public void mostrarinfo() {
        System.out.println("PARTICIPANTE");
        System.out.println("ID:        " + this.id);
        System.out.println("Nombre:    " + this.nombre);
        System.out.println("Correo:    " + this.correo);
        System.out.println("Ubicacion: " + this.ubicacion);
        System.out.println("Rol:       " + this.rolEspecifico);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getRolEspecifico() {
        return rolEspecifico;
    }

    public void setRolEspecifico(String rolEspecifico) {
        this.rolEspecifico = rolEspecifico;
    }
}