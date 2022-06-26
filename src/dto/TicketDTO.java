package dto;

import model.ticket.DatosDeEmpleo;
import model.ticket.Ticket;
import model.ticket.pretensionSalarial.PretensionSalarial;
import model.usuario.UsuarioPuntuado;
import types.Resultado;

import java.time.LocalDate;
import java.util.List;

public class TicketDTO {
  public static TicketDTO of (Ticket ticket) {
    if (ticket == null) {
      return null;
    }
    return new TicketDTO(ticket);
  }
  public LocalDate getFechaDeAlta() {
    return fechaDeAlta;
  }

  public void setFechaDeAlta(LocalDate fechaDeAlta) {
    this.fechaDeAlta = fechaDeAlta;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Resultado getResultado() {
    return resultado;
  }

  public void setResultado(Resultado resultado) {
    this.resultado = resultado;
  }

  public Float getComsionAPagar() {
    return comsionAPagar;
  }

  public void setComsionAPagar(Float comsionAPagar) {
    this.comsionAPagar = comsionAPagar;
  }

  public DatosDeEmpleo getPretensionSalarial() {
    return pretensionSalarial;
  }

  public void setPretensionSalarial(DatosDeEmpleo pretensionSalarial) {
    this.pretensionSalarial = pretensionSalarial;
  }

  public DatosDeEmpleo getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(DatosDeEmpleo experiencia) {
    this.experiencia = experiencia;
  }

  public DatosDeEmpleo getTipoDePuesto() {
    return tipoDePuesto;
  }

  public void setTipoDePuesto(DatosDeEmpleo tipoDePuesto) {
    this.tipoDePuesto = tipoDePuesto;
  }

  public DatosDeEmpleo getRangoEtario() {
    return rangoEtario;
  }

  public void setRangoEtario(DatosDeEmpleo rangoEtario) {
    this.rangoEtario = rangoEtario;
  }

  public DatosDeEmpleo getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(DatosDeEmpleo cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public DatosDeEmpleo getEstudios() {
    return estudios;
  }

  public void setEstudios(DatosDeEmpleo estudios) {
    this.estudios = estudios;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  
  

  public List<UsuarioPuntuado> getListaAsignaciones() {
	return listaAsignaciones;
}

public void setListaAsignaciones(List<UsuarioPuntuado> listaAsignaciones) {
	this.listaAsignaciones = listaAsignaciones;
}



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
  private List<UsuarioPuntuado> listaAsignaciones;

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
    this.listaAsignaciones = ticket.getListaDeAsignaciones();
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
