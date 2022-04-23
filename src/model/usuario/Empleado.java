package model.usuario;

import lombok.Getter;
import lombok.Setter;
import model.ticket.FormularioBusqueda;
import model.Usuario;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import types.*;

@Getter
@Setter
public class Empleado extends Usuario {
    
    private String telefono;
    private String email;
    private int edad;
  
    public Empleado(String nombreUsuario,String contrasena){
        super(nombreUsuario, contrasena);
    }

    public Empleado(String nombreUsuario, String contrasena, String nombre, int edad, String email, String telefono){
        super(nombreUsuario, contrasena);
        this.setNombre(nombre);
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
    }

    public TicketBusquedaDeEmpleo altaTicket(FormularioBusqueda formulario){
        return new TicketBusquedaDeEmpleo(formulario, this);
    }
    
    @Override
    public void bajaTicket(Ticket ticket){
        if (ticket.getDueno().equals(this)) {
            ticket.setEstadoTicket(EstadoTicket.CANCELADO);
            this.puntaje--;
        } else {
            //TODO excepcion
        }
    }

    @Override
    public String toString(){
        return "Nombre: " + this.getNombre() + "\n" +
                "Telefono: " + this.getTelefono() + "\n" +
                "email: " + this.getEmail() + "\n" +
                "Edad: " + this.getEdad() + "\n";
    }

}
