package negocio;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;
import exception.NoDuenoDeTicketException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;

import java.util.List;
import java.util.Optional;

public class TicketService {
  private Agencia agencia;
  private static TicketService ticketService = null;

  private TicketService() {
    this.agencia = Agencia.getAgencia();
  }

  public static TicketService getTicketService(
  ) {
    if (ticketService == null) {
      ticketService = new TicketService();
    }
    return ticketService;
  }

  public void modificarTicketDeEmpleado(TicketDeEmpleadoRequest request, String username) {
    List<TicketBusquedaDeEmpleo> busquedas = Agencia.getAgencia().getBusquedas();

    Optional<TicketBusquedaDeEmpleo> result = busquedas.stream().filter(ticket -> ticket.getDueno().getNombreUsuario().equals(username)).findFirst();

    if (result.isPresent()) {
      TicketBusquedaDeEmpleo ticket = result.get();
      Empleado empleado = (Empleado) ticket.getDueno();

      FormularioBusqueda formulario = new FormularioBusqueda(request.getrEtario(), request.getLocacion(),
              request.getExperiencia(), request.getHorario(),
              request.getPuesto(), request.getEstudios(),
              request.getRemuneracion());
      try {
        empleado.modificaTicket(ticket, formulario);
      } catch (NoDuenoDeTicketException e1) {
        //No se ejecuta nunca
      }

    }
  }
}
