package dto;

import model.ticket.DatosDeEmpleo;
import model.ticket.Ticket;
import model.ticket.pretensionSalarial.PretensionSalarial;
import types.Resultado;

import java.time.LocalDate;

public class TicketDTO {
  private LocalDate fechaDeAlta;
  private String id;
  private Resultado resultado;
  private Float comsionAPagar;
  private DatosDeEmpleo pretensionSalarial;
  private DatosDeEmpleo experiencia;
  private DatosDeEmpleo tipoDePuesto;
  private DatosDeEmpleo rangoEtario;
  private DatosDeEmpleo cargaHoraria;
  private DatosDeEmpleo estudios;
  private String estado;

  public TicketDTO (Ticket ticket) {
    this.fechaDeAlta = ticket.getFechaDeAlta();
    this.id = ticket.getId();
    this.resultado = ticket.getResultado();
    this.comsionAPagar = ticket.getComisionAPagar();
    this.pretensionSalarial = ticket.getFormularioDeBusqueda().getPretensionSalarial();
    this.experiencia = ticket.getFormularioDeBusqueda().getExperienciaPrevia();
    this.tipoDePuesto = ticket.getFormularioDeBusqueda().getTipoDePuesto();
    this.cargaHoraria = ticket.getFormularioDeBusqueda().getRangoEtario();
    this.tipoDePuesto = ticket.getFormularioDeBusqueda().getTipoDePuesto();
    this.estudios = ticket.getFormularioDeBusqueda().getEstudios();
  }

	@Override
	public String toString() {
		return "|  FechaDeAlta = " + fechaDeAlta +
			   "|  PretensionSalarial = " + pretensionSalarial.getValor() + 
			   "|  Experiencia = " + experiencia.getValor() + 
			   "|  TipoDePuesto = " + tipoDePuesto.getValor() + 
			   "|  CargaHoraria = " + cargaHoraria.getValor() + 
			   "|  Estudios = " + estudios.getValor();
	}
  
  
  
}
