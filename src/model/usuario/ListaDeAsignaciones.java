package model.usuario;

import java.util.Date;

import lombok.Getter;

import lombok.Setter;
import model.Usuario;

/**
 *
 */

@Getter
@Setter
public class ListaDeAsignaciones implements Comparable<ListaDeAsignaciones> {
  private Date fechaDeGeneracion;
  private Usuario usuario;
  private Float puntaje;
  private boolean seleccionado;
  private boolean contratado;


  public ListaDeAsignaciones(Usuario usuario, float puntaje){
    this.usuario = usuario;
    this.puntaje = puntaje;
    this.fechaDeGeneracion = new Date();
    this.seleccionado = false;
    this.contratado = false;
  }

  @Override
  public int compareTo(ListaDeAsignaciones item) {
    return this.getPuntaje().compareTo(item.getPuntaje());
  }
}
