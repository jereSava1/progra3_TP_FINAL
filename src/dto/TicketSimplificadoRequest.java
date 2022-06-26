package dto;

import model.ticket.Locacion.Locacion;
import types.Rubro;

public class TicketSimplificadoRequest {
	private Locacion locacion;
	private Rubro tipoDeEmpleo;

	public TicketSimplificadoRequest(String locacion, String tipoDeTrabajo) {
		this.locacion = locacion;
		this.tipoDeEmpleo = tipoDeTrabajo;
	}

	public Locacion getLocacion() {
		return locacion;
	}

	public void setLocacion(Locacion locacion) {
		this.locacion = locacion;
	}

	public Rubro getTipoDeEmpleo() {
		return tipoDeEmpleo;
	}

	public void setTipoDeEmpleo(Rubro tipoDeEmpleo) {
		this.tipoDeEmpleo = tipoDeEmpleo;
	}
}
