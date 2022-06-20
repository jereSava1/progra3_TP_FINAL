package dto;

import model.ticket.Locacion.Locacion;
import types.Rubro;

public class TicketSimplificadoRequest {
	private String nombreUsuario;
	private Locacion locacion;
	private Rubro tipoDeEmpleo;
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
