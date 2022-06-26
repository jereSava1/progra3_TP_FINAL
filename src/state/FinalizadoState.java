package state;

import model.ticket.Ticket;
import types.EstadoTicket;

public class FinalizadoState implements IState{

    private Ticket ticket;
    private EstadoTicket nombre;

    public FinalizadoState(Ticket ticket) {
        this.ticket = ticket;
        nombre = EstadoTicket.FINALIZADO;
    }


    @Override
    public void activar() {
        System.out.println("El ticket se encuentra finalizado");
    }

    @Override
    public void suspender() {
        System.out.println("El ticket se encuentra finalizado");
    }

    @Override
    public void cancelar() {
        System.out.println("El ticket se encuentra finalizado");
    }
    
    public void finalizar() {
        System.out.println("El ticket se encuentra finalizado");
    }

    @Override
    public EstadoTicket getNombre() {
        return nombre;
    }

}
