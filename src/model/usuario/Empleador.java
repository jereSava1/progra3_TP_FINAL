package model.usuario;

import exception.NoDuenoDeTicketException;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import types.*;

public class Empleador extends Usuario {

	/**
	 * - TipoPersona
	 *   - Fisica
	 *   - Juridica
	 */
	private TipoPersona tipoPersona;
	/**
	 * - Tipo De Rubro
	 *    - Comercio Internacional
	 *    - Comercio Local
	 *    - Salud
	 */
	private Rubro rubro;

	public Empleador(String nombreUsuario, String contrasena) {
		super(nombreUsuario, contrasena);
	}

	/**
	 * Se crea un nuevo ticket de busqueda de empleador
	 * @param formulario contiene las preferencias del empleador para la busqueda de empleados
	 * @return TicketBusquedaDeEmpleo
	 */
	public TicketBusquedaDeEmpleado altaTicket(FormularioBusqueda formulario, int cantEmpleados) {
		return new TicketBusquedaDeEmpleado(formulario, cantEmpleados, this);
	}

	public void modificaTicket(TicketBusquedaDeEmpleado ticket, int cantEmpleados) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setEmpleadosNecesitados(cantEmpleados);
		} else {
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");
		}
	}
	
	
    //GETTERS Y SETTERS
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public Rubro getRubro() {
		return rubro;
	}
	
}
