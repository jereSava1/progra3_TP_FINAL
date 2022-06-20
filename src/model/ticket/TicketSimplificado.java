package model.ticket;

import model.ticket.Locacion.Locacion;
import model.usuario.Empleado;
import model.usuario.Empleador;
import types.Rubro;

public class TicketSimplificado {
	private final Empleador dueno;
	private Empleado asignacion;
	private final Rubro tipoDeEmpleo;
	private final Locacion locacion;
	private boolean esPermanente;

	public TicketSimplificado(Empleador dueno, Rubro tipoDeEmpleo, Locacion locacion) {
		this.dueno = dueno;
		this.tipoDeEmpleo = tipoDeEmpleo;
		this.locacion = locacion;
		this.esPermanente = false;
	}

	public Empleado getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Empleado asignacion) {
		this.asignacion = asignacion;
	}

	public Empleador getDueno() {
		return dueno;
	}

	public Rubro getTipoDeEmpleo() {
		return tipoDeEmpleo;
	}

	public Locacion getLocacion() {
		return locacion;
	}

	public boolean isEsPermanente() {
		return esPermanente;
	}

	public void setEsPermanente(boolean esPermanente) {
		this.esPermanente = esPermanente;
	}

}
