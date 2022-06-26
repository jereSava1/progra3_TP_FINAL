package state;

import model.ticket.Ticket;
import types.EstadoTicket;

public class SuspendidoState implements IState {

    private Ticket ticket;
    private EstadoTicket nombre;

    public SuspendidoState(Ticket ticket) {
        this.ticket = ticket;
        nombre = EstadoTicket.SUSPENDIDO;
    }

    @Override
    public void activar() {
        ticket.setEstadoTicket(new ActivoState(ticket));
    }

    @Override
    public void suspender() {
        System.out.println("El ticket se encuentra suspendido");
    }

    @Override
    public void cancelar() {
        ticket.setEstadoTicket(new CanceladoState(ticket));
    }
    
    public void finalizar() {
        System.out.println("El ticket se encuentra finalizado");
    }

    @Override
    public EstadoTicket getNombre() {
        return nombre;
    }
}
