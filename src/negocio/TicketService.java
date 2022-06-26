package negocio;

import dto.TicketDTO;
import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;
import exception.NoDuenoDeTicketException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import model.usuario.Empleador;

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

    Optional<TicketBusquedaDeEmpleo> result = busquedas.stream().filter(ticket -> ticket.getDueno().getNombreUsuario().equalsIgnoreCase(username)).findFirst();

    if (result.isPresent()) {
      TicketBusquedaDeEmpleo ticket = result.get();
      Empleado empleado = (Empleado) ticket.getDueno();

      FormularioBusqueda formulario = new FormularioBusqueda(request.getrEtario(), request.getLocacion(),
              request.getExperiencia(), request.getHorario(),
              request.getPuesto(), request.getEstudios(),
              request.getRemuneracion());
      try {
        empleado.modificaTicket(ticket, formulario);
        System.out.println("Ticket modificado: " + ticket.getId());
      } catch (NoDuenoDeTicketException e1) {
        //No se ejecuta nunca
      }
    }
  }

  public void bajaTicketEmpleador(TicketDTO ticketDTO) throws NoDuenoDeTicketException {
    List<TicketBusquedaDeEmpleado> solicitudes = Agencia.getAgencia().getSolicitudes();

    Optional<TicketBusquedaDeEmpleado> result = solicitudes.stream().filter(ticket -> ticket.getId().equals(ticketDTO.getId())).findFirst();

    if (result.isPresent()) {
      TicketBusquedaDeEmpleado ticket = result.get();
      Empleador empleador = (Empleador) ticket.getDueno();

      empleador.bajaTicket(ticket);
      agencia.getSolicitudes().remove(ticket);
      System.out.println("Ticket borrado: " + ticket.getId());
    }
  }
}
