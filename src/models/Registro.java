package models;

//CLASE PADRE
public class Registro exten Verificacion{
    protected String id;
    protected String nombre;

    public Registro(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Registro() {
    }
}
