package exception;

import model.ticket.Ticket;

/**
 * Excepcion debido a que algun Usuario intenta modificar un ticket del cual no es dueno
 */
public class NoDuenoDeTicketException extends Exception {
     public NoDuenoDeTicketException(String message) {
    	super(message);
    }

	

	

    
}
