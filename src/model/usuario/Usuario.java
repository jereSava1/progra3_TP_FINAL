package model.usuario;

import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import types.*;

import exception.ContrasenaIncorrectaException;
import exception.EstadoInvalidoException;
import exception.NoDuenoDeTicketException;

public abstract class Usuario {
	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	protected int puntaje;

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	public boolean validaContrasena(String contrasena) throws ContrasenaIncorrectaException {
		boolean ingreso = false;
		if (contrasena.equals(this.contrasena))
			ingreso = true;
		else {
			throw new ContrasenaIncorrectaException("contrasena incorrecta");
		}
		return ingreso;
	}

	public void bajaTicket(Ticket ticket) throws NoDuenoDeTicketException, EstadoInvalidoException {
		if (ticket.getDueno().equals(this)) {
			if(ticket.getEstadoTicket().equals(EstadoTicket.FINALIZADO))
				throw new EstadoInvalidoException("no se puede modificar el estado de un ticket ya finalizado");
			else
			   ticket.setEstadoTicket(EstadoTicket.CANCELADO);
		} else {
			throw new NoDuenoDeTicketException(this.getNombre()+" no es dueno del ticket que desea dar de baja");// try
		}
	}

	/**
	 * Modifica el ticket de un usurio, permite cambiar el formulario contenido en el.
	 *
	 * pre: ticket != null ; formulario != null
	 * pos: se modifico el ticket reemplazando el formulario anterior, por uno nuevo
	 *
	 * @param ticket ticket al que se le desea aplicar la modificacion, con estadoTicket!=FINALIZADO y estadoTicket!=CANCELADO
	 * @param formularioBusqueda nuevo formulario, reemplaza al anterior
	 * @throws NoDuenoDeTicketException
	 */
	public void modificaTicket(Ticket ticket, FormularioBusqueda formularioBusqueda) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setFormularioDeBusqueda(formularioBusqueda);
		} else {
			throw new NoDuenoDeTicketException(this.getNombre()+" no es dueno de este ticket");
		}
	}

	/**
	 * Cambia el estado  del ticket de un usurio, permite cancelar, suspender o activar el ticket
	 *
	 * pre: ticket != null
	 * pos: se modifica el estado del ticket con exito
	 *
	 * @param ticket ticket al que se le desea aplicar la modificacion, con estadoTicket!=CANCELADO
	 * @param estado, nuevo estado que se le quiere asignar al ticket
	 * @throws NoDuenoDeTicketException EstadoInvalidoException
	 */
	
	public void cambiaEstadoTicket(Ticket ticket, EstadoTicket estado) throws NoDuenoDeTicketException,EstadoInvalidoException {
		if (ticket.getDueno().equals(this)) {
			if(ticket.getEstadoTicket().equals(EstadoTicket.FINALIZADO))
				throw new EstadoInvalidoException("no se puede modificar el estado de un ticket ya finalizado");
			else
			  ticket.setEstadoTicket(estado);
			
		} else {
			throw new NoDuenoDeTicketException(this.getNombre()+ " no es dueno de este ticket");
		}
	}

	public void aumentarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}

	/**
	 *
	 * Baja un determinado puntaje al puntaje final del usuario.
	 * El puntaje final no puede ser menor a 0
	 *
	 * pre: puntaje > 0
	 * pos: se actualiza el nuevo puntaje final, luego de la resta de puntaje
	 *
	 * @param puntaje se le resta al puntaje final
	 */
	public void bajarPuntaje(int puntaje) {
		if (this.puntaje - puntaje >= 0)
			this.puntaje -= puntaje;
		else
			this.puntaje = 0;
	}

	public void consultaTicket(Ticket ticket) {
		System.out.println(ticket.toString());
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return " nombreUsuario = " + nombreUsuario + ", puntaje = " + puntaje+"\n";
	}

	
}
