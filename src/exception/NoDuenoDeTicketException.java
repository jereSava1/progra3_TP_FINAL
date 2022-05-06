package exception;

import model.ticket.Ticket;

/**
 * Excepcion debido a que algun Usuario intenta modificar un ticket del cual no es dueno
 */
public class NoDuenoDeTicketException extends Exception {
    private Ticket dato;
   
    public NoDuenoDeTicketException(Ticket ticket,String message) {
    	super(message);
    	this.dato=ticket;
    }

}
