package model.ticket.rangoEtario;

import interfaces.Puntajes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RangoEtario implements Puntajes {
  private final String valor;
  private int peso;
  public abstract float calculaPuntaje(RangoEtario rango);

  public RangoEtario(String dato, int peso){
    this.valor = dato;
    this.peso=peso;
  }
}
