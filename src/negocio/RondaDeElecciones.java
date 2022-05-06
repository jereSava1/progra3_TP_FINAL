package negocio;

import model.ticket.Ticket;
import model.usuario.UsuarioPuntuado;
import model.usuario.Usuario;
import java.util.List;
import java.util.stream.Collectors;

/**
 * En esta ronda un empleado seleccionara un empleador y un empleador seleccionara multiples empleados.
 * Las elecciones quedaran almacenadas para ser usadas posteriormente en la ultima etapa,la ronda de contrataciones.
 */
public class RondaDeElecciones {
	/**
	 * Se seleccionara a un usuario en especifico de la lista de asignaciones del Ticket
	 *
	 * pre: ticket != null
	 *
	 * pos: Se selecciona el candidato con exito
	 *
	 * @param ticket Servira para ver si el Usuario se encuentra en la lista de asignaciones del ticket
	 * @param usuario Es el candidato a seleccionar
	 */
	public static void seleccionaCandidato(Ticket ticket, Usuario usuario) {
		UsuarioPuntuado seleccionado = ticket.getListaDeAsignaciones().stream()
				.filter(r -> r.getUsuario().equals(usuario)).findFirst().orElse(null); // Busco el usuario a seleccionar

		if (seleccionado != null) {
			seleccionado.setSeleccionado(true);
		}

	}

	/**
	 * Se seleccionaran multiples usuarios(identificados en una lista) de la lista de asignaciones del Ticket
	 *
	 * pre: ticket != null
	 * 		lista de usuarios elegidos != null
	 *
	 * pos: Se seleccionan los multiples candidatos
	 * 
	 * @param ticket Servira para ver si los Usuarios de la lista se encuentran en la lista de asignaciones del ticket
	 * @param usuariosElegidos lista de usuarios a seleccionar
	 */
	public static void seleccionaMultiplesCandidatos(Ticket ticket, List<Usuario> usuariosElegidos) {
		for (Usuario usuario : usuariosElegidos) {
			RondaDeElecciones.seleccionaCandidato(ticket, usuario);
		}
	}

	public static void muestraCandidatosSeleccionados(Ticket ticket) {
		List<UsuarioPuntuado> seleccionados = ticket.getListaDeAsignaciones().stream().filter(r -> r.isSeleccionado())
				.collect(Collectors.toList()); //guarda los usuarios seleccionados por el creador del ticket
		for (UsuarioPuntuado usuarioP : seleccionados) {
			System.out.println(usuarioP.toString());
		}
	}

}
