package model;

import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import model.usuario.Empleador;
import model.usuario.UsuarioPuntuado;
import types.Rubro;
import types.TipoPersona;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exception.ContrasenaIncorrectaException;
import exception.UsuarioIncorrectoException;



public class Agencia {
	/**
	 *  coleccion que contiene a los empleados (sin repeticiones) que consumen la aplicacion
	 */
	private Set<Empleado> empleados;
	/**
	 *  coleccion que contiene a los empleadores (sin repeticiones) que consumen la aplicacion
	 */
	private Set<Empleador> empleadores;
	/**
	 * Lista con los tickets de busqueda de empleo
	 */
	private List<TicketBusquedaDeEmpleo> busquedas;
	/**
	 * Lista con los tickets de solicitud de empleado
	 */
	private List<TicketBusquedaDeEmpleado> solicitudes;
	/**
	 * Permite definir que categoria tendra la Pretension salarial junto con V2
	 */
	private Float remuneracionV1;
	/**
	 * Permite definir que categoria tendra la Pretension salarial junto con V1
	 */
	private Float remuneracionV2;
	/**
	 * Suma total de comisiones adquirida por la Agencia
	 */
	private Float comisiones;

	static private Agencia singleton = null;

	private Agencia() {
		this.empleadores = new HashSet<>();
		this.empleados = new HashSet<>();
		this.busquedas = new ArrayList<>();
		this.solicitudes = new ArrayList<>();
		this.comisiones = 0f;
	}

	public static Agencia getAgencia() {

		if (singleton == null) {
			singleton = new Agencia();
		}
		return singleton;
	}

	/**
	 * Agrega un nuevo empleado a la coleccion de empleados
	 *
	 * pre: nuevoEmpleado != null
	 * pos: un nuevo empleado es añadido a la lista de empleados de la agencia
	 *
	 * @param nuevoEmpleado
	 */
	public void registraEmpleado(Empleado nuevoEmpleado) {
		this.empleados.add(nuevoEmpleado);
	}

	/**
	 *Agrega un nuevo empleador a la coleccion de empleadores
	 *
	 * pre: nuevoEmpleado != null
	 * pos: un nuevo empleador es anadido a la lista de empleadores de la agencia
	 *
	 * @param nuevoEmpleador
	 */
	public void registraEmpleador(Empleador nuevoEmpleador) {
		this.empleadores.add(nuevoEmpleador);
	}


	/**
	 * Permite el ingreso del empleado a la plataforma con un Nombre de usuario y una contrasena.
	 * Realiza la validacion de los datos, aceptando o no el ingreso.
	 *
	 * pre: nombreUsuario!= null -, contrasena != null
	 * pos: el empleado podra ingresar luego de una validacion de nombre de usuario y contrasena
	 * a la plataforma unicamente si se encuentra registrado en el sistema
	 *
	 * @param nombreUsuario
	 * @param contrasena
	 * @throws UsuarioIncorrectoException el empleado no se encuentra en la lista de empleados
	 */
	public boolean loginEmpleado(String nombreUsuario, String contrasena) throws UsuarioIncorrectoException,ContrasenaIncorrectaException {
		for (Empleado empleado : this.empleados) {
			if (empleado.getNombreUsuario().equals(nombreUsuario)) {
				return empleado.validaContrasena(contrasena);
			} 
		}
		throw new UsuarioIncorrectoException(nombreUsuario, "nombre incorrecto");
	
	}

	/**
	 * Permite el ingreso del empleador a la plataforma con un Nombre de usuario y una contrasena.
	 * Realiza la validacion de los datos, aceptando o no el ingreso.
	 *
	 * pre: nombreUsuario!= null , contrasena != null 
	 * pos: el empleador podra ingresar luego de una validacion de nombre de usuario y contrasena
	 * a la plataforma unicamente si se encuentra registrado en el sistema
	 *
	 * @param nombreUsuario
	 * @param contrasena
	 * @throws UsuarioIncorrectoException el empleador no se encuentra en la lista de empleadores
	 */
	
	public boolean loginEmpleador(String nombreUsuario, String contrasena) throws UsuarioIncorrectoException,ContrasenaIncorrectaException {
		for (Empleador empleador : this.empleadores) {
			if (empleador.getNombreUsuario().equals(nombreUsuario)) {
				return empleador.validaContrasena(contrasena);
			} 
		}
		throw new UsuarioIncorrectoException(nombreUsuario, "nombre incorrecto");
	}

	public void mostrarEmpleados() {
		for (Empleado empleado : this.empleados) {
			System.out.println(empleado);
		}
	}

	public void mostrarEmpleador() {
		for (Empleador empleador : this.empleadores) {
			System.out.println(empleador.toString());
		}
	}

	public void mostrarTicketBusqueda() {
		for (TicketBusquedaDeEmpleo ticket : busquedas) {
			System.out.println(ticket.toString());
		}
	}

	public void mostrarTicketSolicitud() {
		for (TicketBusquedaDeEmpleado ticket : solicitudes) {
			System.out.println(ticket.toString());
		}
	}

