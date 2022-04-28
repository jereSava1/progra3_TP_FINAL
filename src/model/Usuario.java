package model;

import lombok.Getter;
import lombok.Setter;

import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import types.*;

import java.util.Objects;

@Getter
@Setter
public abstract class Usuario {
   private String nombre;
   private String nombreUsuario;
   private String contrasena;
   protected int puntaje;
   
   public Usuario(String nombreUsuario, String contrasena){
       this.nombreUsuario = nombreUsuario;
       this.contrasena = contrasena;
       this.puntaje = 0;
   }
   
   
   public boolean logIn(String nombreUsuario,String contrasena){
       boolean logeo = false;

       if(Objects.equals(nombreUsuario, this.nombreUsuario)){
           if(Objects.equals(contrasena, this.contrasena)){
               logeo = true;
           }else {}
           //excepcion2
           
       } else {}
       //excepcion1
       
   return logeo;
   }


   public void bajaTicket(Ticket ticket) {
     if (ticket.getDueno().equals(this)) {
       ticket.setEstadoTicket(EstadoTicket.CANCELADO);
     } else {
       //TODO: tirar excepcion si no es dueño del ticket
     }
   };

   public void modificaTicket(Ticket ticket, FormularioBusqueda formularioBusqueda){
     if (ticket.getDueno().equals(this)) {
       ticket.setFormularioDeBusqueda(formularioBusqueda);
     } else {
       //TODO tirar excepcion
     }
   };

   public void cambiaEstadoTicket(Ticket ticket, EstadoTicket estado){
     if (ticket.getDueno().equals(this)) {
       ticket.setEstadoTicket(estado);
     } else {
       //TODO tirar excepcion
     }
   }

   public void aumentarPuntaje(int puntaje) {
     this.puntaje += puntaje;
   }

   public void bajarPuntaje(int puntaje) {
     this.puntaje -= puntaje;
   }
   
   public void consultaTicket(Ticket ticket) {
     System.out.println(ticket.toString());
   };
}
