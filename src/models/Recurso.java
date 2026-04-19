package models;

public class Recurso extends RecursoBase {
    
    public Recurso(String id, String nombre, String categoria, String estado, String ubicacion) {
        super(id, nombre, categoria, estado, ubicacion);
    }

 
    // Polimorfismo: sobreescribimos traerDetalles() de RecursoBase
    // para agregar el encabezado "RECURSO" y distinguirlo de otros tipos
    @Override
    public String traerDetalles() {
        return "RECURSO\n"
                + "ID:        " + id + "\n"
                + "Nombre:    " + nombre + "\n"
                + "Categoria: " + categoria + "\n"
                + "Estado:    " + estado + "\n"
                + "Ubicacion: " + ubicacion;
    }
}