package model.usuario;

import model.ticket.FormularioBusqueda;
import model.Usuario;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import types.*;

public class Empleador extends Usuario {
    
    private TipoPersona tipoPersona;
    private Rubro rubro;
    
    public Empleador(String nombreUsuario,String contrasena){
        super(nombreUsuario,contrasena);
    }

    public TicketBusquedaDeEmpleado altaTicket(FormularioBusqueda formulario, int cantEmpleados) {
        return new TicketBusquedaDeEmpleado(formulario, cantEmpleados, this);
    }

    @Override
    public void bajaTicket(Ticket ticket) {
        // TODO Implement this method

    }

    public void modificaTicket(TicketBusquedaDeEmpleado ticket, int cantEmpleados) {
        if (ticket.getDueno().equals(this)) {
            ticket.setEmpleadosNecesitados(cantEmpleados);
        } else {
            //TODO tirar excepcion
        }
    }
}
