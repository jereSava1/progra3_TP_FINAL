package model;

import types.*;

public class Empleador extends Usuario {
    private TipoPersona tipo;
    private Rubro rubro;
    
    public Empleador(String nombreUsuario,String contrasena){
        super(nombreUsuario,contrasena);
    }
    

    
}
