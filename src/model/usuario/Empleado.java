package model.usuario;

import exception.NoDuenoDeTicketException;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import types.*;

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

    /**
     * Se crea un nuevo ticket de busqueda para el empleado
     * @param formulario contiene las preferencias del empleado para la busqueda de empleo
     * @return TicketBusquedaDeEmpleo
     */
    public TicketBusquedaDeEmpleo altaTicket(FormularioBusqueda formulario){
        return new TicketBusquedaDeEmpleo(formulario, this);
    }


    /**
     * Da de baja el ticket, pone "Finalizado" su estado.
     * El dar de baja el ticket, resta 1 punto del puntaje final.
     * @param ticket
     * @throws NoDuenoDeTicketException lanza excepcion si alguien que no es el dueño del ticket intenta dar de baja el ticket
     */
    @Override
    public void bajaTicket(Ticket ticket) throws NoDuenoDeTicketException{
		if (ticket.getDueno().equals(this)) {
			ticket.setEstadoTicket(EstadoTicket.CANCELADO);
			this.bajarPuntaje(1);
		} else {
			throw new NoDuenoDeTicketException(ticket,"ticket "+ticket.getDueno()+" no es dueno de este ticket");
		}
	}
   //GETTERS Y SETTERS
    public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
    
    @Override
    public String toString(){
        return "Nombre: " + this.getNombre() + "\n" +
                "Telefono: " + this.getTelefono() + "\n" +
                "email: " + this.getEmail() + "\n" +
                "Edad: " + this.getEdad() + "\n";
    }

	
	

}
