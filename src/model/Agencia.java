package model;

import dto.RegistroRequestAdmin;
import dto.RegistroRequestEmpleador;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.ticket.TicketSimplificado;
import model.ticket.DatosDeEmpleo;
import model.usuario.Administrador;
import model.usuario.Empleado;
import model.usuario.Empleador;
import model.usuario.Usuario;
import model.usuario.UsuarioPuntuado;
import types.Rubro;
import types.TipoPersona;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import exception.ContrasenaIncorrectaException;
import exception.UsuarioIncorrectoException;

/**
 *
 */
public class Agencia extends Observable {

	/**
	 * coleccion que contiene a los empleados (sin repeticiones) que consumen la
	 * aplicacion
	 */
	private Set<Empleado> empleados;
	/**
	 * coleccion que contiene a los empleadores (sin repeticiones) que consumen la
	 * aplicacion
	 */
	private Set<Empleador> empleadores;

	private Set<Administrador> administradores;
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
	private final List<TicketSimplificado> bolsaDeTrabajo;

	public void setComisiones(Float comisiones) {
		this.comisiones = comisiones;
	}

	static private Agencia singleton = null;

	private Agencia(String usuario, String contrasena) {
		this.empleadores = new HashSet<>();
		this.empleados = new HashSet<>();
		this.busquedas = new ArrayList<>();
		this.solicitudes = new ArrayList<>();
		this.bolsaDeTrabajo = new ArrayList<>();
		this.administradores = new HashSet<>();
		this.comisiones = 0f;
	}

	public static Agencia getAgencia() {

		if (singleton == null) {
			singleton = new Agencia("admin", "admin");
		}
		return singleton;
	}

	/**
	 * Agrega un nuevo empleado a la coleccion de empleados
	 * 
	 * @param nuevoEmpleado
	 */
	public void registraEmpleado(Empleado nuevoEmpleado) {
		this.empleados.add(nuevoEmpleado);
	}

	/**
	 * Agrega un nuevo empleador a la coleccion de empleadores
	 * 
	 * @param nuevoEmpleador
	 */
	public void registraEmpleador(Empleador nuevoEmpleador) {
		this.empleadores.add(nuevoEmpleador);
	}

