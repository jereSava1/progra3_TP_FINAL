package model;

import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.ticket.tipoDePuesto.TipoDePuesto;
import model.usuario.Empleado;
import model.usuario.Empleador;
import model.usuario.UsuarioPuntuado;
import types.Rubro;
import types.TipoPersona;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import exception.ContrasenaIncorrectaException;
import exception.UsuarioIncorrectoException;

public class Agencia {
	private Set<Empleado> empleados;
	private Set<Empleador> empleadores;
	private List<TicketBusquedaDeEmpleo> busquedas;
	private List<TicketBusquedaDeEmpleado> solicitudes;
	private Float remuneracionV1;
	private Float remuneracionV2;// las remuneraciones se determinan con los setters en el main
	private Float comisiones;// contiene todas las comisiones adquiridas por la empresa

	public void setComisiones(Float comisiones) {
		this.comisiones = comisiones;
	}

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

	public void registraEmpleado(Empleado nuevoEmpleado) {// Agrega un nuevo usuario de tipo empleado a la lista de
															// empleados
		this.empleados.add(nuevoEmpleado);
	}

	public void registraEmpleador(Empleador nuevoEmpleador) {// Agrega un nuevo usuario de tipo empleador a la lista de
																// empleadores
		this.empleadores.add(nuevoEmpleador);
	}

	public void loginEmpleado(String nombreUsuario, String contrasena) throws UsuarioIncorrectoException {
		for (Empleado empleado : this.empleados) {
			if (empleado.getNombreUsuario().equals(nombreUsuario)) {
				try {
					empleado.validaContrasena(contrasena);
				} catch (ContrasenaIncorrectaException e) {
					System.out.println("Contrasena incorrecta");
				}
			} else
				throw new UsuarioIncorrectoException(nombreUsuario, "nombre incorrecto");
		}
	}

	public void loginEmpleador(String nombreUsuario, String contrasena) throws UsuarioIncorrectoException {
		for (Empleador empleador : this.empleadores) {
			if (empleador.getNombreUsuario().equals(nombreUsuario)) {
				try {
					empleador.validaContrasena(contrasena);
				} catch (ContrasenaIncorrectaException e) {
					System.out.println("Contrasena incorrecta");
				}
			} else
				throw new UsuarioIncorrectoException(nombreUsuario, "nombre incorrecto");
		}
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

	// precond: el empleador debe haber conseguido un empleado

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

	// precond: el empleado debe haber conseguido trabajo
	public float calculaComisionesEmpleado(TicketBusquedaDeEmpleo ticket) {
		float comision = 0;
		float sueldo = ticket.getFormularioDeBusqueda().getPretensionSalarial().getRemuneracion();
		Empleado empleado = (Empleado) ticket.getDueno();
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
}
