package models;

//primera clase padre - creado por dave paez
//modificado por juan duarte

public abstract class Persona {
  protected String id;
  protected String nombre;
  protected String correo;

  public Persona(String id, String nombre, String correo) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
  }

  public abstract String rol();
}