	public Usuario login(String nombreUsuario, String contrasena)
			throws UsuarioIncorrectoException, ContrasenaIncorrectaException {
		Optional<Empleador> candidatoEmpleador = empleadores.stream()
				.filter(e -> e.getNombreUsuario().equalsIgnoreCase(nombreUsuario)).findAny();
		if (candidatoEmpleador.isPresent()) {
			candidatoEmpleador.get().validaContrasena(contrasena);
			return candidatoEmpleador.get();
		}

		Optional<Empleado> candidatoEmpleado = empleados.stream()
				.filter(e -> e.getNombreUsuario().equalsIgnoreCase(nombreUsuario)).findAny();

		if (candidatoEmpleado.isPresent()) {
			candidatoEmpleado.get().validaContrasena(contrasena);
			return candidatoEmpleado.get();
		}

		Optional<Administrador> candidatoAdmin = administradores.stream()
				.filter(e -> e.getNombreUsuario().equalsIgnoreCase(nombreUsuario)).findAny();

		if (candidatoAdmin.isPresent()) {
			candidatoAdmin.get().validaContrasena(contrasena);
			return candidatoAdmin.get();
		}

		throw new UsuarioIncorrectoException("Usuario no encontrado", nombreUsuario);
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
	 * PRECOND: - El empleador debe haber conseguido un empleado
	 *
	 * Calcula las comisiones que obtendra del empleador segun el sueldo con el que
	 * el empleador remunerará al empleado El porcentaje de comision varia segun el
	 * tipo de persona que sea la empresa y segun el rubro que esta misma desarrolle
	 *
	 * Por cada punto que tenga el empleador se restara un 1% a la comision final
	 *
	 * Si el puntaje del empleador supera el porcentaje de comision, la comision
	 * final quedara en cero.
	 *
	 * @param ticket
	 * @return comision final para el empleador
	 */
	public float calculaComisionesEmpleador(TicketBusquedaDeEmpleado ticket) {// si el puntaje supera a la comision-->
																				// devuelvo 0
		float comision = 0;
		Empleador empleador = (Empleador) ticket.getDueno();
		float sueldo = ticket.getFormularioDeBusqueda().getPretensionSalarial().getRemuneracion();

		if (empleador.getTipoPersona().equals(TipoPersona.FISICA)) {
			if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
				if (0.8 > empleador.getPuntaje() / 100)
					comision = (float) (sueldo * (0.8 - empleador.getPuntaje() / 100));
			} else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
				if (0.7 > empleador.getPuntaje() / 100)
					comision = (float) (sueldo * (0.7 - empleador.getPuntaje() / 100));
			} else if (0.6 > empleador.getPuntaje() / 100)
				comision = (float) (sueldo * (0.6 - empleador.getPuntaje() / 100));
		} else {
			if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
				if (1 > empleador.getPuntaje() / 100)
					comision = sueldo * (1 - empleador.getPuntaje() / 100);
			} else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
				if (0.9 > empleador.getPuntaje() / 100)
					comision = (float) (sueldo * (0.9 - empleador.getPuntaje() / 100));
			} else if (0.8 > empleador.getPuntaje() / 100)
				comision = (float) (sueldo * (0.8 - empleador.getPuntaje() / 100));
		}
		return comision;
	}

	/**
	 * PRECOND: - El empleado debe haber conseguido trabajo
	 *
	 * Calcula las comisiones que obtendra del empleado segun el sueldo pretendido
	 * El porcentaje de comision varia segun el tipo de puesto
	 *
	 * Por cada punto que tenga el empleado se restara un 1% a la comision final
	 *
	 * Si el puntaje del empleado supera el porcentaje de comision, la comision
	 * final quedara en cero.
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
			if (0.8 > empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (0.8 - empleado.getPuntaje() / 100));
		} else if (tipoDePuesto.equalsIgnoreCase("SR")) {
			if (0.9 > empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (0.9 - empleado.getPuntaje() / 100));
		} else if (tipoDePuesto.equalsIgnoreCase("MANAGMENT")) {
			if (1.0 > empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (1.0 - empleado.getPuntaje() / 100));
		}
		return comision;
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

	public Float getComisiones() {
		return comisiones;
	}

	/**
	 * Por cada empleador se verifica si este fue por lo menos elegido alguna vez
	 * por algun empleado en la ronda de eleccion.
	 *
	 * En cada ticket de busqueda de empleo encontraremos una lista de empleadores
	 * puntuados segun nuestro nivel de coincidencias con ellos.
	 *
	 * Recorro cada empleador de la lista del empleado para ver si este fue
	 * seleccionado.
	 *
	 * Si verifico que el empleador jamas fue seleccionado en la ronda de eleccion,
	 * se le restara 20 puntos a su puntaje final.
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

	public List<TicketSimplificado> getBolsaDeTrabajo() {
		return bolsaDeTrabajo;
	}

	public void registrarAdmin(RegistroRequestAdmin req) {
		Administrador newAdmin = new Administrador(req.getNombreUsuario(), req.getContrasena(), req.getID(), req.getEmail());
		this.administradores.add(newAdmin);
	}

	public void registrarEmpleador(RegistroRequestEmpleador req) {
		Empleador newEmpleador = new Empleador(req.getNombreUsuario(), req.getContrasena());
		newEmpleador.setNombre(req.getNombre());
		newEmpleador.setRubro(Rubro.valueOf(req.getRubro()));
		newEmpleador.setTipoPersona(TipoPersona.valueOf(req.getTipoPersona()));
		this.empleadores.add(newEmpleador);
		System.out.println("Se registro el empleador: " + newEmpleador.getNombre());
	}

	public void registrarEmpleado(){

	}
}
