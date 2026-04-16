package models;

//CLASE PADRE
public class Registo {
    protected String id;
    protected String nombre;

    public Registo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Registo() {
    }
}
