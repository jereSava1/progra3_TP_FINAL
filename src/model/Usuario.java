package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Usuario {
   private String nombre;
   private String nombreUsuario;
   private String contrasena;
   
   public Usuario(String nombreUsuario, String contrasena){
       this.nombreUsuario=nombreUsuario;
       this.contrasena=contrasena;
   }
   
   
   public boolean logIn(String nombreUsuario,String contrasena){
       boolean logeo=false;
       if(nombreUsuario==this.nombreUsuario){
           if(contrasena==this.contrasena){
               logeo=true;
           }else{}
           //excepcion2
           
       }
           else{}
       //excepcion1
       
   return logeo;
   }
   
}
