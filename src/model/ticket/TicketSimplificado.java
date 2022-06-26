package model.ticket;

import model.ticket.Locacion.Locacion;
import model.usuario.Empleado;
import model.usuario.Empleador;
import types.Rubro;

public class TicketSimplificado {
	private final Empleador dueno;
	private Empleado asignacion;
	private final DatosDeEmpleo tipoDeEmpleo;
	private final DatosDeEmpleo locacion;
	private boolean esPermanente;

	public TicketSimplificado(Empleador dueno, DatosDeEmpleo tipoDeEmpleo, DatosDeEmpleo locacion) {
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

	public DatosDeEmpleo getTipoDeEmpleo() {
		return tipoDeEmpleo;
	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public boolean isEsPermanente() {
		return esPermanente;
	}

	public void setEsPermanente(boolean esPermanente) {
		this.esPermanente = esPermanente;
	}

}
