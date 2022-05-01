package model.usuario;

import lombok.Getter;
import lombok.Setter;

import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import types.*;

import java.util.Objects;

import exception.ContrasenaIncorrectaException;
import exception.NoDuenoDeTicketException;
import exception.UsuarioIncorrectoException;


public abstract class Usuario {
	@Getter private String nombre;
	@Getter @Setter private String nombreUsuario;
	@Setter private String contrasena;
	@Getter protected int puntaje;

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	public boolean logIn(String nombreUsuario, String contrasena)
			throws UsuarioIncorrectoException, ContrasenaIncorrectaException {
		boolean logeo = false;

		if (Objects.equals(nombreUsuario, this.nombreUsuario)) {
			if (Objects.equals(contrasena, this.contrasena)) {
				logeo = true;
			} else {
				throw new ContrasenaIncorrectaException(contrasena, "contrasena incorrecta");
			}
		} else {
			throw new UsuarioIncorrectoException(nombreUsuario, "nombre de usuario incorrecte");
		}
		return logeo;
	}

	public void bajaTicket(Ticket ticket) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setEstadoTicket(EstadoTicket.CANCELADO);
		} else {
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");// try
		  }
	}

	public void modificaTicket(Ticket ticket, FormularioBusqueda formularioBusqueda) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setFormularioBusqueda(formularioBusqueda);
		} else {
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");
		}
	}

	public void cambiaEstadoTicket(Ticket ticket, EstadoTicket estado) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setEstadoTicket(estado);
		} else {
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");
		}
	}

	public void aumentarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}

	public void bajarPuntaje(int puntaje) {
		if (this.puntaje - puntaje >= 0)
			this.puntaje -= puntaje;
		else
			this.puntaje = 0;
	}

	public void consultaTicket(Ticket ticket) {
		System.out.println(ticket.toString());
	}
}
