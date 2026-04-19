package models;

public class registro extends Persona {

    private String contraseña_personaladiministrativo;
    private String telefono_personaladministrativo;

   
    public registro(String id, String nombre, String correo, String contraseña_personaladiministrativo,
            String telefono_personaladministrativo) {
        super(id, nombre, correo);
        this.contraseña_personaladiministrativo = contraseña_personaladiministrativo;
        this.telefono_personaladministrativo = telefono_personaladministrativo;
    }

    public registro() {
        super("", "", "");
    }

    @Override
    public String rol(){
        return "su rol es " +  this.nombre;
    }

    @Override
    public void mostrarinfo() {
        System.out.println("el ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Contraseña : " + contraseña_personaladiministrativo);
        System.out.println("Telefono : " + telefono_personaladministrativo);
    }

    void registrocorrecto(){
        System.out.println("el usuario" + this.nombre + " se ha registrado correctamente");
    }

    public String getContraseña_personaladiministrativo() {
        return contraseña_personaladiministrativo;
    }

    public void setContraseña_personaladiministrativo(String contraseña_personaladiministrativo) {
        this.contraseña_personaladiministrativo = contraseña_personaladiministrativo;
    }

    public String getTelefono_personaladministrativo() {
        return telefono_personaladministrativo;
    }

    public void setTelefono_personaladministrativo(String telefono_personaladministrativo) {
        this.telefono_personaladministrativo = telefono_personaladministrativo;
    }
    
}