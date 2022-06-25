package dto;

import model.ticket.Ticket;
import types.Resultado;

import java.time.LocalDate;

public class TicketDTO {
  private LocalDate fechaDeAlta;
  private String id;
  private Resultado resultado;
  private Float comsionAPagar;

  public TicketDTO (Ticket ticket) {
    this.fechaDeAlta = ticket.getFechaDeAlta();
    this.id = ticket.getId();
    this.resultado = ticket.getResultado();
    this.comsionAPagar = ticket.getComisionAPagar();
  }
}