	/**
	 * Calcula las comisiones que obtendra del empleador segun el sueldo con el que el empleador remunerara al empleado
	 * El porcentaje de comision varia segun el tipo de persona que sea la empresa y segun el rubro que esta misma desarrolle
	 *
	 * Por cada punto que tenga el empleador se restara un 1% a la comision final
	 *
	 * Si el puntaje del empleador supera el porcentaje de comision, la comision final quedara en cero.
	 *
	 * pre: el empleador debe haber conseguido un empleado
	 *      ticket != null
	 *      ticket debe tener un dueno,un rubro y un tipo de persona != null
	 *      puntaje del empleador >= 0
	 *      remuneracion dada por el empleado >= 0
	 *
	 * pos: calculara con exito la comision final para el empleador
	 *
	 * @param ticket
	 * @return comision final para el empleador
	 */
	public float calculaComisionesEmpleador(TicketBusquedaDeEmpleado ticket) {

		float comision = 0;
		Empleador empleador = (Empleador) ticket.getDueno();
		float sueldo = ticket.getFormularioDeBusqueda().getPretensionSalarial().getRemuneracion();

		if (empleador.getTipoPersona().equals(TipoPersona.FISICA)) {
			if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
				if (0.8 > (float) empleador.getPuntaje() / 100)
					comision = (float) (sueldo * (0.8 - empleador.getPuntaje() / 100));
			} else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
				if (0.7 > (float) empleador.getPuntaje() / 100)
					comision = (float) (sueldo * (0.7 - empleador.getPuntaje() / 100));
			} else if (0.6 > (float) empleador.getPuntaje() / 100)
				comision = (float) (sueldo * (0.6 - empleador.getPuntaje() / 100));
		} else {
			if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
				if (1 > (float) empleador.getPuntaje() / 100)
					comision = sueldo * (1 - empleador.getPuntaje() / 100);
			} else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
				if (0.9 > (float) empleador.getPuntaje() / 100)
					comision = (float) (sueldo * (0.9 - empleador.getPuntaje() / 100));
			} else if (0.8 > (float) empleador.getPuntaje() / 100)
				comision = (float) (sueldo * (0.8 - empleador.getPuntaje() / 100));
		}
		return comision;
	}

	/**
	 * Calcula las comisiones que obtendra del empleado segun el sueldo pretendido
	 * El porcentaje de comision varia segun el tipo de puesto
	 *
	 * Por cada punto que tenga el empleado se restara un 1% a la comision final
	 *
	 * Si el puntaje del empleado supera el porcentaje de comision, la comision final quedara en cero.
	 *
	 * pre: el empleado debe haber conseguido trabajo
	 *      ticket != null
	 *      ticket debe tener un dueño y un tipo de puesto != null
	 *      puntaje del empleado >= 0
	 *      pretension salarial del empleado >= 0
	 *
	 * @param ticket
	 * @return comision final para el empleado
	 */
	public float calculaComisionesEmpleado(TicketBusquedaDeEmpleo ticket) {
		float comision = 0;
		Empleado empleado = (Empleado) ticket.getDueno();
		float sueldo = ticket.getFormularioDeBusqueda().getPretensionSalarial().getRemuneracion();
		String tipoDePuesto = ticket.getFormularioDeBusqueda().getTipoDePuesto().getValor();

		if (tipoDePuesto.equalsIgnoreCase("JR")) {
			if (0.8 > (float) empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (0.8 - empleado.getPuntaje() / 100));
		} else if (tipoDePuesto.equalsIgnoreCase("SR")) {
			if (0.9 > (float) empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (0.9 - empleado.getPuntaje() / 100));
		} else if (tipoDePuesto.equalsIgnoreCase("MANAGMENT")) {
			if (1.0 > (float) empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (1.0 - empleado.getPuntaje() / 100));
		}
		return comision;
	}
	
	public void addSolicitudes(TicketBusquedaDeEmpleado t) {
		
		this.solicitudes.add(t);
	}
	
public void addBusquedas(TicketBusquedaDeEmpleo t) {
		
		this.busquedas.add(t);
	}


/**
 * Por cada empleador se verifica si este fue por lo menos elegido alguna vez por algun empleado en la ronda de eleccion.
 *
 * En cada ticket de busqueda de empleo encontraremos una lista de empleadores puntuados segun nuestro nivel de coincidencias con ellos.
 *
 * Recorro cada empleador de la lista del empleado para ver si este fue seleccionado.
 *
 * Si verifico que el empleador jamas fue seleccionado en la ronda de eleccion, se le restara 20 puntos a su puntaje final.
 *
 * pre: coleccion de empleadores != null
 * 	    lista de tickets de busqueda de empleo != null
 * 	    lista de asignaciones del empleado != null
 *
 * pos: si algun empleador no fue elegido en alguna oportunidad de la ronda de encuentro se le restara 20 puntos a su puntaje final
 *
 */
public void empleadorNoElegido() {
	for (Empleador empleador : this.empleadores) {
		boolean elegido = false;
		for (TicketBusquedaDeEmpleo ticket : this.busquedas) {
			List<UsuarioPuntuado> lista = ticket.getListaDeAsignaciones();
			for (UsuarioPuntuado usuarioP : lista) {
				if (usuarioP.isSeleccionado() && usuarioP.getUsuario().equals(empleador)) {
					elegido = true;
					break;
				}
			}
			if (elegido)
				break;
		}
		if (!elegido) {
			empleador.bajarPuntaje(20);
		}
	}
}

// GETTERS Y SETTERS
	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public Set<Empleador> getEmpleadores() {
		return empleadores;
	}

	public List<TicketBusquedaDeEmpleo> getBusquedas() {
		return busquedas;
	}

	public List<TicketBusquedaDeEmpleado> getSolicitudes() {
		return solicitudes;
	}

	public Float getRemuneracionV1() {
		return remuneracionV1;
	}

	public Float getRemuneracionV2() {
		return remuneracionV2;
	}

	public void setRemuneracionV1(Float remuneracionV1) {
		this.remuneracionV1 = remuneracionV1;
	}

	public void setRemuneracionV2(Float remuneracionV2) {
		this.remuneracionV2 = remuneracionV2;
	}

	public Float getComisiones() {
		return comisiones;
	}
	public void setComisiones(Float comisiones) {
		this.comisiones = comisiones;
	}

}
	