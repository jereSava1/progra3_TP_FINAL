package negocio;

import model.Agencia;
import model.ticket.FormularioBusqueda;
import java.util.Collections;
import java.util.List;

import exception.ListaVaciaException;

import java.util.ArrayList;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.UsuarioPuntuado;

/**
 * Se analizan los tickets y se determinan las coincidencias para elaborar las Listas de asignaciones
 * para cada Usuario.
 */
public class RondaDeEncuentro {

	/**
	 *  PRECOND:
	 *    busquedas != null
	 *    solicitud != null
	 *
	 *  Al ticket unico (solicitud) se le asignara una lista de asignacion(ranking) dependiendo de las coincidencias entre
	 *  los formularios de este ticket y la lista de tickets (busquedas).
	 *
	 *  Esta lista de asignacion tendra a los posibles candidatos del ticker "solicitud" ordenados en un ranking de mayor a menor.
	 *
	 * @param busquedas sera una lista de tickets
	 * @param solicitud sera un ticket unico (saldra del metodo con la lista de asignacion seteada)
	 */
	private static void ejecutarRondaDeEncuentrosParaTicket(List<? extends Ticket> busquedas, Ticket solicitud) {
		List<UsuarioPuntuado> ranking = new ArrayList<>();
		FormularioBusqueda solicitudForm = solicitud.getFormularioDeBusqueda();

		for (Ticket busqueda : busquedas) {
			FormularioBusqueda formulario = busqueda.getFormularioDeBusqueda();
			float puntaje = 0F;

			puntaje += formulario.getPretensionSalarial().calculaPuntaje(solicitudForm.getPretensionSalarial());
			puntaje += formulario.getEstudios().calculaPuntaje(solicitudForm.getEstudios());
			puntaje += formulario.getRangoEtario().calculaPuntaje(solicitudForm.getRangoEtario());
			puntaje += formulario.getTipoDePuesto().calculaPuntaje(solicitudForm.getTipoDePuesto());
			puntaje += formulario.getCargaHoraria().calculaPuntaje(solicitudForm.getCargaHoraria());
			puntaje += formulario.getLocacion().calculaPuntaje(solicitudForm.getLocacion());
			puntaje += formulario.getExperienciaPrevia().calculaPuntaje(solicitudForm.getExperienciaPrevia());

			ranking.add(new UsuarioPuntuado(busqueda.getDueno(), puntaje));
		}
		Collections.sort(ranking);

		solicitud.setListaDeAsignaciones(ranking);
	}

	/**
	 * Ejecucion de la ronda de encuentro:
	 * Ticket de empleado:
	 *   - A cada ticket de empleado se le asignara una lista de asignacion de empleadores  (Lista del empleado pretenso)
	 *   - A cada ticket de empleador se le asignara una lista de asignacion de empleados (Lista del empleador)
	 *
	 * pre: agencia != null
	 * 		coleccion de tickets de busqueda de empleo de la agencia, agencia.getBusquedas() != null
	 * 		coleccion de tickets de busqueda de empleadores de la agencia, agencia.getSolicitudes() != null
	 *
	 * pos: asigna con exito la lista de asignacion a cada ticket de empleado y empleador
	 *
	 * @param agencia
	 */
	public static void ejecutarRondaDeEncuentros(Agencia agencia) {
		for (Ticket busqueda : agencia.getBusquedas()) { // TICKETS DE EMPLEADOS
			RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getSolicitudes(), busqueda);
		}

		for (Ticket solicitud : agencia.getSolicitudes()) { // TICKETS DE EMPLEADORES
			RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getBusquedas(), solicitud);
		}
	}

	/**
	 * - Se actualizaran el puntajes para un empleado luego de finalizada la ronda de encuentro en caso que:
	 *     - Por cada lista de empleados pretensos dónde quede ultimo, resta 5 puntos
	 *     - Por cada lista de empleados pretensos, sumará 5 puntos
	 *
	 * pre: lista de tickets de busqueda de empleador, solicitudes != null
	 * 		Cada ticket de busqueda de empleador tiene su lista de asignaciones != null
	 *
	 * pos: actualiza con exito el puntaje de los empleados pretensos que cumplan las condiciones
	 *
	 * @param solicitudes
	 */
	public static void actualizarPuntajesParaEmpleado(List<TicketBusquedaDeEmpleado> solicitudes) {
		for (TicketBusquedaDeEmpleado solicitud : solicitudes) {
			List<UsuarioPuntuado> listaDeAsignaciones = solicitud.getListaDeAsignaciones();
			listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(5);
			listaDeAsignaciones.get(listaDeAsignaciones.size() - 1).getUsuario().bajarPuntaje(5);
		}
	}

	/**
	 * - Se actualizaran el puntajes para un empleador luego de finalizada la ronda de encuentro en caso que:
	 *   - Por ser primero en la lista de empleadores suma 10 por c/u
	 *
	 * pre: lista de tickets de busqueda de empleado, busquedas != null
	 * 		Cada ticket de busqueda de empleado tiene su lista de asignaciones != null
	 *
	 * pos: actualiza con exito el puntaje de los empleadores que cumplan las condiciones
	 *
	 * @param busquedas
	 */
	public static void actualizarPuntajesParaEmpleador(List<TicketBusquedaDeEmpleo> busquedas) {
		for (TicketBusquedaDeEmpleo busqueda : busquedas) {
			List<UsuarioPuntuado> listaDeAsignaciones = busqueda.getListaDeAsignaciones();
			listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(10);
		}
	}

	/**
	 * Muestra la lista de asignaciones generada, con los usuarios de mayor
	 * coincidencia de busqueda a menor coincidencia, para que el usuario que genero
	 * el ticket puede ver cuales son los candidatos a elegir( para ejecutar la ronda de elecciones)
	 *
	 * pre: ticket != null
	 *
	 * pos: Muestra por pantalla la lista de asignaciones de un determinado ticket
	 * 
	 * @param ticket recibe un ticket generico de la clase abstracta.
	 */
	public static void muestraListaDeAsignaciones(Ticket ticket) throws ListaVaciaException {
		List<UsuarioPuntuado> lista = ticket.getListaDeAsignaciones();
		if(lista.size()>0) {
		   for (UsuarioPuntuado usuarioP : lista) {
			   System.out.println(usuarioP.toString());
		   }
		}
		else
			throw new ListaVaciaException("lista de asignaciones vacia");
	}
}
