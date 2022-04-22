package model;

public class Empleado extends Usuario {
    private String telefono;
    private String email;
    private int edad;
  
    
    
    public Empleado(String nombreUsuario,String contrasena){
        super(nombreUsuario,contrasena);
    }
    
}
