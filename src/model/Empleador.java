package model;

import lombok.Getter;
import lombok.Setter;
import types.*;

@Getter
@Setter
public class Empleador extends Usuario {
    private TipoPersona tipo;
    private Rubro rubro;
    
    public Empleador(String nombreUsuario,String contrasena){
        super(nombreUsuario,contrasena);
    }
    

    
}
