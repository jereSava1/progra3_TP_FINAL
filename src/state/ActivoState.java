package state;

import model.ticket.Ticket;
import types.EstadoTicket;

public class ActivoState implements IState{

    private Ticket ticket;
    private EstadoTicket nombre;

    public ActivoState(Ticket ticket) {
        this.ticket = ticket;
        nombre = EstadoTicket.ACTIVO;
    }

    @Override
    public void activar() {
        System.out.println("El ticket ya se encuentra activo");
    }

    @Override
    public void suspender() {
        ticket.setEstadoTicket(new SuspendidoState(ticket));
    }

    @Override
    public void cancelar() {
        ticket.setEstadoTicket(new CanceladoState(ticket));
    }

    @Override
    public EstadoTicket getNombre() {
        return nombre;
    }

}
