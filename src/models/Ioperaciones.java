package models;

public interface Ioperaciones {

    void guardar(RecursoBase recurso);
 
    RecursoBase buscar(String id);
 
    void eliminar(String id);
}
