package model.ticket;

import java.time.LocalDate;
import java.util.List;
import model.usuario.UsuarioPuntuado;
import model.usuario.Usuario;
import state.ActivoState;
import state.IState;
import types.EstadoTicket;
import types.Resultado;

/**
 * Cada ticket estara asignado para un Usuario que podra ser Empleado o
 * Empleador
 */
public class Ticket {
	private Usuario dueno;
	private FormularioBusqueda formularioDeBusqueda;
	private LocalDate fechaDeAlta; // LocalDate -> Represents a date (year, month, day

	/**
	 * - Activo - Al momento del alta - Suspendido - Se puede volver a reactivar -
	 * Cancelado - El empleador lo cancela - Finalizado - Alcanzo la cantidad de
	 * empleados solicitados
	 */
	private IState estadoTicket;
	/**
	 * Lista compuesta por Usuarios puntuados segun el nivel de coincidencias entre
	 * el Empleado y Empleador
	 *
	 * Usuario = Empleado - Cada componente de la lista sera un Empleador rankeado,
	 * puntuado segun las coincidencias que se encuentren entre los datos del
	 * Empleado y del Empleador
	 *
	 * Usuario = Empleador - Cada componente de la lista sera un Empleado rankeado,
	 * puntuado segun las coincidencias que se encuentren entre los datos del
	 * Empleado y del Empleador
	 */
	private List<UsuarioPuntuado> listaDeAsignaciones;
	
	/**
	 * - Resultado - Exito : Al final de la ronda de contratacion el empleado
	 * consiguio empleo - Fracaso : Al final de la ronda de contratacion el empleado
	 * NO consiguio empleo - Indeterminado : La ronda de contratacion aun no
	 * finaliza, hay una posible contratacion.
	 */
	private Resultado resultado;

	public Ticket(FormularioBusqueda formularioDeBusqueda, Usuario usuario) {
		this.formularioDeBusqueda = formularioDeBusqueda;
		this.fechaDeAlta = LocalDate.now();
		this.estadoTicket = new ActivoState(this);
		this.dueno = usuario;
		this.resultado = Resultado.INCONCLUSO;

	}

	@Override
	public String toString() {
		return "Ticket [dueno= " + dueno.getNombre() + ", formularioDeBusqueda= " + formularioDeBusqueda.toString()
				+ ", fechaDeAlta=" + fechaDeAlta.toString() + ", estadoTicket= " + estadoTicket + "]";
	}

	// GETTERS Y SETTERS
	public void setFormularioDeBusqueda(FormularioBusqueda formularioDeBusqueda) {
		this.formularioDeBusqueda = formularioDeBusqueda;
	}

	public void setEstadoTicket(IState estadoTicket) {
		this.estadoTicket = estadoTicket;
	}

	public void setListaDeAsignaciones(List<UsuarioPuntuado> listaDeAsignaciones) {
		this.listaDeAsignaciones = listaDeAsignaciones;
	}

	public Usuario getDueno() {
		return dueno;
	}
	
	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public FormularioBusqueda getFormularioDeBusqueda() {
		return formularioDeBusqueda;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public IState getEstadoTicket() {
		return estadoTicket;
	}

	public List<UsuarioPuntuado> getListaDeAsignaciones() {
		return listaDeAsignaciones;
	}

}
