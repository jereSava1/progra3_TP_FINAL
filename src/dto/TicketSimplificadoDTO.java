package dto;

import model.ticket.DatosDeEmpleo;
import model.ticket.TicketSimplificado;

public class TicketSimplificadoDTO {
  private DatosDeEmpleo locacion;
  private DatosDeEmpleo rubro;
  private String empleadoAsignado;

  public TicketSimplificadoDTO(){}

  public static TicketSimplificadoDTO of(TicketSimplificado ticketSimplificado) {
    TicketSimplificadoDTO dto = new TicketSimplificadoDTO();
    dto.setRubro(ticketSimplificado.getTipoDeEmpleo());
    dto.setLocacion(ticketSimplificado.getLocacion());
    dto.setEmpleadoAsignado(ticketSimplificado.getAsignacion() != null ? ticketSimplificado.getAsignacion().getNombreUsuario() : null);
    return dto;
  }

  public DatosDeEmpleo getLocacion() {
    return locacion;
  }

  public void setLocacion(DatosDeEmpleo locacion) {
    this.locacion = locacion;
  }

  public DatosDeEmpleo getRubro() {
    return rubro;
  }

  public void setRubro(DatosDeEmpleo rubro) {
    this.rubro = rubro;
  }

  public String getEmpleadoAsignado() {
    return empleadoAsignado;
  }

  public void setEmpleadoAsignado(String empleadoAsignado) {
    this.empleadoAsignado = empleadoAsignado;
  }
}
