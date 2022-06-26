package dto;

import factory.LocacionFactory;
import factory.TipoDePuestoFactory;
import model.ticket.DatosDeEmpleo;
import model.ticket.Locacion.Locacion;
import model.ticket.tipoDePuesto.TipoDePuesto;
import types.Rubro;

public class TicketSimplificadoRequest {
	private DatosDeEmpleo locacion;
	private DatosDeEmpleo tipoDeEmpleo;

	public TicketSimplificadoRequest(String locacion, String tipoDeTrabajo) {
		try {
			this.locacion = LocacionFactory.getLocacion(locacion, 1);
			this.tipoDeEmpleo = TipoDePuestoFactory.getTipoDePuesto(tipoDeTrabajo, 1);
		} catch (Exception e){}
	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public void setLocacion(DatosDeEmpleo locacion) {
		this.locacion = locacion;
	}

	public DatosDeEmpleo getTipoDeEmpleo() {
		return tipoDeEmpleo;
	}

	public void setTipoDeEmpleo(DatosDeEmpleo tipoDeEmpleo) {
		this.tipoDeEmpleo = tipoDeEmpleo;
	}
}
