package dto;

import model.usuario.UsuarioPuntuado;

import java.io.Serializable;
import java.util.List;

public class OutputListaDeAsignacion implements Serializable {
  private List<UsuarioPuntuado> lista;
  private String ticketId;

  public OutputListaDeAsignacion(List<UsuarioPuntuado> lista, String ticketId) {
    this.lista = lista;
    this.ticketId = ticketId;
  }

  public OutputListaDeAsignacion(){}
  public List<UsuarioPuntuado> getLista() {
    return lista;
  }

  public void setLista(List<UsuarioPuntuado> lista) {
    this.lista = lista;
  }

  public String getTicketId() {
    return ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }
}
