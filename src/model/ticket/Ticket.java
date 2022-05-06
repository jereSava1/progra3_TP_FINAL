package model.ticket;

import java.time.LocalDate;
import java.util.List;
import model.usuario.UsuarioPuntuado;
import model.usuario.Usuario;
import types.EstadoTicket;


/**
 * Cada ticket estara asignado para un Usuario que podra ser Empleado o Empleador
 */
public class Ticket {
	  private Usuario dueno;
	  private FormularioBusqueda formularioDeBusqueda;
	  private LocalDate fechaDeAlta; //LocalDate -> Represents a date (year, month, day

	  /**
	   * - Activo
	   *     - Al momento del alta
	   * - Suspendido
	   *     - Se puede volver a reactivar
	   * - Cancelado
	   *     - El empleador lo cancela
	   * - Finalizado
	   *     - Alcanzo la cantidad de empleados solicitados
	   */
	  private EstadoTicket estadoTicket;
	/**
	 * Lista compuesta por Usuarios puntuados segun el nivel de coincidencias entre el Empleado y Empleador
	 *
	 * Usuario = Empleado
	 *   - Cada componente de la lista sera un Empleador rankeado, puntuado segun las coincidencias que se encuentren
	 *   entre los datos del Empleado y del Empleador
	 *
	 * Usuario = Empleador
	 *   - Cada componente de la lista sera un Empleado rankeado, puntuado segun las coincidencias que se encuentren
	 * 	 entre los datos del Empleado y del Empleador
	 */
	private List<UsuarioPuntuado> listaDeAsignaciones;


    public Ticket(FormularioBusqueda formularioDeBusqueda, Usuario usuario) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.fechaDeAlta = LocalDate.now();
        this.estadoTicket = EstadoTicket.ACTIVO;
        this.dueno = usuario;
        
    }

    
@Override
	public String toString() {
		return "Ticket [dueno= " + dueno.getNombre() + ", formularioDeBusqueda= " + formularioDeBusqueda.toString() + ", fechaDeAlta="
				+ fechaDeAlta.toString() + ", estadoTicket= " + estadoTicket +"]";
	}


	//GETTERS Y SETTERS
	public void setFormularioDeBusqueda(FormularioBusqueda formularioDeBusqueda) {
		this.formularioDeBusqueda = formularioDeBusqueda;
	}


	public void setEstadoTicket(EstadoTicket estadoTicket) {
		this.estadoTicket = estadoTicket;
	}


	public void setListaDeAsignaciones(List<UsuarioPuntuado> listaDeAsignaciones) {
		this.listaDeAsignaciones = listaDeAsignaciones;
	}


	public Usuario getDueno() {
		return dueno;
	}


	public FormularioBusqueda getFormularioDeBusqueda() {
		return formularioDeBusqueda;
	}


	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}


	public EstadoTicket getEstadoTicket() {
		return estadoTicket;
	}


	public List<UsuarioPuntuado> getListaDeAsignaciones() {
		return listaDeAsignaciones;
	}
    
    
    



}
