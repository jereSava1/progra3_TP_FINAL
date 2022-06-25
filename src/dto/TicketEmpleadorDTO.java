package dto;

import model.ticket.TicketBusquedaDeEmpleado;

public class TicketEmpleadorDTO extends TicketDTO {
  private int empleadosNecesitados;
  private int empleadosObtenidos;

  public TicketEmpleadorDTO(TicketBusquedaDeEmpleado ticket) {
    super(ticket);
    this.empleadosNecesitados = ticket.getEmpleadosNecesitados();
    this.empleadosObtenidos = ticket.getEmpleadosObtenidos();
  }
}
