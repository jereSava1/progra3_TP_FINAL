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

public class RondaDeEncuentro {

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

	public static void ejecutarRondaDeEncuentros(Agencia agencia) {
		for (Ticket busqueda : agencia.getBusquedas()) { // TICKETS DE EMPLEADOS
			RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getSolicitudes(), busqueda);
		}

		for (Ticket solicitud : agencia.getSolicitudes()) { // TICKETS DE EMPLEADORES
			RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getBusquedas(), solicitud);
		}
	}

	public static void actualizarPuntajesParaEmpleado(List<TicketBusquedaDeEmpleado> solicitudes) {
		for (TicketBusquedaDeEmpleado solicitud : solicitudes) {
			List<UsuarioPuntuado> listaDeAsignaciones = solicitud.getListaDeAsignaciones();
			listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(5);
			listaDeAsignaciones.get(listaDeAsignaciones.size() - 1).getUsuario().bajarPuntaje(5);
		}
	}

	public static void actualizarPuntajesParaEmpleador(List<TicketBusquedaDeEmpleo> busquedas) {
		for (TicketBusquedaDeEmpleo busqueda : busquedas) {
			List<UsuarioPuntuado> listaDeAsignaciones = busqueda.getListaDeAsignaciones();
			listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(10);
		}
	}

	/**
	 * muestra la lista de asignaciones generada, con los usuarios de mayor
	 * coincidencia de busqueda a menor coincidencia, para que el usuario que genero
	 * el ticket puede ver cuales son los candidatos a elegir( para ejecutar la ronda de elecciones)
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
