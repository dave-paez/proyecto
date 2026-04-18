package models;

//Segunda clase abstracta - creado por juan duarte
public abstract class RecursoBase implements Gestionable {
  protected String id;
  protected String nombre;
  protected String categoria;
  protected String estado;
  protected String ubicacion;

  public RecursoBase(String id, String nombre, String categoria, String estado, String ubicacion) {
    this.id = id;
    this.nombre = nombre;
    this.categoria = categoria;
    this.estado = estado;
    this.ubicacion = ubicacion;
  }

  public abstract void realizarRevision();

  @Override
  public void cambiarEstado(String nuevoEstado) {
    this.estado = nuevoEstado;
  }

}
