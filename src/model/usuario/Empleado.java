package model.usuario;

import exception.NoDuenoDeTicketException;
import lombok.Getter;
import lombok.Setter;
import model.ticket.FormularioBusqueda;
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
    public void bajaTicket(Ticket ticket) throws NoDuenoDeTicketException{
		if (ticket.getDueno().equals(this)) {
			ticket.setEstadoTicket(EstadoTicket.CANCELADO);
			this.bajarPuntaje(1);
		} else {
			throw new NoDuenoDeTicketException(ticket,"ticket "+ticket.getDueno()+" no es dueno de este ticket");
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
