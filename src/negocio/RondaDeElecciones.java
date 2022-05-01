package negocio;


import exception.LimiteExcedidoException;
import model.ticket.Ticket;
import model.usuario.Empleado;
import model.usuario.Empleador;
import model.usuario.ListaDeAsignaciones;
import model.usuario.Usuario;

import java.util.List;


public class RondaDeElecciones {
  /**
   * PRECONTRATO
   * @param ticket
   * @param usuario No null, el usuario existe en el ranking
   */
  public void seleccionaCandidato(Ticket ticket, Usuario usuario) {
      ListaDeAsignaciones seleccionado = ticket.getListaDeAsignaciones()
              .stream()
              .filter(r -> r.getUsuario().equals(usuario))
              .findFirst()
              .orElse(null); //Busco el usuario a seleccionar

      if (seleccionado != null) {
        seleccionado.setSeleccionado(true);
      }

  }

  /**
   * Selecciona multiples usuarios
   * @param ticket ticket de búsqueda
   * @param usuariosElegidos lista de usuarios a seleccionar, no null
   */

  public void seleccionaMultiplesCandidatos(Ticket ticket, List<Usuario> usuariosElegidos) {
    for (Usuario usuario : usuariosElegidos){
      this.seleccionaCandidato(ticket, usuario);
    }
  }
}
