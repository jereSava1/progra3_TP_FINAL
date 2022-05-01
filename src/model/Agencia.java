package model;

import lombok.Getter;
import lombok.Setter;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.ticket.tipoDePuesto.TipoDePuesto;
import model.usuario.Empleado;
import model.usuario.Empleador;
import types.Rubro;
import types.TipoPersona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Setter
public class Agencia {
	@Getter private List<Empleado> empleados;
	@Getter private List<Empleador> empleadores;
	@Getter private List<TicketBusquedaDeEmpleo> busquedas;
	@Getter private List<TicketBusquedaDeEmpleado> solicitudes;
	@Getter private Float remuneracionV1;
	@Getter private Float remuneracionV2;// las remuneraciones se determinan con los setters en el main
	private Float comisiones;//contiene todas las comisiones adquiridas por la empresa

	public void setComisiones(Float comisiones) {
		this.comisiones = comisiones;
	}

	static private Agencia singleton = null;

	private Agencia() {
		this.empleadores = new ArrayList<>();
		this.empleados = new ArrayList<>();
		this.busquedas = new ArrayList<>();
		this.solicitudes = new ArrayList<>();
		this.comisiones=0;
	}

	public static Agencia getAgencia() {

		if (singleton == null) {
			singleton = new Agencia();
		}
		return singleton;

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

	public float calculaComisionesEmpleador(TicketBusquedaDeEmpleado ticket) {// si el puntaje supera a la comision--> devuelvo 0
		float comision = 0;
		Empleador empleador = ticket.getDueno();
		float sueldo = ticket.getFormularioDeBusqueda().getPretensionSalarial();

		if (empleador.getTipoPersona().equals(TipoPersona.FISICA)) {
			if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
				if (0.8 > empleador.getPuntaje() / 100)
					comision = sueldo * (0.8 - empleador.getPuntaje() / 100);
			} else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
				if (0.7 > empleador.getPuntaje() / 100)
					comision = sueldo * (0.7 - empleador.getPuntaje() / 100);
			} else if (0.6 > empleador.getPuntaje() / 100)
				comision = sueldo * (0.6 - empleador.getPuntaje() / 100);
		} else {
			if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
				if (1 > empleador.getPuntaje() / 100)
					comision = sueldo * (1 - empleador.getPuntaje() / 100);
			} 
			else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
				if (0.9 > empleador.getPuntaje() / 100)
					comision = sueldo * (0.9 - empleador.getPuntaje() / 100);
			} else if (0.8 > empleador.getPuntaje / 100)
				comision = sueldo * (0.8 - empleador.getPuntaje() / 100);
		}
		return comision;
	}

	// precond: el empleado debe haber conseguido trabajo
	public float calculaComisionesEmpleado(TicketBusquedaDeEmpleo ticket) {
		float comision = 0;
		float sueldo = ticket.getFormularioDeBusqueda().getPretensionSalarial();
		Empleado empleado = ticket.getDueno();
		TipoDePuesto tipoDePuesto = ticket.getTipoDePuesto();
		if (tipoDePuesto.getValor().equals("JR")) {
			if (0.8 > empleado.getPuntaje() / 100)
				comision = sueldo * (0.8 - empleado.getPuntaje() / 100);
		} else if (tipoDePuesto.getValor().equals("SR")) {
			if (0.9 > empleado.getPuntaje() / 100)
				comision = sueldo * (0.9 - empleado.getPuntaje() / 100);
		} else if (tipoDePuesto.getValor().equals("MANAGMENT")) {
			if (1.0 > empleado.getPuntaje() / 100)
				comision = sueldo * (1.0 - empleado.getPuntaje() / 100);
		}
		return comision;
	}

}
